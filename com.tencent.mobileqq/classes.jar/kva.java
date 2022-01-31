import android.os.Handler;
import com.tencent.biz.pubaccount.Advertisement.view.AdvertisementSplitedProgressBar;
import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

public class kva
  implements Runnable
{
  public kva(VideoCoverView paramVideoCoverView) {}
  
  public void run()
  {
    if ((VideoCoverView.a(this.a) != null) && (VideoCoverView.a(this.a).isPlaying())) {}
    for (;;)
    {
      try
      {
        i = (int)((float)VideoCoverView.a(this.a).getCurrentPostion() * 1.0F * 100.0F / (float)this.a.a);
        if (VideoCoverView.b(this.a) != VideoCoverView.a(this.a).c) {
          continue;
        }
        if ((i > VideoCoverView.a(this.a).d) || ((i == 0) && (VideoCoverView.a(this.a).d > 50)))
        {
          localAdvertisementSplitedProgressBar = VideoCoverView.a(this.a);
          j = VideoCoverView.b(this.a);
          if (i <= 0) {
            continue;
          }
          localAdvertisementSplitedProgressBar.setProgress(j, i);
        }
      }
      catch (Exception localException)
      {
        AdvertisementSplitedProgressBar localAdvertisementSplitedProgressBar;
        int j;
        continue;
        int i = 0;
        continue;
      }
      VideoCoverView.a(this.a).postDelayed(this, 50L);
      return;
      i = 0;
      continue;
      localAdvertisementSplitedProgressBar = VideoCoverView.a(this.a);
      j = VideoCoverView.b(this.a);
      if (i <= 0) {
        continue;
      }
      localAdvertisementSplitedProgressBar.setProgress(j, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kva
 * JD-Core Version:    0.7.0.1
 */