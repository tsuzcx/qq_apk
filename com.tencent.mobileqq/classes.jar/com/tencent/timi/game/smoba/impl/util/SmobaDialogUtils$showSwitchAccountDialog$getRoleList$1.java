package com.tencent.timi.game.smoba.impl.util;

import android.content.Context;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.timi.game.base.ui.LoadingUtils;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.SwitchSmobaAccountCallback;
import com.tencent.timi.game.smoba.impl.widget.SwitchAccountDialog;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetUserSmobaRoleListRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/smoba/impl/util/SmobaDialogUtils$showSwitchAccountDialog$getRoleList$1", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$Callback;", "Ltrpc/yes/common/GameDataServerOuterClass$GetUserSmobaRoleListRsp;", "onResult", "", "result", "", "errorCode", "", "errorMsg", "", "rsp", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SmobaDialogUtils$showSwitchAccountDialog$getRoleList$1
  implements IUserSmobaInfoService.Callback<GameDataServerOuterClass.GetUserSmobaRoleListRsp>
{
  SmobaDialogUtils$showSwitchAccountDialog$getRoleList$1(QBaseActivity paramQBaseActivity, IUserSmobaInfoService.SwitchSmobaAccountCallback paramSwitchSmobaAccountCallback) {}
  
  public void a(boolean paramBoolean, int paramInt, @Nullable String paramString, @Nullable GameDataServerOuterClass.GetUserSmobaRoleListRsp paramGetUserSmobaRoleListRsp)
  {
    LoadingUtils.a.b((Context)this.a);
    if ((paramBoolean) && (paramGetUserSmobaRoleListRsp != null))
    {
      paramString = (Context)this.a;
      paramGetUserSmobaRoleListRsp = paramGetUserSmobaRoleListRsp.role_list.get();
      Intrinsics.checkExpressionValueIsNotNull(paramGetUserSmobaRoleListRsp, "rsp.role_list.get()");
      new SwitchAccountDialog(paramString, paramGetUserSmobaRoleListRsp, this.b).show();
      return;
    }
    paramGetUserSmobaRoleListRsp = this.b;
    if (paramGetUserSmobaRoleListRsp != null) {
      paramGetUserSmobaRoleListRsp.a(paramInt, paramString);
    }
    Logger.c("SmobaDialogUtils_", "showSwitchAccountDialog list is empty!");
    QQToast.makeText((Context)this.a, (CharSequence)"列表拉取失败", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.SmobaDialogUtils.showSwitchAccountDialog.getRoleList.1
 * JD-Core Version:    0.7.0.1
 */