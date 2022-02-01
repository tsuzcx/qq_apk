import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.ui.VideoControlUI;

public class mkf
  extends Handler
{
  public mkf(VideoControlUI paramVideoControlUI, Looper paramLooper)
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
      mbb.a(this.a.a, 1037, str);
      return;
    }
    mbb.a(this.a.a, 1036, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mkf
 * JD-Core Version:    0.7.0.1
 */