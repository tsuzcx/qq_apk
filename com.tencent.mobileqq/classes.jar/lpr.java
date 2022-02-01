import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class lpr
  extends Handler
{
  WeakReference<lpq> a;
  
  lpr(Looper paramLooper, lpq paramlpq)
  {
    super(paramLooper);
    this.a = new WeakReference(paramlpq);
  }
  
  public void handleMessage(Message paramMessage)
  {
    lpq locallpq = (lpq)this.a.get();
    if (locallpq != null) {
      locallpq.a(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lpr
 * JD-Core Version:    0.7.0.1
 */