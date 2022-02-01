import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.LinearLayout;

class qcl
  implements ValueAnimator.AnimatorUpdateListener
{
  qcl(qcf paramqcf) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    qcf.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    qcf.a(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qcl
 * JD-Core Version:    0.7.0.1
 */