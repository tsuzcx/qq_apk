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
    } else {
      DataReportViewerFloatViewHelper.a().d();
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */