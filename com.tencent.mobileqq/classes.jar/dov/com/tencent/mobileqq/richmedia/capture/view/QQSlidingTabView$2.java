package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class QQSlidingTabView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  QQSlidingTabView$2(QQSlidingTabView paramQQSlidingTabView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    QQSlidingTabView.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.QQSlidingTabView.2
 * JD-Core Version:    0.7.0.1
 */