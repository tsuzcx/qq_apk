package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.callback.IFetchInviteInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGuildInviteInfo;
import com.tencent.qphone.base.util.QLog;

class GProFuncTest$39
  implements IFetchInviteInfoCallback
{
  public void a(int paramInt, String paramString, IGuildInviteInfo paramIGuildInviteInfo, IGProSecurityResult paramIGProSecurityResult)
  {
    paramIGProSecurityResult = GProFuncTest.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramString);
    QLog.d(paramIGProSecurityResult, 2, localStringBuilder.toString());
    paramString = GProFuncTest.a();
    paramIGProSecurityResult = new StringBuilder();
    paramIGProSecurityResult.append("getGuildID: ");
    paramIGProSecurityResult.append(paramIGuildInviteInfo.a());
    paramIGProSecurityResult.append(", getGuildName:");
    paramIGProSecurityResult.append(paramIGuildInviteInfo.c());
    paramIGProSecurityResult.append(", getNickName:");
    paramIGProSecurityResult.append(paramIGuildInviteInfo.d());
    paramIGProSecurityResult.append(", getAvatar:");
    paramIGProSecurityResult.append(paramIGuildInviteInfo.e());
    QLog.d(paramString, 2, paramIGProSecurityResult.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.39
 * JD-Core Version:    0.7.0.1
 */