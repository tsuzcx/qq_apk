package com.tencent.mobileqq.pic.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.BaseStrategy;
import com.tencent.mobileqq.pic.PicPreDownloadUtils;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicStatisticsManager;
import com.tencent.mobileqq.pic.PreDownloadStrategyBeta;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.api.IPicPreDownload.ConfigInfo;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class PicPreDownloadImpl
  implements IPicPreDownload
{
  AppInterface app;
  public PicPreDownloader picPreDownloader;
  public PicStatisticsManager picStatisticsManager;
  
  public int calcUinType(AppInterface paramAppInterface, int paramInt, String paramString)
  {
    return PicPreDownloadUtils.a(paramAppInterface, paramInt, paramString);
  }
  
  public void clearAIORequests()
  {
    this.picPreDownloader.c();
  }
  
  public void commitTrafficPref() {}
  
  public IPicPreDownload.ConfigInfo getConfigs()
  {
    return this.picPreDownloader.a.f();
  }
  
  public HashMap<String, String> getDebugPreDownloadReportInfo()
  {
    return this.picPreDownloader.a.i();
  }
  
  public boolean getPreDownSwitch()
  {
    return BaseStrategy.d;
  }
  
  public void increaseTroopCountWhenEnterAIO(String paramString)
  {
    this.picPreDownloader.a.c(paramString);
  }
  
  public boolean isScreenOn()
  {
    return PicPreDownloader.b;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = ((AppInterface)paramAppRuntime);
    this.picStatisticsManager = new PicStatisticsManager(this.app);
    this.picPreDownloader = new PicPreDownloader(this.app, this.picStatisticsManager);
  }
  
  public void onDestroy()
  {
    this.picPreDownloader.onDestroy();
    this.picStatisticsManager.onDestroy();
  }
  
  public void payPicFlow(MessageForPic paramMessageForPic)
  {
    this.picStatisticsManager.c(paramMessageForPic);
    this.picPreDownloader.a.b(paramMessageForPic, paramMessageForPic.size);
    this.picPreDownloader.d();
  }
  
  public void productFromAIO(MessageForPic paramMessageForPic, int paramInt)
  {
    this.picPreDownloader.a(paramMessageForPic, paramInt);
  }
  
  public void productFromAIODynamicPic(MessageForPic paramMessageForPic)
  {
    this.picPreDownloader.b(paramMessageForPic, 2);
  }
  
  public void productFromMsg(MessageRecord paramMessageRecord, int paramInt)
  {
    this.picPreDownloader.b(paramMessageRecord, paramInt);
  }
  
  public void switchOff()
  {
    this.picPreDownloader.a();
  }
  
  public void switchOn()
  {
    this.picPreDownloader.b();
  }
  
  public void updateConfigs(IPicPreDownload.ConfigInfo paramConfigInfo)
  {
    this.picPreDownloader.a.a(paramConfigInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.api.impl.PicPreDownloadImpl
 * JD-Core Version:    0.7.0.1
 */