package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class EllipsizeLayout
  extends LinearLayout
{
  public EllipsizeLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public EllipsizeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = 1;
    int n = 0;
    Object localObject1;
    int i2;
    int k;
    int j;
    int i;
    label129:
    int m;
    if ((getOrientation() == 0) && (View.MeasureSpec.getMode(paramInt1) == 1073741824))
    {
      localObject1 = null;
      int i3 = getChildCount();
      i2 = View.MeasureSpec.getSize(paramInt1);
      int i4 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1), 0);
      k = 0;
      j = 0;
      i = 0;
      if ((k < i3) && (j == 0))
      {
        View localView = getChildAt(k);
        if ((localView == null) || (localView.getVisibility() == 8)) {
          break label304;
        }
        if (!(localView instanceof TextView)) {
          break label301;
        }
        Object localObject2 = (TextView)localView;
        if (((TextView)localObject2).getEllipsize() == null) {
          break label301;
        }
        if (localObject1 == null)
        {
          ((TextView)localObject2).setMaxWidth(2147483647);
          localObject1 = localObject2;
          measureChildWithMargins(localView, i4, 0, paramInt2, 0);
          localObject2 = (LinearLayout.LayoutParams)localView.getLayoutParams();
          if (localObject2 == null) {
            break label224;
          }
          if (((LinearLayout.LayoutParams)localObject2).weight <= 0.0F) {
            break label218;
          }
          m = 1;
          label168:
          j |= m;
          m = localView.getMeasuredWidth();
          int i5 = ((LinearLayout.LayoutParams)localObject2).leftMargin;
          i = ((LinearLayout.LayoutParams)localObject2).rightMargin + (m + i5) + i;
        }
      }
    }
    label298:
    label301:
    label304:
    for (;;)
    {
      k += 1;
      break;
      j = 1;
      break label129;
      label218:
      m = 0;
      break label168;
      label224:
      j = 1;
      continue;
      k = i1;
      if (localObject1 != null)
      {
        if (i == 0) {
          k = i1;
        }
      }
      else if (((j | k) == 0) && (i > i2))
      {
        i = localObject1.getMeasuredWidth() - (i - i2);
        if (i >= 0) {
          break label298;
        }
        i = n;
      }
      for (;;)
      {
        localObject1.setMaxWidth(i);
        super.onMeasure(paramInt1, paramInt2);
        return;
        k = 0;
        break;
      }
      break label129;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.EllipsizeLayout
 * JD-Core Version:    0.7.0.1
 */