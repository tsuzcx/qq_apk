import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.LinearLayout;

class qyj
  implements ValueAnimator.AnimatorUpdateListener
{
  qyj(qyg paramqyg) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    qyg.a(this.a).getLayoutParams().height = i;
    qyg.a(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qyj
 * JD-Core Version:    0.7.0.1
 */