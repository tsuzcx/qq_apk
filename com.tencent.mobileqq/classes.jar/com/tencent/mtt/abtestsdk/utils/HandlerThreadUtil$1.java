package com.tencent.mtt.abtestsdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mtt.abtestsdk.ABTest.ABTestManager;

final class HandlerThreadUtil$1
  extends Handler
{
  HandlerThreadUtil$1(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null)
    {
      ABTestLog.warn("msg is null", new Object[0]);
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      HandlerThreadUtil.access$000().removeMessages(0);
      ABTestLog.stepUpload("update data for 10s", new Object[0]);
      ABTestManager.getInstance().doGetSourceExperiments(null, 0);
      HandlerThreadUtil.access$000().sendEmptyMessageDelayed(0, 10000L);
      return;
    }
    ABTestLog.stepUpload("stop update data", new Object[0]);
    HandlerThreadUtil.access$000().removeMessages(0);
    HandlerThreadUtil.access$100().quit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.utils.HandlerThreadUtil.1
 * JD-Core Version:    0.7.0.1
 */