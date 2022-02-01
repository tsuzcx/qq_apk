package com.tencent.tbs.one.impl.e;

import android.content.Context;
import android.os.Bundle;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneDebugger;
import com.tencent.tbs.one.TBSOneDelegate;
import com.tencent.tbs.one.TBSOneManager.Policy;
import com.tencent.tbs.one.TBSOneOnlineService;
import com.tencent.tbs.one.impl.a.c;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.d.a;
import com.tencent.tbs.one.impl.common.g;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class h
{
  public Context a;
  public String b;
  File c;
  public volatile TBSOneManager.Policy d = TBSOneManager.Policy.AUTO;
  volatile boolean e = false;
  volatile long f = 86400000L;
  volatile boolean g = true;
  public TBSOneDelegate h;
  public Map<String, Object> i = new ConcurrentHashMap();
  public boolean j = false;
  public boolean k = false;
  public d l;
  public com.tencent.tbs.one.impl.a.a<d> m;
  Map<String, com.tencent.tbs.one.impl.c.b> n = new ConcurrentHashMap();
  public Map<String, List<g>> o = new ConcurrentHashMap();
  public b p = new b(this);
  
  public h(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
    this.c = com.tencent.tbs.one.impl.common.f.a(paramContext.getDir("tbs", 0), paramString);
    c.d(this.c);
    c.d(com.tencent.tbs.one.impl.common.f.d(this.c));
  }
  
  private com.tencent.tbs.one.impl.c.b g(String paramString)
  {
    com.tencent.tbs.one.impl.c.b localb2 = (com.tencent.tbs.one.impl.c.b)this.n.get(paramString);
    com.tencent.tbs.one.impl.c.b localb1 = localb2;
    if (localb2 == null)
    {
      localb1 = new com.tencent.tbs.one.impl.c.b(this, paramString);
      this.n.put(paramString, localb1);
    }
    return localb1;
  }
  
  public TBSOneManager.Policy a()
  {
    return this.d;
  }
  
  public com.tencent.tbs.one.impl.a.a<e<d>> a(Bundle paramBundle, l<e<d>> paraml)
  {
    com.tencent.tbs.one.impl.a.f.a("[%s] Installing DEPS", new Object[] { this.b });
    paramBundle = com.tencent.tbs.one.impl.common.f.b(this.c);
    paramBundle = new com.tencent.tbs.one.impl.e.b.b(this.a, this.b, paramBundle);
    paramBundle.a(paraml);
    return paramBundle;
  }
  
  public com.tencent.tbs.one.impl.a.a<e<File>> a(Bundle paramBundle, d.a parama, l<e<File>> paraml)
  {
    com.tencent.tbs.one.impl.a.f.a("[%s] Installing component %s, version: %d", new Object[] { this.b, parama.a, Integer.valueOf(parama.c) });
    File localFile = a(parama.a, parama.c);
    c.d(localFile);
    paramBundle = new com.tencent.tbs.one.impl.e.b.a(this.a, this.b, parama, localFile, paramBundle, "");
    paramBundle.a(paraml);
    return paramBundle;
  }
  
  public final File a(String paramString)
  {
    return com.tencent.tbs.one.impl.common.f.b(this.c, paramString);
  }
  
  public final File a(String paramString, int paramInt)
  {
    return com.tencent.tbs.one.impl.common.f.a(this.c, paramString, paramInt);
  }
  
  public void a(Bundle paramBundle, String paramString, TBSOneCallback<File> paramTBSOneCallback)
  {
    g(paramString).a(paramBundle, paramTBSOneCallback);
  }
  
  protected void a(e<d> parame)
  {
    com.tencent.tbs.one.impl.a.f.a("[%s] Finished loading DEPS#%d from %s", new Object[] { this.b, Integer.valueOf(((d)parame.b).a), parame.a });
    this.l = ((d)parame.b);
  }
  
  public void a(String paramString, Bundle paramBundle, TBSOneCallback<TBSOneComponent> paramTBSOneCallback)
  {
    paramString = g(paramString);
    if (paramString.l != null)
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] {%s} Loaded component %s", new Object[] { paramString.b.b, paramString.a, paramString.l });
      if (paramTBSOneCallback != null)
      {
        paramTBSOneCallback.onProgressChanged(0, 100);
        paramTBSOneCallback.onCompleted(paramString.l);
      }
      return;
    }
    if (paramTBSOneCallback != null)
    {
      paramTBSOneCallback.onProgressChanged(0, paramString.g);
      paramString.d.add(paramTBSOneCallback);
    }
    if (paramString.k != null)
    {
      paramString.b();
      return;
    }
    paramString.a(paramBundle);
  }
  
  public void a(String paramString, Object paramObject)
  {
    this.i.put(paramString, paramObject);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public final boolean a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    if (this.i.containsKey(paramString1))
    {
      paramString1 = this.i.get(paramString1);
      if ((paramString1 instanceof Boolean)) {
        return ((Boolean)paramString1).booleanValue();
      }
    }
    if (this.i.containsKey(paramString2))
    {
      paramString1 = this.i.get(paramString2);
      if ((paramString1 instanceof Boolean)) {
        return ((Boolean)paramString1).booleanValue();
      }
    }
    return false;
  }
  
  public void b(String paramString, Bundle paramBundle, TBSOneCallback<File> paramTBSOneCallback)
  {
    g(paramString).a(paramBundle, paramTBSOneCallback);
  }
  
  public final boolean b()
  {
    TBSOneManager.Policy localPolicy = a();
    return (localPolicy != TBSOneManager.Policy.BUILTIN_ONLY) && (localPolicy != TBSOneManager.Policy.LOCAL_ONLY);
  }
  
  public boolean b(String paramString)
  {
    return true;
  }
  
  public TBSOneOnlineService c()
  {
    return null;
  }
  
  public int[] c(String paramString)
  {
    return new int[] { -1 };
  }
  
  public TBSOneDebugger d()
  {
    return null;
  }
  
  public final com.tencent.tbs.one.impl.c.b d(String paramString)
  {
    return (com.tencent.tbs.one.impl.c.b)this.n.get(paramString);
  }
  
  public final com.tencent.tbs.one.impl.c.a e(String paramString)
  {
    paramString = (com.tencent.tbs.one.impl.c.b)this.n.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.l;
  }
  
  public void e() {}
  
  public final Object f(String paramString)
  {
    return this.i.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.h
 * JD-Core Version:    0.7.0.1
 */