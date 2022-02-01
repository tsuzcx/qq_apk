package com.tencent.mobileqq.kandian.biz.share;

import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.kandian.repo.share.ShareReport;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class WxShareHelperFromReadInjoy$3
  implements WXShareHelper.WXShareListener
{
  WxShareHelperFromReadInjoy$3(WxShareHelperFromReadInjoy paramWxShareHelperFromReadInjoy) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    boolean bool;
    if (paramBaseResp.errCode == 0) {
      bool = true;
    } else {
      bool = false;
    }
    WXShareHelper.a().b(this);
    ShareReport.a.a(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.WxShareHelperFromReadInjoy.3
 * JD-Core Version:    0.7.0.1
 */