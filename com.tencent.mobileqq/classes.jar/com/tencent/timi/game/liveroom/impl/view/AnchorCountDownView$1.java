package com.tencent.timi.game.liveroom.impl.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class AnchorCountDownView$1
  implements View.OnClickListener
{
  AnchorCountDownView$1(AnchorCountDownView paramAnchorCountDownView) {}
  
  public final void onClick(View paramView)
  {
    Logger.INSTANCE.i(new String[] { AnchorCountDownView.b(this.a), "AnchorCountDownView countdown" });
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorCountDownView.1
 * JD-Core Version:    0.7.0.1
 */