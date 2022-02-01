import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class mcg
  extends Handler
{
  public mcg(mcf parammcf, Looper paramLooper)
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
    mcf.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mcg
 * JD-Core Version:    0.7.0.1
 */