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
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ForwardStatisticsReporter.a("KEY_STAGE_2_IMAGE_DC2", bool);
      if (paramBundle == null) {
        break;
      }
      long l = paramBundle.getLong("0xdc2_9_sendTime", -1L);
      if (QLog.isColorLevel()) {
        QLog.d(ForwardMultServerShare.a(), 2, new Object[] { "notifyImageSendMessage onResult currentRequestTime =", Long.valueOf(ForwardMultServerShare.a(this.a)), ", sendStamp = ", Long.valueOf(l) });
      }
      if ((l != -1L) && (l == ForwardMultServerShare.a(this.a))) {
        break;
      }
      ForwardMultServerShare.a(this.a);
      return;
    }
    paramArrayOfByte = ForwardUtils.a(paramArrayOfByte);
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      QLog.e(ForwardMultServerShare.a(), 1, new Object[] { "notifyImageSendMessage onResult error errorCode != 0 || result == null, errorCode=", Integer.valueOf(paramInt) });
      ForwardMultServerShare.a(this.a);
      return;
    }
    ForwardMultServerShare.a(this.a, paramArrayOfByte);
    ForwardUtils.a(ForwardMultServerShare.a(this.a), paramArrayOfByte, ForwardMultServerShare.a(this.a), ForwardMultServerShare.a(this.a).getString("share_comment_message_for_server"));
  }
  
  public boolean a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (!TextUtils.isEmpty(paramString)) {
      QLog.e(ForwardMultServerShare.a(), 1, "notifyImageSendMessage onError msg =" + paramString);
    }
    return super.a(paramInt, paramString, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardMultServerShare.3
 * JD-Core Version:    0.7.0.1
 */