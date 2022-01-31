import UserGrowth.stGlobalConfig;
import UserGrowth.stPopWindowsConfig;
import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import java.net.URLDecoder;

class siz
  implements snk
{
  siz(siy paramsiy, Context paramContext) {}
  
  public void a(String paramString, int paramInt)
  {
    snd.a(siy.a(this.jdField_a_of_type_Siy), "biz_src_jc_gzh_weishi", paramString, 1, siy.a(this.jdField_a_of_type_Siy).link_strategy_type, siy.a(this.jdField_a_of_type_Siy));
    smn.a(114, siy.b(this.jdField_a_of_type_Siy), siy.c(this.jdField_a_of_type_Siy), this.jdField_a_of_type_Siy.a.windowsid);
    smp.c(114, this.jdField_a_of_type_Siy.a.type, this.jdField_a_of_type_Siy.a.windowsid);
    WSPublicAccReport.getInstance().reportClickRichBlockPop(1000003, this.jdField_a_of_type_Siy.a.windowsid);
  }
  
  public void b(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramString = URLDecoder.decode(paramString);
      onh.e(siy.a(this.jdField_a_of_type_Siy), paramString);
      snb.a("weishi-813", "阻断rich弹窗:" + paramString);
      smn.a(140, siy.b(this.jdField_a_of_type_Siy), siy.c(this.jdField_a_of_type_Siy), this.jdField_a_of_type_Siy.a.windowsid);
      smp.c(140, this.jdField_a_of_type_Siy.a.type, this.jdField_a_of_type_Siy.a.windowsid);
      WSPublicAccReport.getInstance().reportClickRichBlockPop(1000004, this.jdField_a_of_type_Siy.a.windowsid);
      return;
    }
    snb.c("weishi-813", "阻断rich弹窗:context 不是Activity");
  }
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = siy.a(this.jdField_a_of_type_Siy).link_strategy_type;
    localWSDownloadParams.mEventId = 401;
    localWSDownloadParams.mTestId = smp.b();
    localWSDownloadParams.mScheme = paramString;
    skn.a((Activity)siy.a(this.jdField_a_of_type_Siy), localWSDownloadParams, false);
    smp.c(115, this.jdField_a_of_type_Siy.a.type, this.jdField_a_of_type_Siy.a.windowsid);
    WSPublicAccReport.getInstance().reportClickRichBlockPop(1000002, this.jdField_a_of_type_Siy.a.windowsid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     siz
 * JD-Core Version:    0.7.0.1
 */