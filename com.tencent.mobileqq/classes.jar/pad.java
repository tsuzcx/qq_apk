import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.LinearLayout;

class pad
  implements ValueAnimator.AnimatorUpdateListener
{
  pad(ozx paramozx) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    ozx.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    ozx.a(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pad
 * JD-Core Version:    0.7.0.1
 */