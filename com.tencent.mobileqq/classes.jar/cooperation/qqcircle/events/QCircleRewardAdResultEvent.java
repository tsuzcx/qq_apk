package cooperation.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleRewardAdResultEvent
  extends SimpleBaseEvent
{
  public String mToast;
  
  public QCircleRewardAdResultEvent(String paramString)
  {
    this.mToast = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.events.QCircleRewardAdResultEvent
 * JD-Core Version:    0.7.0.1
 */