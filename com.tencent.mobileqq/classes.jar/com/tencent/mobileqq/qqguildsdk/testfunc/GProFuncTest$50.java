package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;

class GProFuncTest$50
  implements IResultWithSecurityCallback
{
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    paramString = GProFuncTest.a();
    paramIGProSecurityResult = new StringBuilder();
    paramIGProSecurityResult.append(" onSetAddGuildOptionResult : nResult");
    paramIGProSecurityResult.append(paramInt);
    paramIGProSecurityResult.append(" errMsg:");
    QLog.d(paramString, 2, paramIGProSecurityResult.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.50
 * JD-Core Version:    0.7.0.1
 */