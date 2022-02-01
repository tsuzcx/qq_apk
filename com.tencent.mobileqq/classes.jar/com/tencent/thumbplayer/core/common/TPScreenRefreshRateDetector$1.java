package com.tencent.thumbplayer.core.common;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Display;
import android.view.Display.Mode;

final class TPScreenRefreshRateDetector$1
  extends Handler
{
  TPScreenRefreshRateDetector$1(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      if (TPScreenRefreshRateDetector.access$000() != null)
      {
        Display localDisplay = TPScreenRefreshRateDetector.access$000().getDisplay(0);
        String str = localDisplay.getMode().toString();
        TPNativeLog.printLog(2, TPScreenRefreshRateDetector.access$100(), "handleMessage DISPLAY_CHANGE, mode:" + str.toString());
        TPScreenRefreshRateDetector.access$200(localDisplay.getMode().getRefreshRate());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPScreenRefreshRateDetector.1
 * JD-Core Version:    0.7.0.1
 */