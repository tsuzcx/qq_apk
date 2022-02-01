package com.tencent.mobileqq.forward;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.qphone.base.util.QLog;

class ForwardMultServerShare$3
  extends ProtoUtils.TroopProtocolObserver
{
  ForwardMultServerShare$3(ForwardMultServerShare paramForwardMultServerShare) {}
  
  public boolean onError(int paramInt, String paramString, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String str = ForwardMultServerShare.d();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyImageSendMessage onError msg =");
      localStringBuilder.append(paramString);
      QLog.e(str, 1, localStringBuilder.toString());
    }
    return super.onError(paramInt, paramString, paramBundle);
  }
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ForwardStatisticsReporter.a("KEY_STAGE_2_IMAGE_DC2", bool);
    if (paramBundle != null)
    {
      long l = paramBundle.getLong("0xdc2_9_sendTime", -1L);
      if (QLog.isColorLevel()) {
        QLog.d(ForwardMultServerShare.d(), 2, new Object[] { "notifyImageSendMessage onResult currentRequestTime =", Long.valueOf(ForwardMultServerShare.f(this.a)), ", sendStamp = ", Long.valueOf(l) });
      }
      if ((l == -1L) || (l != ForwardMultServerShare.f(this.a)))
      {
        ForwardMultServerShare.c(this.a);
        return;
      }
    }
    paramArrayOfByte = ForwardUtils.b(paramArrayOfByte);
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      ForwardMultServerShare.a(this.a, paramArrayOfByte);
      ForwardMultServerShare.b(this.a, paramArrayOfByte);
      return;
    }
    QLog.e(ForwardMultServerShare.d(), 1, new Object[] { "notifyImageSendMessage onResult error errorCode != 0 || result == null, errorCode=", Integer.valueOf(paramInt) });
    ForwardMultServerShare.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardMultServerShare.3
 * JD-Core Version:    0.7.0.1
 */