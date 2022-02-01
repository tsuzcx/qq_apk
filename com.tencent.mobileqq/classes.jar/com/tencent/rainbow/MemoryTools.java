package com.tencent.rainbow;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;

public class MemoryTools
{
  public long getApplicationMemory()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      return Debug.getPss();
    }
    long l = -1L;
    try
    {
      Context localContext = RainbowPlugin.sContext;
      if (localContext != null)
      {
        int i = ((android.app.ActivityManager)localContext.getSystemService("activity")).getProcessMemoryInfo(new int[] { android.os.Process.myPid() })[0].getTotalPss();
        l = i;
      }
      return l;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1L;
  }
  
  public long getUsedMemory()
  {
    return getApplicationMemory() / 1024L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.rainbow.MemoryTools
 * JD-Core Version:    0.7.0.1
 */