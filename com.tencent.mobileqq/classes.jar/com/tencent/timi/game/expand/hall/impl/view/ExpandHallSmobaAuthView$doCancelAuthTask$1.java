package com.tencent.timi.game.expand.hall.impl.view;

import android.content.DialogInterface;
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
import trpc.yes.common.GameDataServerOuterClass.CancelSmobaAuthRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/expand/hall/impl/view/ExpandHallSmobaAuthView$doCancelAuthTask$1", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$Callback;", "Ltrpc/yes/common/GameDataServerOuterClass$CancelSmobaAuthRsp;", "onResult", "", "result", "", "errorCode", "", "errorMsg", "", "rsp", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallSmobaAuthView$doCancelAuthTask$1
  implements IUserSmobaInfoService.Callback<GameDataServerOuterClass.CancelSmobaAuthRsp>
{
  ExpandHallSmobaAuthView$doCancelAuthTask$1(DialogInterface paramDialogInterface) {}
  
  public void a(boolean paramBoolean, int paramInt, @Nullable String paramString, @Nullable GameDataServerOuterClass.CancelSmobaAuthRsp paramCancelSmobaAuthRsp)
  {
    LoadingUtils.a.b(this.b);
    paramCancelSmobaAuthRsp = new StringBuilder();
    paramCancelSmobaAuthRsp.append("cancel auth result=");
    paramCancelSmobaAuthRsp.append(paramBoolean);
    paramCancelSmobaAuthRsp.append(", errorCode=");
    paramCancelSmobaAuthRsp.append(paramInt);
    paramCancelSmobaAuthRsp.append(", errorMsg=");
    paramCancelSmobaAuthRsp.append(paramString);
    Logger.a("ExpandHallSmobaAuthView_", paramCancelSmobaAuthRsp.toString());
    if (paramBoolean)
    {
      ExpandHallSmobaAuthView.a(this.a, true);
      QQToast.makeText(this.a.getContext(), 2131916705, 0).show();
      ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).d(null);
      this.b.dismiss();
      return;
    }
    QQToast.makeText(this.a.getContext(), 2131916704, 0).show();
    ((Switch)this.a.a(2131446672)).setOnCheckedChangeListener(null);
    paramString = (Switch)this.a.a(2131446672);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "switchBtn");
    paramString.setChecked(true);
    ((Switch)this.a.a(2131446672)).setOnCheckedChangeListener(ExpandHallSmobaAuthView.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.view.ExpandHallSmobaAuthView.doCancelAuthTask.1
 * JD-Core Version:    0.7.0.1
 */