package com.tencent.mobileqq.profile.PersonalityLabel;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

class ShareHelper$1$2$1
  implements Runnable
{
  ShareHelper$1$2$1(ShareHelper.1.2 param2, String paramString) {}
  
  public void run()
  {
    if (this.b.a.a.e.isFinishing()) {
      return;
    }
    this.b.a.a.g.a(false);
    if (TextUtils.isEmpty(this.a))
    {
      QRUtils.a(1, 2131894251);
      return;
    }
    QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
    localUserInfo.qzone_uin = this.b.a.a.d.getAccount();
    localUserInfo.nickname = ContactUtils.f(this.b.a.a.d, this.b.a.a.d.getAccount());
    QZoneHelper.forwardToPublishMood(this.b.a.a.e, localUserInfo, this.a, this.b.a.a.e.getString(2131889086), "快来看看我的QQ个性标签吧", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.ShareHelper.1.2.1
 * JD-Core Version:    0.7.0.1
 */