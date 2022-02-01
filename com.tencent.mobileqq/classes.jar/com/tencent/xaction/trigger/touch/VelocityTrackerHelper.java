package com.tencent.xaction.trigger.touch;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.Scroller;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/trigger/touch/VelocityTrackerHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mScroller", "Landroid/widget/Scroller;", "mVelocityTracker", "Landroid/view/VelocityTracker;", "addVelocityTracker", "", "event", "Landroid/view/MotionEvent;", "computeScrollOffset", "", "getXScrollVelocity", "", "getYScrollVelocity", "nextInvalidate", "v", "Landroid/view/View;", "callback", "Lcom/tencent/xaction/trigger/touch/VelocityTrackerHelper$ScrollCallback;", "recycleVelocityTracker", "touchUp", "x", "y", "velocitySpeed", "", "ScrollCallback", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class VelocityTrackerHelper
{
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private final Scroller jdField_a_of_type_AndroidWidgetScroller;
  
  public VelocityTrackerHelper(@NotNull Context paramContext)
  {
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext);
  }
  
  private final int a()
  {
    VelocityTracker localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localVelocityTracker == null) {
      Intrinsics.throwNpe();
    }
    return (int)localVelocityTracker.getXVelocity();
  }
  
  private final void a()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      VelocityTracker localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
      if (localVelocityTracker == null) {
        Intrinsics.throwNpe();
      }
      localVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = ((VelocityTracker)null);
    }
  }
  
  private final void a(View paramView, VelocityTrackerHelper.ScrollCallback paramScrollCallback)
  {
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = ((Runnable)null);
    localObjectRef.element = ((Runnable)new VelocityTrackerHelper.nextInvalidate.1(this, paramScrollCallback, paramView, localObjectRef));
    if (Build.VERSION.SDK_INT >= 16) {
      paramView.postOnAnimation((Runnable)localObjectRef.element);
    }
  }
  
  private final boolean a()
  {
    return this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset();
  }
  
  private final int b()
  {
    VelocityTracker localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localVelocityTracker == null) {
      Intrinsics.throwNpe();
    }
    return (int)localVelocityTracker.getYVelocity();
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
  
  public final void a(@NotNull View paramView, int paramInt1, int paramInt2, float paramFloat, @NotNull VelocityTrackerHelper.ScrollCallback paramScrollCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    Intrinsics.checkParameterIsNotNull(paramScrollCallback, "callback");
    Object localObject = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((VelocityTracker)localObject).computeCurrentVelocity(1000);
    int i = a();
    int j = b();
    this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
    localObject = this.jdField_a_of_type_AndroidWidgetScroller;
    float f = -paramFloat;
    ((Scroller)localObject).fling(paramInt1, paramInt2, (int)(i * f), (int)(-paramFloat * j), -2000, 2000, -2000, 2000);
    a(paramView, paramScrollCallback);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.trigger.touch.VelocityTrackerHelper
 * JD-Core Version:    0.7.0.1
 */