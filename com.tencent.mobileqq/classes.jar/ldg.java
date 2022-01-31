import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;

class ldg
  implements Animation.AnimationListener
{
  ldg(ldf paramldf) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ReadInJoyNaviController.a(this.a.a, true);
    ReadInJoyNaviController.a(this.a.a).setAlpha(0.0F);
    ReadInJoyNaviController.a(this.a.a).removeView(ReadInJoyNaviController.a(this.a.a));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ldg
 * JD-Core Version:    0.7.0.1
 */