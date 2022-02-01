package com.tencent.mobileqq.qroute.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.Service;

public class ProcessChecker
{
  public static boolean check(Class<?> paramClass, String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return true;
    }
    Object localObject2 = null;
    Object localObject1;
    if (paramClass.isAnnotationPresent(QAPI.class))
    {
      paramClass = paramClass.getAnnotation(QAPI.class);
      localObject1 = localObject2;
      if ((paramClass instanceof QAPI)) {
        localObject1 = ((QAPI)paramClass).process();
      }
    }
    else
    {
      localObject1 = localObject2;
      if (paramClass.isAnnotationPresent(Service.class))
      {
        paramClass = paramClass.getAnnotation(Service.class);
        localObject1 = localObject2;
        if ((paramClass instanceof Service)) {
          localObject1 = ((Service)paramClass).process();
        }
      }
    }
    if (localObject1 != null)
    {
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        paramClass = localObject1[i];
        if ("multi".equals(paramClass)) {
          break;
        }
        if ("all".equals(paramClass)) {
          return true;
        }
        if (("".equals(paramClass)) && (TextUtils.isEmpty(paramString))) {
          return true;
        }
        if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(paramClass))) {
          return true;
        }
        i += 1;
      }
    }
    return (!paramBoolean) && (TextUtils.isEmpty(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.utils.ProcessChecker
 * JD-Core Version:    0.7.0.1
 */