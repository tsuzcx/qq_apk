package com.tencent.mobileqq.flutter.qqface;

import android.graphics.Bitmap;
import com.qflutter.qqface.data.QQFaceNativeData;
import com.qflutter.qqface.data.QQFaceParam;
import com.qflutter.qqface.loader.QQFaceInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.flutter.download.QFlutterInstaller;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

public class QFlutterFace
  implements QQFaceInterface
{
  private QFlutterFaceLoader.FaceObserver a = new QFlutterFace.1(this);
  
  public QFlutterFace()
  {
    QFlutterFaceLoader.a().a(this.a);
  }
  
  public void clearCache()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFlutterFace", 2, "clearCache");
    }
    QFlutterFaceLoader.a().b();
  }
  
  public QQFaceNativeData getFaceData(QQFaceParam paramQQFaceParam)
  {
    paramQQFaceParam = new DecodeRequest(paramQQFaceParam.faceType, paramQQFaceParam.account, paramQQFaceParam.faceShape);
    paramQQFaceParam = QFlutterFaceLoader.a().a(paramQQFaceParam);
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
      localStringBuilder.append(FileUtil.d(str));
      QLog.d("QFlutterFace", 2, localStringBuilder.toString());
    }
    return str;
  }
  
  public void onDestroy()
  {
    QFlutterFaceLoader.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.qqface.QFlutterFace
 * JD-Core Version:    0.7.0.1
 */