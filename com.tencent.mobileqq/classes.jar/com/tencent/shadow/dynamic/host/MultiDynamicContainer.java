package com.tencent.shadow.dynamic.host;

import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;
import com.tencent.shadow.proguard.l;

public class MultiDynamicContainer
{
  private static final Logger a = LoggerFactory.getLogger(MultiDynamicContainer.class);
  
  private static void a(l paraml)
  {
    Object localObject2 = MultiDynamicContainer.class.getClassLoader();
    ClassLoader localClassLoader;
    for (Object localObject1 = ((ClassLoader)localObject2).getParent(); (localObject1 != null) && (localObject1 != paraml); localObject1 = localClassLoader)
    {
      localClassLoader = ((ClassLoader)localObject1).getParent();
      localObject2 = localObject1;
    }
    if ((localObject2 != null) && (localObject1 == paraml)) {
      DynamicRuntime.a((ClassLoader)localObject2, paraml.getParent());
    }
  }
  
  /* Error */
  public static boolean loadContainerApk(java.lang.String paramString, com.tencent.shadow.core.common.InstalledApk paramInstalledApk)
  {
    // Byte code:
    //   0: ldc 2
    //   2: invokevirtual 27	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   5: invokevirtual 32	java/lang/ClassLoader:getParent	()Ljava/lang/ClassLoader;
    //   8: astore_2
    //   9: aload_2
    //   10: ifnull +135 -> 145
    //   13: aload_2
    //   14: instanceof 34
    //   17: ifeq +120 -> 137
    //   20: aload_2
    //   21: checkcast 34	com/tencent/shadow/proguard/l
    //   24: astore_3
    //   25: aload_3
    //   26: invokestatic 48	com/tencent/shadow/proguard/l:b	(Lcom/tencent/shadow/proguard/l;)Ljava/lang/String;
    //   29: aload_0
    //   30: invokestatic 54	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   33: ifeq +104 -> 137
    //   36: aload_3
    //   37: astore_2
    //   38: aload_2
    //   39: ifnull +136 -> 175
    //   42: aload_2
    //   43: invokestatic 56	com/tencent/shadow/proguard/l:a	(Lcom/tencent/shadow/proguard/l;)Ljava/lang/String;
    //   46: astore_3
    //   47: getstatic 16	com/tencent/shadow/dynamic/host/MultiDynamicContainer:a	Lcom/tencent/shadow/core/common/Logger;
    //   50: invokeinterface 62 1 0
    //   55: ifeq +48 -> 103
    //   58: getstatic 16	com/tencent/shadow/dynamic/host/MultiDynamicContainer:a	Lcom/tencent/shadow/core/common/Logger;
    //   61: new 64	java/lang/StringBuilder
    //   64: dup
    //   65: ldc 66
    //   67: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   70: aload_0
    //   71: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc 75
    //   76: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_3
    //   80: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 77
    //   85: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: aload_1
    //   89: getfield 83	com/tencent/shadow/core/common/InstalledApk:apkFilePath	Ljava/lang/String;
    //   92: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokeinterface 90 2 0
    //   103: aload_3
    //   104: aload_1
    //   105: getfield 83	com/tencent/shadow/core/common/InstalledApk:apkFilePath	Ljava/lang/String;
    //   108: invokestatic 54	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   111: ifeq +39 -> 150
    //   114: getstatic 16	com/tencent/shadow/dynamic/host/MultiDynamicContainer:a	Lcom/tencent/shadow/core/common/Logger;
    //   117: invokeinterface 62 1 0
    //   122: ifeq +13 -> 135
    //   125: getstatic 16	com/tencent/shadow/dynamic/host/MultiDynamicContainer:a	Lcom/tencent/shadow/core/common/Logger;
    //   128: ldc 92
    //   130: invokeinterface 90 2 0
    //   135: iconst_0
    //   136: ireturn
    //   137: aload_2
    //   138: invokevirtual 32	java/lang/ClassLoader:getParent	()Ljava/lang/ClassLoader;
    //   141: astore_2
    //   142: goto -133 -> 9
    //   145: aconst_null
    //   146: astore_2
    //   147: goto -109 -> 38
    //   150: getstatic 16	com/tencent/shadow/dynamic/host/MultiDynamicContainer:a	Lcom/tencent/shadow/core/common/Logger;
    //   153: invokeinterface 62 1 0
    //   158: ifeq +13 -> 171
    //   161: getstatic 16	com/tencent/shadow/dynamic/host/MultiDynamicContainer:a	Lcom/tencent/shadow/core/common/Logger;
    //   164: ldc 94
    //   166: invokeinterface 90 2 0
    //   171: aload_2
    //   172: invokestatic 96	com/tencent/shadow/dynamic/host/MultiDynamicContainer:a	(Lcom/tencent/shadow/proguard/l;)V
    //   175: ldc 2
    //   177: invokevirtual 27	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   180: astore_2
    //   181: aload_2
    //   182: new 34	com/tencent/shadow/proguard/l
    //   185: dup
    //   186: aload_0
    //   187: aload_1
    //   188: aload_2
    //   189: invokevirtual 32	java/lang/ClassLoader:getParent	()Ljava/lang/ClassLoader;
    //   192: invokespecial 99	com/tencent/shadow/proguard/l:<init>	(Ljava/lang/String;Lcom/tencent/shadow/core/common/InstalledApk;Ljava/lang/ClassLoader;)V
    //   195: invokestatic 40	com/tencent/shadow/dynamic/host/DynamicRuntime:a	(Ljava/lang/ClassLoader;Ljava/lang/ClassLoader;)V
    //   198: getstatic 16	com/tencent/shadow/dynamic/host/MultiDynamicContainer:a	Lcom/tencent/shadow/core/common/Logger;
    //   201: invokeinterface 62 1 0
    //   206: ifeq +39 -> 245
    //   209: getstatic 16	com/tencent/shadow/dynamic/host/MultiDynamicContainer:a	Lcom/tencent/shadow/core/common/Logger;
    //   212: new 64	java/lang/StringBuilder
    //   215: dup
    //   216: ldc 101
    //   218: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   221: aload_0
    //   222: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: ldc 103
    //   227: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_1
    //   231: getfield 83	com/tencent/shadow/core/common/InstalledApk:apkFilePath	Ljava/lang/String;
    //   234: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokeinterface 90 2 0
    //   245: iconst_1
    //   246: ireturn
    //   247: astore_0
    //   248: getstatic 16	com/tencent/shadow/dynamic/host/MultiDynamicContainer:a	Lcom/tencent/shadow/core/common/Logger;
    //   251: ldc 105
    //   253: aload_0
    //   254: invokeinterface 109 3 0
    //   259: new 111	java/lang/RuntimeException
    //   262: dup
    //   263: aload_0
    //   264: invokespecial 114	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   267: athrow
    //   268: astore_0
    //   269: new 111	java/lang/RuntimeException
    //   272: dup
    //   273: aload_0
    //   274: invokespecial 114	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   277: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	paramString	java.lang.String
    //   0	278	1	paramInstalledApk	com.tencent.shadow.core.common.InstalledApk
    //   8	181	2	localObject1	Object
    //   24	80	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   171	175	247	java/lang/Exception
    //   175	245	268	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.MultiDynamicContainer
 * JD-Core Version:    0.7.0.1
 */