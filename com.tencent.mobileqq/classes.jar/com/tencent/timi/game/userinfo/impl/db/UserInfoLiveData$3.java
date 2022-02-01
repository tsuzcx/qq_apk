package com.tencent.timi.game.userinfo.impl.db;

import com.tencent.timi.game.databasecore.impl.notify.DbNotifyListener;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import org.jetbrains.annotations.Nullable;

class UserInfoLiveData$3
  implements DbNotifyListener<IUserInfo>
{
  UserInfoLiveData$3(UserInfoLiveData paramUserInfoLiveData) {}
  
  public void a(@Nullable IUserInfo paramIUserInfo)
  {
    if ((paramIUserInfo != null) && (paramIUserInfo.a().longValue() == UserInfoLiveData.a(this.a))) {
      this.a.a(paramIUserInfo, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.db.UserInfoLiveData.3
 * JD-Core Version:    0.7.0.1
 */