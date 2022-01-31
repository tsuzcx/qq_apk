package com.tencent.plato;

import com.tencent.plato.annotation.CallThread;
import com.tencent.plato.annotation.Exported;
import com.tencent.plato.core.IExportedMethod;
import java.lang.reflect.Method;
import java.util.HashMap;

class ExportedMethodFinder
{
  static HashMap<String, IExportedMethod> findExportedMethods(Class<?> paramClass)
  {
    HashMap localHashMap = new HashMap();
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    if (i < j)
    {
      Method localMethod = arrayOfMethod[i];
      Object localObject = (Exported)localMethod.getAnnotation(Exported.class);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = ((Exported)localObject).value();
        if (localHashMap.containsKey(localObject)) {
          throw new IllegalStateException(paramClass.getName() + " method name already registered: " + (String)localObject);
        }
        boolean bool = false;
        CallThread localCallThread = (CallThread)localMethod.getAnnotation(CallThread.class);
        if (localCallThread != null) {
          bool = "UI".equals(localCallThread.value());
        }
        localHashMap.put(localObject, new ExportedMethodImpl(paramClass, (String)localObject, localMethod, bool));
      }
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.ExportedMethodFinder
 * JD-Core Version:    0.7.0.1
 */