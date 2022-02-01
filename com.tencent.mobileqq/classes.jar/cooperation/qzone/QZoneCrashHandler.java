package cooperation.qzone;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
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
    //   1: astore 5
    //   3: new 30	java/io/File
    //   6: dup
    //   7: getstatic 35	anhk:bf	Ljava/lang/String;
    //   10: invokestatic 41	bhgg:a	(Ljava/lang/String;)Ljava/lang/String;
    //   13: invokespecial 44	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore 4
    //   18: aload 4
    //   20: invokevirtual 48	java/io/File:exists	()Z
    //   23: ifne +9 -> 32
    //   26: aload 4
    //   28: invokevirtual 51	java/io/File:mkdirs	()Z
    //   31: pop
    //   32: new 30	java/io/File
    //   35: dup
    //   36: new 53	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   43: getstatic 35	anhk:bf	Ljava/lang/String;
    //   46: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc 60
    //   51: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 41	bhgg:a	(Ljava/lang/String;)Ljava/lang/String;
    //   60: invokespecial 44	java/io/File:<init>	(Ljava/lang/String;)V
    //   63: astore 4
    //   65: aload 4
    //   67: invokevirtual 48	java/io/File:exists	()Z
    //   70: ifne +231 -> 301
    //   73: iconst_1
    //   74: istore_3
    //   75: new 66	java/io/FileWriter
    //   78: dup
    //   79: aload 4
    //   81: iconst_1
    //   82: invokespecial 69	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   85: astore 4
    //   87: iload_3
    //   88: ifeq +105 -> 193
    //   91: aload 4
    //   93: new 53	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   100: ldc 71
    //   102: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: getstatic 76	android/os/Build:MODEL	Ljava/lang/String;
    //   108: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 78
    //   113: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: getstatic 83	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   119: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokevirtual 86	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   128: aload 4
    //   130: ldc 88
    //   132: invokevirtual 86	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   135: new 90	android/text/format/Time
    //   138: dup
    //   139: invokespecial 91	android/text/format/Time:<init>	()V
    //   142: astore 5
    //   144: aload 5
    //   146: invokevirtual 94	android/text/format/Time:setToNow	()V
    //   149: aload 4
    //   151: new 53	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   158: aload 5
    //   160: ldc 96
    //   162: invokevirtual 99	android/text/format/Time:format	(Ljava/lang/String;)Ljava/lang/String;
    //   165: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc 101
    //   170: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokevirtual 86	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   179: aload 4
    //   181: ldc 103
    //   183: invokevirtual 86	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   186: aload 4
    //   188: ldc 88
    //   190: invokevirtual 86	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   193: new 90	android/text/format/Time
    //   196: dup
    //   197: invokespecial 91	android/text/format/Time:<init>	()V
    //   200: astore 5
    //   202: aload 5
    //   204: invokevirtual 94	android/text/format/Time:setToNow	()V
    //   207: aload 4
    //   209: new 53	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   216: aload 5
    //   218: ldc 96
    //   220: invokevirtual 99	android/text/format/Time:format	(Ljava/lang/String;)Ljava/lang/String;
    //   223: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: ldc 101
    //   228: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokevirtual 86	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   237: aload_0
    //   238: ifnull +32 -> 270
    //   241: aload 4
    //   243: new 53	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   250: ldc 105
    //   252: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_0
    //   256: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: ldc 107
    //   261: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokevirtual 86	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   270: aload 4
    //   272: aload_1
    //   273: invokevirtual 86	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   276: aload 4
    //   278: ldc 88
    //   280: invokevirtual 86	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   283: aload 4
    //   285: invokevirtual 110	java/io/FileWriter:close	()V
    //   288: iconst_0
    //   289: ifeq +11 -> 300
    //   292: new 112	java/lang/NullPointerException
    //   295: dup
    //   296: invokespecial 113	java/lang/NullPointerException:<init>	()V
    //   299: athrow
    //   300: return
    //   301: iconst_0
    //   302: istore_3
    //   303: goto -228 -> 75
    //   306: astore_0
    //   307: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq -10 -> 300
    //   313: ldc 120
    //   315: iconst_1
    //   316: new 53	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   323: ldc 122
    //   325: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload_0
    //   329: invokevirtual 125	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   332: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: return
    //   342: astore_1
    //   343: aload 5
    //   345: astore_0
    //   346: aload_1
    //   347: invokevirtual 132	java/lang/Exception:printStackTrace	()V
    //   350: aload_0
    //   351: ifnull -51 -> 300
    //   354: aload_0
    //   355: invokevirtual 110	java/io/FileWriter:close	()V
    //   358: return
    //   359: astore_0
    //   360: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq -63 -> 300
    //   366: ldc 120
    //   368: iconst_1
    //   369: new 53	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   376: ldc 122
    //   378: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload_0
    //   382: invokevirtual 125	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   385: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: return
    //   395: astore_0
    //   396: aconst_null
    //   397: astore_1
    //   398: aload_1
    //   399: ifnull +7 -> 406
    //   402: aload_1
    //   403: invokevirtual 110	java/io/FileWriter:close	()V
    //   406: aload_0
    //   407: athrow
    //   408: astore_1
    //   409: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   412: ifeq -6 -> 406
    //   415: ldc 120
    //   417: iconst_1
    //   418: new 53	java/lang/StringBuilder
    //   421: dup
    //   422: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   425: ldc 122
    //   427: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: aload_1
    //   431: invokevirtual 125	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   434: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: invokestatic 129	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   443: goto -37 -> 406
    //   446: astore_0
    //   447: aload 4
    //   449: astore_1
    //   450: goto -52 -> 398
    //   453: astore 4
    //   455: aload_0
    //   456: astore_1
    //   457: aload 4
    //   459: astore_0
    //   460: goto -62 -> 398
    //   463: astore_1
    //   464: aload 4
    //   466: astore_0
    //   467: goto -121 -> 346
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	470	0	paramString1	String
    //   0	470	1	paramString2	String
    //   0	470	2	paramBoolean	boolean
    //   74	229	3	i	int
    //   16	432	4	localObject1	Object
    //   453	12	4	localObject2	Object
    //   1	343	5	localTime	android.text.format.Time
    // Exception table:
    //   from	to	target	type
    //   292	300	306	java/lang/Exception
    //   3	32	342	java/lang/Exception
    //   32	73	342	java/lang/Exception
    //   75	87	342	java/lang/Exception
    //   354	358	359	java/lang/Exception
    //   3	32	395	finally
    //   32	73	395	finally
    //   75	87	395	finally
    //   402	406	408	java/lang/Exception
    //   91	193	446	finally
    //   193	237	446	finally
    //   241	270	446	finally
    //   270	288	446	finally
    //   346	350	453	finally
    //   91	193	463	java/lang/Exception
    //   193	237	463	java/lang/Exception
    //   241	270	463	java/lang/Exception
    //   270	288	463	java/lang/Exception
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
      if (Build.VERSION.SDK_INT < 9) {
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
    else
    {
      return str;
    }
    ((SharedPreferences.Editor)localObject).apply();
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
    Object localObject = BaseApplicationImpl.sApplication.getAllAccounts();
    if (localObject != null)
    {
      localObject = (SimpleAccount)((List)localObject).get(0);
      if (localObject == null) {
        break label127;
      }
    }
    label127:
    for (localObject = ((SimpleAccount)localObject).getUin();; localObject = "0")
    {
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
      return;
      localObject = null;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     cooperation.qzone.QZoneCrashHandler
 * JD-Core Version:    0.7.0.1
 */