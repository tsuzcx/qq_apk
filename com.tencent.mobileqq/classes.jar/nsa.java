import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class nsa
  extends Handler
{
  nsa(nrz paramnrz, Looper paramLooper)
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
    nrz.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nsa
 * JD-Core Version:    0.7.0.1
 */