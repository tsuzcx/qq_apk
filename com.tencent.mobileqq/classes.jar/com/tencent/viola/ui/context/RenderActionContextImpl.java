package com.tencent.viola.ui.context;

import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.dom.DomObject;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class RenderActionContextImpl
  implements RenderActionContext
{
  private WeakReference<ViolaInstance> mInstanceWeakReference;
  private Map<String, VComponent> mRegistry;
  
  public RenderActionContextImpl(ViolaInstance paramViolaInstance)
  {
    this.mInstanceWeakReference = new WeakReference(paramViolaInstance);
    this.mRegistry = new ConcurrentHashMap();
  }
  
  public void destroy()
  {
    this.mInstanceWeakReference.clear();
    if (this.mRegistry != null)
    {
      Iterator localIterator = this.mRegistry.entrySet().iterator();
      while (localIterator.hasNext())
      {
        VComponent localVComponent = (VComponent)((Map.Entry)localIterator.next()).getValue();
        if ((localVComponent != null) && (!localVComponent.isDestroyed())) {
          localVComponent.destroy();
        }
      }
      this.mRegistry.clear();
    }
  }
  
  public VComponent getComponent(String paramString)
  {
    return (VComponent)this.mRegistry.get(paramString);
  }
  
  public ViolaInstance getInstance()
  {
    if (this.mInstanceWeakReference != null) {
      return (ViolaInstance)this.mInstanceWeakReference.get();
    }
    return null;
  }
  
  public Map<String, VComponent> getRegistryComponents()
  {
    return this.mRegistry;
  }
  
  public void registerComponent(String paramString, VComponent paramVComponent)
  {
    this.mRegistry.put(paramString, paramVComponent);
  }
  
  public void setExtra(String paramString, Object paramObject)
  {
    paramString = (VComponent)this.mRegistry.get(paramString);
    if (paramString == null) {
      return;
    }
    paramString.updateExtra(paramObject);
  }
  
  public void setLayout(String paramString, DomObject paramDomObject)
  {
    paramString = (VComponent)this.mRegistry.get(paramString);
    if (paramString == null) {
      return;
    }
    paramString.applyLayout(paramDomObject);
  }
  
  public VComponent unregisterComponent(String paramString)
  {
    return (VComponent)this.mRegistry.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.context.RenderActionContextImpl
 * JD-Core Version:    0.7.0.1
 */