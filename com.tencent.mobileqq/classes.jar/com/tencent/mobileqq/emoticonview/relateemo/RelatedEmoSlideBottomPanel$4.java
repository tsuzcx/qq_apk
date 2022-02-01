package com.tencent.mobileqq.emoticonview.relateemo;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class RelatedEmoSlideBottomPanel$4
  implements ValueAnimator.AnimatorUpdateListener
{
  RelatedEmoSlideBottomPanel$4(RelatedEmoSlideBottomPanel paramRelatedEmoSlideBottomPanel, boolean paramBoolean, float[] paramArrayOfFloat) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((RelatedEmoSlideBottomPanel.access$200(this.this$0) != null) && (this.val$updatePanel))
    {
      Float localFloat = (Float)paramValueAnimator.getAnimatedValue();
      RelatedEmoSlideBottomPanel.access$200(this.this$0).updatePanelDistance(localFloat.floatValue() - this.this$0.maxTopY());
    }
    if ((RelatedEmoSlideBottomPanel.access$000(this.this$0) > 0) && (paramValueAnimator.getAnimatedFraction() == 1.0F) && (this.val$values[1] == this.this$0.getMeasuredHeight()) && (RelatedEmoSlideBottomPanel.access$200(this.this$0) != null)) {
      RelatedEmoSlideBottomPanel.access$200(this.this$0).onDismiss(RelatedEmoSlideBottomPanel.access$000(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoSlideBottomPanel.4
 * JD-Core Version:    0.7.0.1
 */