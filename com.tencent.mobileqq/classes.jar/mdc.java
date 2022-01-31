import com.tencent.biz.pubaccount.VideoPlayRecommendHandler;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;

public class mdc
  implements Runnable
{
  public mdc(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void run()
  {
    long l2;
    QQAppInterface localQQAppInterface;
    long l1;
    if (VideoFeedsPlayActivity.a(this.a) != null)
    {
      l2 = VideoFeedsPlayActivity.a(this.a);
      localQQAppInterface = VideoFeedsPlayActivity.a(this.a);
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = l2;
        if (localQQAppInterface == null) {}
      }
    }
    try
    {
      l1 = Long.parseLong(localQQAppInterface.getCurrentAccountUin());
      VideoFeedsPlayActivity.a(this.a).a(l1, VideoFeedsPlayActivity.a(this.a).a(), VideoFeedsPlayActivity.a(this.a), VideoFeedsPlayActivity.a(this.a), VideoFeedsPlayActivity.a(this.a).b(), VideoFeedsPlayActivity.b(this.a), VideoFeedsPlayActivity.i(this.a), VideoFeedsPlayActivity.b(this.a), VideoFeedsPlayActivity.c(this.a));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mdc
 * JD-Core Version:    0.7.0.1
 */