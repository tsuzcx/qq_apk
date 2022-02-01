package com.tencent.mobileqq.qqlive.anchor.room.helper;

import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPush;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.qphone.base.util.QLog;

class QQLiveAnchorThirdPushChecker$1
  extends AudienceRoomPlayerBaseListener
{
  QQLiveAnchorThirdPushChecker$1(QQLiveAnchorThirdPushChecker paramQQLiveAnchorThirdPushChecker, String paramString, IQQLiveAnchorRoomThirdPush paramIQQLiveAnchorRoomThirdPush) {}
  
  public void onError(int paramInt, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onError, errorCode:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", msg:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", url: ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("QQLiveAnchor_tpChecker", 1, ((StringBuilder)localObject).toString());
    }
    if (QQLiveAnchorThirdPushChecker.a(this.c)) {
      return;
    }
    try
    {
      localObject = new QQLiveErrorMsg();
      ((QQLiveErrorMsg)localObject).bizModule = 2;
      ((QQLiveErrorMsg)localObject).bizErrCode = 6270;
      ((QQLiveErrorMsg)localObject).bizErrMsg = "player error";
      ((QQLiveErrorMsg)localObject).originErrCode = paramInt;
      ((QQLiveErrorMsg)localObject).originErrMsg = paramString;
      this.b.a(new QQLiveAnchorDataThirdPushCheck(false, (QQLiveErrorMsg)localObject));
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("QQLiveAnchor_tpChecker", 1, paramString, new Object[0]);
    }
  }
  
  public void onFirstFrameCome()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFirstFrameCome, url: ");
      localStringBuilder.append(this.a);
      QLog.d("QQLiveAnchor_tpChecker", 1, localStringBuilder.toString());
    }
    if (QQLiveAnchorThirdPushChecker.a(this.c)) {
      return;
    }
    try
    {
      this.b.a(new QQLiveAnchorDataThirdPushCheck(true, null));
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQLiveAnchor_tpChecker", 1, localThrowable, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorThirdPushChecker.1
 * JD-Core Version:    0.7.0.1
 */