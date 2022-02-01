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
    if ((!this.a) && (!this.b.isEmpty()))
    {
      if ((parama != null) && ((this.d == 0L) || (parama.d + parama.c < this.d)))
      {
        this.d = (parama.d + parama.c);
        long l1 = this.d;
        if (l1 < 0L)
        {
          this.d = SystemClock.elapsedRealtime();
          l1 = 0L;
        }
        else
        {
          l1 -= SystemClock.elapsedRealtime();
        }
        this.c.removeMessages(100);
        parama = this.c;
        long l2 = l1;
        if (l1 <= 0L) {
          l2 = 0L;
        }
        parama.sendEmptyMessageDelayed(100, l2);
      }
    }
    else {
      a();
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
        if (localObject2 != null)
        {
          if (((TimerModule.a)localObject2).d + ((TimerModule.a)localObject2).c <= l)
          {
            if (((TimerModule.a)localObject2).e != null) {
              ((TimerModule.a)localObject2).e.resolve(null);
            }
            if (!((TimerModule.a)localObject2).b)
            {
              localIterator.remove();
              continue;
            }
            ((TimerModule.a)localObject2).d = l;
            if (localObject1 != null) {
              if (((TimerModule.a)localObject2).d + ((TimerModule.a)localObject2).c >= localObject1.d + localObject1.c) {
                continue;
              }
            }
          }
          else
          {
            if ((localObject1 != null) && (((TimerModule.a)localObject2).d + ((TimerModule.a)localObject2).c >= localObject1.d + localObject1.c)) {
              continue;
            }
          }
          localObject1 = localObject2;
        }
      }
    }
    a(localObject1);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100) {
      doFrame();
    }
    return false;
  }
  
  public void initialize()
  {
    this.c = new Handler(this.mContext.getThreadExecutor().getJsBridgeThread().getLooper(), this);
  }
  
  public void onEnginePause()
  {
    Handler localHandler = this.c;
    if (localHandler != null) {
      localHandler.post(new TimerModule.2(this));
    }
  }
  
  public void onEngineResume()
  {
    Handler localHandler = this.c;
    if (localHandler != null) {
      localHandler.post(new TimerModule.1(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.nativemodules.timer.TimerModule
 * JD-Core Version:    0.7.0.1
 */