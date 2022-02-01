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
import com.tencent.widget.TraceUtils;

public class PresetWordFlowLayout
  extends RelativeLayout
{
  public int a;
  private DataSetObserver a;
  protected BaseAdapter a;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  
  public PresetWordFlowLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
  }
  
  public PresetWordFlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
  }
  
  public PresetWordFlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 0;
  }
  
  protected void a()
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
    TraceUtils.traceBegin("PresetWordFlowLayout.onLayout");
    int j = getWidth();
    int k = getChildCount();
    paramInt4 = 0;
    paramInt2 = 0;
    for (paramInt3 = 0; paramInt4 < k; paramInt3 = paramInt1)
    {
      View localView = getChildAt(paramInt4);
      if (localView.getVisibility() == 8)
      {
        paramInt1 = paramInt3;
      }
      else
      {
        int m = localView.getMeasuredWidth();
        int n = localView.getMeasuredHeight();
        paramInt1 = paramInt3;
        int i = paramInt2;
        if (this.jdField_a_of_type_Int + paramInt2 + m + this.b > j)
        {
          paramInt1 = paramInt3 + (this.c + n + this.d);
          i = 0;
        }
        paramInt2 = this.jdField_a_of_type_Int + i;
        paramInt3 = this.c + paramInt1;
        localView.layout(paramInt2, paramInt3, paramInt2 + m, n + paramInt3);
        paramInt2 = i + (this.jdField_a_of_type_Int + m + this.b);
      }
      paramInt4 += 1;
    }
    TraceUtils.traceEnd();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    TraceUtils.traceBegin("PresetWordFlowLayout.onMeasure");
    int i4 = View.MeasureSpec.getSize(paramInt1);
    int i3 = View.MeasureSpec.getSize(paramInt2);
    int i7 = View.MeasureSpec.getMode(paramInt1);
    int i6 = View.MeasureSpec.getMode(paramInt2);
    int i8 = getChildCount();
    int i2 = 0;
    int j = 0;
    int m = 0;
    int k = 0;
    int i1;
    for (int i = 0; i2 < i8; i = i1)
    {
      View localView = getChildAt(i2);
      if (localView.getVisibility() == 8)
      {
        i1 = i;
      }
      else
      {
        measureChild(localView, paramInt1, paramInt2);
        i1 = localView.getMeasuredWidth();
        int n = localView.getMeasuredHeight();
        i1 = i1 + this.jdField_a_of_type_Int + this.b;
        int i5 = n + this.c + this.d;
        n = m + i1;
        if (n > i4)
        {
          j = Math.max(m, i1);
          n = i + i5;
          m = i5;
          k = i1;
        }
        else
        {
          m = Math.max(k, i5);
          k = n;
          n = i;
        }
        i = j;
        i1 = n;
        if (i2 == i8 - 1)
        {
          i = Math.max(k, j);
          i1 = n + m;
        }
        j = k;
        k = m;
        m = j;
        j = i;
      }
      i2 += 1;
    }
    if (i7 == 1073741824) {
      paramInt1 = i4;
    } else {
      paramInt1 = j;
    }
    if (i6 == 1073741824) {
      i = i3;
    }
    setMeasuredDimension(paramInt1, i);
    TraceUtils.traceEnd();
  }
  
  public void setAdapter(BaseAdapter paramBaseAdapter)
  {
    BaseAdapter localBaseAdapter = this.jdField_a_of_type_AndroidWidgetBaseAdapter;
    if (localBaseAdapter != null)
    {
      DataSetObserver localDataSetObserver = this.jdField_a_of_type_AndroidDatabaseDataSetObserver;
      if (localDataSetObserver != null) {
        localBaseAdapter.unregisterDataSetObserver(localDataSetObserver);
      }
    }
    removeAllViews();
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = paramBaseAdapter;
    if (this.jdField_a_of_type_AndroidWidgetBaseAdapter != null)
    {
      this.jdField_a_of_type_AndroidDatabaseDataSetObserver = new PresetWordFlowLayout.AdapterDataSetObserver(this);
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      this.jdField_a_of_type_AndroidWidgetBaseAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.PresetWordFlowLayout
 * JD-Core Version:    0.7.0.1
 */