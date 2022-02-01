import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class mdg
  extends Handler
{
  public mdg(mdf parammdf, Looper paramLooper)
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
    mdf.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mdg
 * JD-Core Version:    0.7.0.1
 */