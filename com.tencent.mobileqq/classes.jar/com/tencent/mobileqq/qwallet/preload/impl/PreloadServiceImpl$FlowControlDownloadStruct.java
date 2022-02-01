package com.tencent.mobileqq.qwallet.preload.impl;

import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.FlowControlObj;
import com.tencent.mobileqq.vip.DownloadListener;

public class PreloadServiceImpl$FlowControlDownloadStruct
  extends IPreloadService.FlowControlObj
{
  PreloadModuleImpl jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadModuleImpl;
  PreloadResourceImpl jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener;
  
  public PreloadServiceImpl$FlowControlDownloadStruct(PreloadResourceImpl paramPreloadResourceImpl, PreloadModuleImpl paramPreloadModuleImpl, DownloadListener paramDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl = paramPreloadResourceImpl;
    this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadModuleImpl = paramPreloadModuleImpl;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener = paramDownloadListener;
  }
  
  public void a(IPreloadService paramIPreloadService)
  {
    PreloadResourceImpl localPreloadResourceImpl = this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadResourceImpl;
    if (localPreloadResourceImpl != null) {
      localPreloadResourceImpl.handleFlowConfig(paramIPreloadService, this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadImplPreloadModuleImpl, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl.FlowControlDownloadStruct
 * JD-Core Version:    0.7.0.1
 */