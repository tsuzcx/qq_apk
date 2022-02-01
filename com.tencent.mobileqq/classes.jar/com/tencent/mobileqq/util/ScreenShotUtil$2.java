package com.tencent.mobileqq.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.sdk.WebView;

final class ScreenShotUtil$2
  implements Runnable
{
  ScreenShotUtil$2(WebView paramWebView, Canvas paramCanvas, ScreenShotUtil.ScreenLongShotCallback paramScreenLongShotCallback, Bitmap paramBitmap) {}
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_ComTencentSmttSdkWebView.getX5WebViewExtension().snapshotWholePage(this.jdField_a_of_type_AndroidGraphicsCanvas, false, false);
      localObject = this.jdField_a_of_type_ComTencentMobileqqUtilScreenShotUtil$ScreenLongShotCallback.a(this.jdField_a_of_type_AndroidGraphicsBitmap);
      ThreadManagerV2.getUIHandlerV2().post(new ScreenShotUtil.2.1(this, localObject));
      return;
    }
    catch (Exception localException)
    {
      Object localObject;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("snapshotWholePage error : ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("ScreenShotUtil", 1, localStringBuilder.toString());
      ThreadManagerV2.getUIHandlerV2().post(new ScreenShotUtil.2.2(this, localException));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label49:
      break label49;
    }
    QLog.e("ScreenShotUtil", 1, "snapshotWholePage out of memory ");
    localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localObject != null) {
      ((Bitmap)localObject).recycle();
    }
    ThreadManagerV2.getUIHandlerV2().post(new ScreenShotUtil.2.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.ScreenShotUtil.2
 * JD-Core Version:    0.7.0.1
 */