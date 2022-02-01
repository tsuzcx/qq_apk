import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class oiw
  extends Handler
{
  private WeakReference<ois> a;
  
  public oiw(ois paramois)
  {
    this.a = new WeakReference(paramois);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ois localois = (ois)this.a.get();
    if (localois == null) {}
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
          ois.a(localois);
          return;
        }
      } while (ois.a(localois) == null);
      ois.a(localois).a(ois.a(localois));
      return;
    } while (ois.a(localois) == null);
    ois.a(localois).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oiw
 * JD-Core Version:    0.7.0.1
 */