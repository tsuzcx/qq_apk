package com.tencent.qqperf.monitor.heldthread;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqMessageQueue;
import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;

final class LooperMonitorHelper$1
  implements AbstractUnifiedMonitor.ThreadMonitorCallback
{
  public void onThreadMonitorEnd(int paramInt)
  {
    if (paramInt == 0)
    {
      Looper.getMainLooper().setMessageLogging(null);
      MqqMessageQueue.getSubMainThreadQueue().setMessageLogging(null);
      return;
    }
    if (paramInt == 4)
    {
      ThreadManager.getSubThreadLooper().setMessageLogging(null);
      return;
    }
    if (paramInt == 5)
    {
      ThreadManager.getFileThreadLooper().setMessageLogging(null);
      return;
    }
    if (paramInt == 14)
    {
      Looper.getMainLooper().setMessageLogging(null);
      return;
    }
    if (paramInt == 18)
    {
      Object localObject = MsfCore.sCore;
      if (localObject == null)
      {
        QLog.e("MagnifierSDK.QAPM", 1, "msf core hasnot init");
        return;
      }
      localObject = ((MsfCore)localObject).getNetworkHandlerThread();
      if ((localObject != null) && (((HandlerThread)localObject).getLooper() != null)) {
        ((HandlerThread)localObject).getLooper().setMessageLogging(null);
      }
    }
    else if (paramInt == 19)
    {
      Looper.getMainLooper().setMessageLogging(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.heldthread.LooperMonitorHelper.1
 * JD-Core Version:    0.7.0.1
 */