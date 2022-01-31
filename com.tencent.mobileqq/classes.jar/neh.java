import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.model.lbs.LbsManager;
import com.tencent.biz.qqstory.model.lbs.LbsManager.LbsUpdateListener;
import com.tencent.biz.qqstory.network.handler.OfficialRecommendListPageLoader;
import com.tencent.biz.qqstory.support.logging.SLog;

public class neh
  implements LbsManager.LbsUpdateListener
{
  public neh(OfficialRecommendListPageLoader paramOfficialRecommendListPageLoader) {}
  
  public void a(boolean paramBoolean, BasicLocation paramBasicLocation)
  {
    SLog.b(":OfficialRecommendListPageLoader", "GetOfficialRecommendStoryListRequest onLbsUpdate.");
    if (!paramBoolean) {
      SLog.e(":OfficialRecommendListPageLoader", "GetOfficialRecommendStoryListRequest failed.");
    }
    this.a.a(paramBasicLocation);
    ((LbsManager)SuperManager.a(9)).b(OfficialRecommendListPageLoader.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     neh
 * JD-Core Version:    0.7.0.1
 */