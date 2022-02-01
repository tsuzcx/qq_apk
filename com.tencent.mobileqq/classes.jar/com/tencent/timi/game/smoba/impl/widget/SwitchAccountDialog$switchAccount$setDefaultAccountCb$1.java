package com.tencent.timi.game.smoba.impl.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.timi.game.base.ui.LoadingUtils;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.SwitchSmobaAccountCallback;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.SetSmobaDefaultRoleRsp;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/smoba/impl/widget/SwitchAccountDialog$switchAccount$setDefaultAccountCb$1", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$Callback;", "Ltrpc/yes/common/GameDataServerOuterClass$SetSmobaDefaultRoleRsp;", "onResult", "", "result", "", "errorCode", "", "errorMsg", "", "rsp", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SwitchAccountDialog$switchAccount$setDefaultAccountCb$1
  implements IUserSmobaInfoService.Callback<GameDataServerOuterClass.SetSmobaDefaultRoleRsp>
{
  public void a(boolean paramBoolean, int paramInt, @Nullable String paramString, @Nullable GameDataServerOuterClass.SetSmobaDefaultRoleRsp paramSetSmobaDefaultRoleRsp)
  {
    LoadingUtils.a.b((DialogInterface)this.a);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("result:");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", errorCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(", errorMsg:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", rsp:");
    ((StringBuilder)localObject).append(paramSetSmobaDefaultRoleRsp);
    Logger.a("SmobaDialogUtils_", ((StringBuilder)localObject).toString());
    if ((paramBoolean) && (paramSetSmobaDefaultRoleRsp != null))
    {
      paramString = SwitchAccountDialog.a(this.a);
      localObject = SwitchAccountDialog.a(this.a);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      QQToast.makeText(paramString, (CharSequence)((Context)localObject).getResources().getString(2131916701), 0).show();
      paramString = new GameDataServerOuterClass.GetSmobaDefaultRoleRsp();
      paramString.role_info.set(paramSetSmobaDefaultRoleRsp.role_info.get());
      paramSetSmobaDefaultRoleRsp = this.a.a();
      if (paramSetSmobaDefaultRoleRsp != null) {
        paramSetSmobaDefaultRoleRsp.a(paramString);
      }
      ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a(null);
      this.a.dismiss();
      return;
    }
    QQToast.makeText(SwitchAccountDialog.a(this.a), (CharSequence)paramString, 0).show();
    paramSetSmobaDefaultRoleRsp = this.a.a();
    if (paramSetSmobaDefaultRoleRsp != null) {
      paramSetSmobaDefaultRoleRsp.a(paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.widget.SwitchAccountDialog.switchAccount.setDefaultAccountCb.1
 * JD-Core Version:    0.7.0.1
 */