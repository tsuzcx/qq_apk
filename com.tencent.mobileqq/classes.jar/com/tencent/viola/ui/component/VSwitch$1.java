package com.tencent.viola.ui.component;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class VSwitch$1
  implements CompoundButton.OnCheckedChangeListener
{
  VSwitch$1(VSwitch paramVSwitch) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.this$0.switchFireEvent("change", true);
    } else {
      this.this$0.switchFireEvent("change", false);
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.component.VSwitch.1
 * JD-Core Version:    0.7.0.1
 */