package com.tencent.viola.module;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.viola.bridge.Invoker;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

public class ViolaModuleManager
{
  public static final String TAG = "ViolaModuleManager";
  private static Map<String, DomModule> sDomModuleMap = new HashMap();
  public static Map<String, BaseModule> sGlobalModuleMap = new HashMap();
  private static Map<String, Map<String, BaseModule>> sInstanceModuleMap = new ConcurrentHashMap();
  private static Map<String, IModuleHolder> sTypeModuleHolderMap = new ConcurrentHashMap();
  
  /* Error */
  public static Object callModuleMethod(String paramString1, String paramString2, String paramString3, JSONArray paramJSONArray)
  {
    // Byte code:
    //   0: getstatic 31	com/tencent/viola/module/ViolaModuleManager:sTypeModuleHolderMap	Ljava/util/Map;
    //   3: aload_1
    //   4: invokeinterface 49 2 0
    //   9: checkcast 51	com/tencent/viola/module/IModuleHolder
    //   12: astore 5
    //   14: aload 5
    //   16: ifnonnull +42 -> 58
    //   19: new 53	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   26: astore_0
    //   27: aload_0
    //   28: ldc 56
    //   30: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_0
    //   35: aload_1
    //   36: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_0
    //   41: ldc 62
    //   43: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: ldc 8
    //   49: aload_0
    //   50: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 72	com/tencent/viola/utils/ViolaLogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aconst_null
    //   57: areturn
    //   58: aload_0
    //   59: aload_1
    //   60: aload 5
    //   62: invokestatic 76	com/tencent/viola/module/ViolaModuleManager:findModule	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/viola/module/IModuleHolder;)Lcom/tencent/viola/module/BaseModule;
    //   65: astore 4
    //   67: aload 4
    //   69: ifnonnull +5 -> 74
    //   72: aconst_null
    //   73: areturn
    //   74: invokestatic 82	com/tencent/viola/core/ViolaSDKManager:getInstance	()Lcom/tencent/viola/core/ViolaSDKManager;
    //   77: aload_0
    //   78: invokevirtual 86	com/tencent/viola/core/ViolaSDKManager:getViolaInstance	(Ljava/lang/String;)Lcom/tencent/viola/core/ViolaInstance;
    //   81: astore_0
    //   82: aload 4
    //   84: aload_0
    //   85: invokevirtual 92	com/tencent/viola/module/BaseModule:setViolaInstance	(Lcom/tencent/viola/core/ViolaInstance;)V
    //   88: aload 5
    //   90: aload_2
    //   91: invokeinterface 96 2 0
    //   96: astore 5
    //   98: aload_0
    //   99: ifnull +39 -> 138
    //   102: aload_0
    //   103: invokevirtual 102	com/tencent/viola/core/ViolaInstance:getNativeInvokeHelper	()Lcom/tencent/viola/bridge/NativeInvokeHelper;
    //   106: aload 4
    //   108: aload 5
    //   110: aload_3
    //   111: invokevirtual 108	com/tencent/viola/bridge/NativeInvokeHelper:invoke	(Ljava/lang/Object;Lcom/tencent/viola/bridge/Invoker;Lorg/json/JSONArray;)Ljava/lang/Object;
    //   114: pop
    //   115: aload 4
    //   117: instanceof 110
    //   120: ifeq +9 -> 129
    //   123: aload 4
    //   125: aconst_null
    //   126: invokevirtual 92	com/tencent/viola/module/BaseModule:setViolaInstance	(Lcom/tencent/viola/core/ViolaInstance;)V
    //   129: aconst_null
    //   130: areturn
    //   131: goto +102 -> 233
    //   134: astore_0
    //   135: goto +26 -> 161
    //   138: ldc 8
    //   140: ldc 112
    //   142: invokestatic 72	com/tencent/viola/utils/ViolaLogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload 4
    //   147: instanceof 110
    //   150: ifeq +9 -> 159
    //   153: aload 4
    //   155: aconst_null
    //   156: invokevirtual 92	com/tencent/viola/module/BaseModule:setViolaInstance	(Lcom/tencent/viola/core/ViolaInstance;)V
    //   159: aconst_null
    //   160: areturn
    //   161: new 53	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   168: astore_3
    //   169: aload_3
    //   170: ldc 114
    //   172: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload_3
    //   177: aload_1
    //   178: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload_3
    //   183: ldc 116
    //   185: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload_3
    //   190: aload_2
    //   191: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_3
    //   196: ldc 118
    //   198: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: aload_3
    //   203: aload_0
    //   204: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: ldc 8
    //   210: aload_3
    //   211: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 72	com/tencent/viola/utils/ViolaLogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload 4
    //   219: instanceof 110
    //   222: ifeq +9 -> 231
    //   225: aload 4
    //   227: aconst_null
    //   228: invokevirtual 92	com/tencent/viola/module/BaseModule:setViolaInstance	(Lcom/tencent/viola/core/ViolaInstance;)V
    //   231: aconst_null
    //   232: areturn
    //   233: aload 4
    //   235: instanceof 110
    //   238: ifeq +9 -> 247
    //   241: aload 4
    //   243: aconst_null
    //   244: invokevirtual 92	com/tencent/viola/module/BaseModule:setViolaInstance	(Lcom/tencent/viola/core/ViolaInstance;)V
    //   247: aconst_null
    //   248: areturn
    //   249: astore_0
    //   250: goto -119 -> 131
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	paramString1	String
    //   0	253	1	paramString2	String
    //   0	253	2	paramString3	String
    //   0	253	3	paramJSONArray	JSONArray
    //   65	177	4	localBaseModule	BaseModule
    //   12	97	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   102	115	134	java/lang/Exception
    //   138	145	134	java/lang/Exception
    //   102	115	249	finally
    //   138	145	249	finally
    //   161	217	249	finally
  }
  
  public static void createDomModule(ViolaInstance paramViolaInstance)
  {
    if (paramViolaInstance != null)
    {
      DomModule localDomModule = new DomModule();
      localDomModule.setViolaInstance(paramViolaInstance);
      sDomModuleMap.put(paramViolaInstance.getInstanceId(), localDomModule);
    }
  }
  
  public static void destroy(String paramString)
  {
    sDomModuleMap.remove(paramString);
    paramString = (Map)sInstanceModuleMap.remove(paramString);
  }
  
  private static Object dispatchCallModuleMethod(@NonNull ViolaInstance paramViolaInstance, @NonNull BaseModule paramBaseModule, @NonNull JSONArray paramJSONArray, @NonNull Invoker paramInvoker)
  {
    return null;
  }
  
  private static BaseModule findModule(String paramString1, String paramString2, IModuleHolder paramIModuleHolder)
  {
    Object localObject1 = (BaseModule)sGlobalModuleMap.get(paramString2);
    Object localObject2;
    if (localObject1 == null)
    {
      localObject2 = (Map)sInstanceModuleMap.get(paramString1);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ConcurrentHashMap();
        sInstanceModuleMap.put(paramString1, localObject1);
      }
      localObject2 = (BaseModule)((Map)localObject1).get(paramString2);
      if (localObject2 != null) {}
    }
    for (;;)
    {
      try
      {
        if (!(paramIModuleHolder instanceof ModuleSimpleHolder)) {
          break label163;
        }
        paramIModuleHolder = paramIModuleHolder.buildInstance();
        paramIModuleHolder.setModuleName(paramString2);
        ((Map)localObject1).put(paramString2, paramIModuleHolder);
        sInstanceModuleMap.put(paramString1, localObject1);
        return paramIModuleHolder;
      }
      catch (Exception paramString1)
      {
        paramIModuleHolder = new StringBuilder();
        paramIModuleHolder.append(paramString2);
        paramIModuleHolder.append(" module build instace failed.");
        paramIModuleHolder.append(paramString1);
        ViolaLogUtils.e("ViolaModuleManager", paramIModuleHolder.toString());
        return null;
      }
      return localObject2;
      return localObject1;
      label163:
      paramIModuleHolder = (IModuleHolder)localObject2;
    }
  }
  
  public static Map<String, BaseModule> findModuleMapById(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (sInstanceModuleMap.containsKey(paramString))) {
      return (Map)sInstanceModuleMap.get(paramString);
    }
    return null;
  }
  
  public static DomModule getDomModule(String paramString)
  {
    return (DomModule)sDomModuleMap.get(paramString);
  }
  
  public static <T> T getModule(String paramString1, String paramString2)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        IModuleHolder localIModuleHolder = (IModuleHolder)sTypeModuleHolderMap.get(paramString2);
        if (localIModuleHolder == null) {
          return null;
        }
        paramString2 = findModule(paramString1, paramString2, localIModuleHolder);
        if (paramString2 != null)
        {
          paramString2.setViolaInstance(ViolaSDKManager.getInstance().getViolaInstance(paramString1));
          return paramString2;
        }
        return null;
      }
      return null;
    }
    finally {}
  }
  
  static boolean registerJSModule(String paramString, IModuleHolder paramIModuleHolder)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString, paramIModuleHolder.getMethods());
    ViolaSDKManager.getInstance().registerModules(localHashMap);
    return true;
  }
  
  public static boolean registerModule(String paramString, IModuleHolder paramIModuleHolder, boolean paramBoolean)
  {
    if (paramString != null)
    {
      if (paramIModuleHolder == null) {
        return false;
      }
      if (TextUtils.equals(paramString, "dom"))
      {
        ViolaLogUtils.e("ViolaModuleManager", "Cannot registered module with name 'dom'.");
        return false;
      }
      ViolaBridgeManager.getInstance().post(new ViolaModuleManager.1(paramString, paramBoolean, paramIModuleHolder));
      return true;
    }
    return false;
  }
  
  static boolean registerNativeModule(String paramString, IModuleHolder paramIModuleHolder)
  {
    if (paramIModuleHolder == null) {
      return false;
    }
    try
    {
      sTypeModuleHolderMap.put(paramString, paramIModuleHolder);
    }
    catch (ArrayStoreException paramString)
    {
      paramString.printStackTrace();
    }
    return true;
  }
  
  public static boolean registerOnlyNativeModule(String paramString, IModuleHolder paramIModuleHolder)
  {
    if (paramString != null)
    {
      if (paramIModuleHolder == null) {
        return false;
      }
      if (TextUtils.equals(paramString, "dom"))
      {
        ViolaLogUtils.e("ViolaModuleManager", "Cannot registered module with name 'dom'.");
        return false;
      }
      ViolaBridgeManager.getInstance().post(new ViolaModuleManager.2(paramString, paramIModuleHolder));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.module.ViolaModuleManager
 * JD-Core Version:    0.7.0.1
 */