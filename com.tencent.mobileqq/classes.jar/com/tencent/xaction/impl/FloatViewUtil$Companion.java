package com.tencent.xaction.impl;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.xaction.api.data.FloatViewData;
import com.tencent.xaction.helper.ViewHelper;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/impl/FloatViewUtil$Companion;", "", "()V", "TAG", "", "bringToFront", "", "floatViewData", "Lcom/tencent/xaction/api/data/FloatViewData;", "view", "Landroid/view/View;", "removeViewToFloat", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class FloatViewUtil$Companion
{
  public final void a(@NotNull FloatViewData paramFloatViewData, @NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramFloatViewData, "floatViewData");
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    if (((Intrinsics.areEqual(paramView.getParent(), paramFloatViewData.getParent()) ^ true)) && ((paramFloatViewData.getParent() instanceof ViewGroup)))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("removeViewToFloat view.parent:");
      ((StringBuilder)localObject).append(paramView.getParent());
      ((StringBuilder)localObject).append(" view:");
      ((StringBuilder)localObject).append(paramView);
      Log.v("FloatViewUtils", ((StringBuilder)localObject).toString());
      ViewHelper.a.a(paramView);
      localObject = paramFloatViewData.getParent();
      if (localObject != null)
      {
        ((ViewGroup)localObject).addView(paramView, paramFloatViewData.getIndex(), paramFloatViewData.getLayoutParam());
        paramFloatViewData.setParent((ViewParent)null);
        paramFloatViewData.setLayoutParam((ViewGroup.LayoutParams)null);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }
  }
  
  public final void b(@NotNull FloatViewData paramFloatViewData, @NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramFloatViewData, "floatViewData");
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    if (((paramView.getParent() instanceof ViewGroup)) && ((Intrinsics.areEqual(paramFloatViewData.getParent(), paramView.getParent()) ^ true)) && ((Intrinsics.areEqual(paramView.getRootView(), paramView.getParent()) ^ true)))
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bringToFront view.parent:");
      ((StringBuilder)localObject).append(paramView.getParent());
      ((StringBuilder)localObject).append(" view:");
      ((StringBuilder)localObject).append(paramView);
      Log.v("FloatViewUtils", ((StringBuilder)localObject).toString());
      localObject = paramView.getRootView();
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      if (paramView.getParent() != null)
      {
        paramFloatViewData.setParent(paramView.getParent());
        paramFloatViewData.setLayoutParam(paramView.getLayoutParams());
        ViewParent localViewParent = paramView.getParent();
        if (localViewParent != null)
        {
          paramFloatViewData.setIndex(((ViewGroup)localViewParent).indexOfChild(paramView));
          ViewHelper.a.a(paramView);
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
      }
      if ((localObject != null) && ((localObject instanceof FrameLayout)))
      {
        paramFloatViewData = new FrameLayout.LayoutParams(paramView.getLayoutParams());
        paramFloatViewData.leftMargin = arrayOfInt[0];
        paramFloatViewData.topMargin = arrayOfInt[1];
        ((FrameLayout)localObject).addView(paramView, (ViewGroup.LayoutParams)paramFloatViewData);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.impl.FloatViewUtil.Companion
 * JD-Core Version:    0.7.0.1
 */