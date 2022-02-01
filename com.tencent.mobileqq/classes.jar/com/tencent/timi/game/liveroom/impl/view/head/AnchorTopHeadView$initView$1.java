package com.tencent.timi.game.liveroom.impl.view.head;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.profile.LivingOperateHelper;
import com.tencent.timi.game.utils.CommonExKt;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class AnchorTopHeadView$initView$1
  implements View.OnClickListener
{
  AnchorTopHeadView$initView$1(AnchorTopHeadView paramAnchorTopHeadView) {}
  
  public final void onClick(View paramView)
  {
    if (!NoDoubleClickUtils.a())
    {
      Activity localActivity = CommonExKt.a(this.a);
      if (localActivity != null) {
        LivingOperateHelper.a.a(paramView, (Context)localActivity, AnchorTopHeadView.a(this.a), AnchorTopHeadView.b(this.a), 0);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.head.AnchorTopHeadView.initView.1
 * JD-Core Version:    0.7.0.1
 */