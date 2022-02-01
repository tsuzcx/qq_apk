package dov.com.tencent.mobileqq.activity.richmedia;

import android.graphics.drawable.AnimationDrawable;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

class VideoFilterViewPager$2
  implements Animation.AnimationListener
{
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = this.a.getDrawable();
    if ((paramAnimation instanceof AnimationDrawable)) {
      ((AnimationDrawable)paramAnimation).start();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.VideoFilterViewPager.2
 * JD-Core Version:    0.7.0.1
 */