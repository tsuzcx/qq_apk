package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchGuildInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class GProFuncTest$22
  implements IFetchGuildInfoCallback
{
  public void a(int paramInt, String paramString, IGProGuildInfo paramIGProGuildInfo)
  {
    Object localObject = GProFuncTest.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramString);
    QLog.d((String)localObject, 2, localStringBuilder.toString());
    GProFuncTest.a(this.b, paramIGProGuildInfo);
    paramString = GProFuncTest.a();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("guildInfo channel list size : ");
    ((StringBuilder)localObject).append(GProFuncTest.a(this.a).getChannelList("33192771617432415").size());
    QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
    GProFuncTest.a(this.b, this.a, paramIGProGuildInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.22
 * JD-Core Version:    0.7.0.1
 */