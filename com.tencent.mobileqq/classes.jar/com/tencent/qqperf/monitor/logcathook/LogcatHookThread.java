package com.tencent.qqperf.monitor.logcathook;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.HandlerThread;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.BufferedWriter;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import mqq.app.MobileQQ;

public class LogcatHookThread
{
  static LogcatHookThread.WriteHandler jdField_a_of_type_ComTencentQqperfMonitorLogcathookLogcatHookThread$WriteHandler;
  private static BufferedWriter jdField_a_of_type_JavaIoBufferedWriter;
  static String jdField_a_of_type_JavaLangString = "";
  static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yy.MM.dd.HH");
  private static boolean jdField_a_of_type_Boolean;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  private static String jdField_b_of_type_JavaLangString;
  static SimpleDateFormat jdField_b_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
  private static String c;
  private static String d;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE" };
    jdField_b_of_type_JavaLangString = "";
    c = "com.tencent.mobileqq";
    jdField_a_of_type_JavaIoBufferedWriter = null;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(BaseApplication.context));
    localStringBuilder.append(File.separator);
    localStringBuilder.append("tencent");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("msflogs");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(c.replace(".", File.separator));
    localStringBuilder.append(File.separator);
    d = localStringBuilder.toString();
  }
  
  public static String a()
  {
    long l = System.currentTimeMillis();
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTimeInMillis(l);
    localObject1 = jdField_a_of_type_JavaTextSimpleDateFormat.format(((Calendar)localObject1).getTime());
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(d);
    ((StringBuilder)localObject2).append(a((String)localObject1));
    localObject1 = ((StringBuilder)localObject2).toString();
    try
    {
      localObject2 = new File(d);
      if (!((File)localObject2).exists()) {
        ((File)localObject2).mkdirs();
      }
      localObject2 = new File((String)localObject1);
      if (!((File)localObject2).exists())
      {
        ((File)localObject2).createNewFile();
        return localObject1;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return localObject1;
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return Environment.getExternalStorageDirectory().getPath();
    }
    File localFile = paramContext.getExternalFilesDir(null);
    if ((localFile != null) && (!a(paramContext))) {
      return localFile.getPath();
    }
    return Environment.getExternalStorageDirectory().getPath();
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaLangString.replace(":", "_"));
    localStringBuilder.append("_syslog_.");
    localStringBuilder.append(paramString);
    localStringBuilder.append(".log");
    return localStringBuilder.toString();
  }
  
  /* Error */
  static void a(long paramLong)
  {
    // Byte code:
    //   0: getstatic 32	com/tencent/qqperf/monitor/logcathook/LogcatHookThread:jdField_b_of_type_JavaTextSimpleDateFormat	Ljava/text/SimpleDateFormat;
    //   3: lload_0
    //   4: invokestatic 163	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7: invokevirtual 166	java/text/SimpleDateFormat:format	(Ljava/lang/Object;)Ljava/lang/String;
    //   10: astore_2
    //   11: invokestatic 102	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   14: astore_3
    //   15: aload_3
    //   16: lload_0
    //   17: invokevirtual 106	java/util/Calendar:setTimeInMillis	(J)V
    //   20: getstatic 28	com/tencent/qqperf/monitor/logcathook/LogcatHookThread:jdField_a_of_type_JavaTextSimpleDateFormat	Ljava/text/SimpleDateFormat;
    //   23: aload_3
    //   24: invokevirtual 110	java/util/Calendar:getTime	()Ljava/util/Date;
    //   27: invokevirtual 114	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   30: astore_3
    //   31: new 50	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   38: astore 4
    //   40: aload 4
    //   42: getstatic 86	com/tencent/qqperf/monitor/logcathook/LogcatHookThread:d	Ljava/lang/String;
    //   45: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 4
    //   51: aload_3
    //   52: invokestatic 117	com/tencent/qqperf/monitor/logcathook/LogcatHookThread:a	(Ljava/lang/String;)Ljava/lang/String;
    //   55: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 4
    //   61: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: astore_3
    //   65: new 67	java/io/File
    //   68: dup
    //   69: getstatic 86	com/tencent/qqperf/monitor/logcathook/LogcatHookThread:d	Ljava/lang/String;
    //   72: invokespecial 118	java/io/File:<init>	(Ljava/lang/String;)V
    //   75: astore 4
    //   77: aload 4
    //   79: invokevirtual 122	java/io/File:exists	()Z
    //   82: ifne +9 -> 91
    //   85: aload 4
    //   87: invokevirtual 125	java/io/File:mkdirs	()Z
    //   90: pop
    //   91: new 67	java/io/File
    //   94: dup
    //   95: aload_3
    //   96: invokespecial 118	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: astore 4
    //   101: aload 4
    //   103: invokevirtual 122	java/io/File:exists	()Z
    //   106: ifne +9 -> 115
    //   109: aload 4
    //   111: invokevirtual 128	java/io/File:createNewFile	()Z
    //   114: pop
    //   115: new 168	java/io/BufferedWriter
    //   118: dup
    //   119: new 170	java/io/OutputStreamWriter
    //   122: dup
    //   123: new 172	java/io/FileOutputStream
    //   126: dup
    //   127: aload 4
    //   129: iconst_1
    //   130: invokespecial 175	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   133: invokespecial 178	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;)V
    //   136: invokespecial 181	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   139: putstatic 48	com/tencent/qqperf/monitor/logcathook/LogcatHookThread:jdField_a_of_type_JavaIoBufferedWriter	Ljava/io/BufferedWriter;
    //   142: getstatic 48	com/tencent/qqperf/monitor/logcathook/LogcatHookThread:jdField_a_of_type_JavaIoBufferedWriter	Ljava/io/BufferedWriter;
    //   145: ifnull +207 -> 352
    //   148: getstatic 48	com/tencent/qqperf/monitor/logcathook/LogcatHookThread:jdField_a_of_type_JavaIoBufferedWriter	Ljava/io/BufferedWriter;
    //   151: astore 5
    //   153: new 50	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   160: astore 6
    //   162: aload 6
    //   164: aload_2
    //   165: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 6
    //   171: ldc 183
    //   173: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 6
    //   179: getstatic 42	com/tencent/qqperf/monitor/logcathook/LogcatHookThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   182: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 6
    //   188: ldc 185
    //   190: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: aload 6
    //   196: getstatic 187	com/tencent/qqperf/monitor/logcathook/LogcatHookThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   199: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 6
    //   205: ldc 189
    //   207: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 5
    //   213: aload 6
    //   215: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokevirtual 192	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   221: getstatic 48	com/tencent/qqperf/monitor/logcathook/LogcatHookThread:jdField_a_of_type_JavaIoBufferedWriter	Ljava/io/BufferedWriter;
    //   224: astore 5
    //   226: new 50	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   233: astore 6
    //   235: aload 6
    //   237: aload_2
    //   238: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload 6
    //   244: ldc 183
    //   246: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 6
    //   252: getstatic 42	com/tencent/qqperf/monitor/logcathook/LogcatHookThread:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   255: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload 6
    //   261: ldc 194
    //   263: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload 6
    //   269: ldc 196
    //   271: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload 6
    //   277: ldc 183
    //   279: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload 6
    //   285: getstatic 201	android/os/Build:MODEL	Ljava/lang/String;
    //   288: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload 6
    //   294: ldc 203
    //   296: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 6
    //   302: getstatic 208	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   305: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload 6
    //   311: ldc 210
    //   313: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload 6
    //   319: aload 4
    //   321: invokevirtual 213	java/io/File:getName	()Ljava/lang/String;
    //   324: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload 6
    //   330: ldc 215
    //   332: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 5
    //   338: aload 6
    //   340: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokevirtual 192	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   346: getstatic 48	com/tencent/qqperf/monitor/logcathook/LogcatHookThread:jdField_a_of_type_JavaIoBufferedWriter	Ljava/io/BufferedWriter;
    //   349: invokevirtual 218	java/io/BufferedWriter:flush	()V
    //   352: getstatic 48	com/tencent/qqperf/monitor/logcathook/LogcatHookThread:jdField_a_of_type_JavaIoBufferedWriter	Ljava/io/BufferedWriter;
    //   355: astore_2
    //   356: aload_2
    //   357: ifnull +31 -> 388
    //   360: goto +20 -> 380
    //   363: astore_2
    //   364: goto +38 -> 402
    //   367: astore_2
    //   368: aload_2
    //   369: invokevirtual 131	java/lang/Throwable:printStackTrace	()V
    //   372: getstatic 48	com/tencent/qqperf/monitor/logcathook/LogcatHookThread:jdField_a_of_type_JavaIoBufferedWriter	Ljava/io/BufferedWriter;
    //   375: astore_2
    //   376: aload_2
    //   377: ifnull +11 -> 388
    //   380: aload_2
    //   381: invokevirtual 221	java/io/BufferedWriter:close	()V
    //   384: aconst_null
    //   385: putstatic 48	com/tencent/qqperf/monitor/logcathook/LogcatHookThread:jdField_a_of_type_JavaIoBufferedWriter	Ljava/io/BufferedWriter;
    //   388: getstatic 227	com/tencent/qqperf/monitor/logcathook/LogcatHook:sLogcatHooked	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   391: invokevirtual 232	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   394: ifeq +7 -> 401
    //   397: aload_3
    //   398: invokestatic 235	com/tencent/qqperf/monitor/logcathook/LogcatHook:updateLogPath	(Ljava/lang/String;)V
    //   401: return
    //   402: getstatic 48	com/tencent/qqperf/monitor/logcathook/LogcatHookThread:jdField_a_of_type_JavaIoBufferedWriter	Ljava/io/BufferedWriter;
    //   405: astore_3
    //   406: aload_3
    //   407: ifnull +11 -> 418
    //   410: aload_3
    //   411: invokevirtual 221	java/io/BufferedWriter:close	()V
    //   414: aconst_null
    //   415: putstatic 48	com/tencent/qqperf/monitor/logcathook/LogcatHookThread:jdField_a_of_type_JavaIoBufferedWriter	Ljava/io/BufferedWriter;
    //   418: aload_2
    //   419: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	420	0	paramLong	long
    //   10	347	2	localObject1	Object
    //   363	1	2	localObject2	Object
    //   367	2	2	localThrowable	Throwable
    //   375	44	2	localBufferedWriter1	BufferedWriter
    //   14	397	3	localObject3	Object
    //   38	282	4	localObject4	Object
    //   151	186	5	localBufferedWriter2	BufferedWriter
    //   160	179	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   65	91	363	finally
    //   91	115	363	finally
    //   115	352	363	finally
    //   368	372	363	finally
    //   65	91	367	java/lang/Throwable
    //   91	115	367	java/lang/Throwable
    //   115	352	367	java/lang/Throwable
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    if (jdField_a_of_type_ComTencentQqperfMonitorLogcathookLogcatHookThread$WriteHandler == null)
    {
      jdField_b_of_type_JavaLangString = paramString2;
      c = paramString1;
      jdField_a_of_type_JavaLangString = paramString3;
      paramString1 = new HandlerThread("sysLogWriteThread");
      paramString1.start();
      jdField_a_of_type_ComTencentQqperfMonitorLogcathookLogcatHookThread$WriteHandler = new LogcatHookThread.WriteHandler(paramString1.getLooper());
      jdField_a_of_type_ComTencentQqperfMonitorLogcathookLogcatHookThread$WriteHandler.sendEmptyMessageDelayed(1, paramLong);
      if (MobileQQ.sProcessId == 1) {
        jdField_a_of_type_ComTencentQqperfMonitorLogcathookLogcatHookThread$WriteHandler.sendEmptyMessageDelayed(2, paramLong);
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = jdField_a_of_type_Boolean;
    boolean bool1 = bool2;
    if (!bool2) {
      if (Build.VERSION.SDK_INT >= 23)
      {
        bool1 = bool2;
        if (paramContext != null)
        {
          bool1 = bool2;
          if (paramContext.checkSelfPermission(jdField_a_of_type_ArrayOfJavaLangString[0]) == 0)
          {
            jdField_a_of_type_Boolean = true;
            return jdField_a_of_type_Boolean;
          }
        }
      }
      else
      {
        jdField_a_of_type_Boolean = true;
        bool1 = jdField_a_of_type_Boolean;
      }
    }
    return bool1;
  }
  
  static void b(long paramLong)
  {
    Object localObject1 = new File(d);
    ArrayList localArrayList = new ArrayList();
    boolean bool = ((File)localObject1).exists();
    long l2 = 0L;
    long l1 = l2;
    if (bool)
    {
      l1 = l2;
      if (((File)localObject1).isDirectory())
      {
        localObject1 = ((File)localObject1).listFiles();
        int j = localObject1.length;
        l1 = 0L;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          l2 = l1;
          if (localObject2.exists())
          {
            l2 = l1;
            if (localObject2.isFile())
            {
              l2 = l1;
              if (localObject2.getName().contains("syslog")) {
                if (paramLong - localObject2.lastModified() > 86400000L)
                {
                  localObject2.delete();
                  l2 = l1;
                }
                else
                {
                  localArrayList.add(new LogcatHookThread.SysLogFile(localObject2.lastModified(), localObject2.length(), localObject2.getPath()));
                  l2 = l1 + localObject2.length();
                }
              }
            }
          }
          i += 1;
          l1 = l2;
        }
      }
    }
    if (l1 > 104857600L)
    {
      Collections.sort(localArrayList);
      while (l1 > 104857600L)
      {
        localObject1 = new File(((LogcatHookThread.SysLogFile)localArrayList.remove(0)).a());
        paramLong = l1 - ((File)localObject1).length();
        l1 = paramLong;
        if (((File)localObject1).exists())
        {
          ((File)localObject1).delete();
          l1 = paramLong;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.logcathook.LogcatHookThread
 * JD-Core Version:    0.7.0.1
 */