package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.animation;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.animation.AccelerateDecelerateInterpolator;
import anyj;
import anyk;

@TargetApi(11)
public class AnimatorFactory
{
  public static ValueAnimator a(long paramLong, float paramFloat1, float paramFloat2, AnimatorFactory.AnimatorListener paramAnimatorListener)
  {
    return a(ValueAnimator.ofFloat(new float[] { paramFloat1, paramFloat2 }), paramAnimatorListener, paramLong);
  }
  
  private static ValueAnimator a(ValueAnimator paramValueAnimator, AnimatorFactory.AnimatorListener paramAnimatorListener, long paramLong)
  {
    paramValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    paramValueAnimator.addUpdateListener(new anyj(paramAnimatorListener));
    paramValueAnimator.addListener(new anyk(paramAnimatorListener, paramValueAnimator));
    paramValueAnimator.setDuration(paramLong);
    return paramValueAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.animation.AnimatorFactory
 * JD-Core Version:    0.7.0.1
 */