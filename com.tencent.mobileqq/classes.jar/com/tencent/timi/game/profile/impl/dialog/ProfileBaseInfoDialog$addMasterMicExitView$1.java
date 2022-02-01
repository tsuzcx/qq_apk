package com.tencent.timi.game.profile.impl.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomDoOpService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ProfileBaseInfoDialog$addMasterMicExitView$1
  implements View.OnClickListener
{
  ProfileBaseInfoDialog$addMasterMicExitView$1(ProfileBaseInfoDialog paramProfileBaseInfoDialog) {}
  
  public final void onClick(View paramView)
  {
    if (!NoDoubleClickUtils.a())
    {
      if (this.a.q() != null) {
        ((IRoomService)ServiceCenter.a(IRoomService.class)).b(this.a.q().longValue()).a((IResultListener)ProfileBaseInfoDialog.d(this.a));
      }
      ((IReportService)ServiceCenter.a(IReportService.class)).a("ev_yes_leave_mic", ProfileBaseInfoDialog.e(this.a));
      this.a.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.dialog.ProfileBaseInfoDialog.addMasterMicExitView.1
 * JD-Core Version:    0.7.0.1
 */