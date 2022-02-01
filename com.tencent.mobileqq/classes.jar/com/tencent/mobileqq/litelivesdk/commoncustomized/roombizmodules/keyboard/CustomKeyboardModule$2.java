package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.keyboard;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.litelivesdk.utils.KeyboardUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CustomKeyboardModule$2
  implements View.OnClickListener
{
  CustomKeyboardModule$2(CustomKeyboardModule paramCustomKeyboardModule) {}
  
  public void onClick(View paramView)
  {
    CustomKeyboardModule.a(this.a).setVisibility(8);
    CustomKeyboardModule.b(this.a);
    if ((CustomKeyboardModule.a(this.a) instanceof Activity)) {
      KeyboardUtil.b((Activity)CustomKeyboardModule.b(this.a), CustomKeyboardModule.a(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.keyboard.CustomKeyboardModule.2
 * JD-Core Version:    0.7.0.1
 */