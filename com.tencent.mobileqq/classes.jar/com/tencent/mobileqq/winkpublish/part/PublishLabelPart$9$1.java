package com.tencent.mobileqq.winkpublish.part;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class PublishLabelPart$9$1
  implements ValueAnimator.AnimatorUpdateListener
{
  PublishLabelPart$9$1(PublishLabelPart.9 param9) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a.a(PublishLabelPart.j(this.a.a), (int)f);
    PublishLabelPart.b(this.a.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.part.PublishLabelPart.9.1
 * JD-Core Version:    0.7.0.1
 */