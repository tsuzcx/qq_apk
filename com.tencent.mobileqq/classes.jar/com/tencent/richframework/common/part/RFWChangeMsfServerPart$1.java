package com.tencent.richframework.common.part;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RFWChangeMsfServerPart$1
  implements RadioGroup.OnCheckedChangeListener
{
  RFWChangeMsfServerPart$1(RFWChangeMsfServerPart paramRFWChangeMsfServerPart) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    RFWChangeMsfServerPart localRFWChangeMsfServerPart = this.a;
    RFWChangeMsfServerPart.a(localRFWChangeMsfServerPart, RFWChangeMsfServerPart.a(localRFWChangeMsfServerPart, paramInt));
    if (RFWChangeMsfServerPart.a(this.a) != null) {
      RFWChangeMsfServerPart.b(this.a);
    }
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richframework.common.part.RFWChangeMsfServerPart.1
 * JD-Core Version:    0.7.0.1
 */