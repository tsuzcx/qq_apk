import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;

public class qqy
  extends osp
{
  private qqy(VideoFeedsRecommendFragment paramVideoFeedsRecommendFragment) {}
  
  public void j()
  {
    if ((this.a.getActivity() instanceof VideoFeedsPlayActivity))
    {
      ((VideoFeedsPlayActivity)this.a.getActivity()).d();
      this.a.getActivity().overridePendingTransition(0, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qqy
 * JD-Core Version:    0.7.0.1
 */