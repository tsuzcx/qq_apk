import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class nxn
  extends Handler
{
  private WeakReference<nxl> a;
  
  public nxn(nxl paramnxl)
  {
    this.a = new WeakReference(paramnxl);
  }
  
  public void handleMessage(Message paramMessage)
  {
    nxl localnxl = (nxl)this.a.get();
    if ((localnxl == null) || (!localnxl.b())) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    localnxl.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nxn
 * JD-Core Version:    0.7.0.1
 */