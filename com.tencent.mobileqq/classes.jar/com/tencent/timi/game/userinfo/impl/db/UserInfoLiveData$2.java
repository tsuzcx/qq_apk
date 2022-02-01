package com.tencent.timi.game.userinfo.impl.db;

import com.tencent.timi.game.databasecore.impl.livedata.LoadDataWrapper;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;

class UserInfoLiveData$2
  implements IResultListener<IUserInfo>
{
  UserInfoLiveData$2(UserInfoLiveData paramUserInfoLiveData, int paramInt, String paramString) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(IUserInfo paramIUserInfo)
  {
    paramIUserInfo = LoadDataWrapper.a(this.a, this.b, paramIUserInfo);
    this.c.b(paramIUserInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.db.UserInfoLiveData.2
 * JD-Core Version:    0.7.0.1
 */