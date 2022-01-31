import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.LinearLayout;

class rky
  implements ValueAnimator.AnimatorUpdateListener
{
  rky(rkv paramrkv) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    rkv.a(this.a).getLayoutParams().height = i;
    rkv.a(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rky
 * JD-Core Version:    0.7.0.1
 */