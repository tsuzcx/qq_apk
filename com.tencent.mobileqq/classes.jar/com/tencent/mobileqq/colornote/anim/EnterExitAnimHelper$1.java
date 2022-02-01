package com.tencent.mobileqq.colornote.anim;

import android.animation.Animator;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.colornote.swipeback.OnColorNoteAnimFinishListener;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import mqq.os.MqqHandler;

class EnterExitAnimHelper$1
  extends D8SafeAnimatorListener
{
  EnterExitAnimHelper$1(EnterExitAnimHelper paramEnterExitAnimHelper, OnColorNoteAnimFinishListener paramOnColorNoteAnimFinishListener, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    OnColorNoteAnimFinishListener localOnColorNoteAnimFinishListener = this.a;
    if (localOnColorNoteAnimFinishListener != null) {
      localOnColorNoteAnimFinishListener.onColorNoteAnimFinish();
    }
    if ((this.b) && ((paramAnimator instanceof CircularRevealAnimator))) {
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