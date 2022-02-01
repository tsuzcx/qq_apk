package com.tencent.theme.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

public final class PropertyUtils
{
  private static Class<?> sClassSystemProperties;
  private static Method sMethodGetString;
  
  static
  {
    try
    {
      sClassSystemProperties = Class.forName("android.os.SystemProperties");
      sMethodGetString = sClassSystemProperties.getDeclaredMethod("get", new Class[] { String.class, String.class });
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static String get(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    String str = getWithReflect(paramString1, null);
    if (TextUtils.isEmpty(str)) {
      paramString1 = getWithCmd(paramString1, null);
    } else {
      paramString1 = str;
    }
    str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = paramString2;
    }
    return str;
  }
  
  public static String getQuickly(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    return getWithReflect(paramString1, paramString2);
  }
  
  /* Error */
  private static String getWithCmd(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore_3
    //   2: invokestatic 62	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   5: astore 4
    //   7: aload_1
    //   8: astore_3
    //   9: new 64	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   16: astore 5
    //   18: aload_1
    //   19: astore_3
    //   20: aload 5
    //   22: ldc 67
    //   24: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_1
    //   29: astore_3
    //   30: aload 5
    //   32: aload_0
    //   33: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_1
    //   38: astore_3
    //   39: aload 4
    //   41: aload 5
    //   43: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokevirtual 79	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   49: astore 5
    //   51: new 81	java/io/BufferedReader
    //   54: dup
    //   55: new 83	java/io/InputStreamReader
    //   58: dup
    //   59: aload 5
    //   61: invokevirtual 89	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   64: invokespecial 92	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   67: invokespecial 95	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   70: astore_0
    //   71: new 64	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   78: astore_3
    //   79: aload_0
    //   80: invokevirtual 98	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   83: astore 4
    //   85: aload 4
    //   87: ifnull +13 -> 100
    //   90: aload_3
    //   91: aload 4
    //   93: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: goto -18 -> 79
    //   100: aload_3
    //   101: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: astore_3
    //   105: aload_3
    //   106: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: istore_2
    //   110: aload_0
    //   111: astore 4
    //   113: iload_2
    //   114: ifne +8 -> 122
    //   117: aload_3
    //   118: astore_1
    //   119: aload_0
    //   120: astore 4
    //   122: aload_1
    //   123: astore_3
    //   124: aload 4
    //   126: invokevirtual 101	java/io/BufferedReader:close	()V
    //   129: aload_1
    //   130: astore_0
    //   131: goto +18 -> 149
    //   134: aload_0
    //   135: ifnull +9 -> 144
    //   138: aload_1
    //   139: astore_3
    //   140: aload_0
    //   141: invokevirtual 101	java/io/BufferedReader:close	()V
    //   144: aload_1
    //   145: astore_3
    //   146: aload 4
    //   148: athrow
    //   149: aload_0
    //   150: astore_3
    //   151: aload 5
    //   153: invokevirtual 104	java/lang/Process:destroy	()V
    //   156: aload_0
    //   157: areturn
    //   158: astore_0
    //   159: aload_0
    //   160: invokevirtual 36	java/lang/Exception:printStackTrace	()V
    //   163: aload_3
    //   164: areturn
    //   165: astore_0
    //   166: goto +24 -> 190
    //   169: astore_3
    //   170: goto +8 -> 178
    //   173: astore 4
    //   175: goto -41 -> 134
    //   178: aload_0
    //   179: astore_3
    //   180: goto +12 -> 192
    //   183: astore 4
    //   185: aconst_null
    //   186: astore_0
    //   187: goto -53 -> 134
    //   190: aconst_null
    //   191: astore_3
    //   192: aload_1
    //   193: astore_0
    //   194: aload_3
    //   195: ifnull -46 -> 149
    //   198: aload_3
    //   199: astore 4
    //   201: goto -79 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	paramString1	String
    //   0	204	1	paramString2	String
    //   109	5	2	bool	boolean
    //   1	163	3	localObject1	Object
    //   169	1	3	localIOException	java.io.IOException
    //   179	20	3	str1	String
    //   5	142	4	localObject2	Object
    //   173	1	4	localObject3	Object
    //   183	1	4	localObject4	Object
    //   199	1	4	str2	String
    //   16	136	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	158	java/lang/Exception
    //   9	18	158	java/lang/Exception
    //   20	28	158	java/lang/Exception
    //   30	37	158	java/lang/Exception
    //   39	51	158	java/lang/Exception
    //   124	129	158	java/lang/Exception
    //   140	144	158	java/lang/Exception
    //   146	149	158	java/lang/Exception
    //   151	156	158	java/lang/Exception
    //   51	71	165	java/io/IOException
    //   71	79	169	java/io/IOException
    //   79	85	169	java/io/IOException
    //   90	97	169	java/io/IOException
    //   100	110	169	java/io/IOException
    //   71	79	173	finally
    //   79	85	173	finally
    //   90	97	173	finally
    //   100	110	173	finally
    //   51	71	183	finally
  }
  
  private static String getWithReflect(String paramString1, String paramString2)
  {
    Class localClass = sClassSystemProperties;
    if (localClass != null)
    {
      Method localMethod = sMethodGetString;
      if (localMethod != null) {
        try
        {
          paramString1 = (String)localMethod.invoke(localClass, new Object[] { paramString1, paramString2 });
          return paramString1;
        }
        catch (Exception paramString1)
        {
          paramString1.printStackTrace();
          return paramString2;
        }
      }
    }
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.theme.utils.PropertyUtils
 * JD-Core Version:    0.7.0.1
 */