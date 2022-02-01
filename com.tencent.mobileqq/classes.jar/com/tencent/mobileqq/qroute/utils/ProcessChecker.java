package com.tencent.mobileqq.qroute.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.Service;

public class ProcessChecker
{
  public static boolean check(Class<?> paramClass, String paramString, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (!paramBoolean) {
      return true;
    }
    Object localObject2 = null;
    if (paramClass.isAnnotationPresent(QAPI.class))
    {
      paramClass = paramClass.getAnnotation(QAPI.class);
      if (!(paramClass instanceof QAPI)) {
        break label225;
      }
    }
    label60:
    label82:
    label220:
    label225:
    for (paramClass = ((QAPI)paramClass).process();; paramClass = null)
    {
      Object localObject1 = paramClass;
      int i;
      if (localObject1 != null)
      {
        int j = localObject1.length;
        i = 0;
        if (i >= j) {
          break label220;
        }
        paramClass = localObject1[i];
        if ("multi".equals(paramClass)) {
          paramBoolean = false;
        }
      }
      for (;;)
      {
        boolean bool1 = paramBoolean;
        for (;;)
        {
          return bool1;
          localObject1 = localObject2;
          if (!paramClass.isAnnotationPresent(Service.class)) {
            break;
          }
          paramClass = paramClass.getAnnotation(Service.class);
          localObject1 = localObject2;
          if (!(paramClass instanceof Service)) {
            break;
          }
          localObject1 = ((Service)paramClass).process();
          break;
          if ("all".equals(paramClass))
          {
            paramBoolean = true;
            break label82;
          }
          if (("".equals(paramClass)) && (TextUtils.isEmpty(paramString)))
          {
            paramBoolean = true;
            break label82;
          }
          if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(paramClass)))
          {
            paramBoolean = true;
            break label82;
          }
          i += 1;
          break label60;
          bool1 = bool2;
          if (!paramBoolean)
          {
            bool1 = bool2;
            if (TextUtils.isEmpty(paramString)) {
              bool1 = true;
            }
          }
        }
        paramBoolean = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.utils.ProcessChecker
 * JD-Core Version:    0.7.0.1
 */