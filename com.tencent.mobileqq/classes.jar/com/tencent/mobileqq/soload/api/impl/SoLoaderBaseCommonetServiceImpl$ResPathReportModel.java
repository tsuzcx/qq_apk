package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;

class SoLoaderBaseCommonetServiceImpl$ResPathReportModel
{
  public boolean a;
  public long b;
  public boolean c;
  private IPreloadService.PathResult d;
  
  public SoLoaderBaseCommonetServiceImpl$ResPathReportModel(IPreloadService.PathResult paramPathResult)
  {
    IPreloadService.PathResult localPathResult = this.d;
    boolean bool;
    if ((localPathResult != null) && (SoLoaderBaseCommonetServiceImpl.retryUnzip(localPathResult))) {
      bool = true;
    } else {
      bool = false;
    }
    this.a = bool;
    this.b = -1L;
    this.c = false;
    this.d = paramPathResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.SoLoaderBaseCommonetServiceImpl.ResPathReportModel
 * JD-Core Version:    0.7.0.1
 */