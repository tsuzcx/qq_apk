package com.tencent.mobileqq.qcircle.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.biz.qcircleshadow.libmanager.QCircleListenerProxyManager;
import com.tencent.biz.qcircleshadow.local.QCircleShadow;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleAlphaUserReportDataBuilder;
import com.tencent.mobileqq.qcircle.api.constant.QCircleDTParamBuilder;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import cooperation.qqcircle.report.QCircleReportHelper.LaunchParam;
import cooperation.qqcircle.report.QCircleReporter;
import feedcloud.FeedCloudCommon.Entry;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class QCircleReportApiImpl
  implements IQCircleReportApi
{
  private static final String TAG = "QCircleReportServiceImpl";
  private static AppRuntime sAppRunTime;
  private ConcurrentHashMap<Class, Class> mClassImplMap = new ConcurrentHashMap();
  
  public String EXT2()
  {
    return "ext2";
  }
  
  public String E_PICKER_ENTER()
  {
    return QCirclePublishQualityReporter.E_PICKER_ENTER;
  }
  
  public String KEY_RET_CODE()
  {
    return "ret_code";
  }
  
  public String TRACEID()
  {
    return "traceid";
  }
  
  public PageParams buildPageParams(String paramString)
  {
    return new QCircleDTParamBuilder().setPageSubclass(paramString).buildPageParams();
  }
  
  public int getPageId()
  {
    return QCircleReportHelper.getInstance().getPageStackSize();
  }
  
  public String getPluginQUA()
  {
    return QCircleShadow.a().a();
  }
  
  public String getQCircleDaTongConstantPageId()
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
  
  public void registerDaTongReport(String paramString, View paramView, Activity paramActivity)
  {
    VideoReport.addToDetectionWhitelist(paramActivity);
    VideoReport.setPageId(paramView, "small_world_base");
    VideoReport.setPageParams(paramView, new QCircleDTParamBuilder().setPageSubclass(paramString).buildPageParams());
    RFLog.i(paramString, RFLog.USR, "reportDaTongRegister  subPage: " + paramString);
  }
  
  public void report5504(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(paramString).setActionType(paramInt1).setSubActionType(paramInt2).setThrActionType(paramInt3));
  }
  
  public void report5504(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(paramString1).setActionType(paramInt1).setSubActionType(paramInt2).setThrActionType(paramInt3).setExt2(paramString2).setExt3(paramString3).setExt4(paramString4).setExt5(paramString5));
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.QCircleReportApiImpl
 * JD-Core Version:    0.7.0.1
 */