import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class lpe
  extends Handler
{
  WeakReference<lpd> a;
  
  lpe(Looper paramLooper, lpd paramlpd)
  {
    super(paramLooper);
    this.a = new WeakReference(paramlpd);
  }
  
  public void handleMessage(Message paramMessage)
  {
    lpd locallpd = (lpd)this.a.get();
    if (locallpd != null) {
      locallpd.a(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lpe
 * JD-Core Version:    0.7.0.1
 */