package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;

class GProFuncTest$19
  implements IResultWithSecurityCallback
{
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    String str = GProFuncTest.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("errCode: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", secActionCode:");
    if (paramIGProSecurityResult != null) {
      paramString = Long.valueOf(paramIGProSecurityResult.a());
    } else {
      paramString = "null";
    }
    localStringBuilder.append(paramString);
    QLog.d(str, 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.19
 * JD-Core Version:    0.7.0.1
 */