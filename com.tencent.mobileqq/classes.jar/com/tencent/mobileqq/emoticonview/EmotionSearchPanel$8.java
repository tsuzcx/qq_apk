package com.tencent.mobileqq.emoticonview;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.FrameLayout;

class EmotionSearchPanel$8
  implements ValueAnimator.AnimatorUpdateListener
{
  EmotionSearchPanel$8(EmotionSearchPanel paramEmotionSearchPanel) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (EmotionSearchPanel.access$000(this.this$0)) {
      EmotionSearchPanel.access$800(this.this$0, EmotionSearchPanel.keyboardHeight + ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    } else {
      EmotionSearchPanel.access$800(this.this$0, EmotionSearchPanel.keyboardHeight - ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    }
    this.this$0.mask.setAlpha((1.0F - paramValueAnimator.getAnimatedFraction()) * 0.71F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionSearchPanel.8
 * JD-Core Version:    0.7.0.1
 */