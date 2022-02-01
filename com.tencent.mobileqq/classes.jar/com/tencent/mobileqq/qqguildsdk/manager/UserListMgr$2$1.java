package com.tencent.mobileqq.qqguildsdk.manager;

import com.tencent.gprosdk.GProUser;
import com.tencent.gprosdk.IGProLoadAllMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.search.selector.AsyncDataSource.DataSourceHandler;
import java.util.ArrayList;

class UserListMgr$2$1
  implements IGProLoadAllMemberListCallback
{
  UserListMgr$2$1(UserListMgr.2 param2, AsyncDataSource.DataSourceHandler paramDataSourceHandler) {}
  
  public void onLoadAllMemberList(int paramInt, String paramString, boolean paramBoolean, ArrayList<GProUser> paramArrayList)
  {
    this.a.a(paramArrayList, paramBoolean ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.manager.UserListMgr.2.1
 * JD-Core Version:    0.7.0.1
 */