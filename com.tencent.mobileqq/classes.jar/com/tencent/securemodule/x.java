package com.tencent.securemodule;

import android.content.Context;
import android.content.Intent;
import com.qq.jce.wup.UniAttribute;
import com.tencent.securemodule.jni.SecureEngine;
import com.tencent.securemodule.ui.TransparentActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class x
{
  private static x e = null;
  private Context a;
  private SecureEngine b;
  private List<e> c;
  private boolean d = false;
  
  private x(Context paramContext)
  {
    this.b = new SecureEngine(paramContext);
    this.a = paramContext;
  }
  
  public static x a(Context paramContext)
  {
    if (e == null) {
      e = new x(paramContext);
    }
    return e;
  }
  
  /* Error */
  private void a(e parame, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokevirtual 42	com/tencent/securemodule/e:c	()Ljava/util/ArrayList;
    //   6: astore 4
    //   8: aload 4
    //   10: ifnonnull +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: iload_2
    //   17: ifeq -4 -> 13
    //   20: aload 4
    //   22: invokeinterface 48 1 0
    //   27: astore 4
    //   29: aload 4
    //   31: invokeinterface 54 1 0
    //   36: ifeq -23 -> 13
    //   39: aload_0
    //   40: aload_1
    //   41: aload 4
    //   43: invokeinterface 58 1 0
    //   48: checkcast 60	com/tencent/securemodule/c
    //   51: invokevirtual 63	com/tencent/securemodule/x:a	(Lcom/tencent/securemodule/e;Lcom/tencent/securemodule/c;)I
    //   54: istore_3
    //   55: iload_3
    //   56: ifeq -27 -> 29
    //   59: goto -46 -> 13
    //   62: astore_1
    //   63: aload_0
    //   64: monitorexit
    //   65: aload_1
    //   66: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	67	0	this	x
    //   0	67	1	parame	e
    //   0	67	2	paramBoolean	boolean
    //   54	2	3	i	int
    //   6	36	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	8	62	finally
    //   20	29	62	finally
    //   29	55	62	finally
  }
  
  private static List<b> b(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new b(4, 21, SecureEngine.getEngineVersion(paramContext) + "&productid=" + at.a(paramContext, 30003, 0), ""));
    ax.b("CloudServiceManager", "SecureEngine.getEngineVersion(context): " + SecureEngine.getEngineVersion(paramContext));
    localArrayList.add(new b(8, 21, "buildno=" + at.a(paramContext, 30004, 0) + "&version=" + at.a(paramContext, 30001, "") + "&productid=" + at.a(paramContext, 30003, 0), ""));
    return localArrayList;
  }
  
  private void b(e parame)
  {
    if (!a(parame)) {}
    do
    {
      return;
      localObject = parame.b();
    } while (localObject == null);
    switch (((u)localObject).c())
    {
    case 8: 
    default: 
      return;
    case 0: 
      a(parame, true);
      return;
    }
    this.d = true;
    Object localObject = new Intent();
    ((Intent)localObject).setClass(this.a, TransparentActivity.class);
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).setAction("1000040");
    ((Intent)localObject).putExtra("data", parame);
    this.a.startActivity((Intent)localObject);
  }
  
  public int a(e parame, c paramc)
  {
    boolean bool = false;
    int j = 0;
    int i = 1;
    Object localObject1 = new UniAttribute();
    ((UniAttribute)localObject1).setEncodeName("UTF-8");
    ((UniAttribute)localObject1).decode(paramc.b());
    int k;
    switch (paramc.a())
    {
    default: 
      i = -5;
      if (j == 0) {
        i = this.b.scanThreatens(paramc.a(), paramc.b());
      }
      return i;
    case 200: 
      localObject1 = new UniAttribute();
      ((UniAttribute)localObject1).decode(paramc.b());
      localObject1 = (r)((UniAttribute)localObject1).getByClass("cloudcmd", new r());
      if (localObject1 != null)
      {
        if (parame.a().a() == 1) {
          bool = true;
        }
        k = ba.a(this.a, ((r)localObject1).a(), bool);
        j = i;
      }
      break;
    }
    for (i = k;; i = -5)
    {
      break;
      localObject1 = (s)((UniAttribute)localObject1).getByClass("cloudcmd", new s());
      Object localObject2;
      if ((localObject1 != null) && (((s)localObject1).a == 56))
      {
        localObject2 = this.a;
        if (((s)localObject1).b != 1) {
          break label330;
        }
        bool = true;
        label223:
        at.b((Context)localObject2, 30008, bool);
        at.b(this.a, 30009, parame.b.c);
        parame = new ArrayList();
        localObject2 = new o();
        if (((s)localObject1).b != 1) {
          break label336;
        }
      }
      label330:
      label336:
      for (i = 235004;; i = 235005)
      {
        ((o)localObject2).a = i;
        ((o)localObject2).c = "1";
        ((o)localObject2).b = ((int)(System.currentTimeMillis() / 1000L));
        parame.add(localObject2);
        ah.a(this.a).a(parame);
        i = -5;
        break;
        bool = false;
        break label223;
      }
      j = 0;
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject2;
    try
    {
      ArrayList localArrayList = new ArrayList();
      localObject2 = this.c.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        e locale = (e)((Iterator)localObject2).next();
        if ((locale != null) && (locale.a().a() == paramInt)) {
          localArrayList.add(locale);
        }
      }
      if (localObject1.size() <= 0) {
        break label128;
      }
    }
    finally {}
    Iterator localIterator = localObject1.iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (e)localIterator.next();
      b((e)localObject2);
      this.c.remove(localObject2);
    }
    label128:
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  boolean a(e parame)
  {
    t localt = parame.a();
    return (parame.a().b() == 0) || (System.currentTimeMillis() / 1000L < localt.b());
  }
  
  public int b()
  {
    ax.b("CloudServiceManager", "handleCloudCmdFromServer");
    Object localObject = b(this.a);
    AtomicReference localAtomicReference = new AtomicReference();
    int i = ah.a(this.a).a((List)localObject, localAtomicReference);
    if (i != 0) {
      return i;
    }
    ax.b("CloudServiceManager", "getUpdatesV2 back");
    localObject = (q)localAtomicReference.get();
    if (localObject != null)
    {
      this.c = ((q)localObject).a();
      a(1);
    }
    return i;
  }
  
  public boolean c()
  {
    boolean bool2 = false;
    boolean bool3 = at.a(this.a, 30008, false);
    long l = at.a(this.a, 30009, 0);
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (l > System.currentTimeMillis() / 1000L) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.securemodule.x
 * JD-Core Version:    0.7.0.1
 */