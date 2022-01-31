import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.now.NowVideoController;

public class kop
  extends Handler
{
  public kop(NowVideoController paramNowVideoController, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.a = true;
    NowVideoController.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kop
 * JD-Core Version:    0.7.0.1
 */