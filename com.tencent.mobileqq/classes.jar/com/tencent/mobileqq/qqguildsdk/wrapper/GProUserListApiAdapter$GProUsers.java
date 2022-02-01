package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class GProUserListApiAdapter$GProUsers
{
  public List<IGProUserInfo> a = new ArrayList();
  public List<IGProUserInfo> b = new ArrayList();
  public List<IGProUserInfo> c = new ArrayList();
  
  public GProUserListApiAdapter$GProUsers(List<IGProUserInfo> paramList)
  {
    a(paramList);
  }
  
  public void a(List<IGProUserInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      IGProUserInfo localIGProUserInfo = (IGProUserInfo)paramList.next();
      if (localIGProUserInfo.f() == 1) {
        this.c.add(localIGProUserInfo);
      } else if (GProUserListApiAdapter.a(localIGProUserInfo)) {
        this.b.add(localIGProUserInfo);
      } else if (GProUserListApiAdapter.b(localIGProUserInfo)) {
        this.a.add(localIGProUserInfo);
      } else {
        QLog.e("GProUserListApiAdapter", 1, new Object[] { "USER: unknown type of user: ", localIGProUserInfo });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.GProUserListApiAdapter.GProUsers
 * JD-Core Version:    0.7.0.1
 */