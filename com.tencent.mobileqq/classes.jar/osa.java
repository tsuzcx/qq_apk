import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class osa
  extends Handler
{
  private WeakReference<ory> a;
  
  public osa(ory paramory)
  {
    this.a = new WeakReference(paramory);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ory localory = (ory)this.a.get();
    if ((localory == null) || (!localory.b())) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    localory.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     osa
 * JD-Core Version:    0.7.0.1
 */