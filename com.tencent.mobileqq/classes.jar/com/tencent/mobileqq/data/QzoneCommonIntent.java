package com.tencent.mobileqq.data;

import android.content.Context;
import android.text.TextUtils;
import anju;
import anjv;
import bgxr;
import bgxt;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qzone.statistic.StatisticCollector;
import cooperation.qzone.statistic.access.WnsKeys;
import cooperation.qzone.statistic.access.concept.Statistic;
import cooperation.qzone.util.NetworkState;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.app.Servlet;

public class QzoneCommonIntent
  extends NewIntent
{
  static anjv defaultProcessor = new anju();
  private anjv processor;
  private bgxt request;
  
  public QzoneCommonIntent(Context paramContext, Class<? extends Servlet> paramClass)
  {
    super(paramContext, paramClass);
  }
  
  private static void prepareReport(bgxt parambgxt, int paramInt, String paramString)
  {
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance();
    Statistic localStatistic = localStatisticCollector.getStatistic();
    localStatistic.setValue(WnsKeys.AppId, Integer.valueOf(localStatisticCollector.getAppid()));
    localStatistic.setValue(WnsKeys.ReleaseVersion, localStatisticCollector.getReleaseVersion());
    localStatistic.setValue(WnsKeys.CommandId, parambgxt.getCmdString());
    localStatistic.setValue(WnsKeys.APN, NetworkState.getAPN());
    localStatistic.setValue(WnsKeys.ResultCode_i, Integer.valueOf(paramInt));
    localStatistic.setValue(WnsKeys.ToUIN, Long.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()));
    localStatistic.setValue(WnsKeys.Qua, bgxr.a());
    localStatistic.setValue(WnsKeys.Build, "4440");
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
  
  public anjv getProcessor()
  {
    if (this.processor == null) {
      return defaultProcessor;
    }
    return this.processor;
  }
  
  public bgxt getRequest()
  {
    return this.request;
  }
  
  public void setRequest(bgxt parambgxt)
  {
    this.request = parambgxt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.QzoneCommonIntent
 * JD-Core Version:    0.7.0.1
 */