package com.tencent.mobileqq.qqguildsdk.testfunc;

import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.callback.IGetUserListCallback;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class GProFuncTest$43
  implements IGetUserListCallback
{
  public void onGetUserList(String paramString1, int paramInt, String paramString2, Object paramObject, List<IGProUserInfo> paramList1, List<IGProUserInfo> paramList2, List<IGProUserInfo> paramList3)
  {
    paramString2 = new ArrayList();
    paramString2.addAll(paramList1);
    paramString2.addAll(paramList2);
    paramString2.addAll(paramList3);
    paramString1 = new ArrayList();
    paramString2 = paramString2.iterator();
    while (paramString2.hasNext())
    {
      paramObject = (IGProUserInfo)paramString2.next();
      paramList1 = GProFuncTest.a();
      paramList2 = new StringBuilder();
      paramList2.append(" tid : ");
      paramList2.append(paramObject.a());
      QLog.d(paramList1, 2, paramList2.toString());
      paramString1.add(paramObject.a());
    }
    paramString1 = GProFuncTest.a(this.a).getGuildUsersNicks(paramString1).entrySet().iterator();
    while (paramString1.hasNext())
    {
      paramString2 = (Map.Entry)paramString1.next();
      paramObject = GProFuncTest.a();
      paramList1 = new StringBuilder();
      paramList1.append(" tid : ");
      paramList1.append((String)paramString2.getKey());
      paramList1.append(", nick :");
      paramList1.append((String)paramString2.getValue());
      QLog.d(paramObject, 2, paramList1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.testfunc.GProFuncTest.43
 * JD-Core Version:    0.7.0.1
 */