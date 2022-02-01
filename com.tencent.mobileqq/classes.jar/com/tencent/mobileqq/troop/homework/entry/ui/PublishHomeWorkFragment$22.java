package com.tencent.mobileqq.troop.homework.entry.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublishHomeWorkFragment$22
  implements CompoundButton.OnCheckedChangeListener
{
  PublishHomeWorkFragment$22(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("口算开关状态改变 ");
      if (!paramBoolean) {
        break label80;
      }
    }
    label80:
    for (String str = "on";; str = "off")
    {
      QLog.d("PublishHomeWorkFragment", 2, str);
      this.a.e = paramBoolean;
      if (this.a.e) {
        this.a.a.setChecked(true);
      }
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.22
 * JD-Core Version:    0.7.0.1
 */