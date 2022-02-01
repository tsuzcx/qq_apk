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
    switch (this.jdField_a_of_type_AndroidWidgetRadioGroup.getCheckedRadioButtonId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
      return;
      SimpleUIProtocolUtil.a(0);
      continue;
      SimpleUIProtocolUtil.a(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.SimpleDebugFragment.1
 * JD-Core Version:    0.7.0.1
 */