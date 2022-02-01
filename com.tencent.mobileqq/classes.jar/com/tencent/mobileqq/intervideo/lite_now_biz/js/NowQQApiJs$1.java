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
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramBaseResp.transaction)) {
      return;
    }
    switch (paramBaseResp.errCode)
    {
    default: 
      QRUtils.a(1, 2131719291);
    }
    for (;;)
    {
      WXShareHelper.a().b(this);
      return;
      QRUtils.a(2, 2131719309);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.lite_now_biz.js.NowQQApiJs.1
 * JD-Core Version:    0.7.0.1
 */