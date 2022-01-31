import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class num
  extends Handler
{
  private WeakReference<nuj> a;
  
  public num(nuj paramnuj)
  {
    this.a = new WeakReference(paramnuj);
  }
  
  public void handleMessage(Message paramMessage)
  {
    nuj localnuj = (nuj)this.a.get();
    if ((localnuj == null) || (!localnuj.b())) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    localnuj.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     num
 * JD-Core Version:    0.7.0.1
 */