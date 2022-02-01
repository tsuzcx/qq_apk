import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import java.util.Iterator;
import java.util.List;

final class pst
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
          pss.a(false);
          pss.a().removeMessages(0);
        } while ((pss.a() == null) || (pss.a().size() <= 0));
        paramMessage = pss.a().iterator();
        while (paramMessage.hasNext()) {
          ((psu)paramMessage.next()).a(true);
        }
        pss.a(false);
        pss.a().removeMessages(1);
      } while ((pss.a() == null) || (pss.a().size() <= 0));
      paramMessage = pss.a().iterator();
      while (paramMessage.hasNext()) {
        ((psu)paramMessage.next()).a(false);
      }
    }
    pss.a(true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pst
 * JD-Core Version:    0.7.0.1
 */