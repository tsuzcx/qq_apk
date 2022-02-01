package com.tencent.mtt.hippy.modules.nativemodules.timer;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyEngineLifecycleEventListener;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyHandlerThread;
import com.tencent.mtt.hippy.common.ThreadExecutor;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

@HippyNativeModule(name="TimerModule")
public class TimerModule
  extends HippyNativeModuleBase
  implements Handler.Callback, HippyEngineLifecycleEventListener
{
  private boolean a = false;
  private HashMap<String, TimerModule.a> b = new HashMap();
  private Handler c;
  private long d = 0L;
  
  public TimerModule(HippyEngineContext paramHippyEngineContext)
  {
    super(paramHippyEngineContext);
    paramHippyEngineContext.addEngineLifecycleEventListener(this);
  }
  
  private void a()
  {
    this.d = 0L;
    this.c.removeMessages(100);
  }
  
  private void a(TimerModule.a parama)
  {
    long l2 = 0L;
    if ((this.a) || (this.b.isEmpty())) {
      a();
    }
    while ((parama == null) || ((this.d != 0L) && (parama.d + parama.c >= this.d))) {
      return;
    }
    this.d = (parama.d + parama.c);
    long l1;
    if (this.d < 0L)
    {
      this.d = SystemClock.elapsedRealtime();
      l1 = 0L;
      this.c.removeMessages(100);
      parama = this.c;
      if (l1 > 0L) {
        break label132;
      }
      l1 = l2;
    }
    label132:
    for (;;)
    {
      parama.sendEmptyMessageDelayed(100, l1);
      return;
      l1 = this.d - SystemClock.elapsedRealtime();
      break;
    }
  }
  
  @HippyMethod(name="clearInterval")
  public void clearInterval(String paramString)
  {
    this.b.remove(paramString);
    a(null);
  }
  
  @HippyMethod(name="clearTimeout")
  public void clearTimeout(String paramString)
  {
    this.b.remove(paramString);
    a(null);
  }
  
  public void destroy()
  {
    this.b.clear();
    a();
    this.mContext.removeEngineLifecycleEventListener(this);
    super.destroy();
  }
  
  public void doFrame()
  {
    this.d = 0L;
    this.c.removeMessages(100);
    long l = SystemClock.elapsedRealtime();
    Iterator localIterator = this.b.entrySet().iterator();
    Object localObject1 = null;
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      if (localObject2 != null)
      {
        localObject2 = (TimerModule.a)((Map.Entry)localObject2).getValue();
        if (localObject2 != null) {
          if (((TimerModule.a)localObject2).d + ((TimerModule.a)localObject2).c <= l)
          {
            if (((TimerModule.a)localObject2).e != null) {
              ((TimerModule.a)localObject2).e.resolve(null);
            }
            if (!((TimerModule.a)localObject2).b)
            {
              localIterator.remove();
            }
            else
            {
              ((TimerModule.a)localObject2).d = l;
              if ((localObject1 == null) || (((TimerModule.a)localObject2).d + ((TimerModule.a)localObject2).c < localObject1.d + localObject1.c)) {
                localObject1 = localObject2;
              }
            }
          }
          else if ((localObject1 == null) || (((TimerModule.a)localObject2).d + ((TimerModule.a)localObject2).c < localObject1.d + localObject1.c))
          {
            localObject1 = localObject2;
          }
        }
      }
    }
    a(localObject1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      doFrame();
    }
  }
  
  public void initialize()
  {
    this.c = new Handler(this.mContext.getThreadExecutor().getJsBridgeThread().getLooper(), this);
  }
  
  public void onEnginePause()
  {
    if (this.c != null) {
      this.c.post(new TimerModule.2(this));
    }
  }
  
  public void onEngineResume()
  {
    if (this.c != null) {
      this.c.post(new TimerModule.1(this));
    }
  }
  
  @HippyMethod(name="setInterval")
  public void setInterval(int paramInt, String paramString, Promise paramPromise)
  {
    paramPromise = new TimerModule.a(paramString, SystemClock.elapsedRealtime(), paramInt, true, paramPromise);
    this.b.put(paramString, paramPromise);
    a(paramPromise);
  }
  
  @HippyMethod(name="setTimeout")
  public void setTimeout(int paramInt, String paramString, Promise paramPromise)
  {
    paramPromise = new TimerModule.a(paramString, SystemClock.elapsedRealtime(), paramInt, false, paramPromise);
    this.b.put(paramString, paramPromise);
    a(paramPromise);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.timer.TimerModule
 * JD-Core Version:    0.7.0.1
 */