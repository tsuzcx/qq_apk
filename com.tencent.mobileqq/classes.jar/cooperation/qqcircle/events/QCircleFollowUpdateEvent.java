package cooperation.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleFollowUpdateEvent
  extends SimpleBaseEvent
{
  public int mFollowStatus;
  public String mUserId;
  
  public QCircleFollowUpdateEvent(int paramInt, String paramString)
  {
    this.mFollowStatus = paramInt;
    this.mUserId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.events.QCircleFollowUpdateEvent
 * JD-Core Version:    0.7.0.1
 */