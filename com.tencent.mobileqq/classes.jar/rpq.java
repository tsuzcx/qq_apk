import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ZImageView;

public class rpq
  implements ValueAnimator.AnimatorUpdateListener
{
  public rpq(ZImageView paramZImageView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.setAlpha(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rpq
 * JD-Core Version:    0.7.0.1
 */