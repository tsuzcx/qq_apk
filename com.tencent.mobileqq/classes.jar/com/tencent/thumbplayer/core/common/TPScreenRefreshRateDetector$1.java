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
    if ((paramMessage.what == 10001) && (TPScreenRefreshRateDetector.access$000() != null))
    {
      Display localDisplay = TPScreenRefreshRateDetector.access$000().getDisplay(0);
      String str1 = localDisplay.getMode().toString();
      String str2 = TPScreenRefreshRateDetector.access$100();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMessage DISPLAY_CHANGE, mode:");
      localStringBuilder.append(str1.toString());
      TPNativeLog.printLog(2, str2, localStringBuilder.toString());
      TPScreenRefreshRateDetector.access$200(localDisplay.getMode().getRefreshRate());
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPScreenRefreshRateDetector.1
 * JD-Core Version:    0.7.0.1
 */