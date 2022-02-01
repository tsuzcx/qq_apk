package com.tencent.qqlive.module.videoreport.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class BaseUtils
{
  public static <T> boolean contains(Collection<T> paramCollection, T paramT)
  {
    if ((!isEmpty(paramCollection)) && (paramT != null)) {
      return paramCollection.contains(paramT);
    }
    return false;
  }
  
  @NonNull
  public static <K, V> Map<K, V> copyNonNull(@Nullable Map<K, V> paramMap)
  {
    return copyTo(paramMap, new ArrayMap());
  }
  
  @NonNull
  public static <K, V> Map<K, V> copyTo(@Nullable Map<K, V> paramMap1, @NonNull Map<K, V> paramMap2)
  {
    if (paramMap1 != null) {
      paramMap2.putAll(paramMap1);
    }
    return paramMap2;
  }
  
  public static String getClassSimpleName(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    return paramObject.getClass().getSimpleName();
  }
  
  public static String getErrorStack(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.close();
    return localStringWriter.toString();
  }
  
  public static <K, V> V getOrDefault(Map<K, V> paramMap, K paramK, V paramV)
  {
    if (paramMap == null) {
      return paramV;
    }
    paramK = paramMap.get(paramK);
    paramMap = paramK;
    if (paramK == null) {
      paramMap = paramV;
    }
    return paramMap;
  }
  
  public static boolean isEmpty(Collection paramCollection)
  {
    return (paramCollection == null) || (paramCollection.isEmpty());
  }
  
  public static boolean isEmpty(Map<?, ?> paramMap)
  {
    return (paramMap == null) || (paramMap.isEmpty());
  }
  
  public static <T> Set<T> newWeakHashSet()
  {
    return Collections.newSetFromMap(new WeakHashMap());
  }
  
  public static <T> T nullAs(T paramT1, T paramT2)
  {
    T ? = paramT1;
    if (paramT1 == null) {
      ? = paramT2;
    }
    return ?;
  }
  
  /* Error */
  public static String readFileFromAssets(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 117	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 118	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore_3
    //   14: aload_0
    //   15: invokevirtual 124	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   18: aload_1
    //   19: invokevirtual 130	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   22: astore_0
    //   23: aload_0
    //   24: astore_3
    //   25: aload_0
    //   26: astore 4
    //   28: sipush 1024
    //   31: newarray byte
    //   33: astore_1
    //   34: aload_0
    //   35: astore_3
    //   36: aload_0
    //   37: astore 4
    //   39: aload_0
    //   40: aload_1
    //   41: invokevirtual 136	java/io/InputStream:read	([B)I
    //   44: istore_2
    //   45: iload_2
    //   46: iconst_m1
    //   47: if_icmpeq +19 -> 66
    //   50: aload_0
    //   51: astore_3
    //   52: aload_0
    //   53: astore 4
    //   55: aload 5
    //   57: aload_1
    //   58: iconst_0
    //   59: iload_2
    //   60: invokevirtual 140	java/io/ByteArrayOutputStream:write	([BII)V
    //   63: goto -29 -> 34
    //   66: aload_0
    //   67: astore_3
    //   68: aload_0
    //   69: astore 4
    //   71: aload 5
    //   73: invokevirtual 141	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   76: astore_1
    //   77: aload_0
    //   78: astore_3
    //   79: aload_0
    //   80: astore 4
    //   82: ldc 143
    //   84: aload_1
    //   85: invokestatic 149	com/tencent/qqlive/module/videoreport/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload 5
    //   90: invokevirtual 150	java/io/ByteArrayOutputStream:close	()V
    //   93: aload_0
    //   94: ifnull +14 -> 108
    //   97: aload_0
    //   98: invokevirtual 151	java/io/InputStream:close	()V
    //   101: aload_1
    //   102: areturn
    //   103: astore_0
    //   104: aload_0
    //   105: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   108: aload_1
    //   109: areturn
    //   110: astore_0
    //   111: goto +42 -> 153
    //   114: astore_0
    //   115: aload 4
    //   117: astore_3
    //   118: ldc 143
    //   120: aload_0
    //   121: invokevirtual 156	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   124: invokestatic 159	com/tencent/qqlive/module/videoreport/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload 5
    //   129: invokevirtual 150	java/io/ByteArrayOutputStream:close	()V
    //   132: aload 4
    //   134: ifnull +16 -> 150
    //   137: aload 4
    //   139: invokevirtual 151	java/io/InputStream:close	()V
    //   142: goto +8 -> 150
    //   145: astore_0
    //   146: aload_0
    //   147: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   150: ldc 61
    //   152: areturn
    //   153: aload 5
    //   155: invokevirtual 150	java/io/ByteArrayOutputStream:close	()V
    //   158: aload_3
    //   159: ifnull +15 -> 174
    //   162: aload_3
    //   163: invokevirtual 151	java/io/InputStream:close	()V
    //   166: goto +8 -> 174
    //   169: astore_1
    //   170: aload_1
    //   171: invokevirtual 153	java/io/IOException:printStackTrace	()V
    //   174: goto +5 -> 179
    //   177: aload_0
    //   178: athrow
    //   179: goto -2 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramContext	android.content.Context
    //   0	182	1	paramString	String
    //   44	16	2	i	int
    //   13	150	3	localContext1	android.content.Context
    //   10	128	4	localContext2	android.content.Context
    //   7	147	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   88	93	103	java/io/IOException
    //   97	101	103	java/io/IOException
    //   14	23	110	finally
    //   28	34	110	finally
    //   39	45	110	finally
    //   55	63	110	finally
    //   71	77	110	finally
    //   82	88	110	finally
    //   118	127	110	finally
    //   14	23	114	java/lang/Exception
    //   28	34	114	java/lang/Exception
    //   39	45	114	java/lang/Exception
    //   55	63	114	java/lang/Exception
    //   71	77	114	java/lang/Exception
    //   82	88	114	java/lang/Exception
    //   127	132	145	java/io/IOException
    //   137	142	145	java/io/IOException
    //   153	158	169	java/io/IOException
    //   162	166	169	java/io/IOException
  }
  
  public static <T> int size(Collection<T> paramCollection)
  {
    if (paramCollection == null) {
      return 0;
    }
    return paramCollection.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.BaseUtils
 * JD-Core Version:    0.7.0.1
 */