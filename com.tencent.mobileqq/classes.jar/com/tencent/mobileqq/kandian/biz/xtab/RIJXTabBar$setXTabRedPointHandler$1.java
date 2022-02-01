package com.tencent.mobileqq.kandian.biz.xtab;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "itemView", "Landroid/view/View;", "tabChannelInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/TabChannelCoverInfo;", "invoke"}, k=3, mv={1, 1, 16})
final class RIJXTabBar$setXTabRedPointHandler$1
  extends Lambda
  implements Function2<View, TabChannelCoverInfo, Unit>
{
  RIJXTabBar$setXTabRedPointHandler$1(RIJXTabBar paramRIJXTabBar)
  {
    super(2);
  }
  
  public final void invoke(@NotNull View paramView, @NotNull TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "itemView");
    Intrinsics.checkParameterIsNotNull(paramTabChannelCoverInfo, "tabChannelInfo");
    RelativeLayout localRelativeLayout = (RelativeLayout)paramView.findViewById(2131376318);
    paramView = (TextView)paramView.findViewById(2131379930);
    RIJXTabBar localRIJXTabBar = this.this$0;
    Intrinsics.checkExpressionValueIsNotNull(localRelativeLayout, "redPointContainer");
    Intrinsics.checkExpressionValueIsNotNull(paramView, "titleView");
    RIJXTabBar.a(localRIJXTabBar, localRelativeLayout, paramView, paramTabChannelCoverInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabBar.setXTabRedPointHandler.1
 * JD-Core Version:    0.7.0.1
 */