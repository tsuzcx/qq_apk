package com.tencent.timi.game.liveroom.impl.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class AnchorMessageLayout$showAtMsgWhenFirstLoad$2$1
  implements View.OnClickListener
{
  AnchorMessageLayout$showAtMsgWhenFirstLoad$2$1(AnchorMessageLayout.showAtMsgWhenFirstLoad.2 param2) {}
  
  public final void onClick(View paramView)
  {
    int i = AnchorMessageLayout.g(this.a.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showAtMsgWhenFirstLoad: next ");
    localStringBuilder.append(i);
    Logger.b("AnchorMessageLayout", localStringBuilder.toString());
    AnchorMessageLayout.a(this.a.this$0, AnchorMessageLayout.d(this.a.this$0), Math.max(0, i), true);
    AnchorMessageLayout.j(this.a.this$0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorMessageLayout.showAtMsgWhenFirstLoad.2.1
 * JD-Core Version:    0.7.0.1
 */