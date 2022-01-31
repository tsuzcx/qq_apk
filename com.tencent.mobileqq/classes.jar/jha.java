import android.os.IBinder.DeathRecipient;
import com.tencent.av.AVLog;

class jha
  implements IBinder.DeathRecipient
{
  jha(jgz paramjgz) {}
  
  public void binderDied()
  {
    AVLog.d("QQServiceProxy", "QQServiceForAV mobileQQ process exited!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jha
 * JD-Core Version:    0.7.0.1
 */