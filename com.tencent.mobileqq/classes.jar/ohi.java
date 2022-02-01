import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class ohi
  extends Handler
{
  private WeakReference<ohg> a;
  
  public ohi(ohg paramohg)
  {
    this.a = new WeakReference(paramohg);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ohg localohg = (ohg)this.a.get();
    if ((localohg == null) || (!localohg.b())) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    localohg.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ohi
 * JD-Core Version:    0.7.0.1
 */