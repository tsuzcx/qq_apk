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
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    QLog.d(ForwardMultServerShare.a(), 1, new Object[] { "notifyNormalSendMessage onResult errorCode=", Integer.valueOf(paramInt), ", isTimeOut=", Boolean.valueOf(ForwardMultServerShare.a(this.a)) });
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ForwardStatisticsReporter.a("KEY_STAGE_2_NORMAL_DC2", bool);
      if (!ForwardMultServerShare.a(this.a)) {
        break;
      }
      return;
    }
    if (paramBundle != null)
    {
      long l = paramBundle.getLong("0xdc2_9_sendTime", -1L);
      if (QLog.isColorLevel()) {
        QLog.d(ForwardMultServerShare.a(), 2, new Object[] { "notifyNormalSendMessage currentRequestTime =", Long.valueOf(ForwardMultServerShare.a(this.a)), ", sendStamp = ", Long.valueOf(l) });
      }
      if ((l == -1L) || (l != ForwardMultServerShare.a(this.a)))
      {
        ForwardMultServerShare.a(this.a);
        return;
      }
    }
    ReportController.b(null, "dc00898", "", "", "0X8009C94", "0X8009C94", 0, 0, "" + paramInt, "", "", "");
    paramArrayOfByte = ForwardUtils.a(paramArrayOfByte);
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      QLog.e(ForwardMultServerShare.a(), 1, new Object[] { "notifyNormalSendMessage sendOIDBRequest onResult errorCode != 0 || result == null, errorCode=", Integer.valueOf(paramInt) });
      ForwardMultServerShare.a(this.a);
      return;
    }
    ForwardMultServerShare.a(this.a, paramArrayOfByte);
    ForwardUtils.a(ForwardMultServerShare.a(this.a), paramArrayOfByte, ForwardMultServerShare.a(this.a), ForwardMultServerShare.a(this.a).getString("share_comment_message_for_server"));
  }
  
  public boolean a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QLog.e(ForwardMultServerShare.a(), 1, new Object[] { "notifyNormalSendMessage onError msg =", paramString });
    }
    return super.a(paramInt, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardMultServerShare.4
 * JD-Core Version:    0.7.0.1
 */