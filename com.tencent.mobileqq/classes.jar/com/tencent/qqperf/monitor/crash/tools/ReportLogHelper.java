package com.tencent.qqperf.monitor.crash.tools;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public abstract class ReportLogHelper
{
  public static String a = "";
  public static String b = "";
  public static String c = "";
  
  public static String a(Context paramContext, String paramString)
  {
    if (("mounted".equals(Environment.getExternalStorageState())) && (Environment.getExternalStorageDirectory().canWrite()))
    {
      paramContext = new StringBuilder();
      paramContext.append(Environment.getExternalStorageDirectory().getPath());
      paramContext.append(paramString);
      paramContext = new File(paramContext.toString());
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
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload 4
    //   8: astore_3
    //   9: new 37	java/io/File
    //   12: dup
    //   13: getstatic 79	com/tencent/mobileqq/app/AppConstants:LOG_PATH_SDCARD	Ljava/lang/String;
    //   16: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore 6
    //   21: aload 4
    //   23: astore_3
    //   24: aload 6
    //   26: invokevirtual 60	java/io/File:exists	()Z
    //   29: ifne +12 -> 41
    //   32: aload 4
    //   34: astore_3
    //   35: aload 6
    //   37: invokevirtual 63	java/io/File:mkdirs	()Z
    //   40: pop
    //   41: aload 4
    //   43: astore_3
    //   44: new 43	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   51: astore 6
    //   53: aload 4
    //   55: astore_3
    //   56: aload 6
    //   58: getstatic 79	com/tencent/mobileqq/app/AppConstants:LOG_PATH_SDCARD	Ljava/lang/String;
    //   61: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 4
    //   67: astore_3
    //   68: aload 6
    //   70: ldc 81
    //   72: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload 4
    //   78: astore_3
    //   79: new 83	java/io/FileWriter
    //   82: dup
    //   83: new 37	java/io/File
    //   86: dup
    //   87: aload 6
    //   89: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokespecial 57	java/io/File:<init>	(Ljava/lang/String;)V
    //   95: iconst_1
    //   96: invokespecial 86	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   99: astore 4
    //   101: new 43	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   108: astore_3
    //   109: aload_3
    //   110: ldc 88
    //   112: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload_3
    //   117: getstatic 90	com/tencent/qqperf/monitor/crash/tools/ReportLogHelper:a	Ljava/lang/String;
    //   120: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_3
    //   125: ldc 92
    //   127: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload_3
    //   132: getstatic 94	com/tencent/qqperf/monitor/crash/tools/ReportLogHelper:b	Ljava/lang/String;
    //   135: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload_3
    //   140: ldc 96
    //   142: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_3
    //   147: getstatic 98	com/tencent/qqperf/monitor/crash/tools/ReportLogHelper:c	Ljava/lang/String;
    //   150: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload_3
    //   155: ldc 100
    //   157: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_3
    //   162: invokestatic 104	com/tencent/common/config/AppSetting:b	()Ljava/lang/String;
    //   165: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 4
    //   171: aload_3
    //   172: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokevirtual 107	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   178: aload 4
    //   180: ldc 109
    //   182: invokevirtual 107	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   185: new 111	android/text/format/Time
    //   188: dup
    //   189: invokespecial 112	android/text/format/Time:<init>	()V
    //   192: astore_3
    //   193: aload_3
    //   194: invokevirtual 115	android/text/format/Time:setToNow	()V
    //   197: new 43	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   204: astore 5
    //   206: aload 5
    //   208: aload_3
    //   209: ldc 117
    //   211: invokevirtual 121	android/text/format/Time:format	(Ljava/lang/String;)Ljava/lang/String;
    //   214: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 5
    //   220: ldc 123
    //   222: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 4
    //   228: aload 5
    //   230: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokevirtual 107	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   236: aload 4
    //   238: ldc 125
    //   240: invokevirtual 107	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   243: aload 4
    //   245: ldc 109
    //   247: invokevirtual 107	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   250: aload_0
    //   251: ifnull +40 -> 291
    //   254: new 43	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   261: astore_3
    //   262: aload_3
    //   263: ldc 127
    //   265: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_3
    //   270: aload_0
    //   271: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload_3
    //   276: ldc 129
    //   278: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 4
    //   284: aload_3
    //   285: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokevirtual 107	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   291: aload 4
    //   293: aload_1
    //   294: invokevirtual 107	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   297: aload 4
    //   299: ldc 109
    //   301: invokevirtual 107	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   304: aload 4
    //   306: invokevirtual 132	java/io/FileWriter:close	()V
    //   309: return
    //   310: astore_0
    //   311: goto +36 -> 347
    //   314: astore_1
    //   315: aload 4
    //   317: astore_0
    //   318: goto +14 -> 332
    //   321: astore_0
    //   322: aload_3
    //   323: astore 4
    //   325: goto +22 -> 347
    //   328: astore_1
    //   329: aload 5
    //   331: astore_0
    //   332: aload_0
    //   333: astore_3
    //   334: aload_1
    //   335: invokevirtual 135	java/lang/Exception:printStackTrace	()V
    //   338: aload_0
    //   339: ifnull +7 -> 346
    //   342: aload_0
    //   343: invokevirtual 132	java/io/FileWriter:close	()V
    //   346: return
    //   347: aload 4
    //   349: ifnull +8 -> 357
    //   352: aload 4
    //   354: invokevirtual 132	java/io/FileWriter:close	()V
    //   357: aload_0
    //   358: athrow
    //   359: astore_0
    //   360: return
    //   361: astore_1
    //   362: goto -5 -> 357
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	paramString1	String
    //   0	365	1	paramString2	String
    //   0	365	2	paramBoolean	boolean
    //   8	326	3	localObject1	Object
    //   4	349	4	localObject2	Object
    //   1	329	5	localStringBuilder	StringBuilder
    //   19	69	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   101	250	310	finally
    //   254	291	310	finally
    //   291	309	310	finally
    //   101	250	314	java/lang/Exception
    //   254	291	314	java/lang/Exception
    //   291	309	314	java/lang/Exception
    //   9	21	321	finally
    //   24	32	321	finally
    //   35	41	321	finally
    //   44	53	321	finally
    //   56	65	321	finally
    //   68	76	321	finally
    //   79	101	321	finally
    //   334	338	321	finally
    //   9	21	328	java/lang/Exception
    //   24	32	328	java/lang/Exception
    //   35	41	328	java/lang/Exception
    //   44	53	328	java/lang/Exception
    //   56	65	328	java/lang/Exception
    //   68	76	328	java/lang/Exception
    //   79	101	328	java/lang/Exception
    //   342	346	359	java/lang/Exception
    //   352	357	361	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.tools.ReportLogHelper
 * JD-Core Version:    0.7.0.1
 */