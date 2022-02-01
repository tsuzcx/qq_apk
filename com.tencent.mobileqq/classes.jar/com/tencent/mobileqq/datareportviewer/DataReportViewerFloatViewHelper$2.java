package com.tencent.mobileqq.datareportviewer;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.util.DisplayUtil;

class DataReportViewerFloatViewHelper$2
  extends DataReportViewer
{
  DataReportViewerFloatViewHelper$2(DataReportViewerFloatViewHelper paramDataReportViewerFloatViewHelper, Context paramContext1, Context paramContext2)
  {
    super(paramContext1);
  }
  
  public void d()
  {
    int j = DisplayUtil.a(this.o, 50.0F);
    int i;
    if (Build.VERSION.SDK_INT >= 26) {
      i = 2038;
    } else {
      i = 2003;
    }
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(j, -2, i, 776, -2);
    localLayoutParams.gravity = 51;
    localLayoutParams.x = 0;
    localLayoutParams.y = DisplayUtil.a(this.o, 72.0F);
    DataReportViewerFloatViewHelper.b(this.p).updateViewLayout(DataReportViewerFloatViewHelper.a(this.p), localLayoutParams);
  }
  
  public void e()
  {
    int i;
    if (Build.VERSION.SDK_INT >= 26) {
      i = 2038;
    } else {
      i = 2003;
    }
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -2, i, 776, -2);
    localLayoutParams.gravity = 51;
    localLayoutParams.x = 0;
    localLayoutParams.y = DisplayUtil.a(this.o, 72.0F);
    DataReportViewerFloatViewHelper.b(this.p).updateViewLayout(DataReportViewerFloatViewHelper.a(this.p), localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportViewerFloatViewHelper.2
 * JD-Core Version:    0.7.0.1
 */