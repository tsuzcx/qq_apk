package com.tencent.mobileqq.jsp;

import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebShareReportInterface;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;

class ShareMsgImpl$3$2
  implements IWxShareHelperFromReadInjoy.WXShareHelperFromReadInjoyListener
{
  ShareMsgImpl$3$2(ShareMsgImpl.3 param3) {}
  
  public void a(BaseResp paramBaseResp)
  {
    if (this.a.this$0.e != null)
    {
      if (!this.a.this$0.e.equals(paramBaseResp.transaction)) {
        return;
      }
      boolean bool2 = false;
      int i = paramBaseResp.errCode;
      boolean bool1 = bool2;
      if (i != -2) {
        if (i != 0)
        {
          QRUtils.a(1, 2131916544);
          bool1 = bool2;
        }
        else
        {
          QRUtils.a(2, 2131916563);
          if ((this.a.this$0.i != null) && (this.a.this$0.g != null))
          {
            if ("2".equals(this.a.a)) {
              i = 1009;
            } else {
              i = 1004;
            }
            paramBaseResp = this.a.this$0.i.d();
            String str1 = this.a.this$0.i.e();
            String str2 = this.a.b;
            String str3 = ((IPublicAccountDetailActivity)QRoute.api(IPublicAccountDetailActivity.class)).getArticleId(this.a.this$0.g.getCurrentUrl());
            String str4 = this.a.this$0.i.f();
            if ((str4 != null) && (!"".equals(str4)))
            {
              ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B07", "0X8005B07", i, 0, str4, paramBaseResp, this.a.this$0.g.getCurrentUrl(), str3, false);
            }
            else
            {
              if ("2".equals(this.a.a)) {
                i = 1003;
              }
              ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", "", "0X80059DC", "0X80059DC", i, 0, str1, paramBaseResp, str2, str3, false);
            }
          }
          bool1 = true;
        }
      }
      this.a.this$0.p.onSharMsgcallback(this.a.this$0.b, String.valueOf(bool1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.ShareMsgImpl.3.2
 * JD-Core Version:    0.7.0.1
 */