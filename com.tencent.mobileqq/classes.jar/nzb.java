import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class nzb
  extends Handler
{
  nzb(nza paramnza, Looper paramLooper)
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
    this.a.a = true;
    nza.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nzb
 * JD-Core Version:    0.7.0.1
 */