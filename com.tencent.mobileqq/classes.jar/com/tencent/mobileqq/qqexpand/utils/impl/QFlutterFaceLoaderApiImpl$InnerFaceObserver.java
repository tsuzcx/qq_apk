package com.tencent.mobileqq.qqexpand.utils.impl;

import android.graphics.Bitmap;
import com.tencent.mobileqq.flutter.qqface.DecodeRequest;
import com.tencent.mobileqq.flutter.qqface.QFlutterFaceLoader.FaceObserver;
import com.tencent.mobileqq.qqexpand.utils.IQFlutterFaceLoaderApi.ApiFaceObserver;

public class QFlutterFaceLoaderApiImpl$InnerFaceObserver
  implements QFlutterFaceLoader.FaceObserver
{
  private final IQFlutterFaceLoaderApi.ApiFaceObserver jdField_a_of_type_ComTencentMobileqqQqexpandUtilsIQFlutterFaceLoaderApi$ApiFaceObserver;
  
  public QFlutterFaceLoaderApiImpl$InnerFaceObserver(QFlutterFaceLoaderApiImpl paramQFlutterFaceLoaderApiImpl, IQFlutterFaceLoaderApi.ApiFaceObserver paramApiFaceObserver)
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandUtilsIQFlutterFaceLoaderApi$ApiFaceObserver = paramApiFaceObserver;
  }
  
  public void onFaceUpdate(DecodeRequest paramDecodeRequest, Bitmap paramBitmap, String paramString)
  {
    IQFlutterFaceLoaderApi.ApiFaceObserver localApiFaceObserver = this.jdField_a_of_type_ComTencentMobileqqQqexpandUtilsIQFlutterFaceLoaderApi$ApiFaceObserver;
    if (localApiFaceObserver != null) {
      localApiFaceObserver.onFaceUpdate(this.jdField_a_of_type_ComTencentMobileqqQqexpandUtilsImplQFlutterFaceLoaderApiImpl.convert2Api(paramDecodeRequest), paramBitmap, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.impl.QFlutterFaceLoaderApiImpl.InnerFaceObserver
 * JD-Core Version:    0.7.0.1
 */