import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import java.util.Iterator;
import java.util.List;

final class olk
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
          olj.a(false);
          olj.a().removeMessages(0);
        } while ((olj.a() == null) || (olj.a().size() <= 0));
        paramMessage = olj.a().iterator();
        while (paramMessage.hasNext()) {
          ((oll)paramMessage.next()).a(true);
        }
        olj.a(false);
        olj.a().removeMessages(1);
      } while ((olj.a() == null) || (olj.a().size() <= 0));
      paramMessage = olj.a().iterator();
      while (paramMessage.hasNext()) {
        ((oll)paramMessage.next()).a(false);
      }
    }
    olj.a(true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     olk
 * JD-Core Version:    0.7.0.1
 */