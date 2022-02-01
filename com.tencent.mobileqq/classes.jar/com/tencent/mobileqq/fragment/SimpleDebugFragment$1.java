package com.tencent.mobileqq.fragment;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.simpleui.SimpleUIProtocolUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SimpleDebugFragment$1
  implements RadioGroup.OnCheckedChangeListener
{
  SimpleDebugFragment$1(SimpleDebugFragment paramSimpleDebugFragment, RadioGroup paramRadioGroup) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    int i = this.a.getCheckedRadioButtonId();
    if (i != 2131434356)
    {
      if (i == 2131450128) {
        SimpleUIProtocolUtil.a(0);
      }
    }
    else {
      SimpleUIProtocolUtil.a(1);
    }
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.SimpleDebugFragment.1
 * JD-Core Version:    0.7.0.1
 */