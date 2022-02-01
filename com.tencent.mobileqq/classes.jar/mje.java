import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

class mje
  implements ValueAnimator.AnimatorUpdateListener
{
  mje(mjd parammjd) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator.getAnimatedFraction();
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    float f;
    if (i <= 220)
    {
      f = i / 220.0F;
      mjd.a(this.a).setAlpha(f);
    }
    if (i <= 160)
    {
      f = i / 100.0F;
      mjd.a(this.a).setAlpha(f);
    }
    if (mjd.a(this.a) != null) {
      mjd.a(this.a).requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mje
 * JD-Core Version:    0.7.0.1
 */