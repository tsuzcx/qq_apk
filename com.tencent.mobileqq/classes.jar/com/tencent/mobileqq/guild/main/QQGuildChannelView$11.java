package com.tencent.mobileqq.guild.main;

import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;

class QQGuildChannelView$11
  implements IResultWithSecurityCallback
{
  QQGuildChannelView$11(QQGuildChannelView paramQQGuildChannelView) {}
  
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    if (paramInt != 0)
    {
      paramIGProSecurityResult = new StringBuilder();
      paramIGProSecurityResult.append("checkNeedAutoExitRoom exitAudioChannel when same platform exits failed result:");
      paramIGProSecurityResult.append(paramInt);
      paramIGProSecurityResult.append(", errMsg:");
      paramIGProSecurityResult.append(paramString);
      QLog.e("QQGuildChannelView", 1, paramIGProSecurityResult.toString());
      return;
    }
    QLog.i("QQGuildChannelView", 1, "checkNeedAutoExitRoom exitAudioChannel success when same platform exits.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.QQGuildChannelView.11
 * JD-Core Version:    0.7.0.1
 */