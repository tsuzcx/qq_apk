package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AdaptiveLayout
  extends ViewGroup
{
  private int jdField_a_of_type_Int;
  private Map<Integer, AdaptiveLayout.Size> jdField_a_of_type_JavaUtilMap = new HashMap();
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public AdaptiveLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdaptiveLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AdaptiveLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i8 = View.MeasureSpec.getMode(paramInt1);
    int i7 = View.MeasureSpec.getMode(paramInt2);
    int i6 = View.MeasureSpec.getSize(paramInt1);
    int i5 = View.MeasureSpec.getSize(paramInt2);
    int i = getPaddingLeft();
    int j = getPaddingRight();
    int i9 = getChildCount();
    this.jdField_a_of_type_JavaUtilMap.clear();
    measureChildren(paramInt1, paramInt2);
    int n = i + j;
    int i3 = 0;
    j = 0;
    i = 0;
    int m;
    for (int k = 0; i3 < i9; k = m)
    {
      View localView = getChildAt(i3);
      int i2 = n;
      int i1 = j;
      int i4 = i;
      m = k;
      if (localView.getVisibility() != 8) {
        if (i8 != 0)
        {
          i4 = n;
          i1 = j;
          m = i;
          i2 = k;
          if (i3 > 0)
          {
            i4 = n;
            i1 = j;
            m = i;
            i2 = k;
            if (localView.getMeasuredWidth() + n > i6)
            {
              n -= this.b;
              i1 = Math.max(j, n);
              m = i + (this.c + k);
              this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i3), new AdaptiveLayout.Size(this, n, k));
              i4 = getPaddingLeft() + getPaddingRight();
              i2 = 0;
            }
          }
          j = i4 + (localView.getMeasuredWidth() + this.b);
          i = Math.max(i2, localView.getMeasuredHeight());
          i2 = j;
          i4 = m;
          m = i;
        }
        else
        {
          i2 = n + (localView.getMeasuredWidth() + this.b);
          m = Math.max(k, localView.getMeasuredHeight());
          i4 = i;
          i1 = j;
        }
      }
      i3 += 1;
      n = i2;
      j = i1;
      i = i4;
    }
    if (n != 0)
    {
      m = n - this.b;
      j = Math.max(j, m);
      i += k;
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i3), new AdaptiveLayout.Size(this, m, k));
      k = j;
    }
    else
    {
      k = j;
    }
    this.e = k;
    this.f = i;
    if (i8 != -2147483648)
    {
      j = i6;
      if (i8 != 1073741824) {
        j = k;
      }
    }
    else
    {
      j = Math.min(k + getPaddingLeft() + getPaddingTop(), i6);
    }
    if (i7 != -2147483648)
    {
      k = i5;
      if (i7 != 1073741824) {
        k = i;
      }
    }
    else
    {
      k = Math.min(i + getPaddingTop() + getPaddingBottom(), i5);
    }
    i = Math.max(j, getSuggestedMinimumWidth());
    j = Math.max(k, getSuggestedMinimumHeight());
    setMeasuredDimension(resolveSize(i, paramInt1), resolveSize(j, paramInt2));
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object[] arrayOfObject = this.jdField_a_of_type_JavaUtilMap.keySet().toArray();
    Arrays.sort(arrayOfObject);
    int i = getChildCount();
    int n = getPaddingTop();
    int i6 = arrayOfObject.length;
    int i7 = arrayOfObject.length;
    int m = 0;
    int i2 = 0;
    for (;;)
    {
      Object localObject1 = this;
      if (m >= i7) {
        break;
      }
      Object localObject2 = arrayOfObject[m];
      int j = ((Integer)localObject2).intValue();
      int i1 = j;
      if (j > i) {
        i1 = i;
      }
      localObject2 = (AdaptiveLayout.Size)((AdaptiveLayout)localObject1).jdField_a_of_type_JavaUtilMap.get(localObject2);
      int i3 = ((AdaptiveLayout)localObject1).b;
      int i4 = ((AdaptiveLayout)localObject1).c;
      j = ((AdaptiveLayout)localObject1).d & 0x7;
      if (j != 1)
      {
        if (j != 5)
        {
          if (j != 7)
          {
            j = i3;
          }
          else
          {
            j = i1 - i2;
            j = (paramInt3 - paramInt1 - (((AdaptiveLayout.Size)localObject2).jdField_a_of_type_Int - ((AdaptiveLayout)localObject1).b * (j - 1))) / j;
          }
          k = getPaddingLeft();
          i3 = j;
          j = k;
        }
        else
        {
          j = getPaddingLeft() + paramInt3 - paramInt1 - ((AdaptiveLayout.Size)localObject2).jdField_a_of_type_Int;
        }
      }
      else {
        j = getPaddingLeft() + (paramInt3 - paramInt1 - ((AdaptiveLayout.Size)localObject2).jdField_a_of_type_Int) / 2;
      }
      int k = ((AdaptiveLayout)localObject1).d & 0x70;
      if (k != 16)
      {
        if (k != 80)
        {
          if (k != 112) {
            k = i4;
          } else {
            k = (paramInt4 - paramInt2 - (((AdaptiveLayout)localObject1).f - ((AdaptiveLayout)localObject1).c * (i6 - 1))) / i6;
          }
          i5 = getPaddingTop();
          i4 = k;
          k = i5;
        }
        else
        {
          k = getPaddingTop() + paramInt4 - paramInt2 - ((AdaptiveLayout)localObject1).f;
        }
      }
      else {
        k = getPaddingTop() + (paramInt4 - paramInt2 - ((AdaptiveLayout)localObject1).f) / 2;
      }
      int i5 = j;
      while (i2 < i1)
      {
        localObject1 = getChildAt(i2);
        if (((View)localObject1).getVisibility() != 8)
        {
          int i8 = (((AdaptiveLayout.Size)localObject2).b - ((View)localObject1).getMeasuredHeight()) / 2 + (k + n);
          ((View)localObject1).layout(i5, i8, ((View)localObject1).getMeasuredWidth() + i5, i8 + ((View)localObject1).getMeasuredHeight());
          i5 += ((View)localObject1).getMeasuredWidth() + i3;
        }
        i2 += 1;
      }
      k = n;
      if (j != i5) {
        k = n + (((AdaptiveLayout.Size)localObject2).b + i4);
      }
      m += 1;
      n = k;
    }
  }
  
  private void b(int paramInt1, int paramInt2) {}
  
  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      b(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    a(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int == 1)
    {
      b(paramInt1, paramInt2);
      return;
    }
    a(paramInt1, paramInt2);
  }
  
  public void setGap(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public void setGravity(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setOrientation(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AdaptiveLayout
 * JD-Core Version:    0.7.0.1
 */