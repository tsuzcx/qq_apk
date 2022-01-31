import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import java.util.Iterator;
import java.util.List;

final class pby
  implements Handler.Callback
{
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        do
        {
          return true;
          pbx.a(false);
          pbx.a().removeMessages(0);
        } while ((pbx.a() == null) || (pbx.a().size() <= 0));
        paramMessage = pbx.a().iterator();
        while (paramMessage.hasNext()) {
          ((pbz)paramMessage.next()).a(true);
        }
        pbx.a(false);
        pbx.a().removeMessages(1);
      } while ((pbx.a() == null) || (pbx.a().size() <= 0));
      paramMessage = pbx.a().iterator();
      while (paramMessage.hasNext()) {
        ((pbz)paramMessage.next()).a(false);
      }
    }
    pbx.a(true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pby
 * JD-Core Version:    0.7.0.1
 */