package com.tencent.qqmini.minigame;

import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot.Callback;

class GameRuntime$8$1
  implements Runnable
{
  GameRuntime$8$1(GameRuntime.8 param8, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.this$1.val$screenshotCallback != null) {
      this.this$1.val$screenshotCallback.onGetScreenshot(ImageUtil.cutAndSaveShareScreenshot(this.this$1.this$0, GameRuntime.access$1000(this.this$1.this$0), this.val$finalBitmap));
    }
    GameRuntime.access$900(this.this$1.this$0).isGettingScreenShot = false;
    this.this$1.this$0.dismissShareScreenshotProgress();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameRuntime.8.1
 * JD-Core Version:    0.7.0.1
 */