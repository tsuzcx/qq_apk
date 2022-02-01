package com.tencent.viola.ui.baseComponent;

import android.text.TextUtils;
import com.tencent.viola.bridge.ViolaBridgeManager;
import com.tencent.viola.core.ViolaSDKManager;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ComponentRegistry
{
  public static String TAG = "ComponentRegistry";
  private static ArrayList<Map<String, Object>> sComponentInfos = new ArrayList();
  private static Map<String, IFComponentHolder> sTypeComponentMap = new ConcurrentHashMap();
  
  public static IFComponentHolder getComponent(String paramString)
  {
    return (IFComponentHolder)sTypeComponentMap.get(paramString);
  }
  
  public static boolean registerComponent(String paramString, IFComponentHolder paramIFComponentHolder, Map<String, Object> paramMap)
  {
    if (paramIFComponentHolder != null) {
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          ViolaBridgeManager.getInstance().post(new ComponentRegistry.1(paramMap, paramString, paramIFComponentHolder));
          return true;
        }
      }
      finally {}
    }
    return false;
  }
  
  private static boolean registerJSComponent(Map<String, Object> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMap);
    ViolaSDKManager.getInstance().registerComponents(localArrayList);
    return true;
  }
  
  private static boolean registerNativeComponent(String paramString, IFComponentHolder paramIFComponentHolder)
  {
    try
    {
      sTypeComponentMap.put(paramString, paramIFComponentHolder);
    }
    catch (ArrayStoreException paramString)
    {
      paramString.printStackTrace();
    }
    return true;
  }
  
  public static boolean registerOnlyNativeComponent(String paramString, IFComponentHolder paramIFComponentHolder)
  {
    if ((paramIFComponentHolder != null) && (!TextUtils.isEmpty(paramString)))
    {
      ViolaBridgeManager.getInstance().post(new ComponentRegistry.3(paramString, paramIFComponentHolder));
      return true;
    }
    return false;
  }
  
  public static void reload()
  {
    ViolaBridgeManager.getInstance().post(new ComponentRegistry.2());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.baseComponent.ComponentRegistry
 * JD-Core Version:    0.7.0.1
 */