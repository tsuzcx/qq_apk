import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView;
import java.util.List;

public class mak
  implements Runnable
{
  public mak(VideoFeedsAdapter paramVideoFeedsAdapter) {}
  
  public void run()
  {
    VideoInfo localVideoInfo = (VideoInfo)VideoFeedsAdapter.a(this.a).get(0);
    Object localObject;
    if (VideoFeedsAdapter.a(this.a).getFirstVisiblePosition() == 0)
    {
      localObject = VideoFeedsAdapter.a(this.a).getChildAt(VideoFeedsAdapter.a(this.a).getHeaderViewsCount());
      if ((localObject != null) && ((((View)localObject).getTag() instanceof VideoFeedsAdapter.VideoItemHolder)))
      {
        localObject = (VideoFeedsAdapter.VideoItemHolder)((View)localObject).getTag();
        if (!VideoFeedsAdapter.f(this.a)) {
          break label93;
        }
        ((VideoFeedsAdapter.VideoItemHolder)localObject).j.setText("免流量播放");
      }
    }
    return;
    label93:
    ((VideoFeedsAdapter.VideoItemHolder)localObject).j.setText(VideoFeedsHelper.b(localVideoInfo.b) + "流量");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mak
 * JD-Core Version:    0.7.0.1
 */