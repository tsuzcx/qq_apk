import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;

public class rdd
  implements Animation.AnimationListener
{
  public rdd(ReadInJoyListViewGroup paramReadInJoyListViewGroup) {}
  
  public void onAnimationEnd(Animation paramAnimation) {}
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    ReadInJoyListViewGroup.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rdd
 * JD-Core Version:    0.7.0.1
 */