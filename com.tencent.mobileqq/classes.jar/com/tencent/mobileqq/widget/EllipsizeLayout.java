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
    if ((getOrientation() == 0) && (View.MeasureSpec.getMode(paramInt1) == 1073741824))
    {
      int i3 = getChildCount();
      int i2 = View.MeasureSpec.getSize(paramInt1);
      int i4 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1), 0);
      Object localObject1 = null;
      int m = 0;
      int i = 0;
      int n;
      for (int k = 0;; k = n)
      {
        n = 1;
        int i1 = 1;
        if ((m >= i3) || (i != 0)) {
          break;
        }
        View localView = getChildAt(m);
        j = i;
        Object localObject2 = localObject1;
        n = k;
        if (localView != null)
        {
          j = i;
          localObject2 = localObject1;
          n = k;
          if (localView.getVisibility() != 8)
          {
            if ((localView instanceof TextView))
            {
              localObject2 = (TextView)localView;
              if (((TextView)localObject2).getEllipsize() != null) {
                if (localObject1 == null)
                {
                  ((TextView)localObject2).setMaxWidth(2147483647);
                  localObject1 = localObject2;
                }
                else
                {
                  i = 1;
                }
              }
            }
            measureChildWithMargins(localView, i4, 0, paramInt2, 0);
            localObject2 = (LinearLayout.LayoutParams)localView.getLayoutParams();
            if (localObject2 != null)
            {
              if (((LinearLayout.LayoutParams)localObject2).weight > 0.0F) {
                j = i1;
              } else {
                j = 0;
              }
              n = k + (localView.getMeasuredWidth() + ((LinearLayout.LayoutParams)localObject2).leftMargin + ((LinearLayout.LayoutParams)localObject2).rightMargin);
              j = i | j;
              localObject2 = localObject1;
            }
            else
            {
              j = 1;
              n = k;
              localObject2 = localObject1;
            }
          }
        }
        m += 1;
        i = j;
        localObject1 = localObject2;
      }
      int j = n;
      if (localObject1 != null) {
        if (k == 0) {
          j = n;
        } else {
          j = 0;
        }
      }
      if (((i | j) == 0) && (k > i2))
      {
        j = localObject1.getMeasuredWidth() - (k - i2);
        i = j;
        if (j < 0) {
          i = 0;
        }
        localObject1.setMaxWidth(i);
      }
    }
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.EllipsizeLayout
 * JD-Core Version:    0.7.0.1
 */