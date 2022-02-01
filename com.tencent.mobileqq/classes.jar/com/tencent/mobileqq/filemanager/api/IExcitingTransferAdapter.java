package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IExcitingTransferAdapter
  extends IRuntimeService
{
  public abstract List<ExcitingTransferHostInfo> getBigDataHostList(boolean paramBoolean);
  
  public abstract ExcitingTransferDownloadConfig getC2CDownloadConfig();
  
  public abstract long getC2CDownloadLimitedSize();
  
  public abstract ExcitingTransferUploadChnConfigInfo getC2CUploadChnConfig();
  
  public abstract long getC2CUploadLimitedSize();
  
  public abstract boolean getConfigFromServer();
  
  public abstract ExcitingTransferDownloadConfig getGroupDownloadConfig();
  
  public abstract long getGroupDownloadLimitedSize();
  
  public abstract ExcitingTransferUploadChnConfigInfo getGroupUploadChnConfig();
  
  public abstract long getGroupUploadLimitedSize();
  
  public abstract long getSelfUin();
  
  public abstract boolean isEnableC2CDownload();
  
  public abstract boolean isEnableC2CUpload();
  
  public abstract boolean isEnableGroupDownload();
  
  public abstract boolean isEnableGroupUpload();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter
 * JD-Core Version:    0.7.0.1
 */