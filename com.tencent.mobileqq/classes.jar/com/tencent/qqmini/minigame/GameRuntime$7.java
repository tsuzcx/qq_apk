package com.tencent.qqmini.minigame;

import android.graphics.Bitmap;
import com.tencent.mobileqq.triton.sdk.callback.ScreenShotCallback;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot.Callback;

class GameRuntime$7
  implements ScreenShotCallback
{
  GameRuntime$7(GameRuntime paramGameRuntime, GetScreenshot.Callback paramCallback) {}
  
  public void onScreenShotCallback(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      if (this.val$screenshotCallback != null) {
        this.val$screenshotCallback.onGetScreenshot(null);
      }
      GameRuntime.access$900(this.this$0).isGettingScreenShot = false;
      return;
    }
    ThreadManager.executeOnDiskIOThreadPool(new GameRuntime.7.1(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameRuntime.7
 * JD-Core Version:    0.7.0.1
 */