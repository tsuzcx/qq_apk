import android.os.Handler;
import android.os.Message;
import mqq.util.WeakReference;

class sdi
  extends Handler
{
  private WeakReference<sdh> a;
  
  public sdi(sdh paramsdh)
  {
    this.a = new WeakReference(paramsdh);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    sdh localsdh = (sdh)this.a.get();
    if (localsdh == null) {}
    while (paramMessage.what != 101) {
      return;
    }
    sdh.a(localsdh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sdi
 * JD-Core Version:    0.7.0.1
 */