package com.tencent.mobileqq.log;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public abstract class ReportLogHelper
{
  static String a = "";
  static String b = "";
  static String c = "";
  
  public static String a(Context paramContext, String paramString)
  {
    if (("mounted".equals(Environment.getExternalStorageState())) && (Environment.getExternalStorageDirectory().canWrite()))
    {
      paramContext = new File(Environment.getExternalStorageDirectory().getPath() + paramString);
      if (!paramContext.exists()) {
        paramContext.mkdirs();
      }
      return paramContext.getAbsolutePath();
    }
    return paramContext.getFilesDir().getAbsolutePath();
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 43	java/io/File
    //   6: dup
    //   7: getstatic 85	com/tencent/mobileqq/app/AppConstants:aO	Ljava/lang/String;
    //   10: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 66	java/io/File:exists	()Z
    //   18: ifne +8 -> 26
    //   21: aload_3
    //   22: invokevirtual 69	java/io/File:mkdirs	()Z
    //   25: pop
    //   26: new 87	java/io/FileWriter
    //   29: dup
    //   30: new 43	java/io/File
    //   33: dup
    //   34: new 49	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   41: getstatic 85	com/tencent/mobileqq/app/AppConstants:aO	Ljava/lang/String;
    //   44: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: ldc 89
    //   49: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: iconst_1
    //   59: invokespecial 92	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   62: astore_3
    //   63: aload_3
    //   64: new 49	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   71: ldc 94
    //   73: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: getstatic 14	com/tencent/mobileqq/log/ReportLogHelper:a	Ljava/lang/String;
    //   79: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 96
    //   84: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: getstatic 16	com/tencent/mobileqq/log/ReportLogHelper:b	Ljava/lang/String;
    //   90: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: ldc 98
    //   95: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: getstatic 18	com/tencent/mobileqq/log/ReportLogHelper:c	Ljava/lang/String;
    //   101: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: ldc 100
    //   106: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: ldc 102
    //   111: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokevirtual 105	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   120: aload_3
    //   121: ldc 107
    //   123: invokevirtual 105	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   126: new 109	android/text/format/Time
    //   129: dup
    //   130: invokespecial 110	android/text/format/Time:<init>	()V
    //   133: astore 4
    //   135: aload 4
    //   137: invokevirtual 113	android/text/format/Time:setToNow	()V
    //   140: aload_3
    //   141: new 49	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   148: aload 4
    //   150: ldc 115
    //   152: invokevirtual 119	android/text/format/Time:format	(Ljava/lang/String;)Ljava/lang/String;
    //   155: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc 121
    //   160: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokevirtual 105	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   169: aload_3
    //   170: ldc 123
    //   172: invokevirtual 105	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   175: aload_3
    //   176: ldc 107
    //   178: invokevirtual 105	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   181: aload_0
    //   182: ifnull +31 -> 213
    //   185: aload_3
    //   186: new 49	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   193: ldc 125
    //   195: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_0
    //   199: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: ldc 127
    //   204: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokevirtual 105	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   213: aload_3
    //   214: aload_1
    //   215: invokevirtual 105	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   218: aload_3
    //   219: ldc 107
    //   221: invokevirtual 105	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   224: aload_3
    //   225: invokevirtual 130	java/io/FileWriter:close	()V
    //   228: iconst_0
    //   229: ifeq +11 -> 240
    //   232: new 132	java/lang/NullPointerException
    //   235: dup
    //   236: invokespecial 133	java/lang/NullPointerException:<init>	()V
    //   239: athrow
    //   240: return
    //   241: astore_1
    //   242: aload 4
    //   244: astore_0
    //   245: aload_1
    //   246: invokevirtual 136	java/lang/Exception:printStackTrace	()V
    //   249: aload_0
    //   250: ifnull -10 -> 240
    //   253: aload_0
    //   254: invokevirtual 130	java/io/FileWriter:close	()V
    //   257: return
    //   258: astore_0
    //   259: return
    //   260: astore_0
    //   261: aconst_null
    //   262: astore_1
    //   263: aload_1
    //   264: ifnull +7 -> 271
    //   267: aload_1
    //   268: invokevirtual 130	java/io/FileWriter:close	()V
    //   271: aload_0
    //   272: athrow
    //   273: astore_0
    //   274: return
    //   275: astore_1
    //   276: goto -5 -> 271
    //   279: astore_0
    //   280: aload_3
    //   281: astore_1
    //   282: goto -19 -> 263
    //   285: astore_3
    //   286: aload_0
    //   287: astore_1
    //   288: aload_3
    //   289: astore_0
    //   290: goto -27 -> 263
    //   293: astore_1
    //   294: aload_3
    //   295: astore_0
    //   296: goto -51 -> 245
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	299	0	paramString1	String
    //   0	299	1	paramString2	String
    //   0	299	2	paramBoolean	boolean
    //   13	268	3	localObject1	Object
    //   285	10	3	localObject2	Object
    //   1	242	4	localTime	android.text.format.Time
    // Exception table:
    //   from	to	target	type
    //   3	26	241	java/lang/Exception
    //   26	63	241	java/lang/Exception
    //   253	257	258	java/lang/Exception
    //   3	26	260	finally
    //   26	63	260	finally
    //   232	240	273	java/lang/Exception
    //   267	271	275	java/lang/Exception
    //   63	181	279	finally
    //   185	213	279	finally
    //   213	228	279	finally
    //   245	249	285	finally
    //   63	181	293	java/lang/Exception
    //   185	213	293	java/lang/Exception
    //   213	228	293	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.log.ReportLogHelper
 * JD-Core Version:    0.7.0.1
 */