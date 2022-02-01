package com.tencent.mobileqq.guild.main;

import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchLiveSecurityTipsCallback;
import com.tencent.qphone.base.util.QLog;

class QQGuildChannelView$4
  implements IFetchLiveSecurityTipsCallback
{
  QQGuildChannelView$4(QQGuildChannelView paramQQGuildChannelView) {}
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fetchLiveSecurityTips callback, result=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("(");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("), securityTips=");
    localStringBuilder.append(paramString2);
    QLog.i("QQGuildChannelView", 1, localStringBuilder.toString());
    if (paramInt != 0) {
      return;
    }
    QQGuildUtil.f(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.QQGuildChannelView.4
 * JD-Core Version:    0.7.0.1
 */