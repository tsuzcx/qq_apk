package com.tencent.mobileqq.emoticonview;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.FrameLayout;

class EmotionSearchPanel$6
  implements ValueAnimator.AnimatorUpdateListener
{
  EmotionSearchPanel$6(EmotionSearchPanel paramEmotionSearchPanel) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    EmotionSearchPanel localEmotionSearchPanel = this.this$0;
    int i = EmotionSearchPanel.access$700(this.this$0);
    EmotionSearchPanel.access$800(localEmotionSearchPanel, ((Integer)paramValueAnimator.getAnimatedValue()).intValue() + i);
    this.this$0.mask.setAlpha(paramValueAnimator.getAnimatedFraction() * 0.71F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionSearchPanel.6
 * JD-Core Version:    0.7.0.1
 */