package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.callback.IGetUserInfoCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class GProFuncTest$40
  implements IGetUserInfoCallback
{
  public void onGetUserInfo(int paramInt, String paramString, List<IGProUserInfo> paramList, List<String> paramList1)
  {
    QLog.d(GProFuncTest.a(), 2, "sucList: ");
    paramString = paramList.iterator();
    while (paramString.hasNext())
    {
      paramList = (IGProUserInfo)paramString.next();
      GProFuncTest.a(this.a, paramList);
    }
    QLog.d(GProFuncTest.a(), 2, "failList: ");
    paramString = paramList1.iterator();
    while (paramString.hasNext())
    {
      paramList = (String)paramString.next();
      QLog.d(GProFuncTest.a(), 2, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.40
 * JD-Core Version:    0.7.0.1
 */