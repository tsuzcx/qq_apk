package com.tencent.qqperf.monitor.crash.tools;

import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqMessage;
import mqq.os.MqqMessageQueue;

public class LooperMessagePrinterHelper
{
  private static String a(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    if (paramMessage.getTarget() != null)
    {
      if (paramMessage.getCallback() != null)
      {
        localStringBuilder.append(" callback=");
        localStringBuilder.append(paramMessage.getCallback().getClass().getName());
      }
      else
      {
        localStringBuilder.append(" what=");
        localStringBuilder.append(paramMessage.what);
      }
      if (paramMessage.arg1 != 0)
      {
        localStringBuilder.append(" arg1=");
        localStringBuilder.append(paramMessage.arg1);
      }
      if (paramMessage.arg2 != 0)
      {
        localStringBuilder.append(" arg2=");
        localStringBuilder.append(paramMessage.arg2);
      }
      if (paramMessage.obj != null)
      {
        localStringBuilder.append(" obj=");
        localStringBuilder.append(paramMessage.obj);
      }
      localStringBuilder.append(" target=");
      localStringBuilder.append(paramMessage.getTarget().getClass().getName());
    }
    else
    {
      localStringBuilder.append(" barrier=");
      localStringBuilder.append(paramMessage.arg1);
    }
    return localStringBuilder.toString();
  }
  
  private static HashMap<String, Integer> a(HashMap<String, Integer> paramHashMap)
  {
    Object localObject = new LinkedList(paramHashMap.entrySet());
    Collections.sort((List)localObject, new LooperMessagePrinterHelper.1());
    paramHashMap = new LinkedHashMap();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramHashMap.put(localEntry.getKey(), localEntry.getValue());
    }
    return paramHashMap;
  }
  
  public static void a(StringBuilder paramStringBuilder)
  {
    try
    {
      Object localObject2 = new HashMap();
      Object localObject1 = MqqMessageQueue.getSubMainThreadQueue();
      Object localObject5 = Class.forName("mqq.os.MqqMessageQueue").getDeclaredField("mMessages");
      ((Field)localObject5).setAccessible(true);
      Object localObject4 = Class.forName("mqq.os.MqqMessage");
      Object localObject3 = ((Class)localObject4).getDeclaredField("wrappedMsg");
      ((Field)localObject3).setAccessible(true);
      localObject4 = ((Class)localObject4).getDeclaredField("next");
      ((Field)localObject4).setAccessible(true);
      localObject1 = (MqqMessage)((Field)localObject5).get(localObject1);
      int j = 0;
      int i = 0;
      while ((localObject1 != null) && (i <= 100000))
      {
        i += 1;
        localObject5 = a((Message)((Field)localObject3).get(localObject1));
        if (((HashMap)localObject2).containsKey(localObject5)) {
          ((HashMap)localObject2).put(localObject5, Integer.valueOf(((Integer)((HashMap)localObject2).get(localObject5)).intValue() + 1));
        } else {
          ((HashMap)localObject2).put(localObject5, Integer.valueOf(1));
        }
        localObject1 = (MqqMessage)((Field)localObject4).get(localObject1);
      }
      localObject1 = a((HashMap)localObject2);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("MqqMessageQueeu has ");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" Messages, and it's Top 50 Messages:\n");
      paramStringBuilder.append(((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("MqqMessageQueeu has ");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" Messages, and it's Top 50 Messages:");
      QLog.d("LooperMessagePrinterHelper", 1, ((StringBuilder)localObject2).toString());
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      i = j;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (i > 50) {
          return;
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)((Map.Entry)localObject2).getKey());
        ((StringBuilder)localObject3).append(", Count = ");
        ((StringBuilder)localObject3).append(((Map.Entry)localObject2).getValue());
        ((StringBuilder)localObject3).append("\n");
        localObject2 = ((StringBuilder)localObject3).toString();
        paramStringBuilder.append((String)localObject2);
        QLog.d("LooperMessagePrinterHelper", 1, (String)localObject2);
        i += 1;
      }
      return;
    }
    catch (Throwable paramStringBuilder)
    {
      QLog.e("LooperMessagePrinterHelper", 1, "Fetch MqqMessageQueue's Messages faild", paramStringBuilder);
    }
  }
  
  public static void b(StringBuilder paramStringBuilder)
  {
    for (;;)
    {
      int i;
      try
      {
        localObject2 = new HashMap();
        localObject1 = Class.forName("android.os.MessageQueue").getDeclaredField("mMessages");
        ((Field)localObject1).setAccessible(true);
        localObject3 = Class.forName("android.os.Looper");
        j = 0;
        localObject3 = ((Class)localObject3).getMethod("getQueue", new Class[0]);
        ((Method)localObject3).setAccessible(true);
        localObject1 = (Message)((Field)localObject1).get((MessageQueue)((Method)localObject3).invoke(Looper.getMainLooper(), new Object[0]));
        if (localObject1 == null) {
          break label481;
        }
        localObject3 = a((Message)localObject1);
        if (((HashMap)localObject2).containsKey(localObject3)) {
          ((HashMap)localObject2).put(localObject3, Integer.valueOf(((Integer)((HashMap)localObject2).get(localObject3)).intValue() + 1));
        } else {
          ((HashMap)localObject2).put(localObject3, Integer.valueOf(1));
        }
      }
      catch (Throwable paramStringBuilder)
      {
        Object localObject2;
        Object localObject1;
        Object localObject3;
        int j;
        String str;
        QLog.e("LooperMessagePrinterHelper", 1, "Fetch Main Thread's Messages faild", paramStringBuilder);
      }
      localObject3 = Class.forName("android.os.Message").getDeclaredField("next");
      ((Field)localObject3).setAccessible(true);
      localObject1 = (Message)((Field)localObject3).get(localObject1);
      if ((localObject1 != null) && (i <= 100000))
      {
        i += 1;
        str = a((Message)localObject1);
        if (((HashMap)localObject2).containsKey(str)) {
          ((HashMap)localObject2).put(str, Integer.valueOf(((Integer)((HashMap)localObject2).get(str)).intValue() + 1));
        } else {
          ((HashMap)localObject2).put(str, Integer.valueOf(1));
        }
        localObject1 = (Message)((Field)localObject3).get(localObject1);
      }
      else
      {
        localObject1 = a((HashMap)localObject2);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Main Thread has ");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" Messages, and it's Top 50 Messages:\n");
        paramStringBuilder.append(((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Main Thread has ");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" Messages, and it's Top 50 Messages:");
        QLog.d("LooperMessagePrinterHelper", 1, ((StringBuilder)localObject2).toString());
        localObject1 = ((HashMap)localObject1).entrySet().iterator();
        i = j;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          if (i > 50) {
            return;
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)((Map.Entry)localObject2).getKey());
          ((StringBuilder)localObject3).append(", Count = ");
          ((StringBuilder)localObject3).append(((Map.Entry)localObject2).getValue());
          ((StringBuilder)localObject3).append("\n");
          localObject2 = ((StringBuilder)localObject3).toString();
          paramStringBuilder.append((String)localObject2);
          QLog.d("LooperMessagePrinterHelper", 1, (String)localObject2);
          i += 1;
        }
        else
        {
          return;
          i = 1;
          continue;
          label481:
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.tools.LooperMessagePrinterHelper
 * JD-Core Version:    0.7.0.1
 */