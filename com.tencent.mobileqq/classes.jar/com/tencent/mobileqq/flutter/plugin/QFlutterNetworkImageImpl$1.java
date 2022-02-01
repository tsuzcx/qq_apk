package com.tencent.mobileqq.flutter.plugin;

import android.graphics.Bitmap;
import android.os.Handler;
import com.qflutter.qflutter_network_image.LoadBitmapCallback;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.interfaces.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class QFlutterNetworkImageImpl$1
  extends QCirclePicStateListener
{
  QFlutterNetworkImageImpl$1(QFlutterNetworkImageImpl paramQFlutterNetworkImageImpl, LoadBitmapCallback paramLoadBitmapCallback) {}
  
  public void onStateChang(int paramInt, Option paramOption)
  {
    Bitmap localBitmap = paramOption.getResultBitMap();
    if (QLog.isColorLevel()) {
      QLog.d("QFlutterNetworkImageImpl", 2, "[loadBitmap] state=" + paramInt + ", bitmap=" + localBitmap);
    }
    if ((6 == paramInt) && (localBitmap != null) && (this.jdField_a_of_type_ComQflutterQflutter_network_imageLoadBitmapCallback != null))
    {
      QFlutterNetworkImageImpl.a(this.jdField_a_of_type_ComTencentMobileqqFlutterPluginQFlutterNetworkImageImpl).put(paramOption.getUrl(), localBitmap);
      ThreadManagerV2.getUIHandlerV2().post(new QFlutterNetworkImageImpl.1.1(this, localBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.plugin.QFlutterNetworkImageImpl.1
 * JD-Core Version:    0.7.0.1
 */