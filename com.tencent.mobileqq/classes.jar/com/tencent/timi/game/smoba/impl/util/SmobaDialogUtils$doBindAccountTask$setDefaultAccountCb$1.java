package com.tencent.timi.game.smoba.impl.util;

import android.content.DialogInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.base.ui.LoadingUtils;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.BindSmobaAccountCallback;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.SetSmobaDefaultRoleRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/smoba/impl/util/SmobaDialogUtils$doBindAccountTask$setDefaultAccountCb$1", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$Callback;", "Ltrpc/yes/common/GameDataServerOuterClass$SetSmobaDefaultRoleRsp;", "onResult", "", "result", "", "errorCode", "", "errorMsg", "", "rsp", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SmobaDialogUtils$doBindAccountTask$setDefaultAccountCb$1
  implements IUserSmobaInfoService.Callback<GameDataServerOuterClass.SetSmobaDefaultRoleRsp>
{
  SmobaDialogUtils$doBindAccountTask$setDefaultAccountCb$1(DialogInterface paramDialogInterface, IUserSmobaInfoService.BindSmobaAccountCallback paramBindSmobaAccountCallback, QBaseActivity paramQBaseActivity) {}
  
  public void a(boolean paramBoolean, int paramInt, @Nullable String paramString, @Nullable GameDataServerOuterClass.SetSmobaDefaultRoleRsp paramSetSmobaDefaultRoleRsp)
  {
    LoadingUtils.a.b(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", errorCode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errorMsg:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", rsp:");
    localStringBuilder.append(paramSetSmobaDefaultRoleRsp);
    Logger.a("SmobaDialogUtils_", localStringBuilder.toString());
    SmobaDialogUtils.a(SmobaDialogUtils.a, paramBoolean, this.b, this.c, paramSetSmobaDefaultRoleRsp, paramString, paramInt);
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.SmobaDialogUtils.doBindAccountTask.setDefaultAccountCb.1
 * JD-Core Version:    0.7.0.1
 */