package com.tencent.timi.game.profile.impl.dialog;

import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.SwitchSmobaAccountCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/profile/impl/dialog/ProfileBaseInfoDialog$realChangeRole$cb$1", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$SwitchSmobaAccountCallback;", "onDialogShow", "", "switchCancel", "switchFailed", "errorCode", "", "errorMsg", "", "switchSucceed", "selectedDefaultAccount", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaDefaultRoleRsp;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ProfileBaseInfoDialog$realChangeRole$cb$1
  implements IUserSmobaInfoService.SwitchSmobaAccountCallback
{
  public void a() {}
  
  public void a(int paramInt, @Nullable String paramString) {}
  
  public void a(@NotNull GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp)
  {
    Intrinsics.checkParameterIsNotNull(paramGetSmobaDefaultRoleRsp, "selectedDefaultAccount");
    ProfileBaseInfoDialog.a(this.a, paramGetSmobaDefaultRoleRsp);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.dialog.ProfileBaseInfoDialog.realChangeRole.cb.1
 * JD-Core Version:    0.7.0.1
 */