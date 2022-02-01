package dov.com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Paint;

class FaceLayer$FaceItem$3
  implements ValueAnimator.AnimatorUpdateListener
{
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.p = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.b.g.setMaskFilter(new BlurMaskFilter(this.a.p, BlurMaskFilter.Blur.OUTER));
    this.a.b.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem.3
 * JD-Core Version:    0.7.0.1
 */