package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class SearchFileFlowLayout
  extends ViewGroup
{
  private int jdField_a_of_type_Int;
  private List<List<View>> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int;
  private List<Integer> jdField_b_of_type_JavaUtilList = new ArrayList();
  private List<Integer> c = new ArrayList();
  private List<Integer> d = new ArrayList();
  private List<View> e = new ArrayList();
  
  public SearchFileFlowLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SearchFileFlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SearchFileFlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SearchFileFlowLayout);
    this.jdField_a_of_type_Int = paramContext.getInt(0, 0);
    this.jdField_b_of_type_Int = paramContext.getInteger(1, -1);
    if (this.jdField_b_of_type_Int <= 0) {
      this.jdField_b_of_type_Int = -1;
    }
    paramContext.recycle();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.c.clear();
    this.e.clear();
    this.d.clear();
    int m = getWidth();
    paramInt3 = 0;
    paramInt2 = 0;
    int n = getChildCount();
    if (n == 0) {
      return;
    }
    paramInt1 = 0;
    paramInt4 = 0;
    Object localObject1;
    Object localObject2;
    int k;
    int j;
    while (paramInt4 < n)
    {
      localObject1 = getChildAt(paramInt4);
      localObject2 = (ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams();
      int i2 = ((View)localObject1).getMeasuredWidth();
      int i1 = ((View)localObject1).getMeasuredHeight();
      if (i2 + paramInt3 + ((ViewGroup.MarginLayoutParams)localObject2).leftMargin + ((ViewGroup.MarginLayoutParams)localObject2).rightMargin <= m - getPaddingLeft() - getPaddingRight())
      {
        k = paramInt1;
        i = paramInt2;
        j = paramInt3;
        if (paramInt1 > this.jdField_b_of_type_Int)
        {
          k = paramInt1;
          i = paramInt2;
          j = paramInt3;
          if (this.jdField_b_of_type_Int == -1) {}
        }
      }
      else
      {
        this.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(paramInt2));
        this.c.add(Integer.valueOf(paramInt3));
        this.jdField_a_of_type_JavaUtilList.add(this.e);
        j = 0;
        paramInt1 = ((ViewGroup.MarginLayoutParams)localObject2).topMargin;
        i = ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin + (paramInt1 + i1);
        this.e = new ArrayList();
        k = 0;
      }
      paramInt1 = k + 1;
      paramInt3 = j + (i2 + ((ViewGroup.MarginLayoutParams)localObject2).leftMargin + ((ViewGroup.MarginLayoutParams)localObject2).rightMargin);
      paramInt2 = ((ViewGroup.MarginLayoutParams)localObject2).topMargin;
      paramInt2 = Math.max(i, ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin + (paramInt2 + i1));
      this.e.add(localObject1);
      paramInt4 += 1;
    }
    this.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(paramInt2));
    this.c.add(Integer.valueOf(paramInt3));
    this.jdField_a_of_type_JavaUtilList.add(this.e);
    paramInt3 = getPaddingLeft();
    paramInt4 = getPaddingTop();
    int i = this.jdField_a_of_type_JavaUtilList.size();
    QLog.d("FlowLayout", 2, "一共有 " + i + " 行");
    paramInt2 = 0;
    paramInt1 = 0;
    while (paramInt2 < i)
    {
      localObject1 = (ViewGroup.MarginLayoutParams)getChildAt(paramInt1).getLayoutParams();
      localObject2 = getChildAt(((List)this.jdField_a_of_type_JavaUtilList.get(paramInt2)).size() + paramInt1 - 1);
      j = ((List)this.jdField_a_of_type_JavaUtilList.get(paramInt2)).size();
      localObject2 = (ViewGroup.MarginLayoutParams)((View)localObject2).getLayoutParams();
      List localList = this.d;
      k = getMeasuredWidth();
      m = ((Integer)this.c.get(paramInt2)).intValue();
      localList.add(Integer.valueOf((((ViewGroup.MarginLayoutParams)localObject1).leftMargin + (k - m) + ((ViewGroup.MarginLayoutParams)localObject2).rightMargin) / 2));
      paramInt2 += 1;
      paramInt1 += j;
    }
    paramInt2 = paramInt4;
    paramInt1 = paramInt3;
    paramInt3 = 0;
    label584:
    if (paramInt3 < i)
    {
      this.e = ((List)this.jdField_a_of_type_JavaUtilList.get(paramInt3));
      j = ((Integer)this.jdField_b_of_type_JavaUtilList.get(paramInt3)).intValue();
      if (this.jdField_a_of_type_Int == 2) {
        paramInt1 = ((Integer)this.d.get(paramInt3)).intValue() * 2 + paramInt1;
      }
    }
    label661:
    label836:
    for (;;)
    {
      paramInt4 = 0;
      if (paramInt4 < this.e.size())
      {
        localObject1 = (View)this.e.get(paramInt4);
        if (((View)localObject1).getVisibility() == 8) {}
        for (;;)
        {
          paramInt4 += 1;
          break label661;
          if (this.jdField_a_of_type_Int != 1) {
            break label836;
          }
          paramInt1 = ((Integer)this.d.get(paramInt3)).intValue() + paramInt1;
          break;
          localObject2 = (ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams();
          k = ((ViewGroup.MarginLayoutParams)localObject2).leftMargin + paramInt1;
          m = ((ViewGroup.MarginLayoutParams)localObject2).topMargin + paramInt2;
          ((View)localObject1).layout(k, m, ((View)localObject1).getMeasuredWidth() + k, ((View)localObject1).getMeasuredHeight() + m);
          paramInt1 += ((View)localObject1).getMeasuredWidth() + ((ViewGroup.MarginLayoutParams)localObject2).leftMargin + ((ViewGroup.MarginLayoutParams)localObject2).rightMargin;
        }
      }
      paramInt1 = getPaddingLeft();
      paramInt3 += 1;
      paramInt2 += j;
      break label584;
      break;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i5 = View.MeasureSpec.getSize(paramInt1);
    int i8 = View.MeasureSpec.getMode(paramInt1);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    int i7 = View.MeasureSpec.getMode(paramInt2);
    int k = 0;
    int i9 = getChildCount();
    int j = 0;
    int i3 = 0;
    int m = 0;
    int n = 0;
    int i = 0;
    if (i3 < i9)
    {
      View localView = getChildAt(i3);
      measureChild(localView, paramInt1, paramInt2);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      int i1 = localView.getMeasuredWidth() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
      int i2 = localView.getMeasuredHeight();
      int i6 = localMarginLayoutParams.topMargin;
      i2 = localMarginLayoutParams.bottomMargin + (i2 + i6);
      if ((n + i1 > i5 - getPaddingLeft() - getPaddingRight()) || ((j >= this.jdField_b_of_type_Int) && (this.jdField_b_of_type_Int != -1)))
      {
        i6 = Math.max(k, n);
        k = i1;
        n = j;
        i1 = i6;
        m = i + m;
        j = k;
        k = i2;
        i = n;
        n = i1;
      }
      for (;;)
      {
        i1 = m;
        i2 = n;
        if (i3 == i9 - 1)
        {
          i2 = Math.max(j, n);
          i1 = m + k;
        }
        i3 += 1;
        m = k;
        n = j;
        k = i2;
        j = i;
        i = i1;
        break;
        m = Math.max(m, i2);
        i2 = j + 1;
        i1 = n + i1;
        j = m;
        m = i;
        n = k;
        i = i2;
        k = j;
        j = i1;
      }
    }
    if (i8 == 1073741824)
    {
      paramInt1 = i5;
      if (i7 != 1073741824) {
        break label355;
      }
    }
    label355:
    for (paramInt2 = i4;; paramInt2 = getPaddingTop() + i + getPaddingBottom())
    {
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      paramInt1 = getPaddingLeft() + k + getPaddingRight();
      break;
    }
  }
  
  public void setAlignMode(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 2)) {
      this.jdField_a_of_type_Int = 0;
    }
    this.jdField_a_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setMaxNumInLine(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setMaxNumInLineAndAlignMode(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 > 2)) {
      this.jdField_a_of_type_Int = 0;
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SearchFileFlowLayout
 * JD-Core Version:    0.7.0.1
 */