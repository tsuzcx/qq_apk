package com.tencent.viola.ui.context;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaRenderManager;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.action.IRenderTask;
import com.tencent.viola.ui.action.RenderAction;
import com.tencent.viola.ui.action.RenderActionTask;
import com.tencent.viola.ui.baseComponent.VComponent;
import com.tencent.viola.ui.baseComponent.VComponentContainer;
import com.tencent.viola.ui.dom.DomObject;
import com.tencent.viola.ui.dom.DomObject.Consumer;
import com.tencent.viola.ui.dom.style.FlexLayoutContext;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class DOMActionContextImpl
  implements DOMActionContext
{
  private Set<Pair<String, Map<String, Object>>> animations;
  private DomObject.Consumer mAddDOMConsumer;
  private Map<String, DOMActionContextImpl.AddDomInfo> mAddDom = new HashMap();
  private DomObject.Consumer mApplyStyleConsumer;
  private boolean mDestroy = false;
  private volatile boolean mDirty;
  private String mInstanceId;
  private FlexLayoutContext mLayoutContext;
  private List<IRenderTask> mNormalTasks;
  final ConcurrentHashMap<String, DomObject> mRegistry;
  private ViolaRenderManager mRenderManager;
  private DomObject.Consumer mUnregisterDomConsumer;
  private String nvRootRef;
  private String rootDomRef;
  private boolean supportNv;
  
  public DOMActionContextImpl(String paramString, ViolaRenderManager paramViolaRenderManager)
  {
    this.mInstanceId = paramString;
    this.mLayoutContext = new FlexLayoutContext();
    this.mRegistry = new ConcurrentHashMap();
    this.mNormalTasks = new CopyOnWriteArrayList();
    this.animations = new LinkedHashSet();
    this.mRenderManager = paramViolaRenderManager;
    this.mAddDOMConsumer = new DOMActionContextImpl.AddDOMConsumer(this, this.mRegistry);
    this.mUnregisterDomConsumer = new DOMActionContextImpl.RemoveElementConsumer(this.mRegistry);
    this.mApplyStyleConsumer = new DOMActionContextImpl.ApplyStyleConsumer(this, this.mRegistry);
  }
  
  private void parseAnimation()
  {
    Iterator localIterator = this.animations.iterator();
    while (localIterator.hasNext()) {
      if (TextUtils.isEmpty((CharSequence)((Pair)localIterator.next()).first)) {}
    }
  }
  
  private void updateDomObj()
  {
    long l = System.currentTimeMillis();
    Iterator localIterator = this.mAddDom.entrySet().iterator();
    while (localIterator.hasNext()) {
      updateDomObj(((DOMActionContextImpl.AddDomInfo)((Map.Entry)localIterator.next()).getValue()).component);
    }
    ViolaLogUtils.d("updateDomObj", "time:" + (System.currentTimeMillis() - l));
  }
  
  private void updateDomObj(VComponent paramVComponent)
  {
    if (paramVComponent == null) {}
    for (;;)
    {
      return;
      DomObject localDomObject = (DomObject)this.mRegistry.get(paramVComponent.getRef());
      if (localDomObject != null)
      {
        localDomObject.old();
        paramVComponent.updateDom(localDomObject);
        if ((paramVComponent instanceof VComponentContainer))
        {
          paramVComponent = (VComponentContainer)paramVComponent;
          int j = paramVComponent.getChildCount();
          int i = 0;
          while (i < j)
          {
            updateDomObj(paramVComponent.getChild(i));
            i += 1;
          }
        }
      }
    }
  }
  
  public void addAnimationForElement(String paramString, Map<String, Object> paramMap)
  {
    this.animations.add(new Pair(paramString, paramMap));
    this.mDirty = true;
  }
  
  public void addDomInfo(String paramString, VComponent paramVComponent)
  {
    DOMActionContextImpl.AddDomInfo localAddDomInfo = new DOMActionContextImpl.AddDomInfo();
    localAddDomInfo.component = paramVComponent;
    this.mAddDom.put(paramString, localAddDomInfo);
  }
  
  public void batch()
  {
    if ((!this.mDirty) || (this.mDestroy) || (TextUtils.isEmpty(this.rootDomRef))) {
      return;
    }
    layout((DomObject)this.mRegistry.get(this.rootDomRef));
  }
  
  public void consumeRenderTasks()
  {
    this.mRenderManager.runOnUIThreadBatch(this.mInstanceId, new ArrayList(this.mNormalTasks));
    this.mNormalTasks.clear();
  }
  
  public void destroy()
  {
    this.mDestroy = true;
    this.mRegistry.clear();
    this.mAddDOMConsumer = null;
    this.mNormalTasks.clear();
    this.mAddDom.clear();
    this.mLayoutContext = null;
    this.mRenderManager = null;
    this.mApplyStyleConsumer = null;
    this.animations.clear();
  }
  
  public DomObject.Consumer getAddDOMConsumer()
  {
    return this.mAddDOMConsumer;
  }
  
  public DomObject.Consumer getApplyStyleConsumer()
  {
    return this.mApplyStyleConsumer;
  }
  
  public VComponent getComponent(String paramString)
  {
    return this.mRenderManager.getComponent(this.mInstanceId, paramString);
  }
  
  public DomObject getDomByRef(String paramString)
  {
    return (DomObject)this.mRegistry.get(paramString);
  }
  
  public ViolaInstance getInstance()
  {
    return this.mRenderManager.getInstance(this.mInstanceId);
  }
  
  public String getInstanceId()
  {
    return this.mInstanceId;
  }
  
  public String getNvRootRef()
  {
    return this.nvRootRef;
  }
  
  public DomObject.Consumer getRemoveElementConsumer()
  {
    return this.mUnregisterDomConsumer;
  }
  
  public String getRootRef()
  {
    return this.rootDomRef;
  }
  
  public boolean isDestory()
  {
    return false;
  }
  
  public boolean isSupportNv()
  {
    return this.supportNv;
  }
  
  void layout(DomObject paramDomObject)
  {
    if (paramDomObject == null) {}
    ViolaInstance localViolaInstance;
    do
    {
      return;
      System.currentTimeMillis();
      paramDomObject.traverseTree(new DomObject.Consumer[] { new DOMActionContextImpl.1(this) });
      System.currentTimeMillis();
      paramDomObject.calculateLayout(this.mLayoutContext);
      localViolaInstance = ViolaSDKManager.getInstance().getViolaInstance(this.mInstanceId);
      if (localViolaInstance != null) {}
      System.currentTimeMillis();
      paramDomObject.traverseTree(new DomObject.Consumer[] { new DOMActionContextImpl.2(this), new DOMActionContextImpl.ApplyUpdateConsumer(this, null) });
      if (localViolaInstance != null) {}
      System.currentTimeMillis();
      updateDomObj();
      if (localViolaInstance != null) {}
      parseAnimation();
      consumeRenderTasks();
      this.mAddDom.clear();
      this.animations.clear();
      this.mDirty = false;
    } while (localViolaInstance == null);
  }
  
  public void markDirty()
  {
    if ((!this.mDestroy) && (!this.mDirty)) {
      this.mDirty = true;
    }
  }
  
  public void nvBatch()
  {
    if ((!this.mDirty) || (this.mDestroy) || (TextUtils.isEmpty(this.nvRootRef))) {
      return;
    }
    layout((DomObject)this.mRegistry.get(this.nvRootRef));
  }
  
  public void postRenderTask(RenderAction paramRenderAction)
  {
    this.mNormalTasks.add(new RenderActionTask(paramRenderAction, this.mRenderManager.getRenderContext(this.mInstanceId)));
    this.mDirty = true;
  }
  
  public void registerComponent(String paramString, VComponent paramVComponent)
  {
    this.mRenderManager.registerComponent(this.mInstanceId, paramString, paramVComponent);
  }
  
  public void registerDOMObject(String paramString, DomObject paramDomObject)
  {
    this.mRegistry.put(paramString, paramDomObject);
  }
  
  public void setNvRootRef(String paramString)
  {
    this.nvRootRef = paramString;
  }
  
  public void setRootRef(@NonNull String paramString)
  {
    this.rootDomRef = paramString;
  }
  
  public void supportNv(boolean paramBoolean)
  {
    this.supportNv = paramBoolean;
  }
  
  public VComponent unregisterComponent(String paramString)
  {
    return this.mRenderManager.unRegisterComponent(this.mInstanceId, paramString);
  }
  
  public DomObject unregisterDOMObject(String paramString)
  {
    return (DomObject)this.mRegistry.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.context.DOMActionContextImpl
 * JD-Core Version:    0.7.0.1
 */