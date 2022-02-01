package com.tencent.mobileqq.flutter.qqface;

import android.graphics.Bitmap;
import com.qflutter.qqface.data.QQFaceNativeData;
import com.qflutter.qqface.data.QQFaceParam;
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
    paramBitmap = new QQFaceParam();
    paramBitmap.account = paramDecodeRequest.a;
    paramBitmap.faceType = paramDecodeRequest.b;
    paramBitmap.faceShape = paramDecodeRequest.c;
    QQFaceLoader.instance().onUpdate(paramBitmap, localQQFaceNativeData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.qqface.QFlutterFace.1
 * JD-Core Version:    0.7.0.1
 */