import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

class mio
  implements ValueAnimator.AnimatorUpdateListener
{
  mio(min parammin) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator.getAnimatedFraction();
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    float f;
    if (i <= 220)
    {
      f = i / 220.0F;
      min.a(this.a).setAlpha(f);
    }
    if (i <= 160)
    {
      f = i / 100.0F;
      min.a(this.a).setAlpha(f);
    }
    if (min.a(this.a) != null) {
      min.a(this.a).requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mio
 * JD-Core Version:    0.7.0.1
 */