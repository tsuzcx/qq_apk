package com.tencent.viola.core;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.viola.commons.ViolaThread;
import com.tencent.viola.ui.action.IRenderTask;
import com.tencent.viola.ui.action.RenderAction;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.context.RenderActionContext;
import com.tencent.viola.ui.context.RenderActionContextImpl;
import com.tencent.viola.ui.dom.DomObject;
import java.util.List;
import java.util.WeakHashMap;

public class ViolaRenderManager
{
  private WeakHashMap<String, RenderActionContextImpl> mRenderActionImplMap = new WeakHashMap();
  private ViolaRenderHandler mRenderHandler = new ViolaRenderHandler();
  
  public void destroyInstance(String paramString)
  {
    postOnUiThreadDelay(new ViolaRenderManager.1(this, paramString), 100L);
  }
  
  @Nullable
  public VComponent getComponent(String paramString1, String paramString2)
  {
    VComponent localVComponent = null;
    if (paramString1 != null)
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      paramString1 = getRenderContext(paramString1);
      if (paramString1 == null) {
        return null;
      }
      localVComponent = paramString1.getComponent(paramString2);
    }
    return localVComponent;
  }
  
  public ViolaInstance getInstance(String paramString)
  {
    RenderActionContext localRenderActionContext = (RenderActionContext)this.mRenderActionImplMap.get(paramString);
    if ((localRenderActionContext != null) && (!TextUtils.isEmpty(paramString))) {
      return localRenderActionContext.getInstance();
    }
    return null;
  }
  
  public RenderActionContextImpl getRenderContext(String paramString)
  {
    return (RenderActionContextImpl)this.mRenderActionImplMap.get(paramString);
  }
  
  public void postOnUiThread(Runnable paramRunnable)
  {
    this.mRenderHandler.post(ViolaThread.secure(paramRunnable));
  }
  
  public void postOnUiThreadDelay(Runnable paramRunnable, long paramLong)
  {
    this.mRenderHandler.postDelayed(ViolaThread.secure(paramRunnable), paramLong);
  }
  
  public void registerComponent(String paramString1, String paramString2, VComponent paramVComponent)
  {
    paramString1 = (RenderActionContextImpl)this.mRenderActionImplMap.get(paramString1);
    if (paramString1 != null) {
      paramString1.registerComponent(paramString2, paramVComponent);
    }
  }
  
  public void registerInstance(ViolaInstance paramViolaInstance)
  {
    if (paramViolaInstance != null)
    {
      if (this.mRenderActionImplMap.containsKey(paramViolaInstance.getInstanceId())) {
        return;
      }
      this.mRenderActionImplMap.put(paramViolaInstance.getInstanceId(), new RenderActionContextImpl(paramViolaInstance));
    }
  }
  
  public void runOnThread(String paramString, IRenderTask paramIRenderTask)
  {
    this.mRenderHandler.post(ViolaThread.secure(new ViolaRenderManager.2(this, paramString, paramIRenderTask)));
  }
  
  public void runOnThread(String paramString, RenderAction paramRenderAction)
  {
    this.mRenderHandler.post(ViolaThread.secure(new ViolaRenderManager.4(this, paramString, paramRenderAction)));
  }
  
  public void runOnUIThreadBatch(String paramString, List<IRenderTask> paramList)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null))
    {
      if (paramList.isEmpty()) {
        return;
      }
      this.mRenderHandler.post(ViolaThread.secure(new ViolaRenderManager.3(this, paramString, paramList)));
    }
  }
  
  public void setExtra(String paramString1, String paramString2, Object paramObject)
  {
    paramString1 = (RenderActionContextImpl)this.mRenderActionImplMap.get(paramString1);
    if (paramString1 == null) {
      return;
    }
    paramString1.setExtra(paramString2, paramObject);
  }
  
  public void setLayout(String paramString1, String paramString2, DomObject paramDomObject)
  {
    paramString1 = (RenderActionContextImpl)this.mRenderActionImplMap.get(paramString1);
    if (paramString1 == null) {
      return;
    }
    paramString1.setLayout(paramString2, paramDomObject);
  }
  
  public VComponent unRegisterComponent(String paramString1, String paramString2)
  {
    paramString1 = (RenderActionContextImpl)this.mRenderActionImplMap.get(paramString1);
    if (paramString1 != null) {
      return paramString1.unregisterComponent(paramString2);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.ViolaRenderManager
 * JD-Core Version:    0.7.0.1
 */