package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IInitGetNoticeListCallback;
import com.tencent.mobileqq.qqguildsdk.data.GuildNotice;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class GProFuncTest$46
  implements IInitGetNoticeListCallback
{
  public void a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean, List<GuildNotice> paramList)
  {
    paramList = GProFuncTest.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" onInitGetGuildNoticeList : nResult");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" offset:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" isEnd:");
    localStringBuilder.append(paramBoolean);
    QLog.d(paramList, 2, localStringBuilder.toString());
    if (!paramBoolean) {
      GProFuncTest.a(this.a).getMoreNoticeList(paramInt2, new GProFuncTest.46.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.46
 * JD-Core Version:    0.7.0.1
 */