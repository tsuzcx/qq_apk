package com.tencent.mobileqq.nearby.api;

import android.content.Context;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vip.DownloaderInterface;
import java.util.HashMap;
import java.util.List;

@QAPI(process={"all"})
public abstract interface INearbyFlowerUtil
  extends QRouteApi
{
  public static final String FLOWER_DOWNLOAD_TASK_ID = "nearby_flower_task_id";
  
  public abstract void checkAllPackageStatus(HashMap<String, Integer> paramHashMap);
  
  public abstract boolean checkPackageValid(String paramString);
  
  public abstract List<String> getAnimationFrames(String paramString);
  
  public abstract String getDownloadUrl(Object paramObject);
  
  public abstract DownloaderInterface getDownloader(Object paramObject);
  
  public abstract int getFlowerCount(Object paramObject);
  
  public abstract String getFlowerMsgVersion(Object paramObject);
  
  public abstract String getGlamourIcon(Context paramContext);
  
  public abstract int[] getGlamourLevelColors(Context paramContext);
  
  public abstract String getPackageDownloadPath(String paramString);
  
  public abstract String getPackageStoreFolder(String paramString);
  
  public abstract String getSummaryText(Object paramObject);
  
  public abstract int getTitleBarHeight(Context paramContext);
  
  public abstract boolean isNearbyFlowerMsg(MessageRecord paramMessageRecord);
  
  public abstract Object loadActionData(String paramString);
  
  public abstract void setGlamourIcon(String paramString);
  
  public abstract void setGlamourLevelColors(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.INearbyFlowerUtil
 * JD-Core Version:    0.7.0.1
 */