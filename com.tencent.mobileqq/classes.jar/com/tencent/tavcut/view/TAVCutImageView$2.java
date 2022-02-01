package com.tencent.tavcut.view;

import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.tavcut.view.ext.OnViewTapListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tavcut/view/TAVCutImageView$2", "Landroid/view/GestureDetector$OnDoubleTapListener;", "onDoubleTap", "", "ev", "Landroid/view/MotionEvent;", "onDoubleTapEvent", "e", "onSingleTapConfirmed", "libtavcut_debug"}, k=1, mv={1, 1, 16})
public final class TAVCutImageView$2
  implements GestureDetector.OnDoubleTapListener
{
  public boolean onDoubleTap(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "ev");
    return true;
  }
  
  public boolean onDoubleTapEvent(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "e");
    return false;
  }
  
  public boolean onSingleTapConfirmed(@NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "e");
    Object localObject = TAVCutImageView.access$getMOnClickListener$p(this.a);
    if (localObject != null) {
      ((View.OnClickListener)localObject).onClick((View)this.a);
    }
    localObject = TAVCutImageView.access$getMViewTapListener$p(this.a);
    if (localObject != null) {
      ((OnViewTapListener)localObject).a((View)this.a, paramMotionEvent.getX(), paramMotionEvent.getY(), paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.view.TAVCutImageView.2
 * JD-Core Version:    0.7.0.1
 */