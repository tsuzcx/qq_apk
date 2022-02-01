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
  public static final String FOLDER;
  private static final String TAG = "MiniCrashHandler";
  public Thread.UncaughtExceptionHandler defaultHandler = null;
  private MiniAppConfig miniAppConfig;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getFilesDir().getPath());
    localStringBuilder.append("/mini/");
    FOLDER = localStringBuilder.toString();
  }
  
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
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      if (!paramString.contains(":")) {
        return null;
      }
      String str = paramString.substring(paramString.indexOf(":") + 1);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(FOLDER);
      localStringBuilder.append(str);
      localStringBuilder.append("_crash");
      str = localStringBuilder.toString();
      return str;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFilePath exception! processName:");
      localStringBuilder.append(paramString);
      QLog.e("MiniCrashHandler", 1, localStringBuilder.toString(), localThrowable);
    }
    return null;
  }
  
  public static long getLastCrashTime(String paramString)
  {
    long l = -1L;
    try
    {
      paramString = getCrashFilePath(paramString);
      if (TextUtils.isEmpty(paramString)) {
        return -1L;
      }
      paramString = new File(paramString);
      if (paramString.exists())
      {
        if (!paramString.isFile()) {
          return -1L;
        }
        l = paramString.lastModified();
      }
      return l;
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
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_2
    //   5: aload_2
    //   6: astore_1
    //   7: invokestatic 26	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   10: invokevirtual 63	com/tencent/common/app/BaseApplicationImpl:getQQProcessName	()Ljava/lang/String;
    //   13: invokestatic 67	com/tencent/mobileqq/mini/MiniCrashHandler:getCrashFilePath	(Ljava/lang/String;)Ljava/lang/String;
    //   16: astore_3
    //   17: aload_2
    //   18: astore_1
    //   19: aload_3
    //   20: invokestatic 73	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   23: ifeq +4 -> 27
    //   26: return
    //   27: aload_2
    //   28: astore_1
    //   29: new 32	java/io/File
    //   32: dup
    //   33: aload_3
    //   34: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore 5
    //   39: aload_2
    //   40: astore_1
    //   41: new 32	java/io/File
    //   44: dup
    //   45: getstatic 47	com/tencent/mobileqq/mini/MiniCrashHandler:FOLDER	Ljava/lang/String;
    //   48: invokespecial 76	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore 6
    //   53: aload_2
    //   54: astore_1
    //   55: aload 6
    //   57: invokevirtual 80	java/io/File:exists	()Z
    //   60: ifeq +13 -> 73
    //   63: aload_2
    //   64: astore_1
    //   65: aload 6
    //   67: invokevirtual 131	java/io/File:isDirectory	()Z
    //   70: ifne +11 -> 81
    //   73: aload_2
    //   74: astore_1
    //   75: aload 6
    //   77: invokevirtual 134	java/io/File:mkdirs	()Z
    //   80: pop
    //   81: aload_2
    //   82: astore_1
    //   83: aload 5
    //   85: invokevirtual 80	java/io/File:exists	()Z
    //   88: ifeq +13 -> 101
    //   91: aload_2
    //   92: astore_1
    //   93: aload 5
    //   95: invokevirtual 83	java/io/File:isFile	()Z
    //   98: ifne +11 -> 109
    //   101: aload_2
    //   102: astore_1
    //   103: aload 5
    //   105: invokevirtual 137	java/io/File:createNewFile	()Z
    //   108: pop
    //   109: aload_2
    //   110: astore_1
    //   111: new 139	java/io/FileOutputStream
    //   114: dup
    //   115: aload 5
    //   117: iconst_0
    //   118: invokespecial 142	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   121: astore_2
    //   122: new 17	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   129: astore_1
    //   130: aload_1
    //   131: ldc 144
    //   133: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload_1
    //   138: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   141: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload_2
    //   146: aload_1
    //   147: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokevirtual 156	java/lang/String:getBytes	()[B
    //   153: invokevirtual 160	java/io/FileOutputStream:write	([B)V
    //   156: aload_2
    //   157: invokevirtual 163	java/io/FileOutputStream:flush	()V
    //   160: new 17	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 20	java/lang/StringBuilder:<init>	()V
    //   167: astore_1
    //   168: aload_1
    //   169: ldc 165
    //   171: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_1
    //   176: aload_3
    //   177: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload_1
    //   182: ldc 167
    //   184: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload_1
    //   189: invokestatic 149	java/lang/System:currentTimeMillis	()J
    //   192: invokevirtual 152	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: ldc 9
    //   198: iconst_1
    //   199: aload_1
    //   200: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 170	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aload_2
    //   207: invokevirtual 173	java/io/FileOutputStream:close	()V
    //   210: return
    //   211: astore_1
    //   212: goto +50 -> 262
    //   215: astore_3
    //   216: goto +15 -> 231
    //   219: astore_3
    //   220: aload_1
    //   221: astore_2
    //   222: aload_3
    //   223: astore_1
    //   224: goto +38 -> 262
    //   227: astore_3
    //   228: aload 4
    //   230: astore_2
    //   231: aload_2
    //   232: astore_1
    //   233: ldc 9
    //   235: iconst_1
    //   236: ldc 175
    //   238: aload_3
    //   239: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   242: aload_2
    //   243: ifnull +18 -> 261
    //   246: aload_2
    //   247: invokevirtual 173	java/io/FileOutputStream:close	()V
    //   250: return
    //   251: astore_1
    //   252: ldc 9
    //   254: iconst_1
    //   255: ldc 175
    //   257: aload_1
    //   258: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   261: return
    //   262: aload_2
    //   263: ifnull +20 -> 283
    //   266: aload_2
    //   267: invokevirtual 173	java/io/FileOutputStream:close	()V
    //   270: goto +13 -> 283
    //   273: astore_2
    //   274: ldc 9
    //   276: iconst_1
    //   277: ldc 175
    //   279: aload_2
    //   280: invokestatic 98	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   283: aload_1
    //   284: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	this	MiniCrashHandler
    //   6	194	1	localObject1	Object
    //   211	10	1	localObject2	Object
    //   223	10	1	localObject3	Object
    //   251	33	1	localThrowable1	Throwable
    //   4	263	2	localObject4	Object
    //   273	7	2	localThrowable2	Throwable
    //   16	161	3	str	String
    //   215	1	3	localThrowable3	Throwable
    //   219	4	3	localObject5	Object
    //   227	12	3	localThrowable4	Throwable
    //   1	228	4	localObject6	Object
    //   37	79	5	localFile1	File
    //   51	25	6	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   122	206	211	finally
    //   122	206	215	java/lang/Throwable
    //   7	17	219	finally
    //   19	26	219	finally
    //   29	39	219	finally
    //   41	53	219	finally
    //   55	63	219	finally
    //   65	73	219	finally
    //   75	81	219	finally
    //   83	91	219	finally
    //   93	101	219	finally
    //   103	109	219	finally
    //   111	122	219	finally
    //   233	242	219	finally
    //   7	17	227	java/lang/Throwable
    //   19	26	227	java/lang/Throwable
    //   29	39	227	java/lang/Throwable
    //   41	53	227	java/lang/Throwable
    //   55	63	227	java/lang/Throwable
    //   65	73	227	java/lang/Throwable
    //   75	81	227	java/lang/Throwable
    //   83	91	227	java/lang/Throwable
    //   93	101	227	java/lang/Throwable
    //   103	109	227	java/lang/Throwable
    //   111	122	227	java/lang/Throwable
    //   206	210	251	java/lang/Throwable
    //   246	250	251	java/lang/Throwable
    //   266	270	273	java/lang/Throwable
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
    Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = this.defaultHandler;
    if (localUncaughtExceptionHandler != null) {
      localUncaughtExceptionHandler.uncaughtException(paramThread, paramThrowable);
    }
    super.uncaughtException(paramThread, paramThrowable);
    paramThread = MobileQQ.sMobileQQ;
    paramThread.crashed();
    paramThread.otherProcessExit(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.MiniCrashHandler
 * JD-Core Version:    0.7.0.1
 */