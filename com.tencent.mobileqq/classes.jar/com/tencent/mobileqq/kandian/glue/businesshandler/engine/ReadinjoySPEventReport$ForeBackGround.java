package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.mobileqq.kandian.repo.feeds.IForeBackGroundCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReadinjoySPEventReport$ForeBackGround
{
  public static int a = 0;
  public static long b = 0L;
  public static long c = 0L;
  public static long d = 0L;
  public static long e = 0L;
  private static int f = -1;
  private static Map<Integer, IForeBackGroundCallback> g = new ConcurrentHashMap();
  private static List<IForeBackGroundCallback> h = new ArrayList();
  
  static
  {
    a = 2;
    e();
  }
  
  public static void a()
  {
    f = -1;
  }
  
  public static void a(int paramInt)
  {
    f = paramInt;
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 25) {
            return;
          }
          d = System.currentTimeMillis();
          return;
        }
        e = System.currentTimeMillis();
        return;
      }
      c = System.currentTimeMillis();
      return;
    }
    b = System.currentTimeMillis();
  }
  
  public static void a(IForeBackGroundCallback paramIForeBackGroundCallback)
  {
    if (paramIForeBackGroundCallback == null) {
      return;
    }
    try
    {
      if (!h.contains(paramIForeBackGroundCallback)) {
        h.add(paramIForeBackGroundCallback);
      }
      return;
    }
    finally
    {
      paramIForeBackGroundCallback = finally;
      throw paramIForeBackGroundCallback;
    }
  }
  
  public static void b()
  {
    try
    {
      a = 1;
      ReadinjoySPEventReport.g(System.currentTimeMillis());
      if (d())
      {
        localObject1 = (IForeBackGroundCallback)g.get(Integer.valueOf(f));
        if (localObject1 != null) {
          ((IForeBackGroundCallback)localObject1).a();
        }
      }
      Object localObject1 = h.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        IForeBackGroundCallback localIForeBackGroundCallback = (IForeBackGroundCallback)((Iterator)localObject1).next();
        if (localIForeBackGroundCallback != null) {
          localIForeBackGroundCallback.a();
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
  
  public static void b(IForeBackGroundCallback paramIForeBackGroundCallback)
  {
    if (paramIForeBackGroundCallback != null) {}
    try
    {
      h.remove(paramIForeBackGroundCallback);
    }
    finally {}
  }
  
  public static void c()
  {
    try
    {
      a = 2;
      if (d())
      {
        localObject1 = (IForeBackGroundCallback)g.get(Integer.valueOf(f));
        if (localObject1 != null) {
          ((IForeBackGroundCallback)localObject1).cU_();
        }
      }
      Object localObject1 = h.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        IForeBackGroundCallback localIForeBackGroundCallback = (IForeBackGroundCallback)((Iterator)localObject1).next();
        if (localIForeBackGroundCallback != null) {
          localIForeBackGroundCallback.cU_();
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
  
  private static boolean d()
  {
    int i = f;
    return (i > 0) && ((i == 2) || (i == 3) || (i == 4) || (i == 25));
  }
  
  private static void e()
  {
    g.put(Integer.valueOf(2), new ReadinjoySPEventReport.ForeBackGround.1());
    g.put(Integer.valueOf(3), new ReadinjoySPEventReport.ForeBackGround.2());
    g.put(Integer.valueOf(25), new ReadinjoySPEventReport.ForeBackGround.3());
    g.put(Integer.valueOf(4), new ReadinjoySPEventReport.ForeBackGround.4());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.ForeBackGround
 * JD-Core Version:    0.7.0.1
 */