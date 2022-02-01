package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import java.util.ArrayList;

class SecondDemoView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  SecondDemoView$1(SecondDemoView paramSecondDemoView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (ArrayList)paramValueAnimator.getAnimatedValue();
    this.a.a = paramValueAnimator;
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.SecondDemoView.1
 * JD-Core Version:    0.7.0.1
 */