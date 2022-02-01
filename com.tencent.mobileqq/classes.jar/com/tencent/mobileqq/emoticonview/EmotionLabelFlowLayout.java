package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.widget.TraceUtils;

public class EmotionLabelFlowLayout
  extends RelativeLayout
{
  public static final int MAX_LINE_COUNT = 2;
  protected BaseAdapter mAdapter;
  private DataSetObserver mDataSetObserver;
  
  public EmotionLabelFlowLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmotionLabelFlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EmotionLabelFlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public RelativeLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return (RelativeLayout.LayoutParams)new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    SLog.b("attach", "attach");
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    SLog.b("detach", "detach");
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TraceUtils.traceBegin("FlowLayout.onLayout");
    int k = getWidth();
    int m = getChildCount();
    paramInt4 = 0;
    paramInt2 = 0;
    paramInt3 = 0;
    int i = 0;
    while (paramInt4 < m)
    {
      View localView = getChildAt(paramInt4);
      if (localView.getVisibility() == 8)
      {
        paramInt1 = paramInt3;
      }
      else
      {
        int n = localView.getMeasuredWidth();
        int i1 = localView.getMeasuredHeight();
        ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        paramInt1 = paramInt3;
        int j = paramInt2;
        if (localMarginLayoutParams.leftMargin + paramInt2 + n + localMarginLayoutParams.rightMargin > k)
        {
          paramInt1 = paramInt3 + i;
          j = 0;
        }
        i = localMarginLayoutParams.topMargin + i1 + localMarginLayoutParams.bottomMargin;
        paramInt2 = localMarginLayoutParams.leftMargin + j;
        paramInt3 = localMarginLayoutParams.topMargin + paramInt1;
        localView.layout(paramInt2, paramInt3, paramInt2 + n, i1 + paramInt3);
        paramInt2 = j + (localMarginLayoutParams.leftMargin + n + localMarginLayoutParams.rightMargin);
      }
      paramInt4 += 1;
      paramInt3 = paramInt1;
    }
    TraceUtils.traceEnd();
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
  
  protected void reloadData()
  {
    int j = getChildCount();
    int i = 0;
    while ((i < this.mAdapter.getCount()) && (i < j))
    {
      View localView = getChildAt(i);
      this.mAdapter.getView(i, localView, this);
      i += 1;
    }
    if (j > this.mAdapter.getCount()) {
      removeViews(i, j - this.mAdapter.getCount());
    }
    if (j < this.mAdapter.getCount()) {
      while (i < this.mAdapter.getCount())
      {
        addView(this.mAdapter.getView(i, null, this), new ViewGroup.MarginLayoutParams(-2, -2));
        i += 1;
      }
    }
  }
  
  public void setAdapter(BaseAdapter paramBaseAdapter)
  {
    BaseAdapter localBaseAdapter = this.mAdapter;
    if (localBaseAdapter != null)
    {
      DataSetObserver localDataSetObserver = this.mDataSetObserver;
      if (localDataSetObserver != null) {
        localBaseAdapter.unregisterDataSetObserver(localDataSetObserver);
      }
    }
    removeAllViews();
    this.mAdapter = paramBaseAdapter;
    if (this.mAdapter != null)
    {
      this.mDataSetObserver = new EmotionLabelFlowLayout.AdapterDataSetObserver(this);
      this.mAdapter.registerDataSetObserver(this.mDataSetObserver);
      this.mAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmotionLabelFlowLayout
 * JD-Core Version:    0.7.0.1
 */