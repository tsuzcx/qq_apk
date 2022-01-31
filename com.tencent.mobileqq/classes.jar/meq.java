import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;

public class meq
  extends Handler
{
  public meq(VideoUIManager paramVideoUIManager) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 100: 
      VideoUIManager.a(this.a);
      return;
    case 101: 
      this.a.f();
      return;
    case 102: 
      VideoUIManager.b(this.a);
      sendEmptyMessageDelayed(102, 1000L);
      return;
    }
    VideoUIManager.a(this.a, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     meq
 * JD-Core Version:    0.7.0.1
 */