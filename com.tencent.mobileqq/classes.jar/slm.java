import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ReadInJoyColorBandEntranceButton;

public class slm
  extends AnimatorListenerAdapter
{
  public slm(ReadInJoyColorBandEntranceButton paramReadInJoyColorBandEntranceButton) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.setClickable(true);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     slm
 * JD-Core Version:    0.7.0.1
 */