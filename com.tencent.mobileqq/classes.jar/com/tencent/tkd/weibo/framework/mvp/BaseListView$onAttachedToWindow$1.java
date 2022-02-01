package com.tencent.tkd.weibo.framework.mvp;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.tkd.weibo.component.R.id;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "BEAN", "<anonymous parameter 0>", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "position", "", "<anonymous parameter 3>", "", "onItemClick"}, k=3, mv={1, 1, 16})
final class BaseListView$onAttachedToWindow$1
  implements AdapterView.OnItemClickListener
{
  BaseListView$onAttachedToWindow$1(BaseListView paramBaseListView) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ListView)this.a.a(R.id.g);
    Intrinsics.checkExpressionValueIsNotNull(paramAdapterView, "listView");
    paramInt -= paramAdapterView.getHeaderViewsCount();
    if ((paramInt < this.a.a().a().size()) && (paramInt >= 0) && (this.a.a().getItemViewType(paramInt) != -1))
    {
      paramAdapterView = BaseListView.a(this.a);
      if (paramAdapterView != null) {
        paramAdapterView = (Unit)paramAdapterView.invoke(this.a.a().a().get(paramInt));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.weibo.framework.mvp.BaseListView.onAttachedToWindow.1
 * JD-Core Version:    0.7.0.1
 */