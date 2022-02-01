package com.tencent.mobileqq.kandian.biz.share;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

class AbstractReadInjoyWebShareHelper$4$2
  implements ITroopMemberApiClientApi.Callback
{
  AbstractReadInjoyWebShareHelper$4$2(AbstractReadInjoyWebShareHelper.4 param4, Bitmap paramBitmap) {}
  
  public void callback(Bundle paramBundle)
  {
    int i = paramBundle.getInt("readinjoy_to_wx_config");
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("config = ");
      paramBundle.append(i);
      QLog.d("AbstractReadInjoyWebShareHelper", 2, paramBundle.toString());
    }
    if (i == 0)
    {
      WxShareHelperFromReadInjoy.getInstance().shareWebPage(this.b.this$0.b, this.b.d, this.a, this.b.e, this.b.f, this.b.a ^ true);
      return;
    }
    WXShareHelper.a().a(this.b.this$0.b, this.b.d, this.a, this.b.e, this.b.f, this.b.a ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.AbstractReadInjoyWebShareHelper.4.2
 * JD-Core Version:    0.7.0.1
 */