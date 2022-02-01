package com.tencent.xaction.trigger.touch;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/trigger/touch/VelocityTrackerHelper;", "", "context", "Landroid/content/Context;", "interpolator", "Landroid/view/animation/Interpolator;", "(Landroid/content/Context;Landroid/view/animation/Interpolator;)V", "flingRunnable", "Ljava/lang/Runnable;", "mainHandler", "Landroid/os/Handler;", "maximumVelocity", "", "getMaximumVelocity", "()F", "setMaximumVelocity", "(F)V", "minimumVelocity", "getMinimumVelocity", "setMinimumVelocity", "scroller", "Landroid/widget/Scroller;", "velocityTracker", "Landroid/view/VelocityTracker;", "abortAnimation", "", "addVelocityTracker", "event", "Landroid/view/MotionEvent;", "computeScrollOffset", "", "nextInvalidate", "callback", "Lcom/tencent/xaction/trigger/touch/VelocityTrackerHelper$ScrollCallback;", "recycleVelocityTracker", "touchUp", "x", "", "y", "velocitySpeed", "Companion", "ScrollCallback", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class VelocityTrackerHelper
{
  public static final VelocityTrackerHelper.Companion a;
  private float jdField_a_of_type_Float;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private final Scroller jdField_a_of_type_AndroidWidgetScroller;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private float b;
  
  static
  {
    jdField_a_of_type_ComTencentXactionTriggerTouchVelocityTrackerHelper$Companion = new VelocityTrackerHelper.Companion(null);
  }
  
  public VelocityTrackerHelper(@NotNull Context paramContext, @Nullable Interpolator paramInterpolator)
  {
    if (paramInterpolator == null) {
      paramInterpolator = new Scroller(paramContext);
    } else {
      paramInterpolator = new Scroller(paramContext, paramInterpolator);
    }
    this.jdField_a_of_type_AndroidWidgetScroller = paramInterpolator;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    paramInterpolator = ViewConfiguration.get(paramContext);
    Intrinsics.checkExpressionValueIsNotNull(paramInterpolator, "ViewConfiguration.get(context)");
    this.jdField_a_of_type_Float = paramInterpolator.getScaledMaximumFlingVelocity();
    paramContext = ViewConfiguration.get(paramContext);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "ViewConfiguration.get(context)");
    this.b = paramContext.getScaledMinimumFlingVelocity();
  }
  
  private final void a(VelocityTrackerHelper.ScrollCallback paramScrollCallback)
  {
    this.jdField_a_of_type_JavaLangRunnable = ((Runnable)new VelocityTrackerHelper.nextInvalidate.1(this, paramScrollCallback));
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private final boolean a()
  {
    return this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
  }
  
  private final void b()
  {
    VelocityTracker localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localVelocityTracker != null)
    {
      if (localVelocityTracker == null) {
        Intrinsics.throwNpe();
      }
      localVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = ((VelocityTracker)null);
    }
  }
  
  public final float a()
  {
    return this.b;
  }
  
  public final void a()
  {
    if (!this.jdField_a_of_type_AndroidWidgetScroller.isFinished()) {
      this.jdField_a_of_type_AndroidWidgetScroller.abortAnimation();
    }
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (localRunnable != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(localRunnable);
    }
  }
  
  public final void a(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    VelocityTracker localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localVelocityTracker == null) {
      Intrinsics.throwNpe();
    }
    localVelocityTracker.addMovement(paramMotionEvent);
  }
  
  public final void a(@NotNull VelocityTrackerHelper.ScrollCallback paramScrollCallback, int paramInt1, int paramInt2, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramScrollCallback, "callback");
    Object localObject = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.jdField_a_of_type_Float);
    localObject = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    float f = ((VelocityTracker)localObject).getXVelocity();
    localObject = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    paramScrollCallback.a(f, ((VelocityTracker)localObject).getYVelocity());
    this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
    localObject = this.jdField_a_of_type_AndroidWidgetScroller;
    paramFloat = -paramFloat;
    VelocityTracker localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localVelocityTracker == null) {
      Intrinsics.throwNpe();
    }
    int i = (int)(localVelocityTracker.getXVelocity() * paramFloat);
    localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localVelocityTracker == null) {
      Intrinsics.throwNpe();
    }
    ((Scroller)localObject).fling(paramInt1, paramInt2, i, (int)(paramFloat * localVelocityTracker.getYVelocity()), -2000, 2000, -2000, 2000);
    a(paramScrollCallback);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.trigger.touch.VelocityTrackerHelper
 * JD-Core Version:    0.7.0.1
 */