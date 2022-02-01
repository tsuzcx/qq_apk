package com.tencent.tbs.one.impl.e;

import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneEventEmitter;
import com.tencent.tbs.one.TBSOneEventEmitter.UnloadedBehavior;
import com.tencent.tbs.one.TBSOneEventReceiver;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.c.a;
import com.tencent.tbs.one.impl.common.g;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public final class b
  implements TBSOneEventEmitter
{
  private WeakReference<h> a;
  
  public b(h paramh)
  {
    this.a = new WeakReference(paramh);
  }
  
  private static void a(String paramString1, String paramString2)
  {
    f.b("Failed to emit event %s, error: %s", new Object[] { paramString1, paramString2 });
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, String paramString4, Throwable paramThrowable)
  {
    f.b("Failed to emit event %s to %s#%s, error: %s", new Object[] { paramString3, paramString1, paramString2, paramString4, paramThrowable });
  }
  
  private static void b(TBSOneComponent paramTBSOneComponent, String paramString1, String paramString2, Map<String, Object> paramMap)
  {
    if (paramTBSOneComponent.getEntryClassLoader() == null) {
      a(paramTBSOneComponent.getName(), paramString1, paramString2, "no entry class loader found", null);
    }
    try
    {
      Class localClass = paramTBSOneComponent.getEntryClassLoader().loadClass(paramString1);
      if (TBSOneEventReceiver.class.isAssignableFrom(localClass))
      {
        ((TBSOneEventReceiver)localClass.getConstructor(new Class[0]).newInstance(new Object[0])).onReceive(paramString2, paramMap);
        return;
      }
      a(paramTBSOneComponent.getName(), paramString1, paramString2, "can't assign receiver class to com.tencent.tbs.one.TBSOneEventReceiver", null);
      return;
    }
    catch (ClassNotFoundException paramMap)
    {
      a(paramTBSOneComponent.getName(), paramString1, paramString2, "can't load event receiver class", paramMap);
      return;
    }
    catch (NoSuchMethodException paramMap)
    {
      a(paramTBSOneComponent.getName(), paramString1, paramString2, "can't find constructor method for event receiver class", paramMap);
      return;
    }
    catch (Exception paramMap)
    {
      a(paramTBSOneComponent.getName(), paramString1, paramString2, "can't construct event receiver object", paramMap);
    }
  }
  
  public final void emit(TBSOneEventEmitter.UnloadedBehavior paramUnloadedBehavior, String paramString1, String paramString2, String paramString3, Map<String, Object> paramMap)
  {
    h localh = (h)this.a.get();
    if (localh == null)
    {
      a(paramString1, paramString2, paramString3, "TBSOneManager is not alive", null);
      return;
    }
    a locala = localh.e(paramString1);
    if (locala == null)
    {
      if (paramUnloadedBehavior == TBSOneEventEmitter.UnloadedBehavior.IGNORE)
      {
        a(paramString1, paramString2, paramString3, "component is not loaded yet", null);
        return;
      }
      if ((paramUnloadedBehavior == TBSOneEventEmitter.UnloadedBehavior.LOAD) && (localh.b(paramString1)))
      {
        a(paramString1, paramString2, paramString3, "component is not installed yet", null);
        return;
      }
      m.a(new b.1(this, localh, paramString1, paramString2, paramString3, paramMap));
      return;
    }
    b(locala, paramString2, paramString3, paramMap);
  }
  
  public final void emit(String paramString, Map<String, Object> paramMap)
  {
    h localh = (h)this.a.get();
    if (localh == null) {
      a(paramString, "TBSOneManager is not alive");
    }
    for (;;)
    {
      return;
      Object localObject = (List)localh.o.get(paramString);
      if (localObject == null)
      {
        a(paramString, "no event receiver found");
        return;
      }
      localObject = ((List)localObject).listIterator();
      while (((ListIterator)localObject).hasNext())
      {
        g localg = (g)((ListIterator)localObject).next();
        b(localh.e(localg.a), localg.b, paramString, paramMap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.b
 * JD-Core Version:    0.7.0.1
 */