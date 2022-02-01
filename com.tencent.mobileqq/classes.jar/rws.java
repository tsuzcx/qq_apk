import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGuideView;

public class rws
  extends Handler
{
  private rws(VideoFeedsGuideView paramVideoFeedsGuideView) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    VideoFeedsGuideView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rws
 * JD-Core Version:    0.7.0.1
 */