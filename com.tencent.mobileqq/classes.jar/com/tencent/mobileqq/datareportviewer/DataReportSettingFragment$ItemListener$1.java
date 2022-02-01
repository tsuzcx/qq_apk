package com.tencent.mobileqq.datareportviewer;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class DataReportSettingFragment$ItemListener$1
  implements DialogInterface.OnClickListener
{
  DataReportSettingFragment$ItemListener$1(DataReportSettingFragment.ItemListener paramItemListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DataReportViewerFloatViewHelper.a().b(this.a.a);
    this.a.b.e.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment.ItemListener.1
 * JD-Core Version:    0.7.0.1
 */