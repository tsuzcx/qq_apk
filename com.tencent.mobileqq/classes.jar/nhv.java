import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class nhv
  extends Handler
{
  private WeakReference<nhr> a;
  
  public nhv(nhr paramnhr)
  {
    this.a = new WeakReference(paramnhr);
  }
  
  public void handleMessage(Message paramMessage)
  {
    nhr localnhr = (nhr)this.a.get();
    if (localnhr == null) {}
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
          nhr.a(localnhr);
          return;
        }
      } while (nhr.a(localnhr) == null);
      nhr.a(localnhr).a(nhr.a(localnhr));
      return;
    } while (nhr.a(localnhr) == null);
    nhr.a(localnhr).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nhv
 * JD-Core Version:    0.7.0.1
 */