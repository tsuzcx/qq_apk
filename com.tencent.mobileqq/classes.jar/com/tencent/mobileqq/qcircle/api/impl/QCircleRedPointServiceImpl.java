package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.biz.qcircleshadow.handler.QCircleHandler;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qcircle.api.IQCircleRedPointService;
import com.tencent.mobileqq.qcircle.api.data.ReportExtraInfo;
import com.tencent.mobileqq.qcircle.api.event.QCircleRedInfoEvent;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.OnGetQQCircleNumRedMsgListener;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.QCircleConfig;
import cooperation.qqcircle.redpoint.BaseRedPoinManagerDelegate;
import cooperation.qqcircle.redpoint.EeveeRedPointManagerDelegate;
import java.util.List;
import mqq.app.AppRuntime;
import qqcircle.QQCircleCounter.RedPointInfo;

public class QCircleRedPointServiceImpl
  implements IQCircleRedPointService
{
  private static final String TAG = "QCircleRedPointManager";
  private static boolean mIsQQCircleCurrentUseEeveeRedPoint;
  private BaseRedPoinManagerDelegate mCurrentRedPointManagerDelegate;
  private EeveeRedPointManagerDelegate mEeveeRedPointManagerDelegate;
  
  private BaseRedPoinManagerDelegate getCurrentRedPointManagerDelegate()
  {
    return this.mCurrentRedPointManagerDelegate;
  }
  
  public void asyncGetNumRedPointInfoByAppid(String paramString, OnGetQQCircleNumRedMsgListener paramOnGetQQCircleNumRedMsgListener, boolean paramBoolean)
  {
    getCurrentRedPointManagerDelegate().asyncGetNumRedPointInfoByAppid(paramString, paramOnGetQQCircleNumRedMsgListener, paramBoolean);
  }
  
  public void clearPedPoint()
  {
    this.mEeveeRedPointManagerDelegate.clearPedPoint();
  }
  
  public QQCircleCounter.RedPointInfo getNumRedPointInfotByAppid(String paramString)
  {
    return getCurrentRedPointManagerDelegate().getNumRedPointInfotByAppid(paramString);
  }
  
  public QQCircleCounter.RedPointInfo getOuterEntranceRedPointInfoByAppid(String paramString)
  {
    return getCurrentRedPointManagerDelegate().getOuterEntranceRedPointInfoByAppid(paramString);
  }
  
  public QQCircleCounter.RedPointInfo getSmallRedPointInfotByAppid(String paramString)
  {
    return getCurrentRedPointManagerDelegate().getSmallRedPointInfotByAppid(paramString);
  }
  
  public boolean isQQCircleCurrentUseEeveeRedPoint()
  {
    return mIsQQCircleCurrentUseEeveeRedPoint;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mEeveeRedPointManagerDelegate = new EeveeRedPointManagerDelegate(paramAppRuntime);
    boolean bool1 = QCircleConfig.getInstance().isEeveeSysTemPolling();
    QCircleConfig.getInstance();
    boolean bool2 = QCircleConfig.isQQCircleUseEeveeRedPoint();
    this.mCurrentRedPointManagerDelegate = this.mEeveeRedPointManagerDelegate;
    mIsQQCircleCurrentUseEeveeRedPoint = true;
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("isQQCircleCurrentUseEeveeRedPoint: ");
    paramAppRuntime.append(mIsQQCircleCurrentUseEeveeRedPoint);
    paramAppRuntime.append(", ( isEeveeSysTemPolling: ");
    paramAppRuntime.append(bool1);
    paramAppRuntime.append(", isQQCircleUseEeveeRedPoint: ");
    paramAppRuntime.append(bool2);
    paramAppRuntime.append(" )");
    QLog.e("QCircleRedPointManager", 1, paramAppRuntime.toString());
  }
  
  public void onDestroy()
  {
    this.mEeveeRedPointManagerDelegate.onDestroy();
  }
  
  public void onNumRedPointClick(String paramString, ReportExtraInfo paramReportExtraInfo)
  {
    this.mEeveeRedPointManagerDelegate.onNumRedPointClick(paramString, paramReportExtraInfo);
  }
  
  public void onNumRedPointExposure(String paramString, ReportExtraInfo paramReportExtraInfo)
  {
    this.mEeveeRedPointManagerDelegate.onNumRedPointExposure(paramString, paramReportExtraInfo);
  }
  
  public void onOuterEntranceRedPointClick(String paramString, ReportExtraInfo paramReportExtraInfo)
  {
    this.mEeveeRedPointManagerDelegate.onOuterEntranceRedPointClick(paramString, paramReportExtraInfo);
  }
  
  public void onOuterEntranceRedPointExposure(String paramString, ReportExtraInfo paramReportExtraInfo)
  {
    this.mEeveeRedPointManagerDelegate.onOuterEntranceRedPointExposure(paramString, paramReportExtraInfo);
  }
  
  public void onSmallRedPointClick(String paramString, ReportExtraInfo paramReportExtraInfo)
  {
    this.mEeveeRedPointManagerDelegate.onSmallRedPointClick(paramString, paramReportExtraInfo);
  }
  
  public void onSmallRedPointExposure(String paramString, ReportExtraInfo paramReportExtraInfo)
  {
    this.mEeveeRedPointManagerDelegate.onSmallRedPointExposure(paramString, paramReportExtraInfo);
  }
  
  public void setNumRedPointReaded(String paramString)
  {
    this.mEeveeRedPointManagerDelegate.setNumRedPointReaded(paramString);
  }
  
  public void setOuterEntranceRedPointReaded(String paramString, List<Integer> paramList)
  {
    this.mEeveeRedPointManagerDelegate.setOuterEntranceRedPointReaded(paramString, paramList);
    SimpleEventBus.getInstance().dispatchEvent(new QCircleRedInfoEvent("QCircleRedPointManager setOuterEntranceRedPointReaded", true));
  }
  
  public void setSmallRedPointReaded(String paramString)
  {
    this.mEeveeRedPointManagerDelegate.setSmallRedPointReaded(paramString);
  }
  
  public void updateRedPoint()
  {
    if (QCircleHandler.d() != null) {
      QCircleHandler.d().b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.QCircleRedPointServiceImpl
 * JD-Core Version:    0.7.0.1
 */