package cooperation.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.qphone.base.util.QLog;

public class QCircleRedInfoEvent
  extends SimpleBaseEvent
{
  private static final String TAG = "QCircleRedInfoEvent";
  public boolean mIsRefreshRedPoint;
  
  public QCircleRedInfoEvent(String paramString, boolean paramBoolean)
  {
    this.mIsRefreshRedPoint = paramBoolean;
    QLog.d("QCircleRedInfoEvent", 2, "clear & refreshRedPoint invokeMethodName:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.events.QCircleRedInfoEvent
 * JD-Core Version:    0.7.0.1
 */