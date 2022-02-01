package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bgnt;
import blfz;

public class PresetWordFlowLayout
  extends RelativeLayout
{
  public int a;
  private DataSetObserver a;
  protected BaseAdapter a;
  public int b;
  public int c;
  public int d;
  
  public PresetWordFlowLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public PresetWordFlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PresetWordFlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    int j = getChildCount();
    int i = 0;
    View localView;
    while ((i < this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount()) && (i < j))
    {
      localView = getChildAt(i);
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.getView(i, localView, this);
      i += 1;
    }
    if (j > this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount()) {
      removeViews(i, j - this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount());
    }
    if (j < this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount()) {
      while (i < this.jdField_a_of_type_AndroidWidgetBaseAdapter.getCount())
      {
        localView = this.jdField_a_of_type_AndroidWidgetBaseAdapter.getView(i, null, this);
        if (localView != null) {
          addView(localView, new ViewGroup.MarginLayoutParams(-2, -2));
        }
        i += 1;
      }
    }
  }
  
  public RelativeLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return (RelativeLayout.LayoutParams)new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    blfz.a("PresetWordFlowLayout.onLayout");
    int j = getWidth();
    int k = getChildCount();
    paramInt2 = 0;
    paramInt3 = 0;
    paramInt4 = 0;
    if (paramInt4 < k)
    {
      View localView = getChildAt(paramInt4);
      if (localView.getVisibility() == 8) {
        paramInt1 = paramInt2;
      }
      for (;;)
      {
        paramInt4 += 1;
        paramInt2 = paramInt1;
        break;
        int m = localView.getMeasuredWidth();
        int n = localView.getMeasuredHeight();
        paramInt1 = paramInt2;
        int i = paramInt3;
        if (this.jdField_a_of_type_Int + paramInt3 + m + this.b > j)
        {
          paramInt1 = paramInt2 + (this.c + n + this.d);
          i = 0;
        }
        paramInt2 = this.jdField_a_of_type_Int + i;
        paramInt3 = this.c + paramInt1;
        localView.layout(paramInt2, paramInt3, paramInt2 + m, n + paramInt3);
        paramInt3 = i + (this.jdField_a_of_type_Int + m + this.b);
      }
    }
    blfz.a();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    blfz.a("PresetWordFlowLayout.onMeasure");
    int i6 = View.MeasureSpec.getSize(paramInt1);
    int i5 = View.MeasureSpec.getSize(paramInt2);
    int i8 = View.MeasureSpec.getMode(paramInt1);
    int i7 = View.MeasureSpec.getMode(paramInt2);
    int i9 = getChildCount();
    int i2 = 0;
    int k = 0;
    int m = 0;
    int i = 0;
    int j = 0;
    while (i2 < i9)
    {
      View localView = getChildAt(i2);
      int i3;
      int i4;
      if (localView.getVisibility() == 8)
      {
        i3 = m;
        i4 = k;
        i2 += 1;
        k = i4;
        m = i3;
      }
      else
      {
        measureChild(localView, paramInt1, paramInt2);
        int n = localView.getMeasuredWidth();
        int i1 = localView.getMeasuredHeight();
        n = n + this.jdField_a_of_type_Int + this.b;
        i1 = i1 + this.c + this.d;
        if (m + n > i6)
        {
          j = Math.max(m, n);
          i += i1;
          k = i1;
          m = n;
          i1 = j;
          n = i;
        }
        for (;;)
        {
          i4 = k;
          i3 = m;
          i = n;
          j = i1;
          if (i2 != i9 - 1) {
            break;
          }
          j = Math.max(m, i1);
          i = n + k;
          i4 = k;
          i3 = m;
          break;
          m += n;
          k = Math.max(k, i1);
          n = i;
          i1 = j;
        }
      }
    }
    if (i8 == 1073741824) {
      j = i6;
    }
    if (i7 == 1073741824) {
      i = i5;
    }
    setMeasuredDimension(j, i);
    blfz.a();
  }
  
  public void setAdapter(BaseAdapter paramBaseAdapter)
  {
    if ((this.jdField_a_of_type_AndroidWidgetBaseAdapter != null) && (this.jdField_a_of_type_AndroidDatabaseDataSetObserver != null)) {
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.unregisterDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    }
    removeAllViews();
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    if (this.jdField_a_of_type_AndroidWidgetBaseAdapter != null)
    {
      this.jdField_a_of_type_AndroidDatabaseDataSetObserver = new bgnt(this);
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.PresetWordFlowLayout
 * JD-Core Version:    0.7.0.1
 */