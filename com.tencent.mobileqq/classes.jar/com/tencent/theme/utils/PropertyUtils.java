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
    if (TextUtils.isEmpty(paramString1)) {}
    String str1;
    do
    {
      return paramString2;
      String str2 = getWithReflect(paramString1, null);
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = getWithCmd(paramString1, null);
      }
    } while (TextUtils.isEmpty(str1));
    return str1;
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
    //   5: new 64	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   12: ldc 67
    //   14: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokevirtual 79	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   27: astore 5
    //   29: aconst_null
    //   30: astore_3
    //   31: new 81	java/io/BufferedReader
    //   34: dup
    //   35: new 83	java/io/InputStreamReader
    //   38: dup
    //   39: aload 5
    //   41: invokevirtual 89	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   44: invokespecial 92	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   47: invokespecial 95	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   50: astore 4
    //   52: new 64	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   59: astore_0
    //   60: aload 4
    //   62: invokevirtual 98	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   65: astore_3
    //   66: aload_3
    //   67: ifnull +36 -> 103
    //   70: aload_0
    //   71: aload_3
    //   72: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: goto -16 -> 60
    //   79: astore_0
    //   80: aload_1
    //   81: astore_0
    //   82: aload 4
    //   84: ifnull +96 -> 180
    //   87: aload_1
    //   88: astore_3
    //   89: aload 4
    //   91: invokevirtual 101	java/io/BufferedReader:close	()V
    //   94: aload_1
    //   95: astore_0
    //   96: aload 5
    //   98: invokevirtual 104	java/lang/Process:destroy	()V
    //   101: aload_0
    //   102: areturn
    //   103: aload_0
    //   104: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: astore_0
    //   108: aload_0
    //   109: invokestatic 47	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   112: istore_2
    //   113: iload_2
    //   114: ifne +5 -> 119
    //   117: aload_0
    //   118: astore_1
    //   119: aload_1
    //   120: astore_0
    //   121: aload 4
    //   123: ifnull +57 -> 180
    //   126: aload_1
    //   127: astore_3
    //   128: aload 4
    //   130: invokevirtual 101	java/io/BufferedReader:close	()V
    //   133: aload_1
    //   134: astore_0
    //   135: goto -39 -> 96
    //   138: aload 4
    //   140: ifnull +10 -> 150
    //   143: aload_1
    //   144: astore_3
    //   145: aload 4
    //   147: invokevirtual 101	java/io/BufferedReader:close	()V
    //   150: aload_1
    //   151: astore_3
    //   152: aload_0
    //   153: athrow
    //   154: astore_0
    //   155: aload_0
    //   156: astore_1
    //   157: aload_3
    //   158: astore_0
    //   159: aload_1
    //   160: invokevirtual 36	java/lang/Exception:printStackTrace	()V
    //   163: aload_0
    //   164: areturn
    //   165: astore_1
    //   166: goto -7 -> 159
    //   169: astore_0
    //   170: goto -32 -> 138
    //   173: astore_0
    //   174: aconst_null
    //   175: astore 4
    //   177: goto -97 -> 80
    //   180: goto -84 -> 96
    //   183: astore_0
    //   184: aload_3
    //   185: astore 4
    //   187: goto -49 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	paramString1	String
    //   0	190	1	paramString2	String
    //   112	2	2	bool	boolean
    //   1	184	3	str	String
    //   50	136	4	localObject	Object
    //   27	70	5	localProcess	java.lang.Process
    // Exception table:
    //   from	to	target	type
    //   52	60	79	java/io/IOException
    //   60	66	79	java/io/IOException
    //   70	76	79	java/io/IOException
    //   103	113	79	java/io/IOException
    //   2	29	154	java/lang/Exception
    //   89	94	154	java/lang/Exception
    //   128	133	154	java/lang/Exception
    //   145	150	154	java/lang/Exception
    //   152	154	154	java/lang/Exception
    //   96	101	165	java/lang/Exception
    //   52	60	169	finally
    //   60	66	169	finally
    //   70	76	169	finally
    //   103	113	169	finally
    //   31	52	173	java/io/IOException
    //   31	52	183	finally
  }
  
  private static String getWithReflect(String paramString1, String paramString2)
  {
    if ((sClassSystemProperties != null) && (sMethodGetString != null)) {
      try
      {
        paramString1 = (String)sMethodGetString.invoke(sClassSystemProperties, new Object[] { paramString1, paramString2 });
        return paramString1;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return paramString2;
      }
    }
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.theme.utils.PropertyUtils
 * JD-Core Version:    0.7.0.1
 */