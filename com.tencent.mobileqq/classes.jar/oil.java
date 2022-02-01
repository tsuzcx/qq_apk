import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController.2;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;

public class oil
  implements Animation.AnimationListener
{
  public oil(ReadInJoyNaviController.2 param2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    oii.a(this.a.this$0, true);
    oii.a(this.a.this$0).setAlpha(0.0F);
    oii.a(this.a.this$0).removeView(oii.a(this.a.this$0));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oil
 * JD-Core Version:    0.7.0.1
 */