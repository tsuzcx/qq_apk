import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController.2;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;

public class nud
  implements Animation.AnimationListener
{
  public nud(ReadInJoyNaviController.2 param2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    nua.a(this.a.this$0, true);
    nua.a(this.a.this$0).setAlpha(0.0F);
    nua.a(this.a.this$0).removeView(nua.a(this.a.this$0));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nud
 * JD-Core Version:    0.7.0.1
 */