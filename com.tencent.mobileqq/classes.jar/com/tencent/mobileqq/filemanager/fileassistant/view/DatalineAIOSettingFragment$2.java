package com.tencent.mobileqq.filemanager.fileassistant.view;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DatalineAIOSettingFragment$2
  implements CompoundButton.OnCheckedChangeListener
{
  DatalineAIOSettingFragment$2(DatalineAIOSettingFragment paramDatalineAIOSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    DatalineAIOSettingFragment.b(this.a, paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.view.DatalineAIOSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */