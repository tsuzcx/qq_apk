package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.keyboard;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CustomKeyboardModule$3
  implements View.OnClickListener
{
  CustomKeyboardModule$3(CustomKeyboardModule paramCustomKeyboardModule) {}
  
  public void onClick(View paramView)
  {
    CustomKeyboardModule.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.keyboard.CustomKeyboardModule.3
 * JD-Core Version:    0.7.0.1
 */