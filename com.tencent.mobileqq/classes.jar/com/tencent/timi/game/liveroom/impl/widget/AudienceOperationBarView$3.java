package com.tencent.timi.game.liveroom.impl.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class AudienceOperationBarView$3
  implements View.OnClickListener
{
  AudienceOperationBarView$3(AudienceOperationBarView paramAudienceOperationBarView) {}
  
  public final void onClick(View paramView)
  {
    if (!NoDoubleClickUtils.a("tag_gift_entrance"))
    {
      AudienceOperationBarView.IAudienceOperationViewListener localIAudienceOperationViewListener = AudienceOperationBarView.e(this.a);
      if (localIAudienceOperationViewListener != null) {
        localIAudienceOperationViewListener.c();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.widget.AudienceOperationBarView.3
 * JD-Core Version:    0.7.0.1
 */