package com.tencent.mobileqq.emoticonview;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class EmotionSearchPanel$4
  implements ValueAnimator.AnimatorUpdateListener
{
  EmotionSearchPanel$4(EmotionSearchPanel paramEmotionSearchPanel, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = (int)(this.val$searchinputWidth + this.val$rightMoveDis * f);
    EmotionSearchPanel.access$300(this.this$0, i);
    EmotionSearchPanel.access$400(this.this$0, (int)(this.val$endPos * f));
    EmotionSearchPanel.access$500(this.this$0, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionSearchPanel.4
 * JD-Core Version:    0.7.0.1
 */