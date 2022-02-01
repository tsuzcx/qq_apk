package com.tencent.qqlive.module.videoreport.utils;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SystemUtils
{
  private static volatile String sSystemUI;
  
  /* Error */
  private static String getSystemProperty(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 20	java/io/BufferedReader
    //   5: dup
    //   6: new 22	java/io/InputStreamReader
    //   9: dup
    //   10: invokestatic 28	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   13: new 30	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   20: ldc 33
    //   22: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokevirtual 45	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   35: invokevirtual 51	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   38: invokespecial 54	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   41: sipush 1024
    //   44: invokespecial 57	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   47: astore_0
    //   48: aload_0
    //   49: invokevirtual 60	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore_1
    //   53: aload_0
    //   54: invokevirtual 63	java/io/BufferedReader:close	()V
    //   57: aload_0
    //   58: ifnull +7 -> 65
    //   61: aload_0
    //   62: invokevirtual 63	java/io/BufferedReader:close	()V
    //   65: aload_1
    //   66: areturn
    //   67: astore_0
    //   68: aconst_null
    //   69: astore_0
    //   70: aload_0
    //   71: ifnull +7 -> 78
    //   74: aload_0
    //   75: invokevirtual 63	java/io/BufferedReader:close	()V
    //   78: aconst_null
    //   79: areturn
    //   80: astore_0
    //   81: aload_1
    //   82: ifnull +7 -> 89
    //   85: aload_1
    //   86: invokevirtual 63	java/io/BufferedReader:close	()V
    //   89: aload_0
    //   90: athrow
    //   91: astore_0
    //   92: aload_1
    //   93: areturn
    //   94: astore_0
    //   95: goto -17 -> 78
    //   98: astore_1
    //   99: goto -10 -> 89
    //   102: astore_2
    //   103: aload_0
    //   104: astore_1
    //   105: aload_2
    //   106: astore_0
    //   107: goto -26 -> 81
    //   110: astore_1
    //   111: goto -41 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramString	String
    //   1	92	1	str1	String
    //   98	1	1	localIOException1	java.io.IOException
    //   104	1	1	str2	String
    //   110	1	1	localIOException2	java.io.IOException
    //   102	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	48	67	java/io/IOException
    //   2	48	80	finally
    //   61	65	91	java/io/IOException
    //   74	78	94	java/io/IOException
    //   85	89	98	java/io/IOException
    //   48	57	102	finally
    //   48	57	110	java/io/IOException
  }
  
  public static String getSystemUI()
  {
    if (sSystemUI == null) {}
    try
    {
      if (sSystemUI == null) {
        sSystemUI = getSystemUIVersion();
      }
      return sSystemUI;
    }
    finally {}
  }
  
  private static String getSystemUIVersion()
  {
    Object localObject = new ArrayList();
    ((List)localObject).add(new SystemUtils.MIUIVersionGetter());
    ((List)localObject).add(new SystemUtils.EMUIVersionGetter());
    ((List)localObject).add(new SystemUtils.DefaultVersionGetter());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = ((SystemUtils.IUIVersionGetter)((Iterator)localObject).next()).getUIVersion();
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.SystemUtils
 * JD-Core Version:    0.7.0.1
 */