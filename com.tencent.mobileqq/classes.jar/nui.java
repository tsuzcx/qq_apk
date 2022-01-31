import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class nui
  extends Handler
{
  private WeakReference<nug> a;
  
  public nui(nug paramnug)
  {
    this.a = new WeakReference(paramnug);
  }
  
  public void handleMessage(Message paramMessage)
  {
    nug localnug = (nug)this.a.get();
    if ((localnug == null) || (!localnug.b())) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    localnug.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nui
 * JD-Core Version:    0.7.0.1
 */