package com.tencent.mobileqq.emoticonview;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class EmotionSearchPanel$3
  implements ValueAnimator.AnimatorUpdateListener
{
  EmotionSearchPanel$3(EmotionSearchPanel paramEmotionSearchPanel, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = (int)(this.this$0.exitWidth - EmotionSearchPanel.access$200(this.this$0) * f);
    EmotionSearchPanel.access$300(this.this$0, i);
    EmotionSearchPanel.access$400(this.this$0, (int)(this.val$startPos * (1.0F - f)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionSearchPanel.3
 * JD-Core Version:    0.7.0.1
 */