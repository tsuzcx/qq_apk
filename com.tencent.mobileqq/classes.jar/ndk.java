import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ndk
  extends Handler
{
  ndk(ndj paramndj, Looper paramLooper)
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
    ndj.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ndk
 * JD-Core Version:    0.7.0.1
 */