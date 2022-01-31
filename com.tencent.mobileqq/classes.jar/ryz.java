import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager;
import java.util.Iterator;
import java.util.List;

public class ryz
  extends Handler
{
  private ryz(VideoPlayManager paramVideoPlayManager) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while ((VideoPlayManager.a(this.a) == null) || (rza.a(VideoPlayManager.a(this.a)) == null));
    Object localObject = rza.a(VideoPlayManager.a(this.a));
    paramMessage = VideoPlayManager.a(this.a);
    if ((localObject != null) && (((qty)localObject).c()))
    {
      long l = ((qty)localObject).a();
      localObject = VideoPlayManager.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((rzb)((Iterator)localObject).next()).a(paramMessage, rzc.a(l) * 1000);
      }
    }
    VideoPlayManager.a(this.a).sendEmptyMessageDelayed(0, VideoPlayManager.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ryz
 * JD-Core Version:    0.7.0.1
 */