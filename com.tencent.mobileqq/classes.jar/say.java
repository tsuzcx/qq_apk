import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;

public class say
  implements ryi
{
  private say(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void a()
  {
    this.a.b(true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (VideoFeedsRecommendFragment.a(this.a) != null) {
      VideoFeedsRecommendFragment.a(this.a).a.e(paramBoolean);
    }
    VideoFeedsRecyclerView localVideoFeedsRecyclerView;
    if (paramBoolean)
    {
      VideoFeedsRecommendFragment.a(this.a).setNeedDetectOrientation(this.a.getActivity(), false);
      if (!VideoFeedsRecommendFragment.b(this.a))
      {
        localVideoFeedsRecyclerView = VideoFeedsRecommendFragment.a(this.a);
        if (paramBoolean) {
          break label152;
        }
      }
    }
    label152:
    for (boolean bool = true;; bool = false)
    {
      localVideoFeedsRecyclerView.setScrollable(bool);
      if ((!paramBoolean) && (VideoFeedsRecommendFragment.c(this.a)))
      {
        VideoFeedsRecommendFragment.a(this.a).a();
        VideoFeedsRecommendFragment.a(this.a, false);
      }
      if (VideoFeedsRecommendFragment.a(this.a) != null) {
        VideoFeedsRecommendFragment.a(this.a).a(paramBoolean);
      }
      return;
      VideoFeedsRecommendFragment.a(this.a, VideoFeedsRecommendFragment.a(this.a));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     say
 * JD-Core Version:    0.7.0.1
 */