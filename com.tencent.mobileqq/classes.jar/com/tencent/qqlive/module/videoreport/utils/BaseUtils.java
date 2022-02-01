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
  private static final String TAG = "BaseUtils";
  
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
  
  public static String emptyAs(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (isEmpty(paramString1)) {
      str = paramString2;
    }
    return str;
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
  
  public static boolean isEmpty(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (paramCharSequence.length() == 0);
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
    //   0: new 132	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 133	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore_3
    //   14: aload_0
    //   15: invokevirtual 139	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   18: aload_1
    //   19: invokevirtual 145	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
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
    //   41: invokevirtual 151	java/io/InputStream:read	([B)I
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
    //   60: invokevirtual 155	java/io/ByteArrayOutputStream:write	([BII)V
    //   63: goto -29 -> 34
    //   66: aload_0
    //   67: astore_3
    //   68: aload_0
    //   69: astore 4
    //   71: aload 5
    //   73: invokevirtual 156	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   76: astore_1
    //   77: aload_0
    //   78: astore_3
    //   79: aload_0
    //   80: astore 4
    //   82: ldc 158
    //   84: aload_1
    //   85: invokestatic 164	com/tencent/qqlive/module/videoreport/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload 5
    //   90: invokevirtual 165	java/io/ByteArrayOutputStream:close	()V
    //   93: aload_0
    //   94: ifnull +40 -> 134
    //   97: aload_0
    //   98: invokevirtual 166	java/io/InputStream:close	()V
    //   101: aload_1
    //   102: areturn
    //   103: astore_0
    //   104: new 168	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   111: astore_3
    //   112: aload_3
    //   113: ldc 171
    //   115: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_3
    //   120: aload_0
    //   121: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: ldc 8
    //   127: aload_3
    //   128: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 182	com/tencent/qqlive/module/videoreport/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: aload_1
    //   135: areturn
    //   136: astore_0
    //   137: goto +68 -> 205
    //   140: astore_0
    //   141: aload 4
    //   143: astore_3
    //   144: ldc 158
    //   146: aload_0
    //   147: invokevirtual 185	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   150: invokestatic 182	com/tencent/qqlive/module/videoreport/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload 5
    //   155: invokevirtual 165	java/io/ByteArrayOutputStream:close	()V
    //   158: aload 4
    //   160: ifnull +42 -> 202
    //   163: aload 4
    //   165: invokevirtual 166	java/io/InputStream:close	()V
    //   168: goto +34 -> 202
    //   171: astore_0
    //   172: new 168	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   179: astore_1
    //   180: aload_1
    //   181: ldc 171
    //   183: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload_1
    //   188: aload_0
    //   189: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: ldc 8
    //   195: aload_1
    //   196: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 182	com/tencent/qqlive/module/videoreport/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   202: ldc 70
    //   204: areturn
    //   205: aload 5
    //   207: invokevirtual 165	java/io/ByteArrayOutputStream:close	()V
    //   210: aload_3
    //   211: ifnull +41 -> 252
    //   214: aload_3
    //   215: invokevirtual 166	java/io/InputStream:close	()V
    //   218: goto +34 -> 252
    //   221: astore_1
    //   222: new 168	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 169	java/lang/StringBuilder:<init>	()V
    //   229: astore_3
    //   230: aload_3
    //   231: ldc 171
    //   233: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload_3
    //   238: aload_1
    //   239: invokevirtual 178	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: ldc 8
    //   245: aload_3
    //   246: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 182	com/tencent/qqlive/module/videoreport/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: goto +5 -> 257
    //   255: aload_0
    //   256: athrow
    //   257: goto -2 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	260	0	paramContext	android.content.Context
    //   0	260	1	paramString	String
    //   44	16	2	i	int
    //   13	233	3	localObject	Object
    //   10	154	4	localContext	android.content.Context
    //   7	199	5	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   88	93	103	java/io/IOException
    //   97	101	103	java/io/IOException
    //   14	23	136	finally
    //   28	34	136	finally
    //   39	45	136	finally
    //   55	63	136	finally
    //   71	77	136	finally
    //   82	88	136	finally
    //   144	153	136	finally
    //   14	23	140	java/lang/Exception
    //   28	34	140	java/lang/Exception
    //   39	45	140	java/lang/Exception
    //   55	63	140	java/lang/Exception
    //   71	77	140	java/lang/Exception
    //   82	88	140	java/lang/Exception
    //   153	158	171	java/io/IOException
    //   163	168	171	java/io/IOException
    //   205	210	221	java/io/IOException
    //   214	218	221	java/io/IOException
  }
  
  public static <T> int size(Collection<T> paramCollection)
  {
    if (paramCollection == null) {
      return 0;
    }
    return paramCollection.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.BaseUtils
 * JD-Core Version:    0.7.0.1
 */