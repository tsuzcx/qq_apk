import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;

public class qqs
  implements qmy
{
  private qqs(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a(boolean paramBoolean)
  {
    boolean bool2 = true;
    VideoFeedsRecyclerView localVideoFeedsRecyclerView;
    if (VideoFeedsRecommendFragment.a(this.a) != null)
    {
      VideoFeedsRecommendFragment.a(this.a).a.d(paramBoolean);
      if ((!VideoFeedsRecommendFragment.a(this.a).b) && ((VideoFeedsRecommendFragment.a(this.a).itemView.getParent() instanceof VideoFeedsRecyclerView)))
      {
        localVideoFeedsRecyclerView = (VideoFeedsRecyclerView)VideoFeedsRecommendFragment.a(this.a).itemView.getParent();
        if (paramBoolean) {
          break label201;
        }
        bool1 = true;
        localVideoFeedsRecyclerView.setScrollable(bool1);
      }
    }
    if (paramBoolean)
    {
      VideoFeedsRecommendFragment.a(this.a).setNeedDetectOrientation(this.a.getActivity(), false);
      label112:
      if (!VideoFeedsRecommendFragment.b(this.a))
      {
        localVideoFeedsRecyclerView = VideoFeedsRecommendFragment.a(this.a);
        if (paramBoolean) {
          break label223;
        }
      }
    }
    label201:
    label223:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localVideoFeedsRecyclerView.setScrollable(bool1);
      if ((!paramBoolean) && (VideoFeedsRecommendFragment.c(this.a)))
      {
        VideoFeedsRecommendFragment.a(this.a).a();
        VideoFeedsRecommendFragment.a(this.a, false);
      }
      if (VideoFeedsRecommendFragment.a(this.a) != null) {
        VideoFeedsRecommendFragment.a(this.a).a(paramBoolean);
      }
      return;
      bool1 = false;
      break;
      VideoFeedsRecommendFragment.a(this.a, VideoFeedsRecommendFragment.a(this.a));
      break label112;
    }
  }
  
  public void b()
  {
    this.a.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qqs
 * JD-Core Version:    0.7.0.1
 */