import android.os.Handler;
import android.os.Message;
import com.tencent.av.ui.funchat.zimu.ZimuViewMotion;
import java.lang.ref.WeakReference;

public final class mdl
  extends Handler
{
  WeakReference<ZimuViewMotion> a;
  
  public mdl(ZimuViewMotion paramZimuViewMotion)
  {
    this.a = new WeakReference(paramZimuViewMotion);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
      paramMessage = (ZimuViewMotion)this.a.get();
    } while (paramMessage == null);
    paramMessage.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mdl
 * JD-Core Version:    0.7.0.1
 */