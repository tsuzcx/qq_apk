package com.tencent.upload.network.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.upload.common.Const.UploadRetCode;
import com.tencent.upload.common.Const.b;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadConfiguration.NetworkStateObserver;
import com.tencent.upload.network.route.RouteFactory;
import com.tencent.upload.network.route.UploadRoute;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class c
  implements b
{
  private Const.b a;
  private HandlerThread b;
  private Handler c;
  private a d;
  private volatile boolean e = false;
  private boolean f;
  private int g;
  private String h;
  private List<a> i;
  private BlockingQueue<a> j;
  private com.tencent.upload.network.route.c k;
  private UploadRoute l;
  private int m = 0;
  private int n = 0;
  private UploadConfiguration.NetworkStateObserver o;
  
  public c(Const.b paramb)
  {
    this.a = paramb;
  }
  
  private void a(int paramInt, UploadRoute paramUploadRoute)
  {
    com.tencent.upload.common.b.b(n(), "createSession num: " + paramInt + " route:" + paramUploadRoute);
    this.l = paramUploadRoute.clone();
    int i1 = 0;
    while (i1 < paramInt)
    {
      e locale = new e(this.b.getLooper(), this, this.a);
      if (locale.a(paramUploadRoute)) {
        this.i.add(locale);
      }
      i1 += 1;
    }
  }
  
  private void a(Looper paramLooper)
  {
    if (paramLooper == null) {
      throw new IllegalArgumentException("initHandler Exception looper == null !!");
    }
    this.c = new b(this, paramLooper);
  }
  
  public static boolean a(int paramInt)
  {
    Object localObject = UploadConfiguration.getNetworkUnavailableRetCode();
    com.tencent.upload.common.b.c("SessionPool", "check network unavailable code, retCodeList:" + (String)localObject + ", targetCode:" + paramInt);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(",");
      if ((localObject != null) && (localObject.length > 0))
      {
        int i2 = localObject.length;
        int i1 = 0;
        while (i1 < i2)
        {
          String str = localObject[i1].trim();
          if ((!TextUtils.isEmpty(str)) && (str.equals(String.valueOf(paramInt))))
          {
            com.tencent.upload.common.b.c("SessionPool", "check network unavailable: true");
            return true;
          }
          i1 += 1;
        }
      }
    }
    com.tencent.upload.common.b.c("SessionPool", "check network unavailable: false");
    return false;
  }
  
  private boolean b(int paramInt)
  {
    this.e = false;
    this.f = false;
    com.tencent.upload.common.b.b(n(), "do change route.");
    d();
    if (d.a()) {
      this.k = RouteFactory.b(this.a);
    }
    while (r())
    {
      UploadRoute localUploadRoute = this.k.a(this.l, paramInt);
      if (localUploadRoute == null)
      {
        com.tencent.upload.common.b.b("SessionPool", "changeRoute get next route null");
        return false;
        if (this.k == null) {
          this.k = RouteFactory.a(this.a);
        }
      }
      else
      {
        c(localUploadRoute);
        com.tencent.upload.common.b.b("SessionPool", "changeRoute get next route !");
      }
    }
    for (;;)
    {
      return true;
      com.tencent.upload.common.b.b("SessionPool", "changeRoute network is not available return");
    }
  }
  
  private void c(UploadRoute paramUploadRoute)
  {
    if (paramUploadRoute == null)
    {
      com.tencent.upload.common.b.b(n(), "create session route == " + paramUploadRoute);
      return;
    }
    a(this.g, paramUploadRoute);
  }
  
  private boolean c(int paramInt)
  {
    Object localObject = UploadConfiguration.getChangeRouteRetCode();
    com.tencent.upload.common.b.c(n(), "check needChangeNextRoute, retCodeList:" + (String)localObject + ", targetCode:" + paramInt);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split(",");
      if ((localObject != null) && (localObject.length > 0))
      {
        int i2 = localObject.length;
        int i1 = 0;
        while (i1 < i2)
        {
          String str = localObject[i1].trim();
          if ((!TextUtils.isEmpty(str)) && (str.equals(String.valueOf(paramInt))))
          {
            com.tencent.upload.common.b.c(n(), "check needChangeNextRoute: true");
            return true;
          }
          i1 += 1;
        }
      }
    }
    com.tencent.upload.common.b.c(n(), "check needChangeNextRoute: false");
    return false;
  }
  
  private static boolean d(int paramInt)
  {
    return (paramInt == Const.UploadRetCode.EINPROGRESS.getCode()) || (paramInt == Const.UploadRetCode.EAGAIN.getCode());
  }
  
  private boolean d(a parama)
  {
    return (parama != null) && (parama.d() == a.b.c);
  }
  
  private String n()
  {
    return "SessionPool-" + this.a;
  }
  
  private void o()
  {
    switch (2.a[this.a.ordinal()])
    {
    default: 
      this.g = 1;
      return;
    case 1: 
      this.g = 2;
      return;
    }
    this.g = 2;
  }
  
  private void p()
  {
    this.f = false;
    if (d.a()) {}
    for (this.k = RouteFactory.b(this.a); r(); this.k = RouteFactory.a(this.a))
    {
      c(this.k.a());
      return;
    }
    com.tencent.upload.common.b.b("SessionPool", "initSessions network is not available !");
  }
  
  private void q()
  {
    this.o = new UploadConfiguration.NetworkStateObserver()
    {
      public void onStateChanged(boolean paramAnonymousBoolean)
      {
        com.tencent.upload.common.b.b("SessionPool", "hasNetwork: " + paramAnonymousBoolean);
        if (!paramAnonymousBoolean) {
          return;
        }
        c.b(c.this).postDelayed(new Runnable()
        {
          public void run()
          {
            c.a(c.this);
          }
        }, 500L);
      }
    };
    UploadConfiguration.registerNetworkStateObserver(this.o);
  }
  
  private static boolean r()
  {
    return UploadConfiguration.isNetworkAvailable();
  }
  
  public Const.b a()
  {
    return this.a;
  }
  
  public void a(a parama)
  {
    if (parama != null) {}
    for (;;)
    {
      try
      {
        boolean bool = this.i.contains(parama);
        if (!bool) {
          return;
        }
        notify();
        com.tencent.upload.common.b.c("[connect] " + n(), "session is ready --- id:" + parama.hashCode());
        this.i.remove(parama);
        this.j.offer(parama);
        if ((this.j.size() == 1) && (!this.f))
        {
          com.tencent.upload.common.b.c("[connect] " + n(), "sessionPool is inited now !");
          this.f = true;
          this.d.b(this.a);
          continue;
        }
        if (this.j.size() <= 0) {
          continue;
        }
      }
      finally {}
      this.f = true;
    }
  }
  
  public void a(a parama, int paramInt, String paramString)
  {
    if ((parama == null) || (!this.i.contains(parama))) {}
    do
    {
      return;
      com.tencent.upload.common.b.c("[connect] " + n(), "failed to open session:" + parama.hashCode());
      this.i.remove(parama);
      com.tencent.upload.common.b.c("[connect] " + n(), "onOpenFailed remove from mDetectingSession, current size:" + this.i.size());
    } while ((!parama.b().isDuplicate(this.l)) || (this.j.size() != 0) || (this.i.size() != 0));
    if (r())
    {
      parama = this.k.a(this.l, 0);
      if (parama == null)
      {
        com.tencent.upload.common.b.c("[connect] " + n(), "all ip failed, mCurrentRoute:" + this.l);
        e();
        return;
      }
      if (d.a())
      {
        com.tencent.upload.common.b.e("[connect] " + n(), "can't connect debug server: " + this.l);
        e();
        return;
      }
      c(parama);
      return;
    }
    com.tencent.upload.common.b.d("[connect] " + n(), "network is not available !!");
  }
  
  public void a(a parama)
  {
    this.d = parama;
  }
  
  public void a(UploadRoute paramUploadRoute)
  {
    d();
    this.e = false;
    this.f = false;
    a(this.g, paramUploadRoute);
    com.tencent.upload.common.b.b(n(), "reset session pool with redirect route: " + paramUploadRoute);
  }
  
  public void b()
  {
    com.tencent.upload.common.b.b("SessionPool", "SessionPool init.");
    this.b = new HandlerThread(n());
    this.b.start();
    a(this.b.getLooper());
    this.j = new LinkedBlockingQueue(6);
    this.i = new LinkedList();
    q();
    o();
    p();
  }
  
  public void b(a parama)
  {
    if (parama == null) {
      return;
    }
    com.tencent.upload.common.b.d("[connect] " + n(), "onSessionClosed ! Session:" + parama.hashCode());
    this.j.remove(parama);
    f();
  }
  
  public void b(a parama, int paramInt, String paramString)
  {
    if (parama == null) {
      return;
    }
    boolean bool = r();
    this.n = paramInt;
    com.tencent.upload.common.b.d("[connect] " + n(), "onSessionError ! Session:" + parama.hashCode() + " errCode=" + paramInt + " errMsg=" + paramString + " networkAvailable=" + bool);
    this.j.remove(parama);
    com.tencent.upload.common.b.d("[connect] " + n(), "remove session " + parama.hashCode() + " queue size: " + this.j.size());
    if (c(paramInt))
    {
      com.tencent.upload.common.b.d("[connect] " + n(), "[dochangeRoute] errCode=" + paramInt + " errMsg=" + paramString + " currentRoute=" + parama.b().toString());
      if (b(6))
      {
        com.tencent.upload.common.b.c("[connect] " + n(), "changeRoute success");
        return;
      }
      com.tencent.upload.common.b.c("[connect] " + n(), "changeRoute failed, allIpFailed");
      e();
      return;
    }
    if ((paramInt == Const.UploadRetCode.EINPROGRESS.getCode()) || (paramInt == Const.UploadRetCode.EAGAIN.getCode()) || (paramInt == Const.UploadRetCode.EHOSTUNREACH.getCode()) || (paramInt == Const.UploadRetCode.ENETUNREACH.getCode()) || (paramInt == Const.UploadRetCode.ENETDOWN.getCode()) || (paramInt == Const.UploadRetCode.ETIMEDOUT.getCode()) || (paramInt == Const.UploadRetCode.ECONNABORTED.getCode()) || (paramInt == 526))
    {
      com.tencent.upload.common.b.d("[connect] " + n(), "errCode=" + paramInt + " 网络异常 !");
      return;
    }
    if ((paramInt == 30100) || (paramInt == Const.UploadRetCode.NETWORK_NOT_AVAILABLE.getCode()))
    {
      com.tencent.upload.common.b.d("[connect] " + n(), "errCode=" + paramInt + " 网络不可用 !");
      return;
    }
    com.tencent.upload.common.b.c("[connect] " + n(), "reconnect session: " + parama.hashCode());
    parama.a();
    parama.a(parama.b());
    this.i.add(parama);
  }
  
  public void b(UploadRoute paramUploadRoute)
  {
    this.n = 0;
    if ((TextUtils.isEmpty(this.h)) || (!paramUploadRoute.getIp().equalsIgnoreCase(this.h)))
    {
      com.tencent.upload.common.b.b(n(), "save recent route: " + paramUploadRoute);
      this.h = paramUploadRoute.getIp();
      if (this.k != null) {
        this.k.a(paramUploadRoute);
      }
    }
  }
  
  /* Error */
  public a c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 220	com/tencent/upload/network/a/c:j	Ljava/util/concurrent/BlockingQueue;
    //   6: invokeinterface 312 1 0
    //   11: ifeq +23 -> 34
    //   14: aload_0
    //   15: getfield 220	com/tencent/upload/network/a/c:j	Ljava/util/concurrent/BlockingQueue;
    //   18: invokeinterface 445 1 0
    //   23: checkcast 252	com/tencent/upload/network/a/a
    //   26: invokeinterface 447 1 0
    //   31: ifeq +80 -> 111
    //   34: aload_0
    //   35: getfield 220	com/tencent/upload/network/a/c:j	Ljava/util/concurrent/BlockingQueue;
    //   38: invokeinterface 312 1 0
    //   43: ifle +85 -> 128
    //   46: aload_0
    //   47: getfield 220	com/tencent/upload/network/a/c:j	Ljava/util/concurrent/BlockingQueue;
    //   50: invokeinterface 450 1 0
    //   55: checkcast 252	com/tencent/upload/network/a/a
    //   58: astore_1
    //   59: aload_1
    //   60: invokeinterface 447 1 0
    //   65: ifeq +20 -> 85
    //   68: aload_1
    //   69: invokeinterface 425 1 0
    //   74: aload_0
    //   75: getfield 220	com/tencent/upload/network/a/c:j	Ljava/util/concurrent/BlockingQueue;
    //   78: aload_1
    //   79: invokeinterface 367 2 0
    //   84: pop
    //   85: aload_0
    //   86: invokespecial 63	com/tencent/upload/network/a/c:n	()Ljava/lang/String;
    //   89: ldc_w 452
    //   92: invokestatic 88	com/tencent/upload/common/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload_0
    //   96: iconst_1
    //   97: aload_0
    //   98: getfield 96	com/tencent/upload/network/a/c:l	Lcom/tencent/upload/network/route/UploadRoute;
    //   101: invokespecial 226	com/tencent/upload/network/a/c:a	(ILcom/tencent/upload/network/route/UploadRoute;)V
    //   104: aload_0
    //   105: ldc2_w 453
    //   108: invokevirtual 458	java/lang/Object:wait	(J)V
    //   111: aload_0
    //   112: getfield 220	com/tencent/upload/network/a/c:j	Ljava/util/concurrent/BlockingQueue;
    //   115: invokeinterface 450 1 0
    //   120: checkcast 252	com/tencent/upload/network/a/a
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: areturn
    //   128: aload_0
    //   129: invokespecial 63	com/tencent/upload/network/a/c:n	()Ljava/lang/String;
    //   132: ldc_w 460
    //   135: invokestatic 88	com/tencent/upload/common/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: goto -53 -> 85
    //   141: astore_1
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_1
    //   145: athrow
    //   146: astore_1
    //   147: ldc 145
    //   149: new 65	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 462
    //   159: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_1
    //   163: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 88	com/tencent/upload/common/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: goto -61 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	c
    //   58	69	1	locala	a
    //   141	4	1	localObject	Object
    //   146	17	1	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	34	141	finally
    //   34	85	141	finally
    //   85	104	141	finally
    //   104	111	141	finally
    //   111	124	141	finally
    //   128	138	141	finally
    //   147	172	141	finally
    //   104	111	146	java/lang/InterruptedException
  }
  
  public void c(a parama)
  {
    com.tencent.upload.common.b.b(n(), "offer session --- id:" + parama.hashCode());
    if ((parama.d() == a.b.c) && (!this.j.contains(parama))) {
      this.j.offer(parama);
    }
    f();
  }
  
  public void d()
  {
    com.tencent.upload.common.b.b(n(), "cleanSessions --- " + this.j.size());
    Iterator localIterator = this.j.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (d(locala)) {
        locala.a();
      }
    }
    this.j.clear();
  }
  
  public void e()
  {
    if (this.d != null) {
      this.d.a(this);
    }
  }
  
  public void f()
  {
    com.tencent.upload.common.b.b(n(), "notifyIdle --- " + this.j.size());
    if ((this.j.size() == 0) && (this.i.size() == 0)) {
      this.d.a(this, Const.UploadRetCode.NO_SESSION.getCode());
    }
  }
  
  public void g()
  {
    com.tencent.upload.common.b.b("SessionPool", n() + " rebuildSessions");
    if (this.c != null)
    {
      this.c.removeMessages(110001);
      this.c.sendMessageDelayed(this.c.obtainMessage(110001), 1000L);
    }
  }
  
  public void h()
  {
    if ((d(this.n)) && (b(0))) {
      return;
    }
    this.e = false;
    d();
    com.tencent.upload.common.b.b(n(), "reset session pool");
    p();
  }
  
  public boolean i()
  {
    return (this.f) || (this.j.size() > 0);
  }
  
  public void j()
  {
    if (this.e) {
      return;
    }
    com.tencent.upload.common.b.b("SessionPool", "close session pool");
    this.e = true;
    this.j.clear();
  }
  
  public void k()
  {
    com.tencent.upload.common.b.b("SessionPool", n() + " setCloseTimer");
    if (this.c != null)
    {
      this.c.removeMessages(110000);
      this.c.sendMessageDelayed(this.c.obtainMessage(110000), 240000L);
    }
  }
  
  public void l()
  {
    if (this.c != null) {
      this.c.removeMessages(110000);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(c paramc);
    
    public abstract void a(c paramc, int paramInt);
    
    public abstract void b(Const.b paramb);
  }
  
  private static class b
    extends Handler
  {
    private WeakReference<c> a;
    private int b = 1;
    
    public b(c paramc, Looper paramLooper)
    {
      super();
      this.a = new WeakReference(paramc);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        do
        {
          do
          {
            return;
          } while ((this.a == null) || (this.a.get() == null));
          com.tencent.upload.common.b.b("SessionPool", "receive msg MSG_CLOSE_POOL");
          ((c)this.a.get()).j();
          return;
          if (!c.m()) {
            break;
          }
          com.tencent.upload.common.b.b("SessionPool", "receive msg MSG_REBUILD_SESSIONS hasNetwork:true");
        } while ((this.a == null) || (this.a.get() == null));
        paramMessage = (c)this.a.get();
        if ((c.c(paramMessage).size() == 0) && (c.d(paramMessage).size() == 0)) {
          paramMessage.h();
        }
        this.b = 1;
        return;
        com.tencent.upload.common.b.b("SessionPool", "receive msg MSG_REBUILD_SESSIONS n == " + this.b);
      } while (this.b > 6);
      paramMessage = obtainMessage(110001);
      int i = this.b;
      this.b = (i + 1);
      sendMessageDelayed(paramMessage, (1 << i) * 1000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.network.a.c
 * JD-Core Version:    0.7.0.1
 */