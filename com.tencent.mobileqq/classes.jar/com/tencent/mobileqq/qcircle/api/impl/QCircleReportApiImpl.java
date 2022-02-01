package com.tencent.mobileqq.qcircle.api.impl;

import android.content.Intent;
import com.tencent.biz.qcircleshadow.libmanager.QCircleListenerProxyManager;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc010001DataBuilder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleLpReportDc05504DataBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import cooperation.qqcircle.report.QCircleLpReportDc010001.DataBuilder;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCircleMapReporter;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleReportHelper.LaunchParam;
import cooperation.qqcircle.report.QCircleReporter;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import feedcloud.FeedCloudCommon.Entry;
import java.util.List;
import java.util.Map;

public class QCircleReportApiImpl
  implements IQCircleReportApi
{
  private static final String TAG = "QCircleReportServiceImpl";
  
  public Map<String, Object> buildElementParams()
  {
    return new QCircleDTParamBuilder().buildElementParams();
  }
  
  public PageParams buildPageParams(String paramString)
  {
    return new QCircleDTParamBuilder().buildPageParams(paramString);
  }
  
  public String desc()
  {
    return "desc";
  }
  
  public String ePickerEnter()
  {
    return QCirclePublishQualityReporter.E_PICKER_ENTER;
  }
  
  public String ePickerExitCancel()
  {
    return QCirclePublishQualityReporter.E_PICKER_EXIT_CANCEL;
  }
  
  public String ePickerExitNormal()
  {
    return QCirclePublishQualityReporter.E_PICKER_EXIT_NORMAL;
  }
  
  public String ePickerExpose()
  {
    return QCirclePublishQualityReporter.E_PICKER_EXPOSE;
  }
  
  public String ePickerReady()
  {
    return QCirclePublishQualityReporter.E_PICKER_READY;
  }
  
  public String ext1()
  {
    return "ext1";
  }
  
  public String ext2()
  {
    return "ext2";
  }
  
  public String ext3()
  {
    return "ext3";
  }
  
  public String ext4()
  {
    return "ext4";
  }
  
  public int getPageId()
  {
    return QCircleReportHelper.getInstance().getPageStackSize();
  }
  
  public String getQCircleDaTongBasePageId()
  {
    return "small_world_base";
  }
  
  public String keyRetCode()
  {
    return "ret_code";
  }
  
  public FeedCloudCommon.Entry newEntry(String paramString1, String paramString2)
  {
    return QCircleReportHelper.newEntry(paramString1, paramString2);
  }
  
  public void onEnterBackground()
  {
    QCircleReportHelper.getInstance().onEnterBackground();
    QCircleListenerProxyManager.getInstance().onQQEnterBackground();
  }
  
  public void onEnterForeground()
  {
    QCircleReportHelper.getInstance().onEnterForeground();
    QCircleListenerProxyManager.getInstance().onQQEnterForeground();
  }
  
  public String pExportEnd()
  {
    return QCirclePublishQualityReporter.P_EXPORT_END;
  }
  
  public String pExportStart()
  {
    return QCirclePublishQualityReporter.P_EXPORT_START;
  }
  
  public String pMaterialCostEnd()
  {
    return QCirclePublishQualityReporter.P_MATERIAL_COST_END;
  }
  
  public String pMaterialCostStart()
  {
    return QCirclePublishQualityReporter.P_MATERIAL_COST_START;
  }
  
  public String pMaterialDownloadFinish()
  {
    return QCirclePublishQualityReporter.P_MATERIAL_DOWNLOAD_FINISH;
  }
  
  public void report5504(QCircleLpReportDc05504DataBuilder paramQCircleLpReportDc05504DataBuilder)
  {
    if (paramQCircleLpReportDc05504DataBuilder == null)
    {
      QLog.e("QCircleReportServiceImpl", 1, "reportDc010001: dataBuilder is null");
      return;
    }
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder(paramQCircleLpReportDc05504DataBuilder));
  }
  
  public void reportCacheDataListToServerWithSession(byte[] paramArrayOfByte)
  {
    QCircleReporter.getInstance().reportCacheDataListToServerWithSession(paramArrayOfByte);
  }
  
  public void reportCmdSuccessRateEvent(QCircleAlphaUserReportDataBuilder paramQCircleAlphaUserReportDataBuilder)
  {
    QCircleAlphaUserReporter.reportCmdSuccessRateEvent(paramQCircleAlphaUserReportDataBuilder);
  }
  
  public void reportDc010001(QCircleLpReportDc010001DataBuilder paramQCircleLpReportDc010001DataBuilder)
  {
    if (paramQCircleLpReportDc010001DataBuilder == null)
    {
      QLog.e("QCircleReportServiceImpl", 1, "reportDc010001: dataBuilder is null");
      return;
    }
    QCircleLpReportDc010001.report(new QCircleLpReportDc010001.DataBuilder(paramQCircleLpReportDc010001DataBuilder));
  }
  
  public void reportEnd(String paramString1, String paramString2, List<FeedCloudCommon.Entry> paramList)
  {
    QCircleMapReporter.getInstance().reportEnd(paramString1, paramString2, paramList);
  }
  
  public void reportLaunchPeriodEvent(QCircleAlphaUserReportDataBuilder paramQCircleAlphaUserReportDataBuilder)
  {
    QCircleAlphaUserReporter.reportLaunchPeriodEvent(paramQCircleAlphaUserReportDataBuilder);
  }
  
  public void reportLog(QCircleAlphaUserReportDataBuilder paramQCircleAlphaUserReportDataBuilder)
  {
    QCircleAlphaUserReporter.reportLog(paramQCircleAlphaUserReportDataBuilder);
  }
  
  public void reportLog(String paramString, QCircleAlphaUserReportDataBuilder paramQCircleAlphaUserReportDataBuilder)
  {
    QCircleAlphaUserReporter.reportLog(paramString, paramQCircleAlphaUserReportDataBuilder);
  }
  
  public void reportPublishQuality(String paramString, List<FeedCloudCommon.Entry> paramList)
  {
    QCirclePublishQualityReporter.report(paramString, paramList);
  }
  
  public void reportQualityEvent(String paramString, List paramList, boolean paramBoolean)
  {
    QCircleQualityReporter.reportQualityEvent(paramString, paramList, paramBoolean);
  }
  
  public void setFlutterLauncherParams(Intent paramIntent)
  {
    if (QCircleReportHelper.getInstance().isPageStackEmpty())
    {
      paramIntent = (QCircleReportHelper.LaunchParam)paramIntent.getParcelableExtra("report_launch_param");
      QCircleReportHelper.getInstance().setLaunchParms(paramIntent);
    }
  }
  
  public void startKey(String paramString)
  {
    QCircleMapReporter.getInstance().startKey(paramString);
  }
  
  public String traceId()
  {
    return "traceid";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.QCircleReportApiImpl
 * JD-Core Version:    0.7.0.1
 */