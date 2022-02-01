package com.tencent.mobileqq.jsp;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.ScreenShotUtil.ScreenshotCallback;

class UiApiPlugin$8$1
  implements ScreenShotUtil.ScreenshotCallback
{
  UiApiPlugin$8$1(UiApiPlugin.8 param8) {}
  
  public void a(Bitmap paramBitmap)
  {
    ThreadManager.post(new UiApiPlugin.8.1.1(this, paramBitmap), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.8.1
 * JD-Core Version:    0.7.0.1
 */