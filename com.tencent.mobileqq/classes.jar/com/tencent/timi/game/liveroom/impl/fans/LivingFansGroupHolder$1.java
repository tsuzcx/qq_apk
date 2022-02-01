package com.tencent.timi.game.liveroom.impl.fans;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class LivingFansGroupHolder$1
  implements View.OnClickListener
{
  LivingFansGroupHolder$1(LivingFansGroupHolder paramLivingFansGroupHolder) {}
  
  public final void onClick(View paramView)
  {
    if (!NoDoubleClickUtils.a()) {
      this.a.a().a(LivingFansGroupHolder.a(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.fans.LivingFansGroupHolder.1
 * JD-Core Version:    0.7.0.1
 */