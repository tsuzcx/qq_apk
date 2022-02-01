package com.tencent.mobileqq.qcircle.api;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqlive.module.videoreport.PageParams;
import feedcloud.FeedCloudCommon.Entry;
import java.util.HashMap;
import java.util.List;

@QAPI(process={"all"})
public abstract interface IQCircleReportApi
  extends QRouteApi
{
  public abstract String EXT2();
  
  public abstract String E_PICKER_ENTER();
  
  public abstract String KEY_RET_CODE();
  
  public abstract String TRACEID();
  
  public abstract PageParams buildPageParams(String paramString);
  
  public abstract int getPageId();
  
  public abstract String getPluginQUA();
  
  public abstract String getQCircleDaTongConstantPageId();
  
  public abstract FeedCloudCommon.Entry newEntry(String paramString1, String paramString2);
  
  public abstract void onEnterBackground();
  
  public abstract void onEnterForeground();
  
  public abstract void registerDaTongReport(String paramString, View paramView, Activity paramActivity);
  
  public abstract void report5504(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void report5504(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void report5504(String paramString, int paramInt1, int paramInt2, int paramInt3, HashMap<String, String> paramHashMap, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public abstract void reportCacheDataListToServerWithSession(byte[] paramArrayOfByte);
  
  public abstract void reportCmdSuccessRateEvent(QCircleAlphaUserReportDataBuilder paramQCircleAlphaUserReportDataBuilder);
  
  public abstract void reportDc010001(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt4);
  
  public abstract void reportPublishQuality(String paramString, List<FeedCloudCommon.Entry> paramList);
  
  public abstract void reportQualityEvent(String paramString, List paramList, boolean paramBoolean);
  
  public abstract void setFlutterLauncherParams(Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.IQCircleReportApi
 * JD-Core Version:    0.7.0.1
 */