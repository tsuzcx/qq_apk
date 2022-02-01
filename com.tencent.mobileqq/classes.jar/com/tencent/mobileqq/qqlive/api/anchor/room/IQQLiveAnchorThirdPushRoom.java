package com.tencent.mobileqq.qqlive.api.anchor.room;

import com.tencent.mobileqq.qqlive.api.room.ILiveTPPlayerRoom;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;

public abstract interface IQQLiveAnchorThirdPushRoom
  extends IQQLiveAnchorRoom, ILiveTPPlayerRoom
{
  public abstract void getRtmpPullUrl(QQLiveAnchorAutoCheckPullPlayParams paramQQLiveAnchorAutoCheckPullPlayParams);
  
  public abstract void getRtmpPushUrl(QQLiveAnchorAutoCheckPullPlayParams paramQQLiveAnchorAutoCheckPullPlayParams);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorThirdPushRoom
 * JD-Core Version:    0.7.0.1
 */