import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class lcg
  extends Handler
{
  WeakReference<lce> a;
  
  lcg(lce paramlce)
  {
    this.a = new WeakReference(paramlce);
  }
  
  public void a()
  {
    sendMessage(obtainMessage(1));
  }
  
  public void b()
  {
    sendMessage(obtainMessage(3));
    removeMessages(1);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    lce locallce = (lce)this.a.get();
    if (locallce != null) {}
    switch (paramMessage.what)
    {
    case 2: 
    default: 
    case 1: 
      do
      {
        return;
        lce.a(locallce, paramMessage.what);
      } while (lce.a(locallce) == 2);
      sendMessageDelayed(obtainMessage(paramMessage.what), 15000L);
      return;
    }
    lce.a(locallce);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lcg
 * JD-Core Version:    0.7.0.1
 */