package com.tencent.mobileqq.qqexpand.widget;

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
  
  protected void a()
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
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i6 = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    int i8 = View.MeasureSpec.getMode(paramInt1);
    int i7 = View.MeasureSpec.getMode(paramInt2);
    int i9 = getChildCount();
    int i2 = 0;
    int i1 = 0;
    int n = 0;
    int m = 1;
    int i = 0;
    int i3;
    for (int j = 0; i2 < i9; j = i3)
    {
      Object localObject = getChildAt(i2);
      if (((View)localObject).getVisibility() == 8)
      {
        i3 = j;
      }
      else
      {
        measureChild((View)localObject, paramInt1, paramInt2);
        i3 = ((View)localObject).getMeasuredWidth();
        int i4 = ((View)localObject).getMeasuredHeight();
        localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
        i3 = i3 + ((ViewGroup.MarginLayoutParams)localObject).leftMargin + ((ViewGroup.MarginLayoutParams)localObject).rightMargin;
        i4 = i4 + ((ViewGroup.MarginLayoutParams)localObject).topMargin + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
        int i5 = i1 + i3;
        if (i5 > i6)
        {
          m += 1;
          if (m > 2)
          {
            paramInt1 = Math.max(i1, i3);
            i += n;
            break label304;
          }
          i1 = Math.max(i1, i3);
          j = i + i4;
          i = i4;
          n = i3;
        }
        else
        {
          i3 = Math.max(n, i4);
          n = i5;
          i1 = j;
          j = i;
          i = i3;
        }
        if (i2 == i9 - 1)
        {
          i1 = Math.max(n, i1);
          j += i;
        }
        i4 = i;
        i5 = n;
        i3 = i1;
        i = j;
        n = i4;
        i1 = i5;
      }
      i2 += 1;
    }
    paramInt1 = j;
    label304:
    if (i8 == 1073741824) {
      paramInt1 = i6;
    }
    if (i7 == 1073741824) {
      i = k;
    }
    setMeasuredDimension(paramInt1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ExtendFriendLabelFlowLayout
 * JD-Core Version:    0.7.0.1
 */