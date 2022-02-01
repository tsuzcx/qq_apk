package com.tencent.mobileqq.profile.PersonalityLabel;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.wxapi.WXShareHelper;

class ShareHelper$1$3$1
  implements Runnable
{
  ShareHelper$1$3$1(ShareHelper.1.3 param3, String paramString) {}
  
  public void run()
  {
    if (this.b.b.a.e.isFinishing()) {
      return;
    }
    this.b.b.a.g.a(false);
    if (TextUtils.isEmpty(this.a))
    {
      QRUtils.a(1, 2131894251);
      return;
    }
    if (this.b.a == 2L)
    {
      WXShareHelper.a().a(this.a, this.b.b.a.f, 0);
      return;
    }
    WXShareHelper.a().a(this.a, this.b.b.a.f, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.3.1
 * JD-Core Version:    0.7.0.1
 */