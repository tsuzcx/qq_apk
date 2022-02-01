package com.tencent.qapmsdk.base.reporter.ab;

import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.common.logger.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class AbProviderSingleton
{
  public static final String ABFACTOR = "abfactor";
  private static final int PLUGIN_QCLOUD_CPU_TRACE = 126;
  private static final int PLUGIN_QCLOUD_MEMORY_CACHE = 129;
  public static final String TAG = "QAPM_AbFactorManger";
  private static AbProviderSingleton instance = null;
  public Class<? extends AbType>[] abTypeArr = new Class[0];
  private ConcurrentHashMap<Class, AbType> abTypeCache = new ConcurrentHashMap();
  
  private String getAbParam(ArrayList<Integer> paramArrayList)
  {
    Class[] arrayOfClass = this.abTypeArr;
    int k = arrayOfClass.length;
    int i = 0;
    int j = 0;
    Object localObject2 = null;
    AbType localAbType;
    Object localObject1;
    if (i < k)
    {
      localAbType = getAbType(arrayOfClass[i]);
      localObject1 = paramArrayList.iterator();
      int m = 0;
      while (((Iterator)localObject1).hasNext())
      {
        boolean bool = localAbType.canReportWith(((Integer)((Iterator)localObject1).next()).intValue());
        m = bool;
        if (bool) {
          m = bool;
        }
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new StringBuilder();
      }
      if (m == 0) {
        break label166;
      }
    }
    label166:
    for (localObject2 = localAbType.value;; localObject2 = "")
    {
      if (j == 1) {
        ((StringBuilder)localObject1).append(";");
      }
      ((StringBuilder)localObject1).append((String)localObject2);
      j += 1;
      i += 1;
      localObject2 = localObject1;
      break;
      if (localObject2 != null) {
        return ((StringBuilder)localObject2).toString();
      }
      return "";
    }
  }
  
  public static AbProviderSingleton getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new AbProviderSingleton();
      }
      return instance;
    }
    finally {}
  }
  
  public void addAbToParams(JSONObject paramJSONObject)
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
        Logger.INSTANCE.exception("QAPM_AbFactorManger", "addFactorToAPM", paramJSONObject);
        return;
      }
      int i = paramJSONObject.getInt("plugin");
    }
  }
  
  public String getAbFactors(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt == PluginCombination.dropFramePlugin.plugin) {
      localArrayList.add(Integer.valueOf(2));
    }
    for (;;)
    {
      String str = null;
      try
      {
        if (localArrayList.size() > 0) {
          str = getAbParam(localArrayList);
        }
        return str;
      }
      catch (Exception localException)
      {
        Logger.INSTANCE.exception("QAPM_AbFactorManger", "addFactorToAPM", localException);
      }
      if (paramInt == PluginCombination.loopStackPlugin.plugin)
      {
        localArrayList.add(Integer.valueOf(2));
      }
      else if ((paramInt == PluginCombination.ceilingHprofPlugin.plugin) || (paramInt == PluginCombination.ceilingHprofPlugin.plugin))
      {
        localArrayList.add(Integer.valueOf(4));
      }
      else if (paramInt == PluginCombination.resourcePlugin.plugin)
      {
        localArrayList.add(Integer.valueOf(4));
        localArrayList.add(Integer.valueOf(1));
        localArrayList.add(Integer.valueOf(2));
      }
      else if (paramInt == 126)
      {
        localArrayList.add(Integer.valueOf(1));
      }
      else if (paramInt == 129)
      {
        localArrayList.add(Integer.valueOf(4));
      }
    }
    return null;
  }
  
  /* Error */
  public AbType getAbType(Class paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/tencent/qapmsdk/base/reporter/ab/AbProviderSingleton:abTypeCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   4: aload_1
    //   5: invokevirtual 179	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8: checkcast 71	com/tencent/qapmsdk/base/reporter/ab/AbType
    //   11: astore_2
    //   12: aload_2
    //   13: ifnonnull +59 -> 72
    //   16: aload_0
    //   17: getfield 41	com/tencent/qapmsdk/base/reporter/ab/AbProviderSingleton:abTypeCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   20: astore 4
    //   22: aload 4
    //   24: monitorenter
    //   25: aload_1
    //   26: invokevirtual 182	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   29: checkcast 71	com/tencent/qapmsdk/base/reporter/ab/AbType
    //   32: astore_3
    //   33: aload_3
    //   34: astore_2
    //   35: aload_0
    //   36: getfield 41	com/tencent/qapmsdk/base/reporter/ab/AbProviderSingleton:abTypeCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   39: aload_1
    //   40: aload_2
    //   41: invokevirtual 185	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   44: pop
    //   45: aload 4
    //   47: monitorexit
    //   48: aload_2
    //   49: areturn
    //   50: astore_3
    //   51: aload_3
    //   52: invokevirtual 188	java/lang/IllegalAccessException:printStackTrace	()V
    //   55: goto -20 -> 35
    //   58: astore_1
    //   59: aload 4
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    //   64: astore_3
    //   65: aload_3
    //   66: invokevirtual 189	java/lang/InstantiationException:printStackTrace	()V
    //   69: goto -34 -> 35
    //   72: aload_2
    //   73: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	AbProviderSingleton
    //   0	74	1	paramClass	Class
    //   11	62	2	localObject	Object
    //   32	2	3	localAbType	AbType
    //   50	2	3	localIllegalAccessException	java.lang.IllegalAccessException
    //   64	2	3	localInstantiationException	java.lang.InstantiationException
    // Exception table:
    //   from	to	target	type
    //   25	33	50	java/lang/IllegalAccessException
    //   25	33	58	finally
    //   35	48	58	finally
    //   51	55	58	finally
    //   59	62	58	finally
    //   65	69	58	finally
    //   25	33	64	java/lang/InstantiationException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.base.reporter.ab.AbProviderSingleton
 * JD-Core Version:    0.7.0.1
 */