import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class nwg
  extends Handler
{
  private WeakReference<nwc> a;
  
  public nwg(nwc paramnwc)
  {
    this.a = new WeakReference(paramnwc);
  }
  
  public void handleMessage(Message paramMessage)
  {
    nwc localnwc = (nwc)this.a.get();
    if (localnwc == null) {}
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 1: 
          nwc.a(localnwc);
          return;
        }
      } while (nwc.a(localnwc) == null);
      nwc.a(localnwc).a(nwc.a(localnwc));
      return;
    } while (nwc.a(localnwc) == null);
    nwc.a(localnwc).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nwg
 * JD-Core Version:    0.7.0.1
 */