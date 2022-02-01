package com.tencent.mobileqq.data;

import android.content.Context;
import android.text.TextUtils;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneCommonRequest;
import cooperation.qzone.statistic.StatisticCollector;
import cooperation.qzone.statistic.access.WnsKeys;
import cooperation.qzone.statistic.access.concept.Statistic;
import cooperation.qzone.util.NetworkState;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Servlet;

public class QzoneCommonIntent
  extends NewIntent
{
  static RespProcessor defaultProcessor = new QzoneCommonIntent.1();
  private RespProcessor processor;
  private QZoneCommonRequest request;
  
  public QzoneCommonIntent(Context paramContext, Class<? extends Servlet> paramClass)
  {
    super(paramContext, paramClass);
  }
  
  private static void prepareReport(QZoneCommonRequest paramQZoneCommonRequest, int paramInt, String paramString)
  {
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance();
    Statistic localStatistic = localStatisticCollector.getStatistic();
    localStatistic.setValue(WnsKeys.AppId, Integer.valueOf(localStatisticCollector.getAppid()));
    localStatistic.setValue(WnsKeys.ReleaseVersion, localStatisticCollector.getReleaseVersion());
    localStatistic.setValue(WnsKeys.CommandId, paramQZoneCommonRequest.getCmdString());
    localStatistic.setValue(WnsKeys.APN, NetworkState.getAPN());
    localStatistic.setValue(WnsKeys.ResultCode_i, Integer.valueOf(paramInt));
    paramQZoneCommonRequest = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (paramQZoneCommonRequest != null) {
      localStatistic.setValue(WnsKeys.ToUIN, Long.valueOf(paramQZoneCommonRequest.getLongAccountUin()));
    }
    localStatistic.setValue(WnsKeys.Qua, QUA.getQUA3());
    localStatistic.setValue(WnsKeys.Build, "5295");
    if ((paramInt != 0) && (!TextUtils.isEmpty(paramString)))
    {
      localStatistic.setValue(WnsKeys.Detail, paramString);
      localStatistic.setValue(WnsKeys.Frequency, Integer.valueOf(1));
    }
    localStatisticCollector.put(localStatistic);
    if (paramInt != 0) {
      localStatisticCollector.forceReport();
    }
  }
  
  public static boolean succeeded(int paramInt)
  {
    return (paramInt == 0) || ((Math.abs(paramInt) <= 19999) && (Math.abs(paramInt) >= 19000));
  }
  
  public RespProcessor getProcessor()
  {
    RespProcessor localRespProcessor2 = this.processor;
    RespProcessor localRespProcessor1 = localRespProcessor2;
    if (localRespProcessor2 == null) {
      localRespProcessor1 = defaultProcessor;
    }
    return localRespProcessor1;
  }
  
  public QZoneCommonRequest getRequest()
  {
    return this.request;
  }
  
  public void setRequest(QZoneCommonRequest paramQZoneCommonRequest)
  {
    this.request = paramQZoneCommonRequest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.QzoneCommonIntent
 * JD-Core Version:    0.7.0.1
 */