package com.tencent.mobileqq.earlydownload.api;

import android.content.Intent;
import com.tencent.mobileqq.earlydownload.handler.EarlyHandler;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;
import protocol.KQQConfig.GetResourceRespInfo;

@Service(process={""})
public abstract interface IEarlyDownloadService
  extends IRuntimeService
{
  public abstract void addRequesting(String paramString);
  
  public abstract void downloadResource(XmlData paramXmlData, String paramString);
  
  public abstract String getCurrentUin();
  
  public abstract EarlyHandler getEarlyHandler(String paramString);
  
  public abstract void handleBroadcastReq(Intent paramIntent);
  
  public abstract boolean isLowEndPhone();
  
  public abstract boolean isRequesting(String paramString);
  
  public abstract void onNetChanged();
  
  public abstract void onServerResp(GetResourceRespInfo paramGetResourceRespInfo);
  
  public abstract void removeRequesting(String paramString);
  
  public abstract void setEarlyDownloadLock();
  
  public abstract void setEarlyDownloadUnLock();
  
  public abstract void updateConfigs(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService
 * JD-Core Version:    0.7.0.1
 */