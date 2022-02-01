package com.tencent.mobileqq.guild.setting;

import android.text.TextUtils;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;

class QQGuildMainSettingFragment$1
  extends GPServiceObserver
{
  QQGuildMainSettingFragment$1(QQGuildMainSettingFragment paramQQGuildMainSettingFragment) {}
  
  protected void c(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(QQGuildMainSettingFragment.a(this.a))) && (!TextUtils.isEmpty(QQGuildMainSettingFragment.b(this.a))))
    {
      if ((QQGuildMainSettingFragment.a(this.a).equals(paramString2)) && (QQGuildMainSettingFragment.b(this.a).equals(paramString1)))
      {
        QQGuildMainSettingFragment.a(this.a, paramString3);
        if (QLog.isColorLevel()) {
          QLog.d("QQGuildCustomTitleBarFragment", 2, String.format("onGuildMemberNameUpdate nick=%s", new Object[] { paramString3 }));
        }
      }
      return;
    }
    QLog.e("QQGuildCustomTitleBarFragment", 2, String.format("onGuildMemberNameUpdate mSelfTid=%s, mGuildId=%s", new Object[] { QQGuildMainSettingFragment.a(this.a), QQGuildMainSettingFragment.b(this.a) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMainSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */