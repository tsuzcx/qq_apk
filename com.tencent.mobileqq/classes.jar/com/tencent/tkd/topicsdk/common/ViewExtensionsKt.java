package com.tencent.tkd.topicsdk.common;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.SystemClock;
import android.view.View;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
      if (paramView != null) {
        return (Activity)paramView;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }
    if ((paramView.getContext() instanceof ContextWrapper))
    {
      paramView = paramView.getContext();
      if (paramView != null)
      {
        Context localContext = ((ContextWrapper)paramView).getBaseContext();
        paramView = localContext;
        if (!(localContext instanceof Activity)) {
          paramView = null;
        }
        return (Activity)paramView;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.content.ContextWrapper");
    }
    return null;
  }
  
  public static final void b(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$setStatusBarHeightPadding");
    SystemBarTintUtil localSystemBarTintUtil = SystemBarTintUtil.a;
    Context localContext = paramView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
    paramView.setPadding(0, localSystemBarTintUtil.a(localContext), 0, 0);
  }
  
  private static final void b(View paramView, Function1<? super View, Unit> paramFunction1)
  {
    Long localLong = (Long)paramView.getTag(R.id.e);
    if (localLong != null)
    {
      if (SystemClock.uptimeMillis() - localLong.longValue() > 500)
      {
        paramView.setTag(R.id.e, Long.valueOf(SystemClock.uptimeMillis()));
        paramFunction1.invoke(paramView);
      }
    }
    else
    {
      paramView.setTag(R.id.e, Long.valueOf(SystemClock.uptimeMillis()));
      paramFunction1.invoke(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.ViewExtensionsKt
 * JD-Core Version:    0.7.0.1
 */