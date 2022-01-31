package com.tencent.mobileqq.minigame.ui;

import com.tencent.mobileqq.minigame.jsapi.webaudio.WebAudioManager;
import com.tencent.mobileqq.triton.sdk.ITTEngine;

class GameActivity$16
  implements Runnable
{
  GameActivity$16(GameActivity paramGameActivity, ITTEngine paramITTEngine) {}
  
  public void run()
  {
    WebAudioManager.getInstance().closeAudioContext(this.val$ttEngine);
    this.val$ttEngine.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.16
 * JD-Core Version:    0.7.0.1
 */