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
    int n = getChildCount();
    if (n == 0) {
      return;
    }
    paramInt4 = 0;
    paramInt3 = 0;
    paramInt1 = 0;
    paramInt2 = 0;
    Object localObject2;
    int j;
    int k;
    while (paramInt4 < n)
    {
      localObject1 = getChildAt(paramInt4);
      localObject2 = (ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams();
      int i2 = ((View)localObject1).getMeasuredWidth();
      int i1 = ((View)localObject1).getMeasuredHeight();
      if (i2 + paramInt1 + ((ViewGroup.MarginLayoutParams)localObject2).leftMargin + ((ViewGroup.MarginLayoutParams)localObject2).rightMargin <= m - getPaddingLeft() - getPaddingRight())
      {
        int i3 = this.jdField_b_of_type_Int;
        j = paramInt1;
        k = paramInt2;
        i = paramInt3;
        if (paramInt2 > i3)
        {
          j = paramInt1;
          k = paramInt2;
          i = paramInt3;
          if (i3 == -1) {}
        }
      }
      else
      {
        this.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(paramInt3));
        this.c.add(Integer.valueOf(paramInt1));
        this.jdField_a_of_type_JavaUtilList.add(this.e);
        i = ((ViewGroup.MarginLayoutParams)localObject2).topMargin + i1 + ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin;
        this.e = new ArrayList();
        j = 0;
        k = 0;
      }
      paramInt2 = k + 1;
      paramInt1 = j + (i2 + ((ViewGroup.MarginLayoutParams)localObject2).leftMargin + ((ViewGroup.MarginLayoutParams)localObject2).rightMargin);
      paramInt3 = Math.max(i, i1 + ((ViewGroup.MarginLayoutParams)localObject2).topMargin + ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin);
      this.e.add(localObject1);
      paramInt4 += 1;
    }
    this.jdField_b_of_type_JavaUtilList.add(Integer.valueOf(paramInt3));
    this.c.add(Integer.valueOf(paramInt1));
    this.jdField_a_of_type_JavaUtilList.add(this.e);
    paramInt4 = getPaddingLeft();
    paramInt3 = getPaddingTop();
    int i = this.jdField_a_of_type_JavaUtilList.size();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("一共有 ");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append(" 行");
    QLog.d("FlowLayout", 2, ((StringBuilder)localObject1).toString());
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < i)
    {
      localObject1 = (ViewGroup.MarginLayoutParams)getChildAt(paramInt2).getLayoutParams();
      localObject2 = getChildAt(((List)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).size() + paramInt2 - 1);
      paramInt2 += ((List)this.jdField_a_of_type_JavaUtilList.get(paramInt1)).size();
      localObject2 = (ViewGroup.MarginLayoutParams)((View)localObject2).getLayoutParams();
      this.d.add(Integer.valueOf((getMeasuredWidth() - ((Integer)this.c.get(paramInt1)).intValue() + ((ViewGroup.MarginLayoutParams)localObject1).leftMargin + ((ViewGroup.MarginLayoutParams)localObject2).rightMargin) / 2));
      paramInt1 += 1;
    }
    paramInt1 = paramInt4;
    paramInt4 = 0;
    while (paramInt4 < i)
    {
      this.e = ((List)this.jdField_a_of_type_JavaUtilList.get(paramInt4));
      j = ((Integer)this.jdField_b_of_type_JavaUtilList.get(paramInt4)).intValue();
      k = this.jdField_a_of_type_Int;
      if (k == 2) {}
      for (paramInt2 = ((Integer)this.d.get(paramInt4)).intValue() * 2;; paramInt2 = ((Integer)this.d.get(paramInt4)).intValue())
      {
        paramInt2 = paramInt1 + paramInt2;
        break;
        paramInt2 = paramInt1;
        if (k != 1) {
          break;
        }
      }
      paramInt1 = 0;
      while (paramInt1 < this.e.size())
      {
        localObject1 = (View)this.e.get(paramInt1);
        if (((View)localObject1).getVisibility() != 8)
        {
          localObject2 = (ViewGroup.MarginLayoutParams)((View)localObject1).getLayoutParams();
          k = ((ViewGroup.MarginLayoutParams)localObject2).leftMargin + paramInt2;
          m = ((ViewGroup.MarginLayoutParams)localObject2).topMargin + paramInt3;
          ((View)localObject1).layout(k, m, ((View)localObject1).getMeasuredWidth() + k, ((View)localObject1).getMeasuredHeight() + m);
          paramInt2 += ((View)localObject1).getMeasuredWidth() + ((ViewGroup.MarginLayoutParams)localObject2).leftMargin + ((ViewGroup.MarginLayoutParams)localObject2).rightMargin;
        }
        paramInt1 += 1;
      }
      paramInt1 = getPaddingLeft();
      paramInt3 += j;
      paramInt4 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getSize(paramInt1);
    int i8 = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt2);
    int i7 = View.MeasureSpec.getMode(paramInt2);
    int i9 = getChildCount();
    int i4 = 0;
    int i2 = 0;
    int m = 0;
    int i1 = 0;
    int k = 0;
    int n = 0;
    while (i4 < i9)
    {
      View localView = getChildAt(i4);
      measureChild(localView, paramInt1, paramInt2);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      int i3 = localView.getMeasuredWidth() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
      int i6 = localView.getMeasuredHeight() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin;
      int i5 = i2 + i3;
      if (i5 <= j - getPaddingLeft() - getPaddingRight())
      {
        int i10 = this.jdField_b_of_type_Int;
        if ((i1 < i10) || (i10 == -1))
        {
          n = Math.max(n, i6);
          i3 = i1 + 1;
          i1 = i5;
          i2 = m;
          i5 = i3;
          m = k;
          break label230;
        }
      }
      i2 = Math.max(m, i2);
      m = k + n;
      n = i6;
      k = i3;
      i5 = i1;
      i1 = k;
      label230:
      i3 = i2;
      k = m;
      if (i4 == i9 - 1)
      {
        i3 = Math.max(i1, i2);
        k = m + n;
      }
      i4 += 1;
      i2 = i1;
      m = i3;
      i1 = i5;
    }
    if (i8 == 1073741824)
    {
      paramInt1 = j;
    }
    else
    {
      paramInt1 = getPaddingLeft();
      paramInt1 = getPaddingRight() + (m + paramInt1);
    }
    if (i7 != 1073741824) {
      i = k + getPaddingTop() + getPaddingBottom();
    }
    setMeasuredDimension(paramInt1, i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.SearchFileFlowLayout
 * JD-Core Version:    0.7.0.1
 */