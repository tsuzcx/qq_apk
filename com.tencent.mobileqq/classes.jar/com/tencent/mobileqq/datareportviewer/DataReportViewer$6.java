package com.tencent.mobileqq.datareportviewer;

import android.widget.TextView;
import java.util.ArrayList;

class DataReportViewer$6
  implements Runnable
{
  DataReportViewer$6(DataReportViewer paramDataReportViewer) {}
  
  public void run()
  {
    if (!this.this$0.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      this.this$0.jdField_a_of_type_JavaUtilArrayList.remove(0);
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.this$0.jdField_a_of_type_JavaUtilArrayList.size()));
      this.this$0.jdField_a_of_type_ComTencentMobileqqDatareportviewerDataReportViewer$DataAdapter.notifyDataSetChanged();
      this.this$0.a();
      return;
    }
    if (DataReportViewerFloatViewHelper.a) {
      DataReportViewerFloatViewHelper.a().b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportViewer.6
 * JD-Core Version:    0.7.0.1
 */