package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IGetUserListCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class GProFuncTest$45
  implements IGetUserListCallback
{
  public void onGetUserList(String paramString1, int paramInt, String paramString2, Object paramObject, List<IGProUserInfo> paramList1, List<IGProUserInfo> paramList2, List<IGProUserInfo> paramList3)
  {
    paramString2 = new ArrayList();
    paramString2.addAll(paramList1);
    paramString2.addAll(paramList2);
    paramString2.addAll(paramList3);
    paramString2 = paramString2.iterator();
    while (paramString2.hasNext())
    {
      paramObject = (IGProUserInfo)paramString2.next();
      paramList1 = GProFuncTest.a();
      paramList2 = new StringBuilder();
      paramList2.append(" tid : ");
      paramList2.append(paramObject.a());
      QLog.d(paramList1, 2, paramList2.toString());
      GProFuncTest.a(this.a).refreshGuildUserProfileInfo(paramString1, paramObject.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.45
 * JD-Core Version:    0.7.0.1
 */