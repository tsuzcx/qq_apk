import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class ntf
  extends Handler
{
  private WeakReference<ntb> a;
  
  public ntf(ntb paramntb)
  {
    this.a = new WeakReference(paramntb);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ntb localntb = (ntb)this.a.get();
    if (localntb == null) {}
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
          ntb.a(localntb);
          return;
        }
      } while (ntb.a(localntb) == null);
      ntb.a(localntb).a(ntb.a(localntb));
      return;
    } while (ntb.a(localntb) == null);
    ntb.a(localntb).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ntf
 * JD-Core Version:    0.7.0.1
 */