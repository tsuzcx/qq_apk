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
  public static boolean a = false;
  public static String b;
  static ProgressDialog c;
  public static String d = "https://bugtrace.3g.qq.com/upload/1/0";
  private static boolean e = false;
  private static final byte[] f = "9u23fh$jkf^%43hj".getBytes();
  private static byte[] g;
  private static String h;
  private static Thread.UncaughtExceptionHandler i;
  private static Handler j;
  private static IHttpCommunicatorListener k;
  
  static
  {
    a = false;
    g = null;
    h = "0";
    b = "/Tencent/MobileQQ/log/";
    j = new ReportLog.1(Looper.getMainLooper());
    k = new ReportLog.2();
  }
  
  public ReportLog()
  {
    if (i == null) {
      i = Thread.getDefaultUncaughtExceptionHandler();
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    if (e == paramBoolean) {
      return;
    }
    e = paramBoolean;
    if (paramBoolean) {}
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ReportLogHelper.a(paramContext, "/Tencent/MobileQQ/log/"));
      localStringBuilder.append("/");
      b = localStringBuilder.toString();
      ReportLogHelper.a = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      ReportLogHelper.b = Build.MODEL;
      ReportLogHelper.c = Build.VERSION.RELEASE;
      return;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
  }
  
  /* Error */
  public static void a(com.tencent.mobileqq.transfile.HttpCommunicator paramHttpCommunicator, Context paramContext, ProgressDialog paramProgressDialog, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 151	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +44 -> 47
    //   6: ldc 153
    //   8: iconst_2
    //   9: iconst_5
    //   10: anewarray 155	java/lang/Object
    //   13: dup
    //   14: iconst_0
    //   15: invokestatic 160	com/tencent/common/config/AppSetting:d	()I
    //   18: invokestatic 166	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: aastore
    //   22: dup
    //   23: iconst_1
    //   24: ldc 168
    //   26: aastore
    //   27: dup
    //   28: iconst_2
    //   29: ldc 170
    //   31: aastore
    //   32: dup
    //   33: iconst_3
    //   34: aload_3
    //   35: aastore
    //   36: dup
    //   37: iconst_4
    //   38: aload 4
    //   40: aastore
    //   41: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   44: goto +39 -> 83
    //   47: ldc 153
    //   49: iconst_1
    //   50: iconst_4
    //   51: anewarray 155	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: invokestatic 160	com/tencent/common/config/AppSetting:d	()I
    //   59: invokestatic 166	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: ldc 168
    //   67: aastore
    //   68: dup
    //   69: iconst_2
    //   70: ldc 170
    //   72: aastore
    //   73: dup
    //   74: iconst_3
    //   75: aload_3
    //   76: invokestatic 179	mqq/util/LogUtil:wrapLogUin	(Ljava/lang/String;)Ljava/lang/String;
    //   79: aastore
    //   80: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   83: aload_0
    //   84: ifnonnull +4 -> 88
    //   87: return
    //   88: aload_2
    //   89: putstatic 181	com/tencent/qqperf/monitor/crash/ReportLog:c	Landroid/app/ProgressDialog;
    //   92: new 89	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   99: astore_2
    //   100: aload_2
    //   101: aload_1
    //   102: ldc 45
    //   104: invokestatic 95	com/tencent/qqperf/monitor/crash/tools/ReportLogHelper:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    //   107: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_2
    //   112: ldc 101
    //   114: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_2
    //   119: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: putstatic 47	com/tencent/qqperf/monitor/crash/ReportLog:b	Ljava/lang/String;
    //   125: new 89	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 90	java/lang/StringBuilder:<init>	()V
    //   132: astore_1
    //   133: aload_1
    //   134: getstatic 47	com/tencent/qqperf/monitor/crash/ReportLog:b	Ljava/lang/String;
    //   137: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_1
    //   142: ldc 183
    //   144: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: new 185	java/io/File
    //   151: dup
    //   152: aload_1
    //   153: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokespecial 188	java/io/File:<init>	(Ljava/lang/String;)V
    //   159: astore 10
    //   161: aload 10
    //   163: invokevirtual 191	java/io/File:exists	()Z
    //   166: ifne +4 -> 170
    //   169: return
    //   170: aconst_null
    //   171: astore 4
    //   173: aconst_null
    //   174: astore 8
    //   176: aconst_null
    //   177: ldc 193
    //   179: iconst_1
    //   180: invokestatic 196	com/tencent/qqperf/monitor/crash/ReportLog:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   183: aload 8
    //   185: astore_1
    //   186: iconst_1
    //   187: putstatic 37	com/tencent/qqperf/monitor/crash/ReportLog:a	Z
    //   190: aload 8
    //   192: astore_1
    //   193: aload 10
    //   195: invokevirtual 200	java/io/File:length	()J
    //   198: lstore 6
    //   200: lload 6
    //   202: l2i
    //   203: istore 5
    //   205: aload 8
    //   207: astore_1
    //   208: iload 5
    //   210: newarray byte
    //   212: astore 9
    //   214: aload 8
    //   216: astore_1
    //   217: new 202	java/io/BufferedInputStream
    //   220: dup
    //   221: new 204	java/io/FileInputStream
    //   224: dup
    //   225: aload 10
    //   227: invokespecial 207	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   230: invokespecial 210	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   233: astore_2
    //   234: aload_2
    //   235: aload 9
    //   237: iconst_0
    //   238: iload 5
    //   240: invokevirtual 214	java/io/BufferedInputStream:read	([BII)I
    //   243: i2l
    //   244: lload 6
    //   246: lcmp
    //   247: ifne +200 -> 447
    //   250: aload_2
    //   251: invokevirtual 217	java/io/BufferedInputStream:close	()V
    //   254: aload 8
    //   256: astore_1
    //   257: aload 10
    //   259: invokevirtual 220	java/io/File:delete	()Z
    //   262: pop
    //   263: aload 8
    //   265: astore_1
    //   266: getstatic 39	com/tencent/qqperf/monitor/crash/ReportLog:g	[B
    //   269: ifnonnull +250 -> 519
    //   272: aload 8
    //   274: astore_1
    //   275: ldc 222
    //   277: invokevirtual 33	java/lang/String:getBytes	()[B
    //   280: putstatic 39	com/tencent/qqperf/monitor/crash/ReportLog:g	[B
    //   283: goto +236 -> 519
    //   286: aload 8
    //   288: astore_1
    //   289: new 224	KQQ/UploadInfo
    //   292: dup
    //   293: invokespecial 225	KQQ/UploadInfo:<init>	()V
    //   296: astore_3
    //   297: aload 8
    //   299: astore_1
    //   300: aload_3
    //   301: invokestatic 160	com/tencent/common/config/AppSetting:d	()I
    //   304: i2l
    //   305: putfield 229	KQQ/UploadInfo:lAppID	J
    //   308: aload 8
    //   310: astore_1
    //   311: aload_3
    //   312: aload_2
    //   313: invokestatic 235	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   316: putfield 238	KQQ/UploadInfo:lFromMID	J
    //   319: aload 8
    //   321: astore_1
    //   322: aload_3
    //   323: lconst_0
    //   324: putfield 241	KQQ/UploadInfo:lToMID	J
    //   327: aload 8
    //   329: astore_1
    //   330: aload_3
    //   331: iconst_1
    //   332: putfield 245	KQQ/UploadInfo:shType	S
    //   335: aload 8
    //   337: astore_1
    //   338: aload_3
    //   339: getstatic 39	com/tencent/qqperf/monitor/crash/ReportLog:g	[B
    //   342: putfield 248	KQQ/UploadInfo:vSignature	[B
    //   345: aload 8
    //   347: astore_1
    //   348: aload_3
    //   349: invokevirtual 251	KQQ/UploadInfo:toByteArray	()[B
    //   352: astore_2
    //   353: aload 8
    //   355: astore_1
    //   356: new 253	com/tencent/qphone/base/util/Cryptor
    //   359: dup
    //   360: invokespecial 254	com/tencent/qphone/base/util/Cryptor:<init>	()V
    //   363: aload_2
    //   364: getstatic 35	com/tencent/qqperf/monitor/crash/ReportLog:f	[B
    //   367: invokevirtual 258	com/tencent/qphone/base/util/Cryptor:encrypt	([B[B)[B
    //   370: astore_2
    //   371: aload 8
    //   373: astore_1
    //   374: new 260	KQQ/HttpUploadReq
    //   377: dup
    //   378: invokespecial 261	KQQ/HttpUploadReq:<init>	()V
    //   381: astore_3
    //   382: aload 8
    //   384: astore_1
    //   385: aload_3
    //   386: aload_2
    //   387: putfield 264	KQQ/HttpUploadReq:vEncryptUploadInfo	[B
    //   390: aload 8
    //   392: astore_1
    //   393: aload_3
    //   394: aload 9
    //   396: putfield 267	KQQ/HttpUploadReq:vFileData	[B
    //   399: aload 8
    //   401: astore_1
    //   402: new 269	com/tencent/mobileqq/utils/httputils/HttpMsg
    //   405: dup
    //   406: getstatic 71	com/tencent/qqperf/monitor/crash/ReportLog:d	Ljava/lang/String;
    //   409: aload_3
    //   410: invokevirtual 270	KQQ/HttpUploadReq:toByteArray	()[B
    //   413: getstatic 67	com/tencent/qqperf/monitor/crash/ReportLog:k	Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   416: invokespecial 273	com/tencent/mobileqq/utils/httputils/HttpMsg:<init>	(Ljava/lang/String;[BLcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;)V
    //   419: astore_2
    //   420: aload 8
    //   422: astore_1
    //   423: aload_2
    //   424: ldc_w 275
    //   427: invokevirtual 278	com/tencent/mobileqq/utils/httputils/HttpMsg:setRequestMethod	(Ljava/lang/String;)V
    //   430: aload 8
    //   432: astore_1
    //   433: aload_0
    //   434: aload_2
    //   435: invokevirtual 284	com/tencent/mobileqq/transfile/HttpCommunicator:sendMsg	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)I
    //   438: pop
    //   439: aload 8
    //   441: astore_1
    //   442: iconst_0
    //   443: putstatic 37	com/tencent/qqperf/monitor/crash/ReportLog:a	Z
    //   446: return
    //   447: new 143	java/lang/Exception
    //   450: dup
    //   451: ldc_w 286
    //   454: invokespecial 287	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   457: athrow
    //   458: astore_0
    //   459: aload_2
    //   460: astore_1
    //   461: goto +40 -> 501
    //   464: astore_1
    //   465: aload_2
    //   466: astore_0
    //   467: aload_1
    //   468: astore_2
    //   469: goto +11 -> 480
    //   472: astore_0
    //   473: goto +28 -> 501
    //   476: astore_2
    //   477: aload 4
    //   479: astore_0
    //   480: aload_0
    //   481: astore_1
    //   482: aload_2
    //   483: invokevirtual 290	java/lang/Exception:printStackTrace	()V
    //   486: aload_0
    //   487: ifnull +13 -> 500
    //   490: aload_0
    //   491: invokevirtual 217	java/io/BufferedInputStream:close	()V
    //   494: return
    //   495: astore_0
    //   496: aload_0
    //   497: invokevirtual 291	java/io/IOException:printStackTrace	()V
    //   500: return
    //   501: aload_1
    //   502: ifnull +15 -> 517
    //   505: aload_1
    //   506: invokevirtual 217	java/io/BufferedInputStream:close	()V
    //   509: goto +8 -> 517
    //   512: astore_1
    //   513: aload_1
    //   514: invokevirtual 291	java/io/IOException:printStackTrace	()V
    //   517: aload_0
    //   518: athrow
    //   519: aload_3
    //   520: astore_2
    //   521: aload_3
    //   522: ifnonnull -236 -> 286
    //   525: ldc 41
    //   527: astore_2
    //   528: goto -242 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	531	0	paramHttpCommunicator	com.tencent.mobileqq.transfile.HttpCommunicator
    //   0	531	1	paramContext	Context
    //   0	531	2	paramProgressDialog	ProgressDialog
    //   0	531	3	paramString1	String
    //   0	531	4	paramString2	String
    //   203	36	5	m	int
    //   198	47	6	l	long
    //   174	266	8	localObject	Object
    //   212	183	9	arrayOfByte	byte[]
    //   159	99	10	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   234	254	458	finally
    //   447	458	458	finally
    //   234	254	464	java/lang/Exception
    //   447	458	464	java/lang/Exception
    //   186	190	472	finally
    //   193	200	472	finally
    //   208	214	472	finally
    //   217	234	472	finally
    //   257	263	472	finally
    //   266	272	472	finally
    //   275	283	472	finally
    //   289	297	472	finally
    //   300	308	472	finally
    //   311	319	472	finally
    //   322	327	472	finally
    //   330	335	472	finally
    //   338	345	472	finally
    //   348	353	472	finally
    //   356	371	472	finally
    //   374	382	472	finally
    //   385	390	472	finally
    //   393	399	472	finally
    //   402	420	472	finally
    //   423	430	472	finally
    //   433	439	472	finally
    //   442	446	472	finally
    //   482	486	472	finally
    //   186	190	476	java/lang/Exception
    //   193	200	476	java/lang/Exception
    //   208	214	476	java/lang/Exception
    //   217	234	476	java/lang/Exception
    //   257	263	476	java/lang/Exception
    //   266	272	476	java/lang/Exception
    //   275	283	476	java/lang/Exception
    //   289	297	476	java/lang/Exception
    //   300	308	476	java/lang/Exception
    //   311	319	476	java/lang/Exception
    //   322	327	476	java/lang/Exception
    //   330	335	476	java/lang/Exception
    //   338	345	476	java/lang/Exception
    //   348	353	476	java/lang/Exception
    //   356	371	476	java/lang/Exception
    //   374	382	476	java/lang/Exception
    //   385	390	476	java/lang/Exception
    //   393	399	476	java/lang/Exception
    //   402	420	476	java/lang/Exception
    //   423	430	476	java/lang/Exception
    //   433	439	476	java/lang/Exception
    //   442	446	476	java/lang/Exception
    //   490	494	495	java/io/IOException
    //   505	509	512	java/io/IOException
  }
  
  public static void a(String paramString)
  {
    h = paramString;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!e) {
      return;
    }
    if (a) {
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
      int i1;
      int m;
      int i3;
      try
      {
        Object localObject3 = ((SharedPreferences)localObject2).getString("key_not_exit_crash_type", null);
        localObject2 = ((SharedPreferences)localObject2).getString("key_not_exit_crash_stack", null);
        if ((localObject3 == null) || (TextUtils.isEmpty((CharSequence)localObject1))) {
          break label370;
        }
        localObject3 = ((String)localObject3).split("\\|");
        i2 = localObject3.length;
        i1 = 0;
        m = 0;
        n = m;
        if (i1 < i2)
        {
          CharSequence localCharSequence = localObject3[i1];
          if (!((String)localObject1).contains(localCharSequence)) {
            break label361;
          }
          QLog.d("ReportLog", 1, new Object[] { "exMsg = ", localObject1, ",crash = ", localCharSequence });
          m = 1;
          break label361;
        }
        if (localObject2 != null)
        {
          localObject1 = ((String)localObject2).split("\\|");
          paramThrowable = paramThrowable.getStackTrace();
          i3 = paramThrowable.length;
          i1 = 0;
          m = 0;
          break label375;
          localObject2 = ((StackTraceElement)localObject2).toString();
          int i4 = localObject1.length;
          i2 = 0;
          if (i2 < i4)
          {
            localObject3 = localObject1[i2];
            if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (((String)localObject2).contains((CharSequence)localObject3)))
            {
              QLog.d("ReportLog", 1, new Object[] { "stackElemStr = ", localObject2, ",crash = ", localObject3 });
              m = 1;
            }
            else
            {
              i2 += 1;
              continue;
            }
          }
          i1 += 1;
          break label375;
        }
        i2 = 0;
        boolean bool1 = bool2;
        if (i2 != 0)
        {
          bool1 = bool2;
          if (n != 0) {
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
      i1 += 1;
      continue;
      label370:
      int n = 0;
      continue;
      label375:
      int i2 = m;
      if (i1 < i3)
      {
        localObject2 = paramThrowable[i1];
        if (m != 0) {
          i2 = m;
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
      SafeModeUtil.a(HardCodeUtil.a(2131910891));
      QQCrashReportManager.i = true;
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
      ReportLogHelper.a = paramThread.getPackageManager().getPackageInfo(paramThread.getPackageName(), 0).versionName;
      ReportLogHelper.b = Build.MODEL;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.monitor.crash.ReportLog
 * JD-Core Version:    0.7.0.1
 */