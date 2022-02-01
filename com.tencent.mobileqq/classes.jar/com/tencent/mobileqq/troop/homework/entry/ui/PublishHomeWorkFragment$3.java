package com.tencent.mobileqq.troop.homework.entry.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PublishHomeWorkFragment$3
  implements CompoundButton.OnCheckedChangeListener
{
  PublishHomeWorkFragment$3(PublishHomeWorkFragment paramPublishHomeWorkFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.a.a(paramCompoundButton, paramBoolean);
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment.3
 * JD-Core Version:    0.7.0.1
 */