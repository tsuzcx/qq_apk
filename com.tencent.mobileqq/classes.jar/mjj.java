import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

class mjj
  implements ValueAnimator.AnimatorUpdateListener
{
  mjj(mji parammji) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator.getAnimatedFraction();
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    float f;
    if (i <= 220)
    {
      f = i / 220.0F;
      mji.a(this.a).setAlpha(f);
    }
    if (i <= 160)
    {
      f = i / 100.0F;
      mji.a(this.a).setAlpha(f);
    }
    if (mji.a(this.a) != null) {
      mji.a(this.a).requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mjj
 * JD-Core Version:    0.7.0.1
 */