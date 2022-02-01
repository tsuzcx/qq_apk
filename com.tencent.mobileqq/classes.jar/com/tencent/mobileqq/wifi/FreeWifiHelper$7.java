package com.tencent.mobileqq.wifi;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.wifisdk.TMSDKCustomConfig.IThreadPoolManager;

final class FreeWifiHelper$7
  implements TMSDKCustomConfig.IThreadPoolManager
{
  public void addTask(int paramInt, Runnable paramRunnable, String paramString)
  {
    ThreadManagerV2.excute(paramRunnable, 16, null, false);
  }
  
  public void addTypeTask(Runnable paramRunnable, int paramInt)
  {
    int i = 16;
    if (paramInt == 3) {
      i = 64;
    }
    for (;;)
    {
      ThreadManagerV2.excute(paramRunnable, i, null, false);
      return;
      if (paramInt == 4) {
        i = 128;
      } else if (paramInt == 2) {
        i = 32;
      }
    }
  }
  
  public Looper getSubThreadLooper()
  {
    return ThreadManagerV2.getSubThreadLooper();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.FreeWifiHelper.7
 * JD-Core Version:    0.7.0.1
 */