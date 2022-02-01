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
    if (paramInt == 3) {
      paramInt = 64;
    } else if (paramInt == 4) {
      paramInt = 128;
    } else if (paramInt == 2) {
      paramInt = 32;
    } else {
      paramInt = 16;
    }
    ThreadManagerV2.excute(paramRunnable, paramInt, null, false);
  }
  
  public Looper getSubThreadLooper()
  {
    return ThreadManagerV2.getSubThreadLooper();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.wifi.FreeWifiHelper.7
 * JD-Core Version:    0.7.0.1
 */