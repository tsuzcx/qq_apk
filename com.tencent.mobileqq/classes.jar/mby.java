import com.tencent.biz.pubaccount.VideoPlayRecommendHandler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class mby
  implements Runnable
{
  public mby(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void run()
  {
    if (VideoFeedsPlayActivity.a(this.a) != null)
    {
      long l2 = VideoFeedsPlayActivity.a(this.a);
      long l1 = l2;
      if (l2 == 0L) {
        l1 = Long.parseLong(VideoFeedsPlayActivity.a(this.a).getCurrentAccountUin());
      }
      VideoFeedsPlayActivity.a(this.a).a(l1, VideoFeedsPlayActivity.a(this.a).a(), VideoFeedsPlayActivity.a(this.a), VideoFeedsPlayActivity.a(this.a), VideoFeedsPlayActivity.a(this.a).b(), VideoFeedsPlayActivity.b(this.a), VideoFeedsPlayActivity.i(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mby
 * JD-Core Version:    0.7.0.1
 */