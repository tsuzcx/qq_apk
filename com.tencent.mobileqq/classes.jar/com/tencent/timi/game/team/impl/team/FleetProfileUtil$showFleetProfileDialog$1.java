package com.tencent.timi.game.team.impl.team;

import android.app.Activity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.gift.impl.timi.GiftPanelUtilsKt;
import com.tencent.timi.game.profile.api.listener.FleetProfileClickListener;
import com.tencent.timi.game.profile.api.ui.ProfileDialog;
import com.tencent.timi.game.team.impl.main.TeamUtil;
import com.tencent.timi.game.utils.ThreadPool;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/team/impl/team/FleetProfileUtil$showFleetProfileDialog$1", "Lcom/tencent/timi/game/profile/api/listener/FleetProfileClickListener;", "onAtClick", "", "profileDialog", "Lcom/tencent/timi/game/profile/api/ui/ProfileDialog;", "onGiveGiftClick", "onQuitFleet", "dialog", "onRemoveMemberClick", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class FleetProfileUtil$showFleetProfileDialog$1
  implements FleetProfileClickListener
{
  FleetProfileUtil$showFleetProfileDialog$1(long paramLong1, long paramLong2, CommonOuterClass.QQUserId paramQQUserId, QBaseActivity paramQBaseActivity) {}
  
  public void a()
  {
    GiftPanelUtilsKt.a(this.b, this.c, "1");
  }
  
  public void a(@NotNull ProfileDialog paramProfileDialog)
  {
    Intrinsics.checkParameterIsNotNull(paramProfileDialog, "dialog");
    FleetProfileUtil.a.a(this.a, (FleetProfileUtil.KickOutListener)new FleetProfileUtil.showFleetProfileDialog.1.onRemoveMemberClick.1(paramProfileDialog), this.b);
  }
  
  public void b(@NotNull ProfileDialog paramProfileDialog)
  {
    Intrinsics.checkParameterIsNotNull(paramProfileDialog, "dialog");
    TeamUtil.a((Activity)TimiGameActivityManager.a(), this.b);
    paramProfileDialog.dismiss();
  }
  
  public void c(@NotNull ProfileDialog paramProfileDialog)
  {
    Intrinsics.checkParameterIsNotNull(paramProfileDialog, "profileDialog");
    paramProfileDialog.dismiss();
    ThreadPool.a((Runnable)new FleetProfileUtil.showFleetProfileDialog.1.onAtClick.1(this, paramProfileDialog), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.FleetProfileUtil.showFleetProfileDialog.1
 * JD-Core Version:    0.7.0.1
 */