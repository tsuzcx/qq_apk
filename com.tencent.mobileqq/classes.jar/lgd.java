import android.os.IBinder.DeathRecipient;

class lgd
  implements IBinder.DeathRecipient
{
  lgd(lgc paramlgc) {}
  
  public void binderDied()
  {
    lcl.d("QQServiceProxy", "QQServiceForAV mobileQQ process exited!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lgd
 * JD-Core Version:    0.7.0.1
 */