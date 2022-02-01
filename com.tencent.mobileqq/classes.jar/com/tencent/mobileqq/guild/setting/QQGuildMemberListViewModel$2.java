package com.tencent.mobileqq.guild.setting;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGuildMemberCountInfos;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;

class QQGuildMemberListViewModel$2
  extends GPServiceObserver
{
  QQGuildMemberListViewModel$2(QQGuildMemberListViewModel paramQQGuildMemberListViewModel) {}
  
  protected void a(IGuildMemberCountInfos paramIGuildMemberCountInfos)
  {
    this.a.i.setValue(paramIGuildMemberCountInfos);
  }
  
  protected void c(String paramString)
  {
    super.c(paramString);
    if ((!TextUtils.isEmpty(paramString)) && (this.a.b != null) && (paramString.equals(this.a.b.getGuildID()))) {
      this.a.f.setValue(Boolean.valueOf(true));
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onRemoveGuild key:");
      localStringBuilder.append(paramString);
      QLog.i("QQGuildMemberListViewModel", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMemberListViewModel.2
 * JD-Core Version:    0.7.0.1
 */