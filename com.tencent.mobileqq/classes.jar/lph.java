import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class lph
  extends Handler
{
  WeakReference<lpg> a;
  
  lph(Looper paramLooper, lpg paramlpg)
  {
    super(paramLooper);
    this.a = new WeakReference(paramlpg);
  }
  
  public void handleMessage(Message paramMessage)
  {
    lpg locallpg = (lpg)this.a.get();
    if (locallpg != null) {
      locallpg.a(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lph
 * JD-Core Version:    0.7.0.1
 */