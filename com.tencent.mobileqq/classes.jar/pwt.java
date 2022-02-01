import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class pwt
  extends Handler
{
  pwt(pwr parampwr, Looper paramLooper)
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
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pwt
 * JD-Core Version:    0.7.0.1
 */