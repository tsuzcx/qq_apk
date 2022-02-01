package dov.com.qq.im.ae.play;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;

class ScaleMoveImageViewer$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ScaleMoveImageViewer$1(ScaleMoveImageViewer paramScaleMoveImageViewer) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    ScaleMoveImageViewer.access$000(this.this$0).setAlpha(i);
    this.this$0.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.ScaleMoveImageViewer.1
 * JD-Core Version:    0.7.0.1
 */