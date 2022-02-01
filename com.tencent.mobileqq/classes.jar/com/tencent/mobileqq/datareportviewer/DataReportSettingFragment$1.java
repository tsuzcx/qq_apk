package com.tencent.mobileqq.datareportviewer;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DataReportSettingFragment$1
  implements CompoundButton.OnCheckedChangeListener
{
  DataReportSettingFragment$1(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      DataReportViewerFloatViewHelper.a().c();
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      DataReportViewerFloatViewHelper.a().d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */