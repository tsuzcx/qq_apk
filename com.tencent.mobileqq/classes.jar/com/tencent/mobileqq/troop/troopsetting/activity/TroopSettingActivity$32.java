package com.tencent.mobileqq.troop.troopsetting.activity;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.announcement.api.TroopAnnouncementObserver;
import com.tencent.qphone.base.util.QLog;

class TroopSettingActivity$32
  extends TroopAnnouncementObserver
{
  TroopSettingActivity$32(TroopSettingActivity paramTroopSettingActivity) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (this.c.t != null) && (TextUtils.equals(paramString1, this.c.t.troopuin)))
    {
      String str = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        str = this.c.t.getLatestMemo();
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, String.format("get last memo [%s, %s]", new Object[] { paramString1, str }));
      }
      if (!TextUtils.isEmpty(str))
      {
        paramString1 = this.c.aD.obtainMessage();
        paramString1.what = 20;
        paramString1.obj = str;
        this.c.aD.sendMessage(paramString1);
      }
      TroopSettingActivity.b(this.c, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.32
 * JD-Core Version:    0.7.0.1
 */