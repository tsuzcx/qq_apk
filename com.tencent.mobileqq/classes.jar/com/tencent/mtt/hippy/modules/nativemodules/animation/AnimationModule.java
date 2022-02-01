package com.tencent.mtt.hippy.modules.nativemodules.animation;

import android.animation.Animator;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyEngineLifecycleEventListener;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.annotation.HippyNativeModule.Thread;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyHandlerThread;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.common.ThreadExecutor;
import com.tencent.mtt.hippy.dom.DomManager;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

@HippyNativeModule(name="AnimationModule", thread=HippyNativeModule.Thread.DOM)
public class AnimationModule
  extends HippyNativeModuleBase
  implements Handler.Callback, HippyEngineLifecycleEventListener, com.tencent.mtt.hippy.dom.node.a, a.a
{
  public static final String ANIMATION_ID = "animationId";
  public static final String EVENT_NAME_ANIMATION_CANCEL = "onHippyAnimationCancel";
  public static final String EVENT_NAME_ANIMATION_END = "onHippyAnimationEnd";
  public static final String EVENT_NAME_ANIMATION_REPEAT = "onHippyAnimationRepeat";
  public static final String EVENT_NAME_ANIMATION_START = "onHippyAnimationStart";
  public static final String FOLLOW = "follow";
  public static final String HANDLE_MESSAGE_BY_ANIMATION = "handleMessageByAnimation";
  public static final String TIMING = "timing";
  public static final String USE_ANIMATION = "useAnimation";
  private SparseArray<a> a;
  private SparseArray<b> b;
  private Handler c;
  private long d;
  private Set<Integer> e;
  private Set<b> f;
  
  public AnimationModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private HippyMap a(int paramInt, HippyRootView paramHippyRootView, HippyMap paramHippyMap)
  {
    if (paramHippyMap == null) {}
    while ((paramHippyMap.containsKey("handleMessageByAnimation")) && (paramHippyMap.getBoolean("handleMessageByAnimation"))) {
      return paramHippyMap;
    }
    if (!paramHippyMap.containsKey("useAnimation"))
    {
      a(paramInt, paramHippyRootView, null, null);
      return paramHippyMap;
    }
    try
    {
      if (!paramHippyMap.getBoolean("useAnimation"))
      {
        a(paramInt, paramHippyRootView, null, null);
        return paramHippyMap;
      }
    }
    catch (Throwable paramHippyRootView)
    {
      paramHippyRootView.printStackTrace();
      return paramHippyMap;
    }
    HippyMap localHippyMap = new HippyMap();
    ArrayList localArrayList = new ArrayList();
    a(paramInt, paramHippyMap, localHippyMap, localArrayList);
    a(paramInt, paramHippyRootView, paramHippyMap, localArrayList);
    localHippyMap.pushBoolean("handleMessageByAnimation", true);
    return localHippyMap;
  }
  
  private Object a(int paramInt1, int paramInt2)
  {
    Object localObject = (a)this.a.get(paramInt2);
    if (localObject != null) {
      return ((a)localObject).f();
    }
    localObject = (b)this.b.get(paramInt1);
    if (localObject != null)
    {
      localObject = ((b)localObject).d().iterator();
      while (((Iterator)localObject).hasNext())
      {
        a locala = (a)((Iterator)localObject).next();
        if ((locala != null) && (locala.d() == paramInt2)) {
          return locala.f();
        }
      }
    }
    return Float.valueOf((0.0F / 0.0F));
  }
  
  private void a()
  {
    this.d = SystemClock.elapsedRealtime();
    if (this.f == null) {
      this.f = new HashSet();
    }
    this.f.clear();
    synchronized (this.e)
    {
      Iterator localIterator = this.e.iterator();
      if (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        b localb = (b)this.b.get(i);
        this.f.add(localb);
        localIterator.remove();
      }
    }
    ??? = this.f.iterator();
    while (((Iterator)???).hasNext())
    {
      a((b)((Iterator)???).next());
      ((Iterator)???).remove();
    }
    if ((this.mContext != null) && (this.mContext.getDomManager() != null)) {
      this.mContext.getDomManager().c();
    }
  }
  
  private void a(int paramInt, HippyRootView paramHippyRootView, HippyMap paramHippyMap, ArrayList<Integer> paramArrayList)
  {
    Object localObject = (b)this.b.get(paramInt);
    if (localObject != null)
    {
      Iterator localIterator = ((b)localObject).d().iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if ((locala != null) && ((paramArrayList == null) || (!paramArrayList.contains(Integer.valueOf(locala.a)))))
        {
          locala.b(paramInt);
          localIterator.remove();
        }
      }
    }
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      this.b.remove(paramInt);
      return;
    }
    if (localObject == null)
    {
      paramHippyRootView = new b(paramInt, paramHippyRootView);
      this.b.append(paramInt, paramHippyRootView);
    }
    for (;;)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject = (Integer)paramArrayList.next();
        localObject = (a)this.a.get(((Integer)localObject).intValue());
        if (localObject != null)
        {
          paramHippyRootView.a((a)localObject);
          ((a)localObject).a(paramInt);
        }
      }
      paramHippyRootView.a(paramHippyMap);
      return;
      paramHippyRootView = (HippyRootView)localObject;
    }
  }
  
  private void a(int paramInt, HippyArray paramHippyArray1, HippyArray paramHippyArray2, ArrayList<Integer> paramArrayList)
  {
    if (paramHippyArray1 == null) {
      return;
    }
    int j = paramHippyArray1.size();
    int i = 0;
    label14:
    Object localObject1;
    if (i < j)
    {
      localObject1 = paramHippyArray1.get(i);
      if (!(localObject1 instanceof HippyMap)) {
        break label138;
      }
      if (!b((HippyMap)localObject1)) {
        break label106;
      }
      int k = ((HippyMap)localObject1).getInt("animationId");
      if (paramArrayList != null) {
        paramArrayList.add(Integer.valueOf(k));
      }
      localObject1 = a(paramInt, k);
      if (localObject1 != null) {
        paramHippyArray2.pushObject(localObject1);
      }
    }
    for (;;)
    {
      i += 1;
      break label14;
      break;
      label106:
      Object localObject2 = new HippyMap();
      a(paramInt, (HippyMap)localObject1, (HippyMap)localObject2, paramArrayList);
      paramHippyArray2.pushMap((HippyMap)localObject2);
      continue;
      label138:
      if ((localObject1 instanceof HippyArray))
      {
        localObject2 = new HippyArray();
        a(paramInt, (HippyArray)localObject1, (HippyArray)localObject2, paramArrayList);
        paramHippyArray2.pushArray((HippyArray)localObject2);
      }
      else
      {
        paramHippyArray2.pushObject(localObject1);
      }
    }
  }
  
  private void a(int paramInt, HippyMap paramHippyMap1, HippyMap paramHippyMap2, ArrayList<Integer> paramArrayList)
  {
    if (paramHippyMap1 == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramHippyMap1.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject1 = paramHippyMap1.get(str);
        Object localObject2;
        if ((localObject1 instanceof HippyMap))
        {
          if (b((HippyMap)localObject1))
          {
            int i = ((HippyMap)localObject1).getInt("animationId");
            if (paramArrayList != null) {
              paramArrayList.add(Integer.valueOf(i));
            }
            localObject1 = a(paramInt, i);
            if (localObject1 != null) {
              paramHippyMap2.pushObject(str, localObject1);
            }
          }
          else
          {
            localObject2 = new HippyMap();
            a(paramInt, (HippyMap)localObject1, (HippyMap)localObject2, paramArrayList);
            paramHippyMap2.pushMap(str, (HippyMap)localObject2);
          }
        }
        else if ((localObject1 instanceof HippyArray))
        {
          localObject2 = new HippyArray();
          a(paramInt, (HippyArray)localObject1, (HippyArray)localObject2, paramArrayList);
          paramHippyMap2.pushArray(str, (HippyArray)localObject2);
        }
        else
        {
          paramHippyMap2.pushObject(str, localObject1);
        }
      }
    }
  }
  
  private void a(HippyMap paramHippyMap)
  {
    if (paramHippyMap == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while (!paramHippyMap.containsKey("startValue"));
      localObject = paramHippyMap.get("startValue");
    } while (!(localObject instanceof HippyMap));
    int i = ((HippyMap)localObject).getInt("animationId");
    paramHippyMap.remove("startValue");
    paramHippyMap.pushObject("startValue", ((a)this.a.get(i)).g());
  }
  
  private void a(b paramb)
  {
    if (paramb == null) {
      return;
    }
    try
    {
      HippyMap localHippyMap = new HippyMap();
      a(paramb.a(), paramb.c(), localHippyMap, null);
      localHippyMap.pushBoolean("handleMessageByAnimation", true);
      this.mContext.getDomManager().a(paramb.a(), localHippyMap, paramb.b());
      return;
    }
    catch (Throwable paramb) {}
  }
  
  private boolean b(HippyMap paramHippyMap)
  {
    if (paramHippyMap == null) {}
    while ((!paramHippyMap.containsKey("animationId")) || (paramHippyMap.size() != 1)) {
      return false;
    }
    return true;
  }
  
  @HippyMethod(name="createAnimation")
  public void createAnimation(int paramInt, String paramString, HippyMap paramHippyMap)
  {
    if (this.a.get(paramInt) != null) {}
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(paramString)) {
        this.a.put(paramInt, null);
      }
      try
      {
        if (TextUtils.equals(paramString, "timing"))
        {
          a(paramHippyMap);
          paramString = new e(paramInt);
          paramString.a(this);
          paramString.a(paramHippyMap);
          this.a.append(paramInt, paramString);
          return;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  @HippyMethod(name="createAnimationSet")
  public void createAnimationSet(int paramInt, HippyMap paramHippyMap)
  {
    boolean bool1 = false;
    c localc = new c(paramInt);
    localc.a(this);
    if (paramHippyMap != null) {}
    for (;;)
    {
      try
      {
        if (paramHippyMap.containsKey("repeatCount")) {
          localc.c(paramHippyMap.getInt("repeatCount"));
        }
        paramHippyMap = paramHippyMap.getArray("children");
        int j = paramHippyMap.size();
        i = 0;
        if (i < j)
        {
          localHippyMap = paramHippyMap.getMap(i);
          boolean bool2 = localHippyMap.containsKey("animationId");
          if (bool2) {
            continue;
          }
        }
      }
      catch (Throwable paramHippyMap)
      {
        int i;
        HippyMap localHippyMap;
        int k;
        continue;
        continue;
      }
      this.a.append(paramInt, localc);
      return;
      k = localHippyMap.getInt("animationId");
      if ((i == 0) || (!localHippyMap.containsKey("follow"))) {
        continue;
      }
      bool1 = localHippyMap.getBoolean("follow");
      localc.a((a)this.a.get(k), bool1);
      i += 1;
    }
  }
  
  public void destroy()
  {
    this.mContext.removeEngineLifecycleEventListener(this);
    if (this.mContext.getDomManager() != null) {
      this.mContext.getDomManager().b(this);
    }
    super.destroy();
  }
  
  @HippyMethod(name="destroyAnimation")
  public void destroyAnimation(int paramInt)
  {
    stopAnimation(paramInt);
    Object localObject = (a)this.a.get(paramInt);
    if ((localObject != null) && ((localObject instanceof c)))
    {
      localObject = ((c)localObject).j();
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          int i = ((Integer)((Iterator)localObject).next()).intValue();
          stopAnimation(i);
          this.a.remove(i);
        }
      }
    }
    this.a.remove(paramInt);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (!this.c.hasMessages(101))
      {
        long l = SystemClock.elapsedRealtime();
        if (l - this.d >= 16L)
        {
          a();
        }
        else
        {
          this.c.sendEmptyMessageDelayed(101, l - this.d);
          continue;
          a();
        }
      }
    }
  }
  
  public void initialize()
  {
    super.initialize();
    this.e = Collections.synchronizedSet(new HashSet());
    this.mContext.addEngineLifecycleEventListener(this);
    this.c = new Handler(this.mContext.getThreadExecutor().getDomThread().getLooper(), this);
    this.a = new SparseArray();
    this.b = new SparseArray();
    if (this.mContext.getDomManager() != null) {
      this.mContext.getDomManager().a(this);
    }
  }
  
  public void onAnimationCancel(a parama)
  {
    ((EventDispatcher)this.mContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent("onHippyAnimationCancel", Integer.valueOf(parama.d()));
  }
  
  public void onAnimationEnd(a parama)
  {
    onAnimationUpdate(parama);
    ((EventDispatcher)this.mContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent("onHippyAnimationEnd", Integer.valueOf(parama.d()));
  }
  
  public void onAnimationRepeat(a parama)
  {
    ((EventDispatcher)this.mContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent("onHippyAnimationRepeat", Integer.valueOf(parama.d()));
  }
  
  public void onAnimationStart(a parama)
  {
    ((EventDispatcher)this.mContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent("onHippyAnimationStart", Integer.valueOf(parama.d()));
  }
  
  public void onAnimationUpdate(a parama)
  {
    if (parama == null) {}
    do
    {
      do
      {
        return;
        parama = parama.e();
      } while (parama == null);
      parama = parama.iterator();
      while (parama.hasNext())
      {
        int i = ((Integer)parama.next()).intValue();
        this.e.add(Integer.valueOf(i));
      }
    } while (this.c.hasMessages(100));
    this.c.sendEmptyMessage(100);
  }
  
  public HippyMap onCreateNode(int paramInt, HippyRootView paramHippyRootView, HippyMap paramHippyMap)
  {
    return a(paramInt, paramHippyRootView, paramHippyMap);
  }
  
  public void onDeleteNode(int paramInt)
  {
    a(paramInt, null, null, null);
  }
  
  public void onEnginePause()
  {
    if (this.c != null) {
      this.c.post(new AnimationModule.2(this));
    }
  }
  
  public void onEngineResume()
  {
    if (this.c != null) {
      this.c.post(new AnimationModule.1(this));
    }
  }
  
  public HippyMap onUpdateNode(int paramInt, HippyRootView paramHippyRootView, HippyMap paramHippyMap)
  {
    return a(paramInt, paramHippyRootView, paramHippyMap);
  }
  
  @HippyMethod(name="pauseAnimation")
  public void pauseAnimation(int paramInt)
  {
    a locala = (a)this.a.get(paramInt);
    if (locala != null) {
      locala.i();
    }
  }
  
  @HippyMethod(name="resumeAnimation")
  public void resumeAnimation(int paramInt)
  {
    a locala = (a)this.a.get(paramInt);
    if (locala != null) {
      locala.h();
    }
  }
  
  @HippyMethod(name="startAnimation")
  public void startAnimation(int paramInt)
  {
    a locala = (a)this.a.get(paramInt);
    if (locala != null) {
      locala.b();
    }
  }
  
  @HippyMethod(name="stopAnimation")
  public void stopAnimation(int paramInt)
  {
    a locala = (a)this.a.get(paramInt);
    if (locala != null) {
      locala.c();
    }
  }
  
  @HippyMethod(name="updateAnimation")
  public void updateAnimation(int paramInt, HippyMap paramHippyMap)
  {
    LogUtils.d("shit", Thread.currentThread().getName());
    a locala = (a)this.a.get(paramInt);
    if ((locala == null) || ((locala.a() != null) && (locala.a().isRunning()))) {
      LogUtils.d("AnimationModule", "trying to update a unexisted animation or the animation has started");
    }
    while (!(locala instanceof e)) {
      return;
    }
    a(paramHippyMap);
    ((e)locala).a(paramHippyMap);
    locala.onAnimationUpdate(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.animation.AnimationModule
 * JD-Core Version:    0.7.0.1
 */