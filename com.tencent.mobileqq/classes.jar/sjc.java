import UserGrowth.stGlobalConfig;
import UserGrowth.stPopWindowsConfig;
import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import java.net.URLDecoder;

class sjc
  implements snn
{
  sjc(sjb paramsjb, Context paramContext) {}
  
  public void a(String paramString, int paramInt)
  {
    sng.a(sjb.a(this.jdField_a_of_type_Sjb), "biz_src_jc_gzh_weishi", paramString, 1, sjb.a(this.jdField_a_of_type_Sjb).link_strategy_type, sjb.a(this.jdField_a_of_type_Sjb));
    smq.a(114, sjb.b(this.jdField_a_of_type_Sjb), sjb.c(this.jdField_a_of_type_Sjb), this.jdField_a_of_type_Sjb.a.windowsid);
    sms.c(114, this.jdField_a_of_type_Sjb.a.type, this.jdField_a_of_type_Sjb.a.windowsid);
    WSPublicAccReport.getInstance().reportClickRichBlockPop(1000003, this.jdField_a_of_type_Sjb.a.windowsid);
  }
  
  public void b(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramString = URLDecoder.decode(paramString);
      onk.e(sjb.a(this.jdField_a_of_type_Sjb), paramString);
      sne.a("weishi-813", "阻断rich弹窗:" + paramString);
      smq.a(140, sjb.b(this.jdField_a_of_type_Sjb), sjb.c(this.jdField_a_of_type_Sjb), this.jdField_a_of_type_Sjb.a.windowsid);
      sms.c(140, this.jdField_a_of_type_Sjb.a.type, this.jdField_a_of_type_Sjb.a.windowsid);
      WSPublicAccReport.getInstance().reportClickRichBlockPop(1000004, this.jdField_a_of_type_Sjb.a.windowsid);
      return;
    }
    sne.c("weishi-813", "阻断rich弹窗:context 不是Activity");
  }
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = sjb.a(this.jdField_a_of_type_Sjb).link_strategy_type;
    localWSDownloadParams.mEventId = 401;
    localWSDownloadParams.mTestId = sms.b();
    localWSDownloadParams.mScheme = paramString;
    skq.a((Activity)sjb.a(this.jdField_a_of_type_Sjb), localWSDownloadParams, false);
    sms.c(115, this.jdField_a_of_type_Sjb.a.type, this.jdField_a_of_type_Sjb.a.windowsid);
    WSPublicAccReport.getInstance().reportClickRichBlockPop(1000002, this.jdField_a_of_type_Sjb.a.windowsid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sjc
 * JD-Core Version:    0.7.0.1
 */