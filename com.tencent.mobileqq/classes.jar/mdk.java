import android.os.MessageQueue.IdleHandler;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.AVActivity.1.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class mdk
  implements MessageQueue.IdleHandler
{
  public mdk(AVActivity paramAVActivity) {}
  
  public boolean queueIdle()
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.a.b, 1, "call IdleHandler mPeerUin:=" + this.a.c);
    }
    ThreadManager.getSubThreadHandler().postDelayed(new AVActivity.1.1(this), 2000L);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mdk
 * JD-Core Version:    0.7.0.1
 */