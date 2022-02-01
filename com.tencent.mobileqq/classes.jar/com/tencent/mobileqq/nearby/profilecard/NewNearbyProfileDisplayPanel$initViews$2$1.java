package com.tencent.mobileqq.nearby.profilecard;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/nearby/profilecard/NewNearbyProfileDisplayPanel$initViews$2$1", "Landroid/view/View$OnTouchListener;", "lastX", "", "getLastX", "()F", "setLastX", "(F)V", "lastY", "getLastY", "setLastY", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NewNearbyProfileDisplayPanel$initViews$2$1
  implements View.OnTouchListener
{
  private float a;
  private float b;
  
  public boolean onTouch(@Nullable View paramView, @NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "event");
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (((i == 1) || (i == 3)) && (Math.abs(paramMotionEvent.getX() - this.a) < Math.abs(paramMotionEvent.getY() - this.b))) {
        return true;
      }
    }
    else
    {
      this.a = paramMotionEvent.getX();
      this.b = paramMotionEvent.getY();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NewNearbyProfileDisplayPanel.initViews.2.1
 * JD-Core Version:    0.7.0.1
 */