package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.callback.IDealNoticeCallback;
import com.tencent.qphone.base.util.QLog;

class GProFuncTest$49
  implements IDealNoticeCallback
{
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    String str = GProFuncTest.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" onDealNoticeResult : nResult");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" dealWording:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" remove:");
    localStringBuilder.append(paramBoolean);
    QLog.d(str, 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.49
 * JD-Core Version:    0.7.0.1
 */