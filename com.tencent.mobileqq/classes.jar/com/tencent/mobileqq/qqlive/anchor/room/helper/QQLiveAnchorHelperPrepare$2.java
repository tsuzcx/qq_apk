package com.tencent.mobileqq.qqlive.anchor.room.helper;

import android.app.Activity;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomPrepare;
import com.tencent.mobileqq.qqlive.callback.verified.QQLiveVerifyCallback;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataAuth;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPrepare;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.qphone.base.util.QLog;

class QQLiveAnchorHelperPrepare$2
  implements QQLiveVerifyCallback
{
  QQLiveAnchorHelperPrepare$2(QQLiveAnchorHelperPrepare paramQQLiveAnchorHelperPrepare, IQQLiveAnchorRoomPrepare paramIQQLiveAnchorRoomPrepare, Activity paramActivity, IQQLiveSDK paramIQQLiveSDK) {}
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onVerifyFinish] code + ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", message:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QQLiveAnchor_Prepare", 1, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 0)
    {
      this.a.a(new QQLiveAnchorDataAuth(true, null));
      this.d.a(this.b, this.c, this.a);
      return;
    }
    Object localObject = new QQLiveErrorMsg();
    ((QQLiveErrorMsg)localObject).bizModule = 2;
    ((QQLiveErrorMsg)localObject).bizErrCode = 6210;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("auth error: ");
    localStringBuilder.append(paramString);
    ((QQLiveErrorMsg)localObject).bizErrMsg = localStringBuilder.toString();
    ((QQLiveErrorMsg)localObject).originErrCode = paramInt;
    this.a.a(new QQLiveAnchorDataAuth(false, (QQLiveErrorMsg)localObject));
    this.a.a(new QQLiveAnchorDataPrepare(false, (QQLiveErrorMsg)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperPrepare.2
 * JD-Core Version:    0.7.0.1
 */