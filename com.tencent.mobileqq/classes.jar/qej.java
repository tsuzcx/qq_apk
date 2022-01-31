import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendFragment;
import com.tencent.mobileqq.activity.fling.TopGestureLayout.OnGestureListener;

public class qej
  implements TopGestureLayout.OnGestureListener
{
  public qej(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void flingLToR()
  {
    if ((VideoFeedsPlayActivity.a(this.a) != null) && (VideoFeedsPlayActivity.a(this.a).a())) {
      return;
    }
    VideoFeedsPlayActivity.a(this.a, true);
    this.a.d();
  }
  
  public void flingRToL()
  {
    if (VideoFeedsPlayActivity.a(this.a) != null) {
      VideoFeedsPlayActivity.a(this.a).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qej
 * JD-Core Version:    0.7.0.1
 */