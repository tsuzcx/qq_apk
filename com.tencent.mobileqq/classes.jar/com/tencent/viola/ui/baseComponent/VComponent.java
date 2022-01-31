package com.tencent.viola.ui.baseComponent;

import android.animation.Animator;
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
import java.lang.reflect.Type;
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
  private IFComponentHolder mHolder;
  public T mHost;
  public ViolaInstance mInstance;
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
  private int mType;
  @VComponentField(nativeReturnMethod="getVisibility", propertyName="visibility")
  private String mVisibility;
  
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
    float f1 = 0.0F;
    if ((this.mAppendEvents.contains(paramString)) && (!isScrollComponent())) {
      paramView = new JSONObject();
    }
    try
    {
      paramView.put("id", getRef());
      if (getInstance() != null)
      {
        paramMotionEvent = getInstance().getLocationOnRenderContainer(new float[] { paramMotionEvent.getRawX(), paramMotionEvent.getRawY() });
        f2 = paramMotionEvent.x;
        f1 = paramMotionEvent.y;
        paramView.put("page_x", FlexConvertUtils.px2dip(f2));
        paramView.put("page_y", FlexConvertUtils.px2dip(f1));
        paramView.put("pageX", FlexConvertUtils.px2dip(f2) + "dp");
        paramView.put("pageY", FlexConvertUtils.px2dip(f1) + "dp");
        paramView.put("name", paramString);
        paramView.put("frame", getPositionInfoRelativeToParent(0));
        fireEvent(paramString, paramView);
        return;
      }
    }
    catch (JSONException paramMotionEvent)
    {
      for (;;)
      {
        paramMotionEvent.printStackTrace();
        continue;
        float f2 = 0.0F;
      }
    }
  }
  
  private void exportClickAction(String paramString)
  {
    if (!containVR(this.mDomObj)) {}
    VComponentAdapter localVComponentAdapter;
    View localView;
    do
    {
      do
      {
        return;
        localVComponentAdapter = ViolaSDKManager.getInstance().getComponentAdapter();
      } while (localVComponentAdapter == null);
      localView = getHostView();
    } while (localView == null);
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return;
      case 0: 
        localVComponentAdapter.onClick(localView, this.mDomObj.getAttributes().get("vr"));
        return;
        if (paramString.equals("click"))
        {
          i = 0;
          continue;
          if (paramString.equals("doubleClick")) {
            i = 1;
          }
        }
        break;
      }
    }
    localVComponentAdapter.onDoubleClick(localView, this.mDomObj.getAttributes().get("vr"));
  }
  
  private void fireClickAction(String paramString, MotionEvent paramMotionEvent)
  {
    float f1 = 0.0F;
    if ((this.mAppendEvents.contains(paramString)) && (this.mHost != null)) {}
    for (;;)
    {
      JSONArray localJSONArray;
      JSONObject localJSONObject;
      try
      {
        localJSONArray = new JSONArray();
        localJSONObject = new JSONObject();
        Object localObject = getPositionInfoRelativeToRoot(0);
        if (getInstance() == null) {
          break label504;
        }
        paramMotionEvent = getInstance().getLocationOnRenderContainer(new float[] { paramMotionEvent.getRawX(), paramMotionEvent.getRawY() });
        f2 = paramMotionEvent.x;
        f1 = paramMotionEvent.y;
        localJSONObject.put("pageX", FlexConvertUtils.px2dip(f2) + "dp");
        localJSONObject.put("pageY", FlexConvertUtils.px2dip(f1) + "dp");
        localJSONObject.put("frame", localObject);
        localJSONObject.put("state", "start");
        paramMotionEvent = this.mHost.getTag();
        if ((paramMotionEvent == null) || (!(paramMotionEvent instanceof HashMap))) {
          break label467;
        }
        paramMotionEvent = (HashMap)paramMotionEvent;
        localObject = paramMotionEvent.get("click");
        if ((localObject == null) || (!(localObject instanceof Map))) {
          break label324;
        }
        localObject = ((Map)localObject).entrySet().iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label358;
        }
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        localJSONObject.put(localEntry.getKey().toString(), localEntry.getValue());
        continue;
        exportClickAction(paramString);
      }
      catch (JSONException paramMotionEvent)
      {
        ViolaLogUtils.e("VComponent", "mClickEventListener JSONException e:" + paramMotionEvent.getMessage());
      }
      return;
      label324:
      if (((this.mHost instanceof VTextView)) && (((VTextView)this.mHost).mIsRich)) {
        localJSONObject.put("index", -2);
      }
      label358:
      paramMotionEvent.put("click", null);
      for (;;)
      {
        paramMotionEvent = this.mDomObj.getRef();
        if (!TextUtils.isEmpty(paramMotionEvent)) {
          localJSONArray.put(paramMotionEvent);
        }
        localJSONArray.put(paramString);
        ViolaLogUtils.d("VComponent", "mClickEventListener callData :" + localJSONArray.toString() + ", dom type = " + getDomObject().getType() + " , data " + localJSONObject.toString());
        fireEvent(paramString, localJSONArray, localJSONObject);
        break;
        label467:
        if (((this.mHost instanceof VTextView)) && (((VTextView)this.mHost).mIsRich)) {
          localJSONObject.put("index", -2);
        }
      }
      label504:
      float f2 = 0.0F;
    }
  }
  
  private void fireCommonTouchEvent(View paramView, MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
      return;
    case 0: 
      dealFireCommonTouchEvent(paramView, "touchDown", paramMotionEvent);
      return;
    case 1: 
      dealFireCommonTouchEvent(paramView, "touchUp", paramMotionEvent);
      return;
    case 2: 
      dealFireCommonTouchEvent(paramView, "touchMove", paramMotionEvent);
      return;
    }
    dealFireCommonTouchEvent(paramView, "touchCancel", paramMotionEvent);
  }
  
  private int getLifeCycleConstanceFromEvent(String paramString)
  {
    int j = 1;
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        j = 0;
      case 0: 
        return j;
        if (paramString.equals("created"))
        {
          i = 0;
          continue;
          if (paramString.equals("mounted"))
          {
            i = 1;
            continue;
            if (paramString.equals("updated"))
            {
              i = 2;
              continue;
              if (paramString.equals("destroyed")) {
                i = 3;
              }
            }
          }
        }
        break;
      }
    }
    return 2;
    return 3;
    return 4;
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
    DomObject localDomObject1 = this.mDomObj;
    int i;
    int j;
    int k;
    int m;
    int n;
    int i1;
    synchronized (DomObject.LOCK)
    {
      i = (int)localDomObject1.getLayoutX();
      j = (int)localDomObject1.getStyle().getMarginRight(750);
      k = (int)localDomObject1.getLayoutY();
      m = (int)localDomObject1.getStyle().getMarginBottom(750);
      n = (int)localDomObject1.getLayoutWidth();
      i1 = (int)localDomObject1.getLayoutHeight();
      if ((this.mPreRealWidth == n) && (this.mPreRealHeight == i1) && (this.mPreRealLeft == i) && (this.mPreRealTop == k)) {
        return;
      }
    }
    this.mPreRealWidth = n;
    this.mPreRealHeight = i1;
    this.mPreRealLeft = i;
    this.mPreRealTop = k;
    setHostLayoutParams(this.mHost, n, i1, i, j, k, m);
    calFrameXY(localDomObject2);
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
    }
    for (;;)
    {
      this.mBackgroundDrawable = null;
      return;
      localView.setBackgroundDrawable(null);
    }
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
  
  private void setLinearGradient(Object paramObject)
  {
    if ((paramObject instanceof LinearGradient)) {
      getOrCreateBorder().setImage((Shader)paramObject);
    }
  }
  
  private void setPivot(Object paramObject)
  {
    paramObject = (Pair)paramObject;
    View localView = getHostView();
    if (localView == null) {
      return;
    }
    localView.setPivotX(((Float)paramObject.first).floatValue());
    localView.setPivotY(((Float)paramObject.second).floatValue());
  }
  
  private void setTransform(Object paramObject)
  {
    View localView = getHostView();
    if (localView == null) {
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
      label68:
      int i;
      if ((paramBoolean) && (localProperty.getName().contains("scale")))
      {
        f = 1.0F;
        localObject = localProperty.getName();
        i = -1;
        switch (((String)localObject).hashCode())
        {
        }
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          break;
        case 0: 
          paramView.setRotation(f);
          break;
          if (paramBoolean)
          {
            f = 0.0F;
            break label68;
          }
          f = ((Float)((Map.Entry)localObject).getValue()).floatValue();
          break label68;
          if (((String)localObject).equals("rotation"))
          {
            i = 0;
            continue;
            if (((String)localObject).equals("rotationX"))
            {
              i = 1;
              continue;
              if (((String)localObject).equals("rotationY"))
              {
                i = 2;
                continue;
                if (((String)localObject).equals("scale"))
                {
                  i = 3;
                  continue;
                  if (((String)localObject).equals("scaleX"))
                  {
                    i = 4;
                    continue;
                    if (((String)localObject).equals("scaleY"))
                    {
                      i = 5;
                      continue;
                      if (((String)localObject).equals("translation"))
                      {
                        i = 6;
                        continue;
                        if (((String)localObject).equals("translationX"))
                        {
                          i = 7;
                          continue;
                          if (((String)localObject).equals("translationY")) {
                            i = 8;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          break;
        }
      }
      paramView.setRotationX(f);
      continue;
      paramView.setRotationY(f);
      continue;
      paramView.setScaleX(f);
      paramView.setScaleY(f);
      continue;
      paramView.setScaleX(f);
      continue;
      paramView.setScaleY(f);
      continue;
      paramView.setTranslationX(f);
      paramView.setTranslationY(f);
      continue;
      paramView.setTranslationX(f);
      continue;
      paramView.setTranslationY(f);
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
    if ((TextUtils.isEmpty(paramString)) || (this.mAppendEvents.contains(paramString)) || (getRealView() == null)) {
      return;
    }
    this.mAppendEvents.add(paramString);
  }
  
  public void addSubViewOnIntercept(ViewGroup paramViewGroup, int paramInt) {}
  
  @JSMethod
  public void animate(@NonNull JSONObject paramJSONObject1, @NonNull JSONObject paramJSONObject2, @Nullable String paramString)
  {
    if ((this.mDomObj != null) && (!TextUtils.isEmpty(this.mDomObj.getRef())) && (paramJSONObject1 != null) && (paramJSONObject2 != null) && (this.mInstance != null)) {}
    try
    {
      paramJSONObject2.put("styles", paramJSONObject1);
      if (paramJSONObject2 != null)
      {
        paramJSONObject1 = new MethodAnimation(this.mDomObj.getRef(), paramJSONObject2, paramString);
        ViolaSDKManager.getInstance().getDomManager().postActionDelay(this.mInstance.getInstanceId(), paramJSONObject1, false, 16L);
      }
      return;
    }
    catch (JSONException paramJSONObject1)
    {
      ViolaLogUtils.e("VComponent", "animate JSONException e :" + paramJSONObject1.getMessage());
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
    float[] arrayOfFloat;
    if ((Build.VERSION.SDK_INT >= 21) && (getHostView() != null))
    {
      getHostView().setOutlineProvider(null);
      getHostView().setClipToOutline(false);
      if ((getDomObject().getAttributes() != null) && (getDomObject().getAttributes().containsKey("clipChild")) && (isSetBorderRadius()))
      {
        arrayOfFloat = getOrCreateBorder().getBorderRadiusArray();
        if (arrayOfFloat[0] == 0.0F) {
          break label111;
        }
        getHostView().setOutlineProvider(new CornerViewOutlineProvider(arrayOfFloat[0], getContentHeight(), 0));
        getHostView().setClipToOutline(true);
      }
    }
    label111:
    do
    {
      return;
      if ((arrayOfFloat[1] != 0.0F) && (arrayOfFloat[1] == arrayOfFloat[2]) && (arrayOfFloat[1] != arrayOfFloat[4]))
      {
        getHostView().setOutlineProvider(new CornerViewOutlineProvider(arrayOfFloat[1], getContentHeight(), 1));
        getHostView().setClipToOutline(true);
        return;
      }
    } while ((arrayOfFloat[3] == 0.0F) || (arrayOfFloat[3] != arrayOfFloat[4]) || (arrayOfFloat[3] == arrayOfFloat[1]));
    getHostView().setOutlineProvider(new CornerViewOutlineProvider(arrayOfFloat[3], getContentHeight(), 2));
    getHostView().setClipToOutline(true);
  }
  
  protected void checkDisAppearEventFromDomobject()
  {
    float f2 = 0.0F;
    DomObject localDomObject;
    int i;
    if ((this.mDomObj.getEvents().contains("didAppear")) || (this.mDomObj.getEvents().contains("didDisappear")) || (this.mDomObj.getEvents().contains("willAppear")))
    {
      localDomObject = getDomObject();
      if ((localDomObject != null) && (localDomObject.getParent() != null) && (!"page".equals(localDomObject.getType())))
      {
        i = 0;
        if ((!"cell".equals(localDomObject.getType())) && (!"footer-cell".equals(localDomObject.getType()))) {
          break label375;
        }
        ((DomObjectCell)localDomObject).addRegisterDidAppearComponentDyStart(i, getRef());
        ((DomObjectCell)localDomObject).addRegisterDidAppearComponentDyEnd(i + getDomObject().getLayoutHeight(), getRef());
        if (!getDomObject().getAttributes().containsKey("appearScopeTop")) {
          break label421;
        }
      }
    }
    label421:
    for (float f1 = (int)FlexConvertUtils.converPxByViewportToRealPx(getDomObject().getAttributes().get("appearScopeTop"), 750);; f1 = 0.0F)
    {
      if (getDomObject().getAttributes().containsKey("appearScopeBottom")) {
        f2 = (int)FlexConvertUtils.converPxByViewportToRealPx(getDomObject().getAttributes().get("appearScopeBottom"), 750);
      }
      ((DomObjectCell)localDomObject).addRegisterDidAppearComponentDyStartOffset(f1, getRef());
      ((DomObjectCell)localDomObject).addRegisterDidAppearComponentDyEndOffset(f2, getRef());
      if (!((DomObjectCell)localDomObject).isSetComponentStaet(getRef())) {
        ((DomObjectCell)localDomObject).setComponentState(getRef(), DomObjectCell.ComponentState.DIDDISAPPEAR);
      }
      if (getDomObject().getEvents().contains("didAppear")) {
        ((DomObjectCell)localDomObject).addRegisterComponent("didAppear", getRef());
      }
      if (getDomObject().getEvents().contains("didDisappear")) {
        ((DomObjectCell)localDomObject).addRegisterComponent("didDisappear", getRef());
      }
      if (getDomObject().getEvents().contains("willAppear")) {
        ((DomObjectCell)localDomObject).addRegisterComponent("willAppear", getRef());
      }
      label375:
      do
      {
        return;
        i = (int)(i + localDomObject.getLayoutY() + localDomObject.getPadding().get(1));
        localDomObject = (DomObject)localDomObject.getParent();
      } while ((localDomObject == null) || (localDomObject.getParent() == null));
      break;
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
      createViewImpl(paramContext);
    }
  }
  
  protected void createViewImpl()
  {
    if (this.mContext != null)
    {
      this.mHost = initComponentHostView(this.mContext);
      tryCompatVR(this.mDomObj);
      if ((this.mHost == null) && (!isVirtualComponent())) {
        initView();
      }
      if (this.mHost != null) {
        this.mHost.setId(DomUtils.generateViewId());
      }
      updateLifeCycle("created");
    }
  }
  
  protected void createViewImpl(Context paramContext)
  {
    this.mContext = paramContext;
    createViewImpl();
  }
  
  public void destroy()
  {
    if ((this.mHost != null) && (this.mHost.getLayerType() == 2)) {
      this.mHost.setLayerType(0, null);
    }
    removeAllEvent();
    ViolaLogUtils.d("VComponent", "destroy component type:" + this.mDomObj.getType() + "; ref:" + this.mDomObj.getRef());
    updateLifeCycle("destroyed");
    this.mDomObj.destroy();
    this.mIsDestroyed = true;
    this.mContext = null;
    this.animationInfos.clear();
    if (this.mAlphaAnimator != null)
    {
      this.mAlphaAnimator.cancel();
      this.mAlphaAnimator = null;
    }
  }
  
  final void doRichGestrue(JSParam paramJSParam)
  {
    ViolaBridgeManager.getInstance().post(new VComponent.2(this, paramJSParam));
  }
  
  public final void fireEvent(String paramString, Object paramObject1, Object paramObject2)
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
    if (this.mContentHeight > 0) {
      return this.mContentHeight;
    }
    return (int)this.mDomObj.getLayoutHeight();
  }
  
  public int getContentWidth()
  {
    if (this.mContentWidth > 0) {
      return this.mContentWidth;
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
      localJSONObject.put("x", FlexConvertUtils.px2dip(getFrameX()) + "dp");
      localJSONObject.put("y", FlexConvertUtils.px2dip(getFrameY()) + "dp");
      localJSONObject.put("width", FlexConvertUtils.px2dip(getHostView().getWidth()) + "dp");
      localJSONObject.put("height", FlexConvertUtils.px2dip(getHostView().getHeight()) + "dp");
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  @JSMethod(uiThread=true)
  public void getFrameInfos(@Nullable String paramString)
  {
    if ((this.mDomObj != null) && (!TextUtils.isEmpty(this.mDomObj.getRef())) && (this.mInstance != null) && (this.mHost != null)) {}
    try
    {
      JSONObject localJSONObject = new JSONObject();
      Object localObject = new int[2];
      this.mHost.getLocationInWindow((int[])localObject);
      int i = localObject[0];
      int j = this.mInstance.getMatchWindowsX();
      int k = localObject[1];
      int m = this.mInstance.getMatchWindowsY();
      localObject = new int[2];
      this.mHost.getLocationOnScreen((int[])localObject);
      localJSONObject.put("pageX", FlexConvertUtils.px2dip(i - j));
      localJSONObject.put("pageY", FlexConvertUtils.px2dip(k - m));
      localJSONObject.put("screenX", FlexConvertUtils.px2dip(localObject[0]));
      localJSONObject.put("screenY", FlexConvertUtils.px2dip(localObject[1]));
      localJSONObject.put("width", FlexConvertUtils.px2dip(this.mHost.getWidth()));
      localJSONObject.put("height", FlexConvertUtils.px2dip(this.mHost.getHeight()));
      localObject = new JSONArray();
      ((JSONArray)localObject).put(paramString);
      ViolaBridgeManager.getInstance().callbackJavascript(this.mInstance.getInstanceId(), "", "callback", localObject, localJSONObject, true);
      return;
    }
    catch (JSONException paramString)
    {
      ViolaLogUtils.e("VComponent", "mLongPressListener JSONException e:" + paramString.getMessage());
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
    JSONObject localJSONObject1;
    Object localObject2;
    Map localMap;
    String str;
    for (;;)
    {
      try
      {
        localJSONObject1 = new JSONObject();
        localJSONObject1.put("ref", getRef());
        localJSONObject1.put("type", getDomObject().getType());
        localObject2 = VReflectionUtils.getFieldValueFromComponent(this, "mHost");
        localJSONObject2 = new JSONObject();
        localIterator = this.mDomObj.getStyle().entrySet().iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (Map.Entry)localIterator.next();
        localMap = VReflectionUtils.getPropertyMap(getClass());
        str = (String)((Map.Entry)localObject1).getKey();
        if (localMap.containsKey(str))
        {
          localObject1 = VReflectionUtils.getMethodValue(localObject2, (String)localMap.get(str));
          localJSONObject2.put(str, localObject1);
        }
        else
        {
          localObject1 = ((Map.Entry)localObject1).getValue();
        }
      }
      catch (JSONException paramString)
      {
        ViolaLogUtils.e("VComponent", "getNativeNodeInfo JSONException e:" + paramString.getMessage());
        return;
      }
    }
    localJSONObject1.put("style", localJSONObject2);
    JSONObject localJSONObject2 = new JSONObject();
    Iterator localIterator = this.mDomObj.getAttributes().entrySet().iterator();
    if (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      localMap = VReflectionUtils.getAttrMap(getClass());
      str = (String)((Map.Entry)localObject1).getKey();
      if (localMap.containsKey(str)) {}
      for (localObject1 = VReflectionUtils.getMethodValue(localObject2, (String)localMap.get(str));; localObject1 = ((Map.Entry)localObject1).getValue())
      {
        localJSONObject2.put(str, localObject1);
        break;
      }
    }
    localJSONObject1.put("attr", localJSONObject2);
    Object localObject1 = new JSONArray();
    int i = 0;
    for (;;)
    {
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
      i += 1;
    }
  }
  
  public BorderDrawable getOrCreateBorder()
  {
    if (this.mBackgroundDrawable == null)
    {
      this.mBackgroundDrawable = new BorderDrawable();
      if (this.mHost == null) {}
    }
    return this.mBackgroundDrawable;
  }
  
  public VComponentContainer getParent()
  {
    return this.mParent;
  }
  
  public JSONObject getPositionInfoRelativeToParent(int paramInt)
  {
    localJSONObject = new JSONObject();
    if (paramInt == 0) {}
    try
    {
      Object localObject = FlexConvertUtils.px2dip(getHostView().getX()) + "dp";
      localJSONObject.put("x", localObject);
      if (paramInt == 0)
      {
        localObject = FlexConvertUtils.px2dip(getHostView().getY()) + "dp";
        label85:
        localJSONObject.put("y", localObject);
        if (paramInt != 0) {
          break label212;
        }
        localObject = FlexConvertUtils.px2dip(getHostView().getWidth()) + "dp";
        label129:
        localJSONObject.put("width", localObject);
        if (paramInt != 0) {
          break label226;
        }
      }
      for (localObject = FlexConvertUtils.px2dip(getHostView().getHeight()) + "dp";; localObject = Integer.valueOf(paramInt))
      {
        localJSONObject.put("height", localObject);
        return localJSONObject;
        localObject = Float.valueOf(getHostView().getX());
        break;
        localObject = Float.valueOf(getHostView().getY());
        break label85;
        label212:
        localObject = Integer.valueOf(getHostView().getWidth());
        break label129;
        label226:
        paramInt = getHostView().getHeight();
      }
      return localJSONObject;
    }
    catch (Exception localException)
    {
      ViolaLogUtils.e("VComponent", "getPositionInfoRelativeToParent error = " + localException.getMessage());
      localException.printStackTrace();
    }
  }
  
  public JSONObject getPositionInfoRelativeToRoot(int paramInt)
  {
    localJSONObject = new JSONObject();
    if (this.mHost != null)
    {
      Object localObject = new int[2];
      this.mHost.getLocationInWindow((int[])localObject);
      int i = localObject[0] - this.mInstance.getMatchWindowsX();
      int j = localObject[1] - this.mInstance.getMatchWindowsY();
      if (paramInt == 0) {}
      try
      {
        localObject = FlexConvertUtils.px2dip(i) + "dp";
        localJSONObject.put("x", localObject);
        if (paramInt == 0)
        {
          localObject = FlexConvertUtils.px2dip(j) + "dp";
          label127:
          localJSONObject.put("y", localObject);
          if (paramInt != 0) {
            break label253;
          }
          localObject = FlexConvertUtils.px2dip(this.mHost.getWidth()) + "dp";
          label174:
          localJSONObject.put("width", localObject);
          if (paramInt != 0) {
            break label268;
          }
        }
        for (localObject = FlexConvertUtils.px2dip(this.mHost.getHeight()) + "dp";; localObject = Integer.valueOf(paramInt))
        {
          localJSONObject.put("height", localObject);
          return localJSONObject;
          localObject = Integer.valueOf(i);
          break;
          localObject = Integer.valueOf(j);
          break label127;
          label253:
          localObject = Integer.valueOf(this.mHost.getWidth());
          break label174;
          label268:
          paramInt = this.mHost.getHeight();
        }
        return localJSONObject;
      }
      catch (Exception localException)
      {
        ViolaLogUtils.e("VComponent", "getPositionInfoRelativeToRoot error = " + localException.getMessage());
      }
    }
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
    if ((this.mDomObj != null) && (!TextUtils.isEmpty(this.mDomObj.getRef())) && (this.mInstance != null) && (this.mHost != null)) {}
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
  
  protected T initComponentHostView(@NonNull Context paramContext)
  {
    return null;
  }
  
  public void initView() {}
  
  public final void invoke(String paramString, JSONArray paramJSONArray)
  {
    paramString = this.mHolder.getMethodInvoker(paramString);
    if (paramString != null) {}
    try
    {
      getInstance().getNativeInvokeHelper().invoke(this, paramString, paramJSONArray);
      return;
    }
    catch (Exception paramJSONArray)
    {
      ViolaLogUtils.e("VComponent", "Component] updateProperties :class:" + getClass() + "method:" + paramString.toString() + " function e" + paramJSONArray);
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
    if ((this.mLifeCycleMap.containsKey(this.mDomObj.getRef())) && ((this.mLifeCycleMap.get(this.mDomObj.getRef()) instanceof Integer))) {
      return ((Integer)this.mLifeCycleMap.get(this.mDomObj.getRef())).intValue() != 0;
    }
    return false;
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
    if (this.mInstance == null) {
      return false;
    }
    return this.mInstance.isLayerTypeEnabled();
  }
  
  public boolean isLazy()
  {
    if (this.mLazy) {}
    while ((this.mParent != null) && (this.mParent.isLazy())) {
      return true;
    }
    return false;
  }
  
  public boolean isMounted()
  {
    if ((this.mLifeCycleMap.containsKey(this.mDomObj.getRef())) && ((this.mLifeCycleMap.get(this.mDomObj.getRef()) instanceof Integer))) {
      return (2 == ((Integer)this.mLifeCycleMap.get(this.mDomObj.getRef())).intValue()) || (3 == ((Integer)this.mLifeCycleMap.get(this.mDomObj.getRef())).intValue());
    }
    return false;
  }
  
  public boolean isReuse()
  {
    return true;
  }
  
  public boolean isSetBorderRadius()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (getDomObject() != null)
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
    return this.mNeedInterceptTouchEvent;
  }
  
  public void notifyChange()
  {
    if (this.mParent != null) {
      this.mParent.notifyChange();
    }
  }
  
  public void notifyChange(int paramInt, String paramString)
  {
    if (this.mParent != null) {
      this.mParent.notifyChange(paramInt, paramString);
    }
  }
  
  public void notifyNativeBgColorChanged(int paramInt)
  {
    if (!this.mNeedLayoutOnAnimation) {}
    for (;;)
    {
      return;
      if ((this.mInstance != null) && (!isDestroyed()))
      {
        Object localObject = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("backgroundColor", String.format("#%06X", new Object[] { Integer.valueOf(0xFFFFFF & paramInt) }));
          localJSONObject.put("style", localObject);
          localObject = new MethodUpdateElement(getRef(), localJSONObject);
          if ((localObject instanceof DOMAction))
          {
            ViolaSDKManager.getInstance().getDomManager().postAction(this.mInstance.getInstanceId(), (DOMAction)localObject, false);
            return;
          }
        }
        catch (JSONException localJSONException) {}
      }
    }
  }
  
  public void notifyNativeSizeChanged(int paramInt1, int paramInt2)
  {
    if (!this.mNeedLayoutOnAnimation) {}
    for (;;)
    {
      return;
      if ((this.mInstance != null) && (!isDestroyed()))
      {
        Object localObject = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        float f1 = FlexConvertUtils.px2dip(paramInt1);
        float f2 = FlexConvertUtils.px2dip(paramInt2);
        try
        {
          ((JSONObject)localObject).put("width", f1 + "dp");
          ((JSONObject)localObject).put("height", f2 + "dp");
          localJSONObject.put("style", localObject);
          localObject = new MethodUpdateElement(getRef(), localJSONObject);
          if ((localObject instanceof DOMAction))
          {
            ViolaSDKManager.getInstance().getDomManager().postAction(this.mInstance.getInstanceId(), (DOMAction)localObject, false);
            return;
          }
        }
        catch (JSONException localJSONException) {}
      }
    }
  }
  
  public void notifyWhenChange(String paramString, DomObject paramDomObject)
  {
    if (this.mParent != null) {
      this.mParent.notifyWhenChange(paramString, paramDomObject);
    }
  }
  
  public boolean onActivityBack()
  {
    ViolaLogUtils.d("VComponent", "life onActivityBack ref:" + getRef());
    return false;
  }
  
  @Deprecated
  public void onActivityCreate()
  {
    ViolaLogUtils.d("VComponent", "life onActivityCreate ref:" + getRef());
  }
  
  public void onActivityDestroy()
  {
    ViolaLogUtils.d("VComponent", "life onActivityDestroy ref:" + getRef());
  }
  
  public void onActivityPause()
  {
    ViolaLogUtils.d("VComponent", "life onActivityPause ref:" + getRef());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    ViolaLogUtils.d("VComponent", "life onActivityResult : requestCode:" + paramInt1 + "; resultCode :" + paramInt2);
  }
  
  public void onActivityResume()
  {
    ViolaLogUtils.d("VComponent", "life onActivityResume ref:" + getRef());
  }
  
  public void onActivityStart()
  {
    ViolaLogUtils.d("VComponent", "life onActivityStart ref:" + getRef());
  }
  
  public void onActivityStop()
  {
    ViolaLogUtils.d("VComponent", "life onActivityStop ref:" + getRef());
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
  
  public void onRichGestureScroll(int paramInt1, int paramInt2)
  {
    if (this.mAssocioationEvents == null) {
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("x", FlexConvertUtils.px2dip(paramInt1) + "dp");
      localJSONObject.put("y", FlexConvertUtils.px2dip(paramInt2) + "dp");
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
    if ((this.mDomObj == null) || (this.mDomObj.getEvents().size() < 1)) {}
    do
    {
      return;
      this.mAppendEvents.clear();
    } while (this.mHost == null);
    this.mHost.setOnFocusChangeListener(null);
    this.mHost.setOnTouchListener(null);
  }
  
  public void removeAnimationInfo(VComponent.AnimationInfo paramAnimationInfo)
  {
    this.animationInfos.remove(paramAnimationInfo);
  }
  
  protected boolean removeEvent(String paramString)
  {
    ViolaLogUtils.d("VComponent", "removeEvent: " + paramString);
    if ((TextUtils.isEmpty(paramString)) || (!this.mAppendEvents.contains(paramString)) || (this.mHost == null)) {}
    do
    {
      return true;
      this.mAppendEvents.remove(paramString);
      if (paramString.equals("click"))
      {
        this.mHost.setOnTouchListener(null);
        return true;
      }
    } while (!paramString.equals("longPress"));
    this.mHost.setOnTouchListener(null);
    return true;
  }
  
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
    if ((paramAnimator == null) || (paramAnimationBean == null) || (paramAnimationBean.styles == null)) {}
    do
    {
      return;
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
    } while (TextUtils.isEmpty(paramAnimationBean.styles.transform));
    paramAnimator.setScaleX(1.0F);
    paramAnimator.setScaleY(1.0F);
    paramAnimator.setRotation(0.0F);
    paramAnimator.setRotationX(0.0F);
    paramAnimator.setRotationY(0.0F);
    paramAnimator.setTranslationX(0.0F);
    paramAnimator.setTranslationY(0.0F);
  }
  
  protected boolean resetAttr(String paramString)
  {
    ViolaLogUtils.d("VComponent", "resetAttr: " + paramString);
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
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
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
        return;
      }
    }
    catch (Exception localException) {}
  }
  
  public final void resetEvents(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        removeEvent((String)paramList.next());
      }
    }
  }
  
  protected boolean resetStyle(String paramString)
  {
    boolean bool = true;
    ViolaLogUtils.d("VComponent", "resetStyle: " + paramString);
    int i = -1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        bool = false;
      }
      break;
    }
    do
    {
      do
      {
        do
        {
          return bool;
          if (!paramString.equals("borderWidth")) {
            break;
          }
          i = 0;
          break;
          if (!paramString.equals("borderLeftWidth")) {
            break;
          }
          i = 1;
          break;
          if (!paramString.equals("borderTopWidth")) {
            break;
          }
          i = 2;
          break;
          if (!paramString.equals("borderRightWidth")) {
            break;
          }
          i = 3;
          break;
          if (!paramString.equals("borderBottomWidth")) {
            break;
          }
          i = 4;
          break;
          if (!paramString.equals("borderColor")) {
            break;
          }
          i = 5;
          break;
          if (!paramString.equals("borderLeftColor")) {
            break;
          }
          i = 6;
          break;
          if (!paramString.equals("borderTopColor")) {
            break;
          }
          i = 7;
          break;
          if (!paramString.equals("borderRightColor")) {
            break;
          }
          i = 8;
          break;
          if (!paramString.equals("borderBottomColor")) {
            break;
          }
          i = 9;
          break;
          if (!paramString.equals("borderStyle")) {
            break;
          }
          i = 10;
          break;
          if (!paramString.equals("borderLeftStyle")) {
            break;
          }
          i = 11;
          break;
          if (!paramString.equals("borderTopStyle")) {
            break;
          }
          i = 12;
          break;
          if (!paramString.equals("borderRightStyle")) {
            break;
          }
          i = 13;
          break;
          if (!paramString.equals("borderBottomStyle")) {
            break;
          }
          i = 14;
          break;
          if (!paramString.equals("backgroundColor")) {
            break;
          }
          i = 15;
          break;
          if (!paramString.equals("borderRadius")) {
            break;
          }
          i = 16;
          break;
          if (!paramString.equals("borderTopLeftRadius")) {
            break;
          }
          i = 17;
          break;
          if (!paramString.equals("borderTopRightRadius")) {
            break;
          }
          i = 18;
          break;
          if (!paramString.equals("borderBottomLeftRadius")) {
            break;
          }
          i = 19;
          break;
          if (!paramString.equals("borderBottomRightRadius")) {
            break;
          }
          i = 20;
          break;
          if (!paramString.equals("opacity")) {
            break;
          }
          i = 21;
          break;
          if (!paramString.equals("visibility")) {
            break;
          }
          i = 22;
          break;
          if (!paramString.equals("transform_origin_parse")) {
            break;
          }
          i = 23;
          break;
          if (!paramString.equals("transform_parse")) {
            break;
          }
          i = 24;
          break;
          if (!paramString.equals("background_image_parse")) {
            break;
          }
          i = 25;
          break;
          if (!paramString.equals("rotation")) {
            break;
          }
          i = 26;
          break;
          resetBackground();
          return true;
          setBorderRadius(0, 0.0F);
          resetBackground();
          return true;
          setBoderTopLeftRadius(0.0F);
          resetBackground();
          return true;
          setBoderTopRightRadius(0.0F);
          resetBackground();
          return true;
          setBoderBottomLeftRadius(0.0F);
          resetBackground();
          return true;
          setBoderBottomRightRadius(0.0F);
          resetBackground();
          return true;
        } while (this.mHost == null);
        this.mHost.setAlpha(1.0F);
        return true;
      } while (this.mHost == null);
      getHostView().setVisibility(0);
      return true;
      resetTransformOrigin();
      return true;
      resetTransform();
      return true;
      resetBackgroundImage();
      return true;
      paramString = getHostView();
    } while (paramString == null);
    paramString.setRotation(0.0F);
    return true;
  }
  
  public final void resetStyles(List<String> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      resetStyle((String)paramList.next());
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
    float[] arrayOfFloat;
    if (getHostView() != null)
    {
      if (this.mBackgroundDrawable != null) {
        this.mBackgroundDrawable.invalidateSelf();
      }
      if (Build.VERSION.SDK_INT < 16) {
        break label128;
      }
      getHostView().setBackground(this.mBackgroundDrawable);
      if ((getDomObject().getAttributes() != null) && (getDomObject().getAttributes().containsKey("clipChild")) && (isSetBorderRadius()) && (Build.VERSION.SDK_INT >= 21))
      {
        arrayOfFloat = getOrCreateBorder().getBorderRadiusArray();
        if (arrayOfFloat[0] == 0.0F) {
          break label142;
        }
        getHostView().setOutlineProvider(new CornerViewOutlineProvider(arrayOfFloat[0], getContentHeight(), 0));
        getHostView().setClipToOutline(true);
      }
    }
    label128:
    label142:
    do
    {
      return;
      getHostView().setBackgroundDrawable(this.mBackgroundDrawable);
      break;
      if ((arrayOfFloat[1] != 0.0F) && (arrayOfFloat[1] == arrayOfFloat[2]) && (arrayOfFloat[1] != arrayOfFloat[4]))
      {
        getHostView().setOutlineProvider(new CornerViewOutlineProvider(arrayOfFloat[1], getContentHeight(), 1));
        getHostView().setClipToOutline(true);
        return;
      }
    } while ((arrayOfFloat[3] == 0.0F) || (arrayOfFloat[3] != arrayOfFloat[4]) || (arrayOfFloat[3] == arrayOfFloat[1]));
    getHostView().setOutlineProvider(new CornerViewOutlineProvider(arrayOfFloat[3], getContentHeight(), 2));
    getHostView().setClipToOutline(true);
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
    if (this.mHost == null) {
      return;
    }
    if (this.mParent == null)
    {
      paramT = new FrameLayout.LayoutParams(paramInt1, paramInt2);
      paramT.setMargins(paramInt3, paramInt5, paramInt4, paramInt6);
      label37:
      if (paramT != null) {
        this.mHost.setLayoutParams(paramT);
      }
    }
    else
    {
      if ((!(this.mHost instanceof VTextView)) || (!((VTextView)this.mHost).mIsRich)) {
        break label110;
      }
      paramInt2 += 5;
    }
    label110:
    for (;;)
    {
      paramT = this.mParent.getChildLayoutParams(this, paramT, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6);
      setContentHeight(paramInt2);
      setContentWidth(paramInt1);
      break label37;
      break;
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
    if ((f < 0.0F) || (f > 1.0F)) {}
    do
    {
      return;
      paramObject = getHostView();
    } while ((paramObject == null) || (paramObject.getAlpha() == f) || (this.mDomObj == null) || (!this.mDomObj.getAttributes().containsKey("animationDuration")));
    int i = ViolaUtils.getInt(this.mDomObj.getAttributes().get("animationDuration"));
    this.mAlphaAnimator = paramObject.animate().alpha(f).setDuration(i);
    this.mAlphaAnimator.start();
  }
  
  protected boolean setProperty(String paramString, Object paramObject)
  {
    boolean bool2 = true;
    int i = -1;
    boolean bool1;
    switch (paramString.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        bool1 = false;
      }
      break;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    do
                                    {
                                      do
                                      {
                                        do
                                        {
                                          do
                                          {
                                            do
                                            {
                                              do
                                              {
                                                return bool1;
                                                if (!paramString.equals("backgroundColor")) {
                                                  break;
                                                }
                                                i = 0;
                                                break;
                                                if (!paramString.equals("borderWidth")) {
                                                  break;
                                                }
                                                i = 1;
                                                break;
                                                if (!paramString.equals("borderLeftWidth")) {
                                                  break;
                                                }
                                                i = 2;
                                                break;
                                                if (!paramString.equals("borderTopWidth")) {
                                                  break;
                                                }
                                                i = 3;
                                                break;
                                                if (!paramString.equals("borderRightWidth")) {
                                                  break;
                                                }
                                                i = 4;
                                                break;
                                                if (!paramString.equals("borderBottomWidth")) {
                                                  break;
                                                }
                                                i = 5;
                                                break;
                                                if (!paramString.equals("borderColor")) {
                                                  break;
                                                }
                                                i = 6;
                                                break;
                                                if (!paramString.equals("borderLeftColor")) {
                                                  break;
                                                }
                                                i = 7;
                                                break;
                                                if (!paramString.equals("borderTopColor")) {
                                                  break;
                                                }
                                                i = 8;
                                                break;
                                                if (!paramString.equals("borderRightColor")) {
                                                  break;
                                                }
                                                i = 9;
                                                break;
                                                if (!paramString.equals("borderBottomColor")) {
                                                  break;
                                                }
                                                i = 10;
                                                break;
                                                if (!paramString.equals("borderStyle")) {
                                                  break;
                                                }
                                                i = 11;
                                                break;
                                                if (!paramString.equals("borderLeftStyle")) {
                                                  break;
                                                }
                                                i = 12;
                                                break;
                                                if (!paramString.equals("borderTopStyle")) {
                                                  break;
                                                }
                                                i = 13;
                                                break;
                                                if (!paramString.equals("borderRightStyle")) {
                                                  break;
                                                }
                                                i = 14;
                                                break;
                                                if (!paramString.equals("borderBottomStyle")) {
                                                  break;
                                                }
                                                i = 15;
                                                break;
                                                if (!paramString.equals("borderRadius")) {
                                                  break;
                                                }
                                                i = 16;
                                                break;
                                                if (!paramString.equals("opacity")) {
                                                  break;
                                                }
                                                i = 17;
                                                break;
                                                if (!paramString.equals("borderTopLeftRadius")) {
                                                  break;
                                                }
                                                i = 18;
                                                break;
                                                if (!paramString.equals("borderTopRightRadius")) {
                                                  break;
                                                }
                                                i = 19;
                                                break;
                                                if (!paramString.equals("borderBottomLeftRadius")) {
                                                  break;
                                                }
                                                i = 20;
                                                break;
                                                if (!paramString.equals("borderBottomRightRadius")) {
                                                  break;
                                                }
                                                i = 21;
                                                break;
                                                if (!paramString.equals("visibility")) {
                                                  break;
                                                }
                                                i = 22;
                                                break;
                                                if (!paramString.equals("rotation")) {
                                                  break;
                                                }
                                                i = 23;
                                                break;
                                                if (!paramString.equals("transform_origin_parse")) {
                                                  break;
                                                }
                                                i = 24;
                                                break;
                                                if (!paramString.equals("transform_parse")) {
                                                  break;
                                                }
                                                i = 25;
                                                break;
                                                if (!paramString.equals("topIndex")) {
                                                  break;
                                                }
                                                i = 26;
                                                break;
                                                if (!paramString.equals("background_image_parse")) {
                                                  break;
                                                }
                                                i = 27;
                                                break;
                                                paramString = ViolaUtils.getString(paramObject, null);
                                                bool1 = bool2;
                                              } while (paramString == null);
                                              setBackgroundColor(paramString);
                                              return true;
                                              setBorderWidth(0, FlexConvertUtils.getFloatByViewport(paramObject, getDomObject().getViewPortWidth()));
                                              return true;
                                              setBorderWidth(1, FlexConvertUtils.converPxByViewportToRealPx(paramObject, getDomObject().getViewPortWidth()));
                                              return true;
                                              setBorderWidth(2, FlexConvertUtils.converPxByViewportToRealPx(paramObject, getDomObject().getViewPortWidth()));
                                              return true;
                                              setBorderWidth(3, FlexConvertUtils.converPxByViewportToRealPx(paramObject, getDomObject().getViewPortWidth()));
                                              return true;
                                              setBorderWidth(4, FlexConvertUtils.converPxByViewportToRealPx(paramObject, getDomObject().getViewPortWidth()));
                                              return true;
                                              paramString = ViolaUtils.getString(paramObject, null);
                                              bool1 = bool2;
                                            } while (paramString == null);
                                            setBorderColor(0, paramString);
                                            return true;
                                            paramString = ViolaUtils.getString(paramObject, null);
                                            bool1 = bool2;
                                          } while (paramString == null);
                                          setBorderColor(1, paramString);
                                          return true;
                                          paramString = ViolaUtils.getString(paramObject, null);
                                          bool1 = bool2;
                                        } while (paramString == null);
                                        setBorderColor(2, paramString);
                                        return true;
                                        paramString = ViolaUtils.getString(paramObject, null);
                                        bool1 = bool2;
                                      } while (paramString == null);
                                      setBorderColor(3, paramString);
                                      return true;
                                      paramString = ViolaUtils.getString(paramObject, null);
                                      bool1 = bool2;
                                    } while (paramString == null);
                                    setBorderColor(4, paramString);
                                    return true;
                                    paramString = ViolaUtils.getString(paramObject, null);
                                    bool1 = bool2;
                                  } while (paramString == null);
                                  setBorderStyle(0, paramString);
                                  return true;
                                  paramString = ViolaUtils.getString(paramObject, null);
                                  bool1 = bool2;
                                } while (paramString == null);
                                setBorderStyle(1, paramString);
                                return true;
                                paramString = ViolaUtils.getString(paramObject, null);
                                bool1 = bool2;
                              } while (paramString == null);
                              setBorderStyle(2, paramString);
                              return true;
                              paramString = ViolaUtils.getString(paramObject, null);
                              bool1 = bool2;
                            } while (paramString == null);
                            setBorderStyle(3, paramString);
                            return true;
                            paramString = ViolaUtils.getString(paramObject, null);
                            bool1 = bool2;
                          } while (paramString == null);
                          setBorderStyle(4, paramString);
                          return true;
                          paramString = ViolaUtils.getString(paramObject, null);
                          bool1 = bool2;
                        } while (paramString == null);
                        setBorderRadius(0, FlexConvertUtils.getFloatByViewport(paramString, getDomObject().getViewPortWidth()));
                        return true;
                        paramString = Float.valueOf(ViolaUtils.getFloat(paramObject, Float.valueOf(-1.0F)));
                        bool1 = bool2;
                      } while (paramString == null);
                      bool1 = bool2;
                    } while (paramString.equals(Float.valueOf(-1.0F)));
                    setOpacity(paramString.floatValue());
                    return true;
                    paramString = ViolaUtils.getString(paramObject, null);
                    bool1 = bool2;
                  } while (paramString == null);
                  setBoderTopLeftRadius(FlexConvertUtils.getFloatByViewport(paramString, getDomObject().getViewPortWidth()));
                  return true;
                  paramString = ViolaUtils.getString(paramObject, null);
                  bool1 = bool2;
                } while (paramString == null);
                setBoderTopRightRadius(FlexConvertUtils.getFloatByViewport(paramString, getDomObject().getViewPortWidth()));
                return true;
                paramString = ViolaUtils.getString(paramObject, null);
                bool1 = bool2;
              } while (paramString == null);
              setBoderBottomLeftRadius(FlexConvertUtils.getFloatByViewport(paramString, getDomObject().getViewPortWidth()));
              return true;
              paramString = ViolaUtils.getString(paramObject, null);
              bool1 = bool2;
            } while (paramString == null);
            setBoderBottomRightRadius(FlexConvertUtils.getFloatByViewport(paramString, getDomObject().getViewPortWidth()));
            return true;
            bool1 = bool2;
          } while (getHostView() == null);
          this.mVisibility = ViolaUtils.getString(paramObject, "visible");
          if ("visible".equals(this.mVisibility))
          {
            getHostView().setVisibility(0);
            return true;
          }
          getHostView().setVisibility(4);
          return true;
          float f = ViolaUtils.getFloat(paramObject, Float.valueOf(90.0F));
          getHostView().setRotation(f);
          return true;
          setPivot(paramObject);
          return true;
          setTransform(paramObject);
          return true;
          bool1 = bool2;
        } while (!Boolean.valueOf(ViolaUtils.getBoolean(paramObject)).booleanValue());
        bool1 = bool2;
      } while (getHostView() == null);
      bool1 = bool2;
    } while (getInstance() == null);
    getInstance().getViolaPageListener().onComponentTopIndex(getHostView(), getDomObject().getLayoutHeight());
    return true;
    setLinearGradient(paramObject);
    return true;
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
    if ((localObject == null) || (this.mDomObj == null)) {}
    do
    {
      do
      {
        return;
        localObject = ViolaUtils.getDomActionContext(((ViolaInstance)localObject).getInstanceId());
      } while (localObject == null);
      ((DOMActionContext)localObject).unregisterComponent(this.mDomObj.getRef());
    } while (!paramBoolean);
    ((DOMActionContext)localObject).unregisterDOMObject(this.mDomObj.getRef());
  }
  
  public void updateAttrs(Map<String, Object> paramMap)
  {
    if (paramMap != null) {
      paramMap = paramMap.entrySet().iterator();
    }
    for (;;)
    {
      if (paramMap.hasNext())
      {
        Object localObject1 = (Map.Entry)paramMap.next();
        localObject2 = (String)((Map.Entry)localObject1).getKey();
        localObject1 = ((Map.Entry)localObject1).getValue();
        if (setProperty((String)localObject2, localObject1)) {
          continue;
        }
        if (this.mHolder != null) {}
      }
      else
      {
        return;
      }
      Object localObject2 = this.mHolder.getPropertyInvoker((String)localObject2);
      if (localObject2 != null)
      {
        Type[] arrayOfType;
        try
        {
          arrayOfType = ((Invoker)localObject2).getParameterTypes();
          if (arrayOfType.length == 1) {
            break label183;
          }
          ViolaLogUtils.e("VComponent", "[VComponent] setX method only one parameter：" + localObject2);
          return;
        }
        catch (Exception localException)
        {
          ViolaLogUtils.e("VComponent", "[VComponent] updateProperties :class:" + getClass() + "method:" + localObject2.toString() + " function " + ViolaLogUtils.getStackTrace(localException));
        }
        continue;
        label183:
        ((Invoker)localObject2).invoke(this, new Object[] { VReflectionUtils.parseArgument(arrayOfType[0], localException) });
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
    JSONObject localJSONObject;
    if ((this.mLifeCycleMap.containsKey(this.mDomObj.getRef())) && ((this.mLifeCycleMap.get(this.mDomObj.getRef()) instanceof Integer)) && ((i > ((Integer)this.mLifeCycleMap.get(this.mDomObj.getRef())).intValue()) || (i == 3)))
    {
      this.mLifeCycleMap.put(this.mDomObj.getRef(), Integer.valueOf(i));
      if (this.mDomObj.getEvents().contains(paramString)) {
        localJSONObject = new JSONObject();
      }
    }
    try
    {
      localJSONObject.put("frame", getPositionInfoRelativeToRoot(1));
      JSONArray localJSONArray = new JSONArray();
      if (getDomObject() != null)
      {
        String str = getDomObject().getRef();
        if (str != null) {
          localJSONArray.put(str);
        }
      }
      localJSONArray.put(paramString);
      fireEvent(paramString, localJSONArray, localJSONObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ViolaLogUtils.e("VComponent", "updateLifeCycle error :" + localException.getMessage());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.baseComponent.VComponent
 * JD-Core Version:    0.7.0.1
 */