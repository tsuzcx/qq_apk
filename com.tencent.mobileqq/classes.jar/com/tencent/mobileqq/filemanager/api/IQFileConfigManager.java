package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.config.business.qfile.IConfigMgr;
import com.tencent.mobileqq.config.business.qfile.IQFileAppStorePromoteConfigBean;
import com.tencent.mobileqq.config.business.qfile.IQFileAppStorePromoteDialogConfigBean;
import com.tencent.mobileqq.config.business.qfile.IQFileDatalineConfigBean;
import com.tencent.mobileqq.config.business.qfile.IQFileExcitingC2CDownloadConfigBean;
import com.tencent.mobileqq.config.business.qfile.IQFileExcitingC2CUploadConfigBean;
import com.tencent.mobileqq.config.business.qfile.IQFileExcitingGroupDownloadConfigBean;
import com.tencent.mobileqq.config.business.qfile.IQFileExcitingGroupUploadConfigBean;
import com.tencent.mobileqq.config.business.qfile.IQFileFileReaderConfigBean;
import com.tencent.mobileqq.filemanager.data.DownloadFileConfig;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IQFileConfigManager
  extends IRuntimeService
{
  public abstract boolean getC2CFileIPv6Switch();
  
  public abstract IQFileDatalineConfigBean getDatalineConfig();
  
  public abstract boolean getDatalineFileIPv6Switch();
  
  public abstract int getDebugDatalineSettingDevice();
  
  public abstract String getDebugDatalineSettingUin();
  
  public abstract boolean getDebugTroopAIOVideoDownloadPlay();
  
  public abstract boolean getDiscFileIPv6Switch();
  
  public abstract IQFileExcitingC2CDownloadConfigBean getExcitingC2CDownloadConfig();
  
  public abstract IQFileExcitingC2CUploadConfigBean getExcitingC2CUploadConfig();
  
  public abstract IQFileExcitingGroupDownloadConfigBean getExcitingGroupDownloadConfig();
  
  public abstract IQFileExcitingGroupUploadConfigBean getExcitingGroupUploadConfig();
  
  public abstract IFileAssistantTipsConfig getFileAssistantTipsConfig();
  
  public abstract DownloadFileConfig getFileAutoDownloadConfig(String paramString);
  
  public abstract int getFileIPv6Strategy();
  
  public abstract boolean getFileIPv6Switch();
  
  public abstract IQFileFileReaderConfigBean getFileReaderConfig();
  
  public abstract boolean getGroupFileIPv6Switch();
  
  public abstract String getHarcodeIP();
  
  public abstract IConfigMgr getQFileConfigManager();
  
  public abstract boolean getTroopVideoFileSVIPSwitch();
  
  public abstract boolean getTroopVideoFileSwitch();
  
  public abstract boolean getTroopVideoFileYearSVIPSwitch();
  
  public abstract IQFileAppStorePromoteConfigBean getYYBPromoteConfig();
  
  public abstract IQFileAppStorePromoteDialogConfigBean getYYBPromoteDialogConfig();
  
  public abstract boolean isHarcodeIP();
  
  public abstract boolean isMMApkFileCheckEnable();
  
  public abstract boolean isMediaPlatformEnabled();
  
  public abstract boolean isMediaPlatformLocalEnabled();
  
  public abstract boolean isUseMediaPlatformLocalConfig();
  
  public abstract boolean isWlanOnly();
  
  public abstract void setDatalineConfig();
  
  public abstract void setDebugDatalineSettingDevice(int paramInt);
  
  public abstract void setDebugDatalineSettingUin(String paramString);
  
  public abstract void setDebugTroopAIOVideoDownloadPlay(boolean paramBoolean);
  
  public abstract void setFileReaderConfig();
  
  public abstract void setHarcodeIP(String paramString);
  
  public abstract void setHarcodeIP(boolean paramBoolean);
  
  public abstract void setMMApkFileCheckEnable(boolean paramBoolean);
  
  public abstract void setMediaPlatformLocalEnabled(boolean paramBoolean);
  
  public abstract void setUseMediaPlatformLocalConfig(boolean paramBoolean);
  
  public abstract void setWlanOnly(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IQFileConfigManager
 * JD-Core Version:    0.7.0.1
 */