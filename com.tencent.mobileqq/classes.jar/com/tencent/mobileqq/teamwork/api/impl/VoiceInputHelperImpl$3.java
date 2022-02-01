package com.tencent.mobileqq.teamwork.api.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class VoiceInputHelperImpl$3
  extends Handler
{
  VoiceInputHelperImpl$3(VoiceInputHelperImpl paramVoiceInputHelperImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    if (!VoiceInputHelperImpl.access$400(this.a))
    {
      QLog.e("VoiceInputHelperImpl", 1, "checkPermission uncertain");
      this.a.onGetError(1830002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.VoiceInputHelperImpl.3
 * JD-Core Version:    0.7.0.1
 */