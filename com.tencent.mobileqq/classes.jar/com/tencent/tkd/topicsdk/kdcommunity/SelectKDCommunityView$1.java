package com.tencent.tkd.topicsdk.kdcommunity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "<anonymous parameter 2>", "", "<anonymous parameter 3>", "", "onItemClick"}, k=3, mv={1, 1, 16})
final class SelectKDCommunityView$1
  implements AdapterView.OnItemClickListener
{
  SelectKDCommunityView$1(SelectKDCommunityView paramSelectKDCommunityView) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramView, "view");
    paramView = paramView.getTag();
    paramAdapterView = paramView;
    if (!(paramView instanceof KDCommunityAdapter.CommunityHolder)) {
      paramAdapterView = null;
    }
    paramAdapterView = (KDCommunityAdapter.CommunityHolder)paramAdapterView;
    if (paramAdapterView != null)
    {
      paramView = this.a.getOnSelectCallback();
      if (paramView != null) {
        paramAdapterView = (Unit)paramView.invoke(paramAdapterView.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.kdcommunity.SelectKDCommunityView.1
 * JD-Core Version:    0.7.0.1
 */