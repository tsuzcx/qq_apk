package com.tencent.mobileqq.kandian.biz.ugc.selecttopic;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "BEAN", "HOLDER", "Lcom/tencent/mobileqq/kandian/biz/ugc/selecttopic/BaseSelectAdapter$BaseSelectViewHolder;", "<anonymous parameter 0>", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "position", "", "<anonymous parameter 3>", "", "onItemClick"}, k=3, mv={1, 1, 16})
final class BaseSelectView$onAttachedToWindow$2
  implements AdapterView.OnItemClickListener
{
  BaseSelectView$onAttachedToWindow$2(BaseSelectView paramBaseSelectView) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a.a();
    if (paramAdapterView != null) {
      paramAdapterView = (Unit)paramAdapterView.invoke(this.a.a().a().get(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.selecttopic.BaseSelectView.onAttachedToWindow.2
 * JD-Core Version:    0.7.0.1
 */