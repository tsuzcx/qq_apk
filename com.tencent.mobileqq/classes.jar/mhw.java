import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.ClipDrawable;
import com.tencent.av.ui.QavPanel;

public class mhw
  implements ValueAnimator.AnimatorUpdateListener
{
  public mhw(QavPanel paramQavPanel) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (QavPanel.a(this.a)) {
      this.a.a.setLevel(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mhw
 * JD-Core Version:    0.7.0.1
 */