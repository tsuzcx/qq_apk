import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.LinearLayout;

class qun
  implements ValueAnimator.AnimatorUpdateListener
{
  qun(quh paramquh) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    quh.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    quh.a(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qun
 * JD-Core Version:    0.7.0.1
 */