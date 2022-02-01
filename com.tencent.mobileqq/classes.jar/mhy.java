import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.ClipDrawable;
import com.tencent.av.ui.QavPanel;

public class mhy
  implements ValueAnimator.AnimatorUpdateListener
{
  public mhy(QavPanel paramQavPanel) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (QavPanel.c(this.a))
    {
      if (this.a.a != null) {
        this.a.a.setLevel(i);
      }
      if (QavPanel.d(this.a))
      {
        QavPanel.a(this.a).a(i);
        QavPanel.a(this.a).b(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mhy
 * JD-Core Version:    0.7.0.1
 */