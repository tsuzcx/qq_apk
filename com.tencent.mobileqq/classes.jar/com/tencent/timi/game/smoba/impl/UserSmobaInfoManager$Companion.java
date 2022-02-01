package com.tencent.timi.game.smoba.impl;

import kotlin.Lazy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/smoba/impl/UserSmobaInfoManager$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/timi/game/smoba/impl/UserSmobaInfoManager;", "getINSTANCE", "()Lcom/tencent/timi/game/smoba/impl/UserSmobaInfoManager;", "INSTANCE$delegate", "Lkotlin/Lazy;", "TAG", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class UserSmobaInfoManager$Companion
{
  @NotNull
  public final UserSmobaInfoManager a()
  {
    Lazy localLazy = UserSmobaInfoManager.d();
    Companion localCompanion = UserSmobaInfoManager.a;
    return (UserSmobaInfoManager)localLazy.getValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.UserSmobaInfoManager.Companion
 * JD-Core Version:    0.7.0.1
 */