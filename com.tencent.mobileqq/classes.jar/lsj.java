import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class lsj
  extends Handler
{
  WeakReference<lsi> a;
  
  lsj(Looper paramLooper, lsi paramlsi)
  {
    super(paramLooper);
    this.a = new WeakReference(paramlsi);
  }
  
  public void handleMessage(Message paramMessage)
  {
    lsi locallsi = (lsi)this.a.get();
    if (locallsi != null) {
      locallsi.a(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lsj
 * JD-Core Version:    0.7.0.1
 */