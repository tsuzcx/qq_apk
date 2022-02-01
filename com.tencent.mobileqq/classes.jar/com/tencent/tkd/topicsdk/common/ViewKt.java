package com.tencent.tkd.topicsdk.common;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"horizontalMargin", "", "Landroid/view/View;", "getHorizontalMargin", "(Landroid/view/View;)I", "horizontalPadding", "getHorizontalPadding", "measuredHeightWithMargin", "getMeasuredHeightWithMargin", "measuredHeightWithoutPadding", "getMeasuredHeightWithoutPadding", "measuredWidthWithMargin", "getMeasuredWidthWithMargin", "measuredWidthWithoutPadding", "getMeasuredWidthWithoutPadding", "verticalMargin", "getVerticalMargin", "verticalPadding", "getVerticalPadding", "topicsdk-common_release"}, k=2, mv={1, 1, 16})
public final class ViewKt
{
  public static final int a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$measuredHeightWithMargin");
    return paramView.getMeasuredHeight() + d(paramView);
  }
  
  public static final int b(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$measuredHeightWithoutPadding");
    return paramView.getMeasuredHeight() - e(paramView);
  }
  
  public static final int c(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$measuredWidthWithoutPadding");
    return paramView.getMeasuredWidth() - f(paramView);
  }
  
  public static final int d(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$verticalMargin");
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    Object localObject = localLayoutParams;
    if (!(localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      localObject = null;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    int j = 0;
    int i;
    if (localObject != null) {
      i = ((ViewGroup.MarginLayoutParams)localObject).topMargin;
    } else {
      i = 0;
    }
    localObject = paramView.getLayoutParams();
    paramView = (View)localObject;
    if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
      paramView = null;
    }
    paramView = (ViewGroup.MarginLayoutParams)paramView;
    if (paramView != null) {
      j = paramView.bottomMargin;
    }
    return i + j;
  }
  
  public static final int e(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$verticalPadding");
    return paramView.getPaddingTop() + paramView.getPaddingBottom();
  }
  
  public static final int f(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$horizontalPadding");
    return paramView.getPaddingLeft() + paramView.getPaddingRight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.ViewKt
 * JD-Core Version:    0.7.0.1
 */