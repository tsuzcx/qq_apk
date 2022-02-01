package com.tencent.mobileqq.extendfriend.wiget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.troop.widget.FlowLayout;

public class ExtendFriendLabelFlowLayout
  extends FlowLayout
{
  public ExtendFriendLabelFlowLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public ExtendFriendLabelFlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ExtendFriendLabelFlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    int j = getChildCount();
    int i = 0;
    while ((i < this.a.getCount()) && (i < j))
    {
      View localView = getChildAt(i);
      this.a.getView(i, localView, this);
      i += 1;
    }
    if (j > this.a.getCount()) {
      removeViews(i, j - this.a.getCount());
    }
    if (j < this.a.getCount()) {
      while (i < this.a.getCount())
      {
        addView(this.a.getView(i, null, this), new ViewGroup.MarginLayoutParams(-2, -2));
        i += 1;
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i8 = View.MeasureSpec.getSize(paramInt1);
    int i7 = View.MeasureSpec.getSize(paramInt2);
    int i10 = View.MeasureSpec.getMode(paramInt1);
    int i9 = View.MeasureSpec.getMode(paramInt2);
    int j = 0;
    int i = 0;
    int m = 0;
    int n = 0;
    int i11 = getChildCount();
    int k = 1;
    int i6 = 0;
    int i1;
    int i2;
    int i3;
    for (;;)
    {
      if (i6 < i11)
      {
        Object localObject = getChildAt(i6);
        if (((View)localObject).getVisibility() == 8)
        {
          i1 = n;
          n = m;
          m = i1;
          i6 += 1;
          i1 = n;
          n = m;
          m = i1;
        }
        else
        {
          measureChild((View)localObject, paramInt1, paramInt2);
          i2 = ((View)localObject).getMeasuredWidth();
          i1 = ((View)localObject).getMeasuredHeight();
          localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
          i3 = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
          i3 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin + (i2 + i3);
          i2 = ((ViewGroup.MarginLayoutParams)localObject).topMargin + i1 + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
          if (m + i3 > i8)
          {
            i1 = k + 1;
            if (i1 > 2)
            {
              paramInt2 = Math.max(m, i3);
              paramInt1 = i + n;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i10 == 1073741824) {
        paramInt2 = i8;
      }
      if (i9 == 1073741824) {
        paramInt1 = i7;
      }
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      int i5 = Math.max(m, i3);
      int i4 = i + i2;
      for (;;)
      {
        k = i1;
        m = i2;
        n = i3;
        i = i4;
        j = i5;
        if (i6 != i11 - 1) {
          break;
        }
        j = Math.max(i3, i5);
        i = i4 + i2;
        k = i1;
        m = i2;
        n = i3;
        break;
        i2 = Math.max(n, i2);
        i3 = m + i3;
        i1 = k;
        i4 = i;
        i5 = j;
      }
      paramInt1 = i;
      paramInt2 = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendLabelFlowLayout
 * JD-Core Version:    0.7.0.1
 */