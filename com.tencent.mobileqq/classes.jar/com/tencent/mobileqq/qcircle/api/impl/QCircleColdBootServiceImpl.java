package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.mobileqq.qcircle.api.IQCircleColdBootService;
import com.tencent.mobileqq.qcircle.api.coldboot.IPreloadTask;
import java.lang.reflect.Method;

public class QCircleColdBootServiceImpl
  implements IQCircleColdBootService
{
  private static final String CLASS_NAME = "com.tencent.biz.qqcircle.richframework.preload.coldboot.QCircleColdBootPreloadFeedManager";
  private static final String METHOD_NAME_DO_CLEAR = "doClear";
  private static final String METHOD_NAME_DO_GET_IS_AVAILABLE = "doGetIsAvailable";
  private static final String METHOD_NAME_DO_GET_TASK = "doGetTask";
  private static final String METHOD_NAME_DO_LOCK = "doLock";
  private static final String METHOD_NAME_DO_PREPARE = "doPrepare";
  private static final String METHOD_NAME_DO_RELEASE_INSTANCE = "releaseInstance";
  private static final String METHOD_NAME_DO_UNLOCK = "doUnlock";
  
  private void invokeQCircleColdBootClear(int paramInt)
  {
    try
    {
      Class.forName("com.tencent.biz.qqcircle.richframework.preload.coldboot.QCircleColdBootPreloadFeedManager").getDeclaredMethod("doClear", new Class[] { Integer.TYPE }).invoke(null, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean invokeQCircleColdBootGetIsAvaiable(int paramInt)
  {
    try
    {
      boolean bool = ((Boolean)Class.forName("com.tencent.biz.qqcircle.richframework.preload.coldboot.QCircleColdBootPreloadFeedManager").getDeclaredMethod("doGetIsAvailable", new Class[] { Integer.TYPE }).invoke(null, new Object[] { Integer.valueOf(paramInt) })).booleanValue();
      return bool;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  private IPreloadTask invokeQCircleColdBootGetTask(int paramInt)
  {
    try
    {
      IPreloadTask localIPreloadTask = (IPreloadTask)Class.forName("com.tencent.biz.qqcircle.richframework.preload.coldboot.QCircleColdBootPreloadFeedManager").getDeclaredMethod("doGetTask", new Class[] { Integer.TYPE }).invoke(null, new Object[] { Integer.valueOf(paramInt) });
      return localIPreloadTask;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private void invokeQCircleColdBootLock()
  {
    try
    {
      Class.forName("com.tencent.biz.qqcircle.richframework.preload.coldboot.QCircleColdBootPreloadFeedManager").getDeclaredMethod("doLock", null).invoke(null, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void invokeQCircleColdBootPrepare()
  {
    try
    {
      Class.forName("com.tencent.biz.qqcircle.richframework.preload.coldboot.QCircleColdBootPreloadFeedManager").getDeclaredMethod("doPrepare", null).invoke(null, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void invokeQCircleColdBootReleaseInstance()
  {
    try
    {
      Class.forName("com.tencent.biz.qqcircle.richframework.preload.coldboot.QCircleColdBootPreloadFeedManager").getDeclaredMethod("releaseInstance", null).invoke(null, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void invokeQCircleColdBootUnlock()
  {
    try
    {
      Class.forName("com.tencent.biz.qqcircle.richframework.preload.coldboot.QCircleColdBootPreloadFeedManager").getDeclaredMethod("doUnlock", null).invoke(null, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void clear(int paramInt)
  {
    invokeQCircleColdBootClear(paramInt);
  }
  
  public IPreloadTask getTask(int paramInt)
  {
    return invokeQCircleColdBootGetTask(paramInt);
  }
  
  public boolean isAvailable(int paramInt)
  {
    return invokeQCircleColdBootGetIsAvaiable(paramInt);
  }
  
  public void lock()
  {
    invokeQCircleColdBootLock();
  }
  
  public void prepare()
  {
    invokeQCircleColdBootPrepare();
  }
  
  public void release()
  {
    invokeQCircleColdBootReleaseInstance();
  }
  
  public void unlock()
  {
    invokeQCircleColdBootUnlock();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.QCircleColdBootServiceImpl
 * JD-Core Version:    0.7.0.1
 */