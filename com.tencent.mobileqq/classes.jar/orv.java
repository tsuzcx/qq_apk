import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController.2;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;

public class orv
  implements Animation.AnimationListener
{
  public orv(ReadInJoyNaviController.2 param2) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ors.a(this.a.this$0, true);
    ors.a(this.a.this$0).setAlpha(0.0F);
    ors.a(this.a.this$0).removeView(ors.a(this.a.this$0));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     orv
 * JD-Core Version:    0.7.0.1
 */