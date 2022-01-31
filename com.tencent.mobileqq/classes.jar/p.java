import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.hiboom.HiBoomTextView;

class p
  implements ValueAnimator.AnimatorUpdateListener
{
  p(o paramo) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (i >= this.a.i[0])
    {
      this.a.a.cancel();
      this.a.e = 0;
      o.a(this.a).a = o.a(this.a).d();
      o.a(this.a).requestLayout();
      o.a(this.a).invalidate();
    }
    while (i <= this.a.e) {
      return;
    }
    this.a.e = i;
    o.a(this.a).invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     p
 * JD-Core Version:    0.7.0.1
 */