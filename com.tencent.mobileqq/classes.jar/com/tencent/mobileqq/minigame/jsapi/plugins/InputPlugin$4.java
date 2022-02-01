package com.tencent.mobileqq.minigame.jsapi.plugins;

import com.tencent.mobileqq.minigame.jsapi.manager.KeyboardHandler;
import com.tencent.mobileqq.minigame.ui.GameActivity;

class InputPlugin$4
  implements Runnable
{
  InputPlugin$4(InputPlugin paramInputPlugin, GameActivity paramGameActivity, String paramString, int paramInt) {}
  
  public void run()
  {
    KeyboardHandler.get().updateKeyboard(this.val$activity.getKeyboard(), this.this$0, this.val$jsonParams, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.plugins.InputPlugin.4
 * JD-Core Version:    0.7.0.1
 */