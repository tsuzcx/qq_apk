import android.os.IBinder.DeathRecipient;

class lib
  implements IBinder.DeathRecipient
{
  lib(lia paramlia) {}
  
  public void binderDied()
  {
    lek.d("QQServiceProxy", "QQServiceForAV mobileQQ process exited!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lib
 * JD-Core Version:    0.7.0.1
 */