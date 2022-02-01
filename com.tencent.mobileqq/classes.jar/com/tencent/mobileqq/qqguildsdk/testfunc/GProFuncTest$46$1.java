package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.callback.IGetMoreNoticeListCallback;
import com.tencent.mobileqq.qqguildsdk.data.GuildNotice;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class GProFuncTest$46$1
  implements IGetMoreNoticeListCallback
{
  GProFuncTest$46$1(GProFuncTest.46 param46) {}
  
  public void a(int paramInt1, String paramString, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, List<GuildNotice> paramList)
  {
    paramList = GProFuncTest.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" onGetMoreGuildNoticeList : nResult");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" errMsg:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" offset:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" isEnd:");
    localStringBuilder.append(paramBoolean2);
    QLog.d(paramList, 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.46.1
 * JD-Core Version:    0.7.0.1
 */