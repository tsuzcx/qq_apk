import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class ohj
  extends Handler
{
  private WeakReference<ohf> a;
  
  public ohj(ohf paramohf)
  {
    this.a = new WeakReference(paramohf);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ohf localohf = (ohf)this.a.get();
    if (localohf == null) {}
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
          ohf.a(localohf);
          return;
        }
      } while (ohf.a(localohf) == null);
      ohf.a(localohf).a(ohf.a(localohf));
      return;
    } while (ohf.a(localohf) == null);
    ohf.a(localohf).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ohj
 * JD-Core Version:    0.7.0.1
 */