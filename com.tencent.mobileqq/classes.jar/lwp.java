import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation;

public class lwp
  implements Animation.AnimationListener
{
  public lwp(ComponentSocialOperation paramComponentSocialOperation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.startAnimation(this.a.c);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lwp
 * JD-Core Version:    0.7.0.1
 */