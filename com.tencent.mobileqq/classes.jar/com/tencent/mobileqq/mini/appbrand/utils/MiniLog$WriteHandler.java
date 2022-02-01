package com.tencent.mobileqq.mini.appbrand.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.concurrent.LinkedBlockingQueue;

class MiniLog$WriteHandler
  extends Handler
{
  private MiniLog$WriteHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      if (!MiniLog.access$400().isEmpty()) {
        ThreadManager.excute(new MiniLog.WriteHandler.2(this), 64, null, false);
      }
    }
    else if ((MiniLog.access$100() != null) && (MiniLog.access$200() != null))
    {
      ThreadManager.excute(new MiniLog.WriteHandler.1(this), 64, null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.MiniLog.WriteHandler
 * JD-Core Version:    0.7.0.1
 */