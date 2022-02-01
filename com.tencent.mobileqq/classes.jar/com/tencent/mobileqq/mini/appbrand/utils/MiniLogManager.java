package com.tencent.mobileqq.mini.appbrand.utils;

import Wallet.GetMiniAppReq;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import mqq.app.AppRuntime;

public class MiniLogManager
{
  private static final int LEVEL_COMPRESS_LOG = 9;
  private static final int LOG_SAVE_DAY = 1;
  private static final int MSG_COMPRESS_LOG = 4;
  private static String TAG = "MiniLogManager";
  private static final long TIME_ONE_HOUR = 3600000L;
  private static final long TIME_ONE_MINUTE = 60000L;
  private static Comparator<File> fileTimeComparator = new MiniLogManager.4();
  private static boolean isInited;
  private static SimpleDateFormat logFileFormatter = new SimpleDateFormat("yy.MM.dd.HH");
  private static Handler mHandler = new MiniLogManager.1(Looper.getMainLooper());
  private static final BroadcastReceiver mReceiver = new MiniLogManager.2();
  private static long sLastCheckLogTime;
  private static SimpleDateFormat timeFormatter = new SimpleDateFormat("yy-MM-dd HH_mm_ss");
  
  static
  {
    isInited = false;
  }
  
  public static void compressAndDeleteOldLog()
  {
    ThreadManagerV2.executeOnFileThread(new MiniLogManager.3());
  }
  
  public static void compressAndUploadLog(String paramString, int paramInt)
  {
    if (StringUtil.a(paramString)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new MiniLogManager.5(MiniLog.getMiniLogFolderPath(paramString), paramString, paramInt));
  }
  
  private static void doUploadFile(String paramString1, String paramString2)
  {
    if (!StringUtil.a(paramString1))
    {
      if (StringUtil.a(paramString2)) {
        return;
      }
      ThreadManager.excute(new MiniLogManager.7(paramString1, paramString2), 128, null, false);
    }
  }
  
  private static String getLastHourLogSuffix()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(System.currentTimeMillis() - 3600000L);
    return logFileFormatter.format(localCalendar.getTime());
  }
  
  private static long getOneDayAgoTime()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.add(6, -1);
    return localCalendar.getTimeInMillis();
  }
  
  private static String getZipLogFilePath(File paramFile)
  {
    Object localObject = paramFile.getAbsolutePath();
    paramFile = (File)localObject;
    if (((String)localObject).endsWith(".log")) {
      paramFile = ((String)localObject).substring(0, ((String)localObject).indexOf(".log"));
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramFile);
    ((StringBuilder)localObject).append(".qlog");
    return ((StringBuilder)localObject).toString();
  }
  
  public static void init()
  {
    try
    {
      if (!isInited)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.SCREEN_ON");
        localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
        BaseApplication.getContext().registerReceiver(mReceiver, localIntentFilter);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "MiniLogManager inited.");
        }
        isInited = true;
      }
      return;
    }
    finally {}
  }
  
  public static void upload(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((!StringUtil.a(paramString1)) && (!StringUtil.a(paramString2)))
    {
      if (!new File(paramString2).exists()) {
        return;
      }
      String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Android|");
      localStringBuilder.append(DeviceInfoUtil.e());
      localStringBuilder.append("|");
      localStringBuilder.append(DeviceInfoUtil.i());
      paramString1 = new GetMiniAppReq(paramString1, paramInt2, paramInt1, "", str, localStringBuilder.toString(), DeviceInfoUtil.c());
      ((IQWalletApi)QRoute.api(IQWalletApi.class)).servletSendRequest(paramString1, new MiniLogManager.6(paramString2, paramInt1));
    }
  }
  
  /* Error */
  public static void zipFiles(java.util.ArrayList<MiniLogManager.LogFile> paramArrayList, String paramString)
  {
    // Byte code:
    //   0: new 314	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 316	java/io/FileOutputStream
    //   7: dup
    //   8: new 186	java/io/File
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 252	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: invokespecial 319	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   19: invokespecial 322	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_1
    //   23: new 324	java/util/zip/ZipOutputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 325	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore 11
    //   33: aload_0
    //   34: invokevirtual 331	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   37: astore_0
    //   38: iconst_0
    //   39: istore_2
    //   40: aload_0
    //   41: invokeinterface 336 1 0
    //   46: ifeq +196 -> 242
    //   49: aload_0
    //   50: invokeinterface 340 1 0
    //   55: checkcast 342	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile
    //   58: astore 12
    //   60: aload 12
    //   62: invokevirtual 343	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile:exists	()Z
    //   65: ifeq -25 -> 40
    //   68: new 206	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   75: astore 13
    //   77: aload 13
    //   79: aload 12
    //   81: invokevirtual 346	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile:getName	()Ljava/lang/String;
    //   84: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 13
    //   90: aload 12
    //   92: getfield 349	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile:stuffix	Ljava/lang/String;
    //   95: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 11
    //   101: new 351	java/util/zip/ZipEntry
    //   104: dup
    //   105: aload 13
    //   107: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokespecial 352	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   113: invokevirtual 356	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   116: aload 11
    //   118: bipush 9
    //   120: invokevirtual 360	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   123: aload 12
    //   125: invokevirtual 363	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile:length	()J
    //   128: lstore 9
    //   130: new 365	java/io/FileInputStream
    //   133: dup
    //   134: aload 12
    //   136: invokespecial 366	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   139: astore 12
    //   141: sipush 20480
    //   144: newarray byte
    //   146: astore 13
    //   148: lconst_0
    //   149: lstore 5
    //   151: aload 12
    //   153: aload 13
    //   155: iconst_0
    //   156: sipush 20480
    //   159: invokevirtual 370	java/io/FileInputStream:read	([BII)I
    //   162: istore 4
    //   164: iload 4
    //   166: iconst_m1
    //   167: if_icmpeq +39 -> 206
    //   170: aload 11
    //   172: aload 13
    //   174: iconst_0
    //   175: iload 4
    //   177: invokevirtual 374	java/util/zip/ZipOutputStream:write	([BII)V
    //   180: iconst_1
    //   181: istore_3
    //   182: iconst_1
    //   183: istore_2
    //   184: lload 5
    //   186: iload 4
    //   188: i2l
    //   189: ladd
    //   190: lstore 7
    //   192: lload 7
    //   194: lstore 5
    //   196: lload 7
    //   198: lload 9
    //   200: lcmp
    //   201: iflt -50 -> 151
    //   204: iload_3
    //   205: istore_2
    //   206: aload 12
    //   208: invokevirtual 377	java/io/FileInputStream:close	()V
    //   211: aload 11
    //   213: invokevirtual 380	java/util/zip/ZipOutputStream:flush	()V
    //   216: aload 11
    //   218: invokevirtual 383	java/util/zip/ZipOutputStream:closeEntry	()V
    //   221: goto -181 -> 40
    //   224: astore_0
    //   225: aload 12
    //   227: invokevirtual 377	java/io/FileInputStream:close	()V
    //   230: aload 11
    //   232: invokevirtual 380	java/util/zip/ZipOutputStream:flush	()V
    //   235: aload 11
    //   237: invokevirtual 383	java/util/zip/ZipOutputStream:closeEntry	()V
    //   240: aload_0
    //   241: athrow
    //   242: iload_2
    //   243: ifeq +8 -> 251
    //   246: aload 11
    //   248: invokevirtual 384	java/util/zip/ZipOutputStream:close	()V
    //   251: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   254: ifeq +13 -> 267
    //   257: getstatic 89	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager:TAG	Ljava/lang/String;
    //   260: iconst_2
    //   261: ldc_w 386
    //   264: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: aload_1
    //   268: invokevirtual 387	java/io/BufferedOutputStream:close	()V
    //   271: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq +115 -> 389
    //   277: getstatic 89	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager:TAG	Ljava/lang/String;
    //   280: astore_0
    //   281: aload_0
    //   282: iconst_2
    //   283: ldc_w 389
    //   286: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: goto +100 -> 389
    //   292: astore_0
    //   293: goto +69 -> 362
    //   296: astore_0
    //   297: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq +45 -> 345
    //   303: getstatic 89	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager:TAG	Ljava/lang/String;
    //   306: astore 11
    //   308: new 206	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   315: astore 12
    //   317: aload 12
    //   319: ldc_w 391
    //   322: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: pop
    //   326: aload 12
    //   328: aload_0
    //   329: invokevirtual 394	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: aload 11
    //   335: iconst_2
    //   336: aload 12
    //   338: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: aload_0
    //   342: invokestatic 397	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   345: aload_1
    //   346: invokevirtual 387	java/io/BufferedOutputStream:close	()V
    //   349: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   352: ifeq +37 -> 389
    //   355: getstatic 89	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager:TAG	Ljava/lang/String;
    //   358: astore_0
    //   359: goto -78 -> 281
    //   362: aload_1
    //   363: invokevirtual 387	java/io/BufferedOutputStream:close	()V
    //   366: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   369: ifeq +13 -> 382
    //   372: getstatic 89	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager:TAG	Ljava/lang/String;
    //   375: iconst_2
    //   376: ldc_w 389
    //   379: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   382: aload_0
    //   383: athrow
    //   384: astore_0
    //   385: aload_0
    //   386: invokevirtual 400	java/io/IOException:printStackTrace	()V
    //   389: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   392: ifeq +13 -> 405
    //   395: getstatic 89	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager:TAG	Ljava/lang/String;
    //   398: iconst_2
    //   399: ldc_w 402
    //   402: invokestatic 404	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   405: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	406	0	paramArrayList	java.util.ArrayList<MiniLogManager.LogFile>
    //   0	406	1	paramString	String
    //   39	204	2	i	int
    //   181	24	3	j	int
    //   162	25	4	k	int
    //   149	46	5	l1	long
    //   190	7	7	l2	long
    //   128	71	9	l3	long
    //   31	303	11	localObject1	Object
    //   58	279	12	localObject2	Object
    //   75	98	13	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   141	148	224	finally
    //   151	164	224	finally
    //   170	180	224	finally
    //   33	38	292	finally
    //   40	141	292	finally
    //   206	221	292	finally
    //   225	242	292	finally
    //   246	251	292	finally
    //   251	267	292	finally
    //   297	345	292	finally
    //   33	38	296	java/io/IOException
    //   40	141	296	java/io/IOException
    //   206	221	296	java/io/IOException
    //   225	242	296	java/io/IOException
    //   246	251	296	java/io/IOException
    //   251	267	296	java/io/IOException
    //   0	33	384	java/io/IOException
    //   267	281	384	java/io/IOException
    //   281	289	384	java/io/IOException
    //   345	359	384	java/io/IOException
    //   362	382	384	java/io/IOException
    //   382	384	384	java/io/IOException
  }
  
  /* Error */
  private static boolean zipLogFile(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 314	java/io/BufferedOutputStream
    //   8: dup
    //   9: new 316	java/io/FileOutputStream
    //   12: dup
    //   13: new 186	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: invokestatic 412	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager:getZipLogFilePath	(Ljava/io/File;)Ljava/lang/String;
    //   21: invokespecial 252	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: invokespecial 319	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   27: invokespecial 322	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   30: astore_2
    //   31: new 324	java/util/zip/ZipOutputStream
    //   34: dup
    //   35: aload_2
    //   36: invokespecial 325	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   39: astore 4
    //   41: aload 4
    //   43: bipush 9
    //   45: invokevirtual 360	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   48: sipush 8192
    //   51: newarray byte
    //   53: astore 5
    //   55: new 351	java/util/zip/ZipEntry
    //   58: dup
    //   59: aload_0
    //   60: invokevirtual 413	java/io/File:getName	()Ljava/lang/String;
    //   63: invokespecial 352	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   66: astore 6
    //   68: aload 6
    //   70: aload_0
    //   71: invokevirtual 414	java/io/File:length	()J
    //   74: invokevirtual 417	java/util/zip/ZipEntry:setSize	(J)V
    //   77: aload 6
    //   79: aload_0
    //   80: invokevirtual 420	java/io/File:lastModified	()J
    //   83: invokevirtual 423	java/util/zip/ZipEntry:setTime	(J)V
    //   86: aload 4
    //   88: aload 6
    //   90: invokevirtual 356	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   93: new 425	java/io/BufferedInputStream
    //   96: dup
    //   97: new 365	java/io/FileInputStream
    //   100: dup
    //   101: aload_0
    //   102: invokespecial 366	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   105: invokespecial 428	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   108: astore_0
    //   109: aload_0
    //   110: aload 5
    //   112: iconst_0
    //   113: sipush 8192
    //   116: invokevirtual 431	java/io/InputStream:read	([BII)I
    //   119: istore_1
    //   120: iload_1
    //   121: iconst_m1
    //   122: if_icmpeq +15 -> 137
    //   125: aload 4
    //   127: aload 5
    //   129: iconst_0
    //   130: iload_1
    //   131: invokevirtual 374	java/util/zip/ZipOutputStream:write	([BII)V
    //   134: goto -25 -> 109
    //   137: aload 4
    //   139: invokevirtual 384	java/util/zip/ZipOutputStream:close	()V
    //   142: aload_2
    //   143: invokevirtual 387	java/io/BufferedOutputStream:close	()V
    //   146: aload_0
    //   147: invokevirtual 432	java/io/InputStream:close	()V
    //   150: iconst_1
    //   151: ireturn
    //   152: astore_0
    //   153: aload_0
    //   154: invokevirtual 433	java/lang/Throwable:printStackTrace	()V
    //   157: iconst_1
    //   158: ireturn
    //   159: astore_3
    //   160: goto +73 -> 233
    //   163: astore_3
    //   164: goto +16 -> 180
    //   167: astore 4
    //   169: aload_3
    //   170: astore_0
    //   171: aload 4
    //   173: astore_3
    //   174: goto +59 -> 233
    //   177: astore_3
    //   178: aconst_null
    //   179: astore_0
    //   180: goto +21 -> 201
    //   183: astore 4
    //   185: aconst_null
    //   186: astore_2
    //   187: aload_3
    //   188: astore_0
    //   189: aload 4
    //   191: astore_3
    //   192: goto +41 -> 233
    //   195: astore_3
    //   196: aconst_null
    //   197: astore_0
    //   198: aload 4
    //   200: astore_2
    //   201: aload_3
    //   202: invokevirtual 434	java/lang/Exception:printStackTrace	()V
    //   205: aload_2
    //   206: ifnull +10 -> 216
    //   209: aload_2
    //   210: invokevirtual 387	java/io/BufferedOutputStream:close	()V
    //   213: goto +3 -> 216
    //   216: aload_0
    //   217: ifnull +13 -> 230
    //   220: aload_0
    //   221: invokevirtual 432	java/io/InputStream:close	()V
    //   224: iconst_0
    //   225: ireturn
    //   226: aload_0
    //   227: invokevirtual 433	java/lang/Throwable:printStackTrace	()V
    //   230: iconst_0
    //   231: ireturn
    //   232: astore_3
    //   233: aload_2
    //   234: ifnull +10 -> 244
    //   237: aload_2
    //   238: invokevirtual 387	java/io/BufferedOutputStream:close	()V
    //   241: goto +3 -> 244
    //   244: aload_0
    //   245: ifnull +14 -> 259
    //   248: aload_0
    //   249: invokevirtual 432	java/io/InputStream:close	()V
    //   252: goto +7 -> 259
    //   255: aload_0
    //   256: invokevirtual 433	java/lang/Throwable:printStackTrace	()V
    //   259: goto +5 -> 264
    //   262: aload_3
    //   263: athrow
    //   264: goto -2 -> 262
    //   267: astore_0
    //   268: goto -42 -> 226
    //   271: astore_0
    //   272: goto -17 -> 255
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	paramFile	File
    //   119	12	1	i	int
    //   30	208	2	localObject1	Object
    //   1	1	3	localObject2	Object
    //   159	1	3	localObject3	Object
    //   163	7	3	localException1	java.lang.Exception
    //   173	1	3	localObject4	Object
    //   177	11	3	localException2	java.lang.Exception
    //   191	1	3	localObject5	Object
    //   195	7	3	localException3	java.lang.Exception
    //   232	31	3	localObject6	Object
    //   3	135	4	localZipOutputStream	java.util.zip.ZipOutputStream
    //   167	5	4	localObject7	Object
    //   183	16	4	localObject8	Object
    //   53	75	5	arrayOfByte	byte[]
    //   66	23	6	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   142	150	152	java/lang/Throwable
    //   109	120	159	finally
    //   125	134	159	finally
    //   137	142	159	finally
    //   109	120	163	java/lang/Exception
    //   125	134	163	java/lang/Exception
    //   137	142	163	java/lang/Exception
    //   31	109	167	finally
    //   31	109	177	java/lang/Exception
    //   5	31	183	finally
    //   5	31	195	java/lang/Exception
    //   201	205	232	finally
    //   209	213	267	java/lang/Throwable
    //   220	224	267	java/lang/Throwable
    //   237	241	271	java/lang/Throwable
    //   248	252	271	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager
 * JD-Core Version:    0.7.0.1
 */