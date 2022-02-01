package com.tencent.xaction.impl;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.xaction.api.data.FloatViewData;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/impl/FloatViewUtil$Companion;", "", "()V", "TAG", "", "bringToFront", "", "floatViewData", "Lcom/tencent/xaction/api/data/FloatViewData;", "view", "Landroid/view/View;", "removeViewToFloat", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class FloatViewUtil$Companion
{
  public final void a(@NotNull FloatViewData paramFloatViewData, @NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramFloatViewData, "floatViewData");
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    if (((Intrinsics.areEqual(paramView.getParent(), paramFloatViewData.getParent()) ^ true)) && ((paramFloatViewData.getParent() instanceof ViewGroup)))
    {
      Log.v("FloatViewUtils", "removeViewToFloat view.parent:" + paramView.getParent() + " view:" + paramView);
      if (paramView.getParent() != null)
      {
        localViewParent = paramView.getParent();
        if (localViewParent == null) {
          throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ((ViewGroup)localViewParent).removeView(paramView);
      }
      ViewParent localViewParent = paramFloatViewData.getParent();
      if (localViewParent == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
      ((ViewGroup)localViewParent).addView(paramView, paramFloatViewData.getIndex(), paramFloatViewData.getLayoutParam());
      paramFloatViewData.setParent((ViewParent)null);
      paramFloatViewData.setLayoutParam((ViewGroup.LayoutParams)null);
    }
  }
  
  public final void b(@NotNull FloatViewData paramFloatViewData, @NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramFloatViewData, "floatViewData");
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    if (((paramView.getParent() instanceof ViewGroup)) && ((Intrinsics.areEqual(paramFloatViewData.getParent(), paramView.getParent()) ^ true)) && ((Intrinsics.areEqual(paramView.getRootView(), paramView.getParent()) ^ true)))
    {
      Log.v("FloatViewUtils", "bringToFront view.parent:" + paramView.getParent() + " view:" + paramView);
      View localView = paramView.getRootView();
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      if (paramView.getParent() != null)
      {
        paramFloatViewData.setParent(paramView.getParent());
        paramFloatViewData.setLayoutParam(paramView.getLayoutParams());
        ViewParent localViewParent = paramView.getParent();
        if (localViewParent == null) {
          throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        paramFloatViewData.setIndex(((ViewGroup)localViewParent).indexOfChild(paramView));
        paramFloatViewData = paramView.getParent();
        if (paramFloatViewData == null) {
          throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ((ViewGroup)paramFloatViewData).removeView(paramView);
      }
      if ((localView != null) && ((localView instanceof FrameLayout)))
      {
        paramFloatViewData = new FrameLayout.LayoutParams(paramView.getLayoutParams());
        paramFloatViewData.leftMargin = arrayOfInt[0];
        paramFloatViewData.topMargin = arrayOfInt[1];
        ((FrameLayout)localView).addView(paramView, (ViewGroup.LayoutParams)paramFloatViewData);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.impl.FloatViewUtil.Companion
 * JD-Core Version:    0.7.0.1
 */