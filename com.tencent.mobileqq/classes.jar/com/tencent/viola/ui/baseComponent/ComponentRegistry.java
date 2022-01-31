package com.tencent.viola.ui.baseComponent;

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
  
  /* Error */
  public static boolean registerComponent(String paramString, IFComponentHolder paramIFComponentHolder, Map<String, Object> paramMap)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_1
    //   4: ifnull +12 -> 16
    //   7: aload_0
    //   8: invokestatic 62	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: istore_3
    //   12: iload_3
    //   13: ifeq +10 -> 23
    //   16: iconst_0
    //   17: istore_3
    //   18: ldc 2
    //   20: monitorexit
    //   21: iload_3
    //   22: ireturn
    //   23: invokestatic 68	com/tencent/viola/bridge/ViolaBridgeManager:getInstance	()Lcom/tencent/viola/bridge/ViolaBridgeManager;
    //   26: new 70	com/tencent/viola/ui/baseComponent/ComponentRegistry$1
    //   29: dup
    //   30: aload_2
    //   31: aload_0
    //   32: aload_1
    //   33: invokespecial 73	com/tencent/viola/ui/baseComponent/ComponentRegistry$1:<init>	(Ljava/util/Map;Ljava/lang/String;Lcom/tencent/viola/ui/baseComponent/IFComponentHolder;)V
    //   36: invokevirtual 77	com/tencent/viola/bridge/ViolaBridgeManager:post	(Ljava/lang/Runnable;)V
    //   39: iconst_1
    //   40: istore_3
    //   41: goto -23 -> 18
    //   44: astore_0
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_0
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	paramString	String
    //   0	50	1	paramIFComponentHolder	IFComponentHolder
    //   0	50	2	paramMap	Map<String, Object>
    //   11	30	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   7	12	44	finally
    //   23	39	44	finally
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
  
  public static void reload()
  {
    ViolaBridgeManager.getInstance().post(new ComponentRegistry.2());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.baseComponent.ComponentRegistry
 * JD-Core Version:    0.7.0.1
 */