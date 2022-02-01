package com.tencent.mobileqq.datareportviewer;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DataReportSettingFragment$3
  implements View.OnClickListener
{
  DataReportSettingFragment$3(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public void onClick(View paramView)
  {
    DialogUtil.a(this.a.getActivity(), 0, 2131559721, HardCodeUtil.a(2131702812), "", HardCodeUtil.a(2131702807), HardCodeUtil.a(2131702813), new DataReportSettingFragment.3.1(this), new DataReportSettingFragment.3.2(this)).show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment.3
 * JD-Core Version:    0.7.0.1
 */