package com.tencent.mobileqq.datareportviewer;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.ListView;
import bdaq;

public class DataReportListView
  extends ListView
{
  public DataReportListView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if (getMeasuredHeight() > bdaq.a(getContext(), 100.0F)) {
      setMeasuredDimension(paramInt1, bdaq.a(getContext(), 100.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportListView
 * JD-Core Version:    0.7.0.1
 */