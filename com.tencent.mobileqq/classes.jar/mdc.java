import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class mdc
  extends Handler
{
  public mdc(mdb parammdb, Looper paramLooper)
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
    mdb.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mdc
 * JD-Core Version:    0.7.0.1
 */