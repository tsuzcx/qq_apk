package com.tencent.mobileqq.qqlive.callback.anchor;

import com.tencent.mobileqq.qqlive.api.anchor.QQLiveAnchorRoomState;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;

public abstract interface IQQLiveAnchorRoomBase
{
  public abstract void a(QQLiveAnchorRoomState paramQQLiveAnchorRoomState1, QQLiveAnchorRoomState paramQQLiveAnchorRoomState2);
  
  public abstract void a(QQLiveErrorMsg paramQQLiveErrorMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomBase
 * JD-Core Version:    0.7.0.1
 */