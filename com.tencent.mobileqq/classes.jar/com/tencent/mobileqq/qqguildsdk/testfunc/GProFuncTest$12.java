package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.callback.IFetchShareInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;

class GProFuncTest$12
  implements IFetchShareInfoCallback
{
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, IGProSecurityResult paramIGProSecurityResult)
  {
    paramIGProSecurityResult = GProFuncTest.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("errCode: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", shareUrl:");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(", shareInfo:");
    localStringBuilder.append(paramString3);
    QLog.d(paramIGProSecurityResult, 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.12
 * JD-Core Version:    0.7.0.1
 */