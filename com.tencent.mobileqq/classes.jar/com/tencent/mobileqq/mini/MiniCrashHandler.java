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
    //   56: astore 5
    //   58: new 32	java/io/File
    //   61: dup
    //   62: getstatic 47	com/tencent/mobileqq/mini/MiniCrashHandler:FOLDER	Ljava/lang/String;
    //   65: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   68: astore_3
    //   69: aload_3
    //   70: invokevirtual 80	java/io/File:exists	()Z
    //   73: ifeq +10 -> 83
    //   76: aload_3
    //   77: invokevirtual 136	java/io/File:isDirectory	()Z
    //   80: ifne +8 -> 88
    //   83: aload_3
    //   84: invokevirtual 139	java/io/File:mkdirs	()Z
    //   87: pop
    //   88: aload 5
    //   90: invokevirtual 80	java/io/File:exists	()Z
    //   93: ifeq +11 -> 104
    //   96: aload 5
    //   98: invokevirtual 83	java/io/File:isFile	()Z
    //   101: ifne +9 -> 110
    //   104: aload 5
    //   106: invokevirtual 142	java/io/File:createNewFile	()Z
    //   109: pop
    //   110: new 144	java/io/FileOutputStream
    //   113: dup
    //   114: aload 5
    //   116: iconst_0
    //   117: invokespecial 147	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   120: astore_3
    //   121: aload_3
    //   122: new 17	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   129: ldc 149
    //   131: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokestatic 154	java/lang/System:currentTimeMillis	()J
    //   137: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   140: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokevirtual 161	java/lang/String:getBytes	()[B
    //   146: invokevirtual 165	java/io/FileOutputStream:write	([B)V
    //   149: aload_3
    //   150: invokevirtual 168	java/io/FileOutputStream:flush	()V
    //   153: ldc 9
    //   155: iconst_1
    //   156: new 17	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   163: ldc 170
    //   165: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload 4
    //   170: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: ldc 172
    //   175: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokestatic 154	java/lang/System:currentTimeMillis	()J
    //   181: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   184: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 175	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: aload_3
    //   191: ifnull -156 -> 35
    //   194: aload_3
    //   195: invokevirtual 178	java/io/FileOutputStream:close	()V
    //   198: return
    //   199: astore_2
    //   200: ldc 9
    //   202: iconst_1
    //   203: ldc 133
    //   205: aload_2
    //   206: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   209: return
    //   210: astore_3
    //   211: ldc 9
    //   213: iconst_1
    //   214: ldc 133
    //   216: aload_3
    //   217: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   220: aload_2
    //   221: ifnull -186 -> 35
    //   224: aload_2
    //   225: invokevirtual 178	java/io/FileOutputStream:close	()V
    //   228: return
    //   229: astore_2
    //   230: ldc 9
    //   232: iconst_1
    //   233: ldc 133
    //   235: aload_2
    //   236: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   239: return
    //   240: astore_2
    //   241: aconst_null
    //   242: astore_3
    //   243: aload_3
    //   244: ifnull +7 -> 251
    //   247: aload_3
    //   248: invokevirtual 178	java/io/FileOutputStream:close	()V
    //   251: aload_2
    //   252: athrow
    //   253: astore_3
    //   254: ldc 9
    //   256: iconst_1
    //   257: ldc 133
    //   259: aload_3
    //   260: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   263: goto -12 -> 251
    //   266: astore_2
    //   267: goto -24 -> 243
    //   270: astore 4
    //   272: aload_2
    //   273: astore_3
    //   274: aload 4
    //   276: astore_2
    //   277: goto -34 -> 243
    //   280: astore 4
    //   282: aload_3
    //   283: astore_2
    //   284: aload 4
    //   286: astore_3
    //   287: goto -76 -> 211
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	290	0	this	MiniCrashHandler
    //   18	2	1	bool	boolean
    //   1	1	2	localObject1	Object
    //   36	7	2	localThrowable1	Throwable
    //   199	26	2	localThrowable2	Throwable
    //   229	7	2	localThrowable3	Throwable
    //   240	12	2	localObject2	Object
    //   266	7	2	localObject3	Object
    //   276	8	2	localObject4	Object
    //   68	127	3	localObject5	Object
    //   210	7	3	localThrowable4	Throwable
    //   242	6	3	localObject6	Object
    //   253	7	3	localThrowable5	Throwable
    //   273	14	3	localObject7	Object
    //   11	158	4	str	String
    //   270	5	4	localObject8	Object
    //   280	5	4	localThrowable6	Throwable
    //   56	59	5	localFile	File
    // Exception table:
    //   from	to	target	type
    //   27	35	36	java/lang/Throwable
    //   194	198	199	java/lang/Throwable
    //   2	19	210	java/lang/Throwable
    //   47	83	210	java/lang/Throwable
    //   83	88	210	java/lang/Throwable
    //   88	104	210	java/lang/Throwable
    //   104	110	210	java/lang/Throwable
    //   110	121	210	java/lang/Throwable
    //   224	228	229	java/lang/Throwable
    //   2	19	240	finally
    //   47	83	240	finally
    //   83	88	240	finally
    //   88	104	240	finally
    //   104	110	240	finally
    //   110	121	240	finally
    //   247	251	253	java/lang/Throwable
    //   121	190	266	finally
    //   211	220	270	finally
    //   121	190	280	java/lang/Throwable
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