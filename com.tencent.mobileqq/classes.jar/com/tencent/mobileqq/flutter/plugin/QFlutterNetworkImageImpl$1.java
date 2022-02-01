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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[loadBitmap] state=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", bitmap=");
      localStringBuilder.append(localBitmap);
      QLog.d("QFlutterNetworkImageImpl", 2, localStringBuilder.toString());
    }
    if ((6 == paramInt) && (localBitmap != null) && (this.a != null))
    {
      QFlutterNetworkImageImpl.a(this.b).put(paramOption.getUrl(), localBitmap);
      ThreadManagerV2.getUIHandlerV2().post(new QFlutterNetworkImageImpl.1.1(this, localBitmap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.plugin.QFlutterNetworkImageImpl.1
 * JD-Core Version:    0.7.0.1
 */