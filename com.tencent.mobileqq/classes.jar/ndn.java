import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ndn
  extends Handler
{
  ndn(ndm paramndm, Looper paramLooper)
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
    ndm.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ndn
 * JD-Core Version:    0.7.0.1
 */