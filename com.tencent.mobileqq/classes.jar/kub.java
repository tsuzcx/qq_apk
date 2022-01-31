import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;

public class kub
  implements Animation.AnimationListener
{
  public kub(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setResult(-1);
    PublicAccountAdvertisementActivity.f(this.a);
    PublicAccountAdvertisementActivity.a(this.a, 0, 0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kub
 * JD-Core Version:    0.7.0.1
 */