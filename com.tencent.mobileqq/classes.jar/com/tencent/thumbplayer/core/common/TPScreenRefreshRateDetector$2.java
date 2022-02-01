package com.tencent.thumbplayer.core.common;

import android.hardware.display.DisplayManager.DisplayListener;
import android.os.Handler;

final class TPScreenRefreshRateDetector$2
  implements DisplayManager.DisplayListener
{
  public void onDisplayAdded(int paramInt) {}
  
  public void onDisplayChanged(int paramInt)
  {
    if (paramInt == 0) {
      TPScreenRefreshRateDetector.access$300().sendEmptyMessage(10001);
    }
    String str = TPScreenRefreshRateDetector.access$100();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDisplayChanged displayId:");
    localStringBuilder.append(paramInt);
    TPNativeLog.printLog(2, str, localStringBuilder.toString());
  }
  
  public void onDisplayRemoved(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.core.common.TPScreenRefreshRateDetector.2
 * JD-Core Version:    0.7.0.1
 */