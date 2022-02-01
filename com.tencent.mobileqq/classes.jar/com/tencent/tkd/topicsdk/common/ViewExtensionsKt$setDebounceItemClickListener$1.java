package com.tencent.tkd.topicsdk.common;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "parent", "Landroid/widget/AdapterView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"}, k=3, mv={1, 1, 16})
final class ViewExtensionsKt$setDebounceItemClickListener$1
  implements AdapterView.OnItemClickListener
{
  ViewExtensionsKt$setDebounceItemClickListener$1(Function4 paramFunction4) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Intrinsics.checkExpressionValueIsNotNull(paramAdapterView, "parent");
    ViewExtensionsKt.a((View)paramAdapterView, (Function1)new ViewExtensionsKt.setDebounceItemClickListener.1.1(this, paramAdapterView, paramView, paramInt, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.ViewExtensionsKt.setDebounceItemClickListener.1
 * JD-Core Version:    0.7.0.1
 */