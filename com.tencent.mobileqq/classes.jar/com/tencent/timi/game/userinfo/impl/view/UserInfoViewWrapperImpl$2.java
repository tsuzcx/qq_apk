package com.tencent.timi.game.userinfo.impl.view;

import com.tencent.timi.game.databasecore.impl.notify.DbNotifyListener;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.api.view.IUserInfoView;
import org.jetbrains.annotations.Nullable;

class UserInfoViewWrapperImpl$2
  implements DbNotifyListener<IUserInfo>
{
  UserInfoViewWrapperImpl$2(UserInfoViewWrapperImpl paramUserInfoViewWrapperImpl) {}
  
  public void a(@Nullable IUserInfo paramIUserInfo)
  {
    if ((paramIUserInfo != null) && (paramIUserInfo.a().longValue() == UserInfoViewWrapperImpl.c(this.a))) {
      UserInfoViewWrapperImpl.a(this.a).a(paramIUserInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.view.UserInfoViewWrapperImpl.2
 * JD-Core Version:    0.7.0.1
 */