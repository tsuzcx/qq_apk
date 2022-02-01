package com.tencent.mobileqq.flashshow.api.impl;

import com.tencent.mobileqq.flashshow.api.IFlashShowColdBootService;
import java.lang.reflect.Method;

public class FlashShowColdBootServiceImpl
  implements IFlashShowColdBootService
{
  private static final String CLASS_NAME = "com.tencent.mobileqq.flashshow.preload.coldboot.FSColdBootPreloadFeedManager";
  private static final String METHOD_NAME_DO_ACTIVATE = "doActivate";
  private static final String METHOD_NAME_DO_GET_ATTACHINFO = "doGetAttachInfo";
  private static final String METHOD_NAME_DO_GET_IS_AVAILABLE = "doGetIsAvailable";
  private static final String METHOD_NAME_DO_INACTIVATE = "doInactivate";
  private static final String METHOD_NAME_DO_INIT = "doInit";
  private static final String METHOD_NAME_DO_PRELOAD = "doPreload";
  private static final String METHOD_NAME_DO_PRELOAD_RSP_DATA = "doGetPreloadRspData";
  private static final String METHOD_NAME_DO_RELEASE_INSTANCE = "releaseInstance";
  private static final String METHOD_NAME_DO_UNLOCK = "doUnlock";
  private boolean mHasInit = false;
  
  private void invokeFSColdBootActivate()
  {
    try
    {
      Class.forName("com.tencent.mobileqq.flashshow.preload.coldboot.FSColdBootPreloadFeedManager").getDeclaredMethod("doActivate", null).invoke(null, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private String invokeFSColdBootGetAttachInfo()
  {
    try
    {
      String str = (String)Class.forName("com.tencent.mobileqq.flashshow.preload.coldboot.FSColdBootPreloadFeedManager").getDeclaredMethod("doGetAttachInfo", null).invoke(null, new Object[0]);
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  private boolean invokeFSColdBootGetIsAvaiable()
  {
    try
    {
      boolean bool = ((Boolean)Class.forName("com.tencent.mobileqq.flashshow.preload.coldboot.FSColdBootPreloadFeedManager").getDeclaredMethod("doGetIsAvailable", null).invoke(null, new Object[0])).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  private byte[] invokeFSColdBootGetPreloadRspData()
  {
    try
    {
      byte[] arrayOfByte = (byte[])Class.forName("com.tencent.mobileqq.flashshow.preload.coldboot.FSColdBootPreloadFeedManager").getDeclaredMethod("doGetPreloadRspData", null).invoke(null, new Object[0]);
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private void invokeFSColdBootInactivate()
  {
    try
    {
      Class.forName("com.tencent.mobileqq.flashshow.preload.coldboot.FSColdBootPreloadFeedManager").getDeclaredMethod("doInactivate", null).invoke(null, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void invokeFSColdBootInit()
  {
    try
    {
      Class.forName("com.tencent.mobileqq.flashshow.preload.coldboot.FSColdBootPreloadFeedManager").getDeclaredMethod("doInit", null).invoke(null, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void invokeFSColdBootPreload()
  {
    try
    {
      Class.forName("com.tencent.mobileqq.flashshow.preload.coldboot.FSColdBootPreloadFeedManager").getDeclaredMethod("doPreload", null).invoke(null, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void invokeFSColdBootReleaseInstance()
  {
    try
    {
      Class.forName("com.tencent.mobileqq.flashshow.preload.coldboot.FSColdBootPreloadFeedManager").getDeclaredMethod("releaseInstance", null).invoke(null, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void invokeFSColdBootUnlock()
  {
    try
    {
      Class.forName("com.tencent.mobileqq.flashshow.preload.coldboot.FSColdBootPreloadFeedManager").getDeclaredMethod("doUnlock", null).invoke(null, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void activate()
  {
    invokeFSColdBootActivate();
  }
  
  public String doGetAttachInfo()
  {
    return invokeFSColdBootGetAttachInfo();
  }
  
  public byte[] doGetPreloadRspData()
  {
    return invokeFSColdBootGetPreloadRspData();
  }
  
  public void doPreload()
  {
    invokeFSColdBootPreload();
  }
  
  public void inactivate()
  {
    invokeFSColdBootInactivate();
  }
  
  public void init()
  {
    if (!this.mHasInit)
    {
      invokeFSColdBootInit();
      this.mHasInit = true;
    }
  }
  
  public boolean isAvailable()
  {
    return invokeFSColdBootGetIsAvaiable();
  }
  
  public void release()
  {
    invokeFSColdBootReleaseInstance();
  }
  
  public void unlock()
  {
    invokeFSColdBootUnlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.api.impl.FlashShowColdBootServiceImpl
 * JD-Core Version:    0.7.0.1
 */