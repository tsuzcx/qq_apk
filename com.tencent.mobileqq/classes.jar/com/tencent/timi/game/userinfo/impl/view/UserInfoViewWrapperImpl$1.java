package com.tencent.timi.game.userinfo.impl.view;

import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.api.view.IUserInfoView;
import com.tencent.timi.game.utils.IResultListener;

class UserInfoViewWrapperImpl$1
  implements IResultListener<IUserInfo>
{
  UserInfoViewWrapperImpl$1(UserInfoViewWrapperImpl paramUserInfoViewWrapperImpl) {}
  
  public void a(int paramInt, String paramString)
  {
    UserInfoViewWrapperImpl.b(this.a);
  }
  
  public void a(IUserInfo paramIUserInfo)
  {
    if (paramIUserInfo.a().longValue() == this.a.a())
    {
      UserInfoViewWrapperImpl.a(this.a).a(paramIUserInfo);
      return;
    }
    UserInfoViewWrapperImpl.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.view.UserInfoViewWrapperImpl.1
 * JD-Core Version:    0.7.0.1
 */