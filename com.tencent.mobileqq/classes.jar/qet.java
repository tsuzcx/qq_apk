import android.os.Handler;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment.1.1;

public class qet
  implements pxm
{
  public qet(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a()
  {
    if ((VideoFeedsRecommendFragment.a(this.a)) && (VideoFeedsRecommendFragment.a(this.a) != null) && (VideoFeedsRecommendFragment.a(this.a).a != null) && (VideoFeedsRecommendFragment.a(this.a).a.a != null) && (VideoFeedsRecommendFragment.a(this.a).a.a.a != null) && (VideoFeedsRecommendFragment.a(this.a) != null)) {
      if ((npi.e(VideoFeedsRecommendFragment.a(this.a).a.a.a)) && (!VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).c)))
      {
        localVideoInfo = VideoFeedsRecommendFragment.a(this.a).a(VideoFeedsRecommendFragment.a(this.a).c);
        if (localVideoInfo != null)
        {
          i = VideoFeedsRecommendFragment.a(this.a).getAdapterPosition() - 1;
          j = VideoFeedsRecommendFragment.a(this.a).c;
          VideoFeedsRecommendFragment.a(this.a).a(i, j, localVideoInfo);
          noy.a(this.a.getActivity(), 50, true);
        }
      }
    }
    while ((VideoFeedsRecommendFragment.a(this.a) == null) || (VideoFeedsRecommendFragment.a(this.a) == null))
    {
      VideoInfo localVideoInfo;
      int i;
      int j;
      VideoFeedsRecommendFragment.a(this.a).postDelayed(new VideoFeedsRecommendFragment.1.1(this, i + 1), 0L);
      do
      {
        return;
      } while (VideoFeedsRecommendFragment.a(this.a) == null);
      VideoFeedsRecommendFragment.a(this.a).c();
      return;
    }
    VideoFeedsRecommendFragment.a(this.a).c(VideoFeedsRecommendFragment.a(this.a).a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qet
 * JD-Core Version:    0.7.0.1
 */