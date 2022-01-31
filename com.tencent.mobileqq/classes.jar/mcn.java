import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class mcn
  extends Handler
{
  public mcn(mcm parammcm, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    mcm.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mcn
 * JD-Core Version:    0.7.0.1
 */