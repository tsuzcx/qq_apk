import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsStartStatistic;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

public class mbt
  implements Runnable
{
  public mbt(VideoFeedsPlayActivity paramVideoFeedsPlayActivity) {}
  
  public void run()
  {
    if (VideoFeedsPlayActivity.a(this.a) != null) {
      VideoFeedsStartStatistic.a(VideoFeedsPlayActivity.a(this.a).getApplication().getApplicationContext());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mbt
 * JD-Core Version:    0.7.0.1
 */