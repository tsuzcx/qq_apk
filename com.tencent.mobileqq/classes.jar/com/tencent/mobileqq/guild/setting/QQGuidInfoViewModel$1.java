package com.tencent.mobileqq.guild.setting;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.qphone.base.util.QLog;

class QQGuidInfoViewModel$1
  extends GPServiceObserver
{
  QQGuidInfoViewModel$1(QQGuidInfoViewModel paramQQGuidInfoViewModel) {}
  
  protected void a(String paramString)
  {
    if (TextUtils.equals(paramString, QQGuidInfoViewModel.a(this.a)))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onGuildInfoUpdated paramGuildId: ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" mGuildId: ");
        localStringBuilder.append(QQGuidInfoViewModel.a(this.a));
        QLog.i("QQGuidInfoViewModel", 2, localStringBuilder.toString());
      }
      QQGuidInfoViewModel.c(this.a).postValue(((QQGuildInfoRepository)QQGuidInfoViewModel.b(this.a)).a(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuidInfoViewModel.1
 * JD-Core Version:    0.7.0.1
 */