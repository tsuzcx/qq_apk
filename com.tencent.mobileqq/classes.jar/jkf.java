import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.random.RandomController;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.qphone.base.util.QLog;

public class jkf
  implements Runnable
{
  public jkf(RandomController paramRandomController) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, "mMatchTimeoutRunnable trigger, show timeOutDialog!");
    }
    this.a.a = -1;
    RandomController.a(this.a).a();
    RandomController.c(this.a);
    RandomController.a(this.a).a().removeCallbacks(RandomController.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jkf
 * JD-Core Version:    0.7.0.1
 */