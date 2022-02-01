package com.tencent.mobileqq.qqlive.callback.anchor;

import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;

public abstract interface IQQLiveAnchorRoomGetPullUrl
  extends IQQLiveAnchorRoomBase
{
  public abstract void a(QQLiveAnchorDataPullInfo paramQQLiveAnchorDataPullInfo);
  
  public abstract void a(QQLiveAnchorDataThirdPushCheck paramQQLiveAnchorDataThirdPushCheck);
  
  public abstract void j();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomGetPullUrl
 * JD-Core Version:    0.7.0.1
 */