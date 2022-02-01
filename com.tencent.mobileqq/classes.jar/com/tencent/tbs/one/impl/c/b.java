package com.tencent.tbs.one.impl.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneDelegate;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.c.a.c;
import com.tencent.tbs.one.impl.common.d;
import com.tencent.tbs.one.impl.common.e;
import com.tencent.tbs.one.impl.common.e.a;
import com.tencent.tbs.one.impl.common.e.b;
import com.tencent.tbs.one.impl.common.g;
import com.tencent.tbs.one.impl.e.h.1;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b
  implements com.tencent.tbs.one.impl.a.a.d.a
{
  public String a;
  public com.tencent.tbs.one.impl.e.h b;
  ArrayList<TBSOneCallback<File>> c = new ArrayList();
  public ArrayList<TBSOneCallback<TBSOneComponent>> d = new ArrayList();
  public boolean e;
  com.tencent.tbs.one.impl.common.d.a f;
  public int g;
  int h;
  int i;
  String j;
  public File k;
  public a l;
  private e m;
  private Map<String, ClassLoader> n;
  
  public b(com.tencent.tbs.one.impl.e.h paramh, String paramString)
  {
    this.a = paramString;
    this.b = paramh;
  }
  
  private File a(String paramString)
  {
    Object localObject = this.b.h;
    if (localObject != null)
    {
      localObject = ((TBSOneDelegate)localObject).shouldOverrideFilePath(this.b.b, this.a, this.f.c, paramString);
      if (localObject != null) {
        return new File((String)localObject);
      }
    }
    paramString = new File(this.k, paramString);
    if (!paramString.exists()) {
      f.b("Failed to find component file %s in installation directory", new Object[] { paramString.getAbsolutePath() });
    }
    return paramString;
  }
  
  private ClassLoader a(Context paramContext, String paramString)
  {
    String str1 = this.b.b;
    String str2 = this.a;
    Object localObject1 = this.n;
    if (localObject1 != null)
    {
      localObject1 = (ClassLoader)((Map)localObject1).get(paramString);
      if (localObject1 != null)
      {
        f.a("[%s] {%s} Reusing class loader %s %s", new Object[] { str1, str2, paramString, localObject1 });
        return localObject1;
      }
    }
    File localFile = a(paramString);
    if (localFile.exists())
    {
      f.a("[%s] {%s} Creating class loader %s from %s", new Object[] { str1, str2, paramString, localFile.getAbsolutePath() });
      if (this.m == null)
      {
        localObject1 = a("MANIFEST");
        if (((File)localObject1).exists())
        {
          f.a("[%s] {%s} Initializing component according to MANIFEST file %s", new Object[] { str1, str2, ((File)localObject1).getAbsolutePath() });
          try
          {
            this.m = e.a((File)localObject1);
          }
          catch (TBSOneException paramContext)
          {
            b(paramContext.getErrorCode(), paramContext.getMessage(), paramContext.getCause());
            return null;
          }
        }
      }
      localObject1 = this.m;
      Object localObject2;
      if (localObject1 == null) {
        localObject2 = null;
      } else {
        localObject2 = ((e)localObject1).a(paramString);
      }
      localObject1 = this.b;
      String str3 = this.a;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(str3);
      ((StringBuilder)localObject3).append(".");
      ((StringBuilder)localObject3).append("parent_classloader");
      str3 = ((StringBuilder)localObject3).toString();
      if (((com.tencent.tbs.one.impl.e.h)localObject1).i.containsKey(str3)) {
        localObject1 = ((com.tencent.tbs.one.impl.e.h)localObject1).i.get(str3);
      } else if (((com.tencent.tbs.one.impl.e.h)localObject1).i.containsKey("parent_classloader")) {
        localObject1 = ((com.tencent.tbs.one.impl.e.h)localObject1).i.get("parent_classloader");
      } else {
        localObject1 = null;
      }
      if ((localObject1 instanceof ClassLoader)) {
        localObject1 = (ClassLoader)localObject1;
      }
      for (;;)
      {
        break;
        if (localObject2 == null) {
          localObject1 = null;
        } else {
          localObject1 = ((e.a)localObject2).d;
        }
        if (localObject1 != null)
        {
          str3 = ((e.b)localObject1).a;
          if (TextUtils.isEmpty(str3))
          {
            localObject1 = a(paramContext, ((e.b)localObject1).b);
          }
          else
          {
            localObject3 = this.b.d(str3);
            if (localObject3 != null)
            {
              localObject1 = ((b)localObject3).a(paramContext, ((e.b)localObject1).b);
            }
            else
            {
              paramContext = new StringBuilder("Failed to get loaded dependency ");
              paramContext.append(str3);
              throw new TBSOneException(404, paramContext.toString());
            }
          }
        }
        else
        {
          localObject1 = this.b.a.getClassLoader();
        }
      }
      str3 = b(localFile.getAbsolutePath());
      boolean bool1 = this.b.a(str2, "disable_sealed_classloader");
      boolean bool2 = this.b.a(str2, "enable_async_dex_optimization");
      long l1 = System.currentTimeMillis();
      localObject3 = this.k.getAbsolutePath();
      if (localObject2 == null) {
        localObject2 = null;
      } else {
        localObject2 = ((e.a)localObject2).c;
      }
      paramContext = c.a(paramContext, localFile, (String)localObject3, str3, (ClassLoader)localObject1, bool1, (String[])localObject2, bool2);
      f.a("[%s] {%s} Created dex class loader %s %s cost %dms", new Object[] { str1, str2, paramString, paramContext, Long.valueOf(System.currentTimeMillis() - l1) });
      if (this.n == null) {
        this.n = new HashMap();
      }
      this.n.put(paramString, paramContext);
      paramString = this.b.h;
      if (paramString != null) {
        paramString.onDexLoaded(str1, str2, this.f.c, localFile.getAbsolutePath(), paramContext);
      }
      return paramContext;
    }
    paramContext = new StringBuilder("Failed to find dex file ");
    paramContext.append(localFile.getAbsolutePath());
    paramContext = new TBSOneException(105, paramContext.toString());
    for (;;)
    {
      throw paramContext;
    }
  }
  
  private void a(a parama)
  {
    Object localObject1 = this.b.b;
    int i1 = 0;
    f.a("[%s] {%s} Finished loading component %s", new Object[] { localObject1, this.a, parama });
    this.l = parama;
    int i2 = this.g;
    this.g = 100;
    localObject1 = (TBSOneCallback[])this.d.toArray(new TBSOneCallback[0]);
    this.d.clear();
    int i3 = localObject1.length;
    while (i1 < i3)
    {
      Object localObject2 = localObject1[i1];
      localObject2.onProgressChanged(i2, 100);
      localObject2.onCompleted(parama);
      i1 += 1;
    }
  }
  
  private String b(String paramString)
  {
    String str = TextUtils.join(File.pathSeparator, c());
    f.a("[%s] {%s} Collected librarySearchPath %s", new Object[] { this.b.b, this.a, str });
    TBSOneDelegate localTBSOneDelegate = this.b.h;
    if (localTBSOneDelegate != null)
    {
      paramString = localTBSOneDelegate.shouldOverrideLibrarySearchPath(this.b.b, this.a, this.f.c, paramString, str);
      if (paramString != null) {
        return paramString;
      }
    }
    return str;
  }
  
  private Set<String> c()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add(this.k.getAbsolutePath());
    String[] arrayOfString = this.f.f;
    if (arrayOfString != null)
    {
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = arrayOfString[i1];
        localHashSet.addAll(this.b.d(str).c());
        i1 += 1;
      }
    }
    return localHashSet;
  }
  
  public final void a()
  {
    String str = this.a;
    f.a("[%s] {%s} Finished installing component and dependencies", new Object[] { this.b.b, str });
    m.a(new b.5(this, str));
  }
  
  final void a(int paramInt)
  {
    Object localObject = this.b.b;
    int i2 = 0;
    localObject = this.a;
    int i1 = this.g;
    int i3 = this.g;
    if (paramInt - i3 > 2)
    {
      this.g = paramInt;
      localObject = (TBSOneCallback[])this.c.toArray(new TBSOneCallback[0]);
      TBSOneCallback[] arrayOfTBSOneCallback = (TBSOneCallback[])this.d.toArray(new TBSOneCallback[0]);
      int i4 = localObject.length;
      i1 = 0;
      while (i1 < i4)
      {
        localObject[i1].onProgressChanged(i3, paramInt);
        i1 += 1;
      }
      i4 = arrayOfTBSOneCallback.length;
      i1 = i2;
      while (i1 < i4)
      {
        arrayOfTBSOneCallback[i1].onProgressChanged(i3, paramInt);
        i1 += 1;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = Math.min(Math.max(0, paramInt1), 100);
    a((int)(paramInt2 + paramInt1 / 100.0F * (paramInt3 - paramInt2)));
  }
  
  public final void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    m.a(new b.4(this, paramInt, paramString, paramThrowable));
  }
  
  public final void a(Bundle paramBundle)
  {
    Object localObject1 = this.b.b;
    Object localObject2 = this.a;
    if (this.e)
    {
      f.a("[%s] {%s} Have started loading component", new Object[] { localObject1, localObject2 });
      return;
    }
    f.a("[%s] {%s} Loading DEPS", new Object[] { localObject1, localObject2 });
    this.e = true;
    localObject1 = this.b;
    localObject2 = new b.1(this, paramBundle);
    String str = ((com.tencent.tbs.one.impl.e.h)localObject1).b;
    f.a("[%s] Loading DEPS", new Object[] { str });
    if (((com.tencent.tbs.one.impl.e.h)localObject1).l != null)
    {
      f.a("[%s] Loaded DEPS#%d", new Object[] { str, Integer.valueOf(((com.tencent.tbs.one.impl.e.h)localObject1).l.a) });
      ((l)localObject2).a(((com.tencent.tbs.one.impl.e.h)localObject1).l);
      return;
    }
    if (((com.tencent.tbs.one.impl.e.h)localObject1).m == null) {
      ((com.tencent.tbs.one.impl.e.h)localObject1).m = new h.1((com.tencent.tbs.one.impl.e.h)localObject1, paramBundle);
    }
    ((com.tencent.tbs.one.impl.e.h)localObject1).m.a((l)localObject2);
  }
  
  public final void a(Bundle paramBundle, TBSOneCallback<File> paramTBSOneCallback)
  {
    if (this.k != null)
    {
      f.a("[%s] {%s} Installed component at %s", new Object[] { this.b.b, this.a, this.k });
      if (paramTBSOneCallback != null)
      {
        paramTBSOneCallback.onProgressChanged(0, 100);
        paramTBSOneCallback.onCompleted(this.k);
      }
      return;
    }
    if (paramTBSOneCallback != null)
    {
      paramTBSOneCallback.onProgressChanged(0, this.g);
      this.c.add(paramTBSOneCallback);
    }
    a(paramBundle);
  }
  
  public final void b()
  {
    Object localObject4 = this.b.b;
    String str1 = this.a;
    int i2 = this.f.c;
    f.a("[%s] {%s} Initializing component", new Object[] { localObject4, str1 });
    Object localObject3 = new a(str1, this.f.b, i2, this.k);
    Object localObject1 = a("MANIFEST");
    if (((File)localObject1).exists())
    {
      f.a("[%s] {%s} Initializing component according to MANIFEST file %s", new Object[] { localObject4, str1, ((File)localObject1).getAbsolutePath() });
      try
      {
        this.m = e.a((File)localObject1);
        Object localObject5 = this.m.f;
        Object localObject7;
        if (localObject5 != null)
        {
          f.a("[%s] {%s} Registering event receivers", new Object[] { localObject4, str1, localObject5 });
          int i3 = localObject5.length;
          int i1 = 0;
          while (i1 < i3)
          {
            localObject1 = localObject5[i1];
            localObject6 = this.b;
            localObject7 = new g(str1, (String)((Pair)localObject1).second, (String)((Pair)localObject1).first);
            String str2 = ((g)localObject7).c;
            localObject2 = (List)((com.tencent.tbs.one.impl.e.h)localObject6).o.get(str2);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new ArrayList();
              ((com.tencent.tbs.one.impl.e.h)localObject6).o.put(str2, localObject1);
            }
            ((List)localObject1).add(localObject7);
            i1 += 1;
          }
        }
        f.a("[%s] {%s} No event receivers", new Object[] { localObject4, str1 });
        Object localObject6 = this.b.a;
        Object localObject2 = this.m.b;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = a((String)localObject2);
          f.a("[%s] {%s} Creating resource context %s from %s", new Object[] { localObject4, str1, localObject2, ((File)localObject1).getAbsolutePath() });
          if (!((File)localObject1).exists())
          {
            localObject2 = new StringBuilder("Failed to find resource file ");
            ((StringBuilder)localObject2).append(((File)localObject1).getAbsolutePath());
            b(105, ((StringBuilder)localObject2).toString(), null);
            return;
          }
          localObject1 = new com.tencent.tbs.one.impl.c.b.b((Context)localObject6, ((File)localObject1).getAbsolutePath());
          ((a)localObject3).a = ((Context)localObject1);
        }
        else
        {
          f.a("[%s] {%s} No resource file", new Object[] { localObject4, str1 });
          localObject1 = null;
        }
        localObject2 = this.m.c;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          try
          {
            localObject7 = a((Context)localObject6, (String)localObject2);
            ((a)localObject3).b = ((ClassLoader)localObject7);
            localObject5 = this.m.d;
            if (!TextUtils.isEmpty((CharSequence)localObject5))
            {
              f.a("[%s] {%s} Constructing entry object %s", new Object[] { localObject4, str1, localObject5 });
              localObject4 = new HashMap();
              ((Map)localObject4).put("callerContext", localObject6);
              if (localObject1 != null)
              {
                ((com.tencent.tbs.one.impl.c.b.b)localObject1).a.a = ((ClassLoader)localObject7);
                ((Map)localObject4).put("resourcesContext", localObject1);
              }
              ((Map)localObject4).put("classLoader", localObject7);
              ((Map)localObject4).put("installationDirectory", this.k);
              ((Map)localObject4).put("optimizedDirectory", this.k);
              ((Map)localObject4).put("librarySearchPath", b((String)localObject2));
              ((Map)localObject4).put("versionName", this.f.b);
              ((Map)localObject4).put("versionCode", Integer.valueOf(i2));
              ((Map)localObject4).put("eventEmitter", this.b.p);
              try
              {
                ((a)localObject3).c = ((ClassLoader)localObject7).loadClass((String)localObject5).getConstructor(new Class[] { Map.class }).newInstance(new Object[] { localObject4 });
              }
              catch (Exception localException)
              {
                localObject3 = new StringBuilder("Failed to construct the entry object with ");
                ((StringBuilder)localObject3).append((String)localObject5);
                ((StringBuilder)localObject3).append(" in ");
                ((StringBuilder)localObject3).append((String)localObject2);
                ((StringBuilder)localObject3).append("\n");
                ((StringBuilder)localObject3).append(Log.getStackTraceString(localException));
                b(407, ((StringBuilder)localObject3).toString(), null);
                return;
              }
              catch (NoSuchMethodException localNoSuchMethodException)
              {
                localObject3 = new StringBuilder("Failed to find entry class ");
                ((StringBuilder)localObject3).append((String)localObject5);
                ((StringBuilder)localObject3).append(" constructor in ");
                ((StringBuilder)localObject3).append((String)localObject2);
                ((StringBuilder)localObject3).append("\n");
                ((StringBuilder)localObject3).append(Log.getStackTraceString(localNoSuchMethodException));
                b(406, ((StringBuilder)localObject3).toString(), null);
                return;
              }
              catch (ClassNotFoundException localClassNotFoundException)
              {
                localObject3 = new StringBuilder("Failed to load entry class ");
                ((StringBuilder)localObject3).append((String)localObject5);
                ((StringBuilder)localObject3).append(" in ");
                ((StringBuilder)localObject3).append((String)localObject2);
                ((StringBuilder)localObject3).append("\n");
                ((StringBuilder)localObject3).append(Log.getStackTraceString(localClassNotFoundException));
                b(405, ((StringBuilder)localObject3).toString(), null);
                return;
              }
            }
            else
            {
              f.a("[%s] {%s} No entry class", new Object[] { localObject4, str1 });
            }
          }
          catch (TBSOneException localTBSOneException1)
          {
            b(localTBSOneException1.getErrorCode(), localTBSOneException1.getMessage(), localTBSOneException1.getCause());
            return;
          }
        } else {
          f.a("[%s] {%s} No entry dex file", new Object[] { localObject4, str1 });
        }
      }
      catch (TBSOneException localTBSOneException2)
      {
        b(localTBSOneException2.getErrorCode(), localTBSOneException2.getMessage(), localTBSOneException2.getCause());
        return;
      }
    }
    else
    {
      f.a("[%s] {%s} No MANIFEST file", new Object[] { localObject4, str1 });
    }
    a((a)localObject3);
  }
  
  final void b(int paramInt, String paramString, Throwable paramThrowable)
  {
    Object localObject1 = this.a;
    int i3 = 0;
    f.b("Failed to install or load component %s, error: [%d] %s", new Object[] { localObject1, Integer.valueOf(paramInt), paramString });
    f.c("[%s] {%s} Failed to install or load component, error: [%d] %s", new Object[] { this.b.b, localObject1, Integer.valueOf(paramInt), paramString, paramThrowable });
    Object localObject2 = this.b.l;
    int i2 = -1;
    if (localObject2 != null) {
      i1 = ((d)localObject2).a;
    } else {
      i1 = -1;
    }
    localObject2 = this.f;
    if (localObject2 != null) {
      i2 = ((com.tencent.tbs.one.impl.common.d.a)localObject2).c;
    }
    com.tencent.tbs.one.impl.common.h.a(i1, (String)localObject1, i2, paramInt, paramString, paramThrowable);
    paramThrowable = this.b;
    paramThrowable.j = true;
    paramThrowable.k = true;
    paramThrowable.e();
    this.i = paramInt;
    this.j = paramString;
    this.f = null;
    this.m = null;
    this.k = null;
    this.l = null;
    this.g = 0;
    this.e = false;
    paramThrowable = (TBSOneCallback[])this.c.toArray(new TBSOneCallback[0]);
    this.c.clear();
    localObject1 = (TBSOneCallback[])this.d.toArray(new TBSOneCallback[0]);
    this.d.clear();
    i2 = paramThrowable.length;
    int i1 = 0;
    while (i1 < i2)
    {
      paramThrowable[i1].onError(paramInt, paramString);
      i1 += 1;
    }
    i2 = localObject1.length;
    i1 = i3;
    while (i1 < i2)
    {
      localObject1[i1].onError(paramInt, paramString);
      i1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.c.b
 * JD-Core Version:    0.7.0.1
 */