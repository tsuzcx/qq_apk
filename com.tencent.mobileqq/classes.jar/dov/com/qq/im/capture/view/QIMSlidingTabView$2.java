package dov.com.qq.im.capture.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class QIMSlidingTabView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  QIMSlidingTabView$2(QIMSlidingTabView paramQIMSlidingTabView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    QIMSlidingTabView.access$002(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.capture.view.QIMSlidingTabView.2
 * JD-Core Version:    0.7.0.1
 */