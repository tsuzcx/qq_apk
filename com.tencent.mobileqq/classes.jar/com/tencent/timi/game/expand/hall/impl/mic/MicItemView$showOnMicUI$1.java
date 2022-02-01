package com.tencent.timi.game.expand.hall.impl.mic;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.expand.hall.impl.util.ExpandProfileUtil;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import trpc.yes.common.CommonOuterClass.QQUserId;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class MicItemView$showOnMicUI$1
  implements View.OnClickListener
{
  MicItemView$showOnMicUI$1(CommonOuterClass.QQUserId paramQQUserId) {}
  
  public final void onClick(View paramView)
  {
    IExpandHall localIExpandHall = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    if (localIExpandHall == null)
    {
      Logger.c("MicItemView_", "userAvatarView#OnClick currentHall is null!");
    }
    else
    {
      ExpandProfileUtil localExpandProfileUtil = ExpandProfileUtil.a;
      QBaseActivity localQBaseActivity = TimiGameActivityManager.a();
      Intrinsics.checkExpressionValueIsNotNull(localQBaseActivity, "TimiGameActivityManager.getTopQActivity()");
      localExpandProfileUtil.a(localQBaseActivity, this.a, localIExpandHall.h());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.mic.MicItemView.showOnMicUI.1
 * JD-Core Version:    0.7.0.1
 */