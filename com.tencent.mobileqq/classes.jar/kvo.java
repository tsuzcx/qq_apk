import android.os.IBinder.DeathRecipient;

class kvo
  implements IBinder.DeathRecipient
{
  kvo(kvn paramkvn) {}
  
  public void binderDied()
  {
    krx.d("QQServiceProxy", "QQServiceForAV mobileQQ process exited!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kvo
 * JD-Core Version:    0.7.0.1
 */