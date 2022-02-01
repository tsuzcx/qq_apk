package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.config.business.qfile.IExcitingC2CDownloadConfig;
import com.tencent.mobileqq.config.business.qfile.IExcitingC2CUploadConfig;
import com.tencent.mobileqq.config.business.qfile.IExcitingGroupDownloadConfig;
import com.tencent.mobileqq.config.business.qfile.IExcitingGroupUploadConfig;
import com.tencent.mobileqq.filemanager.api.IFileAssistantTipsConfig;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager;
import com.tencent.mobileqq.filemanager.data.DownloadFileConfig;
import mqq.app.AppRuntime;

public class QFileConfigManagerImpl
  implements IQFileConfigManager
{
  public boolean getC2CFileIPv6Switch()
  {
    return QFileConfigManager.a().e();
  }
  
  public boolean getDatalineFileIPv6Switch()
  {
    return QFileConfigManager.a().h();
  }
  
  public int getDebugDatalineSettingDevice()
  {
    return QFileConfigManager.a().b();
  }
  
  public String getDebugDatalineSettingUin()
  {
    return QFileConfigManager.a().a();
  }
  
  public boolean getDebugTroopAIOVideoDownloadPlay()
  {
    return QFileConfigManager.a().m();
  }
  
  public boolean getDiscFileIPv6Switch()
  {
    return QFileConfigManager.a().g();
  }
  
  public IExcitingC2CDownloadConfig getExcitingC2CDownloadConfig()
  {
    return QFileConfigManager.a().a();
  }
  
  public IExcitingC2CUploadConfig getExcitingC2CUploadConfig()
  {
    return QFileConfigManager.a().a();
  }
  
  public IExcitingGroupDownloadConfig getExcitingGroupDownloadConfig()
  {
    return QFileConfigManager.a().a();
  }
  
  public IExcitingGroupUploadConfig getExcitingGroupUploadConfig()
  {
    return QFileConfigManager.a().a();
  }
  
  public IFileAssistantTipsConfig getFileAssistantTipsConfig()
  {
    return QFileConfigManager.a().a();
  }
  
  public DownloadFileConfig getFileAutoDownloadConfig(String paramString)
  {
    return QFileConfigManager.a().a(paramString);
  }
  
  public int getFileIPv6Strategy()
  {
    return QFileConfigManager.a().a();
  }
  
  public boolean getFileIPv6Switch()
  {
    return QFileConfigManager.a().d();
  }
  
  public boolean getGroupFileIPv6Switch()
  {
    return QFileConfigManager.a().f();
  }
  
  public String getHarcodeIP()
  {
    return QFileConfigManager.a().b();
  }
  
  public boolean getTroopVideoFileSVIPSwitch()
  {
    return QFileConfigManager.a().b();
  }
  
  public boolean getTroopVideoFileSwitch()
  {
    return QFileConfigManager.a().a();
  }
  
  public boolean getTroopVideoFileYearSVIPSwitch()
  {
    return QFileConfigManager.a().c();
  }
  
  public boolean isAppNull()
  {
    return QFileConfigManager.a().a() == null;
  }
  
  public boolean isHarcodeIP()
  {
    return QFileConfigManager.a().o();
  }
  
  public boolean isMMApkFileCheckEnable()
  {
    return QFileConfigManager.a().n();
  }
  
  public boolean isMediaPlatformEnabled()
  {
    return QFileConfigManager.a().j();
  }
  
  public boolean isMediaPlatformLocalEnabled()
  {
    return QFileConfigManager.a().l();
  }
  
  public boolean isUseMediaPlatformLocalConfig()
  {
    return QFileConfigManager.a().k();
  }
  
  public boolean isWlanOnly()
  {
    return QFileConfigManager.a().i();
  }
  
  public void onAppInit(AppRuntime paramAppRuntime)
  {
    QFileConfigManager.a().a(paramAppRuntime);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    QFileConfigManager.a().a(paramAppRuntime);
    QFileConfigManager.a().a();
  }
  
  public void onDestroy() {}
  
  public void setDatalineConfig()
  {
    QFileConfigManager.a().c();
  }
  
  public void setDebugDatalineSettingDevice(int paramInt)
  {
    QFileConfigManager.a().a(paramInt);
  }
  
  public void setDebugDatalineSettingUin(String paramString)
  {
    QFileConfigManager.a().a(paramString);
  }
  
  public void setDebugTroopAIOVideoDownloadPlay(boolean paramBoolean)
  {
    QFileConfigManager.a().d(paramBoolean);
  }
  
  public void setFileReaderConfig()
  {
    QFileConfigManager.a().b();
  }
  
  public void setHarcodeIP(String paramString)
  {
    QFileConfigManager.a().b(paramString);
  }
  
  public void setHarcodeIP(boolean paramBoolean)
  {
    QFileConfigManager.a().f(paramBoolean);
  }
  
  public void setMMApkFileCheckEnable(boolean paramBoolean)
  {
    QFileConfigManager.a().e(paramBoolean);
  }
  
  public void setMediaPlatformLocalEnabled(boolean paramBoolean)
  {
    QFileConfigManager.a().c(paramBoolean);
  }
  
  public void setUseMediaPlatformLocalConfig(boolean paramBoolean)
  {
    QFileConfigManager.a().b(paramBoolean);
  }
  
  public void setWlanOnly(boolean paramBoolean)
  {
    QFileConfigManager.a().a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.QFileConfigManagerImpl
 * JD-Core Version:    0.7.0.1
 */