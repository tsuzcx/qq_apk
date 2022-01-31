import UserGrowth.stGlobalConfig;
import UserGrowth.stPopWindowsConfig;
import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import java.net.URLDecoder;

class tay
  implements tmc
{
  tay(tax paramtax, Context paramContext) {}
  
  public void a(String paramString, int paramInt)
  {
    tlq.a(tax.a(this.jdField_a_of_type_Tax), "biz_src_jc_gzh_weishi", paramString, 1, tax.a(this.jdField_a_of_type_Tax).link_strategy_type, tax.a(this.jdField_a_of_type_Tax));
    tjr.a(114, tax.b(this.jdField_a_of_type_Tax), tax.c(this.jdField_a_of_type_Tax), this.jdField_a_of_type_Tax.a.windowsid);
    tju.c(114, this.jdField_a_of_type_Tax.a.type, this.jdField_a_of_type_Tax.a.windowsid);
    WSPublicAccReport.getInstance().reportClickRichBlockPop(1000003, this.jdField_a_of_type_Tax.a.windowsid, this.jdField_a_of_type_Tax.a.trace_id);
  }
  
  public void b(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramString = URLDecoder.decode(paramString);
      ors.d(tax.a(this.jdField_a_of_type_Tax), paramString);
      tlo.a("weishi-813", "阻断rich弹窗:" + paramString);
      tjr.a(140, tax.b(this.jdField_a_of_type_Tax), tax.c(this.jdField_a_of_type_Tax), this.jdField_a_of_type_Tax.a.windowsid);
      tju.c(140, this.jdField_a_of_type_Tax.a.type, this.jdField_a_of_type_Tax.a.windowsid);
      WSPublicAccReport.getInstance().reportClickRichBlockPop(1000004, this.jdField_a_of_type_Tax.a.windowsid, this.jdField_a_of_type_Tax.a.trace_id);
      return;
    }
    tlo.c("weishi-813", "阻断rich弹窗:context 不是Activity");
  }
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = tax.a(this.jdField_a_of_type_Tax).link_strategy_type;
    localWSDownloadParams.mEventId = 401;
    localWSDownloadParams.mTestId = tju.b();
    localWSDownloadParams.mScheme = paramString;
    tfa.a((Activity)tax.a(this.jdField_a_of_type_Tax), localWSDownloadParams, false);
    tju.c(115, this.jdField_a_of_type_Tax.a.type, this.jdField_a_of_type_Tax.a.windowsid);
    WSPublicAccReport.getInstance().reportClickRichBlockPop(1000002, this.jdField_a_of_type_Tax.a.windowsid, this.jdField_a_of_type_Tax.a.trace_id);
  }
  
  public void d(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tay
 * JD-Core Version:    0.7.0.1
 */