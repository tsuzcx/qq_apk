import UserGrowth.stGlobalConfig;
import UserGrowth.stPopWindowsConfig;
import android.app.Activity;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import java.net.URLDecoder;

class rwj
  implements sar
{
  rwj(rwi paramrwi, Context paramContext) {}
  
  public void a(String paramString, int paramInt)
  {
    sak.a(rwi.a(this.jdField_a_of_type_Rwi), "biz_src_jc_gzh_weishi", paramString, 1, rwi.a(this.jdField_a_of_type_Rwi).link_strategy_type, rwi.a(this.jdField_a_of_type_Rwi));
    rzu.a(114, rwi.b(this.jdField_a_of_type_Rwi), rwi.c(this.jdField_a_of_type_Rwi), this.jdField_a_of_type_Rwi.a.windowsid);
    rzw.c(114, this.jdField_a_of_type_Rwi.a.type, this.jdField_a_of_type_Rwi.a.windowsid);
    WSPublicAccReport.getInstance().reportClickRichBlockPop(1000003, this.jdField_a_of_type_Rwi.a.windowsid);
  }
  
  public void b(String paramString, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      paramString = URLDecoder.decode(paramString);
      obz.e(rwi.a(this.jdField_a_of_type_Rwi), paramString);
      sai.a("weishi-813", "阻断rich弹窗:" + paramString);
      rzu.a(140, rwi.b(this.jdField_a_of_type_Rwi), rwi.c(this.jdField_a_of_type_Rwi), this.jdField_a_of_type_Rwi.a.windowsid);
      rzw.c(140, this.jdField_a_of_type_Rwi.a.type, this.jdField_a_of_type_Rwi.a.windowsid);
      WSPublicAccReport.getInstance().reportClickRichBlockPop(1000004, this.jdField_a_of_type_Rwi.a.windowsid);
      return;
    }
    sai.c("weishi-813", "阻断rich弹窗:context 不是Activity");
  }
  
  public void c(String paramString, int paramInt)
  {
    WSDownloadParams localWSDownloadParams = new WSDownloadParams();
    localWSDownloadParams.mScene = 1;
    localWSDownloadParams.mLinkStrategyType = rwi.a(this.jdField_a_of_type_Rwi).link_strategy_type;
    localWSDownloadParams.mEventId = 401;
    localWSDownloadParams.mTestId = rzw.b();
    localWSDownloadParams.mScheme = paramString;
    rxu.a((Activity)rwi.a(this.jdField_a_of_type_Rwi), localWSDownloadParams, false);
    rzw.c(115, this.jdField_a_of_type_Rwi.a.type, this.jdField_a_of_type_Rwi.a.windowsid);
    WSPublicAccReport.getInstance().reportClickRichBlockPop(1000002, this.jdField_a_of_type_Rwi.a.windowsid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rwj
 * JD-Core Version:    0.7.0.1
 */