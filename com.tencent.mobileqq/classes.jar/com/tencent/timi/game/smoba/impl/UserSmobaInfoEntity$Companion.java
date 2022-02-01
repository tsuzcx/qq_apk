package com.tencent.timi.game.smoba.impl;

import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.router.ServiceCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/smoba/impl/UserSmobaInfoEntity$Companion;", "", "()V", "createUserSmobaInfoEntity", "Lcom/tencent/timi/game/smoba/impl/UserSmobaInfoEntity;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class UserSmobaInfoEntity$Companion
{
  @NotNull
  public final UserSmobaInfoEntity a()
  {
    UserSmobaInfoEntity localUserSmobaInfoEntity = new UserSmobaInfoEntity();
    Object localObject = ServiceCenter.a(ILoginCoreService.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…nCoreService::class.java)");
    localObject = ((ILoginCoreService)localObject).b();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…:class.java).userIdString");
    localUserSmobaInfoEntity.uin = ((String)localObject);
    return localUserSmobaInfoEntity;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.UserSmobaInfoEntity.Companion
 * JD-Core Version:    0.7.0.1
 */