package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter;
import com.tencent.mobileqq.filemanager.excitingtransfer.ExcitingTransferAdapter;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import java.util.List;
import mqq.app.AppRuntime;

public class ExcitingTransferAdapterImpl
  implements IExcitingTransferAdapter
{
  private ExcitingTransferAdapter adapter = new ExcitingTransferAdapter();
  
  public List<ExcitingTransferHostInfo> getBigDataHostList(boolean paramBoolean)
  {
    return this.adapter.a(paramBoolean);
  }
  
  public ExcitingTransferDownloadConfig getC2CDownloadConfig()
  {
    return this.adapter.f();
  }
  
  public long getC2CDownloadLimitedSize()
  {
    return this.adapter.e();
  }
  
  public ExcitingTransferUploadChnConfigInfo getC2CUploadChnConfig()
  {
    return this.adapter.c();
  }
  
  public long getC2CUploadLimitedSize()
  {
    return this.adapter.b();
  }
  
  public boolean getConfigFromServer()
  {
    return this.adapter.m();
  }
  
  public ExcitingTransferDownloadConfig getGroupDownloadConfig()
  {
    return this.adapter.l();
  }
  
  public long getGroupDownloadLimitedSize()
  {
    return this.adapter.k();
  }
  
  public ExcitingTransferUploadChnConfigInfo getGroupUploadChnConfig()
  {
    return this.adapter.i();
  }
  
  public long getGroupUploadLimitedSize()
  {
    return this.adapter.h();
  }
  
  public long getSelfUin()
  {
    return this.adapter.o();
  }
  
  public boolean isEnableC2CDownload()
  {
    return this.adapter.d();
  }
  
  public boolean isEnableC2CUpload()
  {
    return this.adapter.a();
  }
  
  public boolean isEnableGroupDownload()
  {
    return this.adapter.j();
  }
  
  public boolean isEnableGroupUpload()
  {
    return this.adapter.g();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.adapter.a(paramAppRuntime);
  }
  
  public void onDestroy()
  {
    this.adapter.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.ExcitingTransferAdapterImpl
 * JD-Core Version:    0.7.0.1
 */