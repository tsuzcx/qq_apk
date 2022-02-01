import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.LinearLayout;

class qjz
  implements ValueAnimator.AnimatorUpdateListener
{
  qjz(qjt paramqjt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    qjt.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    qjt.a(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qjz
 * JD-Core Version:    0.7.0.1
 */