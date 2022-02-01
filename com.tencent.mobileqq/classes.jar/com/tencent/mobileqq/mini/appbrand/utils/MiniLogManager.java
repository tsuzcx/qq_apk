package com.tencent.mobileqq.mini.appbrand.utils;

import Wallet.GetMiniAppReq;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
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
  private static Handler mHandler;
  private static final BroadcastReceiver mReceiver;
  private static long sLastCheckLogTime = 0L;
  private static SimpleDateFormat timeFormatter = new SimpleDateFormat("yy-MM-dd HH_mm_ss");
  
  static
  {
    mHandler = new MiniLogManager.1(Looper.getMainLooper());
    mReceiver = new MiniLogManager.2();
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
    if ((StringUtil.a(paramString1)) || (StringUtil.a(paramString2))) {
      return;
    }
    ThreadManager.excute(new MiniLogManager.7(paramString1, paramString2), 128, null, false);
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
    String str = paramFile.getAbsolutePath();
    paramFile = str;
    if (str.endsWith(".log")) {
      paramFile = str.substring(0, str.indexOf(".log"));
    }
    return paramFile + ".qlog";
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
    if ((StringUtil.a(paramString1)) || (StringUtil.a(paramString2)) || (!new File(paramString2).exists())) {
      return;
    }
    QWalletCommonServlet.a(new GetMiniAppReq(paramString1, paramInt2, paramInt1, "", BaseApplicationImpl.getApplication().getRuntime().getAccount(), "Android|" + DeviceInfoUtil.e() + "|" + DeviceInfoUtil.i(), DeviceInfoUtil.c()), new MiniLogManager.6(paramString2, paramInt1));
  }
  
  /* Error */
  public static void zipFiles(java.util.ArrayList<MiniLogManager.LogFile> paramArrayList, String paramString)
  {
    // Byte code:
    //   0: new 307	java/io/BufferedOutputStream
    //   3: dup
    //   4: new 309	java/io/FileOutputStream
    //   7: dup
    //   8: new 186	java/io/File
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 252	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: invokespecial 312	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   19: invokespecial 315	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_1
    //   23: new 317	java/util/zip/ZipOutputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 318	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore 11
    //   33: iconst_0
    //   34: istore_2
    //   35: aload_0
    //   36: invokevirtual 324	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   39: astore_0
    //   40: aload_0
    //   41: invokeinterface 329 1 0
    //   46: ifeq +258 -> 304
    //   49: aload_0
    //   50: invokeinterface 333 1 0
    //   55: checkcast 335	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile
    //   58: astore 12
    //   60: aload 12
    //   62: invokevirtual 336	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile:exists	()Z
    //   65: ifeq +318 -> 383
    //   68: aload 11
    //   70: new 338	java/util/zip/ZipEntry
    //   73: dup
    //   74: new 206	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   81: aload 12
    //   83: invokevirtual 341	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile:getName	()Ljava/lang/String;
    //   86: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 12
    //   91: getfield 344	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile:stuffix	Ljava/lang/String;
    //   94: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokespecial 345	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   103: invokevirtual 349	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   106: aload 11
    //   108: bipush 9
    //   110: invokevirtual 353	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   113: aload 12
    //   115: invokevirtual 356	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager$LogFile:length	()J
    //   118: lstore 9
    //   120: new 358	java/io/FileInputStream
    //   123: dup
    //   124: aload 12
    //   126: invokespecial 359	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   129: astore 12
    //   131: sipush 20480
    //   134: newarray byte
    //   136: astore 13
    //   138: lconst_0
    //   139: lstore 5
    //   141: aload 12
    //   143: aload 13
    //   145: iconst_0
    //   146: sipush 20480
    //   149: invokevirtual 363	java/io/FileInputStream:read	([BII)I
    //   152: istore 4
    //   154: iload 4
    //   156: iconst_m1
    //   157: if_icmpeq +39 -> 196
    //   160: aload 11
    //   162: aload 13
    //   164: iconst_0
    //   165: iload 4
    //   167: invokevirtual 367	java/util/zip/ZipOutputStream:write	([BII)V
    //   170: iconst_1
    //   171: istore_3
    //   172: iconst_1
    //   173: istore_2
    //   174: lload 5
    //   176: iload 4
    //   178: i2l
    //   179: ladd
    //   180: lstore 7
    //   182: lload 7
    //   184: lstore 5
    //   186: lload 7
    //   188: lload 9
    //   190: lcmp
    //   191: iflt -50 -> 141
    //   194: iload_3
    //   195: istore_2
    //   196: aload 12
    //   198: invokevirtual 370	java/io/FileInputStream:close	()V
    //   201: aload 11
    //   203: invokevirtual 373	java/util/zip/ZipOutputStream:flush	()V
    //   206: aload 11
    //   208: invokevirtual 376	java/util/zip/ZipOutputStream:closeEntry	()V
    //   211: goto +172 -> 383
    //   214: astore_0
    //   215: aload 12
    //   217: invokevirtual 370	java/io/FileInputStream:close	()V
    //   220: aload 11
    //   222: invokevirtual 373	java/util/zip/ZipOutputStream:flush	()V
    //   225: aload 11
    //   227: invokevirtual 376	java/util/zip/ZipOutputStream:closeEntry	()V
    //   230: aload_0
    //   231: athrow
    //   232: astore_0
    //   233: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   236: ifeq +31 -> 267
    //   239: getstatic 39	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager:TAG	Ljava/lang/String;
    //   242: iconst_2
    //   243: new 206	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 207	java/lang/StringBuilder:<init>	()V
    //   250: ldc_w 378
    //   253: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: aload_0
    //   257: invokevirtual 381	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 216	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: aload_0
    //   264: invokestatic 384	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   267: aload_1
    //   268: invokevirtual 385	java/io/BufferedOutputStream:close	()V
    //   271: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   274: ifeq +13 -> 287
    //   277: getstatic 39	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager:TAG	Ljava/lang/String;
    //   280: iconst_2
    //   281: ldc_w 387
    //   284: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   290: ifeq +13 -> 303
    //   293: getstatic 39	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager:TAG	Ljava/lang/String;
    //   296: iconst_2
    //   297: ldc_w 389
    //   300: invokestatic 391	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: return
    //   304: iload_2
    //   305: ifeq +8 -> 313
    //   308: aload 11
    //   310: invokevirtual 392	java/util/zip/ZipOutputStream:close	()V
    //   313: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   316: ifeq +13 -> 329
    //   319: getstatic 39	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager:TAG	Ljava/lang/String;
    //   322: iconst_2
    //   323: ldc_w 394
    //   326: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: aload_1
    //   330: invokevirtual 385	java/io/BufferedOutputStream:close	()V
    //   333: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   336: ifeq -49 -> 287
    //   339: getstatic 39	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager:TAG	Ljava/lang/String;
    //   342: iconst_2
    //   343: ldc_w 387
    //   346: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: goto -62 -> 287
    //   352: astore_0
    //   353: aload_0
    //   354: invokevirtual 397	java/io/IOException:printStackTrace	()V
    //   357: goto -70 -> 287
    //   360: astore_0
    //   361: aload_1
    //   362: invokevirtual 385	java/io/BufferedOutputStream:close	()V
    //   365: invokestatic 243	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   368: ifeq +13 -> 381
    //   371: getstatic 39	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager:TAG	Ljava/lang/String;
    //   374: iconst_2
    //   375: ldc_w 387
    //   378: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: aload_0
    //   382: athrow
    //   383: goto -343 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	paramArrayList	java.util.ArrayList<MiniLogManager.LogFile>
    //   0	386	1	paramString	String
    //   34	271	2	i	int
    //   171	24	3	j	int
    //   152	25	4	k	int
    //   139	46	5	l1	long
    //   180	7	7	l2	long
    //   118	71	9	l3	long
    //   31	278	11	localZipOutputStream	java.util.zip.ZipOutputStream
    //   58	158	12	localObject	Object
    //   136	27	13	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   131	138	214	finally
    //   141	154	214	finally
    //   160	170	214	finally
    //   35	40	232	java/io/IOException
    //   40	131	232	java/io/IOException
    //   196	211	232	java/io/IOException
    //   215	232	232	java/io/IOException
    //   308	313	232	java/io/IOException
    //   313	329	232	java/io/IOException
    //   0	33	352	java/io/IOException
    //   267	287	352	java/io/IOException
    //   329	349	352	java/io/IOException
    //   361	381	352	java/io/IOException
    //   381	383	352	java/io/IOException
    //   35	40	360	finally
    //   40	131	360	finally
    //   196	211	360	finally
    //   215	232	360	finally
    //   233	267	360	finally
    //   308	313	360	finally
    //   313	329	360	finally
  }
  
  /* Error */
  private static boolean zipLogFile(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_0
    //   7: istore_3
    //   8: new 307	java/io/BufferedOutputStream
    //   11: dup
    //   12: new 309	java/io/FileOutputStream
    //   15: dup
    //   16: new 186	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: invokestatic 405	com/tencent/mobileqq/mini/appbrand/utils/MiniLogManager:getZipLogFilePath	(Ljava/io/File;)Ljava/lang/String;
    //   24: invokespecial 252	java/io/File:<init>	(Ljava/lang/String;)V
    //   27: invokespecial 312	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   30: invokespecial 315	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   33: astore 4
    //   35: new 317	java/util/zip/ZipOutputStream
    //   38: dup
    //   39: aload 4
    //   41: invokespecial 318	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   44: astore 6
    //   46: aload 6
    //   48: bipush 9
    //   50: invokevirtual 353	java/util/zip/ZipOutputStream:setLevel	(I)V
    //   53: sipush 8192
    //   56: newarray byte
    //   58: astore 7
    //   60: new 338	java/util/zip/ZipEntry
    //   63: dup
    //   64: aload_0
    //   65: invokevirtual 406	java/io/File:getName	()Ljava/lang/String;
    //   68: invokespecial 345	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   71: astore 8
    //   73: aload 8
    //   75: aload_0
    //   76: invokevirtual 407	java/io/File:length	()J
    //   79: invokevirtual 410	java/util/zip/ZipEntry:setSize	(J)V
    //   82: aload 8
    //   84: aload_0
    //   85: invokevirtual 413	java/io/File:lastModified	()J
    //   88: invokevirtual 416	java/util/zip/ZipEntry:setTime	(J)V
    //   91: aload 6
    //   93: aload 8
    //   95: invokevirtual 349	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   98: new 418	java/io/BufferedInputStream
    //   101: dup
    //   102: new 358	java/io/FileInputStream
    //   105: dup
    //   106: aload_0
    //   107: invokespecial 359	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   110: invokespecial 421	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   113: astore_0
    //   114: aload_0
    //   115: aload 7
    //   117: iconst_0
    //   118: sipush 8192
    //   121: invokevirtual 424	java/io/InputStream:read	([BII)I
    //   124: istore_1
    //   125: iload_1
    //   126: iconst_m1
    //   127: if_icmpeq +46 -> 173
    //   130: aload 6
    //   132: aload 7
    //   134: iconst_0
    //   135: iload_1
    //   136: invokevirtual 367	java/util/zip/ZipOutputStream:write	([BII)V
    //   139: goto -25 -> 114
    //   142: astore 5
    //   144: aload 5
    //   146: invokevirtual 425	java/lang/Exception:printStackTrace	()V
    //   149: aload 4
    //   151: ifnull +8 -> 159
    //   154: aload 4
    //   156: invokevirtual 385	java/io/BufferedOutputStream:close	()V
    //   159: iload_3
    //   160: istore_2
    //   161: aload_0
    //   162: ifnull +9 -> 171
    //   165: aload_0
    //   166: invokevirtual 426	java/io/InputStream:close	()V
    //   169: iload_3
    //   170: istore_2
    //   171: iload_2
    //   172: ireturn
    //   173: aload 6
    //   175: invokevirtual 392	java/util/zip/ZipOutputStream:close	()V
    //   178: iconst_1
    //   179: istore_2
    //   180: aload 4
    //   182: ifnull +8 -> 190
    //   185: aload 4
    //   187: invokevirtual 385	java/io/BufferedOutputStream:close	()V
    //   190: aload_0
    //   191: ifnull -20 -> 171
    //   194: aload_0
    //   195: invokevirtual 426	java/io/InputStream:close	()V
    //   198: iconst_1
    //   199: ireturn
    //   200: astore_0
    //   201: aload_0
    //   202: invokevirtual 427	java/lang/Throwable:printStackTrace	()V
    //   205: iconst_1
    //   206: ireturn
    //   207: astore_0
    //   208: aload_0
    //   209: invokevirtual 427	java/lang/Throwable:printStackTrace	()V
    //   212: iconst_0
    //   213: ireturn
    //   214: astore_0
    //   215: aconst_null
    //   216: astore 4
    //   218: aload 4
    //   220: ifnull +8 -> 228
    //   223: aload 4
    //   225: invokevirtual 385	java/io/BufferedOutputStream:close	()V
    //   228: aload 5
    //   230: ifnull +8 -> 238
    //   233: aload 5
    //   235: invokevirtual 426	java/io/InputStream:close	()V
    //   238: aload_0
    //   239: athrow
    //   240: astore 4
    //   242: aload 4
    //   244: invokevirtual 427	java/lang/Throwable:printStackTrace	()V
    //   247: goto -9 -> 238
    //   250: astore_0
    //   251: goto -33 -> 218
    //   254: astore 6
    //   256: aload_0
    //   257: astore 5
    //   259: aload 6
    //   261: astore_0
    //   262: goto -44 -> 218
    //   265: astore 6
    //   267: aload_0
    //   268: astore 5
    //   270: aload 6
    //   272: astore_0
    //   273: goto -55 -> 218
    //   276: astore 5
    //   278: aconst_null
    //   279: astore_0
    //   280: aload 6
    //   282: astore 4
    //   284: goto -140 -> 144
    //   287: astore 5
    //   289: aconst_null
    //   290: astore_0
    //   291: goto -147 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	paramFile	File
    //   124	12	1	i	int
    //   160	20	2	bool1	boolean
    //   7	163	3	bool2	boolean
    //   33	191	4	localBufferedOutputStream	java.io.BufferedOutputStream
    //   240	3	4	localThrowable	java.lang.Throwable
    //   282	1	4	localObject1	Object
    //   1	1	5	localObject2	Object
    //   142	92	5	localException1	java.lang.Exception
    //   257	12	5	localFile	File
    //   276	1	5	localException2	java.lang.Exception
    //   287	1	5	localException3	java.lang.Exception
    //   4	170	6	localZipOutputStream	java.util.zip.ZipOutputStream
    //   254	6	6	localObject3	Object
    //   265	16	6	localObject4	Object
    //   58	75	7	arrayOfByte	byte[]
    //   71	23	8	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   114	125	142	java/lang/Exception
    //   130	139	142	java/lang/Exception
    //   173	178	142	java/lang/Exception
    //   185	190	200	java/lang/Throwable
    //   194	198	200	java/lang/Throwable
    //   154	159	207	java/lang/Throwable
    //   165	169	207	java/lang/Throwable
    //   8	35	214	finally
    //   223	228	240	java/lang/Throwable
    //   233	238	240	java/lang/Throwable
    //   35	114	250	finally
    //   114	125	254	finally
    //   130	139	254	finally
    //   173	178	254	finally
    //   144	149	265	finally
    //   8	35	276	java/lang/Exception
    //   35	114	287	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.utils.MiniLogManager
 * JD-Core Version:    0.7.0.1
 */