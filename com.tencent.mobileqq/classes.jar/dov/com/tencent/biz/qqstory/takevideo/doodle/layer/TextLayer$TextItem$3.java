package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class TextLayer$TextItem$3
  implements ValueAnimator.AnimatorUpdateListener
{
  TextLayer$TextItem$3(TextLayer.TextItem paramTextItem) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.w = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem.3
 * JD-Core Version:    0.7.0.1
 */