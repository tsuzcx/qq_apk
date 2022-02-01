package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QGameBusEvent
  extends SimpleBaseEvent
{
  public static final int EVENT_VIDEO_ARK_PLAY = 4;
  public static final int EVENT_VIDEO_ARK_STOP = 3;
  public static final int EVENT_VIDEO_H5_PLAY = 2;
  public static final int EVENT_VIDEO_H5_STOP = 1;
  public static final int EVENT_VIDEO_NATIVE_PLAY = 6;
  public static final int EVENT_VIDEO_NATIVE_STOP = 5;
  public int eventType;
  
  public QGameBusEvent(int paramInt)
  {
    this.eventType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.QGameBusEvent
 * JD-Core Version:    0.7.0.1
 */