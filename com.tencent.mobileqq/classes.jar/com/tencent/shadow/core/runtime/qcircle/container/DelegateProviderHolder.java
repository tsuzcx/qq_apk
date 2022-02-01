package com.tencent.shadow.core.runtime.qcircle.container;

import android.os.SystemClock;

public class DelegateProviderHolder
{
  private static DelegateProvider delegateProvider;
  public static long sCustomPid = ;
  
  public static DelegateProvider getDelegateProvider()
  {
    return delegateProvider;
  }
  
  public static void setDelegateProvider(DelegateProvider paramDelegateProvider)
  {
    delegateProvider = paramDelegateProvider;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.shadow.core.runtime.qcircle.container.DelegateProviderHolder
 * JD-Core Version:    0.7.0.1
 */