package com.tencent.tkd.topicsdk.selectowner;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.tkd.topicsdk.list.CommonListAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "BEAN", "HOLDER", "Lcom/tencent/tkd/topicsdk/list/CommonListAdapter$BaseListViewHolder;", "<anonymous parameter 0>", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "position", "", "<anonymous parameter 3>", "", "onItemClick"}, k=3, mv={1, 1, 16})
final class BaseSelectView$onAttachedToWindow$1
  implements AdapterView.OnItemClickListener
{
  BaseSelectView$onAttachedToWindow$1(BaseSelectView paramBaseSelectView) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt < this.a.getAdapter().a().size())
    {
      paramAdapterView = BaseSelectView.a(this.a);
      if (paramAdapterView != null) {
        paramAdapterView = (Unit)paramAdapterView.invoke(this.a.getAdapter().a().get(paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.selectowner.BaseSelectView.onAttachedToWindow.1
 * JD-Core Version:    0.7.0.1
 */