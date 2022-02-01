package cooperation.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleRefreshHippyPageEvent
  extends SimpleBaseEvent
{
  public String mModule;
  
  public QCircleRefreshHippyPageEvent(String paramString)
  {
    this.mModule = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.events.QCircleRefreshHippyPageEvent
 * JD-Core Version:    0.7.0.1
 */