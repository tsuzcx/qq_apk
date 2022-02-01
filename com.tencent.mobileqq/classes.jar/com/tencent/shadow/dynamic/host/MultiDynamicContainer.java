package com.tencent.shadow.dynamic.host;

import android.text.TextUtils;
import com.tencent.shadow.core.common.InstalledApk;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;

public class MultiDynamicContainer
{
  private static final Logger mLogger = LoggerFactory.getLogger(MultiDynamicContainer.class);
  
  private static MultiDynamicContainer.ContainerClassLoader findContainerClassLoader(String paramString)
  {
    for (ClassLoader localClassLoader = MultiDynamicContainer.class.getClassLoader().getParent(); localClassLoader != null; localClassLoader = localClassLoader.getParent()) {
      if ((localClassLoader instanceof MultiDynamicContainer.ContainerClassLoader))
      {
        MultiDynamicContainer.ContainerClassLoader localContainerClassLoader = (MultiDynamicContainer.ContainerClassLoader)localClassLoader;
        if (TextUtils.equals(MultiDynamicContainer.ContainerClassLoader.access$100(localContainerClassLoader), paramString)) {
          return localContainerClassLoader;
        }
      }
    }
    return null;
  }
  
  private static void hackContainerClassLoader(String paramString, InstalledApk paramInstalledApk)
  {
    ClassLoader localClassLoader = MultiDynamicContainer.class.getClassLoader();
    DynamicRuntime.hackParentClassLoader(localClassLoader, new MultiDynamicContainer.ContainerClassLoader(paramString, paramInstalledApk, localClassLoader.getParent()));
  }
  
  /* Error */
  public static boolean loadContainerApk(String paramString, InstalledApk paramInstalledApk)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 62	com/tencent/shadow/dynamic/host/MultiDynamicContainer:findContainerClassLoader	(Ljava/lang/String;)Lcom/tencent/shadow/dynamic/host/MultiDynamicContainer$ContainerClassLoader;
    //   4: astore_2
    //   5: aload_2
    //   6: ifnull +126 -> 132
    //   9: aload_2
    //   10: invokestatic 65	com/tencent/shadow/dynamic/host/MultiDynamicContainer$ContainerClassLoader:access$000	(Lcom/tencent/shadow/dynamic/host/MultiDynamicContainer$ContainerClassLoader;)Ljava/lang/String;
    //   13: astore_3
    //   14: getstatic 16	com/tencent/shadow/dynamic/host/MultiDynamicContainer:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   17: invokeinterface 71 1 0
    //   22: ifeq +51 -> 73
    //   25: getstatic 16	com/tencent/shadow/dynamic/host/MultiDynamicContainer:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   28: new 73	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   35: ldc 76
    //   37: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_0
    //   41: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 82
    //   46: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_3
    //   50: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: ldc 84
    //   55: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_1
    //   59: getfield 90	com/tencent/shadow/core/common/InstalledApk:apkFilePath	Ljava/lang/String;
    //   62: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokeinterface 98 2 0
    //   73: aload_3
    //   74: aload_1
    //   75: getfield 90	com/tencent/shadow/core/common/InstalledApk:apkFilePath	Ljava/lang/String;
    //   78: invokestatic 45	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   81: ifeq +26 -> 107
    //   84: getstatic 16	com/tencent/shadow/dynamic/host/MultiDynamicContainer:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   87: invokeinterface 71 1 0
    //   92: ifeq +13 -> 105
    //   95: getstatic 16	com/tencent/shadow/dynamic/host/MultiDynamicContainer:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   98: ldc 100
    //   100: invokeinterface 98 2 0
    //   105: iconst_0
    //   106: ireturn
    //   107: getstatic 16	com/tencent/shadow/dynamic/host/MultiDynamicContainer:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   110: invokeinterface 71 1 0
    //   115: ifeq +13 -> 128
    //   118: getstatic 16	com/tencent/shadow/dynamic/host/MultiDynamicContainer:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   121: ldc 102
    //   123: invokeinterface 98 2 0
    //   128: aload_2
    //   129: invokestatic 106	com/tencent/shadow/dynamic/host/MultiDynamicContainer:removeContainerClassLoader	(Lcom/tencent/shadow/dynamic/host/MultiDynamicContainer$ContainerClassLoader;)V
    //   132: aload_0
    //   133: aload_1
    //   134: invokestatic 108	com/tencent/shadow/dynamic/host/MultiDynamicContainer:hackContainerClassLoader	(Ljava/lang/String;Lcom/tencent/shadow/core/common/InstalledApk;)V
    //   137: getstatic 16	com/tencent/shadow/dynamic/host/MultiDynamicContainer:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   140: invokeinterface 71 1 0
    //   145: ifeq +42 -> 187
    //   148: getstatic 16	com/tencent/shadow/dynamic/host/MultiDynamicContainer:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   151: new 73	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   158: ldc 110
    //   160: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_0
    //   164: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc 112
    //   169: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_1
    //   173: getfield 90	com/tencent/shadow/core/common/InstalledApk:apkFilePath	Ljava/lang/String;
    //   176: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokeinterface 98 2 0
    //   187: iconst_1
    //   188: ireturn
    //   189: astore_0
    //   190: getstatic 16	com/tencent/shadow/dynamic/host/MultiDynamicContainer:mLogger	Lcom/tencent/shadow/core/common/Logger;
    //   193: ldc 114
    //   195: aload_0
    //   196: invokeinterface 118 3 0
    //   201: new 120	java/lang/RuntimeException
    //   204: dup
    //   205: aload_0
    //   206: invokespecial 123	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   209: athrow
    //   210: astore_0
    //   211: new 120	java/lang/RuntimeException
    //   214: dup
    //   215: aload_0
    //   216: invokespecial 123	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   219: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	220	0	paramString	String
    //   0	220	1	paramInstalledApk	InstalledApk
    //   4	125	2	localContainerClassLoader	MultiDynamicContainer.ContainerClassLoader
    //   13	61	3	str	String
    // Exception table:
    //   from	to	target	type
    //   128	132	189	java/lang/Exception
    //   132	187	210	java/lang/Exception
  }
  
  private static void removeContainerClassLoader(MultiDynamicContainer.ContainerClassLoader paramContainerClassLoader)
  {
    Object localObject2 = MultiDynamicContainer.class.getClassLoader();
    ClassLoader localClassLoader;
    for (Object localObject1 = ((ClassLoader)localObject2).getParent();; localObject1 = localClassLoader)
    {
      if ((localObject1 == null) || (localObject1 == paramContainerClassLoader))
      {
        if ((localObject2 != null) && (localObject1 == paramContainerClassLoader)) {
          DynamicRuntime.hackParentClassLoader((ClassLoader)localObject2, paramContainerClassLoader.getParent());
        }
        return;
      }
      localClassLoader = ((ClassLoader)localObject1).getParent();
      localObject2 = localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.MultiDynamicContainer
 * JD-Core Version:    0.7.0.1
 */