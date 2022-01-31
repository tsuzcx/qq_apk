import com.tencent.av.random.RandomController;
import com.tencent.av.random.RandomWebProtocol;
import com.tencent.qphone.base.util.QLog;

public class jkv
  implements Runnable
{
  public jkv(RandomController paramRandomController) {}
  
  public void run()
  {
    if (RandomController.c(this.a))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RandomController", 2, "mRandomPushTimeoutRunnable trigger, request room owner!");
      }
      RandomController.a(this.a).a(RandomController.b(this.a), this.a.a);
      this.a.a();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("RandomController", 2, "mRoomOwnerEnable == false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jkv
 * JD-Core Version:    0.7.0.1
 */