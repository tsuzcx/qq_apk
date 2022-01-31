import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class lqd
  extends Handler
{
  WeakReference<lqc> a;
  
  lqd(Looper paramLooper, lqc paramlqc)
  {
    super(paramLooper);
    this.a = new WeakReference(paramlqc);
  }
  
  public void handleMessage(Message paramMessage)
  {
    lqc locallqc = (lqc)this.a.get();
    if (locallqc != null) {
      locallqc.a(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lqd
 * JD-Core Version:    0.7.0.1
 */