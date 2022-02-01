package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class DragAnimationMgr$1
  extends AnimatorListenerAdapter
{
  DragAnimationMgr$1(DragAnimationMgr paramDragAnimationMgr) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    int i = DragAnimationMgr.a(this.a).a();
    DragAnimationMgr.a(this.a, DragAnimationMgr.a(this.a), i);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    int i = DragAnimationMgr.a(this.a).a();
    DragAnimationMgr.a(this.a, DragAnimationMgr.a(this.a), i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.DragAnimationMgr.1
 * JD-Core Version:    0.7.0.1
 */