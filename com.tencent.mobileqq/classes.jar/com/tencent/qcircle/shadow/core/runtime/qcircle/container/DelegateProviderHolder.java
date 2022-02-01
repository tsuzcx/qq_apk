package com.tencent.qcircle.shadow.core.runtime.qcircle.container;

import android.os.SystemClock;
import java.util.HashMap;

public class DelegateProviderHolder
{
  public static long sCustomPid = SystemClock.elapsedRealtime();
  private static HashMap<String, DelegateProvider> sDelegateMap = new HashMap();
  
  public static DelegateProvider getDelegateProvider(String paramString)
  {
    return (DelegateProvider)sDelegateMap.get(paramString);
  }
  
  public static void setDelegateProvider(String paramString, DelegateProvider paramDelegateProvider)
  {
    sDelegateMap.put(paramString, paramDelegateProvider);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.shadow.core.runtime.qcircle.container.DelegateProviderHolder
 * JD-Core Version:    0.7.0.1
 */