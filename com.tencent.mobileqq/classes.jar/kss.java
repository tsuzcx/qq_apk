import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class kss
  extends Handler
{
  WeakReference<ksq> a;
  
  kss(ksq paramksq)
  {
    this.a = new WeakReference(paramksq);
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
    ksq localksq = (ksq)this.a.get();
    if (localksq != null) {}
    switch (paramMessage.what)
    {
    case 2: 
    default: 
    case 1: 
      do
      {
        return;
        ksq.a(localksq, paramMessage.what);
      } while (ksq.a(localksq) == 2);
      sendMessageDelayed(obtainMessage(paramMessage.what), 15000L);
      return;
    }
    ksq.a(localksq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kss
 * JD-Core Version:    0.7.0.1
 */