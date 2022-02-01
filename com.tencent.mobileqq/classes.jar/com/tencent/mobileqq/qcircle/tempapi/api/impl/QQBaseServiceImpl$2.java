package com.tencent.mobileqq.qcircle.tempapi.api.impl;

import com.tencent.mobileqq.flutter.download.QFlutterInstaller.InstallCallback;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.FlutterInstallCallBack;

class QQBaseServiceImpl$2
  implements QFlutterInstaller.InstallCallback
{
  QQBaseServiceImpl$2(QQBaseServiceImpl paramQQBaseServiceImpl, FlutterInstallCallBack paramFlutterInstallCallBack) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqQcircleTempapiInterfacesFlutterInstallCallBack.onProgress(paramInt);
  }
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.jdField_a_of_type_ComTencentMobileqqQcircleTempapiInterfacesFlutterInstallCallBack.onResult(paramBoolean1, paramString, paramBoolean2, paramBoolean3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.tempapi.api.impl.QQBaseServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */