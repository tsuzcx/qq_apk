package com.tencent.mobileqq.datareportviewer;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class DataReportSettingFragment$ItemListener
  implements View.OnLongClickListener, CompoundButton.OnCheckedChangeListener
{
  public BaseReportDataConfig a;
  
  protected DataReportSettingFragment$ItemListener(DataReportSettingFragment paramDataReportSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    BaseReportDataConfig localBaseReportDataConfig = this.a;
    if (localBaseReportDataConfig != null)
    {
      localBaseReportDataConfig.b = paramBoolean;
      DataReportViewerFloatViewHelper.a().h();
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public boolean onLongClick(View paramView)
  {
    DialogUtil.a(this.b.getBaseActivity(), 230, null, HardCodeUtil.a(2131900921), new DataReportSettingFragment.ItemListener.1(this), new DataReportSettingFragment.ItemListener.2(this)).show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.datareportviewer.DataReportSettingFragment.ItemListener
 * JD-Core Version:    0.7.0.1
 */