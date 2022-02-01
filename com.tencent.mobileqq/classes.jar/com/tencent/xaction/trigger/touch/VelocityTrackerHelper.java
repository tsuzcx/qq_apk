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
  public static final VelocityTrackerHelper.Companion a = new VelocityTrackerHelper.Companion(null);
  private final Scroller b;
  private VelocityTracker c;
  private Runnable d;
  private final Handler e;
  private float f;
  private float g;
  
  public VelocityTrackerHelper(@NotNull Context paramContext, @Nullable Interpolator paramInterpolator)
  {
    if (paramInterpolator == null) {
      paramInterpolator = new Scroller(paramContext);
    } else {
      paramInterpolator = new Scroller(paramContext, paramInterpolator);
    }
    this.b = paramInterpolator;
    this.e = new Handler(Looper.getMainLooper());
    paramInterpolator = ViewConfiguration.get(paramContext);
    Intrinsics.checkExpressionValueIsNotNull(paramInterpolator, "ViewConfiguration.get(context)");
    this.f = paramInterpolator.getScaledMaximumFlingVelocity();
    paramContext = ViewConfiguration.get(paramContext);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "ViewConfiguration.get(context)");
    this.g = paramContext.getScaledMinimumFlingVelocity();
  }
  
  private final void a(VelocityTrackerHelper.ScrollCallback paramScrollCallback)
  {
    this.d = ((Runnable)new VelocityTrackerHelper.nextInvalidate.1(this, paramScrollCallback));
    this.e.post(this.d);
  }
  
  private final boolean c()
  {
    return this.b.computeScrollOffset();
  }
  
  private final void d()
  {
    VelocityTracker localVelocityTracker = this.c;
    if (localVelocityTracker != null)
    {
      if (localVelocityTracker == null) {
        Intrinsics.throwNpe();
      }
      localVelocityTracker.recycle();
      this.c = ((VelocityTracker)null);
    }
  }
  
  public final float a()
  {
    return this.g;
  }
  
  public final void a(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    if (this.c == null) {
      this.c = VelocityTracker.obtain();
    }
    VelocityTracker localVelocityTracker = this.c;
    if (localVelocityTracker == null) {
      Intrinsics.throwNpe();
    }
    localVelocityTracker.addMovement(paramMotionEvent);
  }
  
  public final void a(@NotNull VelocityTrackerHelper.ScrollCallback paramScrollCallback, int paramInt1, int paramInt2, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramScrollCallback, "callback");
    Object localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.f);
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    float f1 = ((VelocityTracker)localObject).getXVelocity();
    localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    paramScrollCallback.a(f1, ((VelocityTracker)localObject).getYVelocity());
    this.b.forceFinished(true);
    localObject = this.b;
    paramFloat = -paramFloat;
    VelocityTracker localVelocityTracker = this.c;
    if (localVelocityTracker == null) {
      Intrinsics.throwNpe();
    }
    int i = (int)(localVelocityTracker.getXVelocity() * paramFloat);
    localVelocityTracker = this.c;
    if (localVelocityTracker == null) {
      Intrinsics.throwNpe();
    }
    ((Scroller)localObject).fling(paramInt1, paramInt2, i, (int)(paramFloat * localVelocityTracker.getYVelocity()), -2000, 2000, -2000, 2000);
    a(paramScrollCallback);
    d();
  }
  
  public final void b()
  {
    if (!this.b.isFinished()) {
      this.b.abortAnimation();
    }
    Runnable localRunnable = this.d;
    if (localRunnable != null) {
      this.e.removeCallbacks(localRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.trigger.touch.VelocityTrackerHelper
 * JD-Core Version:    0.7.0.1
 */