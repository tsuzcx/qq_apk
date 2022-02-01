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
    //   2: invokestatic 24	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   5: astore_2
    //   6: new 26	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 27	java/lang/StringBuilder:<init>	()V
    //   13: astore_3
    //   14: aload_3
    //   15: ldc 29
    //   17: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: pop
    //   21: aload_3
    //   22: aload_0
    //   23: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: new 35	java/io/BufferedReader
    //   30: dup
    //   31: new 37	java/io/InputStreamReader
    //   34: dup
    //   35: aload_2
    //   36: aload_3
    //   37: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: invokevirtual 45	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   43: invokevirtual 51	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   46: invokespecial 54	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   49: sipush 1024
    //   52: invokespecial 57	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   55: astore_0
    //   56: aload_0
    //   57: invokevirtual 60	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   60: astore_1
    //   61: aload_0
    //   62: invokevirtual 63	java/io/BufferedReader:close	()V
    //   65: aload_0
    //   66: invokevirtual 63	java/io/BufferedReader:close	()V
    //   69: aload_1
    //   70: areturn
    //   71: astore_2
    //   72: aload_0
    //   73: astore_1
    //   74: aload_2
    //   75: astore_0
    //   76: goto +7 -> 83
    //   79: goto +16 -> 95
    //   82: astore_0
    //   83: aload_1
    //   84: ifnull +7 -> 91
    //   87: aload_1
    //   88: invokevirtual 63	java/io/BufferedReader:close	()V
    //   91: aload_0
    //   92: athrow
    //   93: aconst_null
    //   94: astore_0
    //   95: aload_0
    //   96: ifnull +7 -> 103
    //   99: aload_0
    //   100: invokevirtual 63	java/io/BufferedReader:close	()V
    //   103: aconst_null
    //   104: areturn
    //   105: astore_0
    //   106: goto -13 -> 93
    //   109: astore_1
    //   110: goto -31 -> 79
    //   113: astore_0
    //   114: aload_1
    //   115: areturn
    //   116: astore_1
    //   117: goto -26 -> 91
    //   120: astore_0
    //   121: aconst_null
    //   122: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramString	String
    //   1	87	1	str	String
    //   109	6	1	localIOException1	java.io.IOException
    //   116	1	1	localIOException2	java.io.IOException
    //   5	31	2	localRuntime	java.lang.Runtime
    //   71	4	2	localObject	Object
    //   13	24	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   56	65	71	finally
    //   2	56	82	finally
    //   2	56	105	java/io/IOException
    //   56	65	109	java/io/IOException
    //   65	69	113	java/io/IOException
    //   87	91	116	java/io/IOException
    //   99	103	120	java/io/IOException
  }
  
  public static String getSystemUI()
  {
    if (sSystemUI == null) {
      try
      {
        if (sSystemUI == null) {
          sSystemUI = getSystemUIVersion();
        }
      }
      finally {}
    }
    return sSystemUI;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.utils.SystemUtils
 * JD-Core Version:    0.7.0.1
 */