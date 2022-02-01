package cooperation.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleSelectTabEvent
  extends SimpleBaseEvent
{
  public boolean needScrollTop;
  public int tabType;
  
  public QCircleSelectTabEvent(int paramInt)
  {
    this.tabType = paramInt;
  }
  
  public QCircleSelectTabEvent needScrollTop()
  {
    this.needScrollTop = true;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.events.QCircleSelectTabEvent
 * JD-Core Version:    0.7.0.1
 */