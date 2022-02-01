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
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      b();
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
        if (!((Iterator)localObject).hasNext()) {
          continue;
        }
        str = (String)((Iterator)localObject).next();
        HashMap localHashMap = (HashMap)a.get(str);
        Iterator localIterator = paramList.iterator();
        if (!localIterator.hasNext()) {
          continue;
        }
        if (!((IDelayReporter)localIterator.next()).a(str, localHashMap)) {
          continue;
        }
        i = 1;
      }
      finally
      {
        String str;
        continue;
        throw paramList;
        continue;
        int i = 0;
        continue;
      }
      if (i == 0) {
        QLog.e("DelayReportUtils", 1, new Object[] { "no reporter for this event : ", str });
      }
    }
    a.clear();
    a = null;
  }
  
  public static boolean a()
  {
    try
    {
      Object localObject1 = a;
      boolean bool2 = false;
      if (localObject1 == null) {
        return false;
      }
      localObject1 = a.keySet();
      boolean bool1 = bool2;
      if (localObject1 != null)
      {
        boolean bool3 = ((Set)localObject1).isEmpty();
        bool1 = bool2;
        if (!bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    finally {}
  }
  
  private static void b()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.DelayReportUtils
 * JD-Core Version:    0.7.0.1
 */