package com.tencent.mobileqq.kandian.ad.api;

import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.vip.DownloadTask;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={"all"})
public abstract interface ISuperMaskResPreloadService
  extends IRuntimeService
{
  public abstract MaterialData findDataById(String paramString);
  
  public abstract ConcurrentHashMap<String, MaterialData> getAllDBData();
  
  public abstract void init();
  
  public abstract void onResDownloadDone(DownloadTask paramDownloadTask, MaterialData paramMaterialData, File paramFile);
  
  public abstract void onResDownloadStart(MaterialData paramMaterialData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.ISuperMaskResPreloadService
 * JD-Core Version:    0.7.0.1
 */