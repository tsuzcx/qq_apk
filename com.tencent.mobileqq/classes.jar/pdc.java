import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.webview.swift.SwiftWebViewFragmentSupporter;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

public class pdc
  implements WXShareHelper.WXShareListener
{
  public pdc(Share paramShare, String paramString) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if ((this.jdField_a_of_type_ComTencentBizWebviewpluginShare.k == null) || (!this.jdField_a_of_type_ComTencentBizWebviewpluginShare.k.equals(paramBaseResp.transaction))) {}
    int i;
    String str1;
    String str2;
    String str3;
    for (;;)
    {
      return;
      BaseApplicationImpl.getContext();
      switch (paramBaseResp.errCode)
      {
      case -2: 
      case -1: 
      default: 
        QRUtils.a(1, 2131435303);
        return;
      }
      QRUtils.a(2, 2131435302);
      if ((this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a instanceof SwiftWebViewFragmentSupporter))
      {
        paramBaseResp = ((SwiftWebViewFragmentSupporter)this.jdField_a_of_type_ComTencentBizWebviewpluginShare.a).b();
        if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.e == 1) {}
        for (i = 1009; paramBaseResp != null; i = 1004)
        {
          str1 = paramBaseResp.j;
          str2 = paramBaseResp.i;
          str3 = AccountDetailActivity.a(paramBaseResp.g);
          String str4 = paramBaseResp.k;
          if ((str4 == null) || ("".equals(str4))) {
            break label200;
          }
          PublicAccountReportUtils.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", i, 0, str4, str1, paramBaseResp.g, str3, false);
          return;
        }
      }
    }
    label200:
    if (this.jdField_a_of_type_ComTencentBizWebviewpluginShare.e == 1) {
      i = 1003;
    }
    PublicAccountReportUtils.a(null, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", i, 0, str2, str1, this.jdField_a_of_type_JavaLangString, str3, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pdc
 * JD-Core Version:    0.7.0.1
 */