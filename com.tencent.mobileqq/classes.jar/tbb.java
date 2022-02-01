import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ReadInJoyColorBandEntranceButton;

public class tbb
  extends AnimatorListenerAdapter
{
  public tbb(ReadInJoyColorBandEntranceButton paramReadInJoyColorBandEntranceButton) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.a.setClickable(true);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.a.setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tbb
 * JD-Core Version:    0.7.0.1
 */