package com.tencent.timi.game.userinfo.impl.view;

import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.api.view.IUserInfoView;
import com.tencent.timi.game.utils.IResultListener;

class UserInfoViewWrapperImpl$3
  implements IResultListener<IUserInfo>
{
  UserInfoViewWrapperImpl$3(UserInfoViewWrapperImpl paramUserInfoViewWrapperImpl) {}
  
  public void a(int paramInt, String paramString) {}
  
  public void a(IUserInfo paramIUserInfo)
  {
    if (paramIUserInfo.a().longValue() == this.a.a()) {
      UserInfoViewWrapperImpl.a(this.a).a(paramIUserInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.view.UserInfoViewWrapperImpl.3
 * JD-Core Version:    0.7.0.1
 */