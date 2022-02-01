package com.tencent.mobileqq.onlinestatus.olympic.helper;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

class OlympicShareActionSheetHelper$4$2
  implements Runnable
{
  OlympicShareActionSheetHelper$4$2(OlympicShareActionSheetHelper.4 param4, String paramString) {}
  
  public void run()
  {
    if (this.b.this$0.c != null)
    {
      if (this.b.this$0.c.isFinishing()) {
        return;
      }
      if (TextUtils.isEmpty(this.a))
      {
        QQToast.makeText(this.b.this$0.c, 1, HardCodeUtil.a(2131896392), 1).show();
        if (this.b.a != null) {
          this.b.a.a();
        }
        return;
      }
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
      localUserInfo.qzone_uin = this.b.this$0.b.getAccount();
      localUserInfo.nickname = OlympicShareHelper.a(this.b.this$0.b, this.b.this$0.b.getAccount());
      QZoneHelper.forwardToPublishMood(this.b.this$0.c, localUserInfo, this.a, this.b.this$0.c.getResources().getString(2131889086), "", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicShareActionSheetHelper.4.2
 * JD-Core Version:    0.7.0.1
 */