import android.os.Handler;
import android.os.Message;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VideoPlayManager;
import java.util.Iterator;
import java.util.List;

public class rml
  extends Handler
{
  private rml(VideoPlayManager paramVideoPlayManager) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while ((VideoPlayManager.a(this.a) == null) || (rmm.a(VideoPlayManager.a(this.a)) == null));
    Object localObject = rmm.a(VideoPlayManager.a(this.a));
    paramMessage = VideoPlayManager.a(this.a);
    if ((localObject != null) && (((qhw)localObject).b()))
    {
      long l = ((qhw)localObject).a();
      localObject = VideoPlayManager.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((rmn)((Iterator)localObject).next()).a(paramMessage, rmo.a(l) * 1000);
      }
    }
    VideoPlayManager.a(this.a).sendEmptyMessageDelayed(0, VideoPlayManager.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rml
 * JD-Core Version:    0.7.0.1
 */