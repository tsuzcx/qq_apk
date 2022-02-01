package com.tencent.mobileqq.guild.util;

import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.BaseApplication;

final class QQJoinGuildHelper$3
  implements IResultWithSecurityCallback
{
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if (paramInt != 0) {
      QQGuildUtil.a(BaseApplication.getContext(), paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQJoinGuildHelper.3
 * JD-Core Version:    0.7.0.1
 */