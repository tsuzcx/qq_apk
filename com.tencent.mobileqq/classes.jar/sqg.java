import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

public class sqg
  extends Handler
{
  private WeakReference<VideoPlayManager> a;
  
  public sqg(VideoPlayManager paramVideoPlayManager)
  {
    this.a = new WeakReference(paramVideoPlayManager);
  }
  
  public void handleMessage(Message paramMessage)
  {
    VideoPlayManager localVideoPlayManager;
    if (this.a != null)
    {
      localVideoPlayManager = (VideoPlayManager)this.a.get();
      if (localVideoPlayManager != null) {
        switch (paramMessage.what)
        {
        }
      }
    }
    do
    {
      return;
      localVideoPlayManager = null;
      break;
    } while ((VideoPlayManager.a(localVideoPlayManager) == null) || (sqh.a(VideoPlayManager.a(localVideoPlayManager)) == null));
    Object localObject = sqh.a(VideoPlayManager.a(localVideoPlayManager));
    paramMessage = VideoPlayManager.a(localVideoPlayManager);
    if ((localObject != null) && (((rjn)localObject).c()))
    {
      long l = ((rjn)localObject).a();
      localObject = VideoPlayManager.a(localVideoPlayManager).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((sqi)((Iterator)localObject).next()).a(paramMessage, sqj.a(l) * 1000);
      }
    }
    VideoPlayManager.a(localVideoPlayManager).sendEmptyMessageDelayed(0, VideoPlayManager.a(localVideoPlayManager));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sqg
 * JD-Core Version:    0.7.0.1
 */