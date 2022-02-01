package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;
import com.tencent.qphone.base.util.QLog;

class GProFuncTest$1
  implements IResultCallback
{
  public void onResult(int paramInt, String paramString)
  {
    String str = GProFuncTest.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg = ");
    localStringBuilder.append(paramString);
    QLog.d(str, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.1
 * JD-Core Version:    0.7.0.1
 */