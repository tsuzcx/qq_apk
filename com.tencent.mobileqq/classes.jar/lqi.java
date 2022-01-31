import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class lqi
  extends Handler
{
  WeakReference<lqh> a;
  
  lqi(Looper paramLooper, lqh paramlqh)
  {
    super(paramLooper);
    this.a = new WeakReference(paramlqh);
  }
  
  public void handleMessage(Message paramMessage)
  {
    lqh locallqh = (lqh)this.a.get();
    if (locallqh != null) {
      locallqh.a(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lqi
 * JD-Core Version:    0.7.0.1
 */