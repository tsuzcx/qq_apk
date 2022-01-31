package com.tencent.thumbplayer.tplayer.plugins;

import java.util.ArrayList;
import java.util.Iterator;

public class TPPluginManager
  implements ITPPluginManager
{
  private ArrayList<ITPPluginBase> mPluginList = new ArrayList();
  
  public ITPPluginManager addPlugin(ITPPluginBase paramITPPluginBase)
  {
    if (this.mPluginList == null) {
      this.mPluginList = new ArrayList();
    }
    if (!this.mPluginList.contains(paramITPPluginBase))
    {
      paramITPPluginBase.onAttach();
      this.mPluginList.add(paramITPPluginBase);
    }
    return this;
  }
  
  public void onAttach() {}
  
  public void onDetach() {}
  
  public void onEvent(int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
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
  }
  
  public void release()
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
        localIterator.remove();
      }
    }
    this.mPluginList = null;
  }
  
  public void removePlugin(ITPPluginBase paramITPPluginBase)
  {
    if (this.mPluginList != null)
    {
      paramITPPluginBase.onDetach();
      this.mPluginList.remove(paramITPPluginBase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.thumbplayer.tplayer.plugins.TPPluginManager
 * JD-Core Version:    0.7.0.1
 */