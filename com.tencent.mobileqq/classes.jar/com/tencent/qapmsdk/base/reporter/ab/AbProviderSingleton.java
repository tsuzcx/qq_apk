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
    int k = 0;
    StringBuilder localStringBuilder = new StringBuilder();
    Class[] arrayOfClass = abTypeArr;
    int m = arrayOfClass.length;
    int j = 0;
    int i = 0;
    Object localObject;
    if (j < m)
    {
      localObject = arrayOfClass[j];
      localObject = INSTANCE.getAbType((Class)localObject);
      Iterator localIterator = ((Iterable)paramArrayList).iterator();
      boolean bool = false;
      if (localIterator.hasNext())
      {
        int n = ((Number)localIterator.next()).intValue();
        if (localObject != null) {}
        for (bool = ((AbType)localObject).canReportWith(n);; bool = false)
        {
          if (bool) {}
          break;
        }
      }
      if (!bool) {
        break label217;
      }
      if (localObject != null)
      {
        localObject = ((AbType)localObject).getValue();
        if (localObject == null) {}
      }
    }
    for (;;)
    {
      if (i == 1) {
        localStringBuilder.append(";");
      }
      localStringBuilder.append((String)localObject);
      j += 1;
      i += 1;
      break;
      localObject = "";
      continue;
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
      label217:
      localObject = "";
    }
  }
  
  public final void addAbToParams(@Nullable JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("newplugin"))
        {
          i = paramJSONObject.getInt("newplugin");
          String str = getAbFactors(i);
          if (str == null) {
            break;
          }
          paramJSONObject.put("abfactor", str);
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        Logger.INSTANCE.exception("QAPM_base_AbFactorManger", "addFactorToAPM", (Throwable)paramJSONObject);
        return;
      }
      int i = paramJSONObject.getInt("plugin");
    }
  }
  
  @Nullable
  public final String getAbFactors(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == PluginCombination.dropFramePlugin.plugin) {
      localArrayList.add(Integer.valueOf(2));
    }
    String str;
    for (;;)
    {
      str = (String)null;
      Object localObject = str;
      try
      {
        if (localArrayList.size() > 0) {
          localObject = getAbParam(localArrayList);
        }
        return localObject;
      }
      catch (Exception localException)
      {
        Logger.INSTANCE.exception("QAPM_base_AbFactorManger", "addFactorToAPM", (Throwable)localException);
      }
      if (paramInt == PluginCombination.loopStackPlugin.plugin)
      {
        localArrayList.add(Integer.valueOf(2));
      }
      else
      {
        if (paramInt == PluginCombination.ceilingValuePlugin.plugin) {}
        while (paramInt == PluginCombination.ceilingHprofPlugin.plugin)
        {
          localArrayList.add(Integer.valueOf(4));
          break;
        }
        if (paramInt == PluginCombination.resourcePlugin.plugin)
        {
          localArrayList.add(Integer.valueOf(4));
          localArrayList.add(Integer.valueOf(1));
          localArrayList.add(Integer.valueOf(2));
        }
        else
        {
          localObject = callback;
          if (localObject != null) {
            ((IAbCallback)localObject).addType(paramInt, localArrayList);
          }
        }
      }
    }
    return str;
  }
  
  @Nullable
  public final AbType getAbType(@NotNull Class<?> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    AbType localAbType2 = (AbType)abTypeCache.get(paramClass);
    localObject1 = localAbType2;
    if (localAbType2 == null)
    {
      localConcurrentHashMap = abTypeCache;
      localObject1 = localAbType2;
      localAbType1 = localAbType2;
    }
    try
    {
      Object localObject3 = paramClass.newInstance();
      Object localObject2 = localObject3;
      localObject1 = localAbType2;
      localAbType1 = localAbType2;
      if (!(localObject3 instanceof AbType)) {
        localObject2 = null;
      }
      localObject1 = localAbType2;
      localAbType1 = localAbType2;
      localAbType2 = (AbType)localObject2;
      localObject1 = localAbType2;
      if (localAbType2 != null)
      {
        localObject1 = localAbType2;
        localAbType1 = localAbType2;
        paramClass = (AbType)abTypeCache.put(paramClass, localAbType2);
        localObject1 = localAbType2;
      }
    }
    catch (IllegalAccessException paramClass)
    {
      for (;;)
      {
        Logger.INSTANCE.exception("QAPM_base_AbFactorManger", (Throwable)paramClass);
        paramClass = Unit.INSTANCE;
      }
    }
    catch (InstantiationException paramClass)
    {
      for (;;)
      {
        Logger.INSTANCE.exception("QAPM_base_AbFactorManger", (Throwable)paramClass);
        paramClass = Unit.INSTANCE;
        localObject1 = localAbType1;
      }
    }
    finally {}
    return localObject1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.ab.AbProviderSingleton
 * JD-Core Version:    0.7.0.1
 */