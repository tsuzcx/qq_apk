package com.tencent.mobileqq.qcircle.api;

import android.content.Intent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc010001DataBuilder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqlive.module.videoreport.PageParams;
import feedcloud.FeedCloudCommon.Entry;
import java.util.List;
import java.util.Map;

@QAPI(process={"all"})
public abstract interface IQCircleReportApi
  extends QRouteApi
{
  public abstract Map<String, Object> buildElementParams();
  
  public abstract PageParams buildPageParams(String paramString);
  
  public abstract String desc();
  
  public abstract String ePickerEnter();
  
  public abstract String ePickerExitCancel();
  
  public abstract String ePickerExitNormal();
  
  public abstract String ePickerExpose();
  
  public abstract String ePickerReady();
  
  public abstract String ext1();
  
  public abstract String ext2();
  
  public abstract String ext3();
  
  public abstract String ext4();
  
  public abstract int getPageId();
  
  public abstract String getQCircleDaTongBasePageId();
  
  public abstract String keyRetCode();
  
  public abstract FeedCloudCommon.Entry newEntry(String paramString1, String paramString2);
  
  public abstract void onEnterBackground();
  
  public abstract void onEnterForeground();
  
  public abstract String pExportEnd();
  
  public abstract String pExportStart();
  
  public abstract String pMaterialCostEnd();
  
  public abstract String pMaterialCostStart();
  
  public abstract String pMaterialDownloadFinish();
  
  public abstract void report5504(QCircleLpReportDc05504DataBuilder paramQCircleLpReportDc05504DataBuilder);
  
  public abstract void reportCacheDataListToServerWithSession(byte[] paramArrayOfByte);
  
  public abstract void reportCmdSuccessRateEvent(QCircleAlphaUserReportDataBuilder paramQCircleAlphaUserReportDataBuilder);
  
  public abstract void reportDc010001(QCircleLpReportDc010001DataBuilder paramQCircleLpReportDc010001DataBuilder);
  
  public abstract void reportEnd(String paramString1, String paramString2, List<FeedCloudCommon.Entry> paramList);
  
  public abstract void reportLaunchPeriodEvent(QCircleAlphaUserReportDataBuilder paramQCircleAlphaUserReportDataBuilder);
  
  public abstract void reportLog(QCircleAlphaUserReportDataBuilder paramQCircleAlphaUserReportDataBuilder);
  
  public abstract void reportLog(String paramString, QCircleAlphaUserReportDataBuilder paramQCircleAlphaUserReportDataBuilder);
  
  public abstract void reportPublishQuality(String paramString, List<FeedCloudCommon.Entry> paramList);
  
  public abstract void reportQualityEvent(String paramString, List paramList, boolean paramBoolean);
  
  public abstract void setFlutterLauncherParams(Intent paramIntent);
  
  public abstract void startKey(String paramString);
  
  public abstract String traceId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.IQCircleReportApi
 * JD-Core Version:    0.7.0.1
 */