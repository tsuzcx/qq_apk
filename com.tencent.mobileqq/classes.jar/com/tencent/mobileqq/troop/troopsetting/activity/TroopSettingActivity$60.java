package com.tencent.mobileqq.troop.troopsetting.activity;

import android.os.Handler;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;

class TroopSettingActivity$60
  extends BaseMessageObserver
{
  TroopSettingActivity$60(TroopSettingActivity paramTroopSettingActivity) {}
  
  protected void a(boolean paramBoolean, OpenID paramOpenID)
  {
    if (!this.a.isFinishing())
    {
      if (this.a.n) {
        return;
      }
      this.a.n();
      if (this.a.b != null) {
        this.a.b.removeCallbacksAndMessages(null);
      }
      if ((paramBoolean) && (paramOpenID != null) && (paramOpenID.openID != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.chatopttroop", 2, "openIdObserver success");
        }
        if (!paramOpenID.openID.equals(this.a.e))
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.chatopttroop", 2, "-->onGetOpenId--openid doesn't equal current openid");
          }
          this.a.q();
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("Q.chatopttroop", 2, "openIdObserver fail");
      }
    }
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isSuccess=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(",data=");
    localStringBuilder.append(paramObject);
    QLog.d("openid", 2, localStringBuilder.toString());
    a(paramBoolean, (OpenID)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopsetting.activity.TroopSettingActivity.60
 * JD-Core Version:    0.7.0.1
 */