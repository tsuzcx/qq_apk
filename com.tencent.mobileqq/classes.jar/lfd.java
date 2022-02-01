import android.os.IBinder.DeathRecipient;

class lfd
  implements IBinder.DeathRecipient
{
  lfd(lfc paramlfc) {}
  
  public void binderDied()
  {
    lbj.d("QQServiceProxy", "QQServiceForAV mobileQQ process exited!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lfd
 * JD-Core Version:    0.7.0.1
 */