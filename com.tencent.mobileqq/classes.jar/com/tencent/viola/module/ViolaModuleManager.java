package com.tencent.viola.module;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.viola.bridge.Invoker;
import com.tencent.viola.bridge.NativeInvokeHelper;
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
  
  public static Object callModuleMethod(String paramString1, String paramString2, String paramString3, JSONArray paramJSONArray)
  {
    Object localObject = (IModuleHolder)sTypeModuleHolderMap.get(paramString2);
    if (localObject == null) {
      ViolaLogUtils.e("ViolaModuleManager", "module " + paramString2 + "  not found.");
    }
    BaseModule localBaseModule;
    do
    {
      for (;;)
      {
        return null;
        localBaseModule = findModule(paramString1, paramString2, (IModuleHolder)localObject);
        if (localBaseModule != null)
        {
          paramString1 = ViolaSDKManager.getInstance().getViolaInstance(paramString1);
          localBaseModule.setViolaInstance(paramString1);
          localObject = ((IModuleHolder)localObject).getMethodInvoker(paramString3);
          if (paramString1 != null) {}
          try
          {
            paramString1.getNativeInvokeHelper().invoke(localBaseModule, (Invoker)localObject, paramJSONArray);
            if ((localBaseModule instanceof DomModule))
            {
              localBaseModule.setViolaInstance(null);
              return null;
              ViolaLogUtils.e("ViolaModuleManager", "callModuleMethod >>> instance is null");
              if ((localBaseModule instanceof DomModule))
              {
                localBaseModule.setViolaInstance(null);
                return null;
              }
            }
          }
          catch (Exception paramString1)
          {
            paramString1 = paramString1;
            ViolaLogUtils.e("ViolaModuleManager", "callModuleMethod >>> invoke module:" + paramString2 + ", method:" + paramString3 + " failed. " + paramString1);
            if ((localBaseModule instanceof DomModule))
            {
              localBaseModule.setViolaInstance(null);
              return null;
            }
          }
          finally {}
        }
      }
    } while (!(localBaseModule instanceof DomModule));
    localBaseModule.setViolaInstance(null);
    return null;
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
    if ((Map)sInstanceModuleMap.remove(paramString) != null) {}
  }
  
  private static Object dispatchCallModuleMethod(@NonNull ViolaInstance paramViolaInstance, @NonNull BaseModule paramBaseModule, @NonNull JSONArray paramJSONArray, @NonNull Invoker paramInvoker)
  {
    return null;
  }
  
  private static BaseModule findModule(String paramString1, String paramString2, IModuleHolder paramIModuleHolder)
  {
    Object localObject2 = (BaseModule)sGlobalModuleMap.get(paramString2);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = (Map)sInstanceModuleMap.get(paramString1);
      if (localObject2 != null) {
        break label160;
      }
      localObject2 = new ConcurrentHashMap();
      sInstanceModuleMap.put(paramString1, localObject2);
    }
    label160:
    for (;;)
    {
      BaseModule localBaseModule = (BaseModule)((Map)localObject2).get(paramString2);
      localObject1 = localBaseModule;
      if (localBaseModule == null) {
        localObject1 = localBaseModule;
      }
      try
      {
        if ((paramIModuleHolder instanceof ModuleSimpleHolder)) {
          localObject1 = paramIModuleHolder.buildInstance();
        }
        ((BaseModule)localObject1).setModuleName(paramString2);
        ((Map)localObject2).put(paramString2, localObject1);
        sInstanceModuleMap.put(paramString1, localObject2);
        return localObject1;
      }
      catch (Exception paramString1)
      {
        ViolaLogUtils.e("ViolaModuleManager", paramString2 + " module build instace failed." + paramString1);
        return null;
      }
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
  
  static boolean registerJSModule(String paramString, IModuleHolder paramIModuleHolder)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramString, paramIModuleHolder.getMethods());
    ViolaSDKManager.getInstance().registerModules(localHashMap);
    return true;
  }
  
  public static boolean registerModule(String paramString, IModuleHolder paramIModuleHolder, boolean paramBoolean)
  {
    if ((paramString == null) || (paramIModuleHolder == null)) {
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
  
  static boolean registerNativeModule(String paramString, IModuleHolder paramIModuleHolder)
  {
    if (paramIModuleHolder == null) {
      return false;
    }
    try
    {
      sTypeModuleHolderMap.put(paramString, paramIModuleHolder);
      return true;
    }
    catch (ArrayStoreException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static boolean registerOnlyNativeModule(String paramString, IModuleHolder paramIModuleHolder)
  {
    if ((paramString == null) || (paramIModuleHolder == null)) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.module.ViolaModuleManager
 * JD-Core Version:    0.7.0.1
 */