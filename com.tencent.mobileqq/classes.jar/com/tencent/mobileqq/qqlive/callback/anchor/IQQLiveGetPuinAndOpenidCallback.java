package com.tencent.mobileqq.qqlive.callback.anchor;

import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorPuinAndOpenid;

public abstract interface IQQLiveGetPuinAndOpenidCallback
{
  public abstract void onFail(int paramInt, String paramString);
  
  public abstract void onSuccess(QQLiveAnchorPuinAndOpenid paramQQLiveAnchorPuinAndOpenid);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveGetPuinAndOpenidCallback
 * JD-Core Version:    0.7.0.1
 */