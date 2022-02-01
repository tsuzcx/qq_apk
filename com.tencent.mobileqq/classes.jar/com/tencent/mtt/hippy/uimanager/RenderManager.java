package com.tencent.mtt.hippy.uimanager;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.StyleNode;
import com.tencent.mtt.hippy.dom.node.b;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.util.ArrayList;
import java.util.List;

public class RenderManager
{
  SparseArray<RenderNode> a = new SparseArray();
  SparseArray<Boolean> b = new SparseArray();
  ArrayList<RenderNode> c = new ArrayList();
  ArrayList<RenderNode> d = new ArrayList();
  HippyEngineContext e;
  ControllerManager f;
  
  public RenderManager(HippyEngineContext paramHippyEngineContext, List<HippyAPIProvider> paramList)
  {
    this.e = paramHippyEngineContext;
    this.f = new ControllerManager(paramHippyEngineContext, paramList);
  }
  
  private void b(RenderNode paramRenderNode)
  {
    LogUtils.d("RenderManager", "delete RenderNode " + paramRenderNode.mId + " class " + paramRenderNode.mClassName);
    if (paramRenderNode.mParent != null) {
      paramRenderNode.mParent.removeChild(paramRenderNode);
    }
    this.a.remove(paramRenderNode.mId);
    int j = paramRenderNode.getChildCount();
    int i = 0;
    while (i < j)
    {
      b(paramRenderNode.getChildAt(0));
      i += 1;
    }
  }
  
  public b a(String paramString, boolean paramBoolean, int paramInt)
  {
    StyleNode localStyleNode = this.f.a(paramString, paramBoolean);
    localStyleNode.setViewClassName(paramString);
    localStyleNode.setId(paramInt);
    return localStyleNode;
  }
  
  public void a()
  {
    getControllerManager().a();
  }
  
  public void a(int paramInt)
  {
    RenderNode localRenderNode = new RenderNode(paramInt, "RootNode", this.f);
    this.a.put(paramInt, localRenderNode);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    LogUtils.d("RenderManager", "updateLayout ID " + paramInt1);
    RenderNode localRenderNode = (RenderNode)this.a.get(paramInt1);
    localRenderNode.updateLayout(paramInt2, paramInt3, paramInt4, paramInt5);
    addUpdateNodeIfNeeded(localRenderNode);
  }
  
  public void a(int paramInt, HippyMap paramHippyMap)
  {
    LogUtils.d("RenderManager", "updateNode ID " + paramInt);
    RenderNode localRenderNode = (RenderNode)this.a.get(paramInt);
    localRenderNode.updateNode(paramHippyMap);
    addUpdateNodeIfNeeded(localRenderNode);
  }
  
  public void a(int paramInt, Promise paramPromise)
  {
    RenderNode localRenderNode = (RenderNode)this.a.get(paramInt);
    if (localRenderNode == null)
    {
      paramPromise.reject("this view is null");
      return;
    }
    localRenderNode.measureInWindow(paramPromise);
    a(localRenderNode);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    LogUtils.d("RenderManager", "updateExtra ID " + paramInt);
    RenderNode localRenderNode = (RenderNode)this.a.get(paramInt);
    localRenderNode.updateExtra(paramObject);
    addUpdateNodeIfNeeded(localRenderNode);
  }
  
  public void a(int paramInt, String paramString, HippyArray paramHippyArray, Promise paramPromise)
  {
    RenderNode localRenderNode = (RenderNode)this.a.get(paramInt);
    if (localRenderNode != null)
    {
      localRenderNode.dispatchUIFunction(paramString, paramHippyArray, paramPromise);
      a(localRenderNode);
      return;
    }
    Log.e("RenderManager", "dispatchUIFunction Node Null");
  }
  
  public void a(HippyRootView paramHippyRootView, int paramInt1, int paramInt2, int paramInt3, String paramString, HippyMap paramHippyMap)
  {
    LogUtils.d("RenderManager", "createNode ID " + paramInt1 + " mParentId " + paramInt2 + " index " + paramInt3 + "className" + paramString);
    RenderNode localRenderNode = (RenderNode)this.a.get(paramInt2);
    boolean bool = this.f.a(paramString);
    ControllerManager localControllerManager = this.f;
    if ((bool) || (localRenderNode.mIsLazyLoad)) {}
    for (bool = true;; bool = false)
    {
      paramHippyRootView = localControllerManager.a(paramInt1, paramHippyMap, paramString, paramHippyRootView, bool);
      this.a.put(paramInt1, paramHippyRootView);
      this.b.remove(paramInt1);
      localRenderNode.addChild(paramHippyRootView, paramInt3);
      addUpdateNodeIfNeeded(localRenderNode);
      addUpdateNodeIfNeeded(paramHippyRootView);
      return;
    }
  }
  
  void a(RenderNode paramRenderNode)
  {
    if (!this.d.contains(paramRenderNode)) {
      this.d.add(paramRenderNode);
    }
  }
  
  public void a(ArrayList<Integer> paramArrayList, int paramInt1, int paramInt2)
  {
    RenderNode localRenderNode1 = (RenderNode)this.a.get(paramInt1);
    RenderNode localRenderNode2 = (RenderNode)this.a.get(paramInt2);
    ArrayList localArrayList = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < paramArrayList.size())
    {
      RenderNode localRenderNode3 = (RenderNode)this.a.get(((Integer)paramArrayList.get(paramInt1)).intValue());
      localArrayList.add(localRenderNode3);
      localRenderNode1.removeChild(localRenderNode3);
      localRenderNode2.addChild(localRenderNode3, paramInt1);
      paramInt1 += 1;
    }
    localRenderNode1.move(localArrayList, paramInt2);
    addUpdateNodeIfNeeded(localRenderNode2);
  }
  
  public void addUpdateNodeIfNeeded(RenderNode paramRenderNode)
  {
    if ((!this.c.contains(paramRenderNode)) && (paramRenderNode != null)) {
      this.c.add(paramRenderNode);
    }
  }
  
  public void b()
  {
    int k = 0;
    LogUtils.d("RenderManager", "do batch size " + this.c.size());
    int i = 0;
    while (i < this.c.size())
    {
      ((RenderNode)this.c.get(i)).createView();
      i += 1;
    }
    i = 0;
    while (i < this.c.size())
    {
      ((RenderNode)this.c.get(i)).update();
      i += 1;
    }
    i = 0;
    while (i < this.c.size())
    {
      ((RenderNode)this.c.get(i)).batchComplete();
      i += 1;
    }
    this.c.clear();
    i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.d.size()) {
        break;
      }
      ((RenderNode)this.d.get(i)).createView();
      i += 1;
    }
    while (j < this.d.size())
    {
      ((RenderNode)this.d.get(j)).update();
      j += 1;
    }
    this.d.clear();
  }
  
  public void b(int paramInt)
  {
    RenderNode localRenderNode = (RenderNode)this.a.get(paramInt);
    localRenderNode.setDelete(true);
    if ((localRenderNode.mParent != null) && (this.f.a(paramInt)))
    {
      localRenderNode.mParent.addDeleteId(paramInt, localRenderNode);
      addUpdateNodeIfNeeded(localRenderNode.mParent);
    }
    for (;;)
    {
      b(localRenderNode);
      return;
      if (TextUtils.equals("RootNode", localRenderNode.getClassName())) {
        addUpdateNodeIfNeeded(localRenderNode);
      }
    }
  }
  
  public void b(HippyRootView paramHippyRootView, int paramInt1, int paramInt2, int paramInt3, String paramString, HippyMap paramHippyMap)
  {
    boolean bool1 = false;
    boolean bool2 = this.f.a(paramString);
    RenderNode localRenderNode = (RenderNode)this.a.get(paramInt2);
    if (localRenderNode != null) {
      if ((bool2) || (localRenderNode.mIsLazyLoad)) {
        bool1 = true;
      }
    }
    for (;;)
    {
      this.b.put(paramInt1, Boolean.valueOf(bool1));
      if (!bool1) {
        this.f.a(paramHippyRootView, paramInt1, paramString, paramHippyMap);
      }
      return;
      bool1 = false;
      continue;
      if ((bool2) || (((Boolean)this.b.get(paramInt2)).booleanValue())) {
        bool1 = true;
      }
    }
  }
  
  public ControllerManager getControllerManager()
  {
    return this.f;
  }
  
  public RenderNode getRenderNode(int paramInt)
  {
    try
    {
      RenderNode localRenderNode = (RenderNode)this.a.get(paramInt);
      return localRenderNode;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.RenderManager
 * JD-Core Version:    0.7.0.1
 */