import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class lfg
  extends Handler
{
  WeakReference<lfe> a;
  
  lfg(lfe paramlfe)
  {
    this.a = new WeakReference(paramlfe);
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
    lfe locallfe = (lfe)this.a.get();
    if (locallfe != null) {}
    switch (paramMessage.what)
    {
    case 2: 
    default: 
    case 1: 
      do
      {
        return;
        lfe.a(locallfe, paramMessage.what);
      } while (lfe.a(locallfe) == 2);
      sendMessageDelayed(obtainMessage(paramMessage.what), 15000L);
      return;
    }
    lfe.a(locallfe);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lfg
 * JD-Core Version:    0.7.0.1
 */