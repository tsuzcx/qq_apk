import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.ui.VideoControlUI;

public class lyy
  extends Handler
{
  public lyy(VideoControlUI paramVideoControlUI, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    String str = (String)paramMessage.obj;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 256: 
      lqb.a(this.a.a, 1037, str);
      return;
    }
    lqb.a(this.a.a, 1036, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lyy
 * JD-Core Version:    0.7.0.1
 */