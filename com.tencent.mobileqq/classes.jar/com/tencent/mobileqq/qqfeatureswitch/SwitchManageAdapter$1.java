package com.tencent.mobileqq.qqfeatureswitch;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SwitchManageAdapter$1
  implements CompoundButton.OnCheckedChangeListener
{
  SwitchManageAdapter$1(SwitchManageAdapter paramSwitchManageAdapter, FeatureSwitch paramFeatureSwitch) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    QLog.d("SwitchManageAdapter", 1, "外发 版本修改状态不生效");
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqfeatureswitch.SwitchManageAdapter.1
 * JD-Core Version:    0.7.0.1
 */