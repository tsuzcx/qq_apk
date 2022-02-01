import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;

public class skl
  implements TopGestureLayout.OnGestureListener
{
  public skl(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void flingLToR()
  {
    if ((VideoFeedsPlayActivity.a(this.a) != null) && (VideoFeedsPlayActivity.a(this.a).a())) {
      return;
    }
    VideoFeedsPlayActivity.a(this.a, true);
    this.a.d();
  }
  
  public void flingRToL() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     skl
 * JD-Core Version:    0.7.0.1
 */