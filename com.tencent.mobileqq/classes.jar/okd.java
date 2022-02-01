import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class okd
  extends Handler
{
  private WeakReference<okb> a;
  
  public okd(okb paramokb)
  {
    this.a = new WeakReference(paramokb);
  }
  
  public void handleMessage(Message paramMessage)
  {
    okb localokb = (okb)this.a.get();
    if ((localokb == null) || (!localokb.b())) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    localokb.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okd
 * JD-Core Version:    0.7.0.1
 */