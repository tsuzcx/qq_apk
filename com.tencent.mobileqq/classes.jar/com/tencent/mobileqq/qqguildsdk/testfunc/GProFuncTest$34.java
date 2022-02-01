package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.callback.ISetGuildInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;

class GProFuncTest$34
  implements ISetGuildInfoCallback
{
  public void a(int paramInt, IGProGuildInfo paramIGProGuildInfo, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    paramIGProSecurityResult = GProFuncTest.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("errCode: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramString);
    QLog.d(paramIGProSecurityResult, 2, localStringBuilder.toString());
    GProFuncTest.a(this.a, paramIGProGuildInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.34
 * JD-Core Version:    0.7.0.1
 */