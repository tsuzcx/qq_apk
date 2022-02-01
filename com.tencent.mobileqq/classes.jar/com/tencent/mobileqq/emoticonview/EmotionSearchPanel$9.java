package com.tencent.mobileqq.emoticonview;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class EmotionSearchPanel$9
  extends D8SafeAnimatorListener
{
  EmotionSearchPanel$9(EmotionSearchPanel paramEmotionSearchPanel) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!EmotionSearchPanel.access$900(this.this$0, true))
    {
      EmotionSearchPanel.access$500(this.this$0, 1.0F);
      EmotionSearchPanel.access$600(this.this$0);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionSearchPanel.9
 * JD-Core Version:    0.7.0.1
 */