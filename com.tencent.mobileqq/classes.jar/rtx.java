import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;

public class rtx
  implements ValueAnimator.AnimatorUpdateListener
{
  public rtx(TabLayoutCompat paramTabLayoutCompat) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.scrollTo(((Integer)paramValueAnimator.getAnimatedValue()).intValue(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rtx
 * JD-Core Version:    0.7.0.1
 */