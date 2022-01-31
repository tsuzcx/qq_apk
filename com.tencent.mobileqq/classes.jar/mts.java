import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;

public class mts
  implements Animation.AnimationListener
{
  public mts(SubscriptRecommendController paramSubscriptRecommendController) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a(SubscriptRecommendController.a(this.a));
    this.a.c();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mts
 * JD-Core Version:    0.7.0.1
 */