package com.tencent.mobileqq.qqlive.anchor.room.helper;

import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback;
import com.tencent.qphone.base.util.QLog;

class QQLiveAnchorHelperTRTC$1
  implements TRTCInitCallback
{
  QQLiveAnchorHelperTRTC$1(QQLiveAnchorHelperTRTC paramQQLiveAnchorHelperTRTC, QQLiveAnchorHelperTRTC.Callback paramCallback) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("trtc init:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("QQLiveAnchor_TRTC", 1, ((StringBuilder)localObject).toString());
    }
    if (paramInt1 == 2)
    {
      this.b.a = true;
      this.a.a();
      return;
    }
    if (paramInt1 == 3)
    {
      this.b.a = false;
      localObject = new QQLiveErrorMsg();
      ((QQLiveErrorMsg)localObject).bizModule = 2;
      ((QQLiveErrorMsg)localObject).bizErrCode = 6101;
      ((QQLiveErrorMsg)localObject).bizErrMsg = "trtc init failed";
      ((QQLiveErrorMsg)localObject).originErrCode = paramInt2;
      ((QQLiveErrorMsg)localObject).originErrMsg = "";
      this.a.a((QQLiveErrorMsg)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperTRTC.1
 * JD-Core Version:    0.7.0.1
 */