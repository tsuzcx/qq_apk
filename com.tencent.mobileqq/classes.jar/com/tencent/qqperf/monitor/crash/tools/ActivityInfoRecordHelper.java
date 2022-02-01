package com.tencent.qqperf.monitor.crash.tools;

import android.app.Activity;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ActivityInfoRecordHelper
{
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(10);
    try
    {
      localObject1 = new HashMap();
      localObject2 = a(new Class[] { Activity.class });
      if (localObject2 == null) {
        break label208;
      }
      j = localObject2[0].length;
      localStringBuilder.append("\nTotal Count: ");
      localStringBuilder.append(j);
      localStringBuilder.append("\n");
      i = 0;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        int j;
        int i;
        String str;
        label208:
        continue;
        i += 1;
      }
    }
    if (i < j)
    {
      str = localObject2[0][i].getClass().getName();
      if (!((HashMap)localObject1).containsKey(str)) {
        ((HashMap)localObject1).put(str, Integer.valueOf(1));
      } else {
        ((HashMap)localObject1).put(str, Integer.valueOf(((Integer)((HashMap)localObject1).get(str)).intValue() + 1));
      }
    }
    else
    {
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localStringBuilder.append((String)((Map.Entry)localObject2).getKey());
        localStringBuilder.append(" : ");
        localStringBuilder.append(((Map.Entry)localObject2).getValue());
        localStringBuilder.append("\n");
      }
      return localStringBuilder.toString();
    }
  }
  
  private static Object[][] a(Class[] paramArrayOfClass)
  {
    try
    {
      paramArrayOfClass = (Object[][])Class.forName("dalvik.system.VMDebug").getDeclaredMethod("getInstancesOfClasses", new Class[] { [Ljava.lang.Class.class, Boolean.TYPE }).invoke(null, new Object[] { paramArrayOfClass, Boolean.valueOf(true) });
      return paramArrayOfClass;
    }
    catch (Throwable paramArrayOfClass)
    {
      label53:
      break label53;
    }
    return (Object[][])null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.tools.ActivityInfoRecordHelper
 * JD-Core Version:    0.7.0.1
 */