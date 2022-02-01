package com.tencent.timi.game.userinfo.impl.db;

import com.tencent.timi.game.databasecore.impl.livedata.LoadDataWrapper;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;

class UserInfoLiveData$1
  implements IResultListener<IUserInfo>
{
  UserInfoLiveData$1(UserInfoLiveData paramUserInfoLiveData) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(IUserInfo paramIUserInfo)
  {
    if (paramIUserInfo != null)
    {
      LoadDataWrapper localLoadDataWrapper = new LoadDataWrapper(1, null);
      if (paramIUserInfo != null)
      {
        localLoadDataWrapper.c = 4;
        localLoadDataWrapper.d = paramIUserInfo;
        UserInfoLiveData.a(this.a, true);
      }
      this.a.b(localLoadDataWrapper);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.db.UserInfoLiveData.1
 * JD-Core Version:    0.7.0.1
 */