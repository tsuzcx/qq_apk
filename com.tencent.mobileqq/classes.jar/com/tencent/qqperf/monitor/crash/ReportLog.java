package com.tencent.qqperf.monitor.crash;

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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.utils.HeavyTaskExecutor;
import com.tencent.mobileqq.listentogether.player.QQMusicPlayService;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil;
import com.tencent.qqperf.monitor.crash.tools.ReportLogHelper;
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
  public static boolean a = false;
  private static final byte[] jdField_a_of_type_ArrayOfByte = "9u23fh$jkf^%43hj".getBytes();
  public static String b;
  private static boolean jdField_b_of_type_Boolean = false;
  private static byte[] jdField_b_of_type_ArrayOfByte;
  private static String c;
  
  static
  {
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
    if (jdField_b_of_type_Boolean == paramBoolean) {
      return;
    }
    jdField_b_of_type_Boolean = paramBoolean;
    if (paramBoolean) {}
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ReportLogHelper.a(paramContext, "/Tencent/MobileQQ/log/"));
      localStringBuilder.append("/");
      jdField_a_of_type_JavaLangString = localStringBuilder.toString();
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
    //   0: ldc 137
    //   2: iconst_1
    //   3: iconst_5
    //   4: anewarray 139	java/lang/Object
    //   7: dup
    //   8: iconst_0
    //   9: invokestatic 144	com/tencent/common/config/AppSetting:a	()I
    //   12: invokestatic 150	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: ldc 152
    //   20: aastore
    //   21: dup
    //   22: iconst_2
    //   23: ldc 154
    //   25: aastore
    //   26: dup
    //   27: iconst_3
    //   28: aload_3
    //   29: aastore
    //   30: dup
    //   31: iconst_4
    //   32: aload 4
    //   34: aastore
    //   35: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   38: aload_0
    //   39: ifnonnull +4 -> 43
    //   42: return
    //   43: aload_2
    //   44: putstatic 162	com/tencent/qqperf/monitor/crash/ReportLog:jdField_a_of_type_AndroidAppProgressDialog	Landroid/app/ProgressDialog;
    //   47: new 81	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   54: astore_2
    //   55: aload_2
    //   56: aload_1
    //   57: ldc 37
    //   59: invokestatic 87	com/tencent/qqperf/monitor/crash/tools/ReportLogHelper:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   62: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_2
    //   67: ldc 93
    //   69: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_2
    //   74: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: putstatic 39	com/tencent/qqperf/monitor/crash/ReportLog:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   80: new 81	java/lang/StringBuilder
    //   83: dup
    //   84: invokespecial 82	java/lang/StringBuilder:<init>	()V
    //   87: astore_1
    //   88: aload_1
    //   89: getstatic 39	com/tencent/qqperf/monitor/crash/ReportLog:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   92: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_1
    //   97: ldc 164
    //   99: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: new 166	java/io/File
    //   106: dup
    //   107: aload_1
    //   108: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokespecial 169	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: astore 10
    //   116: aload 10
    //   118: invokevirtual 173	java/io/File:exists	()Z
    //   121: ifne +4 -> 125
    //   124: return
    //   125: aconst_null
    //   126: astore 4
    //   128: aconst_null
    //   129: astore 8
    //   131: aconst_null
    //   132: ldc 175
    //   134: iconst_1
    //   135: invokestatic 178	com/tencent/qqperf/monitor/crash/ReportLog:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   138: aload 8
    //   140: astore_1
    //   141: iconst_1
    //   142: putstatic 29	com/tencent/qqperf/monitor/crash/ReportLog:jdField_a_of_type_Boolean	Z
    //   145: aload 8
    //   147: astore_1
    //   148: aload 10
    //   150: invokevirtual 182	java/io/File:length	()J
    //   153: lstore 6
    //   155: lload 6
    //   157: l2i
    //   158: istore 5
    //   160: aload 8
    //   162: astore_1
    //   163: iload 5
    //   165: newarray byte
    //   167: astore 9
    //   169: aload 8
    //   171: astore_1
    //   172: new 184	java/io/BufferedInputStream
    //   175: dup
    //   176: new 186	java/io/FileInputStream
    //   179: dup
    //   180: aload 10
    //   182: invokespecial 189	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   185: invokespecial 192	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   188: astore_2
    //   189: aload_2
    //   190: aload 9
    //   192: iconst_0
    //   193: iload 5
    //   195: invokevirtual 196	java/io/BufferedInputStream:read	([BII)I
    //   198: i2l
    //   199: lload 6
    //   201: lcmp
    //   202: ifne +200 -> 402
    //   205: aload_2
    //   206: invokevirtual 199	java/io/BufferedInputStream:close	()V
    //   209: aload 8
    //   211: astore_1
    //   212: aload 10
    //   214: invokevirtual 202	java/io/File:delete	()Z
    //   217: pop
    //   218: aload 8
    //   220: astore_1
    //   221: getstatic 31	com/tencent/qqperf/monitor/crash/ReportLog:jdField_b_of_type_ArrayOfByte	[B
    //   224: ifnonnull +250 -> 474
    //   227: aload 8
    //   229: astore_1
    //   230: ldc 204
    //   232: invokevirtual 25	java/lang/String:getBytes	()[B
    //   235: putstatic 31	com/tencent/qqperf/monitor/crash/ReportLog:jdField_b_of_type_ArrayOfByte	[B
    //   238: goto +236 -> 474
    //   241: aload 8
    //   243: astore_1
    //   244: new 206	KQQ/UploadInfo
    //   247: dup
    //   248: invokespecial 207	KQQ/UploadInfo:<init>	()V
    //   251: astore_3
    //   252: aload 8
    //   254: astore_1
    //   255: aload_3
    //   256: invokestatic 144	com/tencent/common/config/AppSetting:a	()I
    //   259: i2l
    //   260: putfield 211	KQQ/UploadInfo:lAppID	J
    //   263: aload 8
    //   265: astore_1
    //   266: aload_3
    //   267: aload_2
    //   268: invokestatic 217	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   271: putfield 220	KQQ/UploadInfo:lFromMID	J
    //   274: aload 8
    //   276: astore_1
    //   277: aload_3
    //   278: lconst_0
    //   279: putfield 223	KQQ/UploadInfo:lToMID	J
    //   282: aload 8
    //   284: astore_1
    //   285: aload_3
    //   286: iconst_1
    //   287: putfield 227	KQQ/UploadInfo:shType	S
    //   290: aload 8
    //   292: astore_1
    //   293: aload_3
    //   294: getstatic 31	com/tencent/qqperf/monitor/crash/ReportLog:jdField_b_of_type_ArrayOfByte	[B
    //   297: putfield 230	KQQ/UploadInfo:vSignature	[B
    //   300: aload 8
    //   302: astore_1
    //   303: aload_3
    //   304: invokevirtual 233	KQQ/UploadInfo:toByteArray	()[B
    //   307: astore_2
    //   308: aload 8
    //   310: astore_1
    //   311: new 235	com/tencent/qphone/base/util/Cryptor
    //   314: dup
    //   315: invokespecial 236	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   318: aload_2
    //   319: getstatic 27	com/tencent/qqperf/monitor/crash/ReportLog:jdField_a_of_type_ArrayOfByte	[B
    //   322: invokevirtual 240	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   325: astore_2
    //   326: aload 8
    //   328: astore_1
    //   329: new 242	KQQ/HttpUploadReq
    //   332: dup
    //   333: invokespecial 243	KQQ/HttpUploadReq:<init>	()V
    //   336: astore_3
    //   337: aload 8
    //   339: astore_1
    //   340: aload_3
    //   341: aload_2
    //   342: putfield 246	KQQ/HttpUploadReq:vEncryptUploadInfo	[B
    //   345: aload 8
    //   347: astore_1
    //   348: aload_3
    //   349: aload 9
    //   351: putfield 249	KQQ/HttpUploadReq:vFileData	[B
    //   354: aload 8
    //   356: astore_1
    //   357: new 251	com/tencent/mobileqq/utils/httputils/HttpMsg
    //   360: dup
    //   361: getstatic 63	com/tencent/qqperf/monitor/crash/ReportLog:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   364: aload_3
    //   365: invokevirtual 252	KQQ/HttpUploadReq:toByteArray	()[B
    //   368: getstatic 59	com/tencent/qqperf/monitor/crash/ReportLog:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsIHttpCommunicatorListener	Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   371: invokespecial 255	com/tencent/mobileqq/utils/httputils/HttpMsg:<init>	(Ljava/lang/String;[BLcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;)V
    //   374: astore_2
    //   375: aload 8
    //   377: astore_1
    //   378: aload_2
    //   379: ldc_w 257
    //   382: invokevirtual 260	com/tencent/mobileqq/utils/httputils/HttpMsg:setRequestMethod	(Ljava/lang/String;)V
    //   385: aload 8
    //   387: astore_1
    //   388: aload_0
    //   389: aload_2
    //   390: invokevirtual 266	com/tencent/mobileqq/transfile/HttpCommunicator:sendMsg	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)I
    //   393: pop
    //   394: aload 8
    //   396: astore_1
    //   397: iconst_0
    //   398: putstatic 29	com/tencent/qqperf/monitor/crash/ReportLog:jdField_a_of_type_Boolean	Z
    //   401: return
    //   402: new 133	java/lang/Exception
    //   405: dup
    //   406: ldc_w 268
    //   409: invokespecial 269	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   412: athrow
    //   413: astore_0
    //   414: aload_2
    //   415: astore_1
    //   416: goto +40 -> 456
    //   419: astore_1
    //   420: aload_2
    //   421: astore_0
    //   422: aload_1
    //   423: astore_2
    //   424: goto +11 -> 435
    //   427: astore_0
    //   428: goto +28 -> 456
    //   431: astore_2
    //   432: aload 4
    //   434: astore_0
    //   435: aload_0
    //   436: astore_1
    //   437: aload_2
    //   438: invokevirtual 272	java/lang/Exception:printStackTrace	()V
    //   441: aload_0
    //   442: ifnull +13 -> 455
    //   445: aload_0
    //   446: invokevirtual 199	java/io/BufferedInputStream:close	()V
    //   449: return
    //   450: astore_0
    //   451: aload_0
    //   452: invokevirtual 273	java/io/IOException:printStackTrace	()V
    //   455: return
    //   456: aload_1
    //   457: ifnull +15 -> 472
    //   460: aload_1
    //   461: invokevirtual 199	java/io/BufferedInputStream:close	()V
    //   464: goto +8 -> 472
    //   467: astore_1
    //   468: aload_1
    //   469: invokevirtual 273	java/io/IOException:printStackTrace	()V
    //   472: aload_0
    //   473: athrow
    //   474: aload_3
    //   475: astore_2
    //   476: aload_3
    //   477: ifnonnull -236 -> 241
    //   480: ldc 33
    //   482: astore_2
    //   483: goto -242 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	486	0	paramHttpCommunicator	com.tencent.mobileqq.transfile.HttpCommunicator
    //   0	486	1	paramContext	Context
    //   0	486	2	paramProgressDialog	ProgressDialog
    //   0	486	3	paramString1	String
    //   0	486	4	paramString2	String
    //   158	36	5	i	int
    //   153	47	6	l	long
    //   129	266	8	localObject	Object
    //   167	183	9	arrayOfByte	byte[]
    //   114	99	10	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   189	209	413	finally
    //   402	413	413	finally
    //   189	209	419	java/lang/Exception
    //   402	413	419	java/lang/Exception
    //   141	145	427	finally
    //   148	155	427	finally
    //   163	169	427	finally
    //   172	189	427	finally
    //   212	218	427	finally
    //   221	227	427	finally
    //   230	238	427	finally
    //   244	252	427	finally
    //   255	263	427	finally
    //   266	274	427	finally
    //   277	282	427	finally
    //   285	290	427	finally
    //   293	300	427	finally
    //   303	308	427	finally
    //   311	326	427	finally
    //   329	337	427	finally
    //   340	345	427	finally
    //   348	354	427	finally
    //   357	375	427	finally
    //   378	385	427	finally
    //   388	394	427	finally
    //   397	401	427	finally
    //   437	441	427	finally
    //   141	145	431	java/lang/Exception
    //   148	155	431	java/lang/Exception
    //   163	169	431	java/lang/Exception
    //   172	189	431	java/lang/Exception
    //   212	218	431	java/lang/Exception
    //   221	227	431	java/lang/Exception
    //   230	238	431	java/lang/Exception
    //   244	252	431	java/lang/Exception
    //   255	263	431	java/lang/Exception
    //   266	274	431	java/lang/Exception
    //   277	282	431	java/lang/Exception
    //   285	290	431	java/lang/Exception
    //   293	300	431	java/lang/Exception
    //   303	308	431	java/lang/Exception
    //   311	326	431	java/lang/Exception
    //   329	337	431	java/lang/Exception
    //   340	345	431	java/lang/Exception
    //   348	354	431	java/lang/Exception
    //   357	375	431	java/lang/Exception
    //   378	385	431	java/lang/Exception
    //   388	394	431	java/lang/Exception
    //   397	401	431	java/lang/Exception
    //   445	449	450	java/io/IOException
    //   460	464	467	java/io/IOException
  }
  
  public static void a(String paramString)
  {
    c = paramString;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!jdField_b_of_type_Boolean) {
      return;
    }
    if (jdField_a_of_type_Boolean) {
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
    boolean bool2 = false;
    Object localObject2;
    Object localObject1;
    if (paramThrowable != null)
    {
      if ((1 != MobileQQ.sProcessId) && (7 != MobileQQ.sProcessId)) {
        return false;
      }
      localObject2 = BaseApplicationImpl.getContext().getSharedPreferences("pref_safemode_not_exit", 4);
      if (!((SharedPreferences)localObject2).getBoolean("key_not_exit_enable", false)) {
        return false;
      }
      localObject1 = paramThrowable.toString();
    }
    for (;;)
    {
      int k;
      int i;
      int n;
      try
      {
        Object localObject3 = ((SharedPreferences)localObject2).getString("key_not_exit_crash_type", null);
        localObject2 = ((SharedPreferences)localObject2).getString("key_not_exit_crash_stack", null);
        if ((localObject3 == null) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          break label370;
        }
        localObject3 = ((String)localObject3).split("\\|");
        m = localObject3.length;
        k = 0;
        i = 0;
        j = i;
        if (k < m)
        {
          CharSequence localCharSequence = localObject3[k];
          if (!((String)localObject1).contains(localCharSequence)) {
            break label361;
          }
          QLog.d("ReportLog", 1, new Object[] { "exMsg = ", localObject1, ",crash = ", localCharSequence });
          i = 1;
          break label361;
        }
        if (localObject2 != null)
        {
          localObject1 = ((String)localObject2).split("\\|");
          paramThrowable = paramThrowable.getStackTrace();
          n = paramThrowable.length;
          k = 0;
          i = 0;
          break label375;
          localObject2 = ((StackTraceElement)localObject2).toString();
          int i1 = localObject1.length;
          m = 0;
          if (m < i1)
          {
            localObject3 = localObject1[m];
            if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject2).contains((CharSequence)localObject3)))
            {
              QLog.d("ReportLog", 1, new Object[] { "stackElemStr = ", localObject2, ",crash = ", localObject3 });
              i = 1;
            }
            else
            {
              m += 1;
              continue;
            }
          }
          k += 1;
          break label375;
        }
        m = 0;
        boolean bool1 = bool2;
        if (m != 0)
        {
          bool1 = bool2;
          if (j != 0) {
            bool1 = true;
          }
        }
        return bool1;
      }
      catch (Throwable paramThrowable)
      {
        QLog.e("ReportLog", 1, "isNotExitSafeMode has some error", paramThrowable);
      }
      return false;
      label361:
      k += 1;
      continue;
      label370:
      int j = 0;
      continue;
      label375:
      int m = i;
      if (k < n)
      {
        localObject2 = paramThrowable[k];
        if (i != 0) {
          m = i;
        }
      }
    }
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("uncaughtException java crash=");
    ((StringBuilder)localObject).append(paramThrowable);
    QLog.d("ReportLog", 1, ((StringBuilder)localObject).toString());
    if (paramThrowable != null)
    {
      localObject = paramThrowable.toString();
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("java.util.concurrent.TimeoutException")) && (((String)localObject).contains(".finalize() timed out after"))) {
        return;
      }
    }
    if (a(paramThrowable))
    {
      SafeModeUtil.a(HardCodeUtil.a(2131713338));
      QQCrashReportManager.c = true;
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
        }
      }
      return;
    }
    super.uncaughtException(paramThread, paramThrowable);
    long l = System.currentTimeMillis();
    paramThread = new StringBuilder();
    paramThread.append("uncaughtException trySave cost=");
    paramThread.append(System.currentTimeMillis() - l);
    QLog.d("ReportLog", 1, paramThread.toString());
    HeavyTaskExecutor.a();
    paramThread = new StringBuilder();
    paramThread.append("uncaughtException HeavyTask cost=");
    paramThread.append(System.currentTimeMillis() - l);
    QLog.d("ReportLog", 1, paramThread.toString());
    paramThread = MobileQQ.sMobileQQ;
    try
    {
      ReportLogHelper.jdField_a_of_type_JavaLangString = paramThread.getPackageManager().getPackageInfo(paramThread.getPackageName(), 0).versionName;
      ReportLogHelper.jdField_b_of_type_JavaLangString = Build.MODEL;
      ReportLogHelper.c = Build.VERSION.RELEASE;
      label339:
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
      break label339;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.ReportLog
 * JD-Core Version:    0.7.0.1
 */