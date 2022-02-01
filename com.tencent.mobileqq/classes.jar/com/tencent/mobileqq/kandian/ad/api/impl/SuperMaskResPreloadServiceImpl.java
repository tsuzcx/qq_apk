package com.tencent.mobileqq.kandian.ad.api.impl;

import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.mobileqq.kandian.ad.api.ISuperMaskResPreloadService;
import com.tencent.mobileqq.vip.DownloadTask;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class SuperMaskResPreloadServiceImpl
  implements ISuperMaskResPreloadService
{
  private AdMaterialResManager resManager;
  
  public MaterialData findDataById(String paramString)
  {
    return this.resManager.a(paramString);
  }
  
  public ConcurrentHashMap<String, MaterialData> getAllDBData()
  {
    return this.resManager.g();
  }
  
  public void init()
  {
    this.resManager.a();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.resManager = AdMaterialResManager.a(paramAppRuntime);
  }
  
  public void onDestroy() {}
  
  public void onResDownloadDone(DownloadTask paramDownloadTask, MaterialData paramMaterialData, File paramFile)
  {
    this.resManager.a(paramDownloadTask, paramMaterialData, paramFile);
  }
  
  public void onResDownloadStart(MaterialData paramMaterialData)
  {
    this.resManager.a(paramMaterialData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.SuperMaskResPreloadServiceImpl
 * JD-Core Version:    0.7.0.1
 */