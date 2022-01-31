import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.qphone.base.util.QLog;

public class sfj
  implements Animation.AnimationListener
{
  public sfj(ContactBindedActivity paramContactBindedActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "doMultiAddTipsAnim end");
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "doMultiAddTipsAnim start");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sfj
 * JD-Core Version:    0.7.0.1
 */