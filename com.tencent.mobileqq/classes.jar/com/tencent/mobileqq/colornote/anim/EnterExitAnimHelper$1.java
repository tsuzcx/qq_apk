package com.tencent.mobileqq.colornote.anim;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import com.tencent.biz.qqstory.widget.circularreveal.CircularRevealAnimator;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.swipeback.OnColorNoteAnimFinishListener;
import mqq.os.MqqHandler;

class EnterExitAnimHelper$1
  implements Animator.AnimatorListener
{
  EnterExitAnimHelper$1(EnterExitAnimHelper paramEnterExitAnimHelper, OnColorNoteAnimFinishListener paramOnColorNoteAnimFinishListener, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackOnColorNoteAnimFinishListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteSwipebackOnColorNoteAnimFinishListener.onColorNoteAnimFinish();
    }
    if ((this.jdField_a_of_type_Boolean) && ((paramAnimator instanceof CircularRevealAnimator))) {
      ThreadManager.getUIHandler().postDelayed(new EnterExitAnimHelper.1.1(this, paramAnimator), 200L);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.anim.EnterExitAnimHelper.1
 * JD-Core Version:    0.7.0.1
 */