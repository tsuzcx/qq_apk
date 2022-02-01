package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQFileExcitingGroupDownloadConfigBean
  extends QRouteApi
{
  public abstract boolean isDebugLocalEnable();
  
  public abstract void setDebugLocalEnable(boolean paramBoolean);
  
  public abstract void setDebugUseLocalCfg(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IQFileExcitingGroupDownloadConfigBean
 * JD-Core Version:    0.7.0.1
 */