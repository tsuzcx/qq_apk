package com.tencent.tkd.topicsdk.mediaselector;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "position", "", "<anonymous parameter 3>", "", "onItemClick"}, k=3, mv={1, 1, 16})
final class RecentMediaListView$onAttachedToWindow$1
  implements AdapterView.OnItemClickListener
{
  RecentMediaListView$onAttachedToWindow$1(RecentMediaListView paramRecentMediaListView) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = RecentMediaListView.a(this.a).get(paramInt);
    Intrinsics.checkExpressionValueIsNotNull(paramAdapterView, "mMediaMapList[position]");
    paramAdapterView = (RecentMediaListView.Album)paramAdapterView;
    paramView = this.a.getOnSelectCallback();
    if (paramView != null) {
      paramAdapterView = (Unit)paramView.invoke(paramAdapterView.a(), paramAdapterView.b(), paramAdapterView.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.mediaselector.RecentMediaListView.onAttachedToWindow.1
 * JD-Core Version:    0.7.0.1
 */