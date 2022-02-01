package com.tencent.viola.core;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.viola.commons.ViolaThread;
import com.tencent.viola.ui.action.DOMAction;
import com.tencent.viola.ui.context.DOMActionContext;
import com.tencent.viola.ui.context.DOMActionContextImpl;
import com.tencent.viola.ui.dom.DomObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ViolaDomManager
{
  private ConcurrentHashMap<String, DOMActionContextImpl> mDomContextImpMap;
  Handler mDomHandler;
  private ViolaThread mDomThread;
  private ViolaRenderManager mRenderManager;
  
  public ViolaDomManager(ViolaRenderManager paramViolaRenderManager)
  {
    this.mRenderManager = paramViolaRenderManager;
    this.mDomContextImpMap = new ConcurrentHashMap();
    this.mDomThread = new ViolaThread("ViolaDomThread", new ViolaDomHandler(this));
    this.mDomHandler = this.mDomThread.getHandler();
  }
  
  private boolean isDomThread()
  {
    return Thread.currentThread().getId() == this.mDomThread.getId();
  }
  
  private void throwIfNotDomThread()
  {
    if (!isDomThread()) {}
  }
  
  void batch()
  {
    throwIfNotDomThread();
    Iterator localIterator = this.mDomContextImpMap.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((DOMActionContextImpl)((Map.Entry)localIterator.next()).getValue()).batch();
    }
  }
  
  void consumeRenderTask(String paramString)
  {
    throwIfNotDomThread();
    paramString = (DOMActionContextImpl)this.mDomContextImpMap.get(paramString);
    if (paramString != null) {
      paramString.consumeRenderTasks();
    }
  }
  
  public void destroy()
  {
    if ((this.mDomThread != null) && (this.mDomThread.isThreadAlive())) {
      this.mDomThread.quit();
    }
    if (this.mDomContextImpMap != null) {
      this.mDomContextImpMap.clear();
    }
    this.mDomHandler = null;
    this.mDomThread = null;
  }
  
  public void destroyInstance(String paramString)
  {
    paramString = (DOMActionContextImpl)this.mDomContextImpMap.remove(paramString);
    if (paramString != null) {
      post(new ViolaDomManager.1(this, paramString));
    }
  }
  
  public void executeAction(String paramString, DOMAction paramDOMAction, boolean paramBoolean)
  {
    DOMActionContext localDOMActionContext = (DOMActionContext)this.mDomContextImpMap.get(paramString);
    Object localObject = localDOMActionContext;
    if (localDOMActionContext == null)
    {
      if (paramBoolean)
      {
        localObject = new DOMActionContextImpl(paramString, this.mRenderManager);
        this.mDomContextImpMap.put(paramString, localObject);
      }
    }
    else
    {
      System.currentTimeMillis();
      System.nanoTime();
      paramDOMAction.executeDom((DOMActionContext)localObject);
      return;
    }
    ViolaSDKManager.getInstance().getViolaInstance(paramString);
  }
  
  public void forceBatch()
  {
    throwIfNotDomThread();
    Iterator localIterator = this.mDomContextImpMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      DOMActionContextImpl localDOMActionContextImpl = (DOMActionContextImpl)((Map.Entry)localIterator.next()).getValue();
      if (localDOMActionContextImpl != null)
      {
        localDOMActionContextImpl.markDirty();
        localDOMActionContextImpl.batch();
      }
    }
  }
  
  public void forceNvBatch()
  {
    throwIfNotDomThread();
    Iterator localIterator = this.mDomContextImpMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      DOMActionContextImpl localDOMActionContextImpl = (DOMActionContextImpl)((Map.Entry)localIterator.next()).getValue();
      if (localDOMActionContextImpl != null)
      {
        localDOMActionContextImpl.markDirty();
        localDOMActionContextImpl.nvBatch();
      }
    }
  }
  
  public DOMActionContext getDomContext(String paramString)
  {
    return (DOMActionContext)this.mDomContextImpMap.get(paramString);
  }
  
  public DomObject getDomboject(String paramString1, String paramString2)
  {
    DOMActionContextImpl localDOMActionContextImpl = (DOMActionContextImpl)this.mDomContextImpMap.remove(paramString1);
    if ((localDOMActionContextImpl != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return localDOMActionContextImpl.getDomByRef(paramString2);
    }
    return null;
  }
  
  public boolean hasMessages(int paramInt)
  {
    if ((this.mDomHandler == null) || (this.mDomThread == null) || (!this.mDomThread.isThreadAlive()) || (this.mDomThread.getLooper() == null)) {
      return true;
    }
    return this.mDomHandler.hasMessages(paramInt);
  }
  
  public void post(Runnable paramRunnable)
  {
    if ((this.mDomHandler == null) || (paramRunnable == null) || (this.mDomThread == null) || (!this.mDomThread.isThreadAlive()) || (this.mDomThread.getLooper() == null)) {
      return;
    }
    this.mDomHandler.post(ViolaThread.secure(paramRunnable));
  }
  
  public void postAction(String paramString, DOMAction paramDOMAction, boolean paramBoolean)
  {
    postActionDelay(paramString, paramDOMAction, paramBoolean, 0L);
  }
  
  public void postActionDelay(String paramString, DOMAction paramDOMAction, boolean paramBoolean, long paramLong)
  {
    if (paramDOMAction == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    ViolaDomTask localViolaDomTask = new ViolaDomTask();
    localViolaDomTask.instanceId = paramString;
    localViolaDomTask.args = new ArrayList();
    localViolaDomTask.args.add(paramDOMAction);
    localViolaDomTask.args.add(Boolean.valueOf(paramBoolean));
    localMessage.obj = localViolaDomTask;
    sendMessageDelayed(localMessage, paramLong);
  }
  
  public void postRenderTask(@NonNull String paramString)
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    ViolaDomTask localViolaDomTask = new ViolaDomTask();
    localViolaDomTask.instanceId = paramString;
    localMessage.obj = localViolaDomTask;
    sendMessage(localMessage);
  }
  
  public void postTransitionTask(String paramString, DOMAction paramDOMAction, boolean paramBoolean)
  {
    if (paramDOMAction == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 4;
    ViolaDomTask localViolaDomTask = new ViolaDomTask();
    localViolaDomTask.instanceId = paramString;
    localViolaDomTask.args = new ArrayList();
    localViolaDomTask.args.add(paramDOMAction);
    localViolaDomTask.args.add(Boolean.valueOf(paramBoolean));
    localMessage.obj = localViolaDomTask;
    sendMessage(localMessage);
  }
  
  public void removeMessages(int paramInt)
  {
    if ((this.mDomHandler == null) || (this.mDomThread == null) || (!this.mDomThread.isThreadAlive()) || (this.mDomThread.getLooper() == null)) {
      return;
    }
    this.mDomHandler.removeMessages(paramInt);
  }
  
  public void sendEmptyMessageDelayed(int paramInt, long paramLong)
  {
    if ((this.mDomHandler == null) || (this.mDomThread == null) || (!this.mDomThread.isThreadAlive()) || (this.mDomThread.getLooper() == null)) {
      return;
    }
    this.mDomHandler.sendEmptyMessageDelayed(paramInt, paramLong);
  }
  
  public void sendMessage(Message paramMessage)
  {
    sendMessageDelayed(paramMessage, 0L);
  }
  
  public void sendMessageDelayed(Message paramMessage, long paramLong)
  {
    if ((paramMessage == null) || (this.mDomHandler == null) || (this.mDomThread == null) || (!this.mDomThread.isThreadAlive()) || (this.mDomThread.getLooper() == null)) {
      return;
    }
    this.mDomHandler.sendMessageDelayed(paramMessage, paramLong);
  }
  
  public DomObject unRegisterDomboject(String paramString1, String paramString2)
  {
    DOMActionContextImpl localDOMActionContextImpl = (DOMActionContextImpl)this.mDomContextImpMap.remove(paramString1);
    if ((localDOMActionContextImpl != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return localDOMActionContextImpl.unregisterDOMObject(paramString2);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.core.ViolaDomManager
 * JD-Core Version:    0.7.0.1
 */