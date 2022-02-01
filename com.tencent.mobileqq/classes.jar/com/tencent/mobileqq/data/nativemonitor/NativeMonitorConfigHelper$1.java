package com.tencent.mobileqq.data.nativemonitor;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nativememorymonitor.library.ExternalProvider;

final class NativeMonitorConfigHelper$1
  implements ExternalProvider
{
  public void onSoLoad(String paramString1, String paramString2)
  {
    ThreadManager.excute(new NativeMonitorConfigHelper.1.1(this, paramString1, paramString2), 64, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper.1
 * JD-Core Version:    0.7.0.1
 */