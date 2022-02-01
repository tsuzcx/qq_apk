package com.tencent.mobileqq.datareportviewer;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

class DataReportSettingFragment$4$1
  implements Runnable
{
  DataReportSettingFragment$4$1(DataReportSettingFragment.4 param4, ArrayList paramArrayList) {}
  
  public void run()
  {
    DataReportViewerFloatViewHelper.a().a(this.a);
    this.b.b.e.notifyDataSetChanged();
    QQToast.makeText(this.b.b.getBaseActivity(), HardCodeUtil.a(2131900918), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment.4.1
 * JD-Core Version:    0.7.0.1
 */