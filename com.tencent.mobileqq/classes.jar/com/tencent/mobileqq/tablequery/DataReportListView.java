package com.tencent.mobileqq.tablequery;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.widget.ListView;

public class DataReportListView
  extends ListView
{
  private int jdField_a_of_type_Int;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  
  public DataReportListView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.jdField_a_of_type_Int = (this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getHeight() / 3);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    if (getMeasuredHeight() > this.jdField_a_of_type_Int) {
      setMeasuredDimension(paramInt1, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.DataReportListView
 * JD-Core Version:    0.7.0.1
 */