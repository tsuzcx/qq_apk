import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class lpw
  extends Handler
{
  WeakReference<lpv> a;
  
  lpw(Looper paramLooper, lpv paramlpv)
  {
    super(paramLooper);
    this.a = new WeakReference(paramlpv);
  }
  
  public void handleMessage(Message paramMessage)
  {
    lpv locallpv = (lpv)this.a.get();
    if (locallpv != null) {
      locallpv.a(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lpw
 * JD-Core Version:    0.7.0.1
 */