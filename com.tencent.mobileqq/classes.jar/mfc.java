import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class mfc
  extends Handler
{
  public mfc(mfb parammfb, Looper paramLooper)
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
    mfb.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mfc
 * JD-Core Version:    0.7.0.1
 */