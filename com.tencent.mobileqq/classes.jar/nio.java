import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;

public class nio
  implements Animation.AnimationListener
{
  public nio(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setResult(-1);
    PublicAccountAdvertisementActivity.g(this.a);
    PublicAccountAdvertisementActivity.a(this.a, 0, 0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     nio
 * JD-Core Version:    0.7.0.1
 */