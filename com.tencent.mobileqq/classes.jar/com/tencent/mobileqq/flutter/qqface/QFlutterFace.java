package com.tencent.mobileqq.flutter.qqface;

import android.graphics.Bitmap;
import com.qflutter.qqface.data.QQFaceNativeData;
import com.qflutter.qqface.data.QQFaceParam;
import com.qflutter.qqface.loader.QQFaceInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.flutter.download.QFlutterInstaller;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

public class QFlutterFace
  implements QQFaceInterface
{
  private QFlutterFaceLoader.FaceObserver jdField_a_of_type_ComTencentMobileqqFlutterQqfaceQFlutterFaceLoader$FaceObserver = new QFlutterFace.1(this);
  private QFlutterFaceLoader jdField_a_of_type_ComTencentMobileqqFlutterQqfaceQFlutterFaceLoader = new QFlutterFaceLoader(BaseApplicationImpl.getContext());
  
  public QFlutterFace()
  {
    this.jdField_a_of_type_ComTencentMobileqqFlutterQqfaceQFlutterFaceLoader.a(this.jdField_a_of_type_ComTencentMobileqqFlutterQqfaceQFlutterFaceLoader$FaceObserver);
  }
  
  public void clearCache()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutterFace", 2, "clearCache");
    }
    this.jdField_a_of_type_ComTencentMobileqqFlutterQqfaceQFlutterFaceLoader.a();
  }
  
  public QQFaceNativeData getFaceData(QQFaceParam paramQQFaceParam)
  {
    paramQQFaceParam = new DecodeRequest(paramQQFaceParam.faceType, paramQQFaceParam.account, paramQQFaceParam.faceShape);
    paramQQFaceParam = this.jdField_a_of_type_ComTencentMobileqqFlutterQqfaceQFlutterFaceLoader.a(paramQQFaceParam);
    QQFaceNativeData localQQFaceNativeData = new QQFaceNativeData();
    localQQFaceNativeData.setBitmap((Bitmap)paramQQFaceParam.first);
    localQQFaceNativeData.isDefaultFace = ((Boolean)paramQQFaceParam.second).booleanValue();
    return localQQFaceNativeData;
  }
  
  public String getLibPath()
  {
    String str = QFlutterInstaller.a("libqflutter-resource-loader.so");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getLibPath: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", isExist: ");
      localStringBuilder.append(FileUtil.b(str));
      QLog.d("QFlutterFace", 2, localStringBuilder.toString());
    }
    return str;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqFlutterQqfaceQFlutterFaceLoader.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.qqface.QFlutterFace
 * JD-Core Version:    0.7.0.1
 */