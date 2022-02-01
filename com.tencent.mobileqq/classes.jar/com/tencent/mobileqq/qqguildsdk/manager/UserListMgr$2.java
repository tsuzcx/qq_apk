package com.tencent.mobileqq.qqguildsdk.manager;

import com.tencent.gprosdk.GProUser;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import com.tencent.mobileqq.qqguildsdk.search.selector.AsyncDataSource;
import com.tencent.mobileqq.qqguildsdk.search.selector.AsyncDataSource.DataSourceHandler;

class UserListMgr$2
  implements AsyncDataSource<GProUser>
{
  UserListMgr$2(UserListMgr paramUserListMgr, String paramString) {}
  
  public void a(AsyncDataSource.DataSourceHandler<GProUser> paramDataSourceHandler)
  {
    UserListMgr.a(this.b).a(this.a, UserListMgr.a(), new UserListMgr.2.1(this, paramDataSourceHandler));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.manager.UserListMgr.2
 * JD-Core Version:    0.7.0.1
 */