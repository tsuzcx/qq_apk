import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class ngg
  extends Handler
{
  ngg(ngf paramngf, Looper paramLooper)
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
    ngf.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ngg
 * JD-Core Version:    0.7.0.1
 */