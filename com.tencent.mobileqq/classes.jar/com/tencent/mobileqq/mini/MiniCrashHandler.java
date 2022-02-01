package com.tencent.mobileqq.mini;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC05115;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.CrashHandler;
import mqq.app.MobileQQ;

public class MiniCrashHandler
  extends CrashHandler
{
  public static final String FOLDER = BaseApplicationImpl.getApplication().getFilesDir().getPath() + "/mini/";
  private static final String TAG = "MiniCrashHandler";
  public Thread.UncaughtExceptionHandler defaultHandler;
  private MiniAppConfig miniAppConfig;
  
  public MiniCrashHandler()
  {
    if (this.defaultHandler == null) {
      this.defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
    }
  }
  
  public static void cleanCrashInfo()
  {
    try
    {
      Object localObject = getCrashFilePath(BaseApplicationImpl.getApplication().getQQProcessName());
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      localObject = new File((String)localObject);
      if ((((File)localObject).exists()) && (((File)localObject).isFile())) {
        ((File)localObject).delete();
      }
      QLog.e("MiniCrashHandler", 1, "cleanCrashInfo");
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniCrashHandler", 1, "cleanCrashInfo exception!", localThrowable);
    }
  }
  
  public static String getCrashFilePath(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        if (paramString.contains(":"))
        {
          String str = paramString.substring(paramString.indexOf(":") + 1);
          str = FOLDER + str + "_crash";
          return str;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MiniCrashHandler", 1, "getFilePath exception! processName:" + paramString, localThrowable);
      }
    }
    return null;
  }
  
  public static long getLastCrashTime(String paramString)
  {
    try
    {
      paramString = getCrashFilePath(paramString);
      if (TextUtils.isEmpty(paramString)) {
        return -1L;
      }
      paramString = new File(paramString);
      if ((paramString.exists()) && (paramString.isFile()))
      {
        long l = paramString.lastModified();
        return l;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("MiniCrashHandler", 1, "get crash info exception!", paramString);
    }
    return -1L;
  }
  
  /* Error */
  public void saveCrashInfo()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: invokestatic 26	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   5: invokevirtual 63	com/tencent/common/app/BaseApplicationImpl:getQQProcessName	()Ljava/lang/String;
    //   8: invokestatic 67	com/tencent/mobileqq/mini/MiniCrashHandler:getCrashFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 4
    //   13: aload 4
    //   15: invokestatic 73	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: istore_1
    //   19: iload_1
    //   20: ifeq +27 -> 47
    //   23: iconst_0
    //   24: ifeq +11 -> 35
    //   27: new 130	java/lang/NullPointerException
    //   30: dup
    //   31: invokespecial 131	java/lang/NullPointerException:<init>	()V
    //   34: athrow
    //   35: return
    //   36: astore_2
    //   37: ldc 9
    //   39: iconst_1
    //   40: ldc 133
    //   42: aload_2
    //   43: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   46: return
    //   47: new 32	java/io/File
    //   50: dup
    //   51: aload 4
    //   53: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: astore_3
    //   57: new 32	java/io/File
    //   60: dup
    //   61: getstatic 47	com/tencent/mobileqq/mini/MiniCrashHandler:FOLDER	Ljava/lang/String;
    //   64: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   67: astore 5
    //   69: aload 5
    //   71: invokevirtual 80	java/io/File:exists	()Z
    //   74: ifeq +11 -> 85
    //   77: aload 5
    //   79: invokevirtual 136	java/io/File:isDirectory	()Z
    //   82: ifne +9 -> 91
    //   85: aload 5
    //   87: invokevirtual 139	java/io/File:mkdirs	()Z
    //   90: pop
    //   91: aload_3
    //   92: invokevirtual 80	java/io/File:exists	()Z
    //   95: ifeq +10 -> 105
    //   98: aload_3
    //   99: invokevirtual 83	java/io/File:isFile	()Z
    //   102: ifne +8 -> 110
    //   105: aload_3
    //   106: invokevirtual 142	java/io/File:createNewFile	()Z
    //   109: pop
    //   110: new 144	java/io/FileOutputStream
    //   113: dup
    //   114: aload_3
    //   115: iconst_0
    //   116: invokespecial 147	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   119: astore_3
    //   120: aload_3
    //   121: new 17	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   128: ldc 149
    //   130: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokestatic 154	java/lang/System:currentTimeMillis	()J
    //   136: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   139: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokevirtual 161	java/lang/String:getBytes	()[B
    //   145: invokevirtual 165	java/io/FileOutputStream:write	([B)V
    //   148: aload_3
    //   149: invokevirtual 168	java/io/FileOutputStream:flush	()V
    //   152: ldc 9
    //   154: iconst_1
    //   155: new 17	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   162: ldc 170
    //   164: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload 4
    //   169: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc 172
    //   174: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokestatic 154	java/lang/System:currentTimeMillis	()J
    //   180: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   183: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 175	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: aload_3
    //   190: ifnull -155 -> 35
    //   193: aload_3
    //   194: invokevirtual 178	java/io/FileOutputStream:close	()V
    //   197: return
    //   198: astore_2
    //   199: ldc 9
    //   201: iconst_1
    //   202: ldc 133
    //   204: aload_2
    //   205: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   208: return
    //   209: astore_3
    //   210: ldc 9
    //   212: iconst_1
    //   213: ldc 133
    //   215: aload_3
    //   216: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   219: aload_2
    //   220: ifnull -185 -> 35
    //   223: aload_2
    //   224: invokevirtual 178	java/io/FileOutputStream:close	()V
    //   227: return
    //   228: astore_2
    //   229: ldc 9
    //   231: iconst_1
    //   232: ldc 133
    //   234: aload_2
    //   235: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   238: return
    //   239: astore_2
    //   240: aconst_null
    //   241: astore_3
    //   242: aload_3
    //   243: ifnull +7 -> 250
    //   246: aload_3
    //   247: invokevirtual 178	java/io/FileOutputStream:close	()V
    //   250: aload_2
    //   251: athrow
    //   252: astore_3
    //   253: ldc 9
    //   255: iconst_1
    //   256: ldc 133
    //   258: aload_3
    //   259: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   262: goto -12 -> 250
    //   265: astore_2
    //   266: goto -24 -> 242
    //   269: astore 4
    //   271: aload_2
    //   272: astore_3
    //   273: aload 4
    //   275: astore_2
    //   276: goto -34 -> 242
    //   279: astore 4
    //   281: aload_3
    //   282: astore_2
    //   283: aload 4
    //   285: astore_3
    //   286: goto -76 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	MiniCrashHandler
    //   18	2	1	bool	boolean
    //   1	1	2	localObject1	Object
    //   36	7	2	localThrowable1	Throwable
    //   198	26	2	localThrowable2	Throwable
    //   228	7	2	localThrowable3	Throwable
    //   239	12	2	localObject2	Object
    //   265	7	2	localObject3	Object
    //   275	8	2	localObject4	Object
    //   56	138	3	localObject5	Object
    //   209	7	3	localThrowable4	Throwable
    //   241	6	3	localObject6	Object
    //   252	7	3	localThrowable5	Throwable
    //   272	14	3	localObject7	Object
    //   11	157	4	str	String
    //   269	5	4	localObject8	Object
    //   279	5	4	localThrowable6	Throwable
    //   67	19	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   27	35	36	java/lang/Throwable
    //   193	197	198	java/lang/Throwable
    //   2	19	209	java/lang/Throwable
    //   47	85	209	java/lang/Throwable
    //   85	91	209	java/lang/Throwable
    //   91	105	209	java/lang/Throwable
    //   105	110	209	java/lang/Throwable
    //   110	120	209	java/lang/Throwable
    //   223	227	228	java/lang/Throwable
    //   2	19	239	finally
    //   47	85	239	finally
    //   85	91	239	finally
    //   91	105	239	finally
    //   105	110	239	finally
    //   110	120	239	finally
    //   246	250	252	java/lang/Throwable
    //   120	189	265	finally
    //   210	219	269	finally
    //   120	189	279	java/lang/Throwable
  }
  
  public void setMiniAppConfig(MiniAppConfig paramMiniAppConfig)
  {
    this.miniAppConfig = paramMiniAppConfig;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    QLog.e("MiniCrashHandler", 1, "uncaughtException ", paramThrowable);
    saveCrashInfo();
    MiniProgramLpReportDC05115.reportCrash(this.miniAppConfig, paramThrowable);
    if (this.defaultHandler != null) {
      this.defaultHandler.uncaughtException(paramThread, paramThrowable);
    }
    super.uncaughtException(paramThread, paramThrowable);
    paramThread = MobileQQ.sMobileQQ;
    paramThread.crashed();
    paramThread.otherProcessExit(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.MiniCrashHandler
 * JD-Core Version:    0.7.0.1
 */