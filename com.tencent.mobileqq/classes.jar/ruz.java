import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ReadInJoyColorBandEntranceButton;

public class ruz
  extends AnimatorListenerAdapter
{
  public ruz(ReadInJoyColorBandEntranceButton paramReadInJoyColorBandEntranceButton) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.setClickable(true);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ruz
 * JD-Core Version:    0.7.0.1
 */