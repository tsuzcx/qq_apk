package com.tencent.mobileqq.qqlive.api.impl.anchor;

import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveGetAnchorPageUrlCallback;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveGetPuinAndOpenidCallback;
import com.tencent.mobileqq.qqlive.config.QQLiveConfigBean;
import com.tencent.mobileqq.qqlive.config.QQLiveConfigProcessor;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorPuinAndOpenid;
import com.tencent.qphone.base.util.QLog;

class QQLiveAnchorPageServiceImpl$1
  implements IQQLiveGetPuinAndOpenidCallback
{
  QQLiveAnchorPageServiceImpl$1(QQLiveAnchorPageServiceImpl paramQQLiveAnchorPageServiceImpl, long paramLong, IQQLiveGetAnchorPageUrlCallback paramIQQLiveGetAnchorPageUrlCallback) {}
  
  public void onFail(int paramInt, String paramString)
  {
    IQQLiveGetAnchorPageUrlCallback localIQQLiveGetAnchorPageUrlCallback = this.val$callback;
    if (localIQQLiveGetAnchorPageUrlCallback != null) {
      localIQQLiveGetAnchorPageUrlCallback.a(paramInt, paramString);
    }
  }
  
  public void onSuccess(QQLiveAnchorPuinAndOpenid paramQQLiveAnchorPuinAndOpenid)
  {
    Object localObject = QQLiveConfigProcessor.a().a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQQLiveAnchorPuinAndOpenid.pgcPuin);
    localStringBuilder.append("");
    localObject = ((String)localObject).replace("{pUin}", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramQQLiveAnchorPuinAndOpenid.pgcOpenid);
    localStringBuilder.append("");
    paramQQLiveAnchorPuinAndOpenid = ((String)localObject).replace("{anchorOpenId}", localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.val$anchorUid);
    ((StringBuilder)localObject).append("");
    paramQQLiveAnchorPuinAndOpenid = paramQQLiveAnchorPuinAndOpenid.replace("{anchorUid}", ((StringBuilder)localObject).toString());
    localObject = this.val$callback;
    if (localObject != null) {
      ((IQQLiveGetAnchorPageUrlCallback)localObject).a(paramQQLiveAnchorPuinAndOpenid);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("IQQLiveGetAnchorPageUrlCallback :");
      ((StringBuilder)localObject).append(paramQQLiveAnchorPuinAndOpenid);
      QLog.i("QQLiveFansServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.anchor.QQLiveAnchorPageServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */