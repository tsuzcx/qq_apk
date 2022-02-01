package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IGetChannelCategoryCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qphone.base.util.QLog;

class GProFuncTest$10
  implements IGetChannelCategoryCallback
{
  public void a(int paramInt, String paramString, IGProSecurityResult paramIGProSecurityResult)
  {
    paramIGProSecurityResult = GProFuncTest.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("guildId：");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", categoryName:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", categoryId:");
    localStringBuilder.append(this.c);
    QLog.d(paramIGProSecurityResult, 2, new Object[] { paramString, localStringBuilder.toString() });
    this.e.a(GProFuncTest.a(this.d).getChannelCategoryList(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.10
 * JD-Core Version:    0.7.0.1
 */