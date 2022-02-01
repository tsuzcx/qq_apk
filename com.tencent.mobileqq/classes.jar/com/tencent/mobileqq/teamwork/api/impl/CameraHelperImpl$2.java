package com.tencent.mobileqq.teamwork.api.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class CameraHelperImpl$2
  extends Handler
{
  CameraHelperImpl$2(CameraHelperImpl paramCameraHelperImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return;
    }
    if (!CameraHelperImpl.access$200(this.a))
    {
      QLog.e("CameraHelperImpl", 1, "checkPermission uncertain");
      CameraHelperImpl.access$100(this.a, false, 1830004);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.CameraHelperImpl.2
 * JD-Core Version:    0.7.0.1
 */