import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecommendManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

public class mhz
  implements Runnable
{
  public mhz(VideoFeedsRecommendManager paramVideoFeedsRecommendManager) {}
  
  public void run()
  {
    VideoFeedsRecommendManager.a(this.a, ReadInJoyHelper.D(VideoFeedsRecommendManager.a(this.a)));
    VideoFeedsRecommendManager.b(this.a, ReadInJoyHelper.E(VideoFeedsRecommendManager.a(this.a)));
    VideoFeedsRecommendManager.a(this.a, ReadInJoyHelper.a(VideoFeedsRecommendManager.a(this.a)));
    VideoFeedsRecommendManager.c(this.a, ReadInJoyHelper.F(VideoFeedsRecommendManager.a(this.a)));
    if ((VideoFeedsRecommendManager.a(this.a) < 0.0F) || (VideoFeedsRecommendManager.a(this.a) > 1.0D)) {
      VideoFeedsRecommendManager.a(this.a, 0.8F);
    }
    if (VideoFeedsRecommendManager.a(this.a) < 1000) {
      VideoFeedsRecommendManager.b(this.a, 40000);
    }
    if (VideoFeedsRecommendManager.b(this.a) != 0) {
      VideoFeedsRecommendManager.a(this.a, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsRecommendManager", 2, "init() 开关配置，mIsOpened = " + VideoFeedsRecommendManager.a(this.a) + ", mStrategyID = " + VideoFeedsRecommendManager.b(this.a) + ", mStrategyDurationLimit = " + VideoFeedsRecommendManager.a(this.a) + ", mStrategyDurationPercent = " + VideoFeedsRecommendManager.a(this.a) + ", mOperator = " + VideoFeedsRecommendManager.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mhz
 * JD-Core Version:    0.7.0.1
 */