package cooperation.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleFuelAnimationEvent
  extends SimpleBaseEvent
{
  private boolean isPublishTask;
  
  public QCircleFuelAnimationEvent() {}
  
  public QCircleFuelAnimationEvent(boolean paramBoolean)
  {
    this.isPublishTask = paramBoolean;
  }
  
  public boolean getPublishTask()
  {
    return this.isPublishTask;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.events.QCircleFuelAnimationEvent
 * JD-Core Version:    0.7.0.1
 */