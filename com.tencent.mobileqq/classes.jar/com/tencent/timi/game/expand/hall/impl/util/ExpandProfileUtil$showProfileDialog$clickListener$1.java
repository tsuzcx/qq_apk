package com.tencent.timi.game.expand.hall.impl.util;

import android.app.Activity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.expand.hall.api.HallReportHelper;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.gift.impl.timi.GiftPanelUtilsKt;
import com.tencent.timi.game.profile.api.listener.CPDDProfileClickListener;
import com.tencent.timi.game.profile.api.ui.ProfileDialog;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.team.api.ITeamService;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.ThreadPool;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/expand/hall/impl/util/ExpandProfileUtil$showProfileDialog$clickListener$1", "Lcom/tencent/timi/game/profile/api/listener/CPDDProfileClickListener;", "onAtClick", "", "profileDialog", "Lcom/tencent/timi/game/profile/api/ui/ProfileDialog;", "onGiveGiftClick", "onKaiHeiClick", "onReceiveVoiceClick", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandProfileUtil$showProfileDialog$clickListener$1
  implements CPDDProfileClickListener
{
  ExpandProfileUtil$showProfileDialog$clickListener$1(CommonOuterClass.QQUserId paramQQUserId, QBaseActivity paramQBaseActivity, long paramLong) {}
  
  public void a()
  {
    long l = this.c;
    if (l == 0L) {
      return;
    }
    GiftPanelUtilsKt.a(l, this.a, "1");
  }
  
  public void a(@NotNull ProfileDialog paramProfileDialog)
  {
    Intrinsics.checkParameterIsNotNull(paramProfileDialog, "profileDialog");
    paramProfileDialog.dismiss();
    ThreadPool.a((Runnable)new ExpandProfileUtil.showProfileDialog.clickListener.1.onAtClick.1(this, paramProfileDialog), 500L);
  }
  
  public void b() {}
  
  public void b(@NotNull ProfileDialog paramProfileDialog)
  {
    Intrinsics.checkParameterIsNotNull(paramProfileDialog, "profileDialog");
    Object localObject = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.c);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…getData(roomIdFromServer)");
    localObject = ((IRoomGetDataService)localObject).b();
    if (localObject == null)
    {
      CustomToastView.a("目前不在扩列大厅无法邀请哦");
      return;
    }
    String str = paramProfileDialog.a();
    paramProfileDialog = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    if (paramProfileDialog != null)
    {
      paramProfileDialog = paramProfileDialog.e();
      if (paramProfileDialog != null)
      {
        paramProfileDialog = paramProfileDialog.u();
        break label91;
      }
    }
    paramProfileDialog = null;
    label91:
    ((ITeamService)ServiceCenter.a(ITeamService.class)).a((Activity)this.b, this.c, ((YoloRoomOuterClass.YoloRoomInfo)localObject).tim_group_id.get(), this.a, str, paramProfileDialog);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.util.ExpandProfileUtil.showProfileDialog.clickListener.1
 * JD-Core Version:    0.7.0.1
 */