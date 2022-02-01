package com.tencent.timi.game.smoba.impl.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.base.ui.LoadingUtils;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.AuthToGetSmobaInfoCallback;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.AgreeSmobaAuthRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/smoba/impl/util/SmobaDialogUtils$showAuthHintDialog$2$1", "Lcom/tencent/timi/game/net/api/RequestListener;", "Ltrpc/yes/common/GameDataServerOuterClass$AgreeSmobaAuthRsp;", "onError", "", "isMsfSuccess", "", "msfResultCode", "", "timiErrCode", "timiSubErrCode", "timiErrMsg", "", "timiDisplayErrMsg", "response", "originalMsfRsp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class SmobaDialogUtils$showAuthHintDialog$2$1
  implements RequestListener<GameDataServerOuterClass.AgreeSmobaAuthRsp>
{
  SmobaDialogUtils$showAuthHintDialog$2$1(DialogInterface paramDialogInterface) {}
  
  public void a(@Nullable GameDataServerOuterClass.AgreeSmobaAuthRsp paramAgreeSmobaAuthRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramFromServiceMsg = LoadingUtils.a;
    DialogInterface localDialogInterface = this.b;
    Intrinsics.checkExpressionValueIsNotNull(localDialogInterface, "dialog");
    paramFromServiceMsg.b(localDialogInterface);
    QQToast.makeText((Context)this.a.a, (CharSequence)this.a.a.getResources().getString(2131916703), 0).show();
    if (paramAgreeSmobaAuthRsp != null)
    {
      paramFromServiceMsg = this.a.b;
      if (paramFromServiceMsg != null) {
        paramFromServiceMsg.a(paramAgreeSmobaAuthRsp);
      }
    }
    else
    {
      paramAgreeSmobaAuthRsp = this.a.b;
      if (paramAgreeSmobaAuthRsp != null) {
        paramAgreeSmobaAuthRsp.a(-1, "response is null");
      }
    }
    if (!this.a.c)
    {
      this.b.dismiss();
      return;
    }
    paramAgreeSmobaAuthRsp = SmobaDialogUtils.a;
    paramFromServiceMsg = this.a.a;
    localDialogInterface = this.b;
    Intrinsics.checkExpressionValueIsNotNull(localDialogInterface, "dialog");
    SmobaDialogUtils.a(paramAgreeSmobaAuthRsp, paramFromServiceMsg, localDialogInterface, this.a.d);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString1, @Nullable String paramString2, @Nullable GameDataServerOuterClass.AgreeSmobaAuthRsp paramAgreeSmobaAuthRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    LoadingUtils.a.b((Context)this.a.a);
    paramAgreeSmobaAuthRsp = new StringBuilder();
    paramAgreeSmobaAuthRsp.append("isMsfSuccess:");
    paramAgreeSmobaAuthRsp.append(paramBoolean);
    paramAgreeSmobaAuthRsp.append(',');
    paramAgreeSmobaAuthRsp.append(" msfResultCode:");
    paramAgreeSmobaAuthRsp.append(paramInt1);
    paramAgreeSmobaAuthRsp.append(", timiErrCode:");
    paramAgreeSmobaAuthRsp.append(paramInt2);
    paramAgreeSmobaAuthRsp.append(',');
    paramAgreeSmobaAuthRsp.append(" timiSubErrCode:");
    paramAgreeSmobaAuthRsp.append(paramInt3);
    paramAgreeSmobaAuthRsp.append(", timiErrMsg:");
    paramAgreeSmobaAuthRsp.append(paramString1);
    paramAgreeSmobaAuthRsp.append(" timiDisplayErrMsg:");
    paramAgreeSmobaAuthRsp.append(paramString2);
    Logger.c("SmobaDialogUtils_", paramAgreeSmobaAuthRsp.toString());
    paramString2 = this.a.b;
    if (paramString2 != null) {
      paramString2.a(paramInt2, paramString1);
    }
    QQToast.makeText((Context)this.a.a, (CharSequence)paramString1, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.SmobaDialogUtils.showAuthHintDialog.2.1
 * JD-Core Version:    0.7.0.1
 */