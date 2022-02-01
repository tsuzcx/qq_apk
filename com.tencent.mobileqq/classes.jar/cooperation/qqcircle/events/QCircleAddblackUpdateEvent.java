package cooperation.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleAddblackUpdateEvent
  extends SimpleBaseEvent
{
  public int blackstate;
  public String mUserId;
  
  public QCircleAddblackUpdateEvent(int paramInt, String paramString)
  {
    this.blackstate = paramInt;
    this.mUserId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.events.QCircleAddblackUpdateEvent
 * JD-Core Version:    0.7.0.1
 */