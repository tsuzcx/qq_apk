package cooperation.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleFrameEvent
  extends SimpleBaseEvent
{
  public String mBackgroundColor = "#FAFAFB";
  public boolean mIsHideSnapShot;
  public boolean mIsRefreshRedNum;
  public boolean mIsTabClickSelf;
  
  public QCircleFrameEvent() {}
  
  public QCircleFrameEvent(int paramInt, boolean paramBoolean)
  {
    this.mHashCode = paramInt;
    this.mIsTabClickSelf = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqcircle.events.QCircleFrameEvent
 * JD-Core Version:    0.7.0.1
 */