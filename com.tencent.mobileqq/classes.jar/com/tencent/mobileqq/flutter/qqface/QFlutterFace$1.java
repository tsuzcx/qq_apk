package com.tencent.mobileqq.flutter.qqface;

import android.graphics.Bitmap;
import com.qflutter.qqface.data.QQFaceNativeData;
import com.qflutter.qqface.loader.QQFaceLoader;

class QFlutterFace$1
  implements QFlutterFaceLoader.FaceObserver
{
  QFlutterFace$1(QFlutterFace paramQFlutterFace) {}
  
  public void onFaceUpdate(DecodeRequest paramDecodeRequest, Bitmap paramBitmap, String paramString)
  {
    QQFaceNativeData localQQFaceNativeData = new QQFaceNativeData();
    localQQFaceNativeData.setBitmap(paramBitmap);
    localQQFaceNativeData.setPath(paramString);
    QQFaceLoader.instance().onUpdate(paramDecodeRequest.d, localQQFaceNativeData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.qqface.QFlutterFace.1
 * JD-Core Version:    0.7.0.1
 */