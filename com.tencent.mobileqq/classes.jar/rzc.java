import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager;
import java.util.Iterator;
import java.util.List;

public class rzc
  extends Handler
{
  private rzc(VideoPlayManager paramVideoPlayManager) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while ((VideoPlayManager.a(this.a) == null) || (rzd.a(VideoPlayManager.a(this.a)) == null));
    Object localObject = rzd.a(VideoPlayManager.a(this.a));
    paramMessage = VideoPlayManager.a(this.a);
    if ((localObject != null) && (((qub)localObject).c()))
    {
      long l = ((qub)localObject).a();
      localObject = VideoPlayManager.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((rze)((Iterator)localObject).next()).a(paramMessage, rzf.a(l) * 1000);
      }
    }
    VideoPlayManager.a(this.a).sendEmptyMessageDelayed(0, VideoPlayManager.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rzc
 * JD-Core Version:    0.7.0.1
 */