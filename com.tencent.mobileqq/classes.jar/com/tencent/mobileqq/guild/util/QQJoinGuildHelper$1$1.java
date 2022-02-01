package com.tencent.mobileqq.guild.util;

import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;

class QQJoinGuildHelper$1$1
  implements IResultWithSecurityCallback
{
  QQJoinGuildHelper$1$1(QQJoinGuildHelper.1 param1, IResultWithSecurityCallback paramIResultWithSecurityCallback) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if (paramInt != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("join guild failed. guildId = ");
      localStringBuilder.append(this.b.a);
      QLog.d("QQJoinGuildHelper", 1, localStringBuilder.toString());
    }
    this.a.a(paramInt, paramString, paramIGProSecurityResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQJoinGuildHelper.1.1
 * JD-Core Version:    0.7.0.1
 */