import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsTopicViewGroup;
import java.util.List;

public class mbq
  implements Runnable
{
  public mbq(VideoFeedsAdapter paramVideoFeedsAdapter) {}
  
  public void run()
  {
    VideoInfo localVideoInfo = (VideoInfo)VideoFeedsAdapter.a(this.a).get(0);
    if (VideoFeedsAdapter.a(this.a).getFirstVisiblePosition() == 0)
    {
      Object localObject = VideoFeedsAdapter.a(this.a).getChildAt(VideoFeedsAdapter.a(this.a).getHeaderViewsCount());
      if ((localObject != null) && ((((View)localObject).getTag() instanceof VideoFeedsAdapter.VideoItemHolder)))
      {
        localObject = (VideoFeedsAdapter.VideoItemHolder)((View)localObject).getTag();
        if ((((VideoFeedsAdapter.VideoItemHolder)localObject).a != null) && (localVideoInfo.a != null))
        {
          ((VideoFeedsAdapter.VideoItemHolder)localObject).a.setVisibility(0);
          ((VideoFeedsAdapter.VideoItemHolder)localObject).a.setArticleInfo(VideoFeedsAdapter.a(this.a), this.a, localVideoInfo, VideoFeedsAdapter.c(this.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mbq
 * JD-Core Version:    0.7.0.1
 */