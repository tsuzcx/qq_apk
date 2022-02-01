package cooperation.vip.ad;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import mqq.os.MqqHandler;

class TianshuBannerManager$TianShuGetSplashCallback
  implements TianShuGetAdvCallback
{
  public String a;
  
  public TianshuBannerManager$TianShuGetSplashCallback(TianshuBannerManager paramTianshuBannerManager, String paramString)
  {
    this.a = paramString;
  }
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    if ((paramBoolean) && (paramGetAdsRsp != null)) {
      ThreadManager.getUIHandler().postDelayed(new TianshuBannerManager.TianShuGetSplashCallback.1(this, paramGetAdsRsp), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.ad.TianshuBannerManager.TianShuGetSplashCallback
 * JD-Core Version:    0.7.0.1
 */