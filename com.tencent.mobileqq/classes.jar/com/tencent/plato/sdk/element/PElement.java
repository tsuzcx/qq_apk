package com.tencent.plato.sdk.element;

import android.animation.ArgbEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.plato.JSONWritableArray;
import com.tencent.plato.JSONWritableMap;
import com.tencent.plato.core.IReadableArray;
import com.tencent.plato.core.IReadableMap;
import com.tencent.plato.core.IWritableArray;
import com.tencent.plato.core.IWritableMap;
import com.tencent.plato.core.utils.PLog;
import com.tencent.plato.layout.LayoutEngine;
import com.tencent.plato.layout.PDisplay;
import com.tencent.plato.layout.PEdge;
import com.tencent.plato.layout.PValue;
import com.tencent.plato.layout.PlatoNode;
import com.tencent.plato.sdk.animation.PAnimation;
import com.tencent.plato.sdk.animation.PAnimation.ITransition;
import com.tencent.plato.sdk.animation.PKeyFrame;
import com.tencent.plato.sdk.dom.IDom;
import com.tencent.plato.sdk.render.PRect;
import com.tencent.plato.sdk.render.data.ElementItem;
import com.tencent.plato.sdk.utils.ColorUtils;
import com.tencent.plato.sdk.utils.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class PElement
  extends LayoutElement
{
  public static final String TAG = "PElement";
  int backgroundColor = 0;
  int[] borderColor = { 0, 0, 0, 0 };
  int[] borderWidth = { 0, 0, 0, 0 };
  private IDom dom;
  Dimension height;
  String id;
  protected List<String> mEvents;
  protected List<PAnimation> mExecAnimations;
  protected List<String> mPauseAnimations;
  protected List<String> mResumeAnimations;
  protected List<String> mStopAnimations;
  private Map<String, Object> mTransform = new HashMap();
  int roundRadius;
  protected IWritableMap uiStyles = new JSONWritableMap();
  Dimension width;
  
  public PElement(LayoutEngine paramLayoutEngine, int paramInt)
  {
    super(paramLayoutEngine, paramInt);
    this.uiStyles.put("id", paramInt);
    this.uiStyles.put("borderWidth", this.borderWidth);
    this.uiStyles.put("borderColor", this.borderColor);
  }
  
  private void addTransitionProperty(PAnimation.ITransition paramITransition)
  {
    if (paramITransition == null) {
      return;
    }
    Object localObject2 = this.uiStyles.get("transitionProperty");
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if ((localObject2 instanceof IWritableArray)) {}
    }
    else
    {
      localObject1 = new JSONWritableArray();
      this.uiStyles.put("transitionProperty", localObject1);
    }
    ((IWritableArray)localObject1).add(paramITransition);
  }
  
  public void addAnimation(PAnimation paramPAnimation)
  {
    if (this.mExecAnimations == null) {
      this.mExecAnimations = new ArrayList();
    }
    if (paramPAnimation != null)
    {
      PLog.i("PElement", "id:" + getElementId() + ", addAnimation:" + paramPAnimation);
      this.mExecAnimations.add(paramPAnimation);
      setState(this.mState | 0x10);
    }
  }
  
  public void addEvent(String paramString)
  {
    if (this.mEvents == null) {
      this.mEvents = new LinkedList();
    }
    if ((!TextUtils.isEmpty(paramString)) && (!this.mEvents.contains(paramString)))
    {
      this.mEvents.add(paramString);
      setState(this.mState | 0x8);
    }
  }
  
  public void addEventArray(IReadableArray paramIReadableArray)
  {
    int i;
    if ((paramIReadableArray != null) && (paramIReadableArray.length() > 0)) {
      i = 0;
    }
    while (i < paramIReadableArray.length())
    {
      addEvent(paramIReadableArray.getString(i, ""));
      i += 1;
      continue;
      PLog.e("PElement", this + "addEvent error. event type null");
    }
  }
  
  void addUIStyle(String paramString, double paramDouble)
  {
    this.uiStyles.put(paramString, paramDouble);
    setState(this.mState | 0x4);
  }
  
  void addUIStyle(String paramString, int paramInt)
  {
    this.uiStyles.put(paramString, paramInt);
    setState(this.mState | 0x4);
  }
  
  void addUIStyle(String paramString, Object paramObject)
  {
    this.uiStyles.put(paramString, paramObject);
    setState(this.mState | 0x4);
  }
  
  void addUIStyle(String paramString1, String paramString2)
  {
    this.uiStyles.put(paramString1, paramString2);
    setState(this.mState | 0x4);
  }
  
  void addUIStyle(String paramString, boolean paramBoolean)
  {
    this.uiStyles.put(paramString, paramBoolean);
    setState(this.mState | 0x4);
  }
  
  @Property("alignSelf")
  public void alignSelf(String paramString)
  {
    setAlignSelf(paramString);
  }
  
  @Property("animation")
  public void animation(String paramString)
  {
    String[] arrayOfString;
    Object localObject;
    if (!TextUtils.isEmpty(paramString))
    {
      arrayOfString = paramString.split(" ");
      if ((arrayOfString != null) && (arrayOfString.length == 3))
      {
        localObject = (PKeyFrame)getDom().getKeyFrames().get(arrayOfString[0]);
        if (localObject != null) {
          break label81;
        }
        PLog.e("PElement", "non registered animation:" + paramString);
      }
    }
    for (;;)
    {
      return;
      label81:
      paramString = ((PKeyFrame)localObject).toPropertyValuesHolder();
      if ((paramString != null) && (paramString.length > 0))
      {
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          localObject = paramString[i];
          localObject = PAnimation.createAnimation(arrayOfString[0], (PropertyValuesHolder)localObject, PAnimation.parseTime(arrayOfString[1]).intValue(), arrayOfString[2]);
          attachAnimationEvent((PAnimation)localObject, "animationend");
          addAnimation((PAnimation)localObject);
          i += 1;
        }
      }
    }
  }
  
  protected void attachAnimationEvent(PAnimation paramPAnimation, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramPAnimation == null)) {}
    List localList;
    do
    {
      return;
      localList = getEvents();
    } while ((localList == null) || (!localList.contains(paramString)));
    paramPAnimation.setCallBack(paramString);
  }
  
  @Property("backgroundColor")
  public void backgroundColor(final String paramString)
  {
    this.backgroundColor = ColorUtils.parseColor(paramString);
    paramString = (Integer)this.uiStyles.get("backgroundColor");
    if ((paramString != null) && (paramString.intValue() != this.backgroundColor)) {
      addTransitionProperty(new PAnimation.ITransition()
      {
        public PAnimation createAnimation()
        {
          int i = PElement.this.getTransitionDuration(name());
          if (i > 0)
          {
            Object localObject = PElement.this.getTransitionTimingFunction(name());
            localObject = PAnimation.createAnimation("backgroundColor", PropertyValuesHolder.ofInt("backgroundColor", new int[] { paramString.intValue(), PElement.this.backgroundColor }), i, (String)localObject);
            ((ValueAnimator)((PAnimation)localObject).getAnimator()).setEvaluator(new ArgbEvaluator());
            PElement.this.attachAnimationEvent((PAnimation)localObject, "transitionend");
            return localObject;
          }
          return null;
        }
        
        public String name()
        {
          return "backgroundColor";
        }
      });
    }
    addUIStyle("backgroundColor", this.backgroundColor);
  }
  
  @Property("borderBottomColor")
  public void borderBottomColor(String paramString)
  {
    this.borderColor[2] = ColorUtils.parseColor(paramString);
    addUIStyle("borderColor", this.borderColor);
  }
  
  @Property("borderBottomWidth")
  public void borderBottomWidth(String paramString)
  {
    setBorder(PEdge.BOTTOM, paramString);
    this.borderWidth[2] = ((int)Dimension.parse(paramString).px);
    addUIStyle("borderWidth", this.borderWidth);
  }
  
  @Property("borderColor")
  public void borderColor(String paramString)
  {
    this.borderColor[0] = ColorUtils.parseColor(paramString);
    this.borderColor[1] = this.borderColor[0];
    this.borderColor[2] = this.borderColor[0];
    this.borderColor[3] = this.borderColor[0];
    addUIStyle("borderColor", this.borderColor);
  }
  
  @Property("borderLeftColor")
  public void borderLeftColor(String paramString)
  {
    this.borderColor[3] = ColorUtils.parseColor(paramString);
    addUIStyle("borderColor", this.borderColor);
  }
  
  @Property("borderLeftWidth")
  public void borderLeftWidth(String paramString)
  {
    setBorder(PEdge.LEFT, paramString);
    this.borderWidth[3] = ((int)Dimension.parse(paramString).px);
    addUIStyle("borderWidth", this.borderWidth);
  }
  
  @Property("borderRadius")
  public void borderRadius(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (this.roundRadius = 0;; this.roundRadius = ((int)Dimension.parse(paramString).px))
    {
      addUIStyle("roundRadius", this.roundRadius);
      return;
    }
  }
  
  @Property("borderRightColor")
  public void borderRightColor(String paramString)
  {
    this.borderColor[1] = ColorUtils.parseColor(paramString);
    addUIStyle("borderColor", this.borderColor);
  }
  
  @Property("borderRightWidth")
  public void borderRightWidth(String paramString)
  {
    setBorder(PEdge.RIGHT, paramString);
    this.borderWidth[1] = ((int)Dimension.parse(paramString).px);
    addUIStyle("borderWidth", this.borderWidth);
  }
  
  @Property("borderTopColor")
  public void borderTopColor(String paramString)
  {
    this.borderColor[0] = ColorUtils.parseColor(paramString);
    addUIStyle("borderColor", this.borderColor);
  }
  
  @Property("borderTopWidth")
  public void borderTopWidth(String paramString)
  {
    setBorder(PEdge.TOP, paramString);
    this.borderWidth[0] = ((int)Dimension.parse(paramString).px);
    addUIStyle("borderWidth", this.borderWidth);
  }
  
  @Property("borderWidth")
  public void borderWidth(String paramString)
  {
    setBorder(paramString);
    this.borderWidth[0] = ((int)Dimension.parse(paramString).px);
    this.borderWidth[1] = this.borderWidth[0];
    this.borderWidth[2] = this.borderWidth[0];
    this.borderWidth[3] = this.borderWidth[0];
    addUIStyle("borderWidth", this.borderWidth);
  }
  
  @Property("bottom")
  public void bottom(String paramString)
  {
    setPosition(PEdge.BOTTOM, paramString);
  }
  
  protected ElementItem copyFields(ElementItem paramElementItem)
  {
    Object localObject1;
    Object localObject2;
    if (this.mEvents != null)
    {
      paramElementItem.mEvents = new LinkedList();
      localObject1 = this.mEvents.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        paramElementItem.mEvents.add(localObject2);
      }
    }
    if ((this.mTransform != null) && (this.mTransform.size() > 0))
    {
      paramElementItem.mTransform = new HashMap();
      paramElementItem.mTransform.putAll(this.mTransform);
    }
    paramElementItem.elementType = getElementType();
    paramElementItem.mId = getElementId();
    paramElementItem.mIndex = this.mIndex;
    paramElementItem.isBlockType = isBlockType();
    paramElementItem.rc = new PRect(getElementId(), -1, (int)getLayoutX(), (int)getLayoutY(), (int)getLayoutWidth(), (int)getLayoutHeight());
    try
    {
      localObject1 = this.uiStyles.toJSONObject();
      if (localObject1 != null)
      {
        localObject2 = ((JSONObject)localObject1).keys();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          paramElementItem.uiStyles.put(str, ((JSONObject)localObject1).get(str));
        }
      }
      return paramElementItem;
    }
    catch (Exception localException)
    {
      PLog.e("PElement", Log.getStackTraceString(localException));
    }
  }
  
  @Property("display")
  public void display(String paramString)
  {
    setDisplay(paramString);
  }
  
  public JSONObject dumpNode(JSONObject paramJSONObject)
  {
    PLog.i("PElement-dump", "id:" + getElementId());
    if (paramJSONObject != null) {}
    label926:
    label946:
    for (;;)
    {
      try
      {
        if ((this instanceof PItemElement))
        {
          paramJSONObject.put("type", "item");
          paramJSONObject.put("id", getElementId());
          if (!paramJSONObject.has("attributes")) {
            break label926;
          }
          JSONObject localJSONObject1 = paramJSONObject.getJSONObject("attributes");
          if (!localJSONObject1.has("style")) {
            break label946;
          }
          localJSONObject1 = localJSONObject1.getJSONObject("style");
          if (this.mNode.getMargin(PEdge.TOP).value > 0.0F) {
            localJSONObject1.put("marginTop", Dimension.devicePx2RemPx(this.mNode.getMargin(PEdge.TOP).value) + "px");
          }
          if (this.mNode.getMargin(PEdge.LEFT).value > 0.0F) {
            localJSONObject1.put("marginLeft", Dimension.devicePx2RemPx(this.mNode.getMargin(PEdge.LEFT).value) + "px");
          }
          if (this.mNode.getMargin(PEdge.RIGHT).value > 0.0F) {
            localJSONObject1.put("marginRight", Dimension.devicePx2RemPx(this.mNode.getMargin(PEdge.RIGHT).value) + "px");
          }
          if (this.mNode.getMargin(PEdge.BOTTOM).value > 0.0F) {
            localJSONObject1.put("marginBottom", Dimension.devicePx2RemPx(this.mNode.getMargin(PEdge.BOTTOM).value) + "px");
          }
          if (this.mNode.getPadding(PEdge.TOP).value > 0.0F) {
            localJSONObject1.put("paddingTop", Dimension.devicePx2RemPx(this.mNode.getPadding(PEdge.TOP).value) + "px");
          }
          if (this.mNode.getPadding(PEdge.LEFT).value > 0.0F) {
            localJSONObject1.put("paddingLeft", Dimension.devicePx2RemPx(this.mNode.getPadding(PEdge.LEFT).value) + "px");
          }
          if (this.mNode.getPadding(PEdge.RIGHT).value > 0.0F) {
            localJSONObject1.put("paddingRight", Dimension.devicePx2RemPx(this.mNode.getPadding(PEdge.RIGHT).value) + "px");
          }
          if (this.mNode.getPadding(PEdge.BOTTOM).value > 0.0F) {
            localJSONObject1.put("paddingBottom", Dimension.devicePx2RemPx(this.mNode.getPadding(PEdge.BOTTOM).value) + "px");
          }
          if (!Float.isNaN(this.mNode.getWidth().value)) {
            localJSONObject1.put("width", Dimension.devicePx2RemPx(this.mNode.getWidth().value) + "px");
          }
          if (this.mNode.getHeight().value > 0.0F) {
            localJSONObject1.put("height", Dimension.devicePx2RemPx(this.mNode.getHeight().value) + "px");
          }
          localJSONObject1.put("posX", this.mNode.getLayoutX());
          localJSONObject1.put("posY", this.mNode.getLayoutY());
          localJSONObject1.put("layoutW", this.mNode.getLayoutWidth());
          localJSONObject1.put("layoutH", this.mNode.getLayoutHeight());
          return paramJSONObject;
          paramJSONObject = new JSONObject();
          continue;
        }
        if ((this instanceof PDivElement))
        {
          paramJSONObject.put("type", "view");
          continue;
        }
        if (!(this instanceof PTextElement)) {
          break label871;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return paramJSONObject;
      }
      paramJSONObject.put("type", "text");
      continue;
      label871:
      if ((this instanceof PImgElement))
      {
        paramJSONObject.put("type", "image");
      }
      else if ((this instanceof PListElement))
      {
        paramJSONObject.put("type", "list");
      }
      else
      {
        PLog.e("dumpNode", "unknown Element type");
        continue;
        Object localObject = new JSONObject();
        paramJSONObject.put("attributes", localObject);
        continue;
        JSONObject localJSONObject2 = new JSONObject();
        ((JSONObject)localObject).put("style", localJSONObject2);
        localObject = localJSONObject2;
      }
    }
  }
  
  @Property("event")
  public void event(String paramString)
  {
    PLog.d("PElement", "v");
  }
  
  @Property("flex")
  public void flex(String paramString)
  {
    setFlex(paramString);
  }
  
  @Property("flexBasis")
  public void flexBasis(String paramString)
  {
    setFlexBasis(paramString);
  }
  
  @Property("flexGrow")
  public void flexGrow(String paramString)
  {
    setFlexGrow(paramString);
  }
  
  @Property("flexShrink")
  public void flexShrink(String paramString)
  {
    setFlexShrink(paramString);
  }
  
  public void generateTransitionAnimations()
  {
    IReadableArray localIReadableArray = this.uiStyles.getReadableArray("transitionProperty");
    if ((localIReadableArray == null) || (localIReadableArray.length() == 0)) {
      return;
    }
    IReadableMap localIReadableMap = this.uiStyles.getReadableMap("transition");
    int i = 0;
    if (i < localIReadableArray.length())
    {
      PAnimation.ITransition localITransition = (PAnimation.ITransition)localIReadableArray.get(i);
      if (localITransition != null)
      {
        if ((localIReadableMap == null) || ((!localIReadableMap.has("all")) && (!localIReadableMap.has(localITransition.name())))) {
          break label118;
        }
        addAnimation(localITransition.createAnimation());
      }
      for (;;)
      {
        i += 1;
        break;
        label118:
        if ("transform".equals(localITransition.name())) {
          localITransition.createAnimation();
        }
      }
    }
    this.uiStyles.remove("transitionProperty");
  }
  
  public IDom getDom()
  {
    return this.dom;
  }
  
  public List<String> getEvents()
  {
    return this.mEvents;
  }
  
  public Map<Integer, Object> getOperateAnimations()
  {
    HashMap localHashMap = new HashMap();
    if ((this.mExecAnimations != null) && (this.mExecAnimations.size() > 0))
    {
      localHashMap.put(Integer.valueOf(1), new ArrayList(this.mExecAnimations));
      this.mExecAnimations.clear();
    }
    if ((this.mPauseAnimations != null) && (this.mPauseAnimations.size() > 0))
    {
      localHashMap.put(Integer.valueOf(2), new ArrayList(this.mPauseAnimations));
      this.mPauseAnimations.clear();
    }
    if ((this.mResumeAnimations != null) && (this.mResumeAnimations.size() > 0))
    {
      localHashMap.put(Integer.valueOf(3), new ArrayList(this.mResumeAnimations));
      this.mResumeAnimations.clear();
    }
    if ((this.mStopAnimations != null) && (this.mStopAnimations.size() > 0))
    {
      localHashMap.put(Integer.valueOf(4), new ArrayList(this.mStopAnimations));
      this.mStopAnimations.clear();
    }
    return localHashMap;
  }
  
  protected int getTransitionDuration(String paramString)
  {
    int j = 0;
    IReadableMap localIReadableMap = this.uiStyles.getReadableMap("transition");
    int i = j;
    if (localIReadableMap != null)
    {
      i = j;
      if (localIReadableMap.get("all") != null) {
        i = localIReadableMap.getInt("all", 0);
      }
    }
    j = i;
    if (!TextUtils.isEmpty(paramString))
    {
      j = i;
      if (localIReadableMap != null)
      {
        j = i;
        if (localIReadableMap.get(paramString) != null)
        {
          j = i;
          if ((localIReadableMap.get(paramString) instanceof Map))
          {
            paramString = (Map)localIReadableMap.get(paramString);
            j = i;
            if (paramString != null)
            {
              j = i;
              if (paramString.containsKey("duration"))
              {
                j = i;
                if ((paramString.get("duration") instanceof Integer)) {
                  j = ((Integer)paramString.get("duration")).intValue();
                }
              }
            }
          }
        }
      }
    }
    return j;
  }
  
  protected String getTransitionTimingFunction(String paramString)
  {
    Object localObject2 = null;
    Object localObject3 = (String)this.uiStyles.get("transitionTimingFunction");
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject1 = localObject2;
      if (PAnimation.timingFunctionList.contains(localObject3)) {
        localObject1 = localObject3;
      }
    }
    localObject3 = this.uiStyles.getReadableMap("transition");
    localObject2 = localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject2 = localObject1;
      if (localObject3 != null)
      {
        localObject2 = localObject1;
        if (((IReadableMap)localObject3).get(paramString) != null)
        {
          localObject2 = localObject1;
          if ((((IReadableMap)localObject3).get(paramString) instanceof Map))
          {
            paramString = (Map)((IReadableMap)localObject3).get(paramString);
            localObject2 = localObject1;
            if (paramString != null)
            {
              localObject2 = localObject1;
              if (paramString.containsKey("timing-function"))
              {
                localObject2 = localObject1;
                if ((paramString.get("timing-function") instanceof String)) {
                  localObject2 = (String)paramString.get("timing-function");
                }
              }
            }
          }
        }
      }
    }
    return localObject2;
  }
  
  public IWritableMap getUIStyles()
  {
    return this.uiStyles;
  }
  
  @Property("id")
  public void id(String paramString)
  {
    this.id = paramString;
  }
  
  public boolean isBlockType()
  {
    return false;
  }
  
  public boolean isDisplayNone()
  {
    return this.mNode.getDisplay() == PDisplay.NONE;
  }
  
  public boolean isLeafNode()
  {
    return false;
  }
  
  public boolean isNotCalculate()
  {
    return false;
  }
  
  @Property("left")
  public void left(final String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      removeUIStyle("left");
    }
    final Dimension localDimension;
    do
    {
      return;
      setPosition(PEdge.LEFT, paramString);
      paramString = Dimension.parse(paramString);
      localDimension = (Dimension)this.uiStyles.get("left");
      this.uiStyles.put("left", paramString);
    } while ((localDimension == null) || (paramString.px == localDimension.px));
    addTransitionProperty(new PAnimation.ITransition()
    {
      public PAnimation createAnimation()
      {
        int i = PElement.this.getTransitionDuration(name());
        if (i > 0)
        {
          Object localObject = PElement.this.getTransitionTimingFunction(name());
          localObject = PAnimation.createAnimation("left", PropertyValuesHolder.ofFloat("left", new float[] { localDimension.px, paramString.px }), i, (String)localObject);
          PElement.this.attachAnimationEvent((PAnimation)localObject, "transitionend");
          return localObject;
        }
        return null;
      }
      
      public String name()
      {
        return "left";
      }
    });
  }
  
  @Property("margin")
  public void margin(String paramString)
  {
    setMargin(paramString);
  }
  
  @Property("marginBottom")
  public void marginBottom(String paramString)
  {
    setMargin(PEdge.BOTTOM, paramString);
  }
  
  @Property("marginLeft")
  public void marginLeft(String paramString)
  {
    setMargin(PEdge.LEFT, paramString);
  }
  
  @Property("marginRight")
  public void marginRight(String paramString)
  {
    setMargin(PEdge.RIGHT, paramString);
  }
  
  @Property("marginTop")
  public void marginTop(String paramString)
  {
    setMargin(PEdge.TOP, paramString);
  }
  
  @Property("opacity")
  public void opacity(final String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      removeUIStyle("opacity");
    }
    final Float localFloat;
    do
    {
      return;
      paramString = Float.valueOf(Float.parseFloat(paramString));
      localFloat = (Float)this.uiStyles.get("opacity");
      this.uiStyles.put("opacity", paramString);
    } while ((localFloat == null) || (paramString.equals(localFloat)));
    addTransitionProperty(new PAnimation.ITransition()
    {
      public PAnimation createAnimation()
      {
        int i = PElement.this.getTransitionDuration(name());
        if (i > 0)
        {
          Object localObject = PElement.this.getTransitionTimingFunction(name());
          localObject = PAnimation.createAnimation("opacity", PropertyValuesHolder.ofFloat("opacity", new float[] { localFloat.floatValue(), paramString.floatValue() }), i, (String)localObject);
          PElement.this.attachAnimationEvent((PAnimation)localObject, "transitionend");
          return localObject;
        }
        return null;
      }
      
      public String name()
      {
        return "opacity";
      }
    });
  }
  
  @Property("padding")
  public void padding(String paramString)
  {
    setPadding(paramString);
  }
  
  @Property("paddingBottom")
  public void paddingBottom(String paramString)
  {
    setPadding(PEdge.BOTTOM, paramString);
  }
  
  @Property("paddingLeft")
  public void paddingLeft(String paramString)
  {
    setPadding(PEdge.LEFT, paramString);
  }
  
  @Property("paddingRight")
  public void paddingRight(String paramString)
  {
    setPadding(PEdge.RIGHT, paramString);
  }
  
  @Property("paddingTop")
  public void paddingTop(String paramString)
  {
    setPadding(PEdge.TOP, paramString);
  }
  
  public void pauseAnimation(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.mPauseAnimations == null) {
      this.mPauseAnimations = new ArrayList();
    }
    this.mPauseAnimations.add(paramString);
    setState(this.mState | 0x10);
  }
  
  public void playAnimation(String paramString1, String paramString2)
  {
    PropertyValuesHolder[] arrayOfPropertyValuesHolder = ((PKeyFrame)getDom().getKeyFrames().get(paramString1)).toPropertyValuesHolder();
    if ((arrayOfPropertyValuesHolder != null) && (arrayOfPropertyValuesHolder.length > 0))
    {
      int j = arrayOfPropertyValuesHolder.length;
      int i = 0;
      while (i < j)
      {
        PAnimation localPAnimation = PAnimation.createAnimation(paramString1, arrayOfPropertyValuesHolder[i], PAnimation.parseTime(paramString2).intValue());
        attachAnimationEvent(localPAnimation, "animationend");
        addAnimation(localPAnimation);
        i += 1;
      }
    }
  }
  
  @Property("position")
  public void position(String paramString)
  {
    setPositionType(paramString);
  }
  
  public void removeAttr(String paramString)
  {
    if (this.uiStyles.has(paramString))
    {
      this.uiStyles.remove(paramString);
      if (isLeafNode()) {
        this.mNode.dirty();
      }
    }
  }
  
  public void removeEvent(String paramString)
  {
    if (this.mEvents == null) {
      this.mEvents = new LinkedList();
    }
    if ((!TextUtils.isEmpty(paramString)) && (this.mEvents.contains(paramString)))
    {
      this.mEvents.remove(paramString);
      setState(this.mState | 0x8);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(this).append("removeEvent error. ");
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = "event type null";; paramString = "no event:" + paramString)
    {
      PLog.e("PElement", paramString);
      return;
    }
  }
  
  void removeUIStyle(String paramString)
  {
    if (this.uiStyles.has(paramString))
    {
      this.uiStyles.remove(paramString);
      setState(this.mState | 0x4);
    }
  }
  
  public void resumeAnimation(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.mResumeAnimations == null) {
      this.mResumeAnimations = new ArrayList();
    }
    this.mResumeAnimations.add(paramString);
    setState(this.mState | 0x10);
  }
  
  public ElementItem retrieveData(boolean paramBoolean)
  {
    ElementItem localElementItem = new ElementItem();
    copyFields(localElementItem);
    return localElementItem;
  }
  
  @Property("right")
  public void right(String paramString)
  {
    setPosition(PEdge.RIGHT, paramString);
  }
  
  public void setDom(IDom paramIDom)
  {
    this.dom = paramIDom;
  }
  
  @Property("height")
  public void set_height(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      removeUIStyle("height");
      setHeight(paramString);
      return;
    }
    this.height = Dimension.parse(paramString);
    final Dimension localDimension = (Dimension)this.uiStyles.get("height");
    this.uiStyles.put("height", this.height);
    if ((localDimension != null) && (this.height.px != localDimension.px)) {
      addTransitionProperty(new PAnimation.ITransition()
      {
        public PAnimation createAnimation()
        {
          int i = PElement.this.getTransitionDuration(name());
          if (i > 0)
          {
            Object localObject = PElement.this.getTransitionTimingFunction(name());
            localObject = PAnimation.createAnimation("height", PropertyValuesHolder.ofInt("height", new int[] { (int)localDimension.px, (int)PElement.this.height.px }), i, (String)localObject);
            PElement.this.attachAnimationEvent((PAnimation)localObject, "transitionend");
            return localObject;
          }
          return null;
        }
        
        public String name()
        {
          return "height";
        }
      });
    }
    setHeight(paramString);
  }
  
  @Property("width")
  public void set_width(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      removeUIStyle("width");
      setWidth(paramString);
      return;
    }
    this.width = Dimension.parse(paramString);
    final Dimension localDimension = (Dimension)this.uiStyles.get("width");
    this.uiStyles.put("width", this.width);
    if ((localDimension != null) && (this.width.px != localDimension.px)) {
      addTransitionProperty(new PAnimation.ITransition()
      {
        public PAnimation createAnimation()
        {
          int i = PElement.this.getTransitionDuration("width");
          if (i > 0)
          {
            Object localObject = PElement.this.getTransitionTimingFunction(name());
            localObject = PAnimation.createAnimation("width", PropertyValuesHolder.ofInt("width", new int[] { (int)localDimension.px, (int)PElement.this.width.px }), i, (String)localObject);
            PElement.this.attachAnimationEvent((PAnimation)localObject, "transitionend");
            return localObject;
          }
          return null;
        }
        
        public String name()
        {
          return "width";
        }
      });
    }
    setWidth(paramString);
  }
  
  public void stopAnimation(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.mStopAnimations == null) {
      this.mStopAnimations = new ArrayList();
    }
    this.mStopAnimations.add(paramString);
    setState(this.mState | 0x10);
  }
  
  @Property("top")
  public void top(final String paramString)
  {
    setPosition(PEdge.TOP, paramString);
    paramString = Dimension.parse(paramString);
    final Dimension localDimension = (Dimension)this.uiStyles.get("top");
    this.uiStyles.put("top", paramString);
    if ((localDimension != null) && (paramString.px != localDimension.px)) {
      addTransitionProperty(new PAnimation.ITransition()
      {
        public PAnimation createAnimation()
        {
          int i = PElement.this.getTransitionDuration(name());
          if (i > 0)
          {
            Object localObject = PElement.this.getTransitionTimingFunction(name());
            localObject = PAnimation.createAnimation("top", PropertyValuesHolder.ofFloat("top", new float[] { localDimension.px, paramString.px }), i, (String)localObject);
            PElement.this.attachAnimationEvent((PAnimation)localObject, "transitionend");
            return localObject;
          }
          return null;
        }
        
        public String name()
        {
          return "top";
        }
      });
    }
  }
  
  @Property("transform")
  public void transform(final String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = PAnimation.parseTransform(paramString);
      if (paramString != null) {}
    }
    else
    {
      return;
    }
    PLog.i("PElement", paramString.toString());
    addTransitionProperty(new PAnimation.ITransition()
    {
      public PAnimation createAnimation()
      {
        int j = PElement.this.getTransitionDuration(name());
        if (j > 0)
        {
          Object localObject = new float[((Object[])paramString.second).length];
          int i = 0;
          while (i < ((Object[])paramString.second).length)
          {
            if ((((Object[])paramString.second)[i] instanceof Float)) {
              localObject[i] = ((Float)((Object[])paramString.second)[i]).floatValue();
            }
            i += 1;
          }
          String str = PElement.this.getTransitionTimingFunction(name());
          localObject = PAnimation.createAnimation((String)paramString.first, PropertyValuesHolder.ofFloat((String)paramString.first, (float[])localObject), j, str);
          PElement.this.attachAnimationEvent((PAnimation)localObject, "transitionend");
          return localObject;
        }
        PElement.this.mTransform.put(paramString.first, paramString.second);
        return null;
      }
      
      public String name()
      {
        return "transform";
      }
    });
  }
  
  @Property("transition")
  public void transition(String paramString)
  {
    PLog.i("PElement", "id:" + getElementId() + ", call transition(), " + paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split(",");
      if ((paramString != null) && (paramString.length > 0))
      {
        if (this.uiStyles.getReadableMap("transition") != null) {
          this.uiStyles.remove("transition");
        }
        JSONWritableMap localJSONWritableMap = new JSONWritableMap();
        this.uiStyles.put("transition", localJSONWritableMap);
        int j = paramString.length;
        int i = 0;
        while (i < j)
        {
          Object localObject = PAnimation.parseTransition(paramString[i]);
          if ((localJSONWritableMap instanceof JSONWritableMap))
          {
            localObject = ((Map)localObject).entrySet().iterator();
            while (((Iterator)localObject).hasNext())
            {
              Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
              ((JSONWritableMap)localJSONWritableMap).put((String)localEntry.getKey(), localEntry.getValue());
            }
          }
          i += 1;
        }
      }
    }
    else
    {
      this.uiStyles.remove("transition");
      PLog.i("PElement", "id:" + getElementId() + ", clear transition");
    }
  }
  
  @Property("transitionTimingFunction")
  public void transitionTimingFunction(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.uiStyles.put("transitionTimingFunction", paramString);
    }
  }
  
  public void updateRect(View paramView)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams((int)getLayoutWidth(), (int)getLayoutHeight());
    localLayoutParams.leftMargin = ((int)getLayoutX());
    localLayoutParams.topMargin = ((int)getLayoutY());
    PLog.i("PElement", "updateRect node:" + getElementId() + " l:" + localLayoutParams.leftMargin + " t:" + localLayoutParams.topMargin + " w:" + localLayoutParams.width + " h:" + localLayoutParams.height);
    if (paramView != null)
    {
      paramView.setLayoutParams(localLayoutParams);
      return;
    }
    PLog.e("PElement", "updateRect view == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.element.PElement
 * JD-Core Version:    0.7.0.1
 */