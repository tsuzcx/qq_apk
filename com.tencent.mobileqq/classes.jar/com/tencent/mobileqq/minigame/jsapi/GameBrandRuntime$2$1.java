package com.tencent.mobileqq.minigame.jsapi;

import android.graphics.Bitmap;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime.ShareScreenshotCallback;

class GameBrandRuntime$2$1
  implements Runnable
{
  GameBrandRuntime$2$1(GameBrandRuntime.2 param2, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.this$1.val$screenshotCallback != null) {
      this.this$1.val$screenshotCallback.onGetShareScreenshot(GameBrandRuntime.access$000(this.this$1.this$0, this.val$bitmap));
    }
    this.this$1.this$0.isGettingScreenShot = false;
    GameBrandRuntime.access$100(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.jsapi.GameBrandRuntime.2.1
 * JD-Core Version:    0.7.0.1
 */