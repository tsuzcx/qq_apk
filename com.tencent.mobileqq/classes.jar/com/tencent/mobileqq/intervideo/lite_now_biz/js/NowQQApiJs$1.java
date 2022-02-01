package com.tencent.mobileqq.intervideo.lite_now_biz.js;

import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;

class NowQQApiJs$1
  implements WXShareHelper.WXShareListener
{
  NowQQApiJs$1(NowQQApiJs paramNowQQApiJs, String paramString) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.js.NowQQApiJs.1
 * JD-Core Version:    0.7.0.1
 */