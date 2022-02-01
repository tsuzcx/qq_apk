import android.os.Handler;
import android.os.Message;
import mqq.util.WeakReference;

class rjt
  extends Handler
{
  private WeakReference<rjs> a;
  
  public rjt(rjs paramrjs)
  {
    this.a = new WeakReference(paramrjs);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    rjs localrjs = (rjs)this.a.get();
    if (localrjs == null) {}
    while (paramMessage.what != 101) {
      return;
    }
    rjs.a(localrjs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rjt
 * JD-Core Version:    0.7.0.1
 */