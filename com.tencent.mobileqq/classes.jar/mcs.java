import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class mcs
  extends Handler
{
  public mcs(mcr parammcr, Looper paramLooper)
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
    mcr.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mcs
 * JD-Core Version:    0.7.0.1
 */