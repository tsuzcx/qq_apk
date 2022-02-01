package com.tencent.mobileqq.datareportviewer;

import android.widget.TextView;
import java.util.ArrayList;

class DataReportViewer$6
  implements Runnable
{
  DataReportViewer$6(DataReportViewer paramDataReportViewer) {}
  
  public void run()
  {
    if (!this.this$0.h.isEmpty())
    {
      this.this$0.h.remove(0);
      this.this$0.g.setText(String.valueOf(this.this$0.h.size()));
      this.this$0.i.notifyDataSetChanged();
      this.this$0.a();
      return;
    }
    if (DataReportViewerFloatViewHelper.a) {
      DataReportViewerFloatViewHelper.a().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportViewer.6
 * JD-Core Version:    0.7.0.1
 */