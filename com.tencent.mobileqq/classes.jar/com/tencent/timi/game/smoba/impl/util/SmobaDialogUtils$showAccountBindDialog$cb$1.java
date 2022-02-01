package com.tencent.timi.game.smoba.impl.util;

import android.content.Context;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.base.ui.LoadingUtils;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.BindSmobaAccountCallback;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetUserSmobaRoleListRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/smoba/impl/util/SmobaDialogUtils$showAccountBindDialog$cb$1", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$Callback;", "Ltrpc/yes/common/GameDataServerOuterClass$GetUserSmobaRoleListRsp;", "onResult", "", "result", "", "errorCode", "", "errorMsg", "", "rsp", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SmobaDialogUtils$showAccountBindDialog$cb$1
  implements IUserSmobaInfoService.Callback<GameDataServerOuterClass.GetUserSmobaRoleListRsp>
{
  SmobaDialogUtils$showAccountBindDialog$cb$1(QBaseActivity paramQBaseActivity, IUserSmobaInfoService.BindSmobaAccountCallback paramBindSmobaAccountCallback) {}
  
  public void a(boolean paramBoolean, int paramInt, @Nullable String paramString, @Nullable GameDataServerOuterClass.GetUserSmobaRoleListRsp paramGetUserSmobaRoleListRsp)
  {
    LoadingUtils.a.b((Context)this.a);
    if ((paramBoolean) && (paramGetUserSmobaRoleListRsp != null))
    {
      SmobaDialogUtils.a.a(this.a, paramGetUserSmobaRoleListRsp, this.b);
      return;
    }
    paramGetUserSmobaRoleListRsp = this.b;
    if (paramGetUserSmobaRoleListRsp != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Get list failed, ");
      localStringBuilder.append(paramString);
      paramGetUserSmobaRoleListRsp.a(paramInt, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.SmobaDialogUtils.showAccountBindDialog.cb.1
 * JD-Core Version:    0.7.0.1
 */