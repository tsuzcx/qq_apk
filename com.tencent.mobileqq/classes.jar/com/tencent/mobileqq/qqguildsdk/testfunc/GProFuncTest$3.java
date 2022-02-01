package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;

class GProFuncTest$3
  implements IResultWithSecurityCallback
{
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    paramIGProSecurityResult = GProFuncTest.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result： ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramString);
    QLog.d(paramIGProSecurityResult, 2, localStringBuilder.toString());
    paramString = GProFuncTest.a();
    paramIGProSecurityResult = new StringBuilder();
    paramIGProSecurityResult.append("guildId : 66772871619769143, ori: ");
    paramIGProSecurityResult.append(this.a);
    paramIGProSecurityResult.append(", new: ");
    paramIGProSecurityResult.append(GProFuncTest.a(this.b).getSelfGuildMemberName("66772871619769143"));
    QLog.d(paramString, 2, paramIGProSecurityResult.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.3
 * JD-Core Version:    0.7.0.1
 */