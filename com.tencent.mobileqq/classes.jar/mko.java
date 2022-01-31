import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.ClipDrawable;
import com.tencent.av.ui.QavPanel;

public class mko
  implements ValueAnimator.AnimatorUpdateListener
{
  public mko(QavPanel paramQavPanel) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (QavPanel.a(this.a)) {
      this.a.a.setLevel(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mko
 * JD-Core Version:    0.7.0.1
 */