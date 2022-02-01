package com.tencent.mobileqq.qqexpand.utils.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.flutter.qqface.DecodeRequest;
import com.tencent.mobileqq.flutter.qqface.QFlutterFaceLoader.FaceObserver;
import com.tencent.mobileqq.qqexpand.utils.IQFlutterFaceLoaderApi.ApiFaceObserver;

public class QFlutterFaceLoaderApiImpl$InnerFaceObserver
  implements QFlutterFaceLoader.FaceObserver
{
  private final IQFlutterFaceLoaderApi.ApiFaceObserver b;
  
  public QFlutterFaceLoaderApiImpl$InnerFaceObserver(QFlutterFaceLoaderApiImpl paramQFlutterFaceLoaderApiImpl, IQFlutterFaceLoaderApi.ApiFaceObserver paramApiFaceObserver)
  {
    this.b = paramApiFaceObserver;
  }
  
  public void onFaceUpdate(DecodeRequest paramDecodeRequest, Bitmap paramBitmap, String paramString)
  {
    IQFlutterFaceLoaderApi.ApiFaceObserver localApiFaceObserver = this.b;
    if (localApiFaceObserver != null) {
      localApiFaceObserver.onFaceUpdate(this.a.convert2Api(paramDecodeRequest), paramBitmap, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.impl.QFlutterFaceLoaderApiImpl.InnerFaceObserver
 * JD-Core Version:    0.7.0.1
 */