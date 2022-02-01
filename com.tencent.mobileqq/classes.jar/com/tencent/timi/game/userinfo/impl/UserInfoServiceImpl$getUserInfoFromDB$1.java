package com.tencent.timi.game.userinfo.impl;

import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/userinfo/impl/UserInfoServiceImpl$getUserInfoFromDB$1", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "result", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class UserInfoServiceImpl$getUserInfoFromDB$1
  implements IResultListener<IUserInfo>
{
  UserInfoServiceImpl$getUserInfoFromDB$1(IResultListener paramIResultListener) {}
  
  public void a(int paramInt, @Nullable String paramString)
  {
    IResultListener localIResultListener = this.a;
    if (localIResultListener != null) {
      localIResultListener.a(paramInt, paramString);
    }
  }
  
  public void a(@NotNull IUserInfo paramIUserInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramIUserInfo, "result");
    IResultListener localIResultListener = this.a;
    if (localIResultListener != null) {
      localIResultListener.a(paramIUserInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.UserInfoServiceImpl.getUserInfoFromDB.1
 * JD-Core Version:    0.7.0.1
 */