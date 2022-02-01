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
    int i = getPaddingTop();
    int i1 = getPaddingRight();
    int j = getChildCount() - 1;
    int i2;
    Object localObject;
    int k;
    if (j >= 0)
    {
      View localView = getChildAt(j);
      if ((localView == null) || (localView.getVisibility() == 8)) {
        break label234;
      }
      i2 = localView.getMeasuredWidth();
      int i3 = localView.getMeasuredHeight();
      if ((localView.getLayoutParams() instanceof LinearLayout.LayoutParams))
      {
        localObject = localView.getLayoutParams();
        if (localObject == null) {
          throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        localObject = (LinearLayout.LayoutParams)localObject;
        int n = ((LinearLayout.LayoutParams)localObject).gravity;
        k = n;
        if (n < 0) {
          k = 1;
        }
        switch (k & 0x7)
        {
        default: 
          k = m;
          label152:
          i += ((LinearLayout.LayoutParams)localObject).topMargin;
          localView.layout(k, i, i2 + k, i + i3);
          i = ((LinearLayout.LayoutParams)localObject).bottomMargin + i3 + 0 + i;
        }
      }
    }
    label234:
    for (;;)
    {
      j -= 1;
      break;
      k = (paramInt2 - paramInt1 - m - i1 - i2) / 2 + m + ((LinearLayout.LayoutParams)localObject).leftMargin - ((LinearLayout.LayoutParams)localObject).rightMargin;
      break label152;
      return;
    }
  }
  
  private final void b(int paramInt1, int paramInt2)
  {
    int m = getPaddingTop();
    int i = getPaddingLeft();
    int i1 = getPaddingBottom();
    int j = getChildCount() - 1;
    int i3;
    Object localObject;
    int k;
    if (j >= 0)
    {
      View localView = getChildAt(j);
      if ((localView == null) || (localView.getVisibility() == 8)) {
        break label238;
      }
      int i2 = localView.getMeasuredWidth();
      i3 = localView.getMeasuredHeight();
      if ((localView.getLayoutParams() instanceof LinearLayout.LayoutParams))
      {
        localObject = localView.getLayoutParams();
        if (localObject == null) {
          throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        }
        localObject = (LinearLayout.LayoutParams)localObject;
        int n = ((LinearLayout.LayoutParams)localObject).gravity;
        k = n;
        if (n < 0) {
          k = 16;
        }
        switch (k & 0x70)
        {
        default: 
          k = m;
          label156:
          i += ((LinearLayout.LayoutParams)localObject).leftMargin;
          localView.layout(i, k, i + i2, i3 + k);
          i = ((LinearLayout.LayoutParams)localObject).rightMargin + i2 + 0 + i;
        }
      }
    }
    label238:
    for (;;)
    {
      j -= 1;
      break;
      k = (paramInt2 - paramInt1 - m - i1 - i3) / 2 + m + ((LinearLayout.LayoutParams)localObject).topMargin - ((LinearLayout.LayoutParams)localObject).bottomMargin;
      break label156;
      return;
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getOrientation() == 1)
    {
      a(paramInt1, paramInt3);
      return;
    }
    b(paramInt2, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.widget.ReverseLinearLayout
 * JD-Core Version:    0.7.0.1
 */