package cooperation.qzone;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.networkedmodule.QzoneModuleConst;
import java.util.List;
import mqq.app.CrashHandler;
import mqq.app.MobileQQ;

public class QZoneCrashHandler
  extends CrashHandler
{
  private static final String PREf_LAST_ERROR = "QZ_setting";
  private static Thread.UncaughtExceptionHandler defaultHandler;
  public static String lastCrashedMeasuredText;
  
  public QZoneCrashHandler()
  {
    if (defaultHandler == null) {
      defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
    }
  }
  
  /* Error */
  public static void appendLog(String paramString1, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 5
    //   8: astore 4
    //   10: new 31	java/io/File
    //   13: dup
    //   14: getstatic 36	com/tencent/mobileqq/app/AppConstants:LOG_PATH_SDCARD	Ljava/lang/String;
    //   17: invokestatic 42	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokespecial 45	java/io/File:<init>	(Ljava/lang/String;)V
    //   23: astore 7
    //   25: aload 5
    //   27: astore 4
    //   29: aload 7
    //   31: invokevirtual 49	java/io/File:exists	()Z
    //   34: ifne +13 -> 47
    //   37: aload 5
    //   39: astore 4
    //   41: aload 7
    //   43: invokevirtual 52	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: aload 5
    //   49: astore 4
    //   51: new 54	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   58: astore 7
    //   60: aload 5
    //   62: astore 4
    //   64: aload 7
    //   66: getstatic 36	com/tencent/mobileqq/app/AppConstants:LOG_PATH_SDCARD	Ljava/lang/String;
    //   69: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 5
    //   75: astore 4
    //   77: aload 7
    //   79: ldc 61
    //   81: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 5
    //   87: astore 4
    //   89: new 31	java/io/File
    //   92: dup
    //   93: aload 7
    //   95: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 42	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   101: invokespecial 45	java/io/File:<init>	(Ljava/lang/String;)V
    //   104: astore 7
    //   106: aload 5
    //   108: astore 4
    //   110: aload 7
    //   112: invokevirtual 49	java/io/File:exists	()Z
    //   115: ifne +416 -> 531
    //   118: iconst_1
    //   119: istore_3
    //   120: goto +3 -> 123
    //   123: aload 5
    //   125: astore 4
    //   127: new 67	java/io/FileWriter
    //   130: dup
    //   131: aload 7
    //   133: iconst_1
    //   134: invokespecial 70	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   137: astore 5
    //   139: iload_3
    //   140: ifeq +131 -> 271
    //   143: new 54	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   150: astore 4
    //   152: aload 4
    //   154: ldc 72
    //   156: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload 4
    //   162: getstatic 77	android/os/Build:MODEL	Ljava/lang/String;
    //   165: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 4
    //   171: ldc 79
    //   173: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 4
    //   179: getstatic 84	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   182: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 5
    //   188: aload 4
    //   190: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokevirtual 87	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   196: aload 5
    //   198: ldc 89
    //   200: invokevirtual 87	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   203: new 91	android/text/format/Time
    //   206: dup
    //   207: invokespecial 92	android/text/format/Time:<init>	()V
    //   210: astore 4
    //   212: aload 4
    //   214: invokevirtual 95	android/text/format/Time:setToNow	()V
    //   217: new 54	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   224: astore 6
    //   226: aload 6
    //   228: aload 4
    //   230: ldc 97
    //   232: invokevirtual 100	android/text/format/Time:format	(Ljava/lang/String;)Ljava/lang/String;
    //   235: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: pop
    //   239: aload 6
    //   241: ldc 102
    //   243: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: aload 5
    //   249: aload 6
    //   251: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokevirtual 87	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   257: aload 5
    //   259: ldc 104
    //   261: invokevirtual 87	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   264: aload 5
    //   266: ldc 89
    //   268: invokevirtual 87	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   271: new 91	android/text/format/Time
    //   274: dup
    //   275: invokespecial 92	android/text/format/Time:<init>	()V
    //   278: astore 4
    //   280: aload 4
    //   282: invokevirtual 95	android/text/format/Time:setToNow	()V
    //   285: new 54	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   292: astore 6
    //   294: aload 6
    //   296: aload 4
    //   298: ldc 97
    //   300: invokevirtual 100	android/text/format/Time:format	(Ljava/lang/String;)Ljava/lang/String;
    //   303: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload 6
    //   309: ldc 102
    //   311: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: pop
    //   315: aload 5
    //   317: aload 6
    //   319: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokevirtual 87	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   325: aload_0
    //   326: ifnull +45 -> 371
    //   329: new 54	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   336: astore 4
    //   338: aload 4
    //   340: ldc 106
    //   342: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload 4
    //   348: aload_0
    //   349: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 4
    //   355: ldc 108
    //   357: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload 5
    //   363: aload 4
    //   365: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: invokevirtual 87	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   371: aload 5
    //   373: aload_1
    //   374: invokevirtual 87	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   377: aload 5
    //   379: ldc 89
    //   381: invokevirtual 87	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   384: aload 5
    //   386: invokevirtual 111	java/io/FileWriter:close	()V
    //   389: return
    //   390: astore_0
    //   391: goto +80 -> 471
    //   394: astore_1
    //   395: aload 5
    //   397: astore_0
    //   398: goto +15 -> 413
    //   401: astore_0
    //   402: aload 4
    //   404: astore 5
    //   406: goto +65 -> 471
    //   409: astore_1
    //   410: aload 6
    //   412: astore_0
    //   413: aload_0
    //   414: astore 4
    //   416: aload_1
    //   417: invokevirtual 114	java/lang/Exception:printStackTrace	()V
    //   420: aload_0
    //   421: ifnull +49 -> 470
    //   424: aload_0
    //   425: invokevirtual 111	java/io/FileWriter:close	()V
    //   428: return
    //   429: astore_0
    //   430: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   433: ifeq +37 -> 470
    //   436: new 54	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   443: astore_1
    //   444: aload_1
    //   445: ldc 121
    //   447: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: pop
    //   451: aload_1
    //   452: aload_0
    //   453: invokevirtual 124	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   456: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: ldc 126
    //   462: iconst_1
    //   463: aload_1
    //   464: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   470: return
    //   471: aload 5
    //   473: ifnull +56 -> 529
    //   476: aload 5
    //   478: invokevirtual 111	java/io/FileWriter:close	()V
    //   481: goto +48 -> 529
    //   484: astore_1
    //   485: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   488: ifeq +41 -> 529
    //   491: new 54	java/lang/StringBuilder
    //   494: dup
    //   495: invokespecial 55	java/lang/StringBuilder:<init>	()V
    //   498: astore 4
    //   500: aload 4
    //   502: ldc 121
    //   504: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: aload 4
    //   510: aload_1
    //   511: invokevirtual 124	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   514: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: ldc 126
    //   520: iconst_1
    //   521: aload 4
    //   523: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokestatic 130	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   529: aload_0
    //   530: athrow
    //   531: iconst_0
    //   532: istore_3
    //   533: goto -410 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	536	0	paramString1	String
    //   0	536	1	paramString2	String
    //   0	536	2	paramBoolean	boolean
    //   119	414	3	i	int
    //   8	514	4	localObject1	Object
    //   4	473	5	localObject2	Object
    //   1	410	6	localStringBuilder	java.lang.StringBuilder
    //   23	109	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   143	271	390	finally
    //   271	325	390	finally
    //   329	371	390	finally
    //   371	389	390	finally
    //   143	271	394	java/lang/Exception
    //   271	325	394	java/lang/Exception
    //   329	371	394	java/lang/Exception
    //   371	389	394	java/lang/Exception
    //   10	25	401	finally
    //   29	37	401	finally
    //   41	47	401	finally
    //   51	60	401	finally
    //   64	73	401	finally
    //   77	85	401	finally
    //   89	106	401	finally
    //   110	118	401	finally
    //   127	139	401	finally
    //   416	420	401	finally
    //   10	25	409	java/lang/Exception
    //   29	37	409	java/lang/Exception
    //   41	47	409	java/lang/Exception
    //   51	60	409	java/lang/Exception
    //   64	73	409	java/lang/Exception
    //   77	85	409	java/lang/Exception
    //   89	106	409	java/lang/Exception
    //   110	118	409	java/lang/Exception
    //   127	139	409	java/lang/Exception
    //   424	428	429	java/lang/Exception
    //   476	481	484	java/lang/Exception
  }
  
  @SuppressLint({"NewApi"})
  public static String getLastCrashInf()
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("QZ_setting", 0);
    String str = ((SharedPreferences)localObject).getString("key_last_crash_info", null);
    if (str != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).remove("key_last_crash_info");
      if (Build.VERSION.SDK_INT < 9)
      {
        ((SharedPreferences.Editor)localObject).commit();
        return str;
      }
      ((SharedPreferences.Editor)localObject).apply();
    }
    return str;
  }
  
  @SuppressLint({"NewApi"})
  public static void saveLastCrashInf(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    LocalMultiProcConfig.putString("QZ_setting", "key_last_crash_info", paramString);
    QzoneModuleConst.updateCrashInfo(paramString, true);
  }
  
  void alertExit() {}
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    super.uncaughtException(paramThread, paramThrowable);
    Object localObject = MobileQQ.sMobileQQ.getAllAccounts();
    if (localObject != null) {
      localObject = (SimpleAccount)((List)localObject).get(0);
    } else {
      localObject = null;
    }
    if (localObject != null) {
      localObject = ((SimpleAccount)localObject).getUin();
    } else {
      localObject = "0";
    }
    long l = Long.valueOf((String)localObject).longValue();
    CrashGuard.getInstance().onException(paramThrowable, l);
    localObject = MobileQQ.sMobileQQ;
    String str = QLog.getStackTraceString(paramThrowable);
    QLog.e("crash", 1, str);
    saveLastCrashInf(str);
    appendLog("crash", str, true);
    QzoneModuleConst.updateCrashInfo(str, false);
    defaultHandler.uncaughtException(paramThread, paramThrowable);
    ((MobileQQ)localObject).crashed();
    ((MobileQQ)localObject).otherProcessExit(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.QZoneCrashHandler
 * JD-Core Version:    0.7.0.1
 */