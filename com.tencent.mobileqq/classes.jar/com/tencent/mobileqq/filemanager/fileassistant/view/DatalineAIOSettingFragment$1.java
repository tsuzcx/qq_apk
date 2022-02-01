package com.tencent.mobileqq.filemanager.fileassistant.view;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DatalineAIOSettingFragment$1
  implements CompoundButton.OnCheckedChangeListener
{
  DatalineAIOSettingFragment$1(DatalineAIOSettingFragment paramDatalineAIOSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    DatalineAIOSettingFragment.a(this.a, paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.view.DatalineAIOSettingFragment.1
 * JD-Core Version:    0.7.0.1
 */