package com.tencent.mobileqq.jsp;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.share.api.IWxShareHelperFromReadInjoy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class ShareMsgImpl$3$3
  implements ITroopMemberApiClientApi.Callback
{
  ShareMsgImpl$3$3(ShareMsgImpl.3 param3, Bitmap paramBitmap) {}
  
  public void callback(Bundle paramBundle)
  {
    if (paramBundle.getInt("readinjoy_to_wx_config") == 0)
    {
      ((IWxShareHelperFromReadInjoy)QRoute.api(IWxShareHelperFromReadInjoy.class)).shareWebPage(this.b.this$0.e, this.b.f, this.a, this.b.g, this.b.b, "2".equals(this.b.a) ^ true);
      return;
    }
    WXShareHelper.a().a(this.b.this$0.e, this.b.f, this.a, this.b.g, this.b.b, "2".equals(this.b.a) ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.ShareMsgImpl.3.3
 * JD-Core Version:    0.7.0.1
 */