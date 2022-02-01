package com.tencent.timi.game.userinfo.impl;

import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.impl.db.UserInfoLiveData;
import com.tencent.timi.game.utils.IResultListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/userinfo/impl/UserInfoServiceImpl$updateAllUserInfo$1", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "result", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class UserInfoServiceImpl$updateAllUserInfo$1
  implements IResultListener<IUserInfo>
{
  public void a(int paramInt, @Nullable String paramString)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((UserInfoLiveData)localObject).a(paramInt, paramString);
    }
    localObject = this.b;
    if (localObject != null) {
      ((IResultListener)localObject).a(paramInt, paramString);
    }
  }
  
  public void a(@Nullable IUserInfo paramIUserInfo)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((UserInfoLiveData)localObject).a(paramIUserInfo, 2);
    }
    localObject = this.b;
    if (localObject != null) {
      ((IResultListener)localObject).a(paramIUserInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.UserInfoServiceImpl.updateAllUserInfo.1
 * JD-Core Version:    0.7.0.1
 */