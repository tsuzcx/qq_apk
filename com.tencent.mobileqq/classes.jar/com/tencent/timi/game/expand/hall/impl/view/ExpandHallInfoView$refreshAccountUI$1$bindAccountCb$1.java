package com.tencent.timi.game.expand.hall.impl.view;

import android.content.Context;
import com.tencent.timi.game.base.ui.LoadingUtils;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.BindSmobaAccountCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/expand/hall/impl/view/ExpandHallInfoView$refreshAccountUI$1$bindAccountCb$1", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$BindSmobaAccountCallback;", "bindCancel", "", "bindFailed", "errorCode", "", "errorMsg", "", "bindSucceed", "selectedDefaultAccount", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaDefaultRoleRsp;", "onDialogShow", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallInfoView$refreshAccountUI$1$bindAccountCb$1
  implements IUserSmobaInfoService.BindSmobaAccountCallback
{
  public void a() {}
  
  public void a(int paramInt, @Nullable String paramString)
  {
    paramString = LoadingUtils.a;
    Context localContext = this.a.a.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    paramString.b(localContext);
  }
  
  public void a(@NotNull GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp)
  {
    Intrinsics.checkParameterIsNotNull(paramGetSmobaDefaultRoleRsp, "selectedDefaultAccount");
  }
  
  public void b()
  {
    LoadingUtils localLoadingUtils = LoadingUtils.a;
    Context localContext = this.a.a.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    localLoadingUtils.b(localContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.view.ExpandHallInfoView.refreshAccountUI.1.bindAccountCb.1
 * JD-Core Version:    0.7.0.1
 */