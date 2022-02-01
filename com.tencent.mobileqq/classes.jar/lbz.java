import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class lbz
  extends Handler
{
  WeakReference<lbx> a;
  
  lbz(lbx paramlbx)
  {
    this.a = new WeakReference(paramlbx);
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
    lbx locallbx = (lbx)this.a.get();
    if (locallbx != null) {}
    switch (paramMessage.what)
    {
    case 2: 
    default: 
    case 1: 
      do
      {
        return;
        lbx.a(locallbx, paramMessage.what);
      } while (lbx.a(locallbx) == 2);
      sendMessageDelayed(obtainMessage(paramMessage.what), 15000L);
      return;
    }
    lbx.a(locallbx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lbz
 * JD-Core Version:    0.7.0.1
 */