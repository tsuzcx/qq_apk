import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.QQLSActivity;

public class tft
  implements Animation.AnimationListener
{
  public tft(QQLSActivity paramQQLSActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QQLSActivity.a(this.a) != null) {
      QQLSActivity.a(this.a).post(new tfu(this));
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tft
 * JD-Core Version:    0.7.0.1
 */