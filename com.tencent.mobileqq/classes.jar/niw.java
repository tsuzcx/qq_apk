import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController.2;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;

public class niw
  implements Animation.AnimationListener
{
  public niw(ReadInJoyNaviController.2 param2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    nit.a(this.a.this$0, true);
    nit.a(this.a.this$0).setAlpha(0.0F);
    nit.a(this.a.this$0).removeView(nit.a(this.a.this$0));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     niw
 * JD-Core Version:    0.7.0.1
 */