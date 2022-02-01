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
  private final Set<Integer> e = Collections.synchronizedSet(new HashSet());
  private Set<b> f;
  
  public AnimationModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
  }
  
  private HippyMap a(int paramInt, HippyRootView paramHippyRootView, HippyMap paramHippyMap)
  {
    if (paramHippyMap == null) {
      return null;
    }
    if ((paramHippyMap.containsKey("handleMessageByAnimation")) && (paramHippyMap.getBoolean("handleMessageByAnimation"))) {
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
      HippyMap localHippyMap = new HippyMap();
      ArrayList localArrayList = new ArrayList();
      a(paramInt, paramHippyMap, localHippyMap, localArrayList);
      a(paramInt, paramHippyRootView, paramHippyMap, localArrayList);
      localHippyMap.pushBoolean("handleMessageByAnimation", true);
      return localHippyMap;
    }
    catch (Throwable paramHippyRootView)
    {
      paramHippyRootView.printStackTrace();
    }
    return paramHippyMap;
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
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        b localb = (b)this.b.get(i);
        this.f.add(localb);
        localIterator.remove();
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
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void a(int paramInt, HippyRootView paramHippyRootView, HippyMap paramHippyMap, ArrayList<Integer> paramArrayList)
  {
    b localb = (b)this.b.get(paramInt);
    Object localObject;
    if (localb != null)
    {
      localObject = localb.d().iterator();
      while (((Iterator)localObject).hasNext())
      {
        a locala = (a)((Iterator)localObject).next();
        if ((locala != null) && ((paramArrayList == null) || (!paramArrayList.contains(Integer.valueOf(locala.a)))))
        {
          locala.b(paramInt);
          ((Iterator)localObject).remove();
        }
      }
    }
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localObject = localb;
      if (localb == null)
      {
        localObject = new b(paramInt, paramHippyRootView);
        this.b.append(paramInt, localObject);
      }
      paramHippyRootView = paramArrayList.iterator();
      while (paramHippyRootView.hasNext())
      {
        paramArrayList = (Integer)paramHippyRootView.next();
        paramArrayList = (a)this.a.get(paramArrayList.intValue());
        if (paramArrayList != null)
        {
          ((b)localObject).a(paramArrayList);
          paramArrayList.a(paramInt);
        }
      }
      ((b)localObject).a(paramHippyMap);
      return;
    }
    this.b.remove(paramInt);
  }
  
  private void a(int paramInt, HippyArray paramHippyArray1, HippyArray paramHippyArray2, ArrayList<Integer> paramArrayList)
  {
    if (paramHippyArray1 == null) {
      return;
    }
    int j = paramHippyArray1.size();
    int i = 0;
    while (i < j)
    {
      Object localObject2 = paramHippyArray1.get(i);
      Object localObject1;
      if ((localObject2 instanceof HippyMap))
      {
        localObject1 = (HippyMap)localObject2;
        if (b((HippyMap)localObject1))
        {
          int k = ((HippyMap)localObject1).getInt("animationId");
          if (paramArrayList != null) {
            paramArrayList.add(Integer.valueOf(k));
          }
          localObject1 = a(paramInt, k);
          if (localObject1 == null) {
            break label174;
          }
        }
        else
        {
          localObject2 = new HippyMap();
          a(paramInt, (HippyMap)localObject1, (HippyMap)localObject2, paramArrayList);
          paramHippyArray2.pushMap((HippyMap)localObject2);
          break label174;
        }
      }
      else
      {
        localObject1 = localObject2;
        if ((localObject2 instanceof HippyArray))
        {
          localObject1 = new HippyArray();
          a(paramInt, (HippyArray)localObject2, (HippyArray)localObject1, paramArrayList);
          paramHippyArray2.pushArray((HippyArray)localObject1);
          break label174;
        }
      }
      paramHippyArray2.pushObject(localObject1);
      label174:
      i += 1;
    }
  }
  
  private void a(int paramInt, HippyMap paramHippyMap1, HippyMap paramHippyMap2, ArrayList<Integer> paramArrayList)
  {
    if (paramHippyMap1 == null) {
      return;
    }
    Iterator localIterator = paramHippyMap1.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject2 = paramHippyMap1.get(str);
      if ((localObject2 instanceof HippyMap))
      {
        localObject1 = (HippyMap)localObject2;
        if (b((HippyMap)localObject1))
        {
          int i = ((HippyMap)localObject1).getInt("animationId");
          if (paramArrayList != null) {
            paramArrayList.add(Integer.valueOf(i));
          }
          localObject1 = a(paramInt, i);
          if (localObject1 == null) {
            continue;
          }
        }
      }
      do
      {
        paramHippyMap2.pushObject(str, localObject1);
        break;
        localObject2 = new HippyMap();
        a(paramInt, (HippyMap)localObject1, (HippyMap)localObject2, paramArrayList);
        paramHippyMap2.pushMap(str, (HippyMap)localObject2);
        break;
        localObject1 = localObject2;
      } while (!(localObject2 instanceof HippyArray));
      Object localObject1 = new HippyArray();
      a(paramInt, (HippyArray)localObject2, (HippyArray)localObject1, paramArrayList);
      paramHippyMap2.pushArray(str, (HippyArray)localObject1);
    }
  }
  
  private void a(HippyMap paramHippyMap)
  {
    if (paramHippyMap == null) {
      return;
    }
    if (paramHippyMap.containsKey("startValue"))
    {
      Object localObject = paramHippyMap.get("startValue");
      if ((localObject instanceof HippyMap))
      {
        int i = ((HippyMap)localObject).getInt("animationId");
        paramHippyMap.remove("startValue");
        paramHippyMap.pushObject("startValue", ((a)this.a.get(i)).g());
      }
    }
  }
  
  private void a(b paramb)
  {
    if (paramb == null) {
      return;
    }
    try
    {
      localObject = new HippyMap();
      a(paramb.a(), paramb.c(), (HippyMap)localObject, null);
      ((HippyMap)localObject).pushBoolean("handleMessageByAnimation", true);
      this.mContext.getDomManager().a(paramb.a(), (HippyMap)localObject, paramb.b());
      return;
    }
    catch (Throwable paramb)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateAnimationNodeProps: ");
      ((StringBuilder)localObject).append(paramb.getMessage());
      LogUtils.d("AnimationModule", ((StringBuilder)localObject).toString());
    }
  }
  
  private boolean b(HippyMap paramHippyMap)
  {
    boolean bool2 = false;
    if (paramHippyMap == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramHippyMap.containsKey("animationId"))
    {
      bool1 = bool2;
      if (paramHippyMap.size() == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @HippyMethod(name="createAnimation")
  public void createAnimation(int paramInt, String paramString, HippyMap paramHippyMap)
  {
    if (this.a.get(paramInt) != null) {
      return;
    }
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
  
  @HippyMethod(name="createAnimationSet")
  public void createAnimationSet(int paramInt, HippyMap paramHippyMap)
  {
    c localc = new c(paramInt);
    localc.a(this);
    if (paramHippyMap != null) {
      try
      {
        if (paramHippyMap.containsKey("repeatCount")) {
          localc.c(paramHippyMap.getInt("repeatCount"));
        }
        paramHippyMap = paramHippyMap.getArray("children");
        int j = paramHippyMap.size();
        int i = 0;
        Object localObject;
        boolean bool2;
        for (boolean bool1 = false; i < j; bool1 = bool2)
        {
          localObject = paramHippyMap.getMap(i);
          if (!((HippyMap)localObject).containsKey("animationId")) {
            break;
          }
          int k = ((HippyMap)localObject).getInt("animationId");
          bool2 = bool1;
          if (i != 0)
          {
            bool2 = bool1;
            if (((HippyMap)localObject).containsKey("follow")) {
              bool2 = ((HippyMap)localObject).getBoolean("follow");
            }
          }
          localc.a((a)this.a.get(k), bool2);
          i += 1;
        }
        this.a.append(paramInt, localc);
      }
      catch (Throwable paramHippyMap)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("createAnimationSet: ");
        ((StringBuilder)localObject).append(paramHippyMap.getMessage());
        LogUtils.d("AnimationModule", ((StringBuilder)localObject).toString());
      }
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
    if ((localObject instanceof c))
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
    int i = paramMessage.what;
    if (i != 100)
    {
      if (i != 101) {}
    }
    else
    {
      long l1;
      long l2;
      do
      {
        a();
        break;
        if (this.c.hasMessages(101)) {
          break;
        }
        l1 = SystemClock.elapsedRealtime();
        l2 = this.d;
      } while (l1 - l2 >= 16L);
      this.c.sendEmptyMessageDelayed(101, l1 - l2);
    }
    return true;
  }
  
  public void initialize()
  {
    super.initialize();
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
    if (parama == null) {
      return;
    }
    parama = parama.e();
    if (parama == null) {
      return;
    }
    parama = parama.iterator();
    while (parama.hasNext())
    {
      int i = ((Integer)parama.next()).intValue();
      this.e.add(Integer.valueOf(i));
    }
    if (!this.c.hasMessages(100)) {
      this.c.sendEmptyMessage(100);
    }
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
    Handler localHandler = this.c;
    if (localHandler != null) {
      localHandler.post(new AnimationModule.2(this));
    }
  }
  
  public void onEngineResume()
  {
    Handler localHandler = this.c;
    if (localHandler != null) {
      localHandler.post(new AnimationModule.1(this));
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
    if ((locala != null) && ((locala.a() == null) || (!locala.a().isRunning())))
    {
      if ((locala instanceof e))
      {
        a(paramHippyMap);
        ((e)locala).a(paramHippyMap);
        locala.onAnimationUpdate(null);
      }
      return;
    }
    LogUtils.d("AnimationModule", "trying to update a unexisted animation or the animation has started");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.animation.AnimationModule
 * JD-Core Version:    0.7.0.1
 */