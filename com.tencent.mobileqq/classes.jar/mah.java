import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.VideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsListView;
import java.util.List;

public class mah
  implements Runnable
{
  public mah(VideoFeedsAdapter paramVideoFeedsAdapter) {}
  
  public void run()
  {
    VideoInfo localVideoInfo = (VideoInfo)VideoFeedsAdapter.a(this.a).get(0);
    if (VideoFeedsAdapter.a(this.a).getFirstVisiblePosition() == 0)
    {
      View localView = VideoFeedsAdapter.a(this.a).getChildAt(VideoFeedsAdapter.a(this.a).getHeaderViewsCount());
      if ((localView != null) && ((localView.getTag() instanceof VideoFeedsAdapter.VideoItemHolder))) {
        ((VideoFeedsAdapter.VideoItemHolder)localView.getTag()).n.setText(localVideoInfo.k);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mah
 * JD-Core Version:    0.7.0.1
 */