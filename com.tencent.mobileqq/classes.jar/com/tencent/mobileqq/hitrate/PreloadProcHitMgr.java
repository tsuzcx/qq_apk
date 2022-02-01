package com.tencent.mobileqq.hitrate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PreloadProcHitMgr
{
  public static ConcurrentHashMap<String, ArrayList<PreloadProcHitSession>> a = new ConcurrentHashMap();
  public static ConcurrentHashMap<String, PreloadProcHitPluginSessionProc> b = new ConcurrentHashMap();
  
  public static void a()
  {
    synchronized (a)
    {
      HashSet localHashSet = new HashSet();
      Iterator localIterator2 = a.values().iterator();
      while (localIterator2.hasNext())
      {
        Iterator localIterator3 = ((ArrayList)localIterator2.next()).iterator();
        if (localIterator3.hasNext())
        {
          PreloadProcHitSession localPreloadProcHitSession = (PreloadProcHitSession)localIterator3.next();
          localPreloadProcHitSession.d();
          localHashSet.add(localPreloadProcHitSession.d);
        }
      }
    }
    Iterator localIterator1 = localObject.iterator();
    while (localIterator1.hasNext()) {
      c((String)localIterator1.next());
    }
  }
  
  public static void a(PreloadProcHitSession paramPreloadProcHitSession)
  {
    synchronized (a)
    {
      String str = paramPreloadProcHitSession.a();
      ArrayList localArrayList = (ArrayList)a.get(str);
      if (localArrayList == null)
      {
        localArrayList = new ArrayList();
        localArrayList.add(paramPreloadProcHitSession);
        a.put(str, localArrayList);
      }
      while (localArrayList.contains(paramPreloadProcHitSession)) {
        return;
      }
      localArrayList.add(paramPreloadProcHitSession);
    }
  }
  
  public static void a(String paramString)
  {
    synchronized (a)
    {
      PreloadProcHitSession localPreloadProcHitSession;
      do
      {
        Iterator localIterator = a.keySet().iterator();
        Object localObject;
        while (!((Iterator)localObject).hasNext())
        {
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject = (String)localIterator.next();
          } while (!((String)localObject).endsWith("plugin"));
          localObject = ((ArrayList)a.get(localObject)).iterator();
        }
        localPreloadProcHitSession = (PreloadProcHitSession)((Iterator)localObject).next();
      } while (!((PreloadProcHitPluginSession)localPreloadProcHitSession).a.equals(paramString));
      localPreloadProcHitSession.b();
      localPreloadProcHitSession.d();
    }
  }
  
  public static void b(String paramString)
  {
    synchronized (a)
    {
      Iterator localIterator = a.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        if (((String)localObject).startsWith(paramString))
        {
          localObject = ((ArrayList)a.get(localObject)).iterator();
          if (((Iterator)localObject).hasNext()) {
            ((PreloadProcHitSession)((Iterator)localObject).next()).d();
          }
        }
      }
    }
    c(paramString);
  }
  
  public static void c(String paramString)
  {
    synchronized (a)
    {
      PreloadProcHitPluginSessionProc localPreloadProcHitPluginSessionProc = (PreloadProcHitPluginSessionProc)b.get(paramString);
      if (localPreloadProcHitPluginSessionProc != null)
      {
        localPreloadProcHitPluginSessionProc.d();
        b.remove(paramString);
      }
      return;
    }
  }
  
  public static void d(String paramString)
  {
    synchronized (a)
    {
      paramString = (PreloadProcHitPluginSessionProc)b.get(paramString);
      if (paramString != null) {
        paramString.b();
      }
      return;
    }
  }
  
  public static void e(String paramString)
  {
    synchronized (a)
    {
      if ((PreloadProcHitPluginSessionProc)b.get(paramString) == null)
      {
        PreloadProcHitPluginSessionProc localPreloadProcHitPluginSessionProc = new PreloadProcHitPluginSessionProc(paramString);
        b.put(paramString, localPreloadProcHitPluginSessionProc);
        localPreloadProcHitPluginSessionProc.a();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.hitrate.PreloadProcHitMgr
 * JD-Core Version:    0.7.0.1
 */