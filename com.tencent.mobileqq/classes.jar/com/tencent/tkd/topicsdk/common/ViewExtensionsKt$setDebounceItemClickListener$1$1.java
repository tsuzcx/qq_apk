package com.tencent.tkd.topicsdk.common;

import android.view.View;
import android.widget.AdapterView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "invoke"}, k=3, mv={1, 1, 16})
final class ViewExtensionsKt$setDebounceItemClickListener$1$1
  extends Lambda
  implements Function1<View, Unit>
{
  ViewExtensionsKt$setDebounceItemClickListener$1$1(ViewExtensionsKt.setDebounceItemClickListener.1 param1, AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super(1);
  }
  
  public final void invoke(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "it");
    paramView = this.this$0.a;
    AdapterView localAdapterView = this.$parent;
    Intrinsics.checkExpressionValueIsNotNull(localAdapterView, "parent");
    View localView = this.$view;
    Intrinsics.checkExpressionValueIsNotNull(localView, "view");
    paramView.invoke(localAdapterView, localView, Integer.valueOf(this.$position), Long.valueOf(this.$id));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.ViewExtensionsKt.setDebounceItemClickListener.1.1
 * JD-Core Version:    0.7.0.1
 */