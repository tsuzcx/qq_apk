package com.tencent.mobileqq.emoticonview;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class EmotionKeywordLayout$3
  extends D8SafeAnimatorListener
{
  EmotionKeywordLayout$3(EmotionKeywordLayout paramEmotionKeywordLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (paramAnimator == EmotionKeywordLayout.access$100(this.this$0)) {
      this.this$0.setVisibility(8);
    }
    if (EmotionKeywordLayout.access$200(this.this$0) != null) {
      EmotionKeywordLayout.access$200(this.this$0).resetCurrentX(0);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionKeywordLayout.3
 * JD-Core Version:    0.7.0.1
 */