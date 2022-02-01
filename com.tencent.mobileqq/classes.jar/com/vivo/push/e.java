package com.vivo.push;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.vivo.push.b.a;
import com.vivo.push.b.c;
import com.vivo.push.b.n;
import com.vivo.push.c.y;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.ContextDelegate;
import com.vivo.push.util.s;
import com.vivo.push.util.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
{
  private static volatile e a;
  private long b = -1L;
  private long c = -1L;
  private long d = -1L;
  private long e = -1L;
  private long f = -1L;
  private long g = -1L;
  private Context h;
  private boolean i = true;
  private com.vivo.push.util.b j;
  private String k;
  private String l;
  private SparseArray<e.a> m = new SparseArray();
  private int n = 0;
  private Boolean o;
  private Long p;
  private boolean q;
  private IPushClientFactory r = new d();
  private int s;
  
  private e.a a(com.vivo.push.b.b paramb, IPushActionListener paramIPushActionListener)
  {
    paramIPushActionListener = new e.a(paramb, paramIPushActionListener);
    String str = a(paramIPushActionListener);
    paramb.b(str);
    paramIPushActionListener.a(new h(this, paramb, str));
    return paramIPushActionListener;
  }
  
  public static e a()
  {
    try
    {
      if (a == null) {
        a = new e();
      }
      e locale = a;
      return locale;
    }
    finally {}
  }
  
  private String a(e.a parama)
  {
    try
    {
      this.m.put(this.n, parama);
      int i1 = this.n;
      this.n = (i1 + 1);
      parama = Integer.toString(i1);
      return parama;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  private static boolean a(long paramLong)
  {
    long l1 = SystemClock.elapsedRealtime();
    return (paramLong == -1L) || (l1 <= paramLong) || (l1 >= paramLong + 2000L);
  }
  
  private void c(String paramString)
  {
    m.c(new f(this, paramString));
  }
  
  /* Error */
  private e.a d(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +37 -> 40
    //   6: aload_1
    //   7: invokestatic 146	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   10: istore_2
    //   11: aload_0
    //   12: getfield 60	com/vivo/push/e:m	Landroid/util/SparseArray;
    //   15: iload_2
    //   16: invokevirtual 150	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   19: checkcast 74	com/vivo/push/e$a
    //   22: astore_1
    //   23: aload_0
    //   24: getfield 60	com/vivo/push/e:m	Landroid/util/SparseArray;
    //   27: iload_2
    //   28: invokevirtual 154	android/util/SparseArray:delete	(I)V
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: areturn
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    //   40: aload_0
    //   41: monitorexit
    //   42: aconst_null
    //   43: areturn
    //   44: astore_1
    //   45: goto -5 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	e
    //   0	48	1	paramString	String
    //   10	18	2	i1	int
    // Exception table:
    //   from	to	target	type
    //   6	31	35	finally
    //   6	31	44	java/lang/Exception
  }
  
  private void e(String paramString)
  {
    m.a(new k(this, paramString));
  }
  
  private void m()
  {
    this.l = null;
    this.j.b("APP_ALIAS");
  }
  
  private boolean n()
  {
    if (this.o == null)
    {
      boolean bool;
      if ((l() >= 1230L) && (com.vivo.push.util.z.e(this.h))) {
        bool = true;
      } else {
        bool = false;
      }
      this.o = Boolean.valueOf(bool);
    }
    return this.o.booleanValue();
  }
  
  public final void a(Context paramContext)
  {
    try
    {
      if (this.h == null)
      {
        this.h = ContextDelegate.getContext(paramContext);
        this.q = s.c(paramContext, paramContext.getPackageName());
        w.b().a(this.h);
        a(new com.vivo.push.b.g());
        this.j = new com.vivo.push.util.b();
        this.j.a(this.h, "com.vivo.push_preferences.appconfig_v1");
        this.k = f();
        this.l = this.j.b("APP_ALIAS", null);
      }
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public final void a(Intent paramIntent, PushMessageCallback paramPushMessageCallback)
  {
    paramIntent = this.r.createReceiverCommand(paramIntent);
    Context localContext = a().h;
    if (paramIntent == null)
    {
      com.vivo.push.util.o.a("PushClientManager", "sendCommand, null command!");
      if (localContext != null) {
        com.vivo.push.util.o.c(localContext, "[执行指令失败]指令空！");
      }
      return;
    }
    y localy = this.r.createReceiveTask(paramIntent);
    if (localy == null)
    {
      com.vivo.push.util.o.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(paramIntent)));
      if (localContext != null)
      {
        paramPushMessageCallback = new StringBuilder("[执行指令失败]指令");
        paramPushMessageCallback.append(paramIntent);
        paramPushMessageCallback.append("任务空！");
        com.vivo.push.util.o.c(localContext, paramPushMessageCallback.toString());
      }
      return;
    }
    if ((localContext != null) && (!(paramIntent instanceof n))) {
      com.vivo.push.util.o.a(localContext, "[接收指令]".concat(String.valueOf(paramIntent)));
    }
    localy.a(paramPushMessageCallback);
    m.a(localy);
  }
  
  final void a(IPushActionListener paramIPushActionListener)
  {
    if (this.h == null)
    {
      if (paramIPushActionListener != null) {
        paramIPushActionListener.onStateChanged(102);
      }
      return;
    }
    this.k = f();
    if (!TextUtils.isEmpty(this.k))
    {
      if (paramIPushActionListener != null) {
        paramIPushActionListener.onStateChanged(0);
      }
      return;
    }
    if (!a(this.b))
    {
      if (paramIPushActionListener != null) {
        paramIPushActionListener.onStateChanged(1002);
      }
      return;
    }
    this.b = SystemClock.elapsedRealtime();
    Object localObject1 = this.h.getPackageName();
    Context localContext = this.h;
    Object localObject2 = null;
    if (localContext == null)
    {
      localObject1 = localObject2;
      if (paramIPushActionListener != null)
      {
        paramIPushActionListener.onStateChanged(102);
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = new com.vivo.push.b.b(true, (String)localObject1);
      ((com.vivo.push.b.b)localObject1).g();
      ((com.vivo.push.b.b)localObject1).d();
      ((com.vivo.push.b.b)localObject1).e();
      ((com.vivo.push.b.b)localObject1).a(100);
      if (this.q)
      {
        if (!n())
        {
          localObject1 = localObject2;
          if (paramIPushActionListener != null)
          {
            paramIPushActionListener.onStateChanged(101);
            localObject1 = localObject2;
          }
        }
        else
        {
          localObject1 = a((com.vivo.push.b.b)localObject1, paramIPushActionListener);
        }
      }
      else if (((com.vivo.push.b.b)localObject1).a(this.h) == 2)
      {
        localObject1 = a((com.vivo.push.b.b)localObject1, paramIPushActionListener);
      }
      else
      {
        a((o)localObject1);
        localObject1 = localObject2;
        if (paramIPushActionListener != null)
        {
          paramIPushActionListener.onStateChanged(0);
          localObject1 = localObject2;
        }
      }
    }
    if (localObject1 == null) {
      return;
    }
    ((e.a)localObject1).a(new g(this, (e.a)localObject1));
    ((e.a)localObject1).a();
  }
  
  public final void a(o paramo)
  {
    Context localContext = a().h;
    if (paramo == null)
    {
      com.vivo.push.util.o.a("PushClientManager", "sendCommand, null command!");
      if (localContext != null) {
        com.vivo.push.util.o.c(localContext, "[执行指令失败]指令空！");
      }
      return;
    }
    Object localObject = this.r.createTask(paramo);
    if (localObject == null)
    {
      com.vivo.push.util.o.a("PushClientManager", "sendCommand, null command task! pushCommand = ".concat(String.valueOf(paramo)));
      if (localContext != null)
      {
        localObject = new StringBuilder("[执行指令失败]指令");
        ((StringBuilder)localObject).append(paramo);
        ((StringBuilder)localObject).append("任务空！");
        com.vivo.push.util.o.c(localContext, ((StringBuilder)localObject).toString());
      }
      return;
    }
    com.vivo.push.util.o.d("PushClientManager", "client--sendCommand, command = ".concat(String.valueOf(paramo)));
    m.a((l)localObject);
  }
  
  public final void a(String paramString)
  {
    this.k = paramString;
    this.j.a("APP_TOKEN", this.k);
  }
  
  public final void a(String paramString, int paramInt)
  {
    paramString = d(paramString);
    if (paramString != null)
    {
      paramString.a(paramInt, new Object[0]);
      return;
    }
    com.vivo.push.util.o.d("PushClientManager", "notifyStatusChanged token is null");
  }
  
  public final void a(String paramString, int paramInt, Object... paramVarArgs)
  {
    paramString = d(paramString);
    if (paramString != null)
    {
      paramString.a(paramInt, paramVarArgs);
      return;
    }
    com.vivo.push.util.o.d("PushClientManager", "notifyApp token is null");
  }
  
  final void a(String paramString, IPushActionListener paramIPushActionListener)
  {
    if (this.h == null)
    {
      if (paramIPushActionListener != null) {
        paramIPushActionListener.onStateChanged(102);
      }
      return;
    }
    if ((!TextUtils.isEmpty(this.l)) && (this.l.equals(paramString)))
    {
      if (paramIPushActionListener != null) {
        paramIPushActionListener.onStateChanged(0);
      }
      return;
    }
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramString);
    localObject = new a(true, this.h.getPackageName(), (ArrayList)localObject);
    ((a)localObject).a(100);
    if (this.q)
    {
      if (!n())
      {
        if (paramIPushActionListener != null) {
          paramIPushActionListener.onStateChanged(101);
        }
        return;
      }
      if (!a(this.d))
      {
        if (paramIPushActionListener != null) {
          paramIPushActionListener.onStateChanged(1002);
        }
        return;
      }
      this.d = SystemClock.elapsedRealtime();
      paramIPushActionListener = a(new e.a((c)localObject, paramIPushActionListener));
      ((a)localObject).b(paramIPushActionListener);
      if (TextUtils.isEmpty(this.k))
      {
        a(paramIPushActionListener, 30001);
        return;
      }
      if (TextUtils.isEmpty(paramString))
      {
        a(paramIPushActionListener, 30002);
        return;
      }
      if (paramString.length() > 70L)
      {
        a(paramIPushActionListener, 30003);
        return;
      }
      a((o)localObject);
      e(paramIPushActionListener);
      return;
    }
    a((o)localObject);
    if (paramIPushActionListener != null) {
      paramIPushActionListener.onStateChanged(0);
    }
  }
  
  final void a(ArrayList<String> paramArrayList, IPushActionListener paramIPushActionListener)
  {
    Object localObject = this.h;
    if (localObject == null)
    {
      if (paramIPushActionListener != null) {
        paramIPushActionListener.onStateChanged(102);
      }
      return;
    }
    localObject = new com.vivo.push.b.z(true, ((Context)localObject).getPackageName(), paramArrayList);
    ((com.vivo.push.b.z)localObject).a(500);
    if (this.q)
    {
      if (!n())
      {
        if (paramIPushActionListener != null) {
          paramIPushActionListener.onStateChanged(101);
        }
        return;
      }
      if (!a(this.f))
      {
        if (paramIPushActionListener != null) {
          paramIPushActionListener.onStateChanged(1002);
        }
        return;
      }
      this.f = SystemClock.elapsedRealtime();
      paramIPushActionListener = a(new e.a((c)localObject, paramIPushActionListener));
      ((com.vivo.push.b.z)localObject).b(paramIPushActionListener);
      if (TextUtils.isEmpty(this.k))
      {
        a(paramIPushActionListener, 20001);
        return;
      }
      if (paramArrayList.size() < 0)
      {
        a(paramIPushActionListener, 20002);
        return;
      }
      int i1 = c().size();
      if (paramArrayList.size() + i1 > 500)
      {
        a(paramIPushActionListener, 20004);
        return;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        if (((String)paramArrayList.next()).length() > 70L)
        {
          a(paramIPushActionListener, 20003);
          return;
        }
      }
      a((o)localObject);
      e(paramIPushActionListener);
      return;
    }
    a((o)localObject);
    if (paramIPushActionListener != null) {
      paramIPushActionListener.onStateChanged(0);
    }
  }
  
  public final void a(List<String> paramList)
  {
    try
    {
      if (paramList.size() <= 0) {
        return;
      }
      Object localObject = this.j.b("APP_TAGS", null);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        localObject = new JSONObject();
      } else {
        localObject = new JSONObject((String)localObject);
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((JSONObject)localObject).put((String)paramList.next(), System.currentTimeMillis());
      }
      paramList = ((JSONObject)localObject).toString();
      if (TextUtils.isEmpty(paramList))
      {
        this.j.b("APP_TAGS");
        return;
      }
      this.j.a("APP_TAGS", paramList);
      return;
    }
    catch (JSONException paramList)
    {
      paramList.printStackTrace();
      this.j.b("APP_TAGS");
    }
  }
  
  protected final void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  protected final void b()
  {
    Context localContext = this.h;
    if (localContext != null) {
      com.vivo.push.util.z.c(localContext);
    }
  }
  
  final void b(IPushActionListener paramIPushActionListener)
  {
    if (this.h == null)
    {
      if (paramIPushActionListener != null) {
        paramIPushActionListener.onStateChanged(102);
      }
      return;
    }
    if ("".equals(this.k))
    {
      paramIPushActionListener.onStateChanged(0);
      return;
    }
    if (!a(this.c))
    {
      if (paramIPushActionListener != null) {
        paramIPushActionListener.onStateChanged(1002);
      }
      return;
    }
    this.c = SystemClock.elapsedRealtime();
    Object localObject1 = this.h.getPackageName();
    Object localObject3 = this.h;
    Object localObject2 = null;
    if (localObject3 == null)
    {
      localObject1 = localObject2;
      if (paramIPushActionListener != null)
      {
        paramIPushActionListener.onStateChanged(102);
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject3 = new com.vivo.push.b.b(false, (String)localObject1);
      ((com.vivo.push.b.b)localObject3).d();
      ((com.vivo.push.b.b)localObject3).e();
      ((com.vivo.push.b.b)localObject3).g();
      ((com.vivo.push.b.b)localObject3).a(100);
      if (this.q)
      {
        if (!n())
        {
          localObject1 = localObject2;
          if (paramIPushActionListener != null)
          {
            paramIPushActionListener.onStateChanged(101);
            localObject1 = localObject2;
          }
        }
        else
        {
          localObject1 = new e.a((c)localObject3, paramIPushActionListener);
          paramIPushActionListener = a((e.a)localObject1);
          ((com.vivo.push.b.b)localObject3).b(paramIPushActionListener);
          ((e.a)localObject1).a(new j(this, (com.vivo.push.b.b)localObject3, paramIPushActionListener));
        }
      }
      else if (((com.vivo.push.b.b)localObject3).a(this.h) == 2)
      {
        localObject1 = a((com.vivo.push.b.b)localObject3, paramIPushActionListener);
      }
      else
      {
        a((o)localObject3);
        localObject1 = localObject2;
        if (paramIPushActionListener != null)
        {
          paramIPushActionListener.onStateChanged(0);
          localObject1 = localObject2;
        }
      }
    }
    if (localObject1 == null) {
      return;
    }
    ((e.a)localObject1).a(new i(this));
    ((e.a)localObject1).a();
  }
  
  public final void b(String paramString)
  {
    this.l = paramString;
    this.j.a("APP_ALIAS", paramString);
  }
  
  final void b(String paramString, IPushActionListener paramIPushActionListener)
  {
    if (this.h == null)
    {
      if (paramIPushActionListener != null) {
        paramIPushActionListener.onStateChanged(102);
      }
      return;
    }
    if (TextUtils.isEmpty(this.l))
    {
      if (paramIPushActionListener != null) {
        paramIPushActionListener.onStateChanged(0);
      }
      return;
    }
    Object localObject = new ArrayList();
    ((ArrayList)localObject).add(paramString);
    localObject = new a(false, this.h.getPackageName(), (ArrayList)localObject);
    ((a)localObject).a(100);
    if (this.q)
    {
      if (!n())
      {
        if (paramIPushActionListener != null) {
          paramIPushActionListener.onStateChanged(101);
        }
        return;
      }
      if (!a(this.e))
      {
        if (paramIPushActionListener != null) {
          paramIPushActionListener.onStateChanged(1002);
        }
        return;
      }
      this.e = SystemClock.elapsedRealtime();
      paramIPushActionListener = a(new e.a((c)localObject, paramIPushActionListener));
      ((a)localObject).b(paramIPushActionListener);
      if (TextUtils.isEmpty(this.k))
      {
        a(paramIPushActionListener, 30001);
        return;
      }
      if (TextUtils.isEmpty(paramString))
      {
        a(paramIPushActionListener, 30002);
        return;
      }
      if (paramString.length() > 70L)
      {
        a(paramIPushActionListener, 30003);
        return;
      }
      a((o)localObject);
      e(paramIPushActionListener);
      return;
    }
    a((o)localObject);
    if (paramIPushActionListener != null) {
      paramIPushActionListener.onStateChanged(0);
    }
  }
  
  final void b(ArrayList<String> paramArrayList, IPushActionListener paramIPushActionListener)
  {
    Object localObject = this.h;
    if (localObject == null)
    {
      if (paramIPushActionListener != null) {
        paramIPushActionListener.onStateChanged(102);
      }
      return;
    }
    localObject = new com.vivo.push.b.z(false, ((Context)localObject).getPackageName(), paramArrayList);
    ((com.vivo.push.b.z)localObject).a(500);
    if (this.q)
    {
      if (!n())
      {
        if (paramIPushActionListener != null) {
          paramIPushActionListener.onStateChanged(101);
        }
        return;
      }
      if (!a(this.g))
      {
        if (paramIPushActionListener != null) {
          paramIPushActionListener.onStateChanged(1002);
        }
        return;
      }
      this.g = SystemClock.elapsedRealtime();
      paramIPushActionListener = a(new e.a((c)localObject, paramIPushActionListener));
      ((com.vivo.push.b.z)localObject).b(paramIPushActionListener);
      if (TextUtils.isEmpty(this.k))
      {
        a(paramIPushActionListener, 20001);
        return;
      }
      if (paramArrayList.size() < 0)
      {
        a(paramIPushActionListener, 20002);
        return;
      }
      if (paramArrayList.size() > 500)
      {
        a(paramIPushActionListener, 20004);
        return;
      }
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        if (((String)paramArrayList.next()).length() > 70L)
        {
          a(paramIPushActionListener, 20003);
          return;
        }
      }
      a((o)localObject);
      e(paramIPushActionListener);
      return;
    }
    a((o)localObject);
    if (paramIPushActionListener != null) {
      paramIPushActionListener.onStateChanged(0);
    }
  }
  
  public final void b(List<String> paramList)
  {
    try
    {
      if (paramList.size() <= 0) {
        return;
      }
      Object localObject = this.j.b("APP_TAGS", null);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        localObject = new JSONObject();
      } else {
        localObject = new JSONObject((String)localObject);
      }
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((JSONObject)localObject).remove((String)paramList.next());
      }
      paramList = ((JSONObject)localObject).toString();
      if (TextUtils.isEmpty(paramList))
      {
        this.j.b("APP_TAGS");
        return;
      }
      this.j.a("APP_TAGS", paramList);
      return;
    }
    catch (JSONException paramList)
    {
      paramList.printStackTrace();
      this.j.b("APP_TAGS");
    }
  }
  
  public final List<String> c()
  {
    Object localObject = this.j.b("APP_TAGS", null);
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return localArrayList;
      }
      localObject = new JSONObject((String)localObject).keys();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((Iterator)localObject).next());
      }
    }
    catch (JSONException localJSONException)
    {
      label65:
      break label65;
    }
    this.j.b("APP_TAGS");
    localArrayList.clear();
    com.vivo.push.util.o.d("PushClientManager", "getTags error");
    return localArrayList;
  }
  
  public final void c(List<String> paramList)
  {
    if (paramList.contains(this.l)) {
      m();
    }
  }
  
  public final boolean d()
  {
    if (this.h == null)
    {
      com.vivo.push.util.o.d("PushClientManager", "support:context is null");
      return false;
    }
    this.o = Boolean.valueOf(n());
    return this.o.booleanValue();
  }
  
  public final boolean e()
  {
    return this.q;
  }
  
  public final String f()
  {
    if (!TextUtils.isEmpty(this.k)) {
      return this.k;
    }
    Object localObject = this.j;
    if (localObject != null) {
      localObject = ((com.vivo.push.util.b)localObject).b("APP_TOKEN", null);
    } else {
      localObject = "";
    }
    c((String)localObject);
    return localObject;
  }
  
  public final boolean g()
  {
    return this.i;
  }
  
  public final Context h()
  {
    return this.h;
  }
  
  public final void i()
  {
    this.j.a();
  }
  
  public final String j()
  {
    return this.l;
  }
  
  public final int k()
  {
    return this.s;
  }
  
  public final long l()
  {
    Context localContext = this.h;
    if (localContext == null) {
      return -1L;
    }
    if (this.p == null) {
      this.p = Long.valueOf(com.vivo.push.util.z.b(localContext));
    }
    return this.p.longValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.e
 * JD-Core Version:    0.7.0.1
 */