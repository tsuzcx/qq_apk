package com.tencent.viola.ui.component;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

class VSwitch$1
  implements CompoundButton.OnCheckedChangeListener
{
  VSwitch$1(VSwitch paramVSwitch) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.this$0.switchFireEvent("change", true);
      return;
    }
    this.this$0.switchFireEvent("change", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.viola.ui.component.VSwitch.1
 * JD-Core Version:    0.7.0.1
 */