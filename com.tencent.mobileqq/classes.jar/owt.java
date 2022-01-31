import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import java.util.Iterator;
import java.util.List;

final class owt
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
          ows.a(false);
          ows.a().removeMessages(0);
        } while ((ows.a() == null) || (ows.a().size() <= 0));
        paramMessage = ows.a().iterator();
        while (paramMessage.hasNext()) {
          ((owu)paramMessage.next()).a(true);
        }
        ows.a(false);
        ows.a().removeMessages(1);
      } while ((ows.a() == null) || (ows.a().size() <= 0));
      paramMessage = ows.a().iterator();
      while (paramMessage.hasNext()) {
        ((owu)paramMessage.next()).a(false);
      }
    }
    ows.a(true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     owt
 * JD-Core Version:    0.7.0.1
 */