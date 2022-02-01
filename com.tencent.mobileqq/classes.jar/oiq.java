import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class oiq
  extends Handler
{
  private WeakReference<oio> a;
  
  public oiq(oio paramoio)
  {
    this.a = new WeakReference(paramoio);
  }
  
  public void handleMessage(Message paramMessage)
  {
    oio localoio = (oio)this.a.get();
    if ((localoio == null) || (!localoio.b())) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    localoio.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oiq
 * JD-Core Version:    0.7.0.1
 */