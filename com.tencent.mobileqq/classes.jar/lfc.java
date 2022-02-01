import android.os.IBinder.DeathRecipient;

class lfc
  implements IBinder.DeathRecipient
{
  lfc(lfb paramlfb) {}
  
  public void binderDied()
  {
    lbd.g("QQServiceProxy", "QQServiceForAV mobileQQ process exited!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lfc
 * JD-Core Version:    0.7.0.1
 */