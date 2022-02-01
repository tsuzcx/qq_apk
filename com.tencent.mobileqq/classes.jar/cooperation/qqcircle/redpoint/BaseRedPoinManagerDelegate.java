package cooperation.qqcircle.redpoint;

import com.tencent.mobileqq.qcircle.api.data.ReportExtraInfo;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.OnGetQQCircleNumRedMsgListener;
import java.util.List;
import qqcircle.QQCircleCounter.RedPointInfo;

public abstract interface BaseRedPoinManagerDelegate
{
  public abstract void asyncGetNumRedPointInfoByAppid(String paramString, OnGetQQCircleNumRedMsgListener paramOnGetQQCircleNumRedMsgListener, boolean paramBoolean);
  
  public abstract void clearPedPoint();
  
  public abstract QQCircleCounter.RedPointInfo getNumRedPointInfotByAppid(String paramString);
  
  public abstract QQCircleCounter.RedPointInfo getOuterEntranceRedPointInfoByAppid(String paramString);
  
  public abstract QQCircleCounter.RedPointInfo getSmallRedPointInfotByAppid(String paramString);
  
  public abstract void onNumRedPointClick(String paramString, ReportExtraInfo paramReportExtraInfo);
  
  public abstract void onNumRedPointExposure(String paramString, ReportExtraInfo paramReportExtraInfo);
  
  public abstract void onOuterEntranceRedPointClick(String paramString, ReportExtraInfo paramReportExtraInfo);
  
  public abstract void onOuterEntranceRedPointExposure(String paramString, ReportExtraInfo paramReportExtraInfo);
  
  public abstract void onSmallRedPointClick(String paramString, ReportExtraInfo paramReportExtraInfo);
  
  public abstract void onSmallRedPointExposure(String paramString, ReportExtraInfo paramReportExtraInfo);
  
  public abstract void setNumRedPointReaded(String paramString);
  
  public abstract void setOuterEntranceRedPointReaded(String paramString, List<Integer> paramList);
  
  public abstract void setSmallRedPointReaded(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqcircle.redpoint.BaseRedPoinManagerDelegate
 * JD-Core Version:    0.7.0.1
 */