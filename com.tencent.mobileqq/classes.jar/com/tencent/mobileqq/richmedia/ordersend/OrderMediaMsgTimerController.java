package com.tencent.mobileqq.richmedia.ordersend;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class OrderMediaMsgTimerController
  implements Handler.Callback
{
  private OrderMediaMsgTimerController.IMsgTimeoutListener a;
  private Handler b = new Handler(Looper.getMainLooper(), null);
  private Handler c = new Handler(ThreadManager.getSubThreadLooper(), this);
  private Runnable d;
  private Runnable e;
  private HashMap<Long, Runnable> f;
  
  public OrderMediaMsgTimerController(OrderMediaMsgTimerController.IMsgTimeoutListener paramIMsgTimeoutListener)
  {
    this.a = paramIMsgTimeoutListener;
  }
  
  public Runnable a(long paramLong)
  {
    OrderMediaMsgTimerController.1 local1 = new OrderMediaMsgTimerController.1(this, paramLong);
    this.b.postDelayed(local1, 8000L);
    return local1;
  }
  
  public Runnable a(String paramString)
  {
    paramString = new OrderMediaMsgTimerController.2(this, paramString);
    this.b.postDelayed(paramString, 8000L);
    return paramString;
  }
  
  public void a()
  {
    Handler localHandler = this.b;
    if (localHandler != null)
    {
      localHandler.removeCallbacks(this.d);
      this.d = null;
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.f == null) {
      this.f = new HashMap();
    }
    if (this.f.containsKey(Long.valueOf(paramLong))) {
      return;
    }
    OrderMediaMsgTimerController.4 local4 = new OrderMediaMsgTimerController.4(this, paramLong, paramInt1, paramInt2);
    this.b.postDelayed(local4, 30000L);
    this.f.put(Long.valueOf(paramLong), local4);
  }
  
  public void a(Runnable paramRunnable)
  {
    Handler localHandler = this.b;
    if (localHandler != null) {
      localHandler.removeCallbacks(paramRunnable);
    }
  }
  
  public void b()
  {
    Handler localHandler = this.b;
    if (localHandler != null)
    {
      localHandler.removeCallbacks(this.e);
      this.e = null;
    }
  }
  
  public boolean b(long paramLong)
  {
    if (this.d != null) {
      return false;
    }
    this.d = new OrderMediaMsgTimerController.3(this, paramLong);
    this.b.postDelayed(this.d, 30000L);
    return true;
  }
  
  public void c()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Runnable localRunnable = (Runnable)((Iterator)localObject).next();
        Handler localHandler = this.b;
        if (localHandler != null) {
          localHandler.removeCallbacks(localRunnable);
        }
      }
      this.f.clear();
      this.f = null;
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.b = null;
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.c = null;
    }
  }
  
  public void c(long paramLong)
  {
    Object localObject = this.f;
    if ((localObject != null) && (((HashMap)localObject).containsKey(Long.valueOf(paramLong))))
    {
      localObject = this.b;
      if (localObject != null) {
        ((Handler)localObject).removeCallbacks((Runnable)this.f.get(Long.valueOf(paramLong)));
      }
      this.f.remove(Long.valueOf(paramLong));
    }
  }
  
  public boolean d(long paramLong)
  {
    if (this.e != null) {
      return false;
    }
    this.e = new OrderMediaMsgTimerController.5(this, paramLong);
    this.b.postDelayed(this.e, 30000L);
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    long l = 0L;
    OrderMediaMsgTimerController.IMsgTimeoutListener localIMsgTimeoutListener;
    switch (i)
    {
    default: 
      break;
    case 103: 
      if (paramMessage.obj != null) {
        l = ((Long)paramMessage.obj).longValue();
      }
      paramMessage = this.a;
      if (paramMessage != null) {
        paramMessage.c(l);
      }
      break;
    case 102: 
      if (paramMessage.obj != null) {
        l = ((Long)paramMessage.obj).longValue();
      }
      localIMsgTimeoutListener = this.a;
      if (localIMsgTimeoutListener != null) {
        localIMsgTimeoutListener.a(l, paramMessage.arg1, paramMessage.arg2);
      }
      break;
    case 101: 
      if (paramMessage.obj != null) {
        l = ((Long)paramMessage.obj).longValue();
      }
      paramMessage = this.a;
      if (paramMessage != null) {
        paramMessage.b(l);
      }
      break;
    case 100: 
      if (paramMessage.obj != null)
      {
        localIMsgTimeoutListener = this.a;
        if (localIMsgTimeoutListener != null) {
          localIMsgTimeoutListener.a(paramMessage.obj);
        }
      }
      break;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgTimerController
 * JD-Core Version:    0.7.0.1
 */