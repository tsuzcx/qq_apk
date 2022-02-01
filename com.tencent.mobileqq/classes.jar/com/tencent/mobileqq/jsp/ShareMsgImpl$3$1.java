package com.tencent.mobileqq.jsp;

import com.tencent.biz.pubaccount.AccountDetail.activity.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareReportInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class ShareMsgImpl$3$1
  implements WXShareHelper.WXShareListener
{
  ShareMsgImpl$3$1(ShareMsgImpl.3 param3) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if ((this.a.this$0.b == null) || (!this.a.this$0.b.equals(paramBaseResp.transaction))) {
      return;
    }
    boolean bool2 = false;
    boolean bool1 = bool2;
    switch (paramBaseResp.errCode)
    {
    case -1: 
    default: 
      QRUtils.a(1, 2131719291);
      bool1 = bool2;
    }
    for (;;)
    {
      this.a.this$0.jdField_a_of_type_ComTencentMobileqqJspShareMsgImpl$ShareMsgImplListener.onSharMsgcallback(this.a.this$0.jdField_a_of_type_JavaLangString, String.valueOf(bool1));
      return;
      QRUtils.a(2, 2131719309);
      if ((this.a.this$0.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface != null) && (this.a.this$0.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface != null))
      {
        int i;
        label162:
        String str1;
        String str2;
        String str3;
        if ("2".equals(this.a.jdField_a_of_type_JavaLangString))
        {
          i = 1009;
          paramBaseResp = this.a.this$0.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.getMsgid();
          str1 = this.a.this$0.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.getPublicUin();
          str2 = this.a.b;
          str3 = ((IPublicAccountDetailActivity)QRoute.api(IPublicAccountDetailActivity.class)).getArticleId(this.a.this$0.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface.getCurrentUrl());
          String str4 = this.a.this$0.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebShareReportInterface.getSourcePuin();
          if ((str4 == null) || ("".equals(str4))) {
            break label325;
          }
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", i, 0, str4, paramBaseResp, this.a.this$0.jdField_a_of_type_ComTencentMobileqqWebviewpluginWebUiUtils$WebUiMethodInterface.getCurrentUrl(), str3, false);
        }
        for (;;)
        {
          bool1 = true;
          break;
          i = 1004;
          break label162;
          label325:
          if ("2".equals(this.a.jdField_a_of_type_JavaLangString)) {
            i = 1003;
          }
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", i, 0, str1, paramBaseResp, str2, str3, false);
        }
      }
      bool1 = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.ShareMsgImpl.3.1
 * JD-Core Version:    0.7.0.1
 */