package com.tencent.mobileqq.location.api.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.location.window.GlobalFloatDialog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FloatMapServiceImpl$3
  implements View.OnClickListener
{
  FloatMapServiceImpl$3(FloatMapServiceImpl paramFloatMapServiceImpl, GlobalFloatDialog paramGlobalFloatDialog) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowGlobalFloatDialog.b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.api.impl.FloatMapServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */