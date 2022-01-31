import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.OnPlayStateListener;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.VideoPlayParam;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;

public class mfb
  implements VideoPlayManager.OnPlayStateListener
{
  public mfb(VideoVolumeControl paramVideoVolumeControl) {}
  
  public void a(VideoPlayManager.VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramInt2 == 0) {}
    do
    {
      do
      {
        return;
      } while ((paramInt2 == 1) || (paramInt2 == 2));
      if (paramInt2 == 3)
      {
        this.a.a(true, "PLAY_STATE_PLAYING");
        this.a.a(this.a.b(), "video playing", 1);
        return;
      }
    } while ((paramInt2 == 4) || (paramInt2 == 5) || (paramInt2 == 6) || (paramInt2 != 7));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mfb
 * JD-Core Version:    0.7.0.1
 */