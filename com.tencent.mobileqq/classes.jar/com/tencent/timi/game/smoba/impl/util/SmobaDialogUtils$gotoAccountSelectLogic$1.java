package com.tencent.timi.game.smoba.impl.util;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.timi.game.base.ui.LoadingUtils;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.BindSmobaAccountCallback;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetUserSmobaRoleListRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/smoba/impl/util/SmobaDialogUtils$gotoAccountSelectLogic$1", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$Callback;", "Ltrpc/yes/common/GameDataServerOuterClass$GetUserSmobaRoleListRsp;", "onResult", "", "result", "", "errorCode", "", "errorMsg", "", "rsp", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SmobaDialogUtils$gotoAccountSelectLogic$1
  implements IUserSmobaInfoService.Callback<GameDataServerOuterClass.GetUserSmobaRoleListRsp>
{
  SmobaDialogUtils$gotoAccountSelectLogic$1(DialogInterface paramDialogInterface, QBaseActivity paramQBaseActivity, IUserSmobaInfoService.BindSmobaAccountCallback paramBindSmobaAccountCallback) {}
  
  public void a(boolean paramBoolean, int paramInt, @Nullable String paramString, @Nullable GameDataServerOuterClass.GetUserSmobaRoleListRsp paramGetUserSmobaRoleListRsp)
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
    localStringBuilder.append(paramGetUserSmobaRoleListRsp);
    Logger.a("SmobaDialogUtils_", localStringBuilder.toString());
    if ((paramBoolean) && (paramGetUserSmobaRoleListRsp != null)) {
      SmobaDialogUtils.a.a(this.b, paramGetUserSmobaRoleListRsp, this.c);
    } else {
      QQToast.makeText((Context)this.b, (CharSequence)paramString, 0).show();
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.SmobaDialogUtils.gotoAccountSelectLogic.1
 * JD-Core Version:    0.7.0.1
 */