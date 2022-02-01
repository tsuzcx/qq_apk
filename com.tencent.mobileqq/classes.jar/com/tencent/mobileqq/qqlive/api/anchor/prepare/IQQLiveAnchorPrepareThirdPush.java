package com.tencent.mobileqq.qqlive.api.anchor.prepare;

import android.view.ViewGroup;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;

public abstract interface IQQLiveAnchorPrepareThirdPush
  extends IQQLiveAnchorPrepareSubModule
{
  public abstract void getPullInfo(QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo, QQLiveAnchorAutoCheckPullPlayParams paramQQLiveAnchorAutoCheckPullPlayParams, IQQLiveAnchorRoomThirdPushCallback paramIQQLiveAnchorRoomThirdPushCallback);
  
  public abstract void getPushInfo(QQLiveAnchorRoomInfo paramQQLiveAnchorRoomInfo, QQLiveAnchorAutoCheckPullPlayParams paramQQLiveAnchorAutoCheckPullPlayParams, IQQLiveAnchorRoomThirdPushCallback paramIQQLiveAnchorRoomThirdPushCallback);
  
  public abstract void setPreViewContainer(ViewGroup paramViewGroup);
  
  public abstract void startCheck(String paramString, QQLiveAnchorAutoCheckPullPlayParams paramQQLiveAnchorAutoCheckPullPlayParams, IQQLiveAnchorRoomThirdPushCallback paramIQQLiveAnchorRoomThirdPushCallback);
  
  public abstract void stopCheck();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareThirdPush
 * JD-Core Version:    0.7.0.1
 */