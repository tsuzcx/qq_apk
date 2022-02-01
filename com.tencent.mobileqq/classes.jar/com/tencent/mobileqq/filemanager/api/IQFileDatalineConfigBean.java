package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IQFileDatalineConfigBean
  extends QRouteApi
{
  public abstract long getDelayStartOfflineTime();
  
  public abstract boolean getFileAssistantSwitch();
  
  public abstract boolean getIpadOnline();
  
  public abstract long getOfflineAutoDownload();
  
  public abstract long getOnlyOfflineLimitSize();
  
  public abstract void setFileAssistantSwitch(boolean paramBoolean);
  
  public abstract void setIpadOnline(boolean paramBoolean);
  
  public abstract void setNewFileAssistantSwitch(AppRuntime paramAppRuntime, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IQFileDatalineConfigBean
 * JD-Core Version:    0.7.0.1
 */