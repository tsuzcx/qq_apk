package com.tencent.timi.game.profile.impl.dialog;

import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.BindSmobaAccountCallback;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/profile/impl/dialog/ProfileBaseInfoDialog$showSmobaAccountSelectDialog$bindListener$1", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$BindSmobaAccountCallback;", "bindCancel", "", "bindFailed", "errorCode", "", "errorMsg", "", "bindSucceed", "selectedDefaultAccount", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaDefaultRoleRsp;", "onDialogShow", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ProfileBaseInfoDialog$showSmobaAccountSelectDialog$bindListener$1
  implements IUserSmobaInfoService.BindSmobaAccountCallback
{
  public void a()
  {
    Logger.a(ProfileBaseInfoDialog.c(this.a), "showSmobaAccountSelectDialog bindCancel ");
  }
  
  public void a(int paramInt, @Nullable String paramString) {}
  
  public void a(@NotNull GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp)
  {
    Intrinsics.checkParameterIsNotNull(paramGetSmobaDefaultRoleRsp, "selectedDefaultAccount");
    Logger.a(ProfileBaseInfoDialog.c(this.a), "showSmobaAccountSelectDialog bindSucceed ");
    ProfileBaseInfoDialog.a(this.a, paramGetSmobaDefaultRoleRsp);
    ((IUserInfoService)ServiceCenter.a(IUserInfoService.class)).c(this.a.n().uid.get(), null);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.dialog.ProfileBaseInfoDialog.showSmobaAccountSelectDialog.bindListener.1
 * JD-Core Version:    0.7.0.1
 */