import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class ntc
  extends Handler
{
  private WeakReference<nsy> a;
  
  public ntc(nsy paramnsy)
  {
    this.a = new WeakReference(paramnsy);
  }
  
  public void handleMessage(Message paramMessage)
  {
    nsy localnsy = (nsy)this.a.get();
    if (localnsy == null) {}
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
          nsy.a(localnsy);
          return;
        }
      } while (nsy.a(localnsy) == null);
      nsy.a(localnsy).a(nsy.a(localnsy));
      return;
    } while (nsy.a(localnsy) == null);
    nsy.a(localnsy).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ntc
 * JD-Core Version:    0.7.0.1
 */