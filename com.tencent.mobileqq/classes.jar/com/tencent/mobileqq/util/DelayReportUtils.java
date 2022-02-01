package com.tencent.mobileqq.util;

import com.tencent.mobileqq.app.identity.IDelayReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DelayReportUtils
{
  private static Map<String, HashMap<String, String>> a;
  
  private static void a()
  {
    try
    {
      if (a == null) {
        a = new HashMap();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      a();
      HashMap localHashMap2 = (HashMap)a.get(paramString1);
      HashMap localHashMap1 = localHashMap2;
      if (localHashMap2 == null)
      {
        localHashMap1 = new HashMap();
        a.put(paramString1, localHashMap1);
      }
      localHashMap1.put(paramString2, paramString3);
      return;
    }
    finally {}
  }
  
  public static void a(List<IDelayReporter> paramList)
  {
    for (;;)
    {
      try
      {
        Object localObject = a;
        if (localObject == null) {
          return;
        }
        localObject = a.keySet().iterator();
        if (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          HashMap localHashMap = (HashMap)a.get(str);
          Iterator localIterator = paramList.iterator();
          if (!localIterator.hasNext()) {
            break label150;
          }
          if (!((IDelayReporter)localIterator.next()).a(str, localHashMap)) {
            continue;
          }
          i = 1;
          if (i != 0) {
            continue;
          }
          QLog.e("DelayReportUtils", 1, new Object[] { "no reporter for this event : ", str });
          continue;
        }
        a.clear();
      }
      finally {}
      a = null;
      continue;
      label150:
      int i = 0;
    }
  }
  
  /* Error */
  public static boolean a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: ldc 2
    //   4: monitorenter
    //   5: getstatic 14	com/tencent/mobileqq/util/DelayReportUtils:a	Ljava/util/Map;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnonnull +10 -> 20
    //   13: iload_1
    //   14: istore_0
    //   15: ldc 2
    //   17: monitorexit
    //   18: iload_0
    //   19: ireturn
    //   20: getstatic 14	com/tencent/mobileqq/util/DelayReportUtils:a	Ljava/util/Map;
    //   23: invokeinterface 36 1 0
    //   28: astore_3
    //   29: iload_1
    //   30: istore_0
    //   31: aload_3
    //   32: ifnull -17 -> 15
    //   35: aload_3
    //   36: invokeinterface 80 1 0
    //   41: istore_2
    //   42: iload_1
    //   43: istore_0
    //   44: iload_2
    //   45: ifne -30 -> 15
    //   48: iconst_1
    //   49: istore_0
    //   50: goto -35 -> 15
    //   53: astore_3
    //   54: ldc 2
    //   56: monitorexit
    //   57: aload_3
    //   58: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   14	36	0	bool1	boolean
    //   1	42	1	bool2	boolean
    //   41	4	2	bool3	boolean
    //   8	28	3	localObject1	Object
    //   53	5	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   5	9	53	finally
    //   20	29	53	finally
    //   35	42	53	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.DelayReportUtils
 * JD-Core Version:    0.7.0.1
 */