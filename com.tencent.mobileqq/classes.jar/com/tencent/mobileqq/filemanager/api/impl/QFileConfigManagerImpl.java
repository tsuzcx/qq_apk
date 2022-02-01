package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.config.business.qfile.IConfigMgr;
import com.tencent.mobileqq.config.business.qfile.IQFileAppStorePromoteConfigBean;
import com.tencent.mobileqq.config.business.qfile.IQFileAppStorePromoteDialogConfigBean;
import com.tencent.mobileqq.config.business.qfile.IQFileDatalineConfigBean;
import com.tencent.mobileqq.config.business.qfile.IQFileExcitingC2CDownloadConfigBean;
import com.tencent.mobileqq.config.business.qfile.IQFileExcitingC2CUploadConfigBean;
import com.tencent.mobileqq.config.business.qfile.IQFileExcitingGroupDownloadConfigBean;
import com.tencent.mobileqq.config.business.qfile.IQFileExcitingGroupUploadConfigBean;
import com.tencent.mobileqq.config.business.qfile.IQFileFileReaderConfigBean;
import com.tencent.mobileqq.filemanager.api.IFileAssistantTipsConfig;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager;
import com.tencent.mobileqq.filemanager.data.DownloadFileConfig;
import mqq.app.AppRuntime;

public class QFileConfigManagerImpl
  implements IQFileConfigManager
{
  private AppRuntime mApp;
  private QFileConfigManager mQFileConfigManager;
  
  public boolean getC2CFileIPv6Switch()
  {
    return QFileConfigManager.a(this.mApp).e();
  }
  
  public IQFileDatalineConfigBean getDatalineConfig()
  {
    return QFileConfigManager.a(this.mApp).a();
  }
  
  public boolean getDatalineFileIPv6Switch()
  {
    return QFileConfigManager.a(this.mApp).h();
  }
  
  public int getDebugDatalineSettingDevice()
  {
    return QFileConfigManager.a(this.mApp).b();
  }
  
  public String getDebugDatalineSettingUin()
  {
    return QFileConfigManager.a(this.mApp).a();
  }
  
  public boolean getDebugTroopAIOVideoDownloadPlay()
  {
    return QFileConfigManager.a(this.mApp).m();
  }
  
  public boolean getDiscFileIPv6Switch()
  {
    return QFileConfigManager.a(this.mApp).g();
  }
  
  public IQFileExcitingC2CDownloadConfigBean getExcitingC2CDownloadConfig()
  {
    return QFileConfigManager.a(this.mApp).a();
  }
  
  public IQFileExcitingC2CUploadConfigBean getExcitingC2CUploadConfig()
  {
    return QFileConfigManager.a(this.mApp).a();
  }
  
  public IQFileExcitingGroupDownloadConfigBean getExcitingGroupDownloadConfig()
  {
    return QFileConfigManager.a(this.mApp).a();
  }
  
  public IQFileExcitingGroupUploadConfigBean getExcitingGroupUploadConfig()
  {
    return QFileConfigManager.a(this.mApp).a();
  }
  
  public IFileAssistantTipsConfig getFileAssistantTipsConfig()
  {
    return QFileConfigManager.a(this.mApp).a();
  }
  
  public DownloadFileConfig getFileAutoDownloadConfig(String paramString)
  {
    return QFileConfigManager.a(this.mApp).a(paramString);
  }
  
  public int getFileIPv6Strategy()
  {
    return QFileConfigManager.a(this.mApp).a();
  }
  
  public boolean getFileIPv6Switch()
  {
    return QFileConfigManager.a(this.mApp).d();
  }
  
  public IQFileFileReaderConfigBean getFileReaderConfig()
  {
    return QFileConfigManager.a(this.mApp).a();
  }
  
  public boolean getGroupFileIPv6Switch()
  {
    return QFileConfigManager.a(this.mApp).f();
  }
  
  public String getHarcodeIP()
  {
    return QFileConfigManager.a(this.mApp).b();
  }
  
  public IConfigMgr getQFileConfigManager()
  {
    if (this.mQFileConfigManager == null) {
      this.mQFileConfigManager = new QFileConfigManager(this.mApp);
    }
    return this.mQFileConfigManager;
  }
  
  public boolean getTroopVideoFileSVIPSwitch()
  {
    return QFileConfigManager.a(this.mApp).b();
  }
  
  public boolean getTroopVideoFileSwitch()
  {
    return QFileConfigManager.a(this.mApp).a();
  }
  
  public boolean getTroopVideoFileYearSVIPSwitch()
  {
    return QFileConfigManager.a(this.mApp).c();
  }
  
  public IQFileAppStorePromoteConfigBean getYYBPromoteConfig()
  {
    return QFileConfigManager.a(this.mApp).a();
  }
  
  public IQFileAppStorePromoteDialogConfigBean getYYBPromoteDialogConfig()
  {
    return QFileConfigManager.a(this.mApp).a();
  }
  
  public boolean isHarcodeIP()
  {
    return QFileConfigManager.a(this.mApp).o();
  }
  
  public boolean isMMApkFileCheckEnable()
  {
    return QFileConfigManager.a(this.mApp).n();
  }
  
  public boolean isMediaPlatformEnabled()
  {
    return QFileConfigManager.a(this.mApp).j();
  }
  
  public boolean isMediaPlatformLocalEnabled()
  {
    return QFileConfigManager.a(this.mApp).l();
  }
  
  public boolean isUseMediaPlatformLocalConfig()
  {
    return QFileConfigManager.a(this.mApp).k();
  }
  
  public boolean isWlanOnly()
  {
    return QFileConfigManager.a(this.mApp).i();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    this.mQFileConfigManager = new QFileConfigManager(this.mApp);
  }
  
  public void onDestroy() {}
  
  public void setDatalineConfig()
  {
    QFileConfigManager.a(this.mApp).b();
  }
  
  public void setDebugDatalineSettingDevice(int paramInt)
  {
    QFileConfigManager.a(this.mApp).a(paramInt);
  }
  
  public void setDebugDatalineSettingUin(String paramString)
  {
    QFileConfigManager.a(this.mApp).a(paramString);
  }
  
  public void setDebugTroopAIOVideoDownloadPlay(boolean paramBoolean)
  {
    QFileConfigManager.a(this.mApp).d(paramBoolean);
  }
  
  public void setFileReaderConfig()
  {
    QFileConfigManager.a(this.mApp).a();
  }
  
  public void setHarcodeIP(String paramString)
  {
    QFileConfigManager.a(this.mApp).b(paramString);
  }
  
  public void setHarcodeIP(boolean paramBoolean)
  {
    QFileConfigManager.a(this.mApp).f(paramBoolean);
  }
  
  public void setMMApkFileCheckEnable(boolean paramBoolean)
  {
    QFileConfigManager.a(this.mApp).e(paramBoolean);
  }
  
  public void setMediaPlatformLocalEnabled(boolean paramBoolean)
  {
    QFileConfigManager.a(this.mApp).c(paramBoolean);
  }
  
  public void setUseMediaPlatformLocalConfig(boolean paramBoolean)
  {
    QFileConfigManager.a(this.mApp).b(paramBoolean);
  }
  
  public void setWlanOnly(boolean paramBoolean)
  {
    QFileConfigManager.a(this.mApp).a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.QFileConfigManagerImpl
 * JD-Core Version:    0.7.0.1
 */