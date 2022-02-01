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
  private static x e;
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
  
  private void a(e parame, boolean paramBoolean)
  {
    try
    {
      Object localObject = parame.c();
      if (localObject == null) {
        return;
      }
      if (paramBoolean)
      {
        localObject = ((List)localObject).iterator();
        int i;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          i = a(parame, (c)((Iterator)localObject).next());
        } while (i == 0);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw parame;
    }
  }
  
  private static List<b> b(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(SecureEngine.getEngineVersion(paramContext));
    localStringBuilder.append("&productid=");
    localStringBuilder.append(at.a(paramContext, 30003, 0));
    localArrayList.add(new b(4, 21, localStringBuilder.toString(), ""));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("SecureEngine.getEngineVersion(context): ");
    localStringBuilder.append(SecureEngine.getEngineVersion(paramContext));
    ax.b("CloudServiceManager", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("buildno=");
    localStringBuilder.append(at.a(paramContext, 30004, 0));
    localStringBuilder.append("&version=");
    localStringBuilder.append(at.a(paramContext, 30001, ""));
    localStringBuilder.append("&productid=");
    localStringBuilder.append(at.a(paramContext, 30003, 0));
    localArrayList.add(new b(8, 21, localStringBuilder.toString(), ""));
    return localArrayList;
  }
  
  private void b(e parame)
  {
    if (!a(parame)) {
      return;
    }
    Object localObject = parame.b();
    if (localObject != null)
    {
      int i = ((u)localObject).c();
      if (i != 0)
      {
        if (i != 6) {
          return;
        }
        this.d = true;
        localObject = new Intent();
        ((Intent)localObject).setClass(this.a, TransparentActivity.class);
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).setAction("1000040");
        ((Intent)localObject).putExtra("data", parame);
        this.a.startActivity((Intent)localObject);
        return;
      }
      a(parame, true);
    }
  }
  
  public int a(e parame, c paramc)
  {
    Object localObject1 = new UniAttribute();
    ((UniAttribute)localObject1).setEncodeName("UTF-8");
    ((UniAttribute)localObject1).decode(paramc.b());
    int i = paramc.a();
    int m = 0;
    boolean bool = false;
    int k = -5;
    int j;
    if (i != 200)
    {
      if (i != 301)
      {
        j = m;
        i = k;
      }
      else
      {
        localObject1 = (s)((UniAttribute)localObject1).getByClass("cloudcmd", new s());
        j = m;
        i = k;
        if (localObject1 != null)
        {
          j = m;
          i = k;
          if (((s)localObject1).a == 56)
          {
            Object localObject2 = this.a;
            if (((s)localObject1).b == 1) {
              bool = true;
            } else {
              bool = false;
            }
            at.b((Context)localObject2, 30008, bool);
            at.b(this.a, 30009, parame.b.c);
            parame = new ArrayList();
            localObject2 = new o();
            if (((s)localObject1).b == 1) {
              i = 235004;
            } else {
              i = 235005;
            }
            ((o)localObject2).a = i;
            ((o)localObject2).c = "1";
            ((o)localObject2).b = ((int)(System.currentTimeMillis() / 1000L));
            parame.add(localObject2);
            ah.a(this.a).a(parame);
            j = m;
            i = k;
          }
        }
      }
    }
    else
    {
      localObject1 = new UniAttribute();
      ((UniAttribute)localObject1).decode(paramc.b());
      localObject1 = (r)((UniAttribute)localObject1).getByClass("cloudcmd", new r());
      j = m;
      i = k;
      if (localObject1 != null)
      {
        if (parame.a().a() == 1) {
          bool = true;
        }
        i = ba.a(this.a, ((r)localObject1).a(), bool);
        j = 1;
      }
    }
    if (j == 0) {
      i = this.b.scanThreatens(paramc.a(), paramc.b());
    }
    return i;
  }
  
  public void a(int paramInt)
  {
    try
    {
      Object localObject1 = new ArrayList();
      Object localObject3 = this.c.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        e locale = (e)((Iterator)localObject3).next();
        if ((locale != null) && (locale.a().a() == paramInt)) {
          ((List)localObject1).add(locale);
        }
      }
      if (((List)localObject1).size() > 0)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (e)((Iterator)localObject1).next();
          b((e)localObject3);
          this.c.remove(localObject3);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
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
    Context localContext = this.a;
    boolean bool2 = false;
    boolean bool3 = at.a(localContext, 30008, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.securemodule.x
 * JD-Core Version:    0.7.0.1
 */