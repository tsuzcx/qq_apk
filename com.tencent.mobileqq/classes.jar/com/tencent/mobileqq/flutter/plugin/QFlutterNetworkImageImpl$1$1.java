package com.tencent.mobileqq.flutter.plugin;

import android.graphics.Bitmap;
import com.qflutter.qflutter_network_image.LoadBitmapCallback;

class QFlutterNetworkImageImpl$1$1
  implements Runnable
{
  QFlutterNetworkImageImpl$1$1(QFlutterNetworkImageImpl.1 param1, Bitmap paramBitmap) {}
  
  public void run()
  {
    this.b.a.onLoaded(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.plugin.QFlutterNetworkImageImpl.1.1
 * JD-Core Version:    0.7.0.1
 */