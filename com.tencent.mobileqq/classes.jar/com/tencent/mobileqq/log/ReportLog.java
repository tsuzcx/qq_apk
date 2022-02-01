package com.tencent.mobileqq.log;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.SafeModeUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.utils.HeavyTaskExecutor;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.statistics.CaughtExceptionReport;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.CrashHandler;
import mqq.app.MobileQQ;

public class ReportLog
  extends CrashHandler
{
  static ProgressDialog jdField_a_of_type_AndroidAppProgressDialog;
  private static Handler jdField_a_of_type_AndroidOsHandler;
  private static IHttpCommunicatorListener jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorListener;
  public static String a;
  private static Thread.UncaughtExceptionHandler jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler;
  public static boolean a;
  private static final byte[] jdField_a_of_type_ArrayOfByte;
  public static String b;
  private static boolean jdField_b_of_type_Boolean = false;
  private static byte[] jdField_b_of_type_ArrayOfByte;
  private static String c;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = "9u23fh$jkf^%43hj".getBytes();
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_ArrayOfByte = null;
    c = "0";
    jdField_a_of_type_JavaLangString = "/Tencent/MobileQQ/log/";
    jdField_a_of_type_AndroidOsHandler = new ReportLog.1(Looper.getMainLooper());
    jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorListener = new ReportLog.2();
    jdField_b_of_type_JavaLangString = "https://bugtrace.3g.qq.com/upload/1/0";
  }
  
  public ReportLog()
  {
    if (jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler == null) {
      jdField_a_of_type_JavaLangThread$UncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    if (jdField_b_of_type_Boolean == paramBoolean) {}
    do
    {
      return;
      jdField_b_of_type_Boolean = paramBoolean;
    } while (!paramBoolean);
    try
    {
      jdField_a_of_type_JavaLangString = ReportLogHelper.a(paramContext, "/Tencent/MobileQQ/log/") + "/";
      ReportLogHelper.jdField_a_of_type_JavaLangString = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      ReportLogHelper.jdField_b_of_type_JavaLangString = Build.MODEL;
      ReportLogHelper.c = Build.VERSION.RELEASE;
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
  }
  
  /* Error */
  public static void a(com.tencent.mobileqq.transfile.HttpCommunicator paramHttpCommunicator, Context paramContext, ProgressDialog paramProgressDialog, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: ldc 136
    //   5: iconst_1
    //   6: iconst_5
    //   7: anewarray 138	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: invokestatic 143	com/tencent/common/config/AppSetting:a	()I
    //   15: invokestatic 149	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: ldc 151
    //   23: aastore
    //   24: dup
    //   25: iconst_2
    //   26: ldc 153
    //   28: aastore
    //   29: dup
    //   30: iconst_3
    //   31: aload_3
    //   32: aastore
    //   33: dup
    //   34: iconst_4
    //   35: aload 4
    //   37: aastore
    //   38: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   41: aload_0
    //   42: ifnonnull +4 -> 46
    //   45: return
    //   46: aload_2
    //   47: putstatic 161	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   50: new 80	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   57: aload_1
    //   58: ldc 38
    //   60: invokestatic 86	com/tencent/mobileqq/log/ReportLogHelper:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   63: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc 92
    //   68: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: putstatic 40	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   77: new 163	java/io/File
    //   80: dup
    //   81: new 80	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   88: getstatic 40	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   91: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc 165
    //   96: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokespecial 168	java/io/File:<init>	(Ljava/lang/String;)V
    //   105: astore 9
    //   107: aload 9
    //   109: invokevirtual 172	java/io/File:exists	()Z
    //   112: ifeq -67 -> 45
    //   115: aconst_null
    //   116: ldc 174
    //   118: iconst_1
    //   119: invokestatic 177	com/tencent/mobileqq/log/ReportLog:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   122: iconst_1
    //   123: putstatic 30	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_Boolean	Z
    //   126: aload 9
    //   128: invokevirtual 181	java/io/File:length	()J
    //   131: lstore 6
    //   133: lload 6
    //   135: l2i
    //   136: newarray byte
    //   138: astore 4
    //   140: new 183	java/io/BufferedInputStream
    //   143: dup
    //   144: new 185	java/io/FileInputStream
    //   147: dup
    //   148: aload 9
    //   150: invokespecial 188	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   153: invokespecial 191	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   156: astore_2
    //   157: lload 6
    //   159: l2i
    //   160: istore 5
    //   162: aload_2
    //   163: astore_1
    //   164: aload_2
    //   165: aload 4
    //   167: iconst_0
    //   168: iload 5
    //   170: invokevirtual 195	java/io/BufferedInputStream:read	([BII)I
    //   173: i2l
    //   174: lload 6
    //   176: lcmp
    //   177: ifeq +41 -> 218
    //   180: aload_2
    //   181: astore_1
    //   182: new 132	java/lang/Exception
    //   185: dup
    //   186: ldc 197
    //   188: invokespecial 198	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   191: athrow
    //   192: astore_1
    //   193: aload_2
    //   194: astore_0
    //   195: aload_1
    //   196: astore_2
    //   197: aload_0
    //   198: astore_1
    //   199: aload_2
    //   200: invokevirtual 201	java/lang/Exception:printStackTrace	()V
    //   203: aload_0
    //   204: ifnull -159 -> 45
    //   207: aload_0
    //   208: invokevirtual 204	java/io/BufferedInputStream:close	()V
    //   211: return
    //   212: astore_0
    //   213: aload_0
    //   214: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   217: return
    //   218: aload_2
    //   219: astore_1
    //   220: aload_2
    //   221: invokevirtual 204	java/io/BufferedInputStream:close	()V
    //   224: aload 9
    //   226: invokevirtual 208	java/io/File:delete	()Z
    //   229: pop
    //   230: getstatic 32	com/tencent/mobileqq/log/ReportLog:jdField_b_of_type_ArrayOfByte	[B
    //   233: ifnonnull +179 -> 412
    //   236: ldc 210
    //   238: invokevirtual 26	java/lang/String:getBytes	()[B
    //   241: putstatic 32	com/tencent/mobileqq/log/ReportLog:jdField_b_of_type_ArrayOfByte	[B
    //   244: goto +168 -> 412
    //   247: new 212	KQQ/UploadInfo
    //   250: dup
    //   251: invokespecial 213	KQQ/UploadInfo:<init>	()V
    //   254: astore_2
    //   255: aload_2
    //   256: invokestatic 143	com/tencent/common/config/AppSetting:a	()I
    //   259: i2l
    //   260: putfield 217	KQQ/UploadInfo:lAppID	J
    //   263: aload_2
    //   264: aload_1
    //   265: invokestatic 223	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   268: putfield 226	KQQ/UploadInfo:lFromMID	J
    //   271: aload_2
    //   272: lconst_0
    //   273: putfield 229	KQQ/UploadInfo:lToMID	J
    //   276: aload_2
    //   277: iconst_1
    //   278: putfield 233	KQQ/UploadInfo:shType	S
    //   281: aload_2
    //   282: getstatic 32	com/tencent/mobileqq/log/ReportLog:jdField_b_of_type_ArrayOfByte	[B
    //   285: putfield 236	KQQ/UploadInfo:vSignature	[B
    //   288: aload_2
    //   289: invokevirtual 239	KQQ/UploadInfo:toByteArray	()[B
    //   292: astore_1
    //   293: new 241	com/tencent/qphone/base/util/Cryptor
    //   296: dup
    //   297: invokespecial 242	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   300: aload_1
    //   301: getstatic 28	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_ArrayOfByte	[B
    //   304: invokevirtual 246	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   307: astore_2
    //   308: new 248	KQQ/HttpUploadReq
    //   311: dup
    //   312: invokespecial 249	KQQ/HttpUploadReq:<init>	()V
    //   315: astore_1
    //   316: aload_1
    //   317: aload_2
    //   318: putfield 252	KQQ/HttpUploadReq:vEncryptUploadInfo	[B
    //   321: aload_1
    //   322: aload 4
    //   324: putfield 255	KQQ/HttpUploadReq:vFileData	[B
    //   327: new 257	com/tencent/mobileqq/utils/httputils/HttpMsg
    //   330: dup
    //   331: getstatic 64	com/tencent/mobileqq/log/ReportLog:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   334: aload_1
    //   335: invokevirtual 258	KQQ/HttpUploadReq:toByteArray	()[B
    //   338: getstatic 60	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorListener	Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   341: invokespecial 261	com/tencent/mobileqq/utils/httputils/HttpMsg:<init>	(Ljava/lang/String;[BLcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;)V
    //   344: astore_1
    //   345: aload_1
    //   346: ldc_w 263
    //   349: invokevirtual 266	com/tencent/mobileqq/utils/httputils/HttpMsg:setRequestMethod	(Ljava/lang/String;)V
    //   352: aload_0
    //   353: aload_1
    //   354: invokevirtual 272	com/tencent/mobileqq/transfile/HttpCommunicator:sendMsg	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)I
    //   357: pop
    //   358: iconst_0
    //   359: putstatic 30	com/tencent/mobileqq/log/ReportLog:jdField_a_of_type_Boolean	Z
    //   362: iconst_0
    //   363: ifeq -318 -> 45
    //   366: new 274	java/lang/NullPointerException
    //   369: dup
    //   370: invokespecial 275	java/lang/NullPointerException:<init>	()V
    //   373: athrow
    //   374: astore_0
    //   375: aload_0
    //   376: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   379: return
    //   380: astore_0
    //   381: aload 8
    //   383: astore_1
    //   384: aload_1
    //   385: ifnull +7 -> 392
    //   388: aload_1
    //   389: invokevirtual 204	java/io/BufferedInputStream:close	()V
    //   392: aload_0
    //   393: athrow
    //   394: astore_1
    //   395: aload_1
    //   396: invokevirtual 205	java/io/IOException:printStackTrace	()V
    //   399: goto -7 -> 392
    //   402: astore_0
    //   403: goto -19 -> 384
    //   406: astore_2
    //   407: aconst_null
    //   408: astore_0
    //   409: goto -212 -> 197
    //   412: aload_3
    //   413: astore_1
    //   414: aload_3
    //   415: ifnonnull -168 -> 247
    //   418: ldc 34
    //   420: astore_1
    //   421: goto -174 -> 247
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	424	0	paramHttpCommunicator	com.tencent.mobileqq.transfile.HttpCommunicator
    //   0	424	1	paramContext	Context
    //   0	424	2	paramProgressDialog	ProgressDialog
    //   0	424	3	paramString1	String
    //   0	424	4	paramString2	String
    //   160	9	5	i	int
    //   131	44	6	l	long
    //   1	381	8	localObject	Object
    //   105	120	9	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   164	180	192	java/lang/Exception
    //   182	192	192	java/lang/Exception
    //   220	224	192	java/lang/Exception
    //   207	211	212	java/io/IOException
    //   366	374	374	java/io/IOException
    //   122	157	380	finally
    //   224	244	380	finally
    //   247	362	380	finally
    //   388	392	394	java/io/IOException
    //   164	180	402	finally
    //   182	192	402	finally
    //   199	203	402	finally
    //   220	224	402	finally
    //   122	157	406	java/lang/Exception
    //   224	244	406	java/lang/Exception
    //   247	362	406	java/lang/Exception
  }
  
  public static void a(String paramString)
  {
    c = paramString;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!jdField_b_of_type_Boolean) {}
    while (jdField_a_of_type_Boolean) {
      return;
    }
    a(paramString1, paramString2, true);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    ReportLogHelper.a(paramString1, paramString2, paramBoolean);
  }
  
  private boolean a(Throwable paramThrowable)
  {
    boolean bool = true;
    if ((paramThrowable == null) || ((1 != MobileQQ.sProcessId) && (7 != MobileQQ.sProcessId))) {}
    Object localObject2;
    do
    {
      return false;
      localObject2 = BaseApplicationImpl.getContext().getSharedPreferences("pref_safemode_not_exit", 4);
    } while (!((SharedPreferences)localObject2).getBoolean("key_not_exit_enable", false));
    Object localObject1 = paramThrowable.toString();
    int k;
    int j;
    int i;
    label173:
    int i1;
    label205:
    int m;
    try
    {
      localObject3 = ((SharedPreferences)localObject2).getString("key_not_exit_crash_type", null);
      localObject2 = ((SharedPreferences)localObject2).getString("key_not_exit_crash_stack", null);
      if ((localObject3 == null) || (TextUtils.isEmpty((CharSequence)localObject1))) {
        break label344;
      }
      localObject3 = ((String)localObject3).split("\\|");
      k = localObject3.length;
      j = 0;
      i = 0;
      if (j >= k) {
        break label356;
      }
      CharSequence localCharSequence = localObject3[j];
      if (!((String)localObject1).contains(localCharSequence)) {
        break label349;
      }
      QLog.d("ReportLog", 1, new Object[] { "exMsg = ", localObject1, ",crash = ", localCharSequence });
      i = 1;
    }
    catch (Throwable paramThrowable)
    {
      Object localObject3;
      int i2;
      int n;
      QLog.e("ReportLog", 1, "isNotExitSafeMode has some error", paramThrowable);
      return false;
    }
    if (localObject2 != null)
    {
      localObject1 = ((String)localObject2).split("\\|");
      paramThrowable = paramThrowable.getStackTrace();
      i1 = paramThrowable.length;
      k = 0;
      i = 0;
      break label361;
      localObject2 = ((StackTraceElement)localObject2).toString();
      i2 = localObject1.length;
      n = 0;
      for (;;)
      {
        m = i;
        if (n < i2)
        {
          localObject3 = localObject1[n];
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject2).contains((CharSequence)localObject3)))
          {
            QLog.d("ReportLog", 1, new Object[] { "stackElemStr = ", localObject2, ",crash = ", localObject3 });
            m = 1;
          }
        }
        else
        {
          k += 1;
          i = m;
          break;
        }
        n += 1;
      }
    }
    label344:
    label349:
    label356:
    label361:
    do
    {
      bool = false;
      break label393;
      m = 0;
      continue;
      j = 0;
      break label173;
      j += 1;
      break;
      j = i;
      break label173;
      m = i;
      if (k < i1)
      {
        localObject2 = paramThrowable[k];
        if (i == 0) {
          break label205;
        }
        m = i;
      }
    } while ((m == 0) || (j == 0));
    label393:
    return bool;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    QLog.d("ReportLog", 1, "uncaughtException java crash=" + paramThrowable);
    if (paramThrowable != null)
    {
      String str = paramThrowable.toString();
      if ((!TextUtils.isEmpty(str)) && (str.contains("java.util.concurrent.TimeoutException")) && (str.contains(".finalize() timed out after"))) {
        return;
      }
    }
    if (a(paramThrowable))
    {
      SafeModeUtil.a(HardCodeUtil.a(2131713370));
      com.tencent.mobileqq.statistics.StatisticCollector.sCatchedNotExit = true;
      CaughtExceptionReport.a(new Throwable(paramThrowable), "notExitOnSafeMode");
      if (Looper.myLooper() != null) {
        for (;;)
        {
          try
          {
            Looper.loop();
            continue;
            if (a(paramThread)) {
              continue;
            }
          }
          catch (Throwable paramThread)
          {
            QLog.d("ReportLog", 1, "uncaughtException loop throwable=", paramThread);
          }
          CaughtExceptionReport.a(new Throwable(paramThread), "CrashInLooper");
          if (Looper.getMainLooper() != Looper.myLooper()) {
            break;
          }
          System.exit(0);
        }
      }
      try
      {
        paramThread.run();
        return;
      }
      catch (Throwable paramThrowable)
      {
        QLog.d("ReportLog", 1, "uncaughtException run throwable=", paramThrowable);
        CaughtExceptionReport.a(new Throwable(paramThrowable), "CrashInThreadRun");
        try
        {
          paramThread.interrupt();
          return;
        }
        catch (Throwable paramThread)
        {
          QLog.d("ReportLog", 1, "uncaughtException interrupt throwable=", paramThread);
          return;
        }
      }
    }
    super.uncaughtException(paramThread, paramThrowable);
    long l = System.currentTimeMillis();
    QLog.d("ReportLog", 1, "uncaughtException trySave cost=" + (System.currentTimeMillis() - l));
    HeavyTaskExecutor.a();
    QLog.d("ReportLog", 1, "uncaughtException HeavyTask cost=" + (System.currentTimeMillis() - l));
    paramThread = MobileQQ.sMobileQQ;
    try
    {
      ReportLogHelper.jdField_a_of_type_JavaLangString = paramThread.getPackageManager().getPackageInfo(paramThread.getPackageName(), 0).versionName;
      ReportLogHelper.jdField_b_of_type_JavaLangString = Build.MODEL;
      ReportLogHelper.c = Build.VERSION.RELEASE;
      label317:
      paramThread.crashed();
      paramThread.sendBroadcast(new Intent("qqplayer_exit_action"));
      QQMusicPlayService.b("ReportLog");
      paramThread = new ReportLog.3(this, paramThread);
      if (Thread.currentThread() != Looper.getMainLooper().getThread())
      {
        new Handler(Looper.getMainLooper()).postAtFrontOfQueue(paramThread);
        return;
      }
      paramThread.run();
      return;
    }
    catch (Exception paramThrowable)
    {
      break label317;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.log.ReportLog
 * JD-Core Version:    0.7.0.1
 */