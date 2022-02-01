package com.tencent.mobileqq.doc.jsp;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;

class CameraHelper$2
  extends Handler
{
  CameraHelper$2(CameraHelper paramCameraHelper, Looper paramLooper)
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
    } while (CameraHelper.a(this.a));
    QLog.e("CameraHelper", 1, "checkPermission uncertain");
    CameraHelper.a(this.a, false, 1830004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doc.jsp.CameraHelper.2
 * JD-Core Version:    0.7.0.1
 */