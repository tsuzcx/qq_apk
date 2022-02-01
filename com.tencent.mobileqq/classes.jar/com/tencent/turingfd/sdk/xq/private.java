package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

public final class private
{
  public static String pg;
  
  public static int J()
  {
    try
    {
      int i = Integer.parseInt(Build.VERSION.SDK);
      return i;
    }
    catch (Throwable localThrowable)
    {
      label9:
      break label9;
    }
    return 0;
  }
  
  /* Error */
  public static String b(boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 26
    //   2: astore_2
    //   3: new 28	java/io/FileInputStream
    //   6: dup
    //   7: ldc 30
    //   9: invokespecial 34	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   12: astore_3
    //   13: new 36	java/io/BufferedReader
    //   16: dup
    //   17: new 38	java/io/InputStreamReader
    //   20: dup
    //   21: aload_3
    //   22: invokespecial 41	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   25: sipush 8192
    //   28: invokespecial 44	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   31: astore 4
    //   33: new 46	java/lang/StringBuilder
    //   36: dup
    //   37: ldc 26
    //   39: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: astore_1
    //   43: aload 4
    //   45: invokevirtual 51	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore 5
    //   50: aload 5
    //   52: ifnull +13 -> 65
    //   55: aload_1
    //   56: aload 5
    //   58: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: goto -19 -> 43
    //   65: aload 4
    //   67: invokevirtual 59	java/io/BufferedReader:close	()V
    //   70: aload_3
    //   71: invokevirtual 60	java/io/FileInputStream:close	()V
    //   74: goto +32 -> 106
    //   77: goto +29 -> 106
    //   80: astore_2
    //   81: aload 4
    //   83: invokevirtual 59	java/io/BufferedReader:close	()V
    //   86: aload_3
    //   87: invokevirtual 60	java/io/FileInputStream:close	()V
    //   90: aload_1
    //   91: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: pop
    //   95: aload_2
    //   96: athrow
    //   97: aload 4
    //   99: invokevirtual 59	java/io/BufferedReader:close	()V
    //   102: aload_3
    //   103: invokevirtual 60	java/io/FileInputStream:close	()V
    //   106: aload_1
    //   107: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: astore_3
    //   111: iload_0
    //   112: ifne +5 -> 117
    //   115: aload_3
    //   116: areturn
    //   117: aload_2
    //   118: astore_1
    //   119: aload_3
    //   120: ifnull +40 -> 160
    //   123: aload_2
    //   124: astore_1
    //   125: aload_3
    //   126: ldc 26
    //   128: invokevirtual 69	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   131: ifne +29 -> 160
    //   134: aload_3
    //   135: aload_3
    //   136: ldc 71
    //   138: invokevirtual 74	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   141: bipush 8
    //   143: iadd
    //   144: invokevirtual 78	java/lang/String:substring	(I)Ljava/lang/String;
    //   147: astore_1
    //   148: aload_1
    //   149: iconst_0
    //   150: aload_1
    //   151: ldc 80
    //   153: invokevirtual 74	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   156: invokevirtual 83	java/lang/String:substring	(II)Ljava/lang/String;
    //   159: astore_1
    //   160: aload_1
    //   161: areturn
    //   162: astore_1
    //   163: ldc 26
    //   165: areturn
    //   166: astore 5
    //   168: goto -71 -> 97
    //   171: astore 4
    //   173: goto -103 -> 70
    //   176: astore_3
    //   177: goto -100 -> 77
    //   180: astore 4
    //   182: goto -96 -> 86
    //   185: astore_3
    //   186: goto -96 -> 90
    //   189: astore 4
    //   191: goto -89 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramBoolean	boolean
    //   42	119	1	localObject1	Object
    //   162	1	1	localThrowable1	Throwable
    //   2	1	2	str1	String
    //   80	44	2	localObject2	Object
    //   12	124	3	localObject3	Object
    //   176	1	3	localThrowable2	Throwable
    //   185	1	3	localThrowable3	Throwable
    //   31	67	4	localBufferedReader	java.io.BufferedReader
    //   171	1	4	localThrowable4	Throwable
    //   180	1	4	localThrowable5	Throwable
    //   189	1	4	localThrowable6	Throwable
    //   48	9	5	str2	String
    //   166	1	5	localThrowable7	Throwable
    // Exception table:
    //   from	to	target	type
    //   43	50	80	finally
    //   55	62	80	finally
    //   3	13	162	java/lang/Throwable
    //   134	148	162	java/lang/Throwable
    //   148	160	162	java/lang/Throwable
    //   43	50	166	java/lang/Throwable
    //   55	62	166	java/lang/Throwable
    //   65	70	171	java/lang/Throwable
    //   70	74	176	java/lang/Throwable
    //   102	106	176	java/lang/Throwable
    //   81	86	180	java/lang/Throwable
    //   86	90	185	java/lang/Throwable
    //   97	102	189	java/lang/Throwable
  }
  
  public static String h(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    return str;
  }
  
  public static String x(Context paramContext)
  {
    String str = pg;
    if (str != null) {
      return str;
    }
    try
    {
      str = ((TelephonyManager)paramContext.getSystemService("phone")).getDeviceId();
      paramContext = str;
      if (str == null) {
        paramContext = "";
      }
      pg = paramContext;
    }
    catch (Throwable paramContext)
    {
      label36:
      break label36;
    }
    return pg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.private
 * JD-Core Version:    0.7.0.1
 */