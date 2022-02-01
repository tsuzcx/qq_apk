package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js;

import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class LiteAppJs$3
  implements WXShareHelper.WXShareListener
{
  LiteAppJs$3(LiteAppJs paramLiteAppJs, String paramString) {}
  
  public void onWXShareResp(BaseResp paramBaseResp)
  {
    if (!TextUtils.equals(this.a, paramBaseResp.transaction)) {
      return;
    }
    if (paramBaseResp.errCode != 0) {
      QRUtils.a(1, 2131916544);
    } else {
      QRUtils.a(2, 2131916563);
    }
    WXShareHelper.a().b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.LiteAppJs.3
 * JD-Core Version:    0.7.0.1
 */