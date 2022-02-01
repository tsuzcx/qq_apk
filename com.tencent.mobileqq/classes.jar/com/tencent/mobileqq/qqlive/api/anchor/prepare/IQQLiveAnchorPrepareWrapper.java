package com.tencent.mobileqq.qqlive.api.anchor.prepare;

import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataRoomAttr;

public abstract interface IQQLiveAnchorPrepareWrapper
{
  public abstract void destroy();
  
  public abstract QQLiveAnchorRoomInfo getRoomInfo();
  
  public abstract IQQLiveAnchorPrepareScreenRecord getScreenRecordModule();
  
  public abstract IQQLiveAnchorPrepareThirdPush getThirdPushModule(ViewGroup paramViewGroup);
  
  public abstract void init(IQQLiveSDK paramIQQLiveSDK, long paramLong, String paramString);
  
  public abstract void prepare(Activity paramActivity, IQQLiveAnchorRoomThirdPushCallback paramIQQLiveAnchorRoomThirdPushCallback);
  
  public abstract void set(QQLiveAnchorDataRoomAttr paramQQLiveAnchorDataRoomAttr, IQQLiveAnchorRoomThirdPushCallback paramIQQLiveAnchorRoomThirdPushCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareWrapper
 * JD-Core Version:    0.7.0.1
 */