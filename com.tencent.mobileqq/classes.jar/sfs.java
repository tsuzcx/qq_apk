import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.47.1;

public class sfs
  implements Animation.AnimationListener
{
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.post(new ReadInJoyBaseAdapter.47.1(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sfs
 * JD-Core Version:    0.7.0.1
 */