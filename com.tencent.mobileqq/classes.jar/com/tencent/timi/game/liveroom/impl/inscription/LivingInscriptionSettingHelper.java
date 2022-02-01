package com.tencent.timi.game.liveroom.impl.inscription;

import android.content.Context;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.BindSmobaAccountCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionSettingHelper;", "", "()V", "TAG", "", "checkThenToInscriptionSetting", "", "context", "Landroid/content/Context;", "roomId", "", "gameId", "", "livingInscriptionSettingListener", "Lcom/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionSettingListener;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingInscriptionSettingHelper
{
  private final String a = "LivingInscriptionSettingHelper";
  
  public final void a(@NotNull Context paramContext, long paramLong, int paramInt, @NotNull LivingInscriptionSettingListener paramLivingInscriptionSettingListener)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramLivingInscriptionSettingListener, "livingInscriptionSettingListener");
    if ((paramContext instanceof QBaseActivity))
    {
      paramLivingInscriptionSettingListener = new LivingInscriptionSettingHelper.checkThenToInscriptionSetting.bindListener.1(this, paramContext, paramLong, paramInt, paramLivingInscriptionSettingListener);
      ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a((QBaseActivity)paramContext, true, null, (IUserSmobaInfoService.BindSmobaAccountCallback)paramLivingInscriptionSettingListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionSettingHelper
 * JD-Core Version:    0.7.0.1
 */