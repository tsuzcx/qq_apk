package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.mobileqq.qmethodmonitor.monitor.PhoneInfoMonitor;

public final class implements
{
  public static String a;
  
  public static int a()
  {
    try
    {
      int i = Integer.parseInt(Build.VERSION.SDK);
      return i;
    }
    finally
    {
      label9:
      break label9;
    }
    return 0;
  }
  
  public static String a(Context paramContext)
  {
    String str = a;
    if (str != null) {
      return str;
    }
    try
    {
      str = PhoneInfoMonitor.getDeviceId((TelephonyManager)paramContext.getSystemService("phone"));
      paramContext = str;
      if (str == null) {
        paramContext = "";
      }
      a = paramContext;
    }
    finally
    {
      label36:
      break label36;
    }
    return a;
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return str;
  }
  
  /* Error */
  public static String a(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 40
    //   2: astore_2
    //   3: new 50	java/io/FileInputStream
    //   6: dup
    //   7: ldc 52
    //   9: invokespecial 56	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: astore_3
    //   13: new 58	java/io/BufferedReader
    //   16: dup
    //   17: new 60	java/io/InputStreamReader
    //   20: dup
    //   21: aload_3
    //   22: invokespecial 63	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   25: sipush 8192
    //   28: invokespecial 66	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   31: astore 4
    //   33: new 68	java/lang/StringBuilder
    //   36: dup
    //   37: ldc 40
    //   39: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: astore_1
    //   43: aload 4
    //   45: invokevirtual 73	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore 5
    //   50: aload 5
    //   52: ifnull +13 -> 65
    //   55: aload_1
    //   56: aload 5
    //   58: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: goto -19 -> 43
    //   65: aload 4
    //   67: invokevirtual 81	java/io/BufferedReader:close	()V
    //   70: aload_3
    //   71: invokevirtual 84	java/io/InputStream:close	()V
    //   74: goto +15 -> 89
    //   77: goto +12 -> 89
    //   80: aload 4
    //   82: invokevirtual 81	java/io/BufferedReader:close	()V
    //   85: aload_3
    //   86: invokevirtual 84	java/io/InputStream:close	()V
    //   89: aload_1
    //   90: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore_3
    //   94: iload_0
    //   95: ifne +5 -> 100
    //   98: aload_3
    //   99: areturn
    //   100: aload_2
    //   101: astore_1
    //   102: aload_3
    //   103: ifnull +40 -> 143
    //   106: aload_2
    //   107: astore_1
    //   108: aload_3
    //   109: ldc 40
    //   111: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   114: ifne +29 -> 143
    //   117: aload_3
    //   118: aload_3
    //   119: ldc 95
    //   121: invokevirtual 98	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   124: bipush 8
    //   126: iadd
    //   127: invokevirtual 102	java/lang/String:substring	(I)Ljava/lang/String;
    //   130: astore_1
    //   131: aload_1
    //   132: iconst_0
    //   133: aload_1
    //   134: ldc 104
    //   136: invokevirtual 98	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   139: invokevirtual 107	java/lang/String:substring	(II)Ljava/lang/String;
    //   142: astore_1
    //   143: aload_1
    //   144: areturn
    //   145: astore_1
    //   146: ldc 40
    //   148: areturn
    //   149: astore 5
    //   151: goto -71 -> 80
    //   154: astore 4
    //   156: goto -86 -> 70
    //   159: astore_3
    //   160: goto -83 -> 77
    //   163: astore 4
    //   165: goto -80 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramBoolean	boolean
    //   42	102	1	localObject1	Object
    //   145	1	1	localObject2	Object
    //   2	105	2	str1	String
    //   12	107	3	localObject3	Object
    //   159	1	3	localObject4	Object
    //   31	50	4	localBufferedReader	java.io.BufferedReader
    //   154	1	4	localObject5	Object
    //   163	1	4	localObject6	Object
    //   48	9	5	str2	String
    //   149	1	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	145	finally
    //   117	143	145	finally
    //   43	50	149	finally
    //   55	62	149	finally
    //   65	70	154	finally
    //   70	74	159	finally
    //   85	89	159	finally
    //   80	85	163	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.implements
 * JD-Core Version:    0.7.0.1
 */