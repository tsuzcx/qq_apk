import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;

class tbs
  implements tmc
{
  tbs(tbq paramtbq) {}
  
  public void a(String paramString, int paramInt)
  {
    tlq.a(tbq.a(this.a), "biz_src_jc_gzh_weishi", paramString, 1, tee.a().a(), 0);
    tbq.a(this.a, "gzh_click", "publish_popup", 1000003);
  }
  
  public void b(String paramString, int paramInt)
  {
    tch.a(tbq.a(this.a), paramString);
    tbq.a(this.a, "gzh_click", "publish_popup", 1000004);
  }
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = 0;
    localWSDownloadParams.mEventId = 401;
    localWSDownloadParams.mTestId = tju.b();
    localWSDownloadParams.mScheme = paramString;
    tfa.a((Activity)tbq.a(this.a), localWSDownloadParams, false);
    tbq.a(this.a, "gzh_click", "publish_popup", 1000002);
  }
  
  public void d(String paramString, int paramInt)
  {
    MiniAppLauncher.startMiniApp(tbq.a(this.a), paramString, 2003, new tbt(this));
    tbq.a(this.a, "gzh_click", "publish_popup", 1000007);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tbs
 * JD-Core Version:    0.7.0.1
 */