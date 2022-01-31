package com.tencent.mobileqq.minigame.jsapi.plugins;

import com.tencent.mobileqq.minigame.jsapi.manager.KeyboardHandler;
import com.tencent.mobileqq.minigame.ui.GameActivity;

class InputPlugin$3
  implements Runnable
{
  InputPlugin$3(InputPlugin paramInputPlugin, GameActivity paramGameActivity, int paramInt) {}
  
  public void run()
  {
    KeyboardHandler.get().hideKeyboard(this.val$activity.getKeyboard(), this.this$0, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.InputPlugin.3
 * JD-Core Version:    0.7.0.1
 */