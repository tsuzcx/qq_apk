package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuildInfoByAppIdentityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.IGuildJoinInfo;
import com.tencent.qphone.base.util.QLog;

class GProFuncTest$11
  implements IFetchGuildInfoByAppIdentityCallback
{
  public void a(int paramInt, String paramString, IGuildJoinInfo paramIGuildJoinInfo, IGProSecurityResult paramIGProSecurityResult)
  {
    String str = GProFuncTest.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramString);
    QLog.d(str, 2, localStringBuilder.toString());
    GProFuncTest.a(this.a, paramIGuildJoinInfo);
    GProFuncTest.a(this.a, paramIGProSecurityResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.11
 * JD-Core Version:    0.7.0.1
 */