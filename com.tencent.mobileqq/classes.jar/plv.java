import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.LinearLayout;

class plv
  implements ValueAnimator.AnimatorUpdateListener
{
  plv(plp paramplp) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    plp.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    plp.a(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     plv
 * JD-Core Version:    0.7.0.1
 */