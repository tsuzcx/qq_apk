import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class ldh
  extends Handler
{
  WeakReference<ldf> a;
  
  ldh(ldf paramldf)
  {
    this.a = new WeakReference(paramldf);
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
    ldf localldf = (ldf)this.a.get();
    if (localldf != null) {}
    switch (paramMessage.what)
    {
    case 2: 
    default: 
    case 1: 
      do
      {
        return;
        ldf.a(localldf, paramMessage.what);
      } while (ldf.a(localldf) == 2);
      sendMessageDelayed(obtainMessage(paramMessage.what), 15000L);
      return;
    }
    ldf.a(localldf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     ldh
 * JD-Core Version:    0.7.0.1
 */