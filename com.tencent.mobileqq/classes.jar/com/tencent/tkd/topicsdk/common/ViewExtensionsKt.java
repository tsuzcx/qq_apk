package com.tencent.tkd.topicsdk.common;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.SystemClock;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TIME_INTERVAL", "", "handleDebounceClick", "", "view", "Landroid/view/View;", "listener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "getActivity", "Landroid/app/Activity;", "setDebounceClickListener", "Landroid/view/View$OnClickListener;", "setDebounceItemClickListener", "Landroid/widget/AbsListView;", "Lkotlin/Function4;", "Landroid/widget/AdapterView;", "parent", "position", "", "id", "setStatusBarHeightPadding", "topicsdk-common_release"}, k=2, mv={1, 1, 16})
public final class ViewExtensionsKt
{
  @Nullable
  public static final Activity a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$getActivity");
    if ((paramView.getContext() instanceof Activity))
    {
      paramView = paramView.getContext();
      if (paramView == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
      }
      return (Activity)paramView;
    }
    if ((paramView.getContext() instanceof ContextWrapper))
    {
      paramView = paramView.getContext();
      if (paramView == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.content.ContextWrapper");
      }
      Context localContext = ((ContextWrapper)paramView).getBaseContext();
      paramView = localContext;
      if (!(localContext instanceof Activity)) {
        paramView = null;
      }
      return (Activity)paramView;
    }
    return null;
  }
  
  public static final void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$setStatusBarHeightPadding");
    SystemBarTintUtil localSystemBarTintUtil = SystemBarTintUtil.a;
    Context localContext = paramView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    paramView.setPadding(0, localSystemBarTintUtil.a(localContext), 0, 0);
  }
  
  public static final void a(@NotNull AbsListView paramAbsListView, @NotNull Function4<? super AdapterView<?>, ? super View, ? super Integer, ? super Long, Unit> paramFunction4)
  {
    Intrinsics.checkParameterIsNotNull(paramAbsListView, "$this$setDebounceItemClickListener");
    Intrinsics.checkParameterIsNotNull(paramFunction4, "listener");
    paramAbsListView.setOnItemClickListener((AdapterView.OnItemClickListener)new ViewExtensionsKt.setDebounceItemClickListener.1(paramFunction4));
  }
  
  private static final void b(View paramView, Function1<? super View, Unit> paramFunction1)
  {
    Long localLong = (Long)paramView.getTag(R.id.a);
    if (localLong != null)
    {
      if (SystemClock.uptimeMillis() - localLong.longValue() > 500)
      {
        paramView.setTag(R.id.a, Long.valueOf(SystemClock.uptimeMillis()));
        paramFunction1.invoke(paramView);
      }
      return;
    }
    paramView.setTag(R.id.a, Long.valueOf(SystemClock.uptimeMillis()));
    paramFunction1.invoke(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.ViewExtensionsKt
 * JD-Core Version:    0.7.0.1
 */