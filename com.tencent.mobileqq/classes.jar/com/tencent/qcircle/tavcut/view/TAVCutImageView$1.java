package com.tencent.qcircle.tavcut.view;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.qcircle.tavcut.view.ext.OnLongPressListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/qcircle/tavcut/view/TAVCutImageView$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onFling", "", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "", "velocityY", "onLongPress", "", "e", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class TAVCutImageView$1
  extends GestureDetector.SimpleOnGestureListener
{
  public boolean onFling(@NotNull MotionEvent paramMotionEvent1, @NotNull MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent1, "e1");
    Intrinsics.checkParameterIsNotNull(paramMotionEvent2, "e2");
    return false;
  }
  
  public void onLongPress(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "e");
    paramMotionEvent = TAVCutImageView.access$getMLongPressListener$p(this.this$0);
    if (paramMotionEvent != null) {
      paramMotionEvent.onLongPress();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.view.TAVCutImageView.1
 * JD-Core Version:    0.7.0.1
 */