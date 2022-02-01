package com.tencent.tkd.topicsdk.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import kotlin.Metadata;
import kotlin.TypeCastException;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/widget/ReverseLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "layoutHorizontal", "", "top", "", "bottom", "layoutVertical", "left", "right", "onLayout", "changed", "", "topicsdk-widget_release"}, k=1, mv={1, 1, 16})
public final class ReverseLinearLayout
  extends LinearLayout
{
  public ReverseLinearLayout(@NotNull Context paramContext, @NotNull AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    int m = getPaddingLeft();
    int j = getPaddingTop();
    int i1 = getPaddingRight();
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      View localView = getChildAt(i);
      int k = j;
      if (localView != null)
      {
        k = j;
        if (localView.getVisibility() != 8)
        {
          int i2 = localView.getMeasuredWidth();
          int i3 = localView.getMeasuredHeight();
          if (!(localView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            break;
          }
          Object localObject = localView.getLayoutParams();
          if (localObject != null)
          {
            localObject = (LinearLayout.LayoutParams)localObject;
            int n = ((LinearLayout.LayoutParams)localObject).gravity;
            k = n;
            if (n < 0) {
              k = 1;
            }
            if ((k & 0x7) != 1) {
              k = m;
            } else {
              k = (paramInt2 - paramInt1 - m - i1 - i2) / 2 + m + ((LinearLayout.LayoutParams)localObject).leftMargin - ((LinearLayout.LayoutParams)localObject).rightMargin;
            }
            j += ((LinearLayout.LayoutParams)localObject).topMargin;
            localView.layout(k, j, i2 + k, j + i3);
            k = j + (i3 + ((LinearLayout.LayoutParams)localObject).bottomMargin + 0);
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          }
        }
      }
      i -= 1;
      j = k;
    }
  }
  
  private final void b(int paramInt1, int paramInt2)
  {
    int m = getPaddingTop();
    int j = getPaddingLeft();
    int i1 = getPaddingBottom();
    int i = getChildCount() - 1;
    while (i >= 0)
    {
      View localView = getChildAt(i);
      int k = j;
      if (localView != null)
      {
        k = j;
        if (localView.getVisibility() != 8)
        {
          int i2 = localView.getMeasuredWidth();
          int i3 = localView.getMeasuredHeight();
          if (!(localView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            break;
          }
          Object localObject = localView.getLayoutParams();
          if (localObject != null)
          {
            localObject = (LinearLayout.LayoutParams)localObject;
            int n = ((LinearLayout.LayoutParams)localObject).gravity;
            k = n;
            if (n < 0) {
              k = 16;
            }
            if ((k & 0x70) != 16) {
              k = m;
            } else {
              k = (paramInt2 - paramInt1 - m - i1 - i3) / 2 + m + ((LinearLayout.LayoutParams)localObject).topMargin - ((LinearLayout.LayoutParams)localObject).bottomMargin;
            }
            j += ((LinearLayout.LayoutParams)localObject).leftMargin;
            localView.layout(j, k, j + i2, i3 + k);
            k = j + (i2 + ((LinearLayout.LayoutParams)localObject).rightMargin + 0);
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
          }
        }
      }
      i -= 1;
      j = k;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getOrientation() == 1)
    {
      a(paramInt1, paramInt3);
      return;
    }
    b(paramInt2, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.ReverseLinearLayout
 * JD-Core Version:    0.7.0.1
 */