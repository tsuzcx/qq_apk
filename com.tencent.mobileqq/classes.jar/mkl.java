import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.ui.VideoControlUI;

public class mkl
  extends Handler
{
  public mkl(VideoControlUI paramVideoControlUI, Looper paramLooper)
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
      mbf.a(this.a.a, 1037, str);
      return;
    }
    mbf.a(this.a.a, 1036, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mkl
 * JD-Core Version:    0.7.0.1
 */