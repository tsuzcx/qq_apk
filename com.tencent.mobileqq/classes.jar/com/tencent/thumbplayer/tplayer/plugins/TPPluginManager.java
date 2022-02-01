package com.tencent.thumbplayer.tplayer.plugins;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class TPPluginManager
  implements ITPPluginManager
{
  private CopyOnWriteArrayList<ITPPluginBase> mPluginList = new CopyOnWriteArrayList();
  
  public void addPlugin(ITPPluginBase paramITPPluginBase)
  {
    try
    {
      CopyOnWriteArrayList localCopyOnWriteArrayList = this.mPluginList;
      if (localCopyOnWriteArrayList == null) {
        return;
      }
      if (!this.mPluginList.contains(paramITPPluginBase))
      {
        paramITPPluginBase.onAttach();
        this.mPluginList.add(paramITPPluginBase);
      }
      return;
    }
    finally {}
  }
  
  public void onAttach() {}
  
  public void onDetach() {}
  
  public void onEvent(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    try
    {
      if (this.mPluginList != null)
      {
        Iterator localIterator = this.mPluginList.iterator();
        while (localIterator.hasNext())
        {
          ITPPluginBase localITPPluginBase = (ITPPluginBase)localIterator.next();
          if (localITPPluginBase != null) {
            localITPPluginBase.onEvent(paramInt1, paramInt2, paramInt3, paramString, paramObject);
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void release()
  {
    try
    {
      if (this.mPluginList != null)
      {
        Iterator localIterator = this.mPluginList.iterator();
        while (localIterator.hasNext())
        {
          ITPPluginBase localITPPluginBase = (ITPPluginBase)localIterator.next();
          if (localITPPluginBase != null) {
            localITPPluginBase.onDetach();
          }
        }
        this.mPluginList.clear();
      }
      this.mPluginList = null;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void removePlugin(ITPPluginBase paramITPPluginBase)
  {
    try
    {
      if (this.mPluginList != null)
      {
        paramITPPluginBase.onDetach();
        this.mPluginList.remove(paramITPPluginBase);
      }
      return;
    }
    finally
    {
      paramITPPluginBase = finally;
      throw paramITPPluginBase;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.TPPluginManager
 * JD-Core Version:    0.7.0.1
 */