package com.tencent.timi.game.expand.hall.impl.view;

import android.content.Context;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.timi.game.base.ui.LoadingUtils;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import com.tencent.timi.game.utils.Logger;
import com.tencent.widget.Switch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.AgreeSmobaAuthRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/expand/hall/impl/view/ExpandHallSmobaAuthView$authCallback$1", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$Callback;", "Ltrpc/yes/common/GameDataServerOuterClass$AgreeSmobaAuthRsp;", "onResult", "", "result", "", "errorCode", "", "errorMsg", "", "rsp", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallSmobaAuthView$authCallback$1
  implements IUserSmobaInfoService.Callback<GameDataServerOuterClass.AgreeSmobaAuthRsp>
{
  ExpandHallSmobaAuthView$authCallback$1(Context paramContext) {}
  
  public void a(boolean paramBoolean, int paramInt, @Nullable String paramString, @Nullable GameDataServerOuterClass.AgreeSmobaAuthRsp paramAgreeSmobaAuthRsp)
  {
    LoadingUtils.a.b(this.b);
    paramAgreeSmobaAuthRsp = new StringBuilder();
    paramAgreeSmobaAuthRsp.append("agree auth result=");
    paramAgreeSmobaAuthRsp.append(paramBoolean);
    paramAgreeSmobaAuthRsp.append(", errorCode=");
    paramAgreeSmobaAuthRsp.append(paramInt);
    paramAgreeSmobaAuthRsp.append(", errorMsg=");
    paramAgreeSmobaAuthRsp.append(paramString);
    Logger.a("ExpandHallSmobaAuthView_", paramAgreeSmobaAuthRsp.toString());
    if (paramBoolean)
    {
      QQToast.makeText(this.b, 2131916703, 0).show();
      ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).d(null);
      return;
    }
    QQToast.makeText(this.b, 2131916702, 0).show();
    ((Switch)this.a.a(2131446672)).setOnCheckedChangeListener(null);
    paramString = (Switch)this.a.a(2131446672);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "switchBtn");
    paramString.setChecked(false);
    ((Switch)this.a.a(2131446672)).setOnCheckedChangeListener(ExpandHallSmobaAuthView.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.view.ExpandHallSmobaAuthView.authCallback.1
 * JD-Core Version:    0.7.0.1
 */