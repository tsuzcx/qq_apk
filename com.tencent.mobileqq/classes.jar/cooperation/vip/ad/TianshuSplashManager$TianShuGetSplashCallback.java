package cooperation.vip.ad;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import cooperation.vip.pb.TianShuAccess.GetAdsRsp;
import mqq.os.MqqHandler;

class TianshuSplashManager$TianShuGetSplashCallback
  implements TianShuGetAdvCallback
{
  public String a;
  
  public TianshuSplashManager$TianShuGetSplashCallback(TianshuSplashManager paramTianshuSplashManager, String paramString)
  {
    this.a = paramString;
  }
  
  public void onGetAdvs(boolean paramBoolean, TianShuAccess.GetAdsRsp paramGetAdsRsp)
  {
    if ((paramBoolean) && (paramGetAdsRsp != null)) {
      ThreadManager.getUIHandler().postDelayed(new TianshuSplashManager.TianShuGetSplashCallback.1(this, paramGetAdsRsp), 500L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.ad.TianshuSplashManager.TianShuGetSplashCallback
 * JD-Core Version:    0.7.0.1
 */