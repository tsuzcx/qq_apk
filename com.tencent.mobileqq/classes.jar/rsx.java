import android.os.Handler;
import android.os.Message;
import mqq.util.WeakReference;

class rsx
  extends Handler
{
  private WeakReference<rsw> a;
  
  public rsx(rsw paramrsw)
  {
    this.a = new WeakReference(paramrsw);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    rsw localrsw = (rsw)this.a.get();
    if (localrsw == null) {}
    while (paramMessage.what != 101) {
      return;
    }
    rsw.a(localrsw);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rsx
 * JD-Core Version:    0.7.0.1
 */