import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentSocialOperation;

public class lwe
  implements Animation.AnimationListener
{
  public lwe(ComponentSocialOperation paramComponentSocialOperation) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.post(new lwf(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lwe
 * JD-Core Version:    0.7.0.1
 */