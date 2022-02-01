package com.tencent.mobileqq.qwallet.preload.impl;

import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.FlowControlObj;
import com.tencent.mobileqq.vip.DownloadListener;

public class PreloadServiceImpl$FlowControlDownloadStruct
  extends IPreloadService.FlowControlObj
{
  PreloadResourceImpl a;
  PreloadModuleImpl b;
  DownloadListener c;
  
  public PreloadServiceImpl$FlowControlDownloadStruct(PreloadResourceImpl paramPreloadResourceImpl, PreloadModuleImpl paramPreloadModuleImpl, DownloadListener paramDownloadListener)
  {
    this.a = paramPreloadResourceImpl;
    this.b = paramPreloadModuleImpl;
    this.c = paramDownloadListener;
  }
  
  public void a(IPreloadService paramIPreloadService)
  {
    PreloadResourceImpl localPreloadResourceImpl = this.a;
    if (localPreloadResourceImpl != null) {
      localPreloadResourceImpl.handleFlowConfig(paramIPreloadService, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl.FlowControlDownloadStruct
 * JD-Core Version:    0.7.0.1
 */