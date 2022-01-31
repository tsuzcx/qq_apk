package com.tencent.viola.ui.dom;

import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.dom.style.DrawLayoutStyle;
import com.tencent.viola.ui.dom.style.FlexLayout;
import com.tencent.viola.ui.dom.style.FlexNode;
import com.tencent.viola.ui.dom.style.FlexStyle;
import com.tencent.viola.utils.ViolaLogUtils;
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
  private boolean mIsLazy = false;
  private DrawLayoutStyle mLayoutStyle;
  public DomObject mParent;
  private Map<String, Object> mState = new ArrayMap();
  private Style mStyles;
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
    if (paramMap1 == null) {}
    while (paramMap1.size() <= 0) {
      return false;
    }
    return true;
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
      ViolaLogUtils.e("DomObject", "JSONException e:" + paramJSONObject.getMessage());
    }
    return null;
  }
  
  private void removeFromDom(DomObject paramDomObject)
  {
    if ((paramDomObject == null) || (this.mDomChildren == null)) {}
    int i;
    do
    {
      return;
      i = this.mDomChildren.indexOf(paramDomObject);
    } while (i == -1);
    ((DomObject)this.mDomChildren.remove(i)).mParent = null;
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
    if ((paramDomObject == null) || (paramInt < -1)) {
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
    for (;;)
    {
      paramDomObject.mParent = this;
      return;
      this.mDomChildren.add(i, paramDomObject);
      super.addChildAt(paramDomObject, i);
    }
  }
  
  public void applyDrawLayoutStyle()
  {
    if (this.mStyles != null) {
      this.mLayoutStyle = new DrawLayoutStyle(this.mStyles);
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
    DomObject localDomObject2 = null;
    if (this.sDestroy.get()) {
      localDomObject1 = null;
    }
    do
    {
      return localDomObject1;
      localDomObject1 = this;
    } while (isCloneThis());
    DomObject localDomObject1 = localDomObject2;
    try
    {
      localDomObject2 = DomObjectFactory.newInstance(this.mType);
      localDomObject1 = localDomObject2;
      copyFields(localDomObject2);
      localDomObject1 = localDomObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ViolaLogUtils.e("DomObject", "clone error: " + localException.getMessage());
      }
    }
    return localDomObject1;
  }
  
  protected final void copyFields(DomObject paramDomObject)
  {
    Object localObject2 = null;
    paramDomObject.flexStyle.copy(this.flexStyle);
    paramDomObject.mRef = this.mRef;
    paramDomObject.mType = this.mType;
    if (this.mStyles == null)
    {
      localObject1 = null;
      paramDomObject.mStyles = ((Style)localObject1);
      if (this.mAttributes != null) {
        break label80;
      }
    }
    label80:
    for (Object localObject1 = localObject2;; localObject1 = this.mAttributes.clone())
    {
      paramDomObject.mAttributes = ((Attr)localObject1);
      paramDomObject.flexLayout.copy(this.flexLayout);
      return;
      localObject1 = this.mStyles.clone();
      break;
    }
  }
  
  public void destroy()
  {
    this.sDestroy.set(true);
    if (this.mStyles != null) {
      this.mStyles.clear();
    }
    if (this.mAttributes != null) {
      this.mAttributes.clear();
    }
    if (this.mEvents != null) {
      this.mEvents.clear();
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
      if ((this.mDomChildren == null) || (this.mDomChildren.size() <= paramInt)) {
        return null;
      }
      DomObject localDomObject = (DomObject)this.mDomChildren.get(paramInt);
      return localDomObject;
    }
  }
  
  public int getChildPosition(DomObject paramDomObject)
  {
    if (this.mDomChildren == null) {
      return -1;
    }
    return this.mDomChildren.indexOf(paramDomObject);
  }
  
  public int getDomChildCount()
  {
    if (this.mDomChildren != null) {
      return this.mDomChildren.size();
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
    HashMap localHashMap = new HashMap(5);
    if ((this.mStyles != null) && (!this.mStyles.containsKey("flexDirection"))) {
      localHashMap.put("flexDirection", "column");
    }
    if ((this.mStyles != null) && (!this.mStyles.containsKey("backgroundColor"))) {
      localHashMap.put("backgroundColor", Integer.valueOf(0));
    }
    localHashMap.put("defaultWidth", Float.valueOf(paramFloat2));
    if ((this.mStyles != null) && (!this.mStyles.containsKey("height"))) {
      localHashMap.put("defaultHeight", Float.valueOf(paramFloat1));
    }
    updateStyle(localHashMap);
    ViolaLogUtils.d("DomObject", "initRoot: ref = " + paramString + ";defaultHeight:" + paramFloat1);
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
    return (this.mStyles != null) && (this.mStyles.isFixed());
  }
  
  public boolean isLazy()
  {
    return this.mIsLazy;
  }
  
  public boolean isYoung()
  {
    return this.mYoung;
  }
  
  public void layoutAfter() {}
  
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
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
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
          if ((localObject != null) && ((localObject instanceof JSONObject)))
          {
            if (this.mStyles == null) {
              break label222;
            }
            this.mStyles.putAll(new Style((JSONObject)localObject));
          }
        }
        for (;;)
        {
          if (paramJSONObject.has("attr"))
          {
            localObject = paramJSONObject.get("attr");
            if ((localObject != null) && ((localObject instanceof JSONObject))) {
              this.mAttributes = new Attr((JSONObject)localObject);
            }
          }
          if (!paramJSONObject.has("events")) {
            break;
          }
          paramJSONObject = paramJSONObject.get("events");
          if ((paramJSONObject == null) || (!(paramJSONObject instanceof JSONArray))) {
            break;
          }
          paramJSONObject = (JSONArray)paramJSONObject;
          int j = paramJSONObject.length();
          int i = 0;
          while (i < j)
          {
            localObject = paramJSONObject.get(i);
            this.mEvents.add(localObject.toString());
            i += 1;
          }
          label222:
          this.mStyles = new Style((JSONObject)localObject);
        }
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        Log.e("DomObject", paramJSONObject.getMessage());
      }
    }
  }
  
  public int remove(DomObject paramDomObject)
  {
    Object localObject = this.DOMOBJECT_LOCK;
    if (paramDomObject != null) {}
    try
    {
      if (this.mDomChildren == null) {
        return -1;
      }
      int i = this.mDomChildren.indexOf(paramDomObject);
      removeFromDom(paramDomObject);
      if (i != -1) {
        super.removeChildAt(i);
      }
      return i;
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
  
  public void setViewPortWidth(int paramInt)
  {
    this.mViewPortWidth = paramInt;
  }
  
  public String toString()
  {
    return this.mType + ", " + this.mDomChildren.size();
  }
  
  public int traverseTree(DomObject.Consumer... paramVarArgs)
  {
    int k = 0;
    int i = 0;
    System.nanoTime();
    if (paramVarArgs == null) {
      k = i;
    }
    int j;
    DomObject localDomObject;
    do
    {
      return k;
      j = paramVarArgs.length;
      i = 0;
      while (i < j)
      {
        paramVarArgs[i].accept(this);
        i += 1;
      }
      int m = getChildCount();
      j = 0;
      i = k;
      if (j >= m) {
        break;
      }
      localDomObject = getChild(j);
      k = i;
    } while (localDomObject == null);
    k = localDomObject.traverseTree(paramVarArgs);
    if (i > k) {}
    for (;;)
    {
      j += 1;
      break;
      i = k;
    }
    return i + 1;
  }
  
  public void updateAttr(Map<String, Object> paramMap)
  {
    if (!diffUpdates(paramMap, getAttributes())) {}
    do
    {
      return;
      if (this.mAttributes == null) {
        this.mAttributes = new Attr();
      }
      this.mAttributes.putAll(paramMap);
      if (hasNewLayout()) {
        markUpdateSeen();
      }
    } while (!shouldDirty(paramMap));
    super.dirty();
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
      Style localStyle;
      int j;
      String str;
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
        if (!paramMap.hasNext()) {
          continue;
        }
        str = (String)((Map.Entry)paramMap.next()).getKey();
        switch (str.hashCode())
        {
        case -1063257157: 
          setAlignItems(localStyle.getAlignItems());
          continue;
          if (!str.equals("alignItems")) {
            break label1405;
          }
        }
      }
      finally {}
      int i = 0;
      break label1407;
      if (str.equals("alignSelf"))
      {
        i = 1;
        break label1407;
        if (str.equals("flex"))
        {
          i = 2;
          break label1407;
          if (str.equals("flexDirection"))
          {
            i = 3;
            break label1407;
            if (str.equals("justifyContent"))
            {
              i = 4;
              break label1407;
              if (str.equals("flexWrap"))
              {
                i = 5;
                break label1407;
                if (str.equals("minWidth"))
                {
                  i = 6;
                  break label1407;
                  if (str.equals("minHeight"))
                  {
                    i = 7;
                    break label1407;
                    if (str.equals("maxWidth"))
                    {
                      i = 8;
                      break label1407;
                      if (str.equals("maxHeight"))
                      {
                        i = 9;
                        break label1407;
                        if (str.equals("defaultHeight"))
                        {
                          i = 10;
                          break label1407;
                          if (str.equals("height"))
                          {
                            i = 11;
                            break label1407;
                            if (str.equals("width"))
                            {
                              i = 12;
                              break label1407;
                              if (str.equals("defaultWidth"))
                              {
                                i = 13;
                                break label1407;
                                if (str.equals("position"))
                                {
                                  i = 14;
                                  break label1407;
                                  if (str.equals("left"))
                                  {
                                    i = 15;
                                    break label1407;
                                    if (str.equals("top"))
                                    {
                                      i = 16;
                                      break label1407;
                                      if (str.equals("right"))
                                      {
                                        i = 17;
                                        break label1407;
                                        if (str.equals("bottom"))
                                        {
                                          i = 18;
                                          break label1407;
                                          if (str.equals("margin"))
                                          {
                                            i = 19;
                                            break label1407;
                                            if (str.equals("marginLeft"))
                                            {
                                              i = 20;
                                              break label1407;
                                              if (str.equals("marginTop"))
                                              {
                                                i = 21;
                                                break label1407;
                                                if (str.equals("marginRight"))
                                                {
                                                  i = 22;
                                                  break label1407;
                                                  if (str.equals("marginBottom"))
                                                  {
                                                    i = 23;
                                                    break label1407;
                                                    if (str.equals("borderWidth"))
                                                    {
                                                      i = 24;
                                                      break label1407;
                                                      if (str.equals("borderTopWidth"))
                                                      {
                                                        i = 25;
                                                        break label1407;
                                                        if (str.equals("borderRightWidth"))
                                                        {
                                                          i = 26;
                                                          break label1407;
                                                          if (str.equals("borderBottomWidth"))
                                                          {
                                                            i = 27;
                                                            break label1407;
                                                            if (str.equals("borderLeftWidth"))
                                                            {
                                                              i = 28;
                                                              break label1407;
                                                              if (str.equals("padding"))
                                                              {
                                                                i = 29;
                                                                break label1407;
                                                                if (str.equals("paddingLeft"))
                                                                {
                                                                  i = 30;
                                                                  break label1407;
                                                                  if (str.equals("paddingTop"))
                                                                  {
                                                                    i = 31;
                                                                    break label1407;
                                                                    if (str.equals("paddingRight"))
                                                                    {
                                                                      i = 32;
                                                                      break label1407;
                                                                      if (str.equals("paddingBottom"))
                                                                      {
                                                                        i = 33;
                                                                        break label1407;
                                                                        setAlignSelf(localStyle.getAlignSelf());
                                                                        continue;
                                                                        setFlex(localStyle.getFlex());
                                                                        continue;
                                                                        setFlexDirection(localStyle.getFlexDirection());
                                                                        continue;
                                                                        setJustifyContent(localStyle.getJustifyContent());
                                                                        continue;
                                                                        setWrap(localStyle.getCSSWrap());
                                                                        continue;
                                                                        setMinWidth(localStyle.getMinWidth(j));
                                                                        continue;
                                                                        setMinHeight(localStyle.getMinHeight(j));
                                                                        continue;
                                                                        setMaxWidth(localStyle.getMaxWidth(j));
                                                                        continue;
                                                                        setMaxHeight(localStyle.getMaxHeight(j));
                                                                        continue;
                                                                        if (localStyle.containsKey("height")) {}
                                                                        for (float f = localStyle.getHeight(j);; f = localStyle.getDefaultHeight(j))
                                                                        {
                                                                          setStyleHeight(f);
                                                                          break;
                                                                        }
                                                                        if (localStyle.containsKey("width")) {}
                                                                        for (f = localStyle.getWidth(j);; f = localStyle.getDefaultWidth(j))
                                                                        {
                                                                          setStyleWidth(f);
                                                                          break;
                                                                        }
                                                                        setPositionType(localStyle.getPosition());
                                                                        continue;
                                                                        setPositionLeft(localStyle.getLeft(j));
                                                                        continue;
                                                                        setPositionTop(localStyle.getTop(j));
                                                                        continue;
                                                                        setPositionRight(localStyle.getRight(j));
                                                                        continue;
                                                                        setPositionBottom(localStyle.getBottom(j));
                                                                        continue;
                                                                        setMargin(8, localStyle.getMargin(j));
                                                                        continue;
                                                                        setMargin(0, localStyle.getMarginLeft(j));
                                                                        continue;
                                                                        setMargin(1, localStyle.getMarginTop(j));
                                                                        continue;
                                                                        setMargin(2, localStyle.getMarginRight(j));
                                                                        continue;
                                                                        setMargin(3, localStyle.getMarginBottom(j));
                                                                        continue;
                                                                        setBorder(8, localStyle.getBorderWidth(j));
                                                                        continue;
                                                                        setBorder(1, localStyle.getBorderTopWidth(j));
                                                                        continue;
                                                                        setBorder(2, localStyle.getBorderRightWidth(j));
                                                                        continue;
                                                                        setBorder(3, localStyle.getBorderBottomWidth(j));
                                                                        continue;
                                                                        setBorder(0, localStyle.getBorderLeftWidth(j));
                                                                        continue;
                                                                        setPadding(8, localStyle.getPadding(j));
                                                                        continue;
                                                                        setPadding(0, localStyle.getPaddingLeft(j));
                                                                        continue;
                                                                        setPadding(1, localStyle.getPaddingTop(j));
                                                                        continue;
                                                                        setPadding(2, localStyle.getPaddingRight(j));
                                                                        continue;
                                                                        setPadding(3, localStyle.getPaddingBottom(j));
                                                                        continue;
                                                                      }
                                                                    }
                                                                  }
                                                                }
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      label1405:
      i = -1;
      label1407:
      switch (i)
      {
      }
    }
  }
  
  public void young()
  {
    this.mYoung = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.dom.DomObject
 * JD-Core Version:    0.7.0.1
 */