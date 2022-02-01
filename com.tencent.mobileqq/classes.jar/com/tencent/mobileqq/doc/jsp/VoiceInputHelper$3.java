package com.tencent.mobileqq.doc.jsp;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class VoiceInputHelper$3
  extends Handler
{
  VoiceInputHelper$3(VoiceInputHelper paramVoiceInputHelper, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while (VoiceInputHelper.c(this.a));
    QLog.e("VoiceInputHelper", 1, "checkPermission uncertain");
    this.a.onGetError(1830002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doc.jsp.VoiceInputHelper.3
 * JD-Core Version:    0.7.0.1
 */