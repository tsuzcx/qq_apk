import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class lfr
  extends Handler
{
  WeakReference<lfq> a;
  
  lfr(Looper paramLooper, lfq paramlfq)
  {
    super(paramLooper);
    this.a = new WeakReference(paramlfq);
  }
  
  public void handleMessage(Message paramMessage)
  {
    lfq locallfq = (lfq)this.a.get();
    if (locallfq != null) {
      locallfq.a(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lfr
 * JD-Core Version:    0.7.0.1
 */