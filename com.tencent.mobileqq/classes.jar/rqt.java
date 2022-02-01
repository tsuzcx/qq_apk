import android.os.Handler;
import android.os.Message;
import mqq.util.WeakReference;

class rqt
  extends Handler
{
  private WeakReference<rqs> a;
  
  public rqt(rqs paramrqs)
  {
    this.a = new WeakReference(paramrqs);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    rqs localrqs = (rqs)this.a.get();
    if (localrqs == null) {}
    while (paramMessage.what != 101) {
      return;
    }
    rqs.a(localrqs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rqt
 * JD-Core Version:    0.7.0.1
 */