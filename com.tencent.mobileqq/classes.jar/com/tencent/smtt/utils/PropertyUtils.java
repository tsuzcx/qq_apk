package com.tencent.smtt.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

public class PropertyUtils
{
  private static final String CMD_GET_PROP = "getprop";
  public static final String PROPERTY_DNS_PRIMARY = "net.dns1";
  public static final String PROPERTY_DNS_SECNDARY = "net.dns2";
  private static Class sClassSystemProperties;
  private static Method sMethodGetString;
  
  static
  {
    try
    {
      sClassSystemProperties = Class.forName("android.os.SystemProperties");
      sMethodGetString = sClassSystemProperties.getDeclaredMethod("get", new Class[] { String.class, String.class });
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
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
    //   2: invokestatic 71	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   5: new 73	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   12: ldc 76
    //   14: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokevirtual 88	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   27: astore 5
    //   29: aconst_null
    //   30: astore 4
    //   32: new 90	java/io/BufferedReader
    //   35: dup
    //   36: new 92	java/io/InputStreamReader
    //   39: dup
    //   40: aload 5
    //   42: invokevirtual 98	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   45: invokespecial 101	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   48: invokespecial 104	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   51: astore_0
    //   52: new 73	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   59: astore_3
    //   60: aload_0
    //   61: invokevirtual 107	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   64: astore 4
    //   66: aload 4
    //   68: ifnull +33 -> 101
    //   71: aload_3
    //   72: aload 4
    //   74: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: goto -18 -> 60
    //   81: astore_3
    //   82: aload_0
    //   83: ifnull +9 -> 92
    //   86: aload_1
    //   87: astore_3
    //   88: aload_0
    //   89: invokevirtual 110	java/io/BufferedReader:close	()V
    //   92: aload_1
    //   93: astore_0
    //   94: aload 5
    //   96: invokevirtual 113	java/lang/Process:destroy	()V
    //   99: aload_0
    //   100: areturn
    //   101: aload_3
    //   102: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: astore_3
    //   106: aload_3
    //   107: invokestatic 56	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: istore_2
    //   111: iload_2
    //   112: ifne +5 -> 117
    //   115: aload_3
    //   116: astore_1
    //   117: aload_0
    //   118: ifnull +62 -> 180
    //   121: aload_1
    //   122: astore_3
    //   123: aload_0
    //   124: invokevirtual 110	java/io/BufferedReader:close	()V
    //   127: goto +53 -> 180
    //   130: aload 4
    //   132: ifnull +10 -> 142
    //   135: aload_1
    //   136: astore_3
    //   137: aload 4
    //   139: invokevirtual 110	java/io/BufferedReader:close	()V
    //   142: aload_1
    //   143: astore_3
    //   144: aload_0
    //   145: athrow
    //   146: astore_0
    //   147: aload_0
    //   148: astore_1
    //   149: aload_3
    //   150: astore_0
    //   151: aload_1
    //   152: invokevirtual 45	java/lang/Throwable:printStackTrace	()V
    //   155: aload_0
    //   156: areturn
    //   157: astore_1
    //   158: goto -7 -> 151
    //   161: astore 4
    //   163: aload_0
    //   164: astore_3
    //   165: aload 4
    //   167: astore_0
    //   168: aload_3
    //   169: astore 4
    //   171: goto -41 -> 130
    //   174: astore_0
    //   175: aconst_null
    //   176: astore_0
    //   177: goto -95 -> 82
    //   180: aload_1
    //   181: astore_0
    //   182: goto -88 -> 94
    //   185: astore_0
    //   186: goto -56 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	paramString1	String
    //   0	189	1	paramString2	String
    //   110	2	2	bool	boolean
    //   1	71	3	localObject1	Object
    //   81	1	3	localIOException	java.io.IOException
    //   87	82	3	str1	String
    //   30	108	4	str2	String
    //   161	5	4	localObject2	Object
    //   169	1	4	str3	String
    //   27	68	5	localProcess	java.lang.Process
    // Exception table:
    //   from	to	target	type
    //   52	60	81	java/io/IOException
    //   60	66	81	java/io/IOException
    //   71	78	81	java/io/IOException
    //   101	111	81	java/io/IOException
    //   2	29	146	java/lang/Throwable
    //   88	92	146	java/lang/Throwable
    //   123	127	146	java/lang/Throwable
    //   137	142	146	java/lang/Throwable
    //   144	146	146	java/lang/Throwable
    //   94	99	157	java/lang/Throwable
    //   52	60	161	finally
    //   60	66	161	finally
    //   71	78	161	finally
    //   101	111	161	finally
    //   32	52	174	java/io/IOException
    //   32	52	185	finally
  }
  
  private static String getWithReflect(String paramString1, String paramString2)
  {
    if ((sClassSystemProperties == null) || (sMethodGetString == null)) {
      return paramString2;
    }
    try
    {
      paramString1 = (String)sMethodGetString.invoke(sClassSystemProperties, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
    }
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.smtt.utils.PropertyUtils
 * JD-Core Version:    0.7.0.1
 */