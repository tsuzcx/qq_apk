package com.tencent.mobileqq.forward;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class ForwardMultServerShare$4
  extends ProtoUtils.TroopProtocolObserver
{
  ForwardMultServerShare$4(ForwardMultServerShare paramForwardMultServerShare) {}
  
  public boolean onError(int paramInt, String paramString, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QLog.e(ForwardMultServerShare.d(), 1, new Object[] { "notifyNormalSendMessage onError msg =", paramString });
    }
    return super.onError(paramInt, paramString, paramBundle);
  }
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.d(ForwardMultServerShare.d(), 1, new Object[] { "notifyNormalSendMessage onResult errorCode=", Integer.valueOf(paramInt), ", isTimeOut=", Boolean.valueOf(ForwardMultServerShare.a(this.a)) });
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ForwardStatisticsReporter.a("KEY_STAGE_2_NORMAL_DC2", bool);
    if (ForwardMultServerShare.a(this.a)) {
      return;
    }
    if (paramBundle != null)
    {
      long l = paramBundle.getLong("0xdc2_9_sendTime", -1L);
      if (QLog.isColorLevel()) {
        QLog.d(ForwardMultServerShare.d(), 2, new Object[] { "notifyNormalSendMessage currentRequestTime =", Long.valueOf(ForwardMultServerShare.f(this.a)), ", sendStamp = ", Long.valueOf(l) });
      }
      if ((l == -1L) || (l != ForwardMultServerShare.f(this.a)))
      {
        ForwardMultServerShare.c(this.a);
        return;
      }
    }
    paramBundle = new StringBuilder();
    paramBundle.append("");
    paramBundle.append(paramInt);
    ReportController.b(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, paramBundle.toString(), "", "", "");
    paramArrayOfByte = ForwardUtils.b(paramArrayOfByte);
    if ((paramInt == 0) && (paramArrayOfByte != null))
    {
      ForwardMultServerShare.a(this.a, paramArrayOfByte);
      ForwardMultServerShare.b(this.a, paramArrayOfByte);
      return;
    }
    QLog.e(ForwardMultServerShare.d(), 1, new Object[] { "notifyNormalSendMessage sendOIDBRequest onResult errorCode != 0 || result == null, errorCode=", Integer.valueOf(paramInt) });
    ForwardMultServerShare.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardMultServerShare.4
 * JD-Core Version:    0.7.0.1
 */