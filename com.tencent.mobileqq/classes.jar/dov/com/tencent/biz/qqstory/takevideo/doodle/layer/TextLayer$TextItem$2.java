package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class TextLayer$TextItem$2
  implements ValueAnimator.AnimatorUpdateListener
{
  TextLayer$TextItem$2(TextLayer.TextItem paramTextItem) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.a.a.b == null) {
      return;
    }
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.s = (this.a.d + this.a.f * (1.0F - f));
    this.a.t = (this.a.e + this.a.g * (1.0F - f));
    this.a.q = (this.a.b + this.a.h * (1.0F - f));
    this.a.r = (this.a.c + this.a.i * (1.0F - f));
    if (f == 1.0F)
    {
      this.a.a.b = null;
      this.a.a.a(4);
    }
    TextLayer.b(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem.2
 * JD-Core Version:    0.7.0.1
 */