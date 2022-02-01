package com.tencent.timi.game.expand.hall.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class ExpandHallFragment$initViews$6
  implements View.OnClickListener
{
  ExpandHallFragment$initViews$6(ExpandHallFragment paramExpandHallFragment) {}
  
  public final void onClick(View paramView)
  {
    if (!NoDoubleClickUtils.a("ExpandHall#expandHallInfoIgv"))
    {
      IQQGuildRouterApi localIQQGuildRouterApi = (IQQGuildRouterApi)QRoute.api(IQQGuildRouterApi.class);
      Object localObject = this.a.getQBaseActivity();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "qBaseActivity");
      localObject = ((QBaseActivity)localObject).getAppRuntime();
      if (localObject != null) {
        localIQQGuildRouterApi.openGuildChannelInfoSetting((AppInterface)localObject, this.a.getContext(), String.valueOf(ExpandHallFragment.b(this.a).c), ExpandHallFragment.b(this.a).f);
      } else {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.ExpandHallFragment.initViews.6
 * JD-Core Version:    0.7.0.1
 */