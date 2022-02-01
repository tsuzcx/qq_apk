package com.tencent.timi.game.expand.hall.impl.view;

import com.tencent.mobileqq.widget.QQToast;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.AuthToGetSmobaInfoCallback;
import com.tencent.widget.Switch;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.AgreeSmobaAuthRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/expand/hall/impl/view/ExpandHallSmobaAuthView$doAgreeAuthTask$cb$1", "Lcom/tencent/timi/game/smoba/api/IUserSmobaInfoService$AuthToGetSmobaInfoCallback;", "authCancel", "", "authFailed", "errorCode", "", "errorMsg", "", "authSucceed", "authInfo", "Ltrpc/yes/common/GameDataServerOuterClass$AgreeSmobaAuthRsp;", "onDialogShow", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallSmobaAuthView$doAgreeAuthTask$cb$1
  implements IUserSmobaInfoService.AuthToGetSmobaInfoCallback
{
  public void a()
  {
    ((Switch)this.a.a(2131446672)).setOnCheckedChangeListener(null);
    Switch localSwitch = (Switch)this.a.a(2131446672);
    Intrinsics.checkExpressionValueIsNotNull(localSwitch, "switchBtn");
    localSwitch.setChecked(false);
    ((Switch)this.a.a(2131446672)).setOnCheckedChangeListener(ExpandHallSmobaAuthView.a(this.a));
  }
  
  public void a(int paramInt, @Nullable String paramString)
  {
    ((Switch)this.a.a(2131446672)).setOnCheckedChangeListener(null);
    paramString = (Switch)this.a.a(2131446672);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "switchBtn");
    paramString.setChecked(false);
    ((Switch)this.a.a(2131446672)).setOnCheckedChangeListener(ExpandHallSmobaAuthView.a(this.a));
    QQToast.makeText(this.a.getContext(), 2131916702, 0).show();
  }
  
  public void a(@NotNull GameDataServerOuterClass.AgreeSmobaAuthRsp paramAgreeSmobaAuthRsp)
  {
    Intrinsics.checkParameterIsNotNull(paramAgreeSmobaAuthRsp, "authInfo");
    QQToast.makeText(this.a.getContext(), 2131916703, 0).show();
    ((Switch)this.a.a(2131446672)).setOnCheckedChangeListener(null);
    paramAgreeSmobaAuthRsp = (Switch)this.a.a(2131446672);
    Intrinsics.checkExpressionValueIsNotNull(paramAgreeSmobaAuthRsp, "switchBtn");
    paramAgreeSmobaAuthRsp.setChecked(true);
    ((Switch)this.a.a(2131446672)).setOnCheckedChangeListener(ExpandHallSmobaAuthView.a(this.a));
    ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).d(null);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.view.ExpandHallSmobaAuthView.doAgreeAuthTask.cb.1
 * JD-Core Version:    0.7.0.1
 */