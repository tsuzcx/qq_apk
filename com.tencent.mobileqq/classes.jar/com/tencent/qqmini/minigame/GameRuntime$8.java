package com.tencent.qqmini.minigame;

import android.graphics.Bitmap;
import com.tencent.mobileqq.triton.engine.ScreenShotCallback;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot.Callback;
import org.jetbrains.annotations.NotNull;

class GameRuntime$8
  implements ScreenShotCallback
{
  GameRuntime$8(GameRuntime paramGameRuntime, GetScreenshot.Callback paramCallback) {}
  
  public void onGetScreenShot(@NotNull Object paramObject)
  {
    if ((paramObject instanceof Bitmap)) {
      paramObject = (Bitmap)paramObject;
    } else {
      paramObject = null;
    }
    if ((paramObject != null) && (!paramObject.isRecycled()))
    {
      ThreadManager.executeOnDiskIOThreadPool(new GameRuntime.8.1(this, paramObject));
      return;
    }
    paramObject = this.val$screenshotCallback;
    if (paramObject != null) {
      paramObject.onGetScreenshot(null);
    }
    GameRuntime.access$900(this.this$0).isGettingScreenShot = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameRuntime.8
 * JD-Core Version:    0.7.0.1
 */