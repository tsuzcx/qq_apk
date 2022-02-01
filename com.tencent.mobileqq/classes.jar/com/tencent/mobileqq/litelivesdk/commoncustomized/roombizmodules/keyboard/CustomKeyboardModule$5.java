package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.keyboard;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.litepages.room.webmodule.event.SendChatInputEvent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CustomKeyboardModule$5
  implements View.OnClickListener
{
  CustomKeyboardModule$5(CustomKeyboardModule paramCustomKeyboardModule) {}
  
  public void onClick(View paramView)
  {
    if (CustomKeyboardModule.a(this.a) != null)
    {
      SendChatInputEvent localSendChatInputEvent = new SendChatInputEvent();
      localSendChatInputEvent.mType = 1;
      localSendChatInputEvent.mContent = CustomKeyboardModule.a(this.a).getText().toString();
      this.a.getEvent().post(localSendChatInputEvent);
      CustomKeyboardModule.b(this.a);
      CustomKeyboardModule.a(this.a).setText(null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.keyboard.CustomKeyboardModule.5
 * JD-Core Version:    0.7.0.1
 */