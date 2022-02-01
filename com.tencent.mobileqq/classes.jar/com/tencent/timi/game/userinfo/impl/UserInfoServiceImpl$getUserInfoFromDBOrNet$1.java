package com.tencent.timi.game.userinfo.impl;

import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.impl.net.GetUserInfoRequest;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/userinfo/impl/UserInfoServiceImpl$getUserInfoFromDBOrNet$1", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "result", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class UserInfoServiceImpl$getUserInfoFromDBOrNet$1
  implements IResultListener<IUserInfo>
{
  UserInfoServiceImpl$getUserInfoFromDBOrNet$1(IResultListener paramIResultListener, long paramLong) {}
  
  public void a(int paramInt, @Nullable String paramString)
  {
    GetUserInfoRequest.a.a(this.b, this.a);
  }
  
  public void a(@Nullable IUserInfo paramIUserInfo)
  {
    if (paramIUserInfo != null)
    {
      IResultListener localIResultListener = this.a;
      if (localIResultListener != null) {
        localIResultListener.a(paramIUserInfo);
      }
    }
    else
    {
      GetUserInfoRequest.a.a(this.b, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.UserInfoServiceImpl.getUserInfoFromDBOrNet.1
 * JD-Core Version:    0.7.0.1
 */