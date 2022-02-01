package com.tencent.mtt.hippy.uimanager;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.common.HippyTag;
import com.tencent.mtt.hippy.dom.node.StyleNode;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.common.CommonBorder;
import com.tencent.mtt.hippy.views.common.CommonBorder.BorderRadiusDirection;
import com.tencent.mtt.hippy.views.common.CommonBorder.BorderWidthDirection;
import com.tencent.mtt.hippy.views.view.HippyViewGroupController;
import java.util.Map;

public abstract class HippyViewController<T extends View,  extends HippyViewBase>
  implements View.OnFocusChangeListener
{
  private static final String TAG = "HippyViewController";
  private static f.a sMatrixDecompositionContext = new f.a();
  private static double[] sTransformDecompositionArray = new double[16];
  private boolean bUserChageFocus = false;
  
  private void applyTransform(T paramT, HippyArray paramHippyArray)
  {
    j.a(paramHippyArray, sTransformDecompositionArray);
    sMatrixDecompositionContext.a();
    f.a(sTransformDecompositionArray, sMatrixDecompositionContext);
    paramT.setTranslationX(PixelUtil.dp2px((float)sMatrixDecompositionContext.e[0]));
    paramT.setTranslationY(PixelUtil.dp2px((float)sMatrixDecompositionContext.e[1]));
    paramT.setRotation((float)sMatrixDecompositionContext.f[2]);
    paramT.setRotationX((float)sMatrixDecompositionContext.f[0]);
    paramT.setRotationY((float)sMatrixDecompositionContext.f[1]);
    paramT.setScaleX((float)sMatrixDecompositionContext.c[0]);
    paramT.setScaleY((float)sMatrixDecompositionContext.c[1]);
  }
  
  public static void resetTransform(View paramView)
  {
    paramView.setTranslationX(0.0F);
    paramView.setTranslationY(0.0F);
    paramView.setRotation(0.0F);
    paramView.setRotationX(0.0F);
    paramView.setRotationY(0.0F);
    paramView.setScaleX(1.0F);
    paramView.setScaleY(1.0F);
  }
  
  protected void addView(ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    int i = paramInt;
    if (paramInt > paramViewGroup.getChildCount()) {
      i = paramViewGroup.getChildCount();
    }
    try
    {
      paramViewGroup.addView(paramView, i);
      return;
    }
    catch (Exception paramViewGroup)
    {
      paramViewGroup.printStackTrace();
    }
  }
  
  protected StyleNode createNode(boolean paramBoolean)
  {
    return new StyleNode();
  }
  
  public RenderNode createRenderNode(int paramInt, HippyMap paramHippyMap, String paramString, HippyRootView paramHippyRootView, ControllerManager paramControllerManager, boolean paramBoolean)
  {
    return new RenderNode(paramInt, paramHippyMap, paramString, paramHippyRootView, paramControllerManager, paramBoolean);
  }
  
  public View createView(HippyRootView paramHippyRootView, int paramInt, HippyEngineContext paramHippyEngineContext, String paramString, HippyMap paramHippyMap)
  {
    if (paramHippyRootView != null)
    {
      paramHippyEngineContext = paramHippyRootView.getContext();
      if ((paramHippyEngineContext instanceof HippyInstanceContext))
      {
        paramHippyEngineContext = ((HippyInstanceContext)paramHippyEngineContext).getNativeParams();
        if (paramHippyEngineContext != null)
        {
          paramHippyEngineContext = paramHippyEngineContext.get("CustomViewCreator");
          if (!(paramHippyEngineContext instanceof HippyCustomViewCreator)) {}
        }
      }
      for (View localView = ((HippyCustomViewCreator)paramHippyEngineContext).createCustomView(paramString, paramHippyRootView.getContext(), paramHippyMap);; localView = null)
      {
        paramHippyEngineContext = localView;
        if (localView == null)
        {
          localView = createViewImpl(paramHippyRootView.getContext(), paramHippyMap);
          paramHippyEngineContext = localView;
          if (localView == null) {
            paramHippyEngineContext = createViewImpl(paramHippyRootView.getContext());
          }
        }
        LogUtils.d("HippyViewController", "createView id " + paramInt);
        paramHippyEngineContext.setId(paramInt);
        paramHippyEngineContext.setTag(HippyTag.createTagMap(paramString, paramHippyMap));
        return paramHippyEngineContext;
      }
    }
    return null;
  }
  
  @Deprecated
  protected abstract View createViewImpl(Context paramContext);
  
  protected View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    return null;
  }
  
  protected void deleteChild(ViewGroup paramViewGroup, View paramView)
  {
    paramViewGroup.removeView(paramView);
  }
  
  protected void deleteChild(ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    deleteChild(paramViewGroup, paramView);
  }
  
  public void dispatchFunction(T paramT, String paramString, HippyArray paramHippyArray) {}
  
  public void dispatchFunction(T paramT, String paramString, HippyArray paramHippyArray, Promise paramPromise) {}
  
  public View getChildAt(T paramT, int paramInt)
  {
    if ((paramT instanceof ViewGroup)) {
      return ((ViewGroup)paramT).getChildAt(paramInt);
    }
    return null;
  }
  
  public int getChildCount(T paramT)
  {
    if ((paramT instanceof ViewGroup)) {
      return ((ViewGroup)paramT).getChildCount();
    }
    return 0;
  }
  
  protected boolean handleGestureBySelf()
  {
    return false;
  }
  
  public void onAfterUpdateProps(T paramT) {}
  
  public void onBatchComplete(T paramT) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (this.bUserChageFocus)
    {
      HippyMap localHippyMap = new HippyMap();
      localHippyMap.pushBoolean("focus", paramBoolean);
      new HippyViewEvent("onFocus").send(paramView, localHippyMap);
    }
  }
  
  protected void onManageChildComplete(T paramT) {}
  
  public void onViewDestroy(T paramT) {}
  
  @HippyControllerProps(defaultType="boolean", name="requestFocus")
  public void requestFocus(T paramT, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Looper.getMainLooper();
      Looper.myQueue().addIdleHandler(new HippyViewController.1(this, paramT));
    }
  }
  
  @HippyControllerProps(name="accessibilityLabel")
  public void setAccessibilityLabel(T paramT, String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramT.setContentDescription(str);
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onAttachedToWindow")
  public void setAttachedToWindowHandle(T paramT, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramT.addOnAttachStateChangeListener(NativeGestureDispatcher.getOnAttachedToWindowListener());
      return;
    }
    paramT.removeOnAttachStateChangeListener(NativeGestureDispatcher.getOnAttachedToWindowListener());
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="backgroundColor")
  public void setBackground(T paramT, int paramInt)
  {
    paramT.setBackgroundColor(paramInt);
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="borderBottomColor")
  public void setBorderBottomWidth(T paramT, int paramInt)
  {
    if ((paramT instanceof CommonBorder)) {
      ((CommonBorder)paramT).setBorderColor(paramInt, CommonBorder.BorderWidthDirection.BOTTOM.ordinal());
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="borderColor")
  public void setBorderColor(T paramT, int paramInt)
  {
    if ((paramT instanceof CommonBorder)) {
      ((CommonBorder)paramT).setBorderColor(paramInt, CommonBorder.BorderWidthDirection.ALL.ordinal());
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="borderLeftColor")
  public void setBorderLeftColor(T paramT, int paramInt)
  {
    if ((paramT instanceof CommonBorder)) {
      ((CommonBorder)paramT).setBorderColor(paramInt, CommonBorder.BorderWidthDirection.LEFT.ordinal());
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="borderRadius")
  public void setBorderRadius(T paramT, float paramFloat)
  {
    if ((paramT instanceof CommonBorder)) {
      ((CommonBorder)paramT).setBorderRadius(paramFloat, CommonBorder.BorderRadiusDirection.ALL.ordinal());
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="borderRightColor")
  public void setBorderRightWidth(T paramT, int paramInt)
  {
    if ((paramT instanceof CommonBorder)) {
      ((CommonBorder)paramT).setBorderColor(paramInt, CommonBorder.BorderWidthDirection.RIGHT.ordinal());
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="borderTopColor")
  public void setBorderTopWidth(T paramT, int paramInt)
  {
    if ((paramT instanceof CommonBorder)) {
      ((CommonBorder)paramT).setBorderColor(paramInt, CommonBorder.BorderWidthDirection.TOP.ordinal());
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="borderWidth")
  public void setBorderWidth(T paramT, float paramFloat)
  {
    if ((paramT instanceof CommonBorder)) {
      ((CommonBorder)paramT).setBorderWidth(paramFloat, CommonBorder.BorderWidthDirection.ALL.ordinal());
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="borderBottomWidth")
  public void setBottomBorderWidth(T paramT, float paramFloat)
  {
    if ((paramT instanceof CommonBorder)) {
      ((CommonBorder)paramT).setBorderWidth(paramFloat, CommonBorder.BorderWidthDirection.BOTTOM.ordinal());
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="borderBottomLeftRadius")
  public void setBottomLeftBorderRadius(T paramT, float paramFloat)
  {
    if ((paramT instanceof CommonBorder)) {
      ((CommonBorder)paramT).setBorderRadius(paramFloat, CommonBorder.BorderRadiusDirection.BOTTOM_LEFT.ordinal());
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="borderBottomRightRadius")
  public void setBottomRightBorderRadius(T paramT, float paramFloat)
  {
    if ((paramT instanceof CommonBorder)) {
      ((CommonBorder)paramT).setBorderRadius(paramFloat, CommonBorder.BorderRadiusDirection.BOTTOM_RIGHT.ordinal());
    }
  }
  
  @HippyControllerProps(defaultType="boolean", name="onClick")
  public void setClickable(T paramT, boolean paramBoolean)
  {
    if (!handleGestureBySelf())
    {
      if (paramBoolean) {
        paramT.setOnClickListener(NativeGestureDispatcher.getOnClickListener());
      }
    }
    else {
      return;
    }
    paramT.setOnClickListener(null);
    paramT.setClickable(false);
  }
  
  @HippyControllerProps(name="customProp")
  public void setCustomProp(T paramT, String paramString, Object paramObject) {}
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onDetachedFromWindow")
  public void setDetachedFromWindowHandle(T paramT, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramT.addOnAttachStateChangeListener(NativeGestureDispatcher.getOnDetachedFromWindowListener());
      return;
    }
    paramT.removeOnAttachStateChangeListener(NativeGestureDispatcher.getOnDetachedFromWindowListener());
  }
  
  @HippyControllerProps(defaultType="boolean", name="focusable")
  public void setFocusable(T paramT, boolean paramBoolean)
  {
    paramT.setFocusable(paramBoolean);
    if (paramBoolean)
    {
      paramT.setOnFocusChangeListener(this);
      return;
    }
    paramT.setOnFocusChangeListener(null);
  }
  
  protected void setGestureType(T paramT, String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (((HippyViewBase)paramT).getGestureDispatcher() == null) {
        ((HippyViewBase)paramT).setGestureDispatcher(new NativeGestureDispatcher(paramT));
      }
      ((HippyViewBase)paramT).getGestureDispatcher().addGestureType(paramString);
    }
    while (((HippyViewBase)paramT).getGestureDispatcher() == null) {
      return;
    }
    ((HippyViewBase)paramT).getGestureDispatcher().removeGestureType(paramString);
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="borderLeftWidth")
  public void setLeftBorderWidth(T paramT, float paramFloat)
  {
    if ((paramT instanceof CommonBorder)) {
      ((CommonBorder)paramT).setBorderWidth(paramFloat, CommonBorder.BorderWidthDirection.LEFT.ordinal());
    }
  }
  
  @HippyControllerProps(defaultType="boolean", name="onLongClick")
  public void setLongClickable(T paramT, boolean paramBoolean)
  {
    if (!handleGestureBySelf())
    {
      if (paramBoolean) {
        paramT.setOnLongClickListener(NativeGestureDispatcher.getOnLongClickListener());
      }
    }
    else {
      return;
    }
    paramT.setOnLongClickListener(null);
    paramT.setLongClickable(false);
  }
  
  @HippyControllerProps(defaultType="boolean", name="nextFocusDownId")
  public void setNextFocusDownId(T paramT, int paramInt)
  {
    paramT.setNextFocusDownId(paramInt);
  }
  
  @HippyControllerProps(defaultType="boolean", name="nextFocusLeftId")
  public void setNextFocusLeftId(T paramT, int paramInt)
  {
    paramT.setNextFocusLeftId(paramInt);
  }
  
  @HippyControllerProps(defaultType="boolean", name="nextFocusRightId")
  public void setNextFocusRightId(T paramT, int paramInt)
  {
    paramT.setNextFocusRightId(paramInt);
  }
  
  @HippyControllerProps(defaultType="boolean", name="nextFocusUpId")
  public void setNextFocusUpId(T paramT, int paramInt)
  {
    paramT.setNextFocusUpId(paramInt);
  }
  
  @HippyControllerProps(defaultNumber=1.0D, defaultType="number", name="opacity")
  public void setOpacity(T paramT, float paramFloat)
  {
    paramT.setAlpha(paramFloat);
  }
  
  @HippyControllerProps(defaultType="boolean", name="onPressIn")
  public void setPressInable(T paramT, boolean paramBoolean)
  {
    if (!handleGestureBySelf()) {
      setGestureType(paramT, "onPressIn", paramBoolean);
    }
  }
  
  @HippyControllerProps(defaultType="boolean", name="onPressOut")
  public void setPressOutable(T paramT, boolean paramBoolean)
  {
    if (!handleGestureBySelf()) {
      setGestureType(paramT, "onPressOut", paramBoolean);
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="borderRightWidth")
  public void setRightBorderWidth(T paramT, float paramFloat)
  {
    if ((paramT instanceof CommonBorder)) {
      ((CommonBorder)paramT).setBorderWidth(paramFloat, CommonBorder.BorderWidthDirection.RIGHT.ordinal());
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="borderTopWidth")
  public void setTopBorderWidth(T paramT, float paramFloat)
  {
    if ((paramT instanceof CommonBorder)) {
      ((CommonBorder)paramT).setBorderWidth(paramFloat, CommonBorder.BorderWidthDirection.TOP.ordinal());
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="borderTopLeftRadius")
  public void setTopLeftBorderRadius(T paramT, float paramFloat)
  {
    if ((paramT instanceof CommonBorder)) {
      ((CommonBorder)paramT).setBorderRadius(paramFloat, CommonBorder.BorderRadiusDirection.TOP_LEFT.ordinal());
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="borderTopRightRadius")
  public void setTopRightBorderRadius(T paramT, float paramFloat)
  {
    if ((paramT instanceof CommonBorder)) {
      ((CommonBorder)paramT).setBorderRadius(paramFloat, CommonBorder.BorderRadiusDirection.TOP_RIGHT.ordinal());
    }
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onTouchCancel")
  public void setTouchCancelHandle(T paramT, boolean paramBoolean)
  {
    if (!handleGestureBySelf()) {
      setGestureType(paramT, "onTouchCancel", paramBoolean);
    }
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onTouchDown")
  public void setTouchDownHandle(T paramT, boolean paramBoolean)
  {
    if (!handleGestureBySelf()) {
      setGestureType(paramT, "onTouchDown", paramBoolean);
    }
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onTouchEnd")
  public void setTouchEndHandle(T paramT, boolean paramBoolean)
  {
    if (!handleGestureBySelf()) {
      setGestureType(paramT, "onTouchEnd", paramBoolean);
    }
  }
  
  @HippyControllerProps(defaultBoolean=false, defaultType="boolean", name="onTouchMove")
  public void setTouchMoveHandle(T paramT, boolean paramBoolean)
  {
    if (!handleGestureBySelf()) {
      setGestureType(paramT, "onTouchMove", paramBoolean);
    }
  }
  
  @HippyControllerProps(defaultType="array", name="transform")
  public void setTransform(T paramT, HippyArray paramHippyArray)
  {
    if (paramHippyArray == null)
    {
      resetTransform(paramT);
      return;
    }
    applyTransform(paramT, paramHippyArray);
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="zIndex")
  public void setZIndex(T paramT, int paramInt)
  {
    HippyViewGroupController.setViewZIndex(paramT, paramInt);
    paramT = paramT.getParent();
    if ((paramT instanceof d)) {
      ((d)paramT).updateDrawingOrder();
    }
  }
  
  protected boolean shouldInterceptLayout(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return false;
  }
  
  protected void updateExtra(View paramView, Object paramObject) {}
  
  public void updateLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, b paramb)
  {
    paramb = paramb.a(paramInt1);
    if (paramb != null)
    {
      paramb.measure(View.MeasureSpec.makeMeasureSpec(paramInt4, 1073741824), View.MeasureSpec.makeMeasureSpec(paramInt5, 1073741824));
      if (!shouldInterceptLayout(paramb, paramInt2, paramInt3, paramInt4, paramInt5)) {
        paramb.layout(paramInt2, paramInt3, paramInt2 + paramInt4, paramInt3 + paramInt5);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.HippyViewController
 * JD-Core Version:    0.7.0.1
 */