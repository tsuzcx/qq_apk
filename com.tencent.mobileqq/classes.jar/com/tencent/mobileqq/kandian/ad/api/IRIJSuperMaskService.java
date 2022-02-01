package com.tencent.mobileqq.kandian.ad.api;

import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.widget.ListView;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;

@QAPI(process={"all"})
public abstract interface IRIJSuperMaskService
  extends QRouteApi
{
  public abstract void checkAdMaterialRefresh(Object paramObject);
  
  public abstract void close();
  
  public abstract MaterialData findDataById(Object paramObject, String paramString);
  
  public abstract Object getAdData();
  
  public abstract String getAdMaterialHandlerClassName();
  
  public abstract ConcurrentHashMap<String, MaterialData> getAllDBData(Object paramObject);
  
  public abstract int getChannelID();
  
  public abstract boolean getHasVolume();
  
  public abstract int getMaxReqCount();
  
  public abstract int getShowStatus();
  
  public abstract void initAdMaterialManager(Object paramObject);
  
  public abstract void initRes(Object paramObject);
  
  public abstract void isChannelRefreshing(int paramInt, boolean paramBoolean);
  
  public abstract boolean isNormalMask();
  
  public abstract String obtainResPath(String paramString1, String paramString2, int paramInt);
  
  public abstract void onPause();
  
  public abstract void onResDownloadDone(Object paramObject, DownloadTask paramDownloadTask, MaterialData paramMaterialData, File paramFile);
  
  public abstract void onResDownloadStart(Object paramObject, MaterialData paramMaterialData);
  
  public abstract void onResume();
  
  public abstract void receiveAd(Object paramObject);
  
  public abstract void refreshDailyReqAndRefreshNum();
  
  public abstract void refreshMainFeedsReqAndRefreshNum();
  
  public abstract void resetUIMgr();
  
  public abstract void setChannelID(int paramInt);
  
  public abstract void setHasVolume(boolean paramBoolean);
  
  public abstract void setListView(SoftReference<ListView> paramSoftReference);
  
  public abstract void setShowStatus(int paramInt);
  
  public abstract void setShowing(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService
 * JD-Core Version:    0.7.0.1
 */