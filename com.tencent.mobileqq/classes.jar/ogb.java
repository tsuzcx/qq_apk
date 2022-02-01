import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class ogb
  extends Handler
{
  private WeakReference<ofx> a;
  
  public ogb(ofx paramofx)
  {
    this.a = new WeakReference(paramofx);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ofx localofx = (ofx)this.a.get();
    if (localofx == null) {}
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
          ofx.a(localofx);
          return;
        }
      } while (ofx.a(localofx) == null);
      ofx.a(localofx).a(ofx.a(localofx));
      return;
    } while (ofx.a(localofx) == null);
    ofx.a(localofx).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ogb
 * JD-Core Version:    0.7.0.1
 */