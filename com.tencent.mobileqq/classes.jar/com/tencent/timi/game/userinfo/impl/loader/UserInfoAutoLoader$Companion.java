package com.tencent.timi.game.userinfo.impl.loader;

import kotlin.Lazy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/userinfo/impl/loader/UserInfoAutoLoader$Companion;", "", "()V", "stance", "Lcom/tencent/timi/game/userinfo/impl/loader/UserInfoAutoLoader;", "getStance", "()Lcom/tencent/timi/game/userinfo/impl/loader/UserInfoAutoLoader;", "stance$delegate", "Lkotlin/Lazy;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class UserInfoAutoLoader$Companion
{
  @NotNull
  public final UserInfoAutoLoader a()
  {
    Lazy localLazy = UserInfoAutoLoader.b();
    Companion localCompanion = UserInfoAutoLoader.a;
    return (UserInfoAutoLoader)localLazy.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.loader.UserInfoAutoLoader.Companion
 * JD-Core Version:    0.7.0.1
 */