package com.tencent.mtt.hippy.uimanager;

import android.text.TextUtils;
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
  final SparseArray<RenderNode> a = new SparseArray();
  final SparseArray<Boolean> b = new SparseArray();
  final ArrayList<RenderNode> c = new ArrayList();
  final ArrayList<RenderNode> d = new ArrayList();
  final HippyEngineContext e;
  final ControllerManager f;
  
  public RenderManager(HippyEngineContext paramHippyEngineContext, List<HippyAPIProvider> paramList)
  {
    this.e = paramHippyEngineContext;
    this.f = new ControllerManager(paramHippyEngineContext, paramList);
  }
  
  private void b(RenderNode paramRenderNode)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("delete RenderNode ");
    localStringBuilder.append(paramRenderNode.mId);
    localStringBuilder.append(" class ");
    localStringBuilder.append(paramRenderNode.mClassName);
    LogUtils.d("RenderManager", localStringBuilder.toString());
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
  
  public b a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    StyleNode localStyleNode = this.f.a(paramString, paramBoolean, paramInt2);
    localStyleNode.setViewClassName(paramString);
    localStyleNode.setId(paramInt1);
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateLayout ID ");
    ((StringBuilder)localObject).append(paramInt1);
    LogUtils.d("RenderManager", ((StringBuilder)localObject).toString());
    localObject = (RenderNode)this.a.get(paramInt1);
    ((RenderNode)localObject).updateLayout(paramInt2, paramInt3, paramInt4, paramInt5);
    addUpdateNodeIfNeeded((RenderNode)localObject);
  }
  
  public void a(int paramInt, HippyMap paramHippyMap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateNode ID ");
    ((StringBuilder)localObject).append(paramInt);
    LogUtils.d("RenderManager", ((StringBuilder)localObject).toString());
    localObject = (RenderNode)this.a.get(paramInt);
    ((RenderNode)localObject).updateNode(paramHippyMap);
    addUpdateNodeIfNeeded((RenderNode)localObject);
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateExtra ID ");
    ((StringBuilder)localObject).append(paramInt);
    LogUtils.d("RenderManager", ((StringBuilder)localObject).toString());
    localObject = (RenderNode)this.a.get(paramInt);
    ((RenderNode)localObject).updateExtra(paramObject);
    addUpdateNodeIfNeeded((RenderNode)localObject);
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
    LogUtils.d("RenderManager", "dispatchUIFunction Node Null");
  }
  
  public void a(HippyRootView paramHippyRootView, int paramInt1, int paramInt2, int paramInt3, String paramString, HippyMap paramHippyMap)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("createNode ID ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" mParentId ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" index ");
    ((StringBuilder)localObject).append(paramInt3);
    ((StringBuilder)localObject).append("className");
    ((StringBuilder)localObject).append(paramString);
    LogUtils.d("RenderManager", ((StringBuilder)localObject).toString());
    localObject = (RenderNode)this.a.get(paramInt2);
    boolean bool = this.f.a(paramString);
    ControllerManager localControllerManager = this.f;
    if ((!bool) && (!((RenderNode)localObject).mIsLazyLoad)) {
      bool = false;
    } else {
      bool = true;
    }
    paramHippyRootView = localControllerManager.a(paramInt1, paramHippyMap, paramString, paramHippyRootView, bool);
    this.a.put(paramInt1, paramHippyRootView);
    this.b.remove(paramInt1);
    ((RenderNode)localObject).addChild(paramHippyRootView, paramInt3);
    addUpdateNodeIfNeeded((RenderNode)localObject);
    addUpdateNodeIfNeeded(paramHippyRootView);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("do batch size ");
    localStringBuilder.append(this.c.size());
    LogUtils.d("RenderManager", localStringBuilder.toString());
    int k = 0;
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
    else if (TextUtils.equals("RootNode", localRenderNode.getClassName()))
    {
      addUpdateNodeIfNeeded(localRenderNode);
    }
    b(localRenderNode);
  }
  
  public void b(HippyRootView paramHippyRootView, int paramInt1, int paramInt2, int paramInt3, String paramString, HippyMap paramHippyMap)
  {
    boolean bool2 = this.f.a(paramString);
    RenderNode localRenderNode = (RenderNode)this.a.get(paramInt2);
    boolean bool1 = false;
    if (localRenderNode != null)
    {
      if ((!bool2) && (!localRenderNode.mIsLazyLoad)) {}
    }
    else {
      while ((bool2) || (((Boolean)this.b.get(paramInt2)).booleanValue()))
      {
        bool1 = true;
        break;
      }
    }
    this.b.put(paramInt1, Boolean.valueOf(bool1));
    if (!bool1) {
      this.f.a(paramHippyRootView, paramInt1, paramString, paramHippyMap);
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
    catch (Exception localException)
    {
      label14:
      break label14;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.RenderManager
 * JD-Core Version:    0.7.0.1
 */