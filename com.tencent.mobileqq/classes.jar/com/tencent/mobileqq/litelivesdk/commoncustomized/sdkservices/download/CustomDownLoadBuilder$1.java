package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.download;

import com.tencent.falco.base.libapi.downloader.DownLoaderInterface.DownLoaderComponentAdapter;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;

class CustomDownLoadBuilder$1
  implements DownLoaderInterface.DownLoaderComponentAdapter
{
  CustomDownLoadBuilder$1(CustomDownLoadBuilder paramCustomDownLoadBuilder) {}
  
  public int getAppId()
  {
    return Integer.parseInt(BusinessManager.a.a().a);
  }
  
  public LogInterface getLog()
  {
    return (LogInterface)BizEngineMgr.getInstance().getLiveEngine().getService(LogInterface.class);
  }
  
  public boolean isLite()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.download.CustomDownLoadBuilder.1
 * JD-Core Version:    0.7.0.1
 */