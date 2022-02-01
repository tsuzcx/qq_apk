package com.tencent.mobileqq.kandian.biz.pts.lite;

import android.view.View;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.pts.OnLastReadRefreshListener;
import com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCell.CellListener;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "retData", "", "", "", "", "onEvent"}, k=3, mv={1, 1, 16})
final class PTSLitePlayableCardView$updateComponentLastRead$1
  implements FeedItemCell.CellListener
{
  PTSLitePlayableCardView$updateComponentLastRead$1(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter) {}
  
  public final void a(View paramView, Map<String, Object> paramMap)
  {
    paramView = this.a.y();
    Intrinsics.checkExpressionValueIsNotNull(paramView, "adapter.listenerBuilder");
    paramView = paramView.a();
    if (paramView != null) {
      paramView.m();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.lite.PTSLitePlayableCardView.updateComponentLastRead.1
 * JD-Core Version:    0.7.0.1
 */