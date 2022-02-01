package com.tencent.mobileqq.guild.setting;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;

class QQGuildCoverSettingFragment$1
  extends GPServiceObserver
{
  QQGuildCoverSettingFragment$1(QQGuildCoverSettingFragment paramQQGuildCoverSettingFragment) {}
  
  protected void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(QQGuildCoverSettingFragment.a(this.a))))
    {
      if (!TextUtils.equals(QQGuildCoverSettingFragment.a(this.a), paramString)) {
        return;
      }
      super.a(paramString);
      if (this.a.a() != null)
      {
        QQGuildCoverSettingFragment localQQGuildCoverSettingFragment = this.a;
        QQGuildCoverSettingFragment.a(localQQGuildCoverSettingFragment, ((IGPSService)localQQGuildCoverSettingFragment.a().getRuntimeService(IGPSService.class, "")).getGuildInfo(paramString));
        paramString = this.a;
        QQGuildCoverSettingFragment.b(paramString, QQGuildCoverSettingFragment.b(paramString));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildCoverSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */