package com.tencent.mobileqq.qcircle.tempapi.api.impl;

import com.tencent.mobileqq.qcircle.tempapi.api.IQCirclrModuleDownloadListener;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;

class QZoneServiceImpl$1
  implements ModuleDownloadListener
{
  QZoneServiceImpl$1(QZoneServiceImpl paramQZoneServiceImpl, IQCirclrModuleDownloadListener paramIQCirclrModuleDownloadListener) {}
  
  public void onDownloadCanceled(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqQcircleTempapiApiIQCirclrModuleDownloadListener.onDownloadCanceled(paramString);
  }
  
  public void onDownloadFailed(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqQcircleTempapiApiIQCirclrModuleDownloadListener.onDownloadFailed(paramString);
  }
  
  public void onDownloadProgress(String paramString, float paramFloat)
  {
    this.jdField_a_of_type_ComTencentMobileqqQcircleTempapiApiIQCirclrModuleDownloadListener.onDownloadProgress(paramString, paramFloat);
  }
  
  public void onDownloadSucceed(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqQcircleTempapiApiIQCirclrModuleDownloadListener.onDownloadSucceed(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.tempapi.api.impl.QZoneServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */