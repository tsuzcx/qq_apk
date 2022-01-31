import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import java.util.Iterator;
import java.util.List;

final class oww
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
          owv.a(false);
          owv.a().removeMessages(0);
        } while ((owv.a() == null) || (owv.a().size() <= 0));
        paramMessage = owv.a().iterator();
        while (paramMessage.hasNext()) {
          ((owx)paramMessage.next()).a(true);
        }
        owv.a(false);
        owv.a().removeMessages(1);
      } while ((owv.a() == null) || (owv.a().size() <= 0));
      paramMessage = owv.a().iterator();
      while (paramMessage.hasNext()) {
        ((owx)paramMessage.next()).a(false);
      }
    }
    owv.a(true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oww
 * JD-Core Version:    0.7.0.1
 */