package com.tencent.mobileqq.qcircle.api.impl;

import android.content.Intent;
import com.tencent.biz.qcircleshadow.libmanager.QCircleListenerProxyManager;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
import com.tencent.qqlive.module.videoreport.PageParams;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QCircleReportApiImpl
  implements IQCircleReportApi
{
  private static final String TAG = "QCircleReportServiceImpl";
  
  public String DESC()
  {
    return "desc";
  }
  
  public String EXT1()
  {
    return "ext1";
  }
  
  public String EXT2()
  {
    return "ext2";
  }
  
  public String EXT3()
  {
    return "ext3";
  }
  
  public String EXT4()
  {
    return "ext4";
  }
  
  public String E_PICKER_ENTER()
  {
    return QCirclePublishQualityReporter.E_PICKER_ENTER;
  }
  
  public String E_PICKER_EXPOSE()
  {
    return QCirclePublishQualityReporter.E_PICKER_EXPOSE;
  }
  
  public String E_PICKER_READY()
  {
    return QCirclePublishQualityReporter.E_PICKER_READY;
  }
  
  public String KEY_RET_CODE()
  {
    return "ret_code";
  }
  
  public String P_EXPORT_END()
  {
    return QCirclePublishQualityReporter.P_EXPORT_END;
  }
  
  public String P_EXPORT_START()
  {
    return QCirclePublishQualityReporter.P_EXPORT_START;
  }
  
  public String P_MATERIAL_COST_END()
  {
    return QCirclePublishQualityReporter.P_MATERIAL_COST_END;
  }
  
  public String P_MATERIAL_COST_START()
  {
    return QCirclePublishQualityReporter.P_MATERIAL_COST_START;
  }
  
  public String P_MATERIAL_DOWNLOAD_FINISH()
  {
    return QCirclePublishQualityReporter.P_MATERIAL_DOWNLOAD_FINISH;
  }
  
  public String TRACEID()
  {
    return "traceid";
  }
  
  public Map<String, Object> buildElementParams()
  {
    return new QCircleDTParamBuilder().buildElementParams();
  }
  
  public PageParams buildPageParams(String paramString)
  {
    return new QCircleDTParamBuilder().buildPageParams(paramString);
  }
  
  public int getPageId()
  {
    return QCircleReportHelper.getInstance().getPageStackSize();
  }
  
  public String getQCircleDaTongBasePageId()
  {
    return "small_world_base";
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
  
  public void report5504(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(paramString).setActionType(paramInt1).setSubActionType(paramInt2).setThrActionType(paramInt3));
  }
  
  public void report5504(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(paramString1).setActionType(paramInt1).setSubActionType(paramInt2).setThrActionType(paramInt3).setExt6(paramString2));
  }
  
  public void report5504(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(paramString1).setActionType(paramInt1).setSubActionType(paramInt2).setThrActionType(paramInt3).setExt15(paramString2).setExt16(paramString3).setExt17(paramString4).setExt18(paramString5));
  }
  
  public void report5504(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(paramString1).setActionType(paramInt1).setSubActionType(paramInt2).setThrActionType(paramInt3).setExt15(paramString2).setExt16(paramString3).setExt17(paramString4).setExt18(paramString5).setExt8(paramString6).setExt9(paramString7));
  }
  
  public void report5504(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(paramString1).setActionType(paramInt1).setSubActionType(paramInt2).setThrActionType(paramInt3).setExt6(paramString2).setExt7(paramString3).setExt9(paramString4).setExt15(paramString5).setExt16(paramString6).setExt17(paramString7).setExt18(paramString8));
  }
  
  public void report5504(String paramString, int paramInt1, int paramInt2, int paramInt3, HashMap<String, String> paramHashMap, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(paramString).setActionType(paramInt1).setSubActionType(paramInt2).setThrActionType(paramInt3).setFeedReportInfo(paramArrayOfByte1).setMsgReportInfo(paramArrayOfByte2).setExtras(paramHashMap));
  }
  
  public void reportCacheDataListToServerWithSession(byte[] paramArrayOfByte)
  {
    QCircleReporter.getInstance().reportCacheDataListToServerWithSession(paramArrayOfByte);
  }
  
  public void reportCmdSuccessRateEvent(QCircleAlphaUserReportDataBuilder paramQCircleAlphaUserReportDataBuilder)
  {
    QCircleAlphaUserReporter.reportCmdSuccessRateEvent(paramQCircleAlphaUserReportDataBuilder);
  }
  
  public void reportDc010001(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt4)
  {
    QCircleLpReportDc010001.report(paramInt1, paramInt2, paramInt3, paramString1, paramString2, paramString3, paramString4, paramInt4);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.QCircleReportApiImpl
 * JD-Core Version:    0.7.0.1
 */