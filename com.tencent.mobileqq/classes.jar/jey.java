import android.os.IBinder.DeathRecipient;
import com.tencent.av.AVLog;

class jey
  implements IBinder.DeathRecipient
{
  jey(jex paramjex) {}
  
  public void binderDied()
  {
    AVLog.d("QQServiceProxy", "QQServiceForAV mobileQQ process exited!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jey
 * JD-Core Version:    0.7.0.1
 */