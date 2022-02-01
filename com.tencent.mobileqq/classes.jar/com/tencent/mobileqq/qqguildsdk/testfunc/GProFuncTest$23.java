package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.callback.IGetUserListCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class GProFuncTest$23
  implements IGetUserListCallback
{
  public void onGetUserList(String paramString1, int paramInt, String paramString2, Object paramObject, List<IGProUserInfo> paramList1, List<IGProUserInfo> paramList2, List<IGProUserInfo> paramList3)
  {
    paramObject = GProFuncTest.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg:");
    localStringBuilder.append(paramString2);
    QLog.d(paramObject, 2, localStringBuilder.toString());
    paramString2 = GProFuncTest.a();
    paramObject = new StringBuilder();
    paramObject.append("guildInfo : ");
    paramObject.append(paramString1);
    paramObject.append(" ");
    paramObject.append(this.a.getGuildName());
    QLog.d(paramString2, 2, paramObject.toString());
    if (paramList1 != null)
    {
      paramString1 = GProFuncTest.a();
      paramString2 = new StringBuilder();
      paramString2.append("adminList size : ");
      paramString2.append(paramList1.size());
      QLog.d(paramString1, 2, paramString2.toString());
      paramString1 = paramList1.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (IGProUserInfo)paramString1.next();
        GProFuncTest.a(this.b, paramString2);
      }
    }
    if (paramList2 != null)
    {
      paramString1 = GProFuncTest.a();
      paramString2 = new StringBuilder();
      paramString2.append("normalUserList size : ");
      paramString2.append(paramList2.size());
      QLog.d(paramString1, 2, paramString2.toString());
      paramString1 = paramList2.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (IGProUserInfo)paramString1.next();
        GProFuncTest.a(this.b, paramString2);
      }
    }
    if (paramList3 != null)
    {
      paramString1 = GProFuncTest.a();
      paramString2 = new StringBuilder();
      paramString2.append("robotList size : ");
      paramString2.append(paramList3.size());
      QLog.d(paramString1, 2, paramString2.toString());
      paramString1 = paramList3.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (IGProUserInfo)paramString1.next();
        GProFuncTest.a(this.b, paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.23
 * JD-Core Version:    0.7.0.1
 */