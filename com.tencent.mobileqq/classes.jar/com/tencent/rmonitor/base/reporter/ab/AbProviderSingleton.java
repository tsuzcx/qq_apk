package com.tencent.rmonitor.base.reporter.ab;

import com.tencent.rmonitor.common.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/reporter/ab/AbProviderSingleton;", "", "()V", "ABFACTOR", "", "TAG", "abTypeArr", "", "Ljava/lang/Class;", "Lcom/tencent/rmonitor/base/reporter/ab/AbType;", "getAbTypeArr", "()[Ljava/lang/Class;", "setAbTypeArr", "([Ljava/lang/Class;)V", "[Ljava/lang/Class;", "abTypeCache", "Ljava/util/concurrent/ConcurrentHashMap;", "callback", "Lcom/tencent/rmonitor/base/reporter/ab/IAbCallback;", "getCallback", "()Lcom/tencent/rmonitor/base/reporter/ab/IAbCallback;", "setCallback", "(Lcom/tencent/rmonitor/base/reporter/ab/IAbCallback;)V", "addAbToParams", "", "reportParams", "Lorg/json/JSONObject;", "getAbFactors", "qpmPlugin", "", "getAbParam", "perfTypeList", "Ljava/util/ArrayList;", "getAbType", "clazz", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class AbProviderSingleton
{
  public static final AbProviderSingleton a = new AbProviderSingleton();
  @NotNull
  private static Class<? extends AbType>[] b = new Class[0];
  @Nullable
  private static IAbCallback c;
  private static final ConcurrentHashMap<Class<?>, AbType> d = new ConcurrentHashMap();
  
  private final String a(ArrayList<Integer> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Class[] arrayOfClass = b;
    int m = arrayOfClass.length;
    int k = 0;
    int i = 0;
    int j = 0;
    while (i < m)
    {
      Object localObject1 = arrayOfClass[i];
      Object localObject2 = a.a((Class)localObject1);
      localObject1 = ((Iterable)paramArrayList).iterator();
      int n;
      for (boolean bool = false;; bool = ((AbType)localObject2).canReportWith(n))
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label104;
        }
        n = ((Number)((Iterator)localObject1).next()).intValue();
        if (localObject2 == null) {
          break;
        }
      }
      label104:
      String str = "";
      localObject1 = str;
      if (bool)
      {
        localObject1 = str;
        if (localObject2 != null)
        {
          localObject2 = ((AbType)localObject2).getValue();
          localObject1 = str;
          if (localObject2 != null) {
            localObject1 = localObject2;
          }
        }
      }
      if (j == 1) {
        localStringBuilder.append(";");
      }
      localStringBuilder.append((String)localObject1);
      j += 1;
      i += 1;
    }
    paramArrayList = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArrayList, "sb.toString()");
    i = k;
    if (((CharSequence)paramArrayList).length() == 0) {
      i = 1;
    }
    if (i != 0) {
      return null;
    }
    return localStringBuilder.toString();
  }
  
  @Nullable
  public final AbType a(@NotNull Class<?> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    AbType localAbType = (AbType)d.get(paramClass);
    if (localAbType == null) {}
    try
    {
      try
      {
        synchronized (d)
        {
          Object localObject2 = paramClass.newInstance();
          Object localObject1 = localObject2;
          if (!(localObject2 instanceof AbType)) {
            localObject1 = null;
          }
          localObject1 = (AbType)localObject1;
          if (localObject1 != null) {
            try
            {
              paramClass = (AbType)d.put(paramClass, localObject1);
            }
            catch (InstantiationException localInstantiationException2)
            {
              paramClass = (Class<?>)localObject1;
              localObject1 = localInstantiationException2;
              break label100;
            }
            catch (IllegalAccessException localIllegalAccessException2)
            {
              paramClass = (Class<?>)localObject1;
              localObject1 = localIllegalAccessException2;
              break label119;
            }
          }
          paramClass = (Class<?>)localObject1;
        }
        label100:
        Logger.b.a("RMonitor_base_AbFactorManger", (Throwable)localUnit);
      }
      catch (InstantiationException localInstantiationException1)
      {
        paramClass = localIllegalAccessException2;
        Logger.b.a("RMonitor_base_AbFactorManger", (Throwable)localInstantiationException1);
        localUnit = Unit.INSTANCE;
      }
    }
    catch (IllegalAccessException localIllegalAccessException1)
    {
      for (;;)
      {
        Unit localUnit;
        label119:
        paramClass = localIllegalAccessException2;
      }
    }
    localUnit = Unit.INSTANCE;
    return paramClass;
    throw paramClass;
    return localIllegalAccessException2;
  }
  
  @Nullable
  public final String a(int paramInt)
  {
    Object localObject2 = new ArrayList();
    if (paramInt != 101)
    {
      if (paramInt != 102)
      {
        if (paramInt != 108)
        {
          if (paramInt != 109)
          {
            if (paramInt != 138)
            {
              localObject1 = c;
              if (localObject1 != null) {
                ((IAbCallback)localObject1).a(paramInt, (ArrayList)localObject2);
              }
            }
            else
            {
              ((ArrayList)localObject2).add(Integer.valueOf(4));
              ((ArrayList)localObject2).add(Integer.valueOf(1));
              ((ArrayList)localObject2).add(Integer.valueOf(2));
            }
          }
          else {
            ((ArrayList)localObject2).add(Integer.valueOf(4));
          }
        }
        else {
          ((ArrayList)localObject2).add(Integer.valueOf(4));
        }
      }
      else {
        ((ArrayList)localObject2).add(Integer.valueOf(2));
      }
    }
    else {
      ((ArrayList)localObject2).add(Integer.valueOf(2));
    }
    Object localObject1 = (String)null;
    try
    {
      if (((ArrayList)localObject2).size() > 0)
      {
        localObject2 = a((ArrayList)localObject2);
        return localObject2;
      }
    }
    catch (Exception localException)
    {
      Logger.b.a("RMonitor_base_AbFactorManger", "addFactorToAPM", (Throwable)localException);
    }
    return localObject1;
  }
  
  public final void a(@Nullable IAbCallback paramIAbCallback)
  {
    c = paramIAbCallback;
  }
  
  public final void a(@Nullable JSONObject paramJSONObject)
  {
    String str = "newplugin";
    if (paramJSONObject == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (!paramJSONObject.has("newplugin")) {
          break label61;
        }
        int i = paramJSONObject.getInt(str);
        str = a(i);
        if (str != null)
        {
          paramJSONObject.put("abfactor", str);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        Logger.b.a("RMonitor_base_AbFactorManger", "addFactorToAPM", (Throwable)paramJSONObject);
      }
      return;
      label61:
      str = "plugin";
    }
  }
  
  public final void a(@NotNull Class<? extends AbType>[] paramArrayOfClass)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfClass, "<set-?>");
    b = paramArrayOfClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.reporter.ab.AbProviderSingleton
 * JD-Core Version:    0.7.0.1
 */