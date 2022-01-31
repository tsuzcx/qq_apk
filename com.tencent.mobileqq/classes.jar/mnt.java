import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class mnt
  extends AnimateUtils.AnimationAdapter
{
  mnt(mns parammns) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new ScaleAnimation(1.05F, 0.95F, 1.05F, 0.95F, 1, 0.5F, 1, 0.5F);
    paramAnimation.setDuration(100L);
    paramAnimation.setAnimationListener(new mnu(this));
    this.a.a.a.startAnimation(paramAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mnt
 * JD-Core Version:    0.7.0.1
 */