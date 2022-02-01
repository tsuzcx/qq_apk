package cooperation.vip.ad;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import mqq.os.MqqHandler;

class TianshuAdManager$1
  implements TianShuGetAdvCallback
{
  TianshuAdManager$1(TianshuAdManager paramTianshuAdManager) {}
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    if ((paramBoolean) && (paramGetAdsRsp != null)) {
      ThreadManager.getUIHandler().postDelayed(new TianshuAdManager.1.1(this, paramGetAdsRsp), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.ad.TianshuAdManager.1
 * JD-Core Version:    0.7.0.1
 */