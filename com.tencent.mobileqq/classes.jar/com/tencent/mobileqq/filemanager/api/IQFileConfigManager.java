package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.config.business.qfile.IExcitingC2CDownloadConfig;
import com.tencent.mobileqq.config.business.qfile.IExcitingC2CUploadConfig;
import com.tencent.mobileqq.config.business.qfile.IExcitingGroupDownloadConfig;
import com.tencent.mobileqq.config.business.qfile.IExcitingGroupUploadConfig;
import com.tencent.mobileqq.filemanager.data.DownloadFileConfig;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IQFileConfigManager
  extends IRuntimeService
{
  public abstract boolean getC2CFileIPv6Switch();
  
  public abstract boolean getDatalineFileIPv6Switch();
  
  public abstract int getDebugDatalineSettingDevice();
  
  public abstract String getDebugDatalineSettingUin();
  
  public abstract boolean getDebugTroopAIOVideoDownloadPlay();
  
  public abstract boolean getDiscFileIPv6Switch();
  
  public abstract IExcitingC2CDownloadConfig getExcitingC2CDownloadConfig();
  
  public abstract IExcitingC2CUploadConfig getExcitingC2CUploadConfig();
  
  public abstract IExcitingGroupDownloadConfig getExcitingGroupDownloadConfig();
  
  public abstract IExcitingGroupUploadConfig getExcitingGroupUploadConfig();
  
  public abstract IFileAssistantTipsConfig getFileAssistantTipsConfig();
  
  public abstract DownloadFileConfig getFileAutoDownloadConfig(String paramString);
  
  public abstract int getFileIPv6Strategy();
  
  public abstract boolean getFileIPv6Switch();
  
  public abstract boolean getGroupFileIPv6Switch();
  
  public abstract String getHarcodeIP();
  
  public abstract boolean getTroopVideoFileSVIPSwitch();
  
  public abstract boolean getTroopVideoFileSwitch();
  
  public abstract boolean getTroopVideoFileYearSVIPSwitch();
  
  public abstract boolean isAppNull();
  
  public abstract boolean isHarcodeIP();
  
  public abstract boolean isMMApkFileCheckEnable();
  
  public abstract boolean isMediaPlatformEnabled();
  
  public abstract boolean isMediaPlatformLocalEnabled();
  
  public abstract boolean isUseMediaPlatformLocalConfig();
  
  public abstract boolean isWlanOnly();
  
  public abstract void onAppInit(AppRuntime paramAppRuntime);
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IQFileConfigManager
 * JD-Core Version:    0.7.0.1
 */