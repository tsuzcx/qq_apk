package com.tencent.mobileqq.datareportviewer;

import amvi;
import amvk;
import android.widget.TextView;
import java.util.ArrayList;

class DataReportViewer$3
  implements Runnable
{
  DataReportViewer$3(DataReportViewer paramDataReportViewer) {}
  
  public void run()
  {
    if (!this.this$0.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      this.this$0.jdField_a_of_type_JavaUtilArrayList.remove(0);
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.this$0.jdField_a_of_type_JavaUtilArrayList.size()));
      this.this$0.jdField_a_of_type_Amvi.notifyDataSetChanged();
      this.this$0.a();
    }
    while (!amvk.a) {
      return;
    }
    amvk.a().b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportViewer.3
 * JD-Core Version:    0.7.0.1
 */