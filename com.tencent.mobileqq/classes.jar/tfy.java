import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import mqq.os.MqqHandler;

public class tfy
  implements Animation.AnimationListener
{
  public tfy(QQLSActivity paramQQLSActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.a.removeMessages(99);
    if (VersionUtils.g())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQLSActivity", 2, "do SmoothFinish");
      }
      QQLSActivity.g(this.a);
      this.a.finish();
      return;
    }
    this.a.a.postAtFrontOfQueue(new tfz(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tfy
 * JD-Core Version:    0.7.0.1
 */