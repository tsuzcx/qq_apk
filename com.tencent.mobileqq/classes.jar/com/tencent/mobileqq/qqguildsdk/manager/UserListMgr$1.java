package com.tencent.mobileqq.qqguildsdk.manager;

import com.tencent.gprosdk.IGProLoadAllMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import com.tencent.mobileqq.qqguildsdk.search.selector.UserSearchEngine;
import com.tencent.mobileqq.qqguildsdk.util.GProConstant;

class UserListMgr$1
  extends UserSearchEngine
{
  UserListMgr$1(UserListMgr paramUserListMgr) {}
  
  protected void a(String paramString, IGProLoadAllMemberListCallback paramIGProLoadAllMemberListCallback)
  {
    UserListMgr.a(this.a).a(paramString, GProConstant.a, paramIGProLoadAllMemberListCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.manager.UserListMgr.1
 * JD-Core Version:    0.7.0.1
 */