package com.tencent.mobileqq.intervideo.impl;

import com.tencent.mobileqq.intervideo.IPluginEnterManager;
import com.tencent.mobileqq.intervideo.shadow.PluginProcessKiller;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;

public class PluginEnterManagerImpl
  implements IPluginEnterManager
{
  private static PluginEnterManagerImpl sInstance = new PluginEnterManagerImpl();
  private PluginProcessKiller mLastListener;
  private DynamicPluginManager mLastPluginManager;
  private String sLatestOpenType;
  
  public static PluginEnterManagerImpl getInstance()
  {
    return sInstance;
  }
  
  private void switchBiz(String paramString, DynamicPluginManager paramDynamicPluginManager, PluginProcessKiller paramPluginProcessKiller)
  {
    int j = 1;
    int i;
    if ((paramString != null) && (paramString.equals("Now"))) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject = this.sLatestOpenType;
    if ((localObject == null) || (!((String)localObject).equals("Now"))) {
      j = 0;
    }
    if (i == 0)
    {
      if (j != 0) {
        return;
      }
      if ((paramString != null) && (!paramString.equals(this.sLatestOpenType)))
      {
        localObject = this.mLastPluginManager;
        if (localObject != null)
        {
          localObject = (PluginProcessKiller)((DynamicPluginManager)localObject).getManagerImpl();
          if (localObject != null) {
            ((PluginProcessKiller)localObject).onKillPluginProcess();
          }
        }
        localObject = this.mLastListener;
        if (localObject != null) {
          ((PluginProcessKiller)localObject).onKillPluginProcess();
        }
      }
      this.sLatestOpenType = paramString;
      this.mLastPluginManager = paramDynamicPluginManager;
      this.mLastListener = paramPluginProcessKiller;
    }
  }
  
  public String getLastBizType()
  {
    return this.sLatestOpenType;
  }
  
  public void switchBiz(String paramString, PluginProcessKiller paramPluginProcessKiller)
  {
    switchBiz(paramString, null, paramPluginProcessKiller);
  }
  
  public void switchBiz(String paramString, DynamicPluginManager paramDynamicPluginManager)
  {
    switchBiz(paramString, paramDynamicPluginManager, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.impl.PluginEnterManagerImpl
 * JD-Core Version:    0.7.0.1
 */