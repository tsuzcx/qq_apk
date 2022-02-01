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
      Object localObject1 = new HashSet();
      Iterator localIterator1 = a.values().iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator2 = ((ArrayList)localIterator1.next()).iterator();
        while (localIterator2.hasNext())
        {
          PreloadProcHitSession localPreloadProcHitSession = (PreloadProcHitSession)localIterator2.next();
          localPreloadProcHitSession.d();
          ((HashSet)localObject1).add(localPreloadProcHitSession.d);
        }
      }
      localObject1 = ((HashSet)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        c((String)((Iterator)localObject1).next());
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
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
      else if (!localArrayList.contains(paramPreloadProcHitSession))
      {
        localArrayList.add(paramPreloadProcHitSession);
      }
      return;
    }
  }
  
  public static void a(String paramString)
  {
    synchronized (a)
    {
      Iterator localIterator = a.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        if (((String)localObject).endsWith("plugin"))
        {
          localObject = ((ArrayList)a.get(localObject)).iterator();
          while (((Iterator)localObject).hasNext())
          {
            PreloadProcHitSession localPreloadProcHitSession = (PreloadProcHitSession)((Iterator)localObject).next();
            if (((PreloadProcHitPluginSession)localPreloadProcHitSession).a.equals(paramString))
            {
              localPreloadProcHitSession.b();
              localPreloadProcHitSession.d();
            }
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw paramString;
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
          while (((Iterator)localObject).hasNext()) {
            ((PreloadProcHitSession)((Iterator)localObject).next()).d();
          }
        }
      }
      c(paramString);
      return;
    }
    for (;;)
    {
      throw paramString;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.hitrate.PreloadProcHitMgr
 * JD-Core Version:    0.7.0.1
 */