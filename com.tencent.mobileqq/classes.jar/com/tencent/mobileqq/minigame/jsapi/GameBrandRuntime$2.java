package com.tencent.mobileqq.minigame.jsapi;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime.ShareScreenshotCallback;
import com.tencent.mobileqq.triton.sdk.callback.ScreenShotCallback;

class GameBrandRuntime$2
  implements ScreenShotCallback
{
  GameBrandRuntime$2(GameBrandRuntime paramGameBrandRuntime, BaseAppBrandRuntime.ShareScreenshotCallback paramShareScreenshotCallback) {}
  
  public void onScreenShotCallback(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled()))
    {
      if (this.val$screenshotCallback != null) {
        this.val$screenshotCallback.onGetShareScreenshot(null);
      }
      this.this$0.isGettingScreenShot = false;
      return;
    }
    ThreadManagerV2.executeOnFileThread(new GameBrandRuntime.2.1(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.GameBrandRuntime.2
 * JD-Core Version:    0.7.0.1
 */