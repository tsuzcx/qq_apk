package com.tencent.xweb;

import com.tencent.xweb.util.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.Log;

public class XWebCoreContentProvider$a
{
  private static List<XWebCoreContentProvider.b> a = new ArrayList();
  private static final Object b = new Object();
  
  public static void a()
  {
    Log.i("XWebCoreContentProvider", "CachedInfoMgr process cached info");
    synchronized (b)
    {
      Iterator localIterator = a.iterator();
      while (localIterator.hasNext())
      {
        XWebCoreContentProvider.b localb = (XWebCoreContentProvider.b)localIterator.next();
        h.a(localb.a, localb.b);
      }
      a.clear();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public static void a(XWebCoreContentProvider.b paramb)
  {
    synchronized (b)
    {
      a.add(paramb);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.XWebCoreContentProvider.a
 * JD-Core Version:    0.7.0.1
 */