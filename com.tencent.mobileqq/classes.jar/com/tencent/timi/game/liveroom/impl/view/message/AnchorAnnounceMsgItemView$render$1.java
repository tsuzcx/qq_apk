package com.tencent.timi.game.liveroom.impl.view.message;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.notice.TimiNoticeDialog;
import com.tencent.timi.game.utils.CommonExKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class AnchorAnnounceMsgItemView$render$1
  implements View.OnClickListener
{
  AnchorAnnounceMsgItemView$render$1(long paramLong) {}
  
  public final void onClick(View paramView)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramView, "it");
    Activity localActivity = CommonExKt.a(paramView);
    if (localActivity != null) {
      TimiNoticeDialog.a((Context)localActivity, this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.message.AnchorAnnounceMsgItemView.render.1
 * JD-Core Version:    0.7.0.1
 */