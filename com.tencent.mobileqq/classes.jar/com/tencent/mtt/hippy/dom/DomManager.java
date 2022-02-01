package com.tencent.mtt.hippy.dom;

import android.text.Layout;
import android.text.TextUtils;
import android.util.SparseBooleanArray;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyEngineLifecycleEventListener;
import com.tencent.mtt.hippy.HippyGlobalConfigs;
import com.tencent.mtt.hippy.HippyInstanceLifecycleEventListener;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.adapter.HippyLogAdapter;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.common.ThreadExecutor;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.dom.node.StyleNode;
import com.tencent.mtt.hippy.dom.node.TextNode;
import com.tencent.mtt.hippy.dom.node.a;
import com.tencent.mtt.hippy.dom.node.i;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.uimanager.ControllerManager;
import com.tencent.mtt.hippy.uimanager.DiffUtils;
import com.tencent.mtt.hippy.uimanager.RenderManager;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.utils.UIThreadUtils;
import com.tencent.smtt.flexbox.FlexNode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class DomManager
  implements HippyEngineLifecycleEventListener, HippyInstanceLifecycleEventListener
{
  protected final DomManager.a a;
  protected volatile boolean b;
  protected boolean c = false;
  final b d;
  final ArrayList<f> e;
  final ArrayList<f> f;
  final ArrayList<f> g = new ArrayList();
  final Object h = new Object();
  final c i = new c();
  RenderManager j;
  volatile CopyOnWriteArrayList<a> k;
  i l;
  private final SparseBooleanArray m = new SparseBooleanArray();
  private final HippyEngineContext n;
  private volatile boolean o = false;
  private volatile boolean p = false;
  
  public DomManager(HippyEngineContext paramHippyEngineContext)
  {
    this.n = paramHippyEngineContext;
    this.d = new b();
    this.e = new ArrayList();
    this.f = new ArrayList();
    this.j = paramHippyEngineContext.getRenderManager();
    paramHippyEngineContext.addInstanceLifecycleEventListener(this);
    this.a = new DomManager.a(this, null);
    this.n.addEngineLifecycleEventListener(this);
    this.l = new i();
  }
  
  private DomManager.b a(com.tencent.mtt.hippy.dom.node.b paramb1, com.tencent.mtt.hippy.dom.node.b paramb2, int paramInt)
  {
    int i1 = 0;
    while (i1 < paramb1.getChildCount())
    {
      Object localObject = paramb1.getChildAt(i1);
      if (localObject == paramb2) {
        return new DomManager.b(this, true, paramInt);
      }
      if (((com.tencent.mtt.hippy.dom.node.b)localObject).isJustLayout())
      {
        localObject = a((com.tencent.mtt.hippy.dom.node.b)localObject, paramb2, paramInt);
        if (((DomManager.b)localObject).a) {
          return localObject;
        }
        paramInt = ((DomManager.b)localObject).b;
      }
      else
      {
        paramInt += 1;
      }
      i1 += 1;
    }
    return new DomManager.b(this, false, paramInt);
  }
  
  private void a(f paramf)
  {
    this.e.add(paramf);
  }
  
  private void a(com.tencent.mtt.hippy.dom.node.b paramb, float paramFloat1, float paramFloat2)
  {
    if ((!paramb.isJustLayout()) && (!paramb.isVirtual()))
    {
      if (paramb.shouldUpdateLayout(paramFloat1, paramFloat2)) {
        a(new DomManager.5(this, paramFloat1, paramFloat2, paramb));
      }
      return;
    }
    int i1 = 0;
    while (i1 < paramb.getChildCount())
    {
      com.tencent.mtt.hippy.dom.node.b localb = paramb.getChildAt(i1);
      int i2 = localb.getId();
      if (!this.m.get(i2))
      {
        this.m.put(i2, true);
        a(localb, localb.getLayoutX() + paramFloat1, localb.getLayoutY() + paramFloat2);
      }
      i1 += 1;
    }
  }
  
  private void a(com.tencent.mtt.hippy.dom.node.b paramb, HippyMap paramHippyMap, HippyRootView paramHippyRootView)
  {
    com.tencent.mtt.hippy.dom.node.b localb = b(paramb);
    DomManager.b localb1 = a(localb, paramb, 0);
    if (!paramb.isVirtual()) {
      a(new DomManager.13(this, paramHippyRootView, paramb, localb, localb1, paramHippyMap));
    }
    paramHippyMap = new ArrayList();
    paramb.markUpdated();
    a(paramb, paramHippyMap);
    paramb.setIsJustLayout(false);
    if (!paramb.isVirtual()) {
      a(new DomManager.14(this, paramHippyMap, localb, paramb));
    }
    h(paramb);
    this.m.clear();
  }
  
  private void a(com.tencent.mtt.hippy.dom.node.b paramb, ArrayList<Integer> paramArrayList)
  {
    int i1 = 0;
    while (i1 < paramb.getChildCount())
    {
      com.tencent.mtt.hippy.dom.node.b localb = paramb.getChildAt(i1);
      if (localb.isJustLayout())
      {
        a(localb, paramArrayList);
      }
      else
      {
        localb.markUpdated();
        paramArrayList.add(Integer.valueOf(localb.getId()));
      }
      i1 += 1;
    }
  }
  
  private static boolean a(HippyMap paramHippyMap)
  {
    if (paramHippyMap == null) {
      return true;
    }
    if ((paramHippyMap.get("collapsable") != null) && (!((Boolean)paramHippyMap.get("collapsable")).booleanValue())) {
      return false;
    }
    Iterator localIterator = paramHippyMap.keySet().iterator();
    while (localIterator.hasNext()) {
      if (!NodeProps.isJustLayout(paramHippyMap, (String)localIterator.next())) {
        return false;
      }
    }
    return true;
  }
  
  private void b(f paramf)
  {
    if (this.c)
    {
      this.f.add(paramf);
      return;
    }
    synchronized (this.h)
    {
      c(paramf);
      return;
    }
  }
  
  private boolean b(HippyMap paramHippyMap)
  {
    if (paramHippyMap == null) {
      return false;
    }
    paramHippyMap = paramHippyMap.keySet().iterator();
    while (paramHippyMap.hasNext()) {
      if (NodeProps.isTouchEventProp((String)paramHippyMap.next())) {
        return true;
      }
    }
    return false;
  }
  
  private void c(f paramf)
  {
    if (this.o) {
      return;
    }
    this.g.add(paramf);
    if (!this.b)
    {
      this.b = true;
      if (UIThreadUtils.isOnUiThread())
      {
        d.a().a(this.a);
        return;
      }
      UIThreadUtils.runOnUiThread(new DomManager.3(this));
    }
  }
  
  private void f(com.tencent.mtt.hippy.dom.node.b paramb)
  {
    if (paramb != null)
    {
      int i2 = paramb.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        f(paramb.getChildAt(i1));
        i1 += 1;
      }
      if ((paramb instanceof TextNode))
      {
        paramb = (TextNode)paramb;
        if (paramb.enableScale()) {
          paramb.dirty();
        }
      }
    }
  }
  
  private void g(com.tencent.mtt.hippy.dom.node.b paramb)
  {
    int i1 = 0;
    while (i1 < paramb.getChildCount())
    {
      com.tencent.mtt.hippy.dom.node.b localb = paramb.getChildAt(i1);
      if (localb.isJustLayout()) {
        g(localb);
      } else if (!localb.isVirtual()) {
        a(new DomManager.2(this, localb));
      }
      i1 += 1;
    }
  }
  
  private void h(com.tencent.mtt.hippy.dom.node.b paramb)
  {
    if (paramb.hasUpdates())
    {
      int i1 = 0;
      while (i1 < paramb.getChildCount())
      {
        h(paramb.getChildAt(i1));
        i1 += 1;
      }
      if (paramb.getData() != null)
      {
        TextNode localTextNode = (TextNode)paramb;
        if (!paramb.isVirtual()) {
          a(new DomManager.4(this, paramb, localTextNode));
        }
      }
      if (!TextUtils.equals("RootNode", paramb.getViewClass())) {
        j(paramb);
      }
      if (paramb.shouldNotifyOnLayout()) {
        i(paramb);
      }
      paramb.markUpdateSeen();
    }
  }
  
  private void i(com.tencent.mtt.hippy.dom.node.b paramb)
  {
    if ((this.n.getModuleManager().getJavaScriptModule(EventDispatcher.class) != null) && (!Float.isNaN(paramb.getLayoutX())) && (!Float.isNaN(paramb.getLayoutY())) && (!Float.isNaN(paramb.getLayoutWidth())) && (!Float.isNaN(paramb.getLayoutHeight())))
    {
      HippyMap localHippyMap1 = new HippyMap();
      localHippyMap1.pushObject("x", Integer.valueOf((int)PixelUtil.px2dp(paramb.getLayoutX())));
      localHippyMap1.pushObject("y", Integer.valueOf((int)PixelUtil.px2dp(paramb.getLayoutY())));
      localHippyMap1.pushObject("width", Integer.valueOf((int)PixelUtil.px2dp(paramb.getLayoutWidth())));
      localHippyMap1.pushObject("height", Integer.valueOf((int)PixelUtil.px2dp(paramb.getLayoutHeight())));
      HippyMap localHippyMap2 = new HippyMap();
      localHippyMap2.pushMap("layout", localHippyMap1);
      localHippyMap2.pushInt("target", paramb.getId());
      ((EventDispatcher)this.n.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveUIComponentEvent(paramb.getId(), "onLayout", localHippyMap2);
    }
  }
  
  private void j(com.tencent.mtt.hippy.dom.node.b paramb)
  {
    int i1 = paramb.getId();
    if (this.m.get(i1)) {
      return;
    }
    this.m.put(i1, true);
    float f2 = paramb.getLayoutX();
    float f1 = paramb.getLayoutY();
    for (com.tencent.mtt.hippy.dom.node.b localb = paramb.getParent(); (localb != null) && (localb.isJustLayout()); localb = localb.getParent())
    {
      f2 += localb.getLayoutX();
      f1 += localb.getLayoutY();
    }
    a(paramb, f2, f1);
  }
  
  void a()
  {
    this.o = true;
    b localb = this.d;
    if (localb != null) {
      localb.b();
    }
    this.l.a();
    this.n.removeInstanceLifecycleEventListener(this);
    this.e.clear();
    this.f.clear();
    this.n.removeEngineLifecycleEventListener(this);
    this.b = false;
    if (UIThreadUtils.isOnUiThread())
    {
      d.a().b(this.a);
      return;
    }
    UIThreadUtils.runOnUiThread(new DomManager.8(this));
  }
  
  public void a(int paramInt)
  {
    HippyRootView localHippyRootView = this.n.getInstance(paramInt);
    if (localHippyRootView != null)
    {
      StyleNode localStyleNode = new StyleNode();
      localStyleNode.setId(paramInt);
      localStyleNode.setViewClassName("RootNode");
      localStyleNode.setStyleWidth(localHippyRootView.getWidth());
      localStyleNode.setStyleHeight(localHippyRootView.getHeight());
      a(localStyleNode);
      this.j.a(paramInt);
      return;
    }
    LogUtils.e("DomManager", "createRootNode  RootView Null error");
  }
  
  public void a(int paramInt, HippyMap paramHippyMap, HippyRootView paramHippyRootView)
  {
    com.tencent.mtt.hippy.dom.node.b localb = this.d.c(paramInt);
    if (localb != null)
    {
      HippyMap localHippyMap = paramHippyMap;
      if (this.k != null)
      {
        Iterator localIterator = this.k.iterator();
        for (;;)
        {
          localHippyMap = paramHippyMap;
          if (!localIterator.hasNext()) {
            break;
          }
          paramHippyMap = ((a)localIterator.next()).onUpdateNode(paramInt, paramHippyRootView, paramHippyMap);
        }
      }
      paramHippyMap = localb.getTotalProps();
      int i2 = 0;
      paramHippyMap = DiffUtils.diffProps(paramHippyMap, localHippyMap, 0);
      localb.setProps(localHippyMap);
      this.i.a(localb, paramHippyMap);
      int i1 = i2;
      if (localb.isJustLayout()) {
        if (a((HippyMap)localHippyMap.get("style")))
        {
          i1 = i2;
          if (!b(localHippyMap)) {}
        }
        else
        {
          i1 = 1;
        }
      }
      if (i1 != 0)
      {
        a(localb, localHippyMap, paramHippyRootView);
        return;
      }
      if ((!localb.isJustLayout()) && (!localb.isVirtual())) {
        a(new DomManager.12(this, paramInt, localHippyMap));
      }
    }
    else
    {
      paramHippyMap = new StringBuilder();
      paramHippyMap.append("update error node is null id ");
      paramHippyMap.append(paramInt);
      LogUtils.d("DomManager", paramHippyMap.toString());
      paramHippyMap = this.n.getGlobalConfigs().getLogAdapter();
      paramHippyRootView = new StringBuilder();
      paramHippyRootView.append("update error node is null id ");
      paramHippyRootView.append(paramInt);
      paramHippyMap.log("DomManager", paramHippyRootView.toString());
    }
  }
  
  public void a(int paramInt, Promise paramPromise)
  {
    b(new DomManager.7(this, paramInt, paramPromise));
  }
  
  public void a(int paramInt, String paramString, HippyArray paramHippyArray, Promise paramPromise)
  {
    b(new DomManager.6(this, paramInt, paramString, paramHippyArray, paramPromise));
  }
  
  public void a(Layout paramLayout)
  {
    i locali = this.l;
    if (locali != null) {
      locali.a(paramLayout);
    }
  }
  
  public void a(HippyRootView paramHippyRootView, int paramInt1, int paramInt2, int paramInt3, String paramString, HippyMap paramHippyMap)
  {
    com.tencent.mtt.hippy.dom.node.b localb = this.d.c(paramInt2);
    if (localb != null)
    {
      if (this.k != null)
      {
        ??? = this.k.iterator();
        while (((Iterator)???).hasNext()) {
          paramHippyMap = ((a)((Iterator)???).next()).onCreateNode(paramInt1, paramHippyRootView, paramHippyMap);
        }
      }
      boolean bool3 = TextUtils.equals(localb.getViewClass(), "Text");
      ??? = this.n.getRenderManager().a(paramString, bool3, paramInt1, paramHippyRootView.getId());
      boolean bool1 = localb.isLazy();
      boolean bool2 = true;
      if ((!bool1) && (!this.n.getRenderManager().getControllerManager().a(paramString))) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      ((com.tencent.mtt.hippy.dom.node.b)???).setLazy(bool1);
      ((com.tencent.mtt.hippy.dom.node.b)???).setProps(paramHippyMap);
      if (("View".equals(((com.tencent.mtt.hippy.dom.node.b)???).getViewClass())) && (a((HippyMap)paramHippyMap.get("style"))) && (!b(paramHippyMap))) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("dom create node id: ");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(" mClassName ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(" pid ");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(" mIndex:");
      ((StringBuilder)localObject2).append(paramInt3);
      ((StringBuilder)localObject2).append(" isJustLayout :");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append(" isVirtual ");
      ((StringBuilder)localObject2).append(bool3);
      LogUtils.d("DomManager", ((StringBuilder)localObject2).toString());
      ((com.tencent.mtt.hippy.dom.node.b)???).updateProps(paramHippyMap);
      this.i.a(???, paramHippyMap);
      if (paramInt3 > localb.getChildCount())
      {
        paramInt3 = localb.getChildCount();
        LogUtils.d("DomManager", "createNode  addChild  error index > parent.size");
      }
      localb.addChildAt((FlexNode)???, paramInt3);
      this.d.b((com.tencent.mtt.hippy.dom.node.b)???);
      ((com.tencent.mtt.hippy.dom.node.b)???).setIsJustLayout(bool1);
      if ((!bool1) && (!((com.tencent.mtt.hippy.dom.node.b)???).isVirtual()))
      {
        localb = b((com.tencent.mtt.hippy.dom.node.b)???);
        localObject2 = a(localb, (com.tencent.mtt.hippy.dom.node.b)???, 0);
        if (!((com.tencent.mtt.hippy.dom.node.b)???).isLazy()) {
          synchronized (this.h)
          {
            c(new DomManager.10(this, paramHippyRootView, paramInt1, localb, (DomManager.b)localObject2, paramString, paramHippyMap));
          }
        }
        a(new DomManager.11(this, paramHippyRootView, paramInt1, localb, (DomManager.b)localObject2, paramString, paramHippyMap));
      }
    }
    else
    {
      LogUtils.d("DomManager", "Create Node DomManager Parent IS Null");
    }
  }
  
  public void a(a parama)
  {
    if (this.k == null) {
      try
      {
        if (this.k == null) {
          this.k = new CopyOnWriteArrayList();
        }
      }
      finally {}
    }
    this.k.add(parama);
  }
  
  public void a(com.tencent.mtt.hippy.dom.node.b paramb)
  {
    this.d.a(paramb);
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("renderBatchStart ");
    localStringBuilder.append(paramString);
    LogUtils.d("DomManager", localStringBuilder.toString());
    this.c = true;
  }
  
  public com.tencent.mtt.hippy.dom.node.b b(int paramInt)
  {
    return this.d.c(paramInt);
  }
  
  com.tencent.mtt.hippy.dom.node.b b(com.tencent.mtt.hippy.dom.node.b paramb)
  {
    do
    {
      paramb = paramb.getParent();
    } while (paramb.isJustLayout());
    return paramb;
  }
  
  public void b()
  {
    this.n.getThreadExecutor().postOnDomThread(new DomManager.9(this));
  }
  
  public void b(a parama)
  {
    if (this.k != null) {
      this.k.remove(parama);
    }
  }
  
  public void b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("renderBatchEnd ");
    localStringBuilder.append(paramString);
    LogUtils.d("DomManager", localStringBuilder.toString());
    this.c = false;
    d();
  }
  
  public void c()
  {
    if (!this.c) {
      d();
    }
  }
  
  public void c(int paramInt)
  {
    Object localObject1 = this.d.c(paramInt);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("dom  deleteNode delete  node.getId() ");
    ((StringBuilder)localObject2).append(paramInt);
    LogUtils.d("DomManager", ((StringBuilder)localObject2).toString());
    if (localObject1 != null)
    {
      if (((com.tencent.mtt.hippy.dom.node.b)localObject1).isJustLayout()) {
        g((com.tencent.mtt.hippy.dom.node.b)localObject1);
      } else if (!((com.tencent.mtt.hippy.dom.node.b)localObject1).isVirtual()) {
        a(new DomManager.15(this, paramInt));
      }
      localObject2 = ((com.tencent.mtt.hippy.dom.node.b)localObject1).getParent();
      if (localObject2 != null) {
        ((com.tencent.mtt.hippy.dom.node.b)localObject2).removeChildAt(((com.tencent.mtt.hippy.dom.node.b)localObject2).indexOf((FlexNode)localObject1));
      }
      c((com.tencent.mtt.hippy.dom.node.b)localObject1);
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("dom  deleteNode delete   node is null node.getId() ");
    ((StringBuilder)localObject1).append(paramInt);
    LogUtils.e("DomManager", ((StringBuilder)localObject1).toString());
  }
  
  void c(com.tencent.mtt.hippy.dom.node.b paramb)
  {
    if (this.k != null)
    {
      localObject = this.k.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((a)((Iterator)localObject).next()).onDeleteNode(paramb.getId());
      }
    }
    int i2 = paramb.getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      c(paramb.getChildAt(i1));
      i1 += 1;
    }
    if (TextUtils.equals("RootNode", paramb.getViewClass())) {
      this.d.b(paramb.getId());
    }
    this.d.a(paramb.getId());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("dom deleteNode  remove form mNodeRegistry node.getId() ");
    ((StringBuilder)localObject).append(paramb.getId());
    LogUtils.d("DomManager", ((StringBuilder)localObject).toString());
  }
  
  public void d()
  {
    int i2 = this.d.a();
    int i3 = 0;
    int i1 = 0;
    while (i1 < i2)
    {
      int i4 = this.d.d(i1);
      localObject1 = this.d.c(i4);
      if (localObject1 != null)
      {
        d((com.tencent.mtt.hippy.dom.node.b)localObject1);
        LogUtils.d("DomManager", " dom start  calculateLayout");
        ((com.tencent.mtt.hippy.dom.node.b)localObject1).calculateLayout();
        e((com.tencent.mtt.hippy.dom.node.b)localObject1);
        h((com.tencent.mtt.hippy.dom.node.b)localObject1);
        LogUtils.d("DomManager", "dom end  calculateLayout");
      }
      i1 += 1;
    }
    this.m.clear();
    LogUtils.d("DomManager", "dom batch complete");
    Object localObject1 = this.h;
    i1 = 0;
    for (;;)
    {
      i2 = i3;
      try
      {
        if (i1 < this.e.size())
        {
          c((f)this.e.get(i1));
          i1 += 1;
        }
        else
        {
          while (i2 < this.f.size())
          {
            c((f)this.f.get(i2));
            i2 += 1;
          }
          this.f.clear();
          this.e.clear();
          return;
        }
      }
      finally {}
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  void d(com.tencent.mtt.hippy.dom.node.b paramb)
  {
    if ((paramb != null) && (paramb.hasUpdates()))
    {
      int i1 = 0;
      while (i1 < paramb.getChildCount())
      {
        d(paramb.getChildAt(i1));
        i1 += 1;
      }
      paramb.layoutBefore(this.n);
    }
  }
  
  void e()
  {
    boolean bool = this.p;
    int i1 = 0;
    if (bool) {
      this.b = false;
    } else {
      d.a().a(this.a);
    }
    synchronized (this.h)
    {
      Iterator localIterator = this.g.iterator();
      if (this.g.size() > 0) {
        i1 = 1;
      }
      long l1 = System.currentTimeMillis();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        f localf = (f)localIterator.next();
        if (localf != null)
        {
          bool = this.o;
          if (!bool) {
            try
            {
              localf.a();
            }
            catch (RuntimeException localRuntimeException)
            {
              localRuntimeException.printStackTrace();
            }
          }
        }
        localIterator.remove();
      } while ((!this.b) || (System.currentTimeMillis() - l1 <= 500L));
      if (i1 != 0) {
        this.j.b();
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  void e(com.tencent.mtt.hippy.dom.node.b paramb)
  {
    if ((paramb != null) && (paramb.hasUpdates()))
    {
      int i1 = 0;
      while (i1 < paramb.getChildCount())
      {
        e(paramb.getChildAt(i1));
        i1 += 1;
      }
      paramb.layoutAfter(this.n);
    }
  }
  
  public void forceUpdateNode(int paramInt)
  {
    f(this.d.c(paramInt));
    if (!this.c) {
      d();
    }
  }
  
  public void onEnginePause()
  {
    this.p = true;
  }
  
  public void onEngineResume()
  {
    this.p = false;
  }
  
  public void onInstanceDestroy(int paramInt) {}
  
  public void onInstanceLoad(int paramInt)
  {
    this.n.getThreadExecutor().postOnDomThread(new DomManager.1(this, paramInt));
  }
  
  public void onInstancePause(int paramInt) {}
  
  public void onInstanceResume(int paramInt) {}
  
  public void updateNodeSize(int paramInt1, int paramInt2, int paramInt3)
  {
    com.tencent.mtt.hippy.dom.node.b localb = this.d.c(paramInt1);
    if (localb != null)
    {
      localb.setStyleWidth(paramInt2);
      localb.setStyleHeight(paramInt3);
      if (!this.c) {
        d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.DomManager
 * JD-Core Version:    0.7.0.1
 */