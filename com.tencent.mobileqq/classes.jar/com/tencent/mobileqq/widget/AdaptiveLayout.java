package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import bemy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AdaptiveLayout
  extends ViewGroup
{
  private int jdField_a_of_type_Int;
  private Map<Integer, bemy> jdField_a_of_type_JavaUtilMap = new HashMap();
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
    int m = this.mPaddingLeft;
    int n = this.mPaddingRight;
    int i9 = getChildCount();
    this.jdField_a_of_type_JavaUtilMap.clear();
    measureChildren(paramInt1, paramInt2);
    int i = 0;
    int j = 0;
    int k = 0;
    m += n;
    int i4 = 0;
    if (i4 < i9)
    {
      View localView = getChildAt(i4);
      n = i;
      i1 = j;
      int i2 = k;
      int i3 = m;
      if (localView.getVisibility() != 8)
      {
        if (i8 == 0) {
          break label291;
        }
        n = i;
        i1 = j;
        i2 = k;
        i3 = m;
        if (i4 > 0)
        {
          n = i;
          i1 = j;
          i2 = k;
          i3 = m;
          if (localView.getMeasuredWidth() + m > i6)
          {
            m -= this.b;
            i1 = Math.max(j, m);
            n = i + (this.c + k);
            this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i4), new bemy(this, m, k));
            i = this.mPaddingLeft;
            i3 = this.mPaddingRight + i;
            i2 = 0;
          }
        }
        i3 += localView.getMeasuredWidth() + this.b;
        i2 = Math.max(i2, localView.getMeasuredHeight());
      }
      for (;;)
      {
        i4 += 1;
        i = n;
        j = i1;
        k = i2;
        m = i3;
        break;
        label291:
        i3 = m + (localView.getMeasuredWidth() + this.b);
        i2 = Math.max(k, localView.getMeasuredHeight());
        n = i;
        i1 = j;
      }
    }
    n = i;
    int i1 = j;
    if (m != 0)
    {
      m -= this.b;
      i1 = Math.max(j, m);
      n = i + k;
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i4), new bemy(this, m, k));
    }
    this.e = i1;
    this.f = n;
    switch (i8)
    {
    default: 
      switch (i7)
      {
      }
      break;
    }
    for (;;)
    {
      i = Math.max(i1, getSuggestedMinimumWidth());
      j = Math.max(n, getSuggestedMinimumHeight());
      setMeasuredDimension(resolveSize(i, paramInt1), resolveSize(j, paramInt2));
      return;
      i1 = i6;
      break;
      i1 = Math.min(i1 + this.mPaddingLeft + this.mPaddingTop, i6);
      break;
      n = i5;
      continue;
      n = Math.min(n + this.mPaddingTop + this.mPaddingBottom, i5);
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object[] arrayOfObject = this.jdField_a_of_type_JavaUtilMap.keySet().toArray();
    Arrays.sort(arrayOfObject);
    int i6 = getChildCount();
    int i2 = 0;
    int j = this.mPaddingTop;
    int i7 = arrayOfObject.length;
    int i8 = arrayOfObject.length;
    int n = 0;
    Object localObject;
    int i1;
    if (n < i8)
    {
      localObject = arrayOfObject[n];
      i1 = ((Integer)localObject).intValue();
      if (i1 <= i6) {
        break label505;
      }
      i1 = i6;
    }
    label162:
    label505:
    for (;;)
    {
      localObject = (bemy)this.jdField_a_of_type_JavaUtilMap.get(localObject);
      int k = this.b;
      int m = this.c;
      int i3;
      switch (this.d & 0x7)
      {
      default: 
        i = this.mPaddingLeft;
        i3 = k;
        switch (this.d & 0x70)
        {
        }
        break;
      }
      int i4;
      for (;;)
      {
        k = this.mPaddingTop;
        for (;;)
        {
          int i5;
          for (i4 = i; i2 < i1; i4 = i5)
          {
            View localView = getChildAt(i2);
            i5 = i4;
            if (localView.getVisibility() != 8)
            {
              i5 = (((bemy)localObject).b - localView.getMeasuredHeight()) / 2 + (k + j);
              localView.layout(i4, i5, localView.getMeasuredWidth() + i4, localView.getMeasuredHeight() + i5);
              i5 = i4 + (localView.getMeasuredWidth() + i3);
            }
            i2 += 1;
          }
          i = this.mPaddingLeft + paramInt3 - paramInt1 - ((bemy)localObject).jdField_a_of_type_Int;
          i3 = k;
          break label162;
          i = this.mPaddingLeft + (paramInt3 - paramInt1 - ((bemy)localObject).jdField_a_of_type_Int) / 2;
          i3 = k;
          break label162;
          i = i1 - i2;
          k = (paramInt3 - paramInt1 - (((bemy)localObject).jdField_a_of_type_Int - this.b * (i - 1))) / i;
          break;
          k = this.mPaddingTop + paramInt4 - paramInt2 - this.f;
          continue;
          k = this.mPaddingTop + (paramInt4 - paramInt2 - this.f) / 2;
        }
        m = (paramInt4 - paramInt2 - (this.f - this.c * (i7 - 1))) / i7;
      }
      if (i != i4) {}
      for (int i = ((bemy)localObject).b + m + j;; i = j)
      {
        n += 1;
        j = i;
        break;
        return;
      }
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