package com.tencent.timi.game.smoba.impl.util;

import android.content.Context;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.timi.game.base.ui.LoadingUtils;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.AuthToGetSmobaInfoCallback;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.BindSmobaAccountCallback;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaAuthInfoRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/smoba/impl/util/SmobaDialogUtils$showAuthHintDialog$getAuthInfoCb$1", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$Callback;", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaAuthInfoRsp;", "onResult", "", "result", "", "errorCode", "", "errorMsg", "", "rsp", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SmobaDialogUtils$showAuthHintDialog$getAuthInfoCb$1
  implements IUserSmobaInfoService.Callback<GameDataServerOuterClass.GetSmobaAuthInfoRsp>
{
  SmobaDialogUtils$showAuthHintDialog$getAuthInfoCb$1(QBaseActivity paramQBaseActivity, boolean paramBoolean, IUserSmobaInfoService.AuthToGetSmobaInfoCallback paramAuthToGetSmobaInfoCallback, IUserSmobaInfoService.BindSmobaAccountCallback paramBindSmobaAccountCallback) {}
  
  public void a(boolean paramBoolean, int paramInt, @Nullable String paramString, @Nullable GameDataServerOuterClass.GetSmobaAuthInfoRsp paramGetSmobaAuthInfoRsp)
  {
    LoadingUtils.a.b((Context)this.a);
    if ((paramBoolean) && (paramGetSmobaAuthInfoRsp != null))
    {
      paramString = SmobaDialogUtils.a;
      localObject = this.a;
      paramGetSmobaAuthInfoRsp = paramGetSmobaAuthInfoRsp.auth_desc.get();
      Intrinsics.checkExpressionValueIsNotNull(paramGetSmobaAuthInfoRsp, "rsp.auth_desc.get()");
      paramString.a((QBaseActivity)localObject, paramGetSmobaAuthInfoRsp, this.b, this.c, this.d);
      return;
    }
    paramGetSmobaAuthInfoRsp = this.c;
    if (paramGetSmobaAuthInfoRsp != null) {
      paramGetSmobaAuthInfoRsp.a(paramInt, paramString);
    }
    Logger.c("SmobaDialogUtils_", "showAuthHintDialog auth info is empty!");
    paramGetSmobaAuthInfoRsp = (Context)this.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("授权信息拉取失败：");
    ((StringBuilder)localObject).append(paramString);
    QQToast.makeText(paramGetSmobaAuthInfoRsp, (CharSequence)((StringBuilder)localObject).toString(), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.SmobaDialogUtils.showAuthHintDialog.getAuthInfoCb.1
 * JD-Core Version:    0.7.0.1
 */