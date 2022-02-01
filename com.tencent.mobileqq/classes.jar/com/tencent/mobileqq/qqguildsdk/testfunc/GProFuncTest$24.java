package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.callback.IResultCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;

class GProFuncTest$24
  implements IResultCallback
{
  public void onResult(int paramInt, String paramString)
  {
    String str = GProFuncTest.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", info.getGuildID():");
    localStringBuilder.append(this.a.getGuildID());
    localStringBuilder.append("，info.getGuildName():");
    localStringBuilder.append(this.a.getGuildName());
    QLog.d(str, 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.24
 * JD-Core Version:    0.7.0.1
 */