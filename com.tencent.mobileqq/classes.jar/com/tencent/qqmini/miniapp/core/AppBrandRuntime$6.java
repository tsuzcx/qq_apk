package com.tencent.qqmini.miniapp.core;

import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.launcher.core.utils.ICaptureImageCallback;

class AppBrandRuntime$6
  implements Runnable
{
  AppBrandRuntime$6(AppBrandRuntime paramAppBrandRuntime, ICaptureImageCallback paramICaptureImageCallback, Bitmap paramBitmap) {}
  
  public void run()
  {
    ICaptureImageCallback localICaptureImageCallback = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreUtilsICaptureImageCallback;
    if (localICaptureImageCallback != null) {
      localICaptureImageCallback.onResult(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.AppBrandRuntime.6
 * JD-Core Version:    0.7.0.1
 */