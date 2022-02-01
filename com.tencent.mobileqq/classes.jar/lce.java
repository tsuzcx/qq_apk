import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class lce
  extends Handler
{
  WeakReference<lcc> a;
  
  lce(lcc paramlcc)
  {
    this.a = new WeakReference(paramlcc);
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
    lcc locallcc = (lcc)this.a.get();
    if (locallcc != null) {}
    switch (paramMessage.what)
    {
    case 2: 
    default: 
    case 1: 
      do
      {
        return;
        lcc.a(locallcc, paramMessage.what);
      } while (lcc.a(locallcc) == 2);
      sendMessageDelayed(obtainMessage(paramMessage.what), 15000L);
      return;
    }
    lcc.a(locallcc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lce
 * JD-Core Version:    0.7.0.1
 */