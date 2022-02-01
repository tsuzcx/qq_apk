package com.tencent.mobileqq.nearby.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/nearby/widget/NearbyHorizontalWrapLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "generateDefaultLayoutParams", "Landroid/view/ViewGroup$LayoutParams;", "generateLayoutParams", "p", "onLayout", "", "changed", "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NearbyHorizontalWrapLayout
  extends ViewGroup
{
  @JvmOverloads
  public NearbyHorizontalWrapLayout(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public NearbyHorizontalWrapLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public NearbyHorizontalWrapLayout(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @NotNull
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return (ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(-2, -2);
  }
  
  @NotNull
  public ViewGroup.LayoutParams generateLayoutParams(@Nullable AttributeSet paramAttributeSet)
  {
    return (ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  @NotNull
  protected ViewGroup.LayoutParams generateLayoutParams(@Nullable ViewGroup.LayoutParams paramLayoutParams)
  {
    return (ViewGroup.LayoutParams)new ViewGroup.MarginLayoutParams(paramLayoutParams);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = getPaddingLeft();
    int k = paramInt3 - getPaddingRight() - paramInt1;
    paramInt1 = getPaddingTop();
    int m = getChildCount();
    paramInt2 = 0;
    int j = 0;
    while (j < m)
    {
      View localView = getChildAt(j);
      Intrinsics.checkExpressionValueIsNotNull(localView, "child");
      if (localView.getVisibility() == 8)
      {
        paramInt3 = paramInt2;
      }
      else
      {
        Object localObject = localView.getLayoutParams();
        if (localObject == null) {
          break label324;
        }
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        paramInt3 = paramInt4 + ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        paramInt4 = localView.getMeasuredWidth() + paramInt3;
        int n = ((ViewGroup.MarginLayoutParams)localObject).rightMargin + paramInt4;
        int i;
        if (n <= k)
        {
          i = ((ViewGroup.MarginLayoutParams)localObject).topMargin + paramInt1;
          localView.layout(paramInt3, i, paramInt4, localView.getMeasuredHeight() + i);
          paramInt4 += ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
          paramInt3 = ((ViewGroup.MarginLayoutParams)localObject).topMargin + localView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
          if (paramInt2 >= paramInt3) {
            paramInt3 = paramInt2;
          }
          paramInt2 = paramInt1;
          i = paramInt3;
          if (n == k)
          {
            paramInt4 = getPaddingLeft();
            paramInt1 += paramInt3;
            paramInt3 = 0;
            break label312;
          }
        }
        else
        {
          paramInt2 = paramInt1 + paramInt2;
          i = ((ViewGroup.MarginLayoutParams)localObject).topMargin + localView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
          paramInt1 = getPaddingLeft() + ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
          paramInt3 = localView.getMeasuredWidth() + paramInt1;
          paramInt4 = ((ViewGroup.MarginLayoutParams)localObject).topMargin + paramInt2;
          localView.layout(paramInt1, paramInt4, paramInt3, localView.getMeasuredHeight() + paramInt4);
          paramInt4 = paramInt3 + ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
        }
        paramInt3 = i;
        paramInt1 = paramInt2;
      }
      label312:
      j += 1;
      paramInt2 = paramInt3;
      continue;
      label324:
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i3 = View.MeasureSpec.makeMeasureSpec(i2, 0);
    int i4 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2), 0);
    int i = getPaddingLeft();
    int i5 = i2 - getPaddingRight();
    int k = getPaddingTop();
    int i6 = getChildCount();
    int j = 0;
    paramInt1 = 0;
    while (j < i6)
    {
      View localView = getChildAt(j);
      Intrinsics.checkExpressionValueIsNotNull(localView, "child");
      int n;
      if (localView.getVisibility() == 8)
      {
        n = k;
        paramInt2 = paramInt1;
      }
      else
      {
        measureChild(localView, i3, i4);
        Object localObject = localView.getLayoutParams();
        if (localObject == null) {
          break label258;
        }
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        paramInt2 = localView.getMeasuredWidth();
        n = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
        int i1 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
        int m = localView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams)localObject).topMargin + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
        i1 = i + (paramInt2 + n + i1);
        if (i1 >= i5)
        {
          paramInt2 = paramInt1;
          if (i1 == i5)
          {
            paramInt2 = paramInt1;
            if (m > paramInt1) {
              paramInt2 = m;
            }
          }
          i = getPaddingLeft();
          n = k + paramInt2;
          paramInt2 = 0;
        }
        else
        {
          n = k;
          paramInt2 = paramInt1;
          i = i1;
          if (m > paramInt1)
          {
            paramInt2 = m;
            i = i1;
            n = k;
          }
        }
      }
      j += 1;
      k = n;
      paramInt1 = paramInt2;
      continue;
      label258:
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
    setMeasuredDimension(i2, k + paramInt1 + getPaddingBottom());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.NearbyHorizontalWrapLayout
 * JD-Core Version:    0.7.0.1
 */