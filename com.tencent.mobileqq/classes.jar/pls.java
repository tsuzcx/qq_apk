import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.LinearLayout;

class pls
  implements ValueAnimator.AnimatorUpdateListener
{
  pls(plm paramplm) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    plm.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    plm.a(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pls
 * JD-Core Version:    0.7.0.1
 */