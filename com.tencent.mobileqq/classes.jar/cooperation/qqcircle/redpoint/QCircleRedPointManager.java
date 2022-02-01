package cooperation.qqcircle.redpoint;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qqcircle.events.QCircleRedInfoEvent;
import java.util.List;
import mqq.manager.Manager;
import qqcircle.QQCircleCounter.RedPointInfo;

public class QCircleRedPointManager
  implements IQCircleRedPointManagerDelegate, Manager
{
  private static final String TAG = "QCircleRedPointManager";
  private static boolean mIsQQCircleCurrentUseEeveeRedPoint;
  private IQCircleRedPointManagerDelegate mCurrentRedPointManagerDelegate;
  private final EeveeRedPointManagerDelegate mEeveeRedPointManagerDelegate;
  private final TianShuRedPointManagerDelegate mTianShuRedPointManagerDelegate;
  
  public QCircleRedPointManager(QQAppInterface paramQQAppInterface)
  {
    this.mEeveeRedPointManagerDelegate = new EeveeRedPointManagerDelegate(paramQQAppInterface);
    this.mTianShuRedPointManagerDelegate = new TianShuRedPointManagerDelegate(paramQQAppInterface);
    boolean bool1 = QzoneConfig.isEeveeSysTemPolling();
    boolean bool2 = QzoneConfig.isQQCircleUseEeveeRedPoint();
    this.mCurrentRedPointManagerDelegate = this.mEeveeRedPointManagerDelegate;
    mIsQQCircleCurrentUseEeveeRedPoint = true;
    QLog.e("QCircleRedPointManager", 1, "isQQCircleCurrentUseEeveeRedPoint: " + mIsQQCircleCurrentUseEeveeRedPoint + ", ( isEeveeSysTemPolling: " + bool1 + ", isQQCircleUseEeveeRedPoint: " + bool2 + " )");
  }
  
  private IQCircleRedPointManagerDelegate getCurrentRedPointManagerDelegate()
  {
    return this.mCurrentRedPointManagerDelegate;
  }
  
  public static boolean isQQCircleCurrentUseEeveeRedPoint()
  {
    return mIsQQCircleCurrentUseEeveeRedPoint;
  }
  
  public void asyncGetNumRedPointInfoByAppid(String paramString, QCircleRedPointManager.OnGetQQCircleNumRedMsgListener paramOnGetQQCircleNumRedMsgListener, boolean paramBoolean)
  {
    getCurrentRedPointManagerDelegate().asyncGetNumRedPointInfoByAppid(paramString, paramOnGetQQCircleNumRedMsgListener, paramBoolean);
  }
  
  public void clearPedPoint()
  {
    this.mEeveeRedPointManagerDelegate.clearPedPoint();
    this.mTianShuRedPointManagerDelegate.clearPedPoint();
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
  
  public QQCircleCounter.RedPointInfo getTianShuPromotionRedPointInfoByAppid(String paramString)
  {
    QQCircleCounter.RedPointInfo localRedPointInfo = this.mTianShuRedPointManagerDelegate.getSmallRedPointInfotByAppid(paramString);
    paramString = localRedPointInfo;
    if (localRedPointInfo != null)
    {
      List localList = localRedPointInfo.rptRedInfo.get();
      paramString = localRedPointInfo;
      if (localList != null)
      {
        paramString = localRedPointInfo;
        if (localList.size() > 0) {
          paramString = null;
        }
      }
    }
    return paramString;
  }
  
  public void onDestroy()
  {
    this.mEeveeRedPointManagerDelegate.onDestroy();
    this.mTianShuRedPointManagerDelegate.onDestroy();
  }
  
  public void onNumRedPointClick(String paramString, ReportExtraInfo paramReportExtraInfo)
  {
    this.mEeveeRedPointManagerDelegate.onNumRedPointClick(paramString, paramReportExtraInfo);
    this.mTianShuRedPointManagerDelegate.onNumRedPointClick(paramString, paramReportExtraInfo);
  }
  
  public void onNumRedPointExposure(String paramString, ReportExtraInfo paramReportExtraInfo)
  {
    this.mEeveeRedPointManagerDelegate.onNumRedPointExposure(paramString, paramReportExtraInfo);
    this.mTianShuRedPointManagerDelegate.onNumRedPointExposure(paramString, paramReportExtraInfo);
  }
  
  public void onOuterEntranceRedPointClick(String paramString, ReportExtraInfo paramReportExtraInfo)
  {
    this.mEeveeRedPointManagerDelegate.onOuterEntranceRedPointClick(paramString, paramReportExtraInfo);
    this.mTianShuRedPointManagerDelegate.onOuterEntranceRedPointClick(paramString, paramReportExtraInfo);
  }
  
  public void onOuterEntranceRedPointExposure(String paramString, ReportExtraInfo paramReportExtraInfo)
  {
    this.mEeveeRedPointManagerDelegate.onOuterEntranceRedPointExposure(paramString, paramReportExtraInfo);
    this.mTianShuRedPointManagerDelegate.onOuterEntranceRedPointExposure(paramString, paramReportExtraInfo);
  }
  
  public void onSmallRedPointClick(String paramString, ReportExtraInfo paramReportExtraInfo)
  {
    this.mEeveeRedPointManagerDelegate.onSmallRedPointClick(paramString, paramReportExtraInfo);
    this.mTianShuRedPointManagerDelegate.onSmallRedPointClick(paramString, paramReportExtraInfo);
  }
  
  public void onSmallRedPointExposure(String paramString, ReportExtraInfo paramReportExtraInfo)
  {
    this.mEeveeRedPointManagerDelegate.onSmallRedPointExposure(paramString, paramReportExtraInfo);
    this.mTianShuRedPointManagerDelegate.onSmallRedPointExposure(paramString, paramReportExtraInfo);
  }
  
  public void setNumRedPointReaded(String paramString)
  {
    this.mEeveeRedPointManagerDelegate.setNumRedPointReaded(paramString);
    this.mTianShuRedPointManagerDelegate.setNumRedPointReaded(paramString);
  }
  
  public void setOuterEntranceRedPointReaded(String paramString, List<Integer> paramList)
  {
    this.mEeveeRedPointManagerDelegate.setOuterEntranceRedPointReaded(paramString, paramList);
    this.mTianShuRedPointManagerDelegate.setOuterEntranceRedPointReaded(paramString, paramList);
    SimpleEventBus.getInstance().dispatchEvent(new QCircleRedInfoEvent("QCircleRedPointManager setOuterEntranceRedPointReaded", true));
  }
  
  public void setSmallRedPointReaded(String paramString)
  {
    this.mEeveeRedPointManagerDelegate.setSmallRedPointReaded(paramString);
    this.mTianShuRedPointManagerDelegate.setSmallRedPointReaded(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.redpoint.QCircleRedPointManager
 * JD-Core Version:    0.7.0.1
 */