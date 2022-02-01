package com.tencent.mobileqq.qcircle.api;

import android.content.Intent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqlive.module.videoreport.PageParams;
import feedcloud.FeedCloudCommon.Entry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@QAPI(process={"all"})
public abstract interface IQCircleReportApi
  extends QRouteApi
{
  public abstract String DESC();
  
  public abstract String EXT1();
  
  public abstract String EXT2();
  
  public abstract String EXT3();
  
  public abstract String EXT4();
  
  public abstract String E_PICKER_ENTER();
  
  public abstract String E_PICKER_EXPOSE();
  
  public abstract String E_PICKER_READY();
  
  public abstract String KEY_RET_CODE();
  
  public abstract String P_EXPORT_END();
  
  public abstract String P_EXPORT_START();
  
  public abstract String P_MATERIAL_COST_END();
  
  public abstract String P_MATERIAL_COST_START();
  
  public abstract String P_MATERIAL_DOWNLOAD_FINISH();
  
  public abstract String TRACEID();
  
  public abstract Map<String, Object> buildElementParams();
  
  public abstract PageParams buildPageParams(String paramString);
  
  public abstract int getPageId();
  
  public abstract String getQCircleDaTongBasePageId();
  
  public abstract FeedCloudCommon.Entry newEntry(String paramString1, String paramString2);
  
  public abstract void onEnterBackground();
  
  public abstract void onEnterForeground();
  
  public abstract void report5504(String paramString, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void report5504(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2);
  
  public abstract void report5504(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void report5504(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7);
  
  public abstract void report5504(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8);
  
  public abstract void report5504(String paramString, int paramInt1, int paramInt2, int paramInt3, HashMap<String, String> paramHashMap, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public abstract void reportCacheDataListToServerWithSession(byte[] paramArrayOfByte);
  
  public abstract void reportCmdSuccessRateEvent(QCircleAlphaUserReportDataBuilder paramQCircleAlphaUserReportDataBuilder);
  
  public abstract void reportDc010001(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt4);
  
  public abstract void reportEnd(String paramString1, String paramString2, List<FeedCloudCommon.Entry> paramList);
  
  public abstract void reportLaunchPeriodEvent(QCircleAlphaUserReportDataBuilder paramQCircleAlphaUserReportDataBuilder);
  
  public abstract void reportLog(QCircleAlphaUserReportDataBuilder paramQCircleAlphaUserReportDataBuilder);
  
  public abstract void reportLog(String paramString, QCircleAlphaUserReportDataBuilder paramQCircleAlphaUserReportDataBuilder);
  
  public abstract void reportPublishQuality(String paramString, List<FeedCloudCommon.Entry> paramList);
  
  public abstract void reportQualityEvent(String paramString, List paramList, boolean paramBoolean);
  
  public abstract void setFlutterLauncherParams(Intent paramIntent);
  
  public abstract void startKey(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.IQCircleReportApi
 * JD-Core Version:    0.7.0.1
 */