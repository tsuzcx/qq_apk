package com.tencent.qqmini.sdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
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
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while (MiniLog.access$100().isEmpty());
    ThreadManager.executeOnDiskIOThreadPool(new MiniLog.WriteHandler.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.MiniLog.WriteHandler
 * JD-Core Version:    0.7.0.1
 */