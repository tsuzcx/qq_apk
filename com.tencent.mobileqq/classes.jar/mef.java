import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

public class mef
  implements Runnable
{
  public mef(VideoRecommendManager paramVideoRecommendManager) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
    VideoRecommendManager.a(this.a, ReadInJoyHelper.E(localQQAppInterface));
    VideoRecommendManager.b(this.a, ReadInJoyHelper.F(localQQAppInterface));
    VideoRecommendManager.a(this.a, ReadInJoyHelper.b(localQQAppInterface));
    VideoRecommendManager.c(this.a, ReadInJoyHelper.G(localQQAppInterface));
    if ((VideoRecommendManager.a(this.a) < 0.0F) || (VideoRecommendManager.a(this.a) > 1.0D)) {
      VideoRecommendManager.a(this.a, 0.8F);
    }
    if (VideoRecommendManager.a(this.a) < 1000) {
      VideoRecommendManager.b(this.a, 40000);
    }
    if (VideoRecommendManager.b(this.a) == 1) {
      VideoRecommendManager.a(this.a, true);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoReommendManager", 2, "init() 开关配置，mIsOpened = " + VideoRecommendManager.a(this.a) + ", mStrategyID = " + VideoRecommendManager.b(this.a) + ", mStrategyDurationLimit = " + VideoRecommendManager.a(this.a) + ", mStrategyDurationPercent = " + VideoRecommendManager.a(this.a) + ", mOperator = " + VideoRecommendManager.c(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mef
 * JD-Core Version:    0.7.0.1
 */