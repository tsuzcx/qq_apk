package com.tencent.qapmsdk.base.reporter.ab;

import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.common.logger.Logger;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/reporter/ab/AbProviderSingleton;", "", "()V", "ABFACTOR", "", "TAG", "abTypeArr", "", "Ljava/lang/Class;", "Lcom/tencent/qapmsdk/base/reporter/ab/AbType;", "getAbTypeArr", "()[Ljava/lang/Class;", "setAbTypeArr", "([Ljava/lang/Class;)V", "[Ljava/lang/Class;", "abTypeCache", "Ljava/util/concurrent/ConcurrentHashMap;", "callback", "Lcom/tencent/qapmsdk/base/reporter/ab/IAbCallback;", "getCallback", "()Lcom/tencent/qapmsdk/base/reporter/ab/IAbCallback;", "setCallback", "(Lcom/tencent/qapmsdk/base/reporter/ab/IAbCallback;)V", "addAbToParams", "", "reportParams", "Lorg/json/JSONObject;", "getAbFactors", "qpmPlugin", "", "getAbParam", "perfTypeList", "Ljava/util/ArrayList;", "getAbType", "clazz", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class AbProviderSingleton
{
  private static final String ABFACTOR = "abfactor";
  public static final AbProviderSingleton INSTANCE = new AbProviderSingleton();
  private static final String TAG = "QAPM_base_AbFactorManger";
  @NotNull
  private static Class<? extends AbType>[] abTypeArr = new Class[0];
  private static final ConcurrentHashMap<Class<?>, AbType> abTypeCache = new ConcurrentHashMap();
  @Nullable
  private static IAbCallback callback;
  
  private final String getAbParam(ArrayList<Integer> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Class[] arrayOfClass = abTypeArr;
    int m = arrayOfClass.length;
    int k = 0;
    int i = 0;
    int j = 0;
    while (i < m)
    {
      Object localObject1 = arrayOfClass[i];
      Object localObject2 = INSTANCE.getAbType((Class)localObject1);
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
  
  public final void addAbToParams(@Nullable JSONObject paramJSONObject)
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
        str = getAbFactors(i);
        if (str != null)
        {
          paramJSONObject.put("abfactor", str);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        Logger.INSTANCE.exception("QAPM_base_AbFactorManger", "addFactorToAPM", (Throwable)paramJSONObject);
      }
      return;
      label61:
      str = "plugin";
    }
  }
  
  @Nullable
  public final String getAbFactors(int paramInt)
  {
    Object localObject1 = new ArrayList();
    int i = PluginCombination.dropFramePlugin.plugin;
    Object localObject2 = Integer.valueOf(2);
    if (paramInt == i)
    {
      ((ArrayList)localObject1).add(localObject2);
    }
    else if (paramInt == PluginCombination.loopStackPlugin.plugin)
    {
      ((ArrayList)localObject1).add(localObject2);
    }
    else if ((paramInt == PluginCombination.ceilingValuePlugin.plugin) || (paramInt == PluginCombination.ceilingHprofPlugin.plugin))
    {
      ((ArrayList)localObject1).add(Integer.valueOf(4));
    }
    else if (paramInt == PluginCombination.resourcePlugin.plugin)
    {
      ((ArrayList)localObject1).add(Integer.valueOf(4));
      ((ArrayList)localObject1).add(Integer.valueOf(1));
      ((ArrayList)localObject1).add(localObject2);
    }
    else
    {
      localObject2 = callback;
      if (localObject2 != null) {
        ((IAbCallback)localObject2).addType(paramInt, (ArrayList)localObject1);
      }
    }
    localObject2 = (String)null;
    try
    {
      if (((ArrayList)localObject1).size() > 0)
      {
        localObject1 = getAbParam((ArrayList)localObject1);
        return localObject1;
      }
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.exception("QAPM_base_AbFactorManger", "addFactorToAPM", (Throwable)localException);
    }
    return localObject2;
  }
  
  @Nullable
  public final AbType getAbType(@NotNull Class<?> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    AbType localAbType = (AbType)abTypeCache.get(paramClass);
    if (localAbType == null) {}
    try
    {
      try
      {
        synchronized (abTypeCache)
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
              paramClass = (AbType)abTypeCache.put(paramClass, localObject1);
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
        Logger.INSTANCE.exception("QAPM_base_AbFactorManger", (Throwable)localUnit);
      }
      catch (InstantiationException localInstantiationException1)
      {
        paramClass = localIllegalAccessException2;
        Logger.INSTANCE.exception("QAPM_base_AbFactorManger", (Throwable)localInstantiationException1);
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
  
  @NotNull
  public final Class<? extends AbType>[] getAbTypeArr()
  {
    return abTypeArr;
  }
  
  @Nullable
  public final IAbCallback getCallback()
  {
    return callback;
  }
  
  public final void setAbTypeArr(@NotNull Class<? extends AbType>[] paramArrayOfClass)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfClass, "<set-?>");
    abTypeArr = paramArrayOfClass;
  }
  
  public final void setCallback(@Nullable IAbCallback paramIAbCallback)
  {
    callback = paramIAbCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.ab.AbProviderSingleton
 * JD-Core Version:    0.7.0.1
 */