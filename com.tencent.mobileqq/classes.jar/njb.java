import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class njb
  extends Handler
{
  private WeakReference<niz> a;
  
  public njb(niz paramniz)
  {
    this.a = new WeakReference(paramniz);
  }
  
  public void handleMessage(Message paramMessage)
  {
    niz localniz = (niz)this.a.get();
    if ((localniz == null) || (!localniz.b())) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    localniz.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     njb
 * JD-Core Version:    0.7.0.1
 */