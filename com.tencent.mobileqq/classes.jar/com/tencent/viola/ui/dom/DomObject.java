package com.tencent.viola.ui.dom;

import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.animation.AnimationBean.Style;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.ui.dom.style.FlexLayout;
import com.tencent.viola.ui.dom.style.FlexNode;
import com.tencent.viola.ui.dom.style.FlexStyle;
import com.tencent.viola.utils.GradientParseUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DomObject
  extends FlexNode
  implements Cloneable
{
  public static final String KEY_ATTR = "attr";
  public static final String KEY_CHILDREN = "children";
  public static final String KEY_EVENT = "events";
  public static final String KEY_REF = "ref";
  public static final String KEY_STYLE = "style";
  public static final String KEY_TYPE = "type";
  public static final String TAG = "DomObject";
  public static final Set<String> dirtyStyle = new HashSet();
  private final Object DOMOBJECT_LOCK = new Object();
  private boolean cloneThis = false;
  protected Attr mAttributes;
  public List<DomObject> mDomChildren = new CopyOnWriteArrayList();
  private ArrayList<String> mEvents = new ArrayList();
  private String mInstanceId;
  private boolean mIsLazy = false;
  protected float mLastLayoutHeight;
  protected float mLastLayoutWidth;
  public DomObject mParent;
  private Map<String, Object> mState = new ArrayMap();
  private Style mStyles = new Style();
  private String mType;
  private int mViewPortWidth = 750;
  public boolean mYoung = false;
  private AtomicBoolean sDestroy = new AtomicBoolean();
  
  static
  {
    dirtyStyle.add("defaultHeight");
    dirtyStyle.add("defaultWidth");
    dirtyStyle.add("width");
    dirtyStyle.add("minWidth");
    dirtyStyle.add("maxWidth");
    dirtyStyle.add("height");
    dirtyStyle.add("minHeight");
    dirtyStyle.add("maxHeight");
    dirtyStyle.add("alignItems");
    dirtyStyle.add("alignSelf");
    dirtyStyle.add("flex");
    dirtyStyle.add("flexDirection");
    dirtyStyle.add("justifyContent");
    dirtyStyle.add("flexWrap");
    dirtyStyle.add("margin");
    dirtyStyle.add("marginTop");
    dirtyStyle.add("marginLeft");
    dirtyStyle.add("marginRight");
    dirtyStyle.add("marginBottom");
    dirtyStyle.add("padding");
    dirtyStyle.add("paddingTop");
    dirtyStyle.add("paddingLeft");
    dirtyStyle.add("paddingRight");
    dirtyStyle.add("paddingBottom");
    dirtyStyle.add("left");
    dirtyStyle.add("top");
    dirtyStyle.add("right");
    dirtyStyle.add("bottom");
    dirtyStyle.add("borderWidth");
    dirtyStyle.add("borderTopWidth");
    dirtyStyle.add("borderRightWidth");
    dirtyStyle.add("borderBottomWidth");
    dirtyStyle.add("borderLeftWidth");
    dirtyStyle.add("position");
    dirtyStyle.add("textDecoration");
    dirtyStyle.add("textAlign");
    dirtyStyle.add("fontWeight");
    dirtyStyle.add("fontStyle");
    dirtyStyle.add("fontSize");
    dirtyStyle.add("color");
    dirtyStyle.add("lines");
    dirtyStyle.add("fontFamily");
    dirtyStyle.add("textOverflow");
    dirtyStyle.add("ellipsis");
    dirtyStyle.add("lineHeight");
    dirtyStyle.add("value");
    dirtyStyle.add("values");
  }
  
  private static boolean diffUpdates(Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    boolean bool = false;
    if (paramMap1 == null) {
      return false;
    }
    if (paramMap1.size() > 0) {
      bool = true;
    }
    return bool;
  }
  
  private void fireOnLayoutEvent()
  {
    if (this.mEvents.contains("layout"))
    {
      float f1 = FlexConvertUtils.px2dip(getOnLayoutWidth());
      float f2 = FlexConvertUtils.px2dip(getOnLayoutHeight());
      if ((this.mLastLayoutWidth == f1) && (this.mLastLayoutHeight == f2)) {
        return;
      }
      float f3 = FlexConvertUtils.px2dip(getLayoutX());
      float f4 = FlexConvertUtils.px2dip(getLayoutY());
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("width", f1);
        localJSONObject2.put("height", f2);
        localJSONObject2.put("x", f3);
        localJSONObject2.put("y", f4);
        localJSONObject1.put("layout", localJSONObject2);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      fireEvent("layout", localJSONObject1);
      this.mLastLayoutWidth = f1;
      this.mLastLayoutHeight = f2;
    }
  }
  
  @Nullable
  public static DomObject parse(JSONObject paramJSONObject, ViolaInstance paramViolaInstance, DomObject paramDomObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      if (!paramJSONObject.has("type")) {
        return null;
      }
      Object localObject = (String)paramJSONObject.get("type");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramJSONObject.put("type", "div");
      }
      localObject = DomObjectFactory.newInstance((String)localObject);
      if (localObject == null) {
        return null;
      }
      ((DomObject)localObject).setViewPortWidth(paramViolaInstance.getInstanceViewPortWidth());
      ((DomObject)localObject).setInstanceId(paramViolaInstance.getInstanceId());
      ((DomObject)localObject).parseFromJson(paramJSONObject);
      ((DomObject)localObject).mParent = paramDomObject;
      if (("list".equals(((DomObject)localObject).getType())) || ("scroller".equals(((DomObject)localObject).getType()))) {
        ((DomObject)localObject).setFlex(1.0F);
      }
      if (paramJSONObject.has("children"))
      {
        paramJSONObject = paramJSONObject.get("children");
        if ((paramJSONObject != null) && ((paramJSONObject instanceof JSONArray)))
        {
          paramJSONObject = (JSONArray)paramJSONObject;
          int j = paramJSONObject.length();
          int i = 0;
          while (i < j)
          {
            ((DomObject)localObject).add(parse(paramJSONObject.getJSONObject(i), paramViolaInstance, (DomObject)localObject), -1);
            i += 1;
          }
        }
      }
      return localObject;
    }
    catch (JSONException paramJSONObject)
    {
      paramViolaInstance = new StringBuilder();
      paramViolaInstance.append("JSONException e:");
      paramViolaInstance.append(paramJSONObject.getMessage());
      ViolaLogUtils.e("DomObject", paramViolaInstance.toString());
    }
    return null;
  }
  
  private void parseBackgroundImage(Object paramObject)
  {
    paramObject = GradientParseUtils.parseLinearGradient(paramObject, this);
    if (paramObject != null) {
      this.mStyles.put("background_image_parse", paramObject);
    }
  }
  
  private void parseFromTransform(Object paramObject)
  {
    paramObject = ViolaUtils.getString(paramObject, null);
    if (TextUtils.isEmpty(paramObject)) {
      return;
    }
    paramObject = AnimationBean.Style.parseTransForm(paramObject, (int)getLayoutWidth(), (int)getLayoutHeight(), 750);
    if (paramObject == null) {
      return;
    }
    AnimationBean.Style.resetToDefaultIfAbsent(paramObject);
    this.mStyles.put("fromTransformParse", paramObject);
  }
  
  private void parseTransform(Object paramObject)
  {
    paramObject = ViolaUtils.getString(paramObject, null);
    if (!TextUtils.isEmpty(paramObject))
    {
      paramObject = AnimationBean.Style.parseTransForm(paramObject, (int)getLayoutWidth(), (int)getLayoutHeight(), 750);
      if (paramObject != null)
      {
        AnimationBean.Style.resetToDefaultIfAbsent(paramObject);
        this.mStyles.put("transform_parse", paramObject);
      }
    }
  }
  
  private void parseTransformOrigin(Object paramObject)
  {
    paramObject = ViolaUtils.getString(paramObject, null);
    if (!TextUtils.isEmpty(paramObject))
    {
      paramObject = AnimationBean.Style.parsePivot(paramObject, (int)getLayoutWidth(), (int)getLayoutHeight(), 750);
      if (paramObject != null) {
        this.mStyles.put("transform_origin_parse", paramObject);
      }
    }
  }
  
  private void removeFromDom(DomObject paramDomObject)
  {
    if (paramDomObject != null)
    {
      List localList = this.mDomChildren;
      if (localList == null) {
        return;
      }
      int i = localList.indexOf(paramDomObject);
      if (i == -1) {
        return;
      }
      ((DomObject)this.mDomChildren.remove(i)).mParent = null;
    }
  }
  
  public static boolean shouldDirty(Map<String, Object> paramMap)
  {
    if (paramMap.size() == 0) {
      return false;
    }
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (dirtyStyle.contains(localEntry.getKey())) {
        return true;
      }
    }
    return false;
  }
  
  public void add(DomObject paramDomObject, int paramInt)
  {
    if (paramDomObject != null)
    {
      if (paramInt < -1) {
        return;
      }
      if (this.mDomChildren == null) {
        this.mDomChildren = new ArrayList();
      }
      int i = paramInt;
      if (paramInt >= this.mDomChildren.size()) {
        i = -1;
      }
      if (i == -1)
      {
        this.mDomChildren.add(paramDomObject);
        super.addChildAt(paramDomObject, super.getChildCount());
      }
      else
      {
        this.mDomChildren.add(i, paramDomObject);
        super.addChildAt(paramDomObject, i);
      }
      paramDomObject.mParent = this;
    }
  }
  
  public void applyStyleToNode()
  {
    updateStyleImpl(getStyle());
  }
  
  public int childrenCount()
  {
    return this.mDomChildren.size();
  }
  
  public DomObject clone()
  {
    boolean bool = this.sDestroy.get();
    Object localObject = null;
    if (bool) {
      return null;
    }
    if (isCloneThis()) {
      return this;
    }
    try
    {
      DomObject localDomObject = DomObjectFactory.newInstance(this.mType);
      localObject = localDomObject;
      copyFields(localDomObject);
      return localDomObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clone error: ");
      localStringBuilder.append(localException.getMessage());
      ViolaLogUtils.e("DomObject", localStringBuilder.toString());
    }
    return localObject;
  }
  
  protected final void copyFields(DomObject paramDomObject)
  {
    paramDomObject.flexStyle.copy(this.flexStyle);
    paramDomObject.mRef = this.mRef;
    paramDomObject.mType = this.mType;
    Object localObject1 = this.mStyles;
    Object localObject2 = null;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((Style)localObject1).clone();
    }
    paramDomObject.mStyles = ((Style)localObject1);
    localObject1 = this.mAttributes;
    if (localObject1 == null) {
      localObject1 = localObject2;
    } else {
      localObject1 = ((Attr)localObject1).clone();
    }
    paramDomObject.mAttributes = ((Attr)localObject1);
    paramDomObject.flexLayout.copy(this.flexLayout);
  }
  
  public void destroy()
  {
    this.sDestroy.set(true);
    ??? = this.mStyles;
    if (??? != null) {
      ((Style)???).clear();
    }
    ??? = this.mAttributes;
    if (??? != null) {
      ((Attr)???).clear();
    }
    ??? = this.mEvents;
    if (??? != null) {
      ((ArrayList)???).clear();
    }
    synchronized (this.DOMOBJECT_LOCK)
    {
      if (this.mDomChildren != null)
      {
        int j = this.mDomChildren.size();
        int i = 0;
        while (i < j)
        {
          ((DomObject)this.mDomChildren.get(i)).destroy();
          i += 1;
        }
        this.mDomChildren.clear();
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void fireEvent(String paramString, JSONObject paramJSONObject)
  {
    if (this.mInstanceId == null) {
      return;
    }
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(this.mRef);
    localJSONArray.put(paramString);
    paramString = paramJSONObject;
    if (paramJSONObject == null) {
      paramString = new JSONObject();
    }
    ViolaBridgeManager.getInstance().callbackJavascript(this.mInstanceId, "dom", "fireEvent", localJSONArray, paramString, true);
  }
  
  public Attr getAttributes()
  {
    if (this.mAttributes == null) {
      this.mAttributes = new Attr();
    }
    return this.mAttributes;
  }
  
  public DomObject getChild(int paramInt)
  {
    synchronized (this.DOMOBJECT_LOCK)
    {
      if ((this.mDomChildren != null) && (this.mDomChildren.size() > paramInt))
      {
        DomObject localDomObject = (DomObject)this.mDomChildren.get(paramInt);
        return localDomObject;
      }
      return null;
    }
  }
  
  public int getChildPosition(DomObject paramDomObject)
  {
    List localList = this.mDomChildren;
    if (localList == null) {
      return -1;
    }
    return localList.indexOf(paramDomObject);
  }
  
  public int getChildPositionFromList(DomObject paramDomObject)
  {
    if ((getType().equals("list")) && (("refresh".equals(getChild(0).getType())) || ("kdrefresh".equals(getChild(0).getType())))) {
      return getChildPosition(paramDomObject) - 1;
    }
    return getChildPosition(paramDomObject);
  }
  
  public int getDomChildCount()
  {
    List localList = this.mDomChildren;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public DomObject getDomParent()
  {
    return this.mParent;
  }
  
  public ArrayList<String> getEvents()
  {
    return this.mEvents;
  }
  
  public Object getExtra()
  {
    return null;
  }
  
  public String getInstanceId()
  {
    return this.mInstanceId;
  }
  
  protected float getOnLayoutHeight()
  {
    return getLayoutHeight();
  }
  
  protected float getOnLayoutWidth()
  {
    return getLayoutWidth();
  }
  
  public String getRef()
  {
    return this.mRef;
  }
  
  public Object getState(String paramString)
  {
    return this.mState.get(paramString);
  }
  
  public Style getStyle()
  {
    if (this.mStyles == null) {
      this.mStyles = new Style();
    }
    return this.mStyles;
  }
  
  public String getType()
  {
    return this.mType;
  }
  
  public int getViewPortWidth()
  {
    return this.mViewPortWidth;
  }
  
  public final boolean hasUpdate()
  {
    return (hasNewLayout()) || (isDirty());
  }
  
  public void initRoot(String paramString, float paramFloat1, float paramFloat2)
  {
    this.mRef = paramString;
    Object localObject = new HashMap(5);
    Style localStyle = this.mStyles;
    if ((localStyle != null) && (!localStyle.containsKey("flexDirection"))) {
      ((Map)localObject).put("flexDirection", "column");
    }
    localStyle = this.mStyles;
    if ((localStyle != null) && (!localStyle.containsKey("backgroundColor"))) {
      ((Map)localObject).put("backgroundColor", Integer.valueOf(0));
    }
    ((Map)localObject).put("defaultWidth", Float.valueOf(paramFloat2));
    localStyle = this.mStyles;
    if ((localStyle != null) && (!localStyle.containsKey("height"))) {
      ((Map)localObject).put("defaultHeight", Float.valueOf(paramFloat1));
    }
    updateStyle((Map)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initRoot: ref = ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(";defaultHeight:");
    ((StringBuilder)localObject).append(paramFloat1);
    ViolaLogUtils.d("DomObject", ((StringBuilder)localObject).toString());
  }
  
  public boolean isCloneThis()
  {
    return this.cloneThis;
  }
  
  public boolean isDestroy()
  {
    return this.sDestroy.get();
  }
  
  public boolean isFixed()
  {
    Style localStyle = this.mStyles;
    return (localStyle != null) && (localStyle.isFixed());
  }
  
  public boolean isLazy()
  {
    return this.mIsLazy;
  }
  
  public boolean isYoung()
  {
    return this.mYoung;
  }
  
  public void layoutAfter()
  {
    if (this.mStyles.containsKey("transform")) {
      parseTransform(this.mStyles.get("transform"));
    }
    if (this.mStyles.containsKey("transformOrigin")) {
      parseTransformOrigin(this.mStyles.get("transformOrigin"));
    }
    if (this.mStyles.containsKey("backgroundImage")) {
      parseBackgroundImage(this.mStyles.get("backgroundImage"));
    }
    if (this.mStyles.containsKey("fromTransform")) {
      parseFromTransform(this.mStyles.get("fromTransform"));
    }
    fireOnLayoutEvent();
  }
  
  public void layoutBefore() {}
  
  public void lazy(boolean paramBoolean)
  {
    this.mIsLazy = paramBoolean;
  }
  
  public final void markUpdateSeen()
  {
    if (hasNewLayout()) {
      markLayoutSeen();
    }
  }
  
  public void old()
  {
    this.mYoung = false;
  }
  
  public void parseFromJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      if (paramJSONObject.has("type")) {
        this.mType = String.valueOf(paramJSONObject.get("type"));
      }
      if (paramJSONObject.has("ref")) {
        this.mRef = String.valueOf(paramJSONObject.get("ref"));
      }
      Object localObject;
      if (paramJSONObject.has("style"))
      {
        localObject = paramJSONObject.get("style");
        if ((localObject != null) && ((localObject instanceof JSONObject))) {
          if (this.mStyles != null) {
            this.mStyles.putAll(new Style((JSONObject)localObject));
          } else {
            this.mStyles = new Style((JSONObject)localObject);
          }
        }
      }
      if (paramJSONObject.has("attr"))
      {
        localObject = paramJSONObject.get("attr");
        if ((localObject != null) && ((localObject instanceof JSONObject))) {
          this.mAttributes = new Attr((JSONObject)localObject);
        }
      }
      if (paramJSONObject.has("events"))
      {
        paramJSONObject = paramJSONObject.get("events");
        if ((paramJSONObject != null) && ((paramJSONObject instanceof JSONArray)))
        {
          paramJSONObject = (JSONArray)paramJSONObject;
          int j = paramJSONObject.length();
          int i = 0;
          while (i < j)
          {
            localObject = paramJSONObject.get(i);
            this.mEvents.add(localObject.toString());
            i += 1;
          }
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      Log.e("DomObject", paramJSONObject.getMessage());
    }
  }
  
  public int remove(DomObject paramDomObject)
  {
    Object localObject = this.DOMOBJECT_LOCK;
    if (paramDomObject != null) {}
    try
    {
      if (this.mDomChildren != null)
      {
        int i = this.mDomChildren.indexOf(paramDomObject);
        removeFromDom(paramDomObject);
        if (i != -1) {
          super.removeChildAt(i);
        }
        return i;
      }
      return -1;
    }
    finally {}
  }
  
  public void saveState(String paramString, Object paramObject)
  {
    this.mState.put(paramString, paramObject);
  }
  
  public void setCloneThis(boolean paramBoolean)
  {
    this.cloneThis = paramBoolean;
  }
  
  public void setInstanceId(String paramString)
  {
    this.mInstanceId = paramString;
  }
  
  public void setViewPortWidth(int paramInt)
  {
    this.mViewPortWidth = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mType);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.mDomChildren.size());
    return localStringBuilder.toString();
  }
  
  public int traverseTree(DomObject.Consumer... paramVarArgs)
  {
    System.nanoTime();
    int k = 0;
    if (paramVarArgs == null) {
      return 0;
    }
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramVarArgs[i].accept(this);
      i += 1;
    }
    int m = getChildCount();
    j = 0;
    i = k;
    while (i < m)
    {
      DomObject localDomObject = getChild(i);
      if (localDomObject == null) {
        return j;
      }
      k = localDomObject.traverseTree(paramVarArgs);
      if (j <= k) {
        j = k;
      }
      i += 1;
    }
    return j + 1;
  }
  
  public void updateAttr(Map<String, Object> paramMap)
  {
    if (!diffUpdates(paramMap, getAttributes())) {
      return;
    }
    if (this.mAttributes == null) {
      this.mAttributes = new Attr();
    }
    this.mAttributes.putAll(paramMap);
    if (hasNewLayout()) {
      markUpdateSeen();
    }
    if (shouldDirty(paramMap)) {
      super.dirty();
    }
  }
  
  public void updateStyle(Map<String, Object> paramMap)
  {
    if (this.mStyles == null) {
      this.mStyles = new Style();
    }
    this.mStyles.putAll(paramMap);
    if (shouldDirty(paramMap)) {
      super.dirty();
    }
    updateStyleImpl(paramMap);
  }
  
  public void updateStyleImpl(Map<String, Object> paramMap)
  {
    for (;;)
    {
      try
      {
        i = paramMap.size();
        if (i == 0) {
          return;
        }
        localStyle = getStyle();
        j = getViewPortWidth();
        if (localStyle.isEmpty()) {
          continue;
        }
        paramMap = paramMap.entrySet().iterator();
      }
      finally
      {
        int i;
        Style localStyle;
        int j;
        Map.Entry localEntry;
        String str;
        continue;
        throw paramMap;
        continue;
        switch (i)
        {
        }
        continue;
      }
      if (!paramMap.hasNext()) {
        continue;
      }
      localEntry = (Map.Entry)paramMap.next();
      str = (String)localEntry.getKey();
      i = -1;
      switch (str.hashCode())
      {
      case 1970934485: 
        if (!str.equals("marginLeft")) {
          continue;
        }
        i = 20;
        break;
      case 1860657097: 
        if (!str.equals("justifyContent")) {
          continue;
        }
        i = 4;
        break;
      case 1767100401: 
        if (!str.equals("alignSelf")) {
          continue;
        }
        i = 1;
        break;
      case 1744216035: 
        if (!str.equals("flexWrap")) {
          continue;
        }
        i = 5;
        break;
      case 1292595405: 
        if (!str.equals("backgroundImage")) {
          continue;
        }
        i = 36;
        break;
      case 1052666732: 
        if (!str.equals("transform")) {
          continue;
        }
        i = 34;
        break;
      case 975087886: 
        if (!str.equals("marginRight")) {
          continue;
        }
        i = 22;
        break;
      case 747804969: 
        if (!str.equals("position")) {
          continue;
        }
        i = 14;
        break;
      case 741115130: 
        if (!str.equals("borderWidth")) {
          continue;
        }
        i = 24;
        break;
      case 713848971: 
        if (!str.equals("paddingRight")) {
          continue;
        }
        i = 32;
        break;
      case 644734664: 
        if (!str.equals("defaultHeight")) {
          continue;
        }
        i = 10;
        break;
      case 400381634: 
        if (!str.equals("maxWidth")) {
          continue;
        }
        i = 8;
        break;
      case 202355100: 
        if (!str.equals("paddingBottom")) {
          continue;
        }
        i = 33;
        break;
      case 113126854: 
        if (!str.equals("width")) {
          continue;
        }
        i = 12;
        break;
      case 108511772: 
        if (!str.equals("right")) {
          continue;
        }
        i = 17;
        break;
      case 90130308: 
        if (!str.equals("paddingTop")) {
          continue;
        }
        i = 31;
        break;
      case 3317767: 
        if (!str.equals("left")) {
          continue;
        }
        i = 15;
        break;
      case 3145721: 
        if (!str.equals("flex")) {
          continue;
        }
        i = 2;
        break;
      case 115029: 
        if (!str.equals("top")) {
          continue;
        }
        i = 16;
        break;
      case -133587431: 
        if (!str.equals("minHeight")) {
          continue;
        }
        i = 7;
        break;
      case -223992013: 
        if (!str.equals("borderLeftWidth")) {
          continue;
        }
        i = 28;
        break;
      case -289173127: 
        if (!str.equals("marginBottom")) {
          continue;
        }
        i = 23;
        break;
      case -657971195: 
        if (!str.equals("defaultWidth")) {
          continue;
        }
        i = 13;
        break;
      case -781597262: 
        if (!str.equals("transformOrigin")) {
          continue;
        }
        i = 35;
        break;
      case -806339567: 
        if (!str.equals("padding")) {
          continue;
        }
        i = 29;
        break;
      case -906066005: 
        if (!str.equals("maxHeight")) {
          continue;
        }
        i = 9;
        break;
      case -975171706: 
        if (!str.equals("flexDirection")) {
          continue;
        }
        i = 3;
        break;
      case -1044792121: 
        if (!str.equals("marginTop")) {
          continue;
        }
        i = 21;
        break;
      case -1063257157: 
        if (!str.equals("alignItems")) {
          continue;
        }
        i = 0;
        break;
      case -1081309778: 
        if (!str.equals("margin")) {
          continue;
        }
        i = 19;
        break;
      case -1108380958: 
        if (!str.equals("fromTransform")) {
          continue;
        }
        i = 37;
        break;
      case -1221029593: 
        if (!str.equals("height")) {
          continue;
        }
        i = 11;
        break;
      case -1290574193: 
        if (!str.equals("borderBottomWidth")) {
          continue;
        }
        i = 27;
        break;
      case -1375815020: 
        if (!str.equals("minWidth")) {
          continue;
        }
        i = 6;
        break;
      case -1383228885: 
        if (!str.equals("bottom")) {
          continue;
        }
        i = 18;
        break;
      case -1452542531: 
        if (!str.equals("borderTopWidth")) {
          continue;
        }
        i = 25;
        break;
      case -1501175880: 
        if (!str.equals("paddingLeft")) {
          continue;
        }
        i = 30;
        break;
      case -1971292586: 
        if (!str.equals("borderRightWidth")) {
          continue;
        }
        i = 26;
        continue;
        parseFromTransform(localEntry.getValue());
        continue;
        parseBackgroundImage(localEntry.getValue());
        continue;
        parseTransformOrigin(localEntry.getValue());
        continue;
        parseTransform(localEntry.getValue());
        continue;
        setPadding(3, localStyle.getPaddingBottom(j));
        continue;
        setPadding(2, localStyle.getPaddingRight(j));
        continue;
        setPadding(1, localStyle.getPaddingTop(j));
        continue;
        setPadding(0, localStyle.getPaddingLeft(j));
        continue;
        setPadding(8, localStyle.getPadding(j));
        continue;
        setBorder(0, localStyle.getBorderLeftWidth(j));
        continue;
        setBorder(3, localStyle.getBorderBottomWidth(j));
        continue;
        setBorder(2, localStyle.getBorderRightWidth(j));
        continue;
        setBorder(1, localStyle.getBorderTopWidth(j));
        continue;
        setBorder(8, localStyle.getBorderWidth(j));
        continue;
        setMargin(3, localStyle.getMarginBottom(j));
        continue;
        setMargin(2, localStyle.getMarginRight(j));
        continue;
        setMargin(1, localStyle.getMarginTop(j));
        continue;
        setMargin(0, localStyle.getMarginLeft(j));
        continue;
        setMargin(8, localStyle.getMargin(j));
        continue;
        setPositionBottom(localStyle.getBottom(j));
        continue;
        setPositionRight(localStyle.getRight(j));
        continue;
        setPositionTop(localStyle.getTop(j));
        continue;
        setPositionLeft(localStyle.getLeft(j));
        continue;
        setPositionType(localStyle.getPosition());
        continue;
        float f;
        if (localStyle.containsKey("width")) {
          f = localStyle.getWidth(j);
        } else {
          f = localStyle.getDefaultWidth(j);
        }
        setStyleWidth(f);
        continue;
        if (localStyle.containsKey("height")) {
          f = localStyle.getHeight(j);
        } else {
          f = localStyle.getDefaultHeight(j);
        }
        setStyleHeight(f);
        continue;
        setMaxHeight(localStyle.getMaxHeight(j));
        continue;
        setMaxWidth(localStyle.getMaxWidth(j));
        continue;
        setMinHeight(localStyle.getMinHeight(j));
        continue;
        setMinWidth(localStyle.getMinWidth(j));
        continue;
        setWrap(localStyle.getCSSWrap());
        continue;
        setJustifyContent(localStyle.getJustifyContent());
        continue;
        setFlexDirection(localStyle.getFlexDirection());
        continue;
        setFlex(localStyle.getFlex());
        continue;
        setAlignSelf(localStyle.getAlignSelf());
        continue;
        setAlignItems(localStyle.getAlignItems());
      }
    }
  }
  
  public void young()
  {
    this.mYoung = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.dom.DomObject
 * JD-Core Version:    0.7.0.1
 */