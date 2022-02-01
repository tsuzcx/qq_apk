package com.tencent.mobileqq.vas.hippyhelper;

import android.text.TextUtils;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HippyJSBHelper
{
  private static volatile HippyJSBHelper a;
  private static final Object e = new Object();
  private final ConcurrentHashMap<String, Object> b = new ConcurrentHashMap();
  private Object c;
  private IHippyJsbInvokeAdapter d;
  
  @Nullable
  private Object a(String paramString)
  {
    try
    {
      if ((this.b.containsKey(paramString)) && (this.b.get(paramString) != null))
      {
        paramString = this.b.get(paramString);
      }
      else
      {
        Object localObject = this.d.createWebViewPlugin(paramString);
        if (localObject == null)
        {
          this.d.onCallError("plugin create failed");
          return null;
        }
        this.b.put(paramString, localObject);
        paramString = localObject;
      }
      this.d.onUpdateActivity(paramString);
      return paramString;
    }
    finally {}
  }
  
  private void a(HippyMap paramHippyMap, Object paramObject, String paramString)
  {
    String[] arrayOfString = this.d.getDispatchArgsNameList(paramString);
    Object localObject1 = this.d.getDispatchMethodName(paramString);
    for (;;)
    {
      int i;
      Object[] arrayOfObject;
      try
      {
        Object localObject2 = paramObject.getClass().getDeclaredMethods();
        int k = localObject2.length;
        int j = 0;
        i = 0;
        if (i < k)
        {
          Object localObject3 = localObject2[i];
          if (!((String)localObject1).equals(localObject3.getName()))
          {
            i += 1;
            continue;
          }
          Class[] arrayOfClass = localObject3.getParameterTypes();
          arrayOfObject = new Object[arrayOfClass.length];
          i = j;
          if (i < arrayOfClass.length)
          {
            localObject2 = this.d.getInvokeArgs(i, arrayOfClass[i], paramObject, paramString);
            localObject1 = localObject2;
            if (localObject2 != null) {
              break label235;
            }
            localObject1 = localObject2;
            if (arrayOfString == null) {
              break label235;
            }
            localObject1 = localObject2;
            if (arrayOfString.length != arrayOfClass.length) {
              break label235;
            }
            localObject1 = paramHippyMap.get(arrayOfString[i]);
            break label235;
          }
          localObject3.setAccessible(true);
          localObject3.invoke(paramObject, arrayOfObject);
          return;
        }
      }
      catch (Exception paramHippyMap)
      {
        QLog.e("HippyJSBHelper", 1, "doInvokeJSBMethod error", paramHippyMap);
        paramObject = this.d;
        paramString = new StringBuilder();
        paramString.append("doInvokeJSBMethod error:");
        paramString.append(paramHippyMap);
        paramObject.onCallError(paramString.toString());
      }
      return;
      label235:
      arrayOfObject[i] = localObject1;
      i += 1;
    }
  }
  
  public static HippyJSBHelper b()
  {
    if (a == null) {
      synchronized (e)
      {
        if (a == null) {
          a = new HippyJSBHelper();
        }
      }
    }
    return a;
  }
  
  public IHippyJsbInvokeAdapter a()
  {
    return this.d;
  }
  
  public void a(@NotNull IHippyJsbInvokeAdapter paramIHippyJsbInvokeAdapter)
  {
    this.d = paramIHippyJsbInvokeAdapter;
  }
  
  public void a(HippyMap paramHippyMap)
  {
    Object localObject1 = this.d;
    if (localObject1 == null)
    {
      QLog.e("HippyJSBHelper", 1, "callJsBridge error, need setHippyJsbCallbackAdapter first");
      return;
    }
    localObject1 = ((IHippyJsbInvokeAdapter)localObject1).getJsbNameSpace(paramHippyMap);
    Object localObject2 = this.d.getJsbMethod(paramHippyMap);
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      if (this.d.isNeedIntercept(paramHippyMap))
      {
        this.d.onCallError("custom logic intercepted");
        return;
      }
      localObject2 = a((String)localObject1);
      if (localObject2 == null)
      {
        this.d.onCallError("plugin get failed");
        return;
      }
      if (this.c == null)
      {
        Object localObject3 = this.d.createFakeWebView(localObject2);
        if (localObject3 == null)
        {
          this.d.onCallError("please impl method createFakeWebView");
          return;
        }
        this.c = localObject3;
      }
      this.d.setWebViewInternal(localObject2, this.c);
      a(paramHippyMap, localObject2, (String)localObject1);
      return;
    }
    this.d.onCallError("params namespace and method are both required");
  }
  
  public void a(HashMap<String, Object[]> paramHashMap)
  {
    Iterator localIterator = this.b.values().iterator();
    label268:
    label275:
    for (;;)
    {
      Object localObject3;
      Object localObject2;
      if (localIterator.hasNext())
      {
        localObject3 = localIterator.next();
        localObject2 = null;
      }
      label211:
      do
      {
        for (;;)
        {
          try
          {
            localObject4 = localObject3.getClass().getDeclaredMethods();
            k = localObject4.length;
            j = 0;
            i = 0;
            localObject1 = localObject2;
            if (i >= k) {
              break label275;
            }
            localObject1 = localObject4[i];
            if (!"onActivityResult".equals(localObject1.getName())) {
              break label268;
            }
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            Object localObject4;
            int k;
            int j;
            Object localObject1;
            break label211;
          }
          catch (IllegalAccessException localIllegalAccessException) {}
          localObject2 = localObject1.getParameterTypes();
          localObject4 = new StringBuilder();
          k = localObject2.length;
          int i = j;
          if (i < k)
          {
            ((StringBuilder)localObject4).append(localObject2[i].getSimpleName());
            ((StringBuilder)localObject4).append(',');
            i += 1;
          }
          else
          {
            ((StringBuilder)localObject4).deleteCharAt(((StringBuilder)localObject4).length() - 1);
            if (paramHashMap.containsKey(((StringBuilder)localObject4).toString()))
            {
              localObject1.invoke(localObject3, (Object[])paramHashMap.get(((StringBuilder)localObject4).toString()));
              break;
            }
            this.d.onCallError("please adapt OnActivityResult args");
            return;
            QLog.e("HippyJSBHelper", 1, "dispatchOnActivityResult error:", localIllegalAccessException);
            localObject2 = this.d;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("dispatchOnActivityResult error:");
            ((StringBuilder)localObject3).append(localIllegalAccessException);
            ((IHippyJsbInvokeAdapter)localObject2).onCallError(((StringBuilder)localObject3).toString());
            break;
            return;
            i += 1;
          }
        }
      } while (localIllegalAccessException != null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.hippyhelper.HippyJSBHelper
 * JD-Core Version:    0.7.0.1
 */