package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QQGameSubscribeBusEvent
  extends SimpleBaseEvent
{
  public static final int EVENT_GET_SUBSCRIBE_INFO_SUCCESS_SINGLE_MSG = 2;
  public static final int EVENT_NOTIFY_REFRESH_AIO_LIST = 1;
  public static final int EVENT_SET_SUBSCRIBE_FAILED = 6;
  public static final int EVENT_SET_SUBSCRIBE_INFO_SUCCESS_ALL_MSG = 4;
  public static final int EVENT_SET_SUBSCRIBE_INFO_SUCCESS_SINGLE_MSG = 3;
  public static final int EVENT_SET_SUBSCRIBE_SUCCESS_ALL_MSG_UPDATE_GRAY = 5;
  public int eventType;
  public long seq;
  public QQGamePubSubscribe.AppSubscribeInfo subscribeInfo;
  
  public QQGameSubscribeBusEvent(int paramInt)
  {
    this.eventType = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QQGameSubscribeBusEvent{eventType=");
    localStringBuilder.append(this.eventType);
    localStringBuilder.append(", subscribeInfo=");
    localStringBuilder.append(this.subscribeInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.data.QQGameSubscribeBusEvent
 * JD-Core Version:    0.7.0.1
 */