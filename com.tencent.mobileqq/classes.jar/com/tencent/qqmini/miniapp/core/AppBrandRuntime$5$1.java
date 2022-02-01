package com.tencent.qqmini.miniapp.core;

import android.graphics.Bitmap;
import com.tencent.qqmini.sdk.launcher.core.utils.ICaptureImageCallback;

class AppBrandRuntime$5$1
  implements Runnable
{
  AppBrandRuntime$5$1(AppBrandRuntime.5 param5, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentQqminiMiniappCoreAppBrandRuntime$5.val$callback != null) {
      this.jdField_a_of_type_ComTencentQqminiMiniappCoreAppBrandRuntime$5.val$callback.onResult(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.AppBrandRuntime.5.1
 * JD-Core Version:    0.7.0.1
 */