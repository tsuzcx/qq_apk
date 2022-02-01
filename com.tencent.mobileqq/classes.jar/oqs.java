import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class oqs
  extends Handler
{
  private WeakReference<oqo> a;
  
  public oqs(oqo paramoqo)
  {
    this.a = new WeakReference(paramoqo);
  }
  
  public void handleMessage(Message paramMessage)
  {
    oqo localoqo = (oqo)this.a.get();
    if (localoqo == null) {}
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
          oqo.a(localoqo);
          return;
        }
      } while (oqo.a(localoqo) == null);
      oqo.a(localoqo).a(oqo.a(localoqo));
      return;
    } while (oqo.a(localoqo) == null);
    oqo.a(localoqo).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oqs
 * JD-Core Version:    0.7.0.1
 */