import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class rua
  implements Animation.AnimationListener
{
  rua(rty paramrty) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "animSet onAnimationEnd is called,time is:" + System.currentTimeMillis());
    }
    this.a.a.a.post(new rub(this));
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "animSet onAnimationRepeat is called,time is:" + System.currentTimeMillis());
    }
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.aio.BaseChatPie", 2, "animSet onAnimationStart is called,time is:" + System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rua
 * JD-Core Version:    0.7.0.1
 */