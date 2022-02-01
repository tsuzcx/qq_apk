package com.tencent.viola.ui.baseComponent;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.PointF;
import android.graphics.Shader;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Pair;
import android.util.Property;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.viola.adapter.VComponentAdapter;
import com.tencent.viola.annotation.JSMethod;
import com.tencent.viola.annotation.VComponentField;
import com.tencent.viola.bridge.Invoker;
import com.tencent.viola.bridge.NativeInvokeHelper;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.commons.AssocioationEvents;
import com.tencent.viola.commons.JSParam;
import com.tencent.viola.compatible.VComponentCompat;
import com.tencent.viola.core.IActivityState;
import com.tencent.viola.core.ViolaDomManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaInstance.ViolaPageListener;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.action.DOMAction;
import com.tencent.viola.ui.action.MethodAnimation;
import com.tencent.viola.ui.action.MethodUpdateElement;
import com.tencent.viola.ui.animation.AnimationBean;
import com.tencent.viola.ui.animation.AnimationBean.Style;
import com.tencent.viola.ui.animation.AnimationModule.AnimationHolder;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.dom.Attr;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObjectCell;
import com.tencent.viola.ui.dom.DomObjectCell.ComponentState;
import com.tencent.viola.ui.dom.DomUtils;
import com.tencent.viola.ui.dom.Style;
import com.tencent.viola.ui.dom.style.BorderDrawable;
import com.tencent.viola.ui.dom.style.CornerViewOutlineProvider;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.ui.dom.style.StyleSpace;
import com.tencent.viola.ui.view.VTextView;
import com.tencent.viola.utils.VReflectionUtils;
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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class VComponent<T extends View>
  implements IActivityState, IAddViewInterceptor, IInterestInScroll, IVReuseComponent
{
  public static final int LIFE_CYCLE_CREATED = 1;
  public static final int LIFE_CYCLE_DESTROYED = 4;
  public static final int LIFE_CYCLE_INIT = 0;
  public static final int LIFE_CYCLE_MOUNTED = 2;
  public static final int LIFE_CYCLE_UPDATED = 3;
  public static final int RETURN_TYPE_DP = 0;
  public static final int RETURN_TYPE_PX = 1;
  public static final String TAG = "VComponent";
  private List<VComponent.AnimationInfo> animationInfos = new CopyOnWriteArrayList();
  private VComponentCompat compat;
  private boolean fixMinHeight = false;
  private Animator fromTransformOpacityAnimator;
  private boolean hasPerformFromTransformOpacity;
  private ViewPropertyAnimator mAlphaAnimator;
  private AnimationModule.AnimationHolder mAnimationHolder;
  public Set<String> mAppendEvents = new HashSet();
  private AssocioationEvents mAssocioationEvents;
  public BorderDrawable mBackgroundDrawable;
  private int mContentHeight = 0;
  private int mContentWidth = 0;
  protected Context mContext;
  private GestureDetector mDetector;
  public volatile DomObject mDomObj;
  private long mDoubleClickSystemTime = 0L;
  private int mFrameX = 0;
  private int mFrameY = 0;
  private boolean mHasPerformTransformAnimate;
  private IFComponentHolder mHolder;
  public T mHost;
  protected ViolaInstance mInstance;
  private boolean mIsDestroyed = false;
  private boolean mLazy = false;
  private ConcurrentHashMap<String, Integer> mLifeCycleMap;
  private boolean mNeedInterceptTouchEvent = false;
  private boolean mNeedLayoutOnAnimation = false;
  public VComponentContainer mParent;
  private int mPreRealHeight = 0;
  private int mPreRealLeft = 0;
  private int mPreRealTop = 0;
  private int mPreRealWidth = 0;
  private ViewPropertyAnimator mTransformAnimator;
  private int mType;
  @VComponentField(nativeReturnMethod="getVisibility", propertyName="visibility")
  private String mVisibility;
  private VComponent.BringLayerToTopContext topIndexContext;
  
  public VComponent(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer)
  {
    this(paramViolaInstance, paramDomObject, paramVComponentContainer, 0);
  }
  
  public VComponent(ViolaInstance paramViolaInstance, DomObject paramDomObject, VComponentContainer paramVComponentContainer, int paramInt)
  {
    this.mInstance = paramViolaInstance;
    this.mDomObj = paramDomObject;
    this.mParent = paramVComponentContainer;
    this.mType = paramInt;
    this.mContext = paramViolaInstance.getContext();
    initLifeCycle(paramDomObject);
  }
  
  private boolean containVR(DomObject paramDomObject)
  {
    return (paramDomObject != null) && (paramDomObject.getAttributes().containsKey("vr"));
  }
  
  private void dealFireCommonTouchEvent(View paramView, String paramString, MotionEvent paramMotionEvent)
  {
    if ((this.mAppendEvents.contains(paramString)) && (!isScrollComponent())) {
      paramView = new JSONObject();
    }
    for (;;)
    {
      try
      {
        paramView.put("id", getRef());
        ViolaInstance localViolaInstance = getInstance();
        float f1 = 0.0F;
        if (localViolaInstance == null) {
          break label233;
        }
        paramMotionEvent = getInstance().getLocationOnRenderContainer(new float[] { paramMotionEvent.getRawX(), paramMotionEvent.getRawY() });
        f1 = paramMotionEvent.x;
        f2 = paramMotionEvent.y;
        paramView.put("page_x", FlexConvertUtils.px2dip(f1));
        paramView.put("page_y", FlexConvertUtils.px2dip(f2));
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append(FlexConvertUtils.px2dip(f1));
        paramMotionEvent.append("dp");
        paramView.put("pageX", paramMotionEvent.toString());
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append(FlexConvertUtils.px2dip(f2));
        paramMotionEvent.append("dp");
        paramView.put("pageY", paramMotionEvent.toString());
        paramView.put("name", paramString);
        paramView.put("frame", getPositionInfoRelativeToParent(0));
      }
      catch (JSONException paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
      }
      fireEvent(paramString, paramView);
      return;
      label233:
      float f2 = 0.0F;
    }
  }
  
  private void execAssocioationJSFuncByName(JSONObject paramJSONObject1, String paramString, List<JSParam> paramList, JSONObject paramJSONObject2)
  {
    if ((paramJSONObject1 != null) && (!TextUtils.isEmpty(paramString)))
    {
      if (!paramJSONObject1.has(paramString)) {
        return;
      }
      paramJSONObject1 = paramJSONObject1.optJSONObject(paramString);
      Iterator localIterator = paramJSONObject1.keys();
      JSONObject localJSONObject = new JSONObject();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = paramJSONObject1.optString(str);
        localObject = ViolaBridgeManager.getInstance().execJSFuncByNameWithResult((String)localObject, paramList);
        if ((localObject != null) && (((JSParam)localObject).data != null)) {
          localJSONObject.put(str, ((JSParam)localObject).data);
        }
      }
      if (paramJSONObject1.length() > 0) {
        paramJSONObject2.put(paramString, localJSONObject);
      }
    }
  }
  
  private void exportClickAction(String paramString)
  {
    if (!containVR(this.mDomObj)) {
      return;
    }
    VComponentAdapter localVComponentAdapter = ViolaSDKManager.getInstance().getComponentAdapter();
    if (localVComponentAdapter == null) {
      return;
    }
    View localView = getHostView();
    if (localView == null) {
      return;
    }
    int i = -1;
    int j = paramString.hashCode();
    if (j != -1643834313)
    {
      if ((j == 94750088) && (paramString.equals("click"))) {
        i = 0;
      }
    }
    else if (paramString.equals("doubleClick")) {
      i = 1;
    }
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      localVComponentAdapter.onDoubleClick(localView, this.mDomObj.getAttributes().get("vr"));
      return;
    }
    localVComponentAdapter.onClick(localView, this.mDomObj.getAttributes().get("vr"));
  }
  
  private void fireCommonTouchEvent(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          dealFireCommonTouchEvent(paramView, "touchCancel", paramMotionEvent);
          return;
        }
        dealFireCommonTouchEvent(paramView, "touchMove", paramMotionEvent);
        return;
      }
      dealFireCommonTouchEvent(paramView, "touchUp", paramMotionEvent);
      return;
    }
    dealFireCommonTouchEvent(paramView, "touchDown", paramMotionEvent);
  }
  
  private int getLifeCycleConstanceFromEvent(String paramString)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1986762265: 
      if (paramString.equals("destroyed")) {
        i = 3;
      }
      break;
    case 1242932856: 
      if (paramString.equals("mounted")) {
        i = 1;
      }
      break;
    case 1028554472: 
      if (paramString.equals("created")) {
        i = 0;
      }
      break;
    case -234430277: 
      if (paramString.equals("updated")) {
        i = 2;
      }
      break;
    }
    int i = -1;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return 0;
          }
          return 4;
        }
        return 3;
      }
      return 2;
    }
    return 1;
  }
  
  private float getPivotXResultByStr(String paramString)
  {
    if ("left".equals(paramString)) {
      return 0.0F;
    }
    if ("center".equals(paramString)) {
      return getDomObject().getLayoutWidth() / 2.0F;
    }
    return getDomObject().getLayoutWidth();
  }
  
  private float getPivotYResultByStr(String paramString)
  {
    if ("top".equals(paramString)) {
      return 0.0F;
    }
    if ("center".equals(paramString)) {
      return getDomObject().getLayoutHeight() / 2.0F;
    }
    return getDomObject().getLayoutHeight();
  }
  
  private void initLifeCycle(DomObject paramDomObject)
  {
    if ((getInstance() != null) && (this.mLifeCycleMap == null)) {
      this.mLifeCycleMap = getInstance().getLifeCycleMap();
    }
    if (!this.mLifeCycleMap.containsKey(paramDomObject.getRef())) {
      this.mLifeCycleMap.put(this.mDomObj.getRef(), Integer.valueOf(0));
    }
  }
  
  private void internalApplyEvents()
  {
    int j = this.mDomObj.getEvents().size();
    int i = 0;
    while (i < j)
    {
      addEvent((String)this.mDomObj.getEvents().get(i));
      i += 1;
    }
    addClickEvent();
  }
  
  private void internalApplyLayout()
  {
    if (isLazy()) {
      return;
    }
    DomObject localDomObject = this.mDomObj;
    synchronized (DomObject.LOCK)
    {
      int i = (int)localDomObject.getLayoutX();
      int j = (int)localDomObject.getStyle().getMarginRight(750);
      int k = (int)localDomObject.getLayoutY();
      int m = (int)localDomObject.getStyle().getMarginBottom(750);
      int n = (int)localDomObject.getLayoutWidth();
      int i1 = (int)localDomObject.getLayoutHeight();
      if ((this.mPreRealWidth == n) && (this.mPreRealHeight == i1) && (this.mPreRealLeft == i) && (this.mPreRealTop == k)) {
        return;
      }
      this.mPreRealWidth = n;
      this.mPreRealHeight = i1;
      this.mPreRealLeft = i;
      this.mPreRealTop = k;
      setHostLayoutParams(this.mHost, n, i1, i, j, k, m);
      calFrameXY(localDomObject);
      return;
    }
  }
  
  private void internalCreateViewImpl()
  {
    if (this.mContext == null)
    {
      localObject = this.mParent;
      if (localObject != null) {
        this.mContext = ((VComponentContainer)localObject).getContext();
      }
    }
    Object localObject = this.mContext;
    if (localObject != null)
    {
      this.mHost = initComponentHostView((Context)localObject);
      tryCompatVR(this.mDomObj);
      if ((this.mHost == null) && (!isVirtualComponent())) {
        initView();
      }
      localObject = this.mHost;
      if (localObject != null) {
        ((View)localObject).setId(DomUtils.generateViewId());
      }
      updateLifeCycle("created");
    }
    else
    {
      ViolaLogUtils.e("createViewImpl", "Context is null");
    }
    trySetFromTransformOpacity();
  }
  
  private void internalDestroy(boolean paramBoolean)
  {
    Object localObject = this.mHost;
    if ((localObject != null) && (((View)localObject).getLayerType() == 2)) {
      this.mHost.setLayerType(0, null);
    }
    removeAllEvent();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("destroy component type:");
    ((StringBuilder)localObject).append(this.mDomObj.getType());
    ((StringBuilder)localObject).append("; ref:");
    ((StringBuilder)localObject).append(this.mDomObj.getRef());
    ViolaLogUtils.d("VComponent", ((StringBuilder)localObject).toString());
    updateLifeCycle("destroyed");
    if (paramBoolean) {
      this.mDomObj.destroy();
    }
    this.mIsDestroyed = true;
    this.mContext = null;
    this.animationInfos.clear();
    localObject = this.mAlphaAnimator;
    if (localObject != null)
    {
      ((ViewPropertyAnimator)localObject).cancel();
      this.mAlphaAnimator = null;
    }
    localObject = this.mTransformAnimator;
    if (localObject != null)
    {
      ((ViewPropertyAnimator)localObject).cancel();
      this.mTransformAnimator = null;
    }
    localObject = this.fromTransformOpacityAnimator;
    if (localObject != null)
    {
      ((Animator)localObject).cancel();
      this.fromTransformOpacityAnimator = null;
    }
  }
  
  private void internalRichGesture(JSParam paramJSParam)
  {
    Object localObject1 = this.mAssocioationEvents;
    if ((localObject1 != null) && (((AssocioationEvents)localObject1).mProps != null))
    {
      if (paramJSParam == null) {
        return;
      }
      localObject1 = new ArrayList();
      ((List)localObject1).add(paramJSParam);
      try
      {
        paramJSParam = this.mAssocioationEvents.mProps;
        int i = 0;
        while (i < paramJSParam.length())
        {
          Object localObject2 = new JSONObject();
          JSONObject localJSONObject = paramJSParam.optJSONObject(i);
          if ((localJSONObject != null) && (localJSONObject.has(AssocioationEvents.ASSOCIOATION_PROPS_KEY_TARGET)))
          {
            String str = localJSONObject.optString(AssocioationEvents.ASSOCIOATION_PROPS_KEY_TARGET);
            execAssocioationJSFuncByName(localJSONObject, AssocioationEvents.ASSOCIOATION_PROPS_KEY_STYLE, (List)localObject1, (JSONObject)localObject2);
            execAssocioationJSFuncByName(localJSONObject, AssocioationEvents.ASSOCIOATION_PROPS_KEY_ATTR, (List)localObject1, (JSONObject)localObject2);
            if (ViolaUtils.isStyleOrAttrChange(str, getInstance().getInstanceId(), (JSONObject)localObject2))
            {
              localObject2 = new MethodUpdateElement(str, (JSONObject)localObject2, this.mAssocioationEvents.sync, this.mAssocioationEvents.applyLayout);
              if (this.mAssocioationEvents.sync) {
                ((MethodUpdateElement)localObject2).executeAsync(getInstance().getInstanceId());
              } else {
                ViolaSDKManager.getInstance().getDomManager().postTransitionTask(getInstance().getInstanceId(), (DOMAction)localObject2, false);
              }
            }
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramJSParam)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[internalRichGesture]: ");
        ((StringBuilder)localObject1).append(paramJSParam.getMessage());
        ViolaLogUtils.e("VComponent", ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  private boolean isContainCommonTouchEvent()
  {
    return (this.mAppendEvents.contains("touchDown")) || (this.mAppendEvents.contains("touchUp")) || (this.mAppendEvents.contains("touchMove")) || (this.mAppendEvents.contains("touchCancel"));
  }
  
  private boolean isScrollComponent()
  {
    return (getDomObject().getType().equals("list")) || (getDomObject().getType().equals("waterfall-list")) || (getDomObject().getType().equals("smart-header")) || (getDomObject().getType().equals("scroller"));
  }
  
  private void resetBackground()
  {
    this.mBackgroundDrawable = null;
    if (this.mHost != null) {
      setBackgroundDrawable();
    }
  }
  
  private void resetBackgroundImage()
  {
    View localView = getHostView();
    if (localView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 16) {
      localView.setBackground(null);
    } else {
      localView.setBackgroundDrawable(null);
    }
    this.mBackgroundDrawable = null;
  }
  
  private void resetTransform()
  {
    View localView = getHostView();
    if (localView == null) {
      return;
    }
    setTransformValue(localView, this.mDomObj.getStyle().get("transform_parse"), true);
  }
  
  private void resetTransformOrigin()
  {
    View localView = getHostView();
    if (localView == null) {
      return;
    }
    localView.setPivotX(0.0F);
    localView.setPivotY(0.0F);
  }
  
  private void setBorderStyle(int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      getOrCreateBorder().setBorderStyle(paramInt, paramString);
    }
  }
  
  private void setFromTransform(Object paramObject)
  {
    View localView = getHostView();
    if (localView == null) {
      return;
    }
    if ((this.mDomObj != null) && (this.mDomObj.getStyle().containsKey("transform_origin_parse")))
    {
      Pair localPair = (Pair)this.mDomObj.getStyle().get("transform_origin_parse");
      localView.setPivotX(((Float)localPair.first).floatValue());
      localView.setPivotY(((Float)localPair.second).floatValue());
    }
    setTransformValue(localView, paramObject, false);
  }
  
  private void setLinearGradient(Object paramObject)
  {
    if ((paramObject instanceof LinearGradient)) {
      getOrCreateBorder().setImage((Shader)paramObject);
    }
  }
  
  private void setOpacityCompat(float paramFloat)
  {
    if ((!this.hasPerformFromTransformOpacity) && (this.mHost != null) && (this.mDomObj != null) && (this.mDomObj.getAttributes().containsKey("animationDuration")) && (this.mDomObj.getStyle().containsKey("fromTransformOpacity")))
    {
      Object localObject = this.fromTransformOpacityAnimator;
      if ((localObject != null) && (((Animator)localObject).isRunning())) {
        this.fromTransformOpacityAnimator.cancel();
      }
      int i = ViolaUtils.getInt(this.mDomObj.getAttributes().get("animationDuration"));
      localObject = this.mHost;
      this.fromTransformOpacityAnimator = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { ((View)localObject).getAlpha(), paramFloat }).setDuration(i);
      this.fromTransformOpacityAnimator.start();
      this.hasPerformFromTransformOpacity = true;
      return;
    }
    if ((this.mDomObj != null) && (this.mDomObj.getStyle().containsKey("opacity"))) {
      setOpacity(paramFloat);
    }
  }
  
  private void setPivot(Object paramObject)
  {
    paramObject = (Pair)paramObject;
    View localView = getHostView();
    if (localView == null) {
      return;
    }
    if (this.mDomObj != null)
    {
      if (this.mDomObj.getAttributes().containsKey("animationDuration")) {
        return;
      }
      localView.setPivotX(((Float)paramObject.first).floatValue());
      localView.setPivotY(((Float)paramObject.second).floatValue());
    }
  }
  
  private void setTransform(Object paramObject)
  {
    View localView = getHostView();
    if (localView == null) {
      return;
    }
    if ((this.mDomObj != null) && (this.mDomObj.getAttributes().containsKey("animationDuration")) && (!this.mHasPerformTransformAnimate))
    {
      setTransformWithAnimate(localView, (Map)paramObject);
      this.mHasPerformTransformAnimate = true;
      return;
    }
    setTransformValue(localView, paramObject, false);
  }
  
  private void setTransformValue(View paramView, Object paramObject, boolean paramBoolean)
  {
    paramObject = ((Map)paramObject).entrySet().iterator();
    while (paramObject.hasNext())
    {
      Object localObject = (Map.Entry)paramObject.next();
      Property localProperty = (Property)((Map.Entry)localObject).getKey();
      float f;
      if ((paramBoolean) && (localProperty.getName().contains("scale"))) {
        f = 1.0F;
      } else if (paramBoolean) {
        f = 0.0F;
      } else {
        f = ((Float)((Map.Entry)localObject).getValue()).floatValue();
      }
      localObject = localProperty.getName();
      int i = -1;
      switch (((String)localObject).hashCode())
      {
      default: 
        break;
      case 109250890: 
        if (((String)localObject).equals("scale")) {
          i = 3;
        }
        break;
      case -40300674: 
        if (((String)localObject).equals("rotation")) {
          i = 0;
        }
        break;
      case -908189617: 
        if (((String)localObject).equals("scaleY")) {
          i = 5;
        }
        break;
      case -908189618: 
        if (((String)localObject).equals("scaleX")) {
          i = 4;
        }
        break;
      case -1225497656: 
        if (((String)localObject).equals("translationY")) {
          i = 8;
        }
        break;
      case -1225497657: 
        if (((String)localObject).equals("translationX")) {
          i = 7;
        }
        break;
      case -1249320805: 
        if (((String)localObject).equals("rotationY")) {
          i = 2;
        }
        break;
      case -1249320806: 
        if (((String)localObject).equals("rotationX")) {
          i = 1;
        }
        break;
      case -1840647503: 
        if (((String)localObject).equals("translation")) {
          i = 6;
        }
        break;
      }
      switch (i)
      {
      default: 
        break;
      case 8: 
        paramView.setTranslationY(f);
        break;
      case 7: 
        paramView.setTranslationX(f);
        break;
      case 6: 
        paramView.setTranslationX(f);
        paramView.setTranslationY(f);
        break;
      case 5: 
        paramView.setScaleY(f);
        break;
      case 4: 
        paramView.setScaleX(f);
        break;
      case 3: 
        paramView.setScaleX(f);
        paramView.setScaleY(f);
        break;
      case 2: 
        paramView.setRotationY(f);
        break;
      case 1: 
        paramView.setRotationX(f);
        break;
      case 0: 
        paramView.setRotation(f);
      }
    }
  }
  
  private void setVRElementId()
  {
    if (this.mHost != null)
    {
      if (this.mDomObj == null) {
        return;
      }
      VComponentAdapter localVComponentAdapter = ViolaSDKManager.getInstance().getComponentAdapter();
      if (localVComponentAdapter == null) {
        return;
      }
      localVComponentAdapter.setVRElementReuseIdentifier(this.mHost, this.mDomObj.getRef());
    }
  }
  
  private void trySetFromTransformOpacity()
  {
    if ((this.mHost != null) && (this.mDomObj != null) && (this.mDomObj.getAttributes().containsKey("animationDuration")) && (this.mDomObj.getStyle().containsKey("fromTransformOpacity"))) {
      this.mHost.setAlpha(ViolaUtils.getFloat(this.mDomObj.getStyle().get("fromTransformOpacity"), Float.valueOf(1.0F)));
    }
  }
  
  public void addAnimationInfo(VComponent.AnimationInfo paramAnimationInfo)
  {
    this.animationInfos.add(paramAnimationInfo);
  }
  
  public void addClickEvent()
  {
    if ((getRealView() != null) && ((this.mAppendEvents.contains("click")) || (this.mAppendEvents.contains("doubleClick")) || (this.mAppendEvents.contains("longPress")) || ((isContainCommonTouchEvent()) && (!isScrollComponent()))))
    {
      if (this.mDetector == null) {
        this.mDetector = new GestureDetector(getContext(), new VComponent.MyGestureListener(this));
      }
      getRealView().setOnTouchListener(new VComponent.1(this));
    }
  }
  
  public void addEvent(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!this.mAppendEvents.contains(paramString)))
    {
      if (getRealView() == null) {
        return;
      }
      this.mAppendEvents.add(paramString);
    }
  }
  
  public void addSubViewOnIntercept(ViewGroup paramViewGroup, int paramInt) {}
  
  public void afterBringToRootByAnim() {}
  
  @JSMethod
  public void animate(@NonNull JSONObject paramJSONObject1, @NonNull JSONObject paramJSONObject2, @Nullable String paramString)
  {
    if ((this.mDomObj != null) && (!TextUtils.isEmpty(this.mDomObj.getRef())) && (paramJSONObject1 != null) && (paramJSONObject2 != null) && (this.mInstance != null)) {
      try
      {
        paramJSONObject2.put("styles", paramJSONObject1);
        if (paramJSONObject2 != null)
        {
          paramJSONObject1 = new MethodAnimation(this.mDomObj.getRef(), paramJSONObject2, paramString);
          ViolaSDKManager.getInstance().getDomManager().postActionDelay(this.mInstance.getInstanceId(), paramJSONObject1, false, 16L);
          return;
        }
      }
      catch (JSONException paramJSONObject1)
      {
        paramJSONObject2 = new StringBuilder();
        paramJSONObject2.append("animate JSONException e :");
        paramJSONObject2.append(paramJSONObject1.getMessage());
        ViolaLogUtils.e("VComponent", paramJSONObject2.toString());
      }
    }
  }
  
  public void applyEvents()
  {
    internalApplyEvents();
  }
  
  public void applyLayout()
  {
    internalApplyLayout();
  }
  
  public final void applyLayout(DomObject paramDomObject)
  {
    if (!isLazy())
    {
      this.mDomObj = paramDomObject;
      applyLayout();
    }
  }
  
  public void applyLayoutAndEvent()
  {
    this.mDomObj.applyDrawLayoutStyle();
    applyLayout();
    applyEvents();
  }
  
  public void beforeBringToRootByAnim() {}
  
  public void bindData()
  {
    if (!isLazy())
    {
      updateStyle(this.mDomObj.getStyle(), false);
      updateAttrs(this.mDomObj.getAttributes());
      updateExtra(this.mDomObj.getExtra());
      setBackgroundDrawable();
      checkClipChild();
      checkDisAppearEventFromDomobject();
      updateLifeCycle("mounted");
    }
  }
  
  public void bindData(DomObject paramDomObject)
  {
    this.mDomObj = paramDomObject;
    initLifeCycle(paramDomObject);
    bindData();
  }
  
  public void bindDomobj(DomObject paramDomObject)
  {
    this.mDomObj = paramDomObject;
    initLifeCycle(paramDomObject);
  }
  
  public void bindHolder(IFComponentHolder paramIFComponentHolder)
  {
    this.mHolder = paramIFComponentHolder;
  }
  
  @JSMethod
  public void bringLayerToRootView()
  {
    if (this.mHost != null)
    {
      if (getInstance() == null) {
        return;
      }
      Object localObject1 = getInstance().getRootComp();
      if (localObject1 != null)
      {
        if (((VComponentContainer)localObject1).mHost == null) {
          return;
        }
        Object localObject2 = new int[2];
        ((VComponentContainer)localObject1).mHost.getLocationInWindow((int[])localObject2);
        Object localObject3 = new int[2];
        this.mHost.getLocationInWindow((int[])localObject3);
        float f1 = localObject3[0] - localObject2[0];
        float f2 = localObject3[1] - localObject2[1];
        localObject2 = this.mHost.getLayoutParams();
        if ((localObject2 instanceof ViewGroup.MarginLayoutParams))
        {
          localObject2 = (ViewGroup.MarginLayoutParams)localObject2;
          int i = ((ViewGroup.MarginLayoutParams)localObject2).leftMargin;
          int j = ((ViewGroup.MarginLayoutParams)localObject2).topMargin;
          ((ViewGroup.MarginLayoutParams)localObject2).leftMargin = ((int)f1);
          ((ViewGroup.MarginLayoutParams)localObject2).topMargin = ((int)f2);
          localObject3 = getParent();
          if ((localObject3 != null) && (((VComponentContainer)localObject3).mHost != null))
          {
            int k = ((VComponentContainer)localObject3).indexOf(this);
            ((VComponentContainer)localObject3).getRealView().removeView(this.mHost);
            if (this.topIndexContext == null) {
              this.topIndexContext = new VComponent.BringLayerToTopContext(null);
            }
            localObject3 = this.topIndexContext;
            ((VComponent.BringLayerToTopContext)localObject3).index = k;
            ((VComponent.BringLayerToTopContext)localObject3).leftMargin = i;
            ((VComponent.BringLayerToTopContext)localObject3).topMargin = j;
            if ((this.mHost.getParent() instanceof ViewGroup)) {
              ((ViewGroup)this.mHost.getParent()).removeView(this.mHost);
            }
            localObject1 = ((VComponentContainer)localObject1).getRealView();
            if (localObject1 != null)
            {
              ((ViewGroup)localObject1).addView(this.mHost);
              this.mHost.setLayoutParams((ViewGroup.LayoutParams)localObject2);
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("bringLayerToRootView, hashCode: ");
              ((StringBuilder)localObject1).append(hashCode());
              ViolaLogUtils.e("VComponent-TopLayer", ((StringBuilder)localObject1).toString());
            }
          }
        }
      }
    }
  }
  
  public final void calFrameXY(DomObject paramDomObject)
  {
    float f2 = paramDomObject.getLayoutX();
    for (float f1 = paramDomObject.getLayoutY(); paramDomObject.mParent != null; f1 += paramDomObject.getLayoutY())
    {
      paramDomObject = paramDomObject.mParent;
      f2 += paramDomObject.getLayoutX();
    }
    this.mFrameX = ((int)f2);
    this.mFrameY = ((int)f1);
  }
  
  protected void checkClipChild()
  {
    if ((Build.VERSION.SDK_INT >= 21) && (getHostView() != null))
    {
      getHostView().setOutlineProvider(null);
      getHostView().setClipToOutline(false);
      if ((getDomObject().getAttributes() != null) && (getDomObject().getAttributes().containsKey("clipChild")) && (isSetBorderRadius()))
      {
        float[] arrayOfFloat = getOrCreateBorder().getBorderRadiusArray();
        if (arrayOfFloat[0] != 0.0F)
        {
          getHostView().setOutlineProvider(new CornerViewOutlineProvider(arrayOfFloat[0], getContentHeight(), 0));
          getHostView().setClipToOutline(true);
          return;
        }
        if ((arrayOfFloat[1] != 0.0F) && (arrayOfFloat[1] == arrayOfFloat[2]) && (arrayOfFloat[1] != arrayOfFloat[4]))
        {
          getHostView().setOutlineProvider(new CornerViewOutlineProvider(arrayOfFloat[1], getContentHeight(), 1));
          getHostView().setClipToOutline(true);
          return;
        }
        if ((arrayOfFloat[3] != 0.0F) && (arrayOfFloat[3] == arrayOfFloat[4]) && (arrayOfFloat[3] != arrayOfFloat[1]))
        {
          getHostView().setOutlineProvider(new CornerViewOutlineProvider(arrayOfFloat[3], getContentHeight(), 2));
          getHostView().setClipToOutline(true);
        }
      }
    }
  }
  
  protected void checkDisAppearEventFromDomobject()
  {
    if ((this.mDomObj.getEvents().contains("didAppear")) || (this.mDomObj.getEvents().contains("didDisappear")) || (this.mDomObj.getEvents().contains("willAppear")))
    {
      Object localObject = getDomObject();
      if ((localObject != null) && (((DomObject)localObject).getParent() != null) && (!"page".equals(((DomObject)localObject).getType())))
      {
        int j = 0;
        int i = 0;
        while ((!"cell".equals(((DomObject)localObject).getType())) && (!"footer-cell".equals(((DomObject)localObject).getType())))
        {
          j = (int)(j + ((DomObject)localObject).getLayoutY() + ((DomObject)localObject).getPadding().get(1));
          i = (int)(i + ((DomObject)localObject).getLayoutX() + ((DomObject)localObject).getPadding().get(0));
          DomObject localDomObject = (DomObject)((DomObject)localObject).getParent();
          if (localDomObject == null) {
            return;
          }
          localObject = localDomObject;
          if (localDomObject.getParent() == null) {
            return;
          }
        }
        localObject = (DomObjectCell)localObject;
        float f1 = j;
        ((DomObjectCell)localObject).addReDidAppearComptDyStart(f1, getRef());
        ((DomObjectCell)localObject).addReDidAppearComptDyEnd(f1 + getDomObject().getLayoutHeight(), getRef());
        f1 = i;
        ((DomObjectCell)localObject).addReDidAppearComptDxStart(f1, getRef());
        ((DomObjectCell)localObject).addReDidAppearComptDxEnd(f1 + getDomObject().getLayoutWidth(), getRef());
        boolean bool = getDomObject().getAttributes().containsKey("appearScopeTop");
        float f4 = 0.0F;
        if (bool) {
          f1 = (int)FlexConvertUtils.converPxByViewportToRealPx(getDomObject().getAttributes().get("appearScopeTop"), 750);
        } else {
          f1 = 0.0F;
        }
        float f2;
        if (getDomObject().getAttributes().containsKey("appearScopeBottom")) {
          f2 = (int)FlexConvertUtils.converPxByViewportToRealPx(getDomObject().getAttributes().get("appearScopeBottom"), 750);
        } else {
          f2 = 0.0F;
        }
        float f3;
        if (getDomObject().getAttributes().containsKey("appearScopeLeft")) {
          f3 = (int)FlexConvertUtils.converPxByViewportToRealPx(getDomObject().getAttributes().get("appearScopeLeft"), 750);
        } else {
          f3 = 0.0F;
        }
        if (getDomObject().getAttributes().containsKey("appearScopeRight")) {
          f4 = (int)FlexConvertUtils.converPxByViewportToRealPx(getDomObject().getAttributes().get("appearScopeRight"), 750);
        }
        ((DomObjectCell)localObject).addReDidAppearComptDyStartOffset(f1, getRef());
        ((DomObjectCell)localObject).addReDidAppearComptDyEndOffset(f2, getRef());
        ((DomObjectCell)localObject).addReDidAppearComptDxStartOffset(f3, getRef());
        ((DomObjectCell)localObject).addReDidAppearComptDxEndOffset(f4, getRef());
        if (!((DomObjectCell)localObject).isSetComponentStaet(getRef())) {
          ((DomObjectCell)localObject).setComponentState(getRef(), DomObjectCell.ComponentState.DIDDISAPPEAR);
        }
        if (getDomObject().getEvents().contains("didAppear")) {
          ((DomObjectCell)localObject).addRegisterComponent("didAppear", getRef());
        }
        if (getDomObject().getEvents().contains("didDisappear")) {
          ((DomObjectCell)localObject).addRegisterComponent("didDisappear", getRef());
        }
        if (getDomObject().getEvents().contains("willAppear")) {
          ((DomObjectCell)localObject).addRegisterComponent("willAppear", getRef());
        }
      }
    }
  }
  
  public boolean consumeBackKeyEvent()
  {
    return false;
  }
  
  protected <T extends VComponentCompat> T createCompator()
  {
    return new VComponentCompat(this, this.mDomObj);
  }
  
  public final void createView()
  {
    if (!isLazy()) {
      createViewImpl();
    }
  }
  
  public final void createView(Context paramContext)
  {
    if (!isLazy()) {
      createViewImplWithContext(paramContext);
    }
  }
  
  protected void createViewImpl()
  {
    internalCreateViewImpl();
  }
  
  protected void createViewImplWithContext(Context paramContext)
  {
    this.mContext = paramContext;
    internalCreateViewImpl();
  }
  
  public void destroy()
  {
    internalDestroy(true);
  }
  
  public void destroyComp()
  {
    internalDestroy(false);
    if (this.mInstance != null)
    {
      if (this.mDomObj == null) {
        return;
      }
      DOMActionContext localDOMActionContext = ViolaUtils.getDomActionContext(this.mInstance.getInstanceId());
      if (localDOMActionContext == null) {
        return;
      }
      String str = this.mDomObj.getRef();
      localDOMActionContext.unregisterComponent(str);
      localDOMActionContext.unregisterDOMObject(str);
    }
  }
  
  final void doRichGestrue(JSParam paramJSParam)
  {
    if (this.mAssocioationEvents.sync)
    {
      internalRichGesture(paramJSParam);
      return;
    }
    ViolaBridgeManager.getInstance().post(new VComponent.2(this, paramJSParam));
  }
  
  protected void fireClickAction(String paramString, MotionEvent paramMotionEvent)
  {
    if ((this.mAppendEvents.contains(paramString)) && (this.mHost != null)) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONArray();
        JSONObject localJSONObject = new JSONObject();
        Object localObject2 = getPositionInfoRelativeToRoot(0);
        Object localObject3 = getInstance();
        float f1 = 0.0F;
        if (localObject3 == null) {
          break label561;
        }
        paramMotionEvent = getInstance().getLocationOnRenderContainer(new float[] { paramMotionEvent.getRawX(), paramMotionEvent.getRawY() });
        f1 = paramMotionEvent.x;
        f2 = paramMotionEvent.y;
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append(FlexConvertUtils.px2dip(f1));
        paramMotionEvent.append("dp");
        localJSONObject.put("pageX", paramMotionEvent.toString());
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append(FlexConvertUtils.px2dip(f2));
        paramMotionEvent.append("dp");
        localJSONObject.put("pageY", paramMotionEvent.toString());
        localJSONObject.put("frame", localObject2);
        localJSONObject.put("viewFrame", getPositionInfoRelativeToParent(0));
        localJSONObject.put("state", "start");
        paramMotionEvent = this.mHost.getTag();
        if ((paramMotionEvent != null) && ((paramMotionEvent instanceof HashMap)))
        {
          paramMotionEvent = (HashMap)paramMotionEvent;
          localObject2 = paramMotionEvent.get("click");
          if ((localObject2 != null) && ((localObject2 instanceof Map)))
          {
            localObject2 = ((Map)localObject2).entrySet().iterator();
            if (((Iterator)localObject2).hasNext())
            {
              localObject3 = (Map.Entry)((Iterator)localObject2).next();
              localJSONObject.put(((Map.Entry)localObject3).getKey().toString(), ((Map.Entry)localObject3).getValue());
              continue;
            }
          }
          else if (((this.mHost instanceof VTextView)) && (((VTextView)this.mHost).mIsRich))
          {
            localJSONObject.put("index", -2);
          }
          paramMotionEvent.put("click", null);
        }
        else if (((this.mHost instanceof VTextView)) && (((VTextView)this.mHost).mIsRich))
        {
          localJSONObject.put("index", -2);
        }
        paramMotionEvent = this.mDomObj.getRef();
        if (!TextUtils.isEmpty(paramMotionEvent)) {
          ((JSONArray)localObject1).put(paramMotionEvent);
        }
        ((JSONArray)localObject1).put(paramString);
        paramMotionEvent = new StringBuilder();
        paramMotionEvent.append("mClickEventListener callData :");
        paramMotionEvent.append(((JSONArray)localObject1).toString());
        paramMotionEvent.append(", dom type = ");
        paramMotionEvent.append(getDomObject().getType());
        paramMotionEvent.append(" , data ");
        paramMotionEvent.append(localJSONObject.toString());
        ViolaLogUtils.d("VComponent", paramMotionEvent.toString());
        fireEvent(paramString, localObject1, localJSONObject);
      }
      catch (JSONException paramMotionEvent)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("mClickEventListener JSONException e:");
        ((StringBuilder)localObject1).append(paramMotionEvent.getMessage());
        ViolaLogUtils.e("VComponent", ((StringBuilder)localObject1).toString());
      }
      exportClickAction(paramString);
      return;
      label561:
      float f2 = 0.0F;
    }
  }
  
  protected final void fireEvent(String paramString, Object paramObject1, Object paramObject2)
  {
    if ((this.mInstance != null) && (this.mDomObj != null)) {
      ViolaBridgeManager.getInstance().callbackJavascript(this.mInstance.getInstanceId(), "dom", "fireEvent", paramObject1, paramObject2, true);
    }
  }
  
  public void fireEvent(String paramString, JSONObject paramJSONObject)
  {
    if (this.mDomObj != null) {
      this.mDomObj.fireEvent(paramString, paramJSONObject);
    }
  }
  
  public <T extends VComponentCompat> T getCompator()
  {
    if (this.compat == null) {
      this.compat = createCompator();
    }
    return this.compat;
  }
  
  public int getContentHeight()
  {
    int i = this.mContentHeight;
    if (i > 0) {
      return i;
    }
    return (int)this.mDomObj.getLayoutHeight();
  }
  
  public int getContentWidth()
  {
    int i = this.mContentWidth;
    if (i > 0) {
      return i;
    }
    return (int)this.mDomObj.getLayoutWidth();
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public DomObject getDomObject()
  {
    return this.mDomObj;
  }
  
  public final JSONArray getFireEventArgs(String paramString)
  {
    JSONArray localJSONArray = new JSONArray();
    if (getDomObject() != null)
    {
      String str = getDomObject().getRef();
      if (str != null) {
        localJSONArray.put(str);
      }
    }
    localJSONArray.put(paramString);
    return localJSONArray;
  }
  
  public final JSONObject getFrameInfo()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(FlexConvertUtils.px2dip(getFrameX()));
      localStringBuilder.append("dp");
      localJSONObject.put("x", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(FlexConvertUtils.px2dip(getFrameY()));
      localStringBuilder.append("dp");
      localJSONObject.put("y", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(FlexConvertUtils.px2dip(getHostView().getWidth()));
      localStringBuilder.append("dp");
      localJSONObject.put("width", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(FlexConvertUtils.px2dip(getHostView().getHeight()));
      localStringBuilder.append("dp");
      localJSONObject.put("height", localStringBuilder.toString());
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  @JSMethod(uiThread=true)
  public void getFrameInfos(@Nullable String paramString)
  {
    if ((this.mDomObj != null) && (!TextUtils.isEmpty(this.mDomObj.getRef())) && (this.mInstance != null) && (this.mHost != null)) {
      try
      {
        localObject1 = new JSONObject();
        Object localObject2 = new int[2];
        this.mHost.getLocationInWindow((int[])localObject2);
        int i = localObject2[0];
        int j = this.mInstance.getMatchWindowsX();
        int k = localObject2[1];
        int m = this.mInstance.getMatchWindowsY();
        localObject2 = new int[2];
        this.mHost.getLocationOnScreen((int[])localObject2);
        ((JSONObject)localObject1).put("pageX", FlexConvertUtils.px2dip(i - j));
        ((JSONObject)localObject1).put("pageY", FlexConvertUtils.px2dip(k - m));
        ((JSONObject)localObject1).put("screenX", FlexConvertUtils.px2dip(localObject2[0]));
        ((JSONObject)localObject1).put("screenY", FlexConvertUtils.px2dip(localObject2[1]));
        ((JSONObject)localObject1).put("width", FlexConvertUtils.px2dip(this.mHost.getWidth()));
        ((JSONObject)localObject1).put("height", FlexConvertUtils.px2dip(this.mHost.getHeight()));
        localObject2 = new JSONArray();
        ((JSONArray)localObject2).put(paramString);
        ViolaBridgeManager.getInstance().callbackJavascript(this.mInstance.getInstanceId(), "", "callback", localObject2, localObject1, true);
        return;
      }
      catch (JSONException paramString)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("mLongPressListener JSONException e:");
        ((StringBuilder)localObject1).append(paramString.getMessage());
        ViolaLogUtils.e("VComponent", ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public int getFrameX()
  {
    return this.mFrameX;
  }
  
  public int getFrameY()
  {
    return this.mFrameY;
  }
  
  public T getHostView()
  {
    return this.mHost;
  }
  
  public ViolaInstance getInstance()
  {
    return this.mInstance;
  }
  
  @JSMethod(uiThread=true)
  public void getNativeNodeInfo(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        localJSONObject1.put("ref", getRef());
        localJSONObject1.put("type", getDomObject().getType());
        Object localObject2 = VReflectionUtils.getFieldValueFromComponent(this, "mHost");
        JSONObject localJSONObject2 = new JSONObject();
        Iterator localIterator = this.mDomObj.getStyle().entrySet().iterator();
        Map localMap;
        String str;
        if (localIterator.hasNext())
        {
          localObject1 = (Map.Entry)localIterator.next();
          localMap = VReflectionUtils.getPropertyMap(getClass());
          str = (String)((Map.Entry)localObject1).getKey();
          if (localMap.containsKey(str)) {
            localObject1 = VReflectionUtils.getMethodValue(localObject2, (String)localMap.get(str));
          } else {
            localObject1 = ((Map.Entry)localObject1).getValue();
          }
          localJSONObject2.put(str, localObject1);
          continue;
        }
        localJSONObject1.put("style", localJSONObject2);
        localJSONObject2 = new JSONObject();
        localIterator = this.mDomObj.getAttributes().entrySet().iterator();
        if (localIterator.hasNext())
        {
          localObject1 = (Map.Entry)localIterator.next();
          localMap = VReflectionUtils.getAttrMap(getClass());
          str = (String)((Map.Entry)localObject1).getKey();
          if (localMap.containsKey(str)) {
            localObject1 = VReflectionUtils.getMethodValue(localObject2, (String)localMap.get(str));
          } else {
            localObject1 = ((Map.Entry)localObject1).getValue();
          }
          localJSONObject2.put(str, localObject1);
          continue;
        }
        localJSONObject1.put("attr", localJSONObject2);
        localObject1 = new JSONArray();
        i = 0;
        if (i < this.mDomObj.getChildCount())
        {
          if (this.mDomObj.getChild(i) != null) {
            ((JSONArray)localObject1).put(this.mDomObj.getChild(i).getRef());
          }
        }
        else
        {
          localJSONObject1.put("childiren", localObject1);
          localJSONObject1.put("frame", getPositionInfoRelativeToParent(0));
          localJSONObject1.put("position", getPositionInfoRelativeToRoot(0));
          localObject1 = new JSONArray();
          ((JSONArray)localObject1).put(paramString);
          ViolaBridgeManager.getInstance().callbackJavascript(this.mInstance.getInstanceId(), "", "callback", localObject1, localJSONObject1, true);
          return;
        }
      }
      catch (JSONException paramString)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getNativeNodeInfo JSONException e:");
        ((StringBuilder)localObject1).append(paramString.getMessage());
        ViolaLogUtils.e("VComponent", ((StringBuilder)localObject1).toString());
        return;
      }
      i += 1;
    }
  }
  
  public BorderDrawable getOrCreateBorder()
  {
    if (this.mBackgroundDrawable == null)
    {
      this.mBackgroundDrawable = new BorderDrawable();
      View localView = this.mHost;
    }
    return this.mBackgroundDrawable;
  }
  
  public VComponentContainer getParent()
  {
    return this.mParent;
  }
  
  public JSONObject getPositionInfoRelativeToParent(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramInt == 0) {}
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(FlexConvertUtils.px2dip(getHostView().getX()));
      ((StringBuilder)localObject).append("dp");
      localObject = ((StringBuilder)localObject).toString();
      break label62;
      localObject = Float.valueOf(getHostView().getX());
      label62:
      localJSONObject.put("x", localObject);
      if (paramInt == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(FlexConvertUtils.px2dip(getHostView().getY()));
        ((StringBuilder)localObject).append("dp");
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = Float.valueOf(getHostView().getY());
      }
      localJSONObject.put("y", localObject);
      if (paramInt == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(FlexConvertUtils.px2dip(getHostView().getWidth()));
        ((StringBuilder)localObject).append("dp");
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = Integer.valueOf(getHostView().getWidth());
      }
      localJSONObject.put("width", localObject);
      if (paramInt == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(FlexConvertUtils.px2dip(getHostView().getHeight()));
        ((StringBuilder)localObject).append("dp");
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = Integer.valueOf(getHostView().getHeight());
      }
      localJSONObject.put("height", localObject);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPositionInfoRelativeToParent error = ");
      localStringBuilder.append(localException.getMessage());
      ViolaLogUtils.e("VComponent", localStringBuilder.toString());
      localException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public JSONObject getPositionInfoRelativeToRoot(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = this.mHost;
    if (localObject1 != null)
    {
      Object localObject2 = new int[2];
      ((View)localObject1).getLocationInWindow((int[])localObject2);
      int i = localObject2[0] - this.mInstance.getMatchWindowsX();
      int j = localObject2[1] - this.mInstance.getMatchWindowsY();
      if (paramInt == 0) {}
      try
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(FlexConvertUtils.px2dip(i));
        ((StringBuilder)localObject1).append("dp");
        localObject1 = ((StringBuilder)localObject1).toString();
        break label107;
        localObject1 = Integer.valueOf(i);
        label107:
        localJSONObject.put("x", localObject1);
        if (paramInt == 0)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(FlexConvertUtils.px2dip(j));
          ((StringBuilder)localObject1).append("dp");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject1 = Integer.valueOf(j);
        }
        localJSONObject.put("y", localObject1);
        if (paramInt == 0)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(FlexConvertUtils.px2dip(this.mHost.getWidth()));
          ((StringBuilder)localObject1).append("dp");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject1 = Integer.valueOf(this.mHost.getWidth());
        }
        localJSONObject.put("width", localObject1);
        if (paramInt == 0)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(FlexConvertUtils.px2dip(this.mHost.getHeight()));
          ((StringBuilder)localObject1).append("dp");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject1 = Integer.valueOf(this.mHost.getHeight());
        }
        localJSONObject.put("height", localObject1);
        return localJSONObject;
      }
      catch (Exception localException)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getPositionInfoRelativeToRoot error = ");
        ((StringBuilder)localObject2).append(localException.getMessage());
        ViolaLogUtils.e("VComponent", ((StringBuilder)localObject2).toString());
      }
    }
    return localJSONObject;
  }
  
  public View getRealView()
  {
    return this.mHost;
  }
  
  public String getRef()
  {
    if (this.mDomObj != null) {
      return this.mDomObj.getRef();
    }
    return null;
  }
  
  @JSMethod
  public void getScreenPosition(@Nullable String paramString)
  {
    if ((this.mDomObj != null) && (!TextUtils.isEmpty(this.mDomObj.getRef())) && (this.mInstance != null) && (this.mHost != null)) {
      try
      {
        JSONObject localJSONObject1 = new JSONObject();
        Object localObject = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        int[] arrayOfInt = new int[2];
        this.mHost.getLocationOnScreen(arrayOfInt);
        int i = arrayOfInt[0];
        int j = arrayOfInt[1];
        float f = FlexConvertUtils.getScreenWidth() / getDomObject().getViewPortWidth();
        ((JSONObject)localObject).put("x", i / f);
        ((JSONObject)localObject).put("y", j / f);
        ((JSONObject)localObject).put("width", getContentWidth() / f);
        ((JSONObject)localObject).put("height", getContentHeight() / f);
        localJSONObject2.put("width", FlexConvertUtils.getScreenWidth() / f);
        localJSONObject2.put("height", FlexConvertUtils.getScreenHeight() / f);
        localJSONObject1.put("position", localObject);
        localJSONObject1.put("screen", localJSONObject2);
        localObject = new JSONArray();
        ((JSONArray)localObject).put(paramString);
        ViolaBridgeManager.getInstance().callbackJavascript(this.mInstance.getInstanceId(), "", "callback", localObject, localJSONObject1, true);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  @JSMethod
  public void hidePreCreateBody()
  {
    if (getInstance() != null) {
      getInstance().hidePreCreateBody();
    }
  }
  
  protected T initComponentHostView(@NonNull Context paramContext)
  {
    return null;
  }
  
  public void initView() {}
  
  public final void invoke(String paramString, JSONArray paramJSONArray)
  {
    paramString = this.mHolder.getMethodInvoker(paramString);
    if (paramString != null) {
      try
      {
        getInstance().getNativeInvokeHelper().invoke(this, paramString, paramJSONArray);
        return;
      }
      catch (Exception paramJSONArray)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Component] updateProperties :class:");
        localStringBuilder.append(getClass());
        localStringBuilder.append("method:");
        localStringBuilder.append(paramString.toString());
        localStringBuilder.append(" function e");
        localStringBuilder.append(paramJSONArray);
        ViolaLogUtils.e("VComponent", localStringBuilder.toString());
      }
    }
  }
  
  protected boolean isCompatMode()
  {
    ViolaInstance localViolaInstance = getInstance();
    if (localViolaInstance == null) {
      return false;
    }
    return localViolaInstance.isCompatMode();
  }
  
  public boolean isCreated()
  {
    boolean bool3 = this.mLifeCycleMap.containsKey(this.mDomObj.getRef());
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if ((this.mLifeCycleMap.get(this.mDomObj.getRef()) instanceof Integer))
      {
        bool1 = bool2;
        if (((Integer)this.mLifeCycleMap.get(this.mDomObj.getRef())).intValue() != 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean isDestroyed()
  {
    return this.mIsDestroyed;
  }
  
  public boolean isInterceptAddView()
  {
    return false;
  }
  
  public boolean isLayerTypeEnabled()
  {
    ViolaInstance localViolaInstance = this.mInstance;
    if (localViolaInstance == null) {
      return false;
    }
    return localViolaInstance.isLayerTypeEnabled();
  }
  
  public boolean isLazy()
  {
    if (this.mLazy) {
      return true;
    }
    VComponentContainer localVComponentContainer = this.mParent;
    return (localVComponentContainer != null) && (localVComponentContainer.isLazy());
  }
  
  public boolean isMounted()
  {
    boolean bool3 = this.mLifeCycleMap.containsKey(this.mDomObj.getRef());
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if ((this.mLifeCycleMap.get(this.mDomObj.getRef()) instanceof Integer)) {
        if (2 != ((Integer)this.mLifeCycleMap.get(this.mDomObj.getRef())).intValue())
        {
          bool1 = bool2;
          if (3 != ((Integer)this.mLifeCycleMap.get(this.mDomObj.getRef())).intValue()) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean isReuse()
  {
    return true;
  }
  
  public boolean isSetBorderRadius()
  {
    DomObject localDomObject = getDomObject();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localDomObject != null)
    {
      bool1 = bool2;
      if (getDomObject().getStyle() != null) {
        if ((!getDomObject().getStyle().containsKey("borderRadius")) && (!getDomObject().getStyle().containsKey("borderTopLeftRadius")) && (!getDomObject().getStyle().containsKey("borderTopRightRadius")) && (!getDomObject().getStyle().containsKey("borderBottomLeftRadius")))
        {
          bool1 = bool2;
          if (!getDomObject().getStyle().containsKey("borderBottomRightRadius")) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected boolean isVirtualComponent()
  {
    return false;
  }
  
  public void lazy(boolean paramBoolean)
  {
    this.mLazy = paramBoolean;
  }
  
  public boolean needInterceptTouchEvent()
  {
    return (this.mDomObj != null) && (this.mDomObj.getAttributes().containsKey("disableTouchPenetrate")) && (ViolaUtils.getBoolean(this.mDomObj.getAttributes().get("disableTouchPenetrate")));
  }
  
  public void notifyChange()
  {
    VComponentContainer localVComponentContainer = this.mParent;
    if (localVComponentContainer != null) {
      localVComponentContainer.notifyChange();
    }
  }
  
  public void notifyChange(int paramInt, String paramString)
  {
    VComponentContainer localVComponentContainer = this.mParent;
    if (localVComponentContainer != null) {
      localVComponentContainer.notifyChange(paramInt, paramString);
    }
  }
  
  public void notifyNativeBgColorChanged(int paramInt)
  {
    if (!this.mNeedLayoutOnAnimation) {
      return;
    }
    Object localObject;
    JSONObject localJSONObject;
    if (this.mInstance != null)
    {
      if (isDestroyed()) {
        return;
      }
      localObject = new JSONObject();
      localJSONObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("backgroundColor", String.format("#%06X", new Object[] { Integer.valueOf(paramInt & 0xFFFFFF) }));
      localJSONObject.put("style", localObject);
      localObject = new MethodUpdateElement(getRef(), localJSONObject);
      if ((localObject instanceof DOMAction)) {
        ViolaSDKManager.getInstance().getDomManager().postAction(this.mInstance.getInstanceId(), (DOMAction)localObject, false);
      }
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  public void notifyNativeSizeChanged(int paramInt1, int paramInt2)
  {
    if (!this.mNeedLayoutOnAnimation) {
      return;
    }
    Object localObject;
    JSONObject localJSONObject;
    float f1;
    float f2;
    if (this.mInstance != null)
    {
      if (isDestroyed()) {
        return;
      }
      localObject = new JSONObject();
      localJSONObject = new JSONObject();
      f1 = FlexConvertUtils.px2dip(paramInt1);
      f2 = FlexConvertUtils.px2dip(paramInt2);
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(f1);
      localStringBuilder.append("dp");
      ((JSONObject)localObject).put("width", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(f2);
      localStringBuilder.append("dp");
      ((JSONObject)localObject).put("height", localStringBuilder.toString());
      localJSONObject.put("style", localObject);
      localObject = new MethodUpdateElement(getRef(), localJSONObject);
      if ((localObject instanceof DOMAction)) {
        ViolaSDKManager.getInstance().getDomManager().postAction(this.mInstance.getInstanceId(), (DOMAction)localObject, false);
      }
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  public void notifyWhenChange(String paramString, DomObject paramDomObject)
  {
    VComponentContainer localVComponentContainer = this.mParent;
    if (localVComponentContainer != null) {
      localVComponentContainer.notifyWhenChange(paramString, paramDomObject);
    }
  }
  
  public boolean onActivityBack()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("life onActivityBack ref:");
    localStringBuilder.append(getRef());
    ViolaLogUtils.d("VComponent", localStringBuilder.toString());
    return false;
  }
  
  @Deprecated
  public void onActivityCreate()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("life onActivityCreate ref:");
    localStringBuilder.append(getRef());
    ViolaLogUtils.d("VComponent", localStringBuilder.toString());
  }
  
  public void onActivityDestroy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("life onActivityDestroy ref:");
    localStringBuilder.append(getRef());
    ViolaLogUtils.d("VComponent", localStringBuilder.toString());
  }
  
  public void onActivityPause()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("life onActivityPause ref:");
    localStringBuilder.append(getRef());
    ViolaLogUtils.d("VComponent", localStringBuilder.toString());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramIntent = new StringBuilder();
    paramIntent.append("life onActivityResult : requestCode:");
    paramIntent.append(paramInt1);
    paramIntent.append("; resultCode :");
    paramIntent.append(paramInt2);
    ViolaLogUtils.d("VComponent", paramIntent.toString());
  }
  
  public void onActivityResume()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("life onActivityResume ref:");
    localStringBuilder.append(getRef());
    ViolaLogUtils.d("VComponent", localStringBuilder.toString());
  }
  
  public void onActivityStart()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("life onActivityStart ref:");
    localStringBuilder.append(getRef());
    ViolaLogUtils.d("VComponent", localStringBuilder.toString());
  }
  
  public void onActivityStop()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("life onActivityStop ref:");
    localStringBuilder.append(getRef());
    ViolaLogUtils.d("VComponent", localStringBuilder.toString());
  }
  
  public void onBindData(DomObject paramDomObject)
  {
    this.mDomObj = paramDomObject;
    initLifeCycle(paramDomObject);
    internalApplyEvents();
    internalApplyLayout();
    updateStyle(this.mDomObj.getStyle(), false);
    updateAttrs(this.mDomObj.getAttributes());
    updateExtra(this.mDomObj.getExtra());
    setBackgroundDrawable();
    checkClipChild();
    updateLifeCycle("mounted");
  }
  
  public void onRecycler() {}
  
  public void onRichGestureScroll(int paramInt1, int paramInt2)
  {
    if (this.mAssocioationEvents == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(FlexConvertUtils.px2dip(paramInt1));
      localStringBuilder.append("dp");
      localJSONObject.put("x", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(FlexConvertUtils.px2dip(paramInt2));
      localStringBuilder.append("dp");
      localJSONObject.put("y", localStringBuilder.toString());
      doRichGestrue(new JSParam(3, localJSONObject.toString()));
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  public void onScroll(RecyclerView paramRecyclerView, boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void postAnimation(AnimationModule.AnimationHolder paramAnimationHolder)
  {
    this.mAnimationHolder = paramAnimationHolder;
  }
  
  public void recycled()
  {
    if (this.mDomObj.isFixed()) {}
  }
  
  public final void removeAllEvent()
  {
    if (this.mDomObj != null)
    {
      if (this.mDomObj.getEvents().size() < 1) {
        return;
      }
      this.mAppendEvents.clear();
      View localView = this.mHost;
      if (localView != null)
      {
        localView.setOnFocusChangeListener(null);
        this.mHost.setOnTouchListener(null);
      }
    }
  }
  
  public void removeAnimationInfo(VComponent.AnimationInfo paramAnimationInfo)
  {
    this.animationInfos.remove(paramAnimationInfo);
  }
  
  protected boolean removeEvent(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("removeEvent: ");
    localStringBuilder.append(paramString);
    ViolaLogUtils.d("VComponent", localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString)) && (this.mAppendEvents.contains(paramString)))
    {
      if (this.mHost == null) {
        return true;
      }
      this.mAppendEvents.remove(paramString);
      if (paramString.equals("click"))
      {
        this.mHost.setOnTouchListener(null);
        return true;
      }
      if (paramString.equals("longPress")) {
        this.mHost.setOnTouchListener(null);
      }
    }
    return true;
  }
  
  public void removedByDiff() {}
  
  public void removedByJs()
  {
    updateLifeCycle("destroyed");
  }
  
  public void resetAnimation(Animator paramAnimator, AnimationBean paramAnimationBean)
  {
    if (paramAnimator != null) {
      paramAnimator.cancel();
    }
    paramAnimator = getHostView();
    if ((paramAnimator != null) && (paramAnimationBean != null))
    {
      if (paramAnimationBean.styles == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramAnimationBean.styles.backgroundColor)) {
        paramAnimator.setBackgroundDrawable(null);
      }
      if (!TextUtils.isEmpty(paramAnimationBean.styles.opacity)) {
        paramAnimator.setAlpha(1.0F);
      }
      if (!TextUtils.isEmpty(paramAnimationBean.styles.transformOrigin))
      {
        paramAnimator.setPivotX(0.0F);
        paramAnimator.setPivotY(0.0F);
      }
      if (!TextUtils.isEmpty(paramAnimationBean.styles.transform))
      {
        paramAnimator.setScaleX(1.0F);
        paramAnimator.setScaleY(1.0F);
        paramAnimator.setRotation(0.0F);
        paramAnimator.setRotationX(0.0F);
        paramAnimator.setRotationY(0.0F);
        paramAnimator.setTranslationX(0.0F);
        paramAnimator.setTranslationY(0.0F);
      }
    }
  }
  
  protected boolean resetAttr(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resetAttr: ");
    localStringBuilder.append(paramString);
    ViolaLogUtils.d("VComponent", localStringBuilder.toString());
    if (("clipChild".equals(paramString)) && (this.mHost != null) && (Build.VERSION.SDK_INT >= 21))
    {
      if ((getHostView().getOutlineProvider() instanceof CornerViewOutlineProvider)) {
        ((CornerViewOutlineProvider)getHostView().getOutlineProvider()).setRadius(0.0F);
      }
      getHostView().setOutlineProvider(null);
      getHostView().setClipToOutline(false);
      return true;
    }
    return false;
  }
  
  public final void resetAttrs(List<String> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        resetAttr((String)paramList.next());
      }
    }
  }
  
  public void resetComponent()
  {
    try
    {
      Iterator localIterator = this.animationInfos.iterator();
      while (localIterator.hasNext())
      {
        VComponent.AnimationInfo localAnimationInfo = (VComponent.AnimationInfo)localIterator.next();
        resetAnimation(VComponent.AnimationInfo.access$300(localAnimationInfo), VComponent.AnimationInfo.access$400(localAnimationInfo));
      }
      this.animationInfos.clear();
      if (this.mAlphaAnimator != null)
      {
        this.mAlphaAnimator.cancel();
        if (getHostView() != null) {
          getHostView().setAlpha(1.0F);
        }
        this.mAlphaAnimator = null;
      }
      this.mNeedInterceptTouchEvent = false;
      if (this.mTransformAnimator != null)
      {
        this.mTransformAnimator.cancel();
        this.mTransformAnimator = null;
      }
      this.mHasPerformTransformAnimate = false;
      if (this.fromTransformOpacityAnimator != null)
      {
        this.fromTransformOpacityAnimator.cancel();
        this.fromTransformOpacityAnimator = null;
      }
      this.hasPerformFromTransformOpacity = false;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void resetComponent(DomObject paramDomObject) {}
  
  public final void resetEvents(List<String> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        removeEvent((String)paramList.next());
      }
    }
  }
  
  protected boolean resetStyle(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resetStyle: ");
    localStringBuilder.append(paramString);
    ViolaLogUtils.d("VComponent", localStringBuilder.toString());
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 1941332754: 
      if (paramString.equals("visibility")) {
        i = 22;
      }
      break;
    case 1511773502: 
      if (paramString.equals("background_image_parse")) {
        i = 26;
      }
      break;
    case 1349188574: 
      if (paramString.equals("borderRadius")) {
        i = 16;
      }
      break;
    case 1287124693: 
      if (paramString.equals("backgroundColor")) {
        i = 15;
      }
      break;
    case 741115130: 
      if (paramString.equals("borderWidth")) {
        i = 0;
      }
      break;
    case 737768677: 
      if (paramString.equals("borderStyle")) {
        i = 10;
      }
      break;
    case 722830999: 
      if (paramString.equals("borderColor")) {
        i = 5;
      }
      break;
    case 588239831: 
      if (paramString.equals("borderBottomRightRadius")) {
        i = 20;
      }
      break;
    case 581268560: 
      if (paramString.equals("borderBottomLeftRadius")) {
        i = 19;
      }
      break;
    case 565945933: 
      if (paramString.equals("transform_origin_parse")) {
        i = 23;
      }
      break;
    case 333432965: 
      if (paramString.equals("borderTopRightRadius")) {
        i = 18;
      }
      break;
    case -40300674: 
      if (paramString.equals("rotation")) {
        i = 27;
      }
      break;
    case -223992013: 
      if (paramString.equals("borderLeftWidth")) {
        i = 1;
      }
      break;
    case -227338466: 
      if (paramString.equals("borderLeftStyle")) {
        i = 11;
      }
      break;
    case -242276144: 
      if (paramString.equals("borderLeftColor")) {
        i = 6;
      }
      break;
    case -325605344: 
      if (paramString.equals("transform_parse")) {
        i = 24;
      }
      break;
    case -1228066334: 
      if (paramString.equals("borderTopLeftRadius")) {
        i = 17;
      }
      break;
    case -1267206133: 
      if (paramString.equals("opacity")) {
        i = 21;
      }
      break;
    case -1290574193: 
      if (paramString.equals("borderBottomWidth")) {
        i = 4;
      }
      break;
    case -1293920646: 
      if (paramString.equals("borderBottomStyle")) {
        i = 14;
      }
      break;
    case -1308858324: 
      if (paramString.equals("borderBottomColor")) {
        i = 9;
      }
      break;
    case -1373358863: 
      if (paramString.equals("fromTransformParse")) {
        i = 25;
      }
      break;
    case -1452542531: 
      if (paramString.equals("borderTopWidth")) {
        i = 2;
      }
      break;
    case -1455888984: 
      if (paramString.equals("borderTopStyle")) {
        i = 12;
      }
      break;
    case -1470826662: 
      if (paramString.equals("borderTopColor")) {
        i = 7;
      }
      break;
    case -1971292586: 
      if (paramString.equals("borderRightWidth")) {
        i = 3;
      }
      break;
    case -1974639039: 
      if (paramString.equals("borderRightStyle")) {
        i = 13;
      }
      break;
    case -1989576717: 
      if (paramString.equals("borderRightColor")) {
        i = 8;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      return false;
    case 27: 
      paramString = getHostView();
      if (paramString != null) {
        paramString.setRotation(0.0F);
      }
      return true;
    case 26: 
      resetBackgroundImage();
      return true;
    case 24: 
    case 25: 
      resetTransform();
      return true;
    case 23: 
      resetTransformOrigin();
      return true;
    case 22: 
      if (this.mHost != null) {
        getHostView().setVisibility(0);
      }
      return true;
    case 21: 
      paramString = this.mHost;
      if (paramString != null) {
        paramString.setAlpha(1.0F);
      }
      return true;
    case 20: 
      setBoderBottomRightRadius(0.0F);
      resetBackground();
      return true;
    case 19: 
      setBoderBottomLeftRadius(0.0F);
      resetBackground();
      return true;
    case 18: 
      setBoderTopRightRadius(0.0F);
      resetBackground();
      return true;
    case 17: 
      setBoderTopLeftRadius(0.0F);
      resetBackground();
      return true;
    case 16: 
      setBorderRadius(0, 0.0F);
      resetBackground();
      return true;
    }
    resetBackground();
    return true;
  }
  
  public final void resetStyles(List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      resetStyle((String)paramList.next());
    }
  }
  
  @JSMethod
  public void resumeLayer()
  {
    if ((this.mHost != null) && (getInstance() != null))
    {
      if (this.topIndexContext == null) {
        return;
      }
      Object localObject = getInstance().getRootComp();
      if (localObject != null)
      {
        if (((VComponentContainer)localObject).mHost == null) {
          return;
        }
        localObject = ((VComponentContainer)localObject).getRealView();
        if (localObject == null) {
          return;
        }
        ((ViewGroup)localObject).removeView(this.mHost);
        localObject = (FrameLayout.LayoutParams)this.mHost.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).leftMargin = this.topIndexContext.leftMargin;
        ((FrameLayout.LayoutParams)localObject).topMargin = this.topIndexContext.topMargin;
        this.mHost.setLayoutParams((ViewGroup.LayoutParams)localObject);
        localObject = getParent();
        if (localObject != null)
        {
          ((VComponentContainer)localObject).getRealView().addView(this.mHost, this.topIndexContext.index);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("resumeLayer, hashCode: ");
          ((StringBuilder)localObject).append(hashCode());
          ViolaLogUtils.e("VComponent-TopLayer", ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public void setAssocioationEvents(AssocioationEvents paramAssocioationEvents)
  {
    this.mAssocioationEvents = paramAssocioationEvents;
  }
  
  public void setBackgroundColor(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = ViolaUtils.getColor(paramString);
      if ((i != 0) || (this.mBackgroundDrawable != null)) {
        getOrCreateBorder().setColor(i);
      }
      if ((i == 0) && (getRealView() != null) && (this.mDomObj != null) && (this.mDomObj.getEvents() != null) && (!this.mDomObj.getEvents().contains("click"))) {
        this.mNeedInterceptTouchEvent = true;
      }
    }
  }
  
  public void setBackgroundDrawable()
  {
    if (getHostView() != null)
    {
      Object localObject = this.mBackgroundDrawable;
      if (localObject != null) {
        ((BorderDrawable)localObject).invalidateSelf();
      }
      if (Build.VERSION.SDK_INT >= 16) {
        getHostView().setBackground(this.mBackgroundDrawable);
      } else {
        getHostView().setBackgroundDrawable(this.mBackgroundDrawable);
      }
      if ((getDomObject().getAttributes() != null) && (getDomObject().getAttributes().containsKey("clipChild")) && (isSetBorderRadius()) && (Build.VERSION.SDK_INT >= 21))
      {
        localObject = getOrCreateBorder().getBorderRadiusArray();
        if (localObject[0] != 0.0F)
        {
          getHostView().setOutlineProvider(new CornerViewOutlineProvider(localObject[0], getContentHeight(), 0));
          getHostView().setClipToOutline(true);
          return;
        }
        if ((localObject[1] != 0.0F) && (localObject[1] == localObject[2]) && (localObject[1] != localObject[4]))
        {
          getHostView().setOutlineProvider(new CornerViewOutlineProvider(localObject[1], getContentHeight(), 1));
          getHostView().setClipToOutline(true);
          return;
        }
        if ((localObject[3] != 0.0F) && (localObject[3] == localObject[4]) && (localObject[3] != localObject[1]))
        {
          getHostView().setOutlineProvider(new CornerViewOutlineProvider(localObject[3], getContentHeight(), 2));
          getHostView().setClipToOutline(true);
        }
      }
    }
  }
  
  public void setBoderBottomLeftRadius(float paramFloat)
  {
    setBorderRadius(4, paramFloat);
  }
  
  public void setBoderBottomRightRadius(float paramFloat)
  {
    setBorderRadius(3, paramFloat);
  }
  
  public void setBoderTopLeftRadius(float paramFloat)
  {
    setBorderRadius(1, paramFloat);
  }
  
  public void setBoderTopRightRadius(float paramFloat)
  {
    setBorderRadius(2, paramFloat);
  }
  
  public void setBorderColor(int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = ViolaUtils.getColor(paramString);
      if (i != 0) {
        getOrCreateBorder().setBorderColor(paramInt, i);
      }
    }
  }
  
  public void setBorderRadius(int paramInt, float paramFloat)
  {
    getOrCreateBorder().setBorderRadius(paramInt, paramFloat);
  }
  
  public void setBorderWidth(int paramInt, float paramFloat)
  {
    getOrCreateBorder().setBorderWidth(paramInt, paramFloat);
  }
  
  public void setContentHeight(int paramInt)
  {
    this.mContentHeight = paramInt;
  }
  
  public void setContentWidth(int paramInt)
  {
    this.mContentWidth = paramInt;
  }
  
  public void setHostLayoutParams(T paramT, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    int i = paramInt2;
    View localView = this.mHost;
    if (localView == null) {
      return;
    }
    if (this.mParent == null)
    {
      paramT = new FrameLayout.LayoutParams(paramInt1, paramInt2);
      paramT.setMargins(paramInt3, paramInt5, paramInt4, paramInt6);
    }
    else
    {
      paramInt2 = i;
      if ((localView instanceof VTextView))
      {
        paramInt2 = i;
        if (((VTextView)localView).mIsRich) {
          paramInt2 = i + 5;
        }
      }
      paramT = this.mParent.getChildLayoutParams(this, paramT, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
      setContentHeight(paramInt2);
      setContentWidth(paramInt1);
    }
    if (paramT != null) {
      this.mHost.setLayoutParams(paramT);
    }
  }
  
  public void setHostView(T paramT)
  {
    this.mHost = paramT;
  }
  
  public void setNeedLayoutOnAnimation(boolean paramBoolean)
  {
    this.mNeedLayoutOnAnimation = paramBoolean;
  }
  
  public void setOpacity(float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F) && (getHostView() != null) && (getHostView().getAlpha() != paramFloat))
    {
      if (isLayerTypeEnabled()) {
        this.mHost.setLayerType(2, null);
      }
      this.mHost.setAlpha(paramFloat);
    }
  }
  
  public void setOpacityWithAnimate(Object paramObject)
  {
    float f = ViolaUtils.getFloat(paramObject, Float.valueOf(-1.0F));
    if (f >= 0.0F)
    {
      if (f > 1.0F) {
        return;
      }
      paramObject = getHostView();
      if ((paramObject != null) && (this.mDomObj != null))
      {
        if (!this.mDomObj.getAttributes().containsKey("animationDuration")) {
          return;
        }
        ViewPropertyAnimator localViewPropertyAnimator = this.mAlphaAnimator;
        if (localViewPropertyAnimator != null) {
          localViewPropertyAnimator.cancel();
        }
        int i = ViolaUtils.getInt(this.mDomObj.getAttributes().get("animationDuration"));
        this.mAlphaAnimator = paramObject.animate().alpha(f).setDuration(i);
        this.mAlphaAnimator.start();
      }
    }
  }
  
  protected boolean setProperty(String paramString, Object paramObject)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 2021893585: 
      if (paramString.equals("floatCenter")) {
        i = 28;
      }
      break;
    case 2002678695: 
      if (paramString.equals("floatBottom")) {
        i = 27;
      }
      break;
    case 1941332754: 
      if (paramString.equals("visibility")) {
        i = 22;
      }
      break;
    case 1511773502: 
      if (paramString.equals("background_image_parse")) {
        i = 29;
      }
      break;
    case 1349188574: 
      if (paramString.equals("borderRadius")) {
        i = 16;
      }
      break;
    case 1287124693: 
      if (paramString.equals("backgroundColor")) {
        i = 0;
      }
      break;
    case 741115130: 
      if (paramString.equals("borderWidth")) {
        i = 1;
      }
      break;
    case 737768677: 
      if (paramString.equals("borderStyle")) {
        i = 11;
      }
      break;
    case 722830999: 
      if (paramString.equals("borderColor")) {
        i = 6;
      }
      break;
    case 588239831: 
      if (paramString.equals("borderBottomRightRadius")) {
        i = 21;
      }
      break;
    case 581268560: 
      if (paramString.equals("borderBottomLeftRadius")) {
        i = 20;
      }
      break;
    case 565945933: 
      if (paramString.equals("transform_origin_parse")) {
        i = 24;
      }
      break;
    case 333432965: 
      if (paramString.equals("borderTopRightRadius")) {
        i = 19;
      }
      break;
    case 3772: 
      if (paramString.equals("vr")) {
        i = 32;
      }
      break;
    case -40300674: 
      if (paramString.equals("rotation")) {
        i = 23;
      }
      break;
    case -223992013: 
      if (paramString.equals("borderLeftWidth")) {
        i = 2;
      }
      break;
    case -227338466: 
      if (paramString.equals("borderLeftStyle")) {
        i = 12;
      }
      break;
    case -242276144: 
      if (paramString.equals("borderLeftColor")) {
        i = 7;
      }
      break;
    case -325605344: 
      if (paramString.equals("transform_parse")) {
        i = 25;
      }
      break;
    case -986512259: 
      if (paramString.equals("topIndex")) {
        i = 26;
      }
      break;
    case -1228066334: 
      if (paramString.equals("borderTopLeftRadius")) {
        i = 18;
      }
      break;
    case -1267206133: 
      if (paramString.equals("opacity")) {
        i = 17;
      }
      break;
    case -1290574193: 
      if (paramString.equals("borderBottomWidth")) {
        i = 5;
      }
      break;
    case -1293920646: 
      if (paramString.equals("borderBottomStyle")) {
        i = 15;
      }
      break;
    case -1308858324: 
      if (paramString.equals("borderBottomColor")) {
        i = 10;
      }
      break;
    case -1373358863: 
      if (paramString.equals("fromTransformParse")) {
        i = 30;
      }
      break;
    case -1452542531: 
      if (paramString.equals("borderTopWidth")) {
        i = 3;
      }
      break;
    case -1455888984: 
      if (paramString.equals("borderTopStyle")) {
        i = 13;
      }
      break;
    case -1470826662: 
      if (paramString.equals("borderTopColor")) {
        i = 8;
      }
      break;
    case -1717142839: 
      if (paramString.equals("fromTransformOpacity")) {
        i = 31;
      }
      break;
    case -1971292586: 
      if (paramString.equals("borderRightWidth")) {
        i = 4;
      }
      break;
    case -1974639039: 
      if (paramString.equals("borderRightStyle")) {
        i = 14;
      }
      break;
    case -1989576717: 
      if (paramString.equals("borderRightColor")) {
        i = 9;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      return false;
    case 32: 
      setVRElementId();
      return false;
    case 31: 
      setOpacityCompat(ViolaUtils.getFloat(this.mDomObj.getStyle().get("opacity"), Float.valueOf(1.0F)));
      return true;
    case 30: 
      setFromTransform(paramObject);
      return true;
    case 29: 
      setLinearGradient(paramObject);
      return true;
    case 28: 
      if ((Boolean.valueOf(ViolaUtils.getBoolean(paramObject)).booleanValue()) && (getHostView() != null) && (getInstance() != null)) {
        getInstance().getViolaPageListener().onComponentFloatCenter(getHostView(), getDomObject().getLayoutHeight());
      }
      return true;
    case 27: 
      if ((Boolean.valueOf(ViolaUtils.getBoolean(paramObject)).booleanValue()) && (getHostView() != null) && (getInstance() != null)) {
        getInstance().getViolaPageListener().onComponentFloatBottom(getHostView(), getDomObject().getLayoutHeight());
      }
      return true;
    case 26: 
      if ((Boolean.valueOf(ViolaUtils.getBoolean(paramObject)).booleanValue()) && (getHostView() != null) && (getInstance() != null)) {
        getInstance().getViolaPageListener().onComponentTopIndex(getHostView(), getDomObject().getLayoutHeight());
      }
      return true;
    case 25: 
      setTransform(paramObject);
      return true;
    case 24: 
      setPivot(paramObject);
      return true;
    case 23: 
      float f = ViolaUtils.getFloat(paramObject, Float.valueOf(90.0F));
      getHostView().setRotation(f);
      return true;
    case 22: 
      if (getHostView() != null)
      {
        this.mVisibility = ViolaUtils.getString(paramObject, "visible");
        if ("visible".equals(this.mVisibility))
        {
          getHostView().setVisibility(0);
          return true;
        }
        getHostView().setVisibility(4);
      }
      return true;
    case 21: 
      paramString = ViolaUtils.getString(paramObject, null);
      if (paramString != null) {
        setBoderBottomRightRadius(FlexConvertUtils.getFloatByViewport(paramString, getDomObject().getViewPortWidth()));
      }
      return true;
    case 20: 
      paramString = ViolaUtils.getString(paramObject, null);
      if (paramString != null) {
        setBoderBottomLeftRadius(FlexConvertUtils.getFloatByViewport(paramString, getDomObject().getViewPortWidth()));
      }
      return true;
    case 19: 
      paramString = ViolaUtils.getString(paramObject, null);
      if (paramString != null) {
        setBoderTopRightRadius(FlexConvertUtils.getFloatByViewport(paramString, getDomObject().getViewPortWidth()));
      }
      return true;
    case 18: 
      paramString = ViolaUtils.getString(paramObject, null);
      if (paramString != null) {
        setBoderTopLeftRadius(FlexConvertUtils.getFloatByViewport(paramString, getDomObject().getViewPortWidth()));
      }
      return true;
    case 17: 
      paramString = Float.valueOf(ViolaUtils.getFloat(paramObject, Float.valueOf(-1.0F)));
      if ((paramString != null) && (!paramString.equals(Float.valueOf(-1.0F)))) {
        setOpacityCompat(paramString.floatValue());
      }
      return true;
    case 16: 
      paramString = ViolaUtils.getString(paramObject, null);
      if (paramString != null) {
        setBorderRadius(0, FlexConvertUtils.getFloatByViewport(paramString, getDomObject().getViewPortWidth()));
      }
      return true;
    case 15: 
      paramString = ViolaUtils.getString(paramObject, null);
      if (paramString != null) {
        setBorderStyle(4, paramString);
      }
      return true;
    case 14: 
      paramString = ViolaUtils.getString(paramObject, null);
      if (paramString != null) {
        setBorderStyle(3, paramString);
      }
      return true;
    case 13: 
      paramString = ViolaUtils.getString(paramObject, null);
      if (paramString != null) {
        setBorderStyle(2, paramString);
      }
      return true;
    case 12: 
      paramString = ViolaUtils.getString(paramObject, null);
      if (paramString != null) {
        setBorderStyle(1, paramString);
      }
      return true;
    case 11: 
      paramString = ViolaUtils.getString(paramObject, null);
      if (paramString != null) {
        setBorderStyle(0, paramString);
      }
      return true;
    case 10: 
      paramString = ViolaUtils.getString(paramObject, null);
      if (paramString != null) {
        setBorderColor(4, paramString);
      }
      return true;
    case 9: 
      paramString = ViolaUtils.getString(paramObject, null);
      if (paramString != null) {
        setBorderColor(3, paramString);
      }
      return true;
    case 8: 
      paramString = ViolaUtils.getString(paramObject, null);
      if (paramString != null) {
        setBorderColor(2, paramString);
      }
      return true;
    case 7: 
      paramString = ViolaUtils.getString(paramObject, null);
      if (paramString != null) {
        setBorderColor(1, paramString);
      }
      return true;
    case 6: 
      paramString = ViolaUtils.getString(paramObject, null);
      if (paramString != null) {
        setBorderColor(0, paramString);
      }
      return true;
    case 5: 
      setBorderWidth(4, FlexConvertUtils.converPxByViewportToRealPx(paramObject, getDomObject().getViewPortWidth()));
      return true;
    case 4: 
      setBorderWidth(3, FlexConvertUtils.converPxByViewportToRealPx(paramObject, getDomObject().getViewPortWidth()));
      return true;
    case 3: 
      setBorderWidth(2, FlexConvertUtils.converPxByViewportToRealPx(paramObject, getDomObject().getViewPortWidth()));
      return true;
    case 2: 
      setBorderWidth(1, FlexConvertUtils.converPxByViewportToRealPx(paramObject, getDomObject().getViewPortWidth()));
      return true;
    case 1: 
      setBorderWidth(0, FlexConvertUtils.getFloatByViewport(paramObject, getDomObject().getViewPortWidth()));
      return true;
    }
    paramString = ViolaUtils.getString(paramObject, null);
    if (paramString != null) {
      setBackgroundColor(paramString);
    }
    return true;
  }
  
  public void setTransformWithAnimate(View paramView, Map<Property<View, Float>, Float> paramMap)
  {
    paramMap = paramMap.entrySet().iterator();
    float f6 = -1.0F;
    float f7 = -1.0F;
    float f4 = -1.0F;
    float f5 = -1.0F;
    float f2 = -1.0F;
    float f3 = -1.0F;
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      Property localProperty = (Property)((Map.Entry)localObject).getKey();
      float f1 = ((Float)((Map.Entry)localObject).getValue()).floatValue();
      localObject = localProperty.getName();
      i = -1;
      switch (((String)localObject).hashCode())
      {
      default: 
        break;
      case 109250890: 
        if (((String)localObject).equals("scale")) {
          i = 5;
        }
        break;
      case -40300674: 
        if (((String)localObject).equals("rotation")) {
          i = 6;
        }
        break;
      case -908189617: 
        if (((String)localObject).equals("scaleY")) {
          i = 4;
        }
        break;
      case -908189618: 
        if (((String)localObject).equals("scaleX")) {
          i = 3;
        }
        break;
      case -1225497656: 
        if (((String)localObject).equals("translationY")) {
          i = 1;
        }
        break;
      case -1225497657: 
        if (((String)localObject).equals("translationX")) {
          i = 0;
        }
        break;
      case -1249320805: 
        if (((String)localObject).equals("rotationY")) {
          i = 8;
        }
        break;
      case -1249320806: 
        if (((String)localObject).equals("rotationX")) {
          i = 7;
        }
        break;
      case -1840647503: 
        if (((String)localObject).equals("translation")) {
          i = 2;
        }
        break;
      }
      switch (i)
      {
      default: 
        break;
      case 8: 
        f3 = f1;
        break;
      case 7: 
        f2 = f1;
        break;
      case 6: 
        f3 = f1;
        f2 = f1;
        break;
      case 5: 
        f5 = f1;
        f4 = f1;
        break;
      case 4: 
        f5 = f1;
        break;
      case 3: 
        f4 = f1;
        break;
      case 2: 
        f7 = f1;
        f6 = f1;
        break;
      case 1: 
        f7 = f1;
        break;
      case 0: 
        f6 = f1;
      }
    }
    if ((f6 == -1.0F) && (f7 == -1.0F) && (f4 == -1.0F) && (f5 == -1.0F) && (f2 == -1.0F) && (f3 == -1.0F)) {
      return;
    }
    paramMap = this.mTransformAnimator;
    if (paramMap != null) {
      paramMap.cancel();
    }
    this.mTransformAnimator = paramView.animate();
    paramMap = null;
    if (this.mDomObj.getStyle().containsKey("transform_origin_parse")) {
      paramMap = (Pair)this.mDomObj.getStyle().get("transform_origin_parse");
    }
    if (f6 != -1.0F) {
      this.mTransformAnimator.translationX(f6);
    }
    if (f7 != -1.0F) {
      this.mTransformAnimator.translationY(f7);
    }
    if (f4 != -1.0F)
    {
      this.mTransformAnimator.scaleX(f4);
      if (paramMap != null) {
        paramView.setPivotX(((Float)paramMap.first).floatValue());
      }
    }
    if (f5 != -1.0F)
    {
      this.mTransformAnimator.scaleY(f5);
      if (paramMap != null) {
        paramView.setPivotY(((Float)paramMap.second).floatValue());
      }
    }
    if (f2 != -1.0F)
    {
      this.mTransformAnimator.rotationX(f2);
      if (paramMap != null) {
        paramView.setPivotX(((Float)paramMap.first).floatValue());
      }
    }
    if (f3 != -1.0F)
    {
      this.mTransformAnimator.rotationY(f3);
      if (paramMap != null) {
        paramView.setPivotY(((Float)paramMap.second).floatValue());
      }
    }
    int i = ViolaUtils.getInt(this.mDomObj.getAttributes().get("animationDuration"));
    paramView = getInstance();
    if (paramView == null) {
      return;
    }
    paramView.increaseTransformCount();
    this.mTransformAnimator.setDuration(i).setListener(new VComponent.3(this, paramView)).start();
  }
  
  public void tryCompatVR(DomObject paramDomObject)
  {
    if ((this.mHost != null) && (containVR(paramDomObject)))
    {
      VComponentAdapter localVComponentAdapter = ViolaSDKManager.getInstance().getComponentAdapter();
      if (localVComponentAdapter != null) {
        localVComponentAdapter.onVRParamsChange(this.mHost, paramDomObject.getAttributes().get("vr"));
      }
    }
  }
  
  public void unregisterFromContext(boolean paramBoolean)
  {
    Object localObject = getInstance();
    if (localObject != null)
    {
      if (this.mDomObj == null) {
        return;
      }
      localObject = ViolaUtils.getDomActionContext(((ViolaInstance)localObject).getInstanceId());
      if (localObject == null) {
        return;
      }
      ((DOMActionContext)localObject).unregisterComponent(this.mDomObj.getRef());
      if (paramBoolean) {
        ((DOMActionContext)localObject).unregisterDOMObject(this.mDomObj.getRef());
      }
    }
  }
  
  public void updateAttrs(Map<String, Object> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject2 = (Map.Entry)paramMap.next();
        Object localObject1 = (String)((Map.Entry)localObject2).getKey();
        localObject2 = ((Map.Entry)localObject2).getValue();
        if (!setProperty((String)localObject1, localObject2))
        {
          Object localObject3 = this.mHolder;
          if (localObject3 == null) {
            return;
          }
          localObject1 = ((IFComponentHolder)localObject3).getPropertyInvoker((String)localObject1);
          if (localObject1 != null) {
            try
            {
              localObject3 = ((Invoker)localObject1).getParameterTypes();
              if (localObject3.length != 1)
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("[VComponent] setX method only one parameter：");
                ((StringBuilder)localObject2).append(localObject1);
                ViolaLogUtils.e("VComponent", ((StringBuilder)localObject2).toString());
                return;
              }
              ((Invoker)localObject1).invoke(this, new Object[] { VReflectionUtils.parseArgument(localObject3[0], localObject2) });
            }
            catch (Exception localException)
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("[VComponent] updateProperties :class:");
              ((StringBuilder)localObject3).append(getClass());
              ((StringBuilder)localObject3).append("method:");
              ((StringBuilder)localObject3).append(localObject1.toString());
              ((StringBuilder)localObject3).append(" function ");
              ((StringBuilder)localObject3).append(ViolaLogUtils.getStackTrace(localException));
              ViolaLogUtils.e("VComponent", ((StringBuilder)localObject3).toString());
            }
          }
        }
      }
    }
  }
  
  public void updateDom(DomObject paramDomObject)
  {
    if (paramDomObject == null) {
      return;
    }
    this.mDomObj = paramDomObject.clone();
  }
  
  public void updateExtra(Object paramObject) {}
  
  public void updateLifeCycle(String paramString)
  {
    int i = getLifeCycleConstanceFromEvent(paramString);
    if ((this.mLifeCycleMap.containsKey(this.mDomObj.getRef())) && ((this.mLifeCycleMap.get(this.mDomObj.getRef()) instanceof Integer)) && ((i > ((Integer)this.mLifeCycleMap.get(this.mDomObj.getRef())).intValue()) || (i == 3)))
    {
      this.mLifeCycleMap.put(this.mDomObj.getRef(), Integer.valueOf(i));
      if (this.mDomObj.getEvents().contains(paramString))
      {
        JSONObject localJSONObject = new JSONObject();
        Object localObject;
        try
        {
          localJSONObject.put("frame", getPositionInfoRelativeToRoot(1));
        }
        catch (Exception localException)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateLifeCycle error :");
          ((StringBuilder)localObject).append(localException.getMessage());
          ViolaLogUtils.e("VComponent", ((StringBuilder)localObject).toString());
        }
        JSONArray localJSONArray = new JSONArray();
        if (getDomObject() != null)
        {
          localObject = getDomObject().getRef();
          if (localObject != null) {
            localJSONArray.put(localObject);
          }
        }
        localJSONArray.put(paramString);
        fireEvent(paramString, localJSONArray, localJSONObject);
      }
    }
  }
  
  public void updateStyle(Map<String, Object> paramMap, boolean paramBoolean)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Object localObject = (Map.Entry)paramMap.next();
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = ((Map.Entry)localObject).getValue();
        if ((paramBoolean) && ("opacity".equals(str))) {
          setOpacityWithAnimate(localObject);
        } else {
          setProperty(str, localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.baseComponent.VComponent
 * JD-Core Version:    0.7.0.1
 */