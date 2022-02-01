package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleFeedOptEvent
  extends SimpleBaseEvent
{
  public static final int OPT_TYPE_DELETE = 2;
  public static final int OPT_TYPE_INSERT = 1;
  private int mOptType;
  
  public QCircleFeedOptEvent(int paramInt)
  {
    this.mOptType = paramInt;
  }
  
  public int getOptType()
  {
    return this.mOptType;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleFeedOptEvent{mOptType=");
    localStringBuilder.append(this.mOptType);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.event.QCircleFeedOptEvent
 * JD-Core Version:    0.7.0.1
 */