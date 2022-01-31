package com.tencent.mobileqq.shortvideo;

import actn;
import ajsf;
import amfw;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.text.format.Formatter;
import axdq;
import axlv;
import axpn;
import axpo;
import axqw;
import aywk;
import azaa;
import bbdj;
import bfni;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import ssi;
import swf;

public class ShortVideoUtils
  implements axdq
{
  private static int jdField_a_of_type_Int;
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  public static boolean a;
  private static int[] jdField_a_of_type_ArrayOfInt;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "GT-N7108" };
  private static int b;
  public static boolean b;
  private static final String c;
  public static boolean c;
  public static boolean d;
  public static boolean e;
  public static boolean f;
  private static volatile boolean g;
  private static boolean h;
  private static boolean i;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = true;
    h = true;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    jdField_a_of_type_Int = 2;
    jdField_b_of_type_Int = 1;
    jdField_a_of_type_ArrayOfInt = new int[] { 1, 97, 125 };
    ThreadManager.getSubThreadHandler().post(new ShortVideoUtils.1());
    jdField_c_of_type_JavaLangString = azaa.a(ajsf.aW);
  }
  
  public static int a()
  {
    if (!d)
    {
      b();
      d = true;
    }
    return jdField_a_of_type_Int;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {
      return paramInt2;
    }
    if (paramInt1 >= 100) {
      return 100;
    }
    return (int)((100 - paramInt2) * paramInt1 / 100.0F + paramInt2);
  }
  
  public static int a(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).getInt("short_video_hotpic_cfg_version_" + paramString, 0);
  }
  
  public static long a(String paramString)
  {
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUtils", 2, "Path:" + paramString + ", not exits!");
      }
      return -1L;
    }
    MediaPlayer localMediaPlayer = new MediaPlayer();
    try
    {
      localMediaPlayer.setDataSource(paramString);
      localMediaPlayer.prepare();
      int j = localMediaPlayer.getDuration();
      long l = j;
      return l;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "getDuration", paramString);
      }
      return -1L;
    }
    finally
    {
      localMediaPlayer.release();
    }
  }
  
  public static SharedPreferences a()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("short_video_ptu_template_sdk_sp_" + BaseApplicationImpl.sProcessId, 0);
  }
  
  public static SharedPreferences a(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences(paramString + "_" + BaseApplicationImpl.sProcessId, 0);
  }
  
  @TargetApi(10)
  public static Bitmap a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, 640);
  }
  
  @TargetApi(10)
  public static Bitmap a(Context paramContext, String paramString, int paramInt)
  {
    return a(paramContext, paramString, paramInt, -1L);
  }
  
  /* Error */
  @TargetApi(10)
  public static Bitmap a(Context paramContext, String paramString, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 12
    //   6: iload_2
    //   7: istore 6
    //   9: iload_2
    //   10: ifgt +8 -> 18
    //   13: sipush 640
    //   16: istore 6
    //   18: invokestatic 203	java/lang/System:currentTimeMillis	()J
    //   21: lstore 9
    //   23: new 205	android/media/MediaMetadataRetriever
    //   26: dup
    //   27: invokespecial 206	android/media/MediaMetadataRetriever:<init>	()V
    //   30: astore 13
    //   32: aload 13
    //   34: aload_1
    //   35: invokevirtual 207	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   38: aload 13
    //   40: lload_3
    //   41: invokevirtual 211	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   44: astore_0
    //   45: aload 13
    //   47: invokevirtual 212	android/media/MediaMetadataRetriever:release	()V
    //   50: aload_0
    //   51: ifnonnull +78 -> 129
    //   54: aload 12
    //   56: astore 11
    //   58: aload 11
    //   60: areturn
    //   61: astore_0
    //   62: aload 13
    //   64: invokevirtual 212	android/media/MediaMetadataRetriever:release	()V
    //   67: aconst_null
    //   68: astore_0
    //   69: goto -19 -> 50
    //   72: astore_0
    //   73: aconst_null
    //   74: astore_0
    //   75: goto -25 -> 50
    //   78: astore_0
    //   79: aload 13
    //   81: invokevirtual 212	android/media/MediaMetadataRetriever:release	()V
    //   84: aconst_null
    //   85: astore_0
    //   86: goto -36 -> 50
    //   89: astore_0
    //   90: aconst_null
    //   91: astore_0
    //   92: goto -42 -> 50
    //   95: astore_0
    //   96: ldc 137
    //   98: iconst_1
    //   99: ldc 214
    //   101: aload_0
    //   102: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   105: aload 13
    //   107: invokevirtual 212	android/media/MediaMetadataRetriever:release	()V
    //   110: aconst_null
    //   111: astore_0
    //   112: goto -62 -> 50
    //   115: astore_0
    //   116: aconst_null
    //   117: astore_0
    //   118: goto -68 -> 50
    //   121: astore_0
    //   122: aload 13
    //   124: invokevirtual 212	android/media/MediaMetadataRetriever:release	()V
    //   127: aload_0
    //   128: athrow
    //   129: aload_0
    //   130: invokevirtual 219	android/graphics/Bitmap:getWidth	()I
    //   133: istore 7
    //   135: aload_0
    //   136: invokevirtual 222	android/graphics/Bitmap:getHeight	()I
    //   139: istore_2
    //   140: iload 7
    //   142: iload_2
    //   143: invokestatic 227	java/lang/Math:max	(II)I
    //   146: istore 8
    //   148: iload 8
    //   150: iload 6
    //   152: if_icmple +182 -> 334
    //   155: iload 6
    //   157: i2f
    //   158: iload 8
    //   160: i2f
    //   161: fdiv
    //   162: fstore 5
    //   164: iload 7
    //   166: i2f
    //   167: fload 5
    //   169: fmul
    //   170: invokestatic 231	java/lang/Math:round	(F)I
    //   173: istore 6
    //   175: iload_2
    //   176: i2f
    //   177: fload 5
    //   179: fmul
    //   180: invokestatic 231	java/lang/Math:round	(F)I
    //   183: istore_2
    //   184: aload_0
    //   185: iload 6
    //   187: iload_2
    //   188: iconst_1
    //   189: invokestatic 235	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   192: astore_0
    //   193: invokestatic 203	java/lang/System:currentTimeMillis	()J
    //   196: lstore_3
    //   197: aload_0
    //   198: ifnull +91 -> 289
    //   201: aload_0
    //   202: astore 11
    //   204: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   207: ifeq -149 -> 58
    //   210: ldc 137
    //   212: iconst_2
    //   213: new 101	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   220: ldc 237
    //   222: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: aload_0
    //   226: invokevirtual 219	android/graphics/Bitmap:getWidth	()I
    //   229: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   232: ldc 239
    //   234: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_0
    //   238: invokevirtual 222	android/graphics/Bitmap:getHeight	()I
    //   241: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   244: ldc 241
    //   246: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_1
    //   250: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: ldc 243
    //   255: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: lload_3
    //   259: lload 9
    //   261: lsub
    //   262: invokevirtual 246	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   265: ldc 248
    //   267: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 250	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: aload_0
    //   277: areturn
    //   278: astore_0
    //   279: aload_0
    //   280: invokevirtual 251	java/lang/OutOfMemoryError:printStackTrace	()V
    //   283: aload 11
    //   285: astore_0
    //   286: goto -93 -> 193
    //   289: aload_0
    //   290: astore 11
    //   292: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   295: ifeq -237 -> 58
    //   298: ldc 137
    //   300: iconst_2
    //   301: new 101	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   308: ldc 253
    //   310: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: aload_1
    //   314: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokestatic 144	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   323: aload_0
    //   324: areturn
    //   325: astore 13
    //   327: goto -277 -> 50
    //   330: astore_1
    //   331: goto -204 -> 127
    //   334: goto -141 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	paramContext	Context
    //   0	337	1	paramString	String
    //   0	337	2	paramInt	int
    //   0	337	3	paramLong	long
    //   162	16	5	f1	float
    //   7	179	6	j	int
    //   133	32	7	k	int
    //   146	13	8	m	int
    //   21	239	9	l	long
    //   1	290	11	localObject1	Object
    //   4	51	12	localObject2	Object
    //   30	93	13	localMediaMetadataRetriever	MediaMetadataRetriever
    //   325	1	13	localRuntimeException	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   32	45	61	java/lang/IllegalArgumentException
    //   62	67	72	java/lang/RuntimeException
    //   32	45	78	java/lang/RuntimeException
    //   79	84	89	java/lang/RuntimeException
    //   32	45	95	java/lang/OutOfMemoryError
    //   105	110	115	java/lang/RuntimeException
    //   32	45	121	finally
    //   96	105	121	finally
    //   184	193	278	java/lang/OutOfMemoryError
    //   45	50	325	java/lang/RuntimeException
    //   122	127	330	java/lang/RuntimeException
  }
  
  public static Bitmap a(Bitmap paramBitmap)
  {
    Object localObject;
    if (paramBitmap == null)
    {
      localObject = null;
      return localObject;
    }
    for (;;)
    {
      int j;
      int k;
      try
      {
        j = paramBitmap.getWidth();
        k = paramBitmap.getHeight();
        localObject = a(paramBitmap);
        if (localObject != null) {
          break label234;
        }
        return null;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        float f1;
        float f2;
        Canvas localCanvas;
        RectF localRectF;
        Paint localPaint;
        localObject = paramBitmap;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "resizeThumb ==> dstW:" + m + ", dstH:" + n);
      }
      f1 = m / j;
      f2 = n / k;
      localObject = new Matrix();
      ((Matrix)localObject).postScale(f1, f2);
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      localCanvas = new Canvas((Bitmap)localObject);
      localRectF = new RectF(0.0F, 0.0F, m, n);
      localPaint = new Paint(1);
      localPaint.setColor(-16777216);
      localPaint.setAntiAlias(true);
      localCanvas.drawBitmap(paramBitmap, null, localRectF, localPaint);
      if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
        paramBitmap.recycle();
      }
      return localObject;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("ShortVideoUtils", 2, "resizeThumb, OutOfMemoryError ", localOutOfMemoryError);
      return paramBitmap;
      label234:
      int m = localObject[0];
      int n = localObject[1];
      if (j == m)
      {
        localObject = paramBitmap;
        if (k == n) {
          break;
        }
      }
    }
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(b());
    localStringBuilder.append("thumbs");
    localStringBuilder.append(File.separator);
    Object localObject = new File(localStringBuilder.toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = localStringBuilder.toString() + ".nomedia";
    if (!new File((String)localObject).exists()) {
      bbdj.c((String)localObject);
    }
    return localStringBuilder.toString();
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 8: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 19: 
    default: 
      return " [TYPE_NONE " + paramInt + " ]";
    case 6: 
      return " [TYPE_VIDEO_C2C] ";
    case 7: 
      return " [TYPE_VIDEO_THUMB_C2C] ";
    case 17: 
      return " [TYPE_VIDEO_DISUSS]";
    case 18: 
      return " [TYPE_VIDEO_THUMB_DISUSS] ";
    case 9: 
      return " [TYPE_VIDEO_TROOP]";
    case 16: 
      return " [TYPE_VIDEO_THUMB_TROOP] ";
    }
    return " [TYPE_VIDEO_FORWARD] ";
  }
  
  public static String a(long paramLong)
  {
    int m = (int)paramLong / 1000;
    int j = m % 60;
    int k = m / 60 % 60;
    m /= 3600;
    if (m > 0) {
      return String.format("%d:%02d:%02d", new Object[] { Integer.valueOf(m), Integer.valueOf(k), Integer.valueOf(j) }).toString();
    }
    return String.format("%02d:%02d", new Object[] { Integer.valueOf(k), Integer.valueOf(j) }).toString();
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    String str = Formatter.formatShortFileSize(paramContext, paramLong);
    int j = str.length();
    paramContext = str;
    if (j > 3) {
      paramContext = str.substring(0, j - 1);
    }
    return paramContext.replace(" ", "");
  }
  
  public static String a(MessageForShortVideo paramMessageForShortVideo)
  {
    return a(paramMessageForShortVideo, "mp4") + "." + MD5.toMD5(paramMessageForShortVideo.uuid) + ".tmp";
  }
  
  public static String a(MessageForShortVideo paramMessageForShortVideo, String paramString)
  {
    int j = 0;
    paramString = b(paramMessageForShortVideo, paramString);
    int k = paramMessageForShortVideo.videoFileStatus;
    switch (k)
    {
    }
    boolean bool2;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (paramMessageForShortVideo.isSendFromLocal())
      {
        bool2 = bool1;
        if (bbdj.b(paramString)) {
          bool2 = false;
        }
      }
      paramMessageForShortVideo = a(paramMessageForShortVideo.getMd5());
      localObject = new File(paramMessageForShortVideo);
      if (((File)localObject).exists()) {
        break;
      }
      ((File)localObject).mkdirs();
      bbdj.c(paramMessageForShortVideo + ".nomedia");
      return paramString;
    }
    Object localObject = ((File)localObject).list();
    String str;
    if ((localObject != null) && (localObject.length > 0))
    {
      int m = localObject.length;
      for (;;)
      {
        if (j >= m) {
          break label384;
        }
        str = localObject[j];
        if ((!str.endsWith(".tmp")) && (!str.equals(".nomedia"))) {
          break;
        }
        j += 1;
      }
    }
    label384:
    for (paramMessageForShortVideo = paramMessageForShortVideo + str;; paramMessageForShortVideo = null)
    {
      if ((bool2) && (paramMessageForShortVideo != null) && (!new File(paramString).exists()))
      {
        long l1 = System.currentTimeMillis();
        if (paramMessageForShortVideo.equals(paramString)) {
          return paramString;
        }
        bbdj.d(paramMessageForShortVideo, paramString);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoUtils", 2, "copy " + paramMessageForShortVideo + " to " + paramString);
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUtils", 2, "getShortVideoSavePath-----time: = " + (l2 - l1) + ", videoStatus:" + b(k) + ", needCopy=" + bool2);
        }
      }
      return paramString;
    }
  }
  
  public static String a(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    Object localObject = axlv.a(paramFile);
    paramFile = new StringBuilder(ajsf.bj);
    paramFile.append((String)localObject);
    paramFile.append(".mp4");
    localObject = new File(ajsf.bj);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return paramFile.toString();
  }
  
  public static String a(File paramFile, String paramString)
  {
    if ((paramFile == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    String str = axlv.a(paramFile);
    paramFile = new StringBuilder(ajsf.bj);
    paramFile.append(paramString);
    paramFile.append(str);
    paramFile.append(".mp4");
    paramString = new File(ajsf.bj);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramFile.toString();
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(jdField_c_of_type_JavaLangString);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(a());
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2, long paramLong, String paramString3)
  {
    paramString1 = new StringBuilder(a(paramString1));
    paramString1.append(paramString2);
    paramString1.append(Math.abs(paramLong));
    paramString1.append(".");
    paramString1.append(paramString3);
    return paramString1.toString();
  }
  
  public static URL a(String paramString)
  {
    try
    {
      paramString = new URL("shortvideothumb", null, paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static AtomicInteger a()
  {
    if (!d)
    {
      b();
      d = true;
    }
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  }
  
  public static void a()
  {
    a("", false);
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    try
    {
      if ((VideoEnvironment.c(paramAppInterface)) && (!a()))
      {
        VideoEnvironment.a("AVCodec", null, true);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoUtils", 2, "LoadExtractedShortVideoSo:status_end=" + VideoEnvironment.a());
        }
      }
      return;
    }
    catch (Throwable paramAppInterface)
    {
      do
      {
        paramAppInterface.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("ShortVideoUtils", 2, "Load libAVCodec.so failure.", paramAppInterface);
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, SessionInfo paramSessionInfo, MessageRecord paramMessageRecord, Context paramContext)
  {
    axpo localaxpo = new axpo();
    localaxpo.b = paramString;
    switch (paramSessionInfo.jdField_a_of_type_Int)
    {
    default: 
      if (paramString == "0X8008E53")
      {
        localaxpo.jdField_c_of_type_JavaLangString = "2";
        label67:
        if ((paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForShortVideo))) {
          break label257;
        }
        paramString = (MessageForShortVideo)paramMessageRecord;
        localaxpo.jdField_a_of_type_JavaLangString = String.valueOf(paramString.videoFileTime * 1000);
        switch (paramString.busiType)
        {
        default: 
          label124:
          if (QLog.isColorLevel()) {
            QLog.e("ShortVideoUtils", 1, new Object[] { Long.valueOf(paramMessageRecord.uniseq) });
          }
          label150:
          if ((!(paramContext instanceof SplashActivity)) && (!(paramContext instanceof ChatActivity))) {}
          break;
        }
      }
      break;
    }
    for (localaxpo.f = "1";; localaxpo.f = "2")
    {
      axpn.a(paramAppInterface.getAccount(), "dc01178", paramSessionInfo.jdField_a_of_type_JavaLangString, localaxpo);
      return;
      localaxpo.d = "1";
      break;
      localaxpo.d = "2";
      break;
      localaxpo.d = "3";
      break;
      localaxpo.jdField_c_of_type_JavaLangString = "1";
      break label67;
      localaxpo.e = "1";
      break label124;
      localaxpo.e = "2";
      break label124;
      label257:
      localaxpo.jdField_a_of_type_JavaLangString = "0";
      localaxpo.e = "3";
      break label150;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2, int paramInt3, long paramLong1, long paramLong2)
  {
    String str2;
    switch (paramInt1)
    {
    default: 
      paramInt1 = 4;
      double d1 = paramLong1 / 1000.0D;
      double d2 = paramLong2 / 1000.0D;
      str1 = String.format("%.2f", new Object[] { Double.valueOf(d1) });
      str2 = String.format("%.2f", new Object[] { Double.valueOf(d2) });
      str2 = str1 + ";" + str2;
      if (paramInt1 != 2) {
        break;
      }
    }
    for (String str1 = paramString;; str1 = "")
    {
      axqw.b(paramQQAppInterface, "dc00898", "", paramString, "0X8009AA6", "0X8009AA6", paramInt1, 0, String.valueOf(paramInt2), String.valueOf(paramInt3), str2, str1);
      return;
      paramInt1 = 1;
      break;
      paramInt1 = 2;
      break;
      paramInt1 = 3;
      break;
    }
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(paramMessageForShortVideo.getMd5())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoUtils", 2, "deleteCacheFileByMessage, md5 == null! ");
    return;
    bbdj.d(a(paramMessageForShortVideo, "mp4"));
  }
  
  public static void a(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).edit();
    localEditor.putInt("short_video_hotpic_ptv_version_" + paramString, paramInt);
    localEditor.apply();
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new IllegalArgumentException("uin may be null, uin=" + paramString1);
    }
    a("sp_user_cache_data").edit().putString("recent_poi_" + paramString1, paramString2).apply();
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    axpo localaxpo = new axpo();
    localaxpo.jdField_a_of_type_JavaLangString = paramString3;
    localaxpo.b = "0X8008E53";
    switch (paramInt)
    {
    }
    for (;;)
    {
      localaxpo.jdField_c_of_type_JavaLangString = "2";
      localaxpo.e = paramString4;
      localaxpo.f = paramString5;
      axpn.a(paramString1, "dc01178", paramString2, localaxpo);
      return;
      localaxpo.d = "1";
      continue;
      localaxpo.d = "2";
      continue;
      localaxpo.d = "3";
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUtils", 2, "deleteDownloadTempFile, exclude :" + paramString + ",compareModifiedTime : " + paramBoolean);
    }
    Object localObject = new File(b());
    if (!((File)localObject).exists()) {}
    File[] arrayOfFile;
    for (;;)
    {
      return;
      localObject = ((File)localObject).listFiles();
      if (localObject != null)
      {
        int m = localObject.length;
        int j = 0;
        while (j < m)
        {
          arrayOfFile = localObject[j].listFiles();
          if (arrayOfFile != null) {
            break label109;
          }
          j += 1;
        }
      }
    }
    label109:
    int n = arrayOfFile.length;
    int k = 0;
    label116:
    File localFile;
    if (k < n)
    {
      localFile = arrayOfFile[k];
      if (!localFile.getName().equals(paramString)) {
        break label147;
      }
    }
    for (;;)
    {
      k += 1;
      break label116;
      break;
      label147:
      if ((localFile.isFile()) && (localFile.getName().contains(".tmp"))) {
        if (paramBoolean)
        {
          long l = localFile.lastModified();
          if (604800000L <= System.currentTimeMillis() - l) {
            localFile.delete();
          }
        }
        else
        {
          localFile.delete();
        }
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).edit();
    localEditor.putBoolean("short_video_ae_pitu_takesame_switch", paramBoolean);
    localEditor.apply();
  }
  
  public static boolean a()
  {
    return VideoEnvironment.e();
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    if (a()) {}
    do
    {
      return true;
      a(paramAppInterface);
    } while (a());
    return false;
  }
  
  public static boolean a(File paramFile)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramFile != null)
    {
      bool2 = bool1;
      if (paramFile.exists())
      {
        if (paramFile.isFile()) {
          break label39;
        }
        bool2 = bool1;
      }
    }
    label39:
    long l1;
    label144:
    do
    {
      int j;
      do
      {
        Object localObject;
        do
        {
          do
          {
            return bool2;
            l1 = System.currentTimeMillis();
            localObject = e(paramFile);
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoUtils", 2, "isSupportProgressive(), moovInfoStr: " + (String)localObject + ", filePath:" + paramFile.getAbsolutePath());
            }
            bool2 = bool1;
          } while (TextUtils.isEmpty((CharSequence)localObject));
          localObject = ((String)localObject).split("\\|");
          bool2 = bool1;
        } while (TextUtils.isEmpty(localObject[0]));
        j = -1;
        try
        {
          int k = Integer.parseInt(localObject[0]);
          j = k;
        }
        catch (Exception localException)
        {
          long l2;
          float f1;
          break label144;
        }
        bool2 = bool1;
      } while (j <= 0);
      l2 = paramFile.length();
      f1 = j / (float)l2;
      bool1 = bool3;
      if (f1 > 0.0F)
      {
        bool1 = bool3;
        if (f1 < 0.5F) {
          bool1 = true;
        }
      }
      l2 = System.currentTimeMillis();
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ShortVideoUtils", 2, "isSupportProgressive(), ratio: " + f1 + ", result: " + bool1 + ", cost:" + (l2 - l1));
    return bool1;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (!TextUtils.isEmpty(paramString))
    {
      if (!g) {
        bool2 = bool1;
      }
    }
    else {
      return bool2;
    }
    long l1 = System.currentTimeMillis();
    String str1 = "";
    String str2 = paramString + ".tmp";
    if (adjustMoovPosition(paramString, str2) != 0)
    {
      paramString = " adjustMoovPosition failure";
      bool1 = bool3;
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ShortVideoUtils", 2, "moveMoovAtom() result = " + bool1 + ", step = " + paramString + ", cost = " + (l2 - l1) + "ms");
      return bool1;
      String str3 = paramString + ".back";
      bbdj.c(paramString, str3);
      if (!bbdj.c(str2, paramString))
      {
        bbdj.c(str3, paramString);
        paramString = " rename failure";
        bool1 = bool3;
      }
      else
      {
        bool1 = true;
        paramString = str1;
      }
    }
  }
  
  public static int[] a()
  {
    return jdField_a_of_type_ArrayOfInt;
  }
  
  public static int[] a(int paramInt1, int paramInt2)
  {
    int k;
    int m;
    label13:
    int j;
    int n;
    if (paramInt1 > 0)
    {
      k = paramInt1;
      if (paramInt2 <= 0) {
        break label237;
      }
      m = paramInt2;
      j = (int)(BaseChatItemLayout.e + 0.5D);
      n = aywk.a();
      if (n < 135) {
        break label361;
      }
      n = actn.a(n, BaseApplicationImpl.getApplication().getResources());
      if (n >= j) {
        break label361;
      }
      j = n;
    }
    label82:
    label91:
    label361:
    for (;;)
    {
      n = actn.a(305.0F, BaseApplicationImpl.getApplication().getResources());
      String str;
      if (j > n)
      {
        j = n;
        if (k < m) {
          break label247;
        }
        n = 1;
        if (n == 0) {
          break label307;
        }
        if (k / m <= 1.555556F) {
          break label253;
        }
        str = "landscape close to 16:9";
        k = (int)(j * 9.0F / 16.0F + 0.5D);
        m = j;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUtils", 2, "adjustSize " + str + " maxPixel:" + j + " ow:" + paramInt1 + " oh:" + paramInt2 + " w:" + m + " h:" + k);
        }
        return new int[] { m, k };
        k = 100;
        break;
        label237:
        m = 100;
        break label13;
        break label82;
        label247:
        n = 0;
        break label91;
        label253:
        if (k / m > 1.166667F)
        {
          str = "landscape close to 4:3";
          k = (int)(j * 3.0F / 4.0F + 0.5D);
          m = j;
        }
        else
        {
          str = "landscape close to 1:1";
          k = j;
          m = j;
          continue;
          if (m / k > 1.3F)
          {
            str = "portrait close to 10:16";
            m = (int)(j * 10.0F / 16.0F + 0.5D);
            k = j;
          }
          else
          {
            str = "portrait close to 1:1";
            k = j;
            m = j;
          }
        }
      }
    }
  }
  
  public static int[] a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUtils", 2, "calculateThumbWH, bitmap == null ！");
      }
    }
    do
    {
      return null;
      if (!paramBitmap.isRecycled()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("ShortVideoUtils", 2, "calculateThumbWH, bitmap isRecycled !");
    return null;
    return a(new int[] { paramBitmap.getWidth(), paramBitmap.getHeight() });
  }
  
  @SuppressLint({"InlinedApi"})
  public static int[] a(String paramString)
  {
    int[] arrayOfInt = new int[3];
    int[] tmp5_4 = arrayOfInt;
    tmp5_4[0] = 0;
    int[] tmp9_5 = tmp5_4;
    tmp9_5[1] = 0;
    int[] tmp13_9 = tmp9_5;
    tmp13_9[2] = 0;
    tmp13_9;
    for (;;)
    {
      try
      {
        if (!bfni.d()) {
          return arrayOfInt;
        }
        localMediaMetadataRetriever = new MediaMetadataRetriever();
        localMediaMetadataRetriever.setDataSource(paramString);
        String str2 = localMediaMetadataRetriever.extractMetadata(18);
        String str3 = localMediaMetadataRetriever.extractMetadata(19);
        String str4 = localMediaMetadataRetriever.extractMetadata(9);
        str1 = "";
        if (Build.VERSION.SDK_INT >= 17) {
          str1 = localMediaMetadataRetriever.extractMetadata(24);
        }
        arrayOfInt[0] = Integer.valueOf(str2).intValue();
        arrayOfInt[1] = Integer.valueOf(str3).intValue();
        arrayOfInt[2] = Math.round(Integer.valueOf(str4).intValue() / 1000.0F);
        if (TextUtils.isEmpty(str1)) {
          continue;
        }
        j = Integer.parseInt(str1);
        if (j == 90) {
          continue;
        }
        if (j != 270) {}
      }
      catch (Exception paramString)
      {
        MediaMetadataRetriever localMediaMetadataRetriever;
        String str1;
        if (!QLog.isColorLevel()) {
          return arrayOfInt;
        }
        QLog.e(".troop.troop_file_video", 2, "getVideoResolution exp", paramString);
        return arrayOfInt;
        int j = arrayOfInt[0];
        arrayOfInt[0] = arrayOfInt[1];
        arrayOfInt[1] = j;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_file_video", 2, "getVideoResolution: w=" + arrayOfInt[0] + ", h=" + arrayOfInt[1] + ", dr=" + arrayOfInt[2] + ", rt=" + str1 + ", p=" + paramString);
      }
      localMediaMetadataRetriever.release();
      return arrayOfInt;
      arrayOfInt[0] = 0;
      arrayOfInt[1] = 0;
    }
    return arrayOfInt;
  }
  
  public static int[] a(int[] paramArrayOfInt)
  {
    float f2 = 2.0F;
    int j = 160;
    int k = 80;
    if (paramArrayOfInt == null) {
      return null;
    }
    int m = paramArrayOfInt[0];
    int n = paramArrayOfInt[1];
    if ((m == 0) || (n == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUtils", 2, "calculateThumbWH, w or h == 0 !");
      }
      return null;
    }
    float f1;
    if (n > m)
    {
      f1 = n / m;
      if (f1 <= 2.0F) {
        break label129;
      }
      f1 = f2;
      label76:
      if (n <= m) {
        break label152;
      }
      if (n <= 160) {
        break label132;
      }
    }
    for (;;)
    {
      label91:
      m = (int)(j / f1);
      if (m < 80) {}
      for (;;)
      {
        return new int[] { k, j };
        f1 = m / n;
        break;
        label129:
        break label76;
        label132:
        if (n >= 100) {
          break label213;
        }
        j = 100;
        break label91;
        k = m;
      }
      label152:
      if (m > 160) {}
      for (;;)
      {
        label160:
        m = (int)(j / f1);
        if (m < 80) {}
        for (;;)
        {
          m = j;
          j = k;
          k = m;
          break;
          if (m >= 100) {
            break label207;
          }
          j = 100;
          break label160;
          k = m;
        }
        label207:
        j = m;
      }
      label213:
      j = n;
    }
  }
  
  public static native int adjustMoovPosition(String paramString1, String paramString2);
  
  public static int b(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).getInt("short_video_hotpic_ptv_version_" + paramString, 0);
  }
  
  @TargetApi(14)
  public static long b(String paramString)
  {
    if (!bbdj.a(paramString)) {
      return 0L;
    }
    return swf.a(paramString);
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder(jdField_c_of_type_JavaLangString);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " [STATUS_UNKNOW " + paramInt + "]";
    case 2004: 
      return " [STATUS_RECV_CANCEL] ";
    case 2005: 
      return " [STATUS_RECV_ERROR] ";
    case 2003: 
      return " [STATUS_RECV_FINISHED] ";
    case 2002: 
      return " [STATUS_RECV_PROCESS] ";
    case 2001: 
      return " [STATUS_RECV_START] ";
    case 2008: 
      return " [STATUS_RECV_PREPARED] ";
    case 2000: 
      return " [STATUS_RECV_REQUEST] ";
    case 999: 
      return " [STATUS_SEND_PREPARE] ";
    case 1000: 
      return " [STATUS_SEND_REQUEST] ";
    case 1001: 
      return " [STATUS_SEND_START] ";
    case 1004: 
      return " [STATUS_SEND_CANCEL] ";
    case 1002: 
      return " [STATUS_SEND_PROCESS] ";
    case 1003: 
      return " [STATUS_SEND_FINISHED] ";
    case 1007: 
      return " [STATUS_UPLOAD_FINISHED] ";
    case 1005: 
      return " [STATUS_SEND_ERROR] ";
    case 5001: 
      return " [STATUS_FILE_UNSAFE] ";
    }
    return " [STATUS_FILE_EXPIRED] ";
  }
  
  public static String b(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo == null) {
      return "";
    }
    if (paramMessageForShortVideo.isSendFromLocal())
    {
      if (paramMessageForShortVideo.sendRawVideo) {
        return d(paramMessageForShortVideo.videoFileName, "tmp");
      }
      return c(paramMessageForShortVideo.videoFileName, "tmp");
    }
    return a(paramMessageForShortVideo);
  }
  
  public static String b(MessageForShortVideo paramMessageForShortVideo, String paramString)
  {
    if (paramMessageForShortVideo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(a(paramMessageForShortVideo.getMd5()));
      localStringBuilder.append(paramMessageForShortVideo.frienduin);
      localStringBuilder.append(Math.abs(paramMessageForShortVideo.uniseq));
      localStringBuilder.append(".");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public static String b(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    paramFile = axlv.a(paramFile);
    return ssi.e + paramFile + ".mp4";
  }
  
  public static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("QQ视频");
    localStringBuilder.append("_").append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(b());
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static URL b(String paramString)
  {
    try
    {
      paramString = new URL("shortvideoforpicthumb", null, paramString);
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static void b()
  {
    try
    {
      Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1|1|999|4|1|0_2");
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "getDefaultShortVideoStrategy:" + (String)localObject);
      }
      localObject = ((String)localObject).split("\\|");
      if (localObject.length > 6)
      {
        localObject = localObject[6].split("_");
        if (localObject.length >= 2)
        {
          int j = Integer.valueOf(localObject[0]).intValue();
          if ((j >= 0) && (j <= 2)) {
            jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(j);
          }
          j = Integer.valueOf(localObject[1]).intValue();
          if ((j >= 0) && (j <= 60)) {
            jdField_a_of_type_Int = j;
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ShortVideoUtils", 2, "needBlockBrokenVideo e:" + localException.toString());
    }
  }
  
  public static void b(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).edit();
    localEditor.putInt("short_video_hotpic_pic_version_" + paramString, paramInt);
    localEditor.apply();
  }
  
  public static void b(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).edit();
    localEditor.putBoolean("short_video_hotpic_show_ptv_" + paramString, paramBoolean);
    localEditor.apply();
  }
  
  public static boolean b()
  {
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.pg_switch.name(), "1|1|1");
    if (QLog.isDevelopLevel()) {
      QLog.d("peak_pgjpeg", 4, "DeviceProfileManager.DpcNames.pg_switch value " + (String)localObject);
    }
    localObject = ((String)localObject).split("\\|");
    if (localObject.length < 3) {
      return false;
    }
    return localObject[2].equals("1");
  }
  
  public static boolean b(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).getBoolean("short_video_hotpic_show_ptv_" + paramString, false);
  }
  
  public static int c(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).getInt("short_video_hotpic_pic_version_" + paramString, 0);
  }
  
  public static String c()
  {
    String str = d();
    StringBuilder localStringBuilder2 = new StringBuilder(str);
    File localFile = new File(localStringBuilder2.toString());
    StringBuilder localStringBuilder1 = localStringBuilder2;
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    for (localStringBuilder1 = localStringBuilder2;; localStringBuilder1 = new StringBuilder(str))
    {
      localStringBuilder1.append(axlv.a()).append(".mp4");
      if (!new File(localStringBuilder1.toString()).exists()) {
        return localStringBuilder1.toString();
      }
    }
  }
  
  public static String c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " shortvideo_cmd_unknow ";
    case 2: 
      return " shortvideo_cmd_download ";
    case 0: 
      return " shortvideo_cmd_send ";
    case 1: 
      return " shortvideo_cmd_resend ";
    case 3: 
      return " shortvideo_cmd_forward ";
    }
    return " shortvideo_cmd_reforward ";
  }
  
  @Deprecated
  public static String c(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      do
      {
        return null;
        String str = a(paramMessageForShortVideo, "mp4");
        if (bbdj.b(str)) {
          return str;
        }
      } while (!paramMessageForShortVideo.isSendFromLocal());
      paramMessageForShortVideo = paramMessageForShortVideo.videoFileName;
    } while (!bbdj.b(paramMessageForShortVideo));
    return paramMessageForShortVideo;
  }
  
  public static String c(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    paramFile = axlv.a(paramFile);
    StringBuilder localStringBuilder = new StringBuilder(jdField_c_of_type_JavaLangString);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("temp");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("source");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramFile);
    localStringBuilder.append(".mp4");
    return localStringBuilder.toString();
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("uin may be null, uin=" + paramString);
    }
    return a("sp_user_cache_data").getString("recent_poi_" + paramString, null);
  }
  
  @TargetApi(9)
  public static String c(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      String str = MD5.toMD5(paramString1);
      StringBuilder localStringBuilder = new StringBuilder(jdField_c_of_type_JavaLangString);
      localStringBuilder.append("shortvideo");
      localStringBuilder.append(File.separator);
      localStringBuilder.append(str);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "getShortVideoCompressPath: sourcePath=" + paramString1 + "/n compressPath=" + localStringBuilder.toString());
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static void c(String paramString, int paramInt)
  {
    int j = 1;
    if (paramInt == 0) {
      paramInt = j;
    }
    for (;;)
    {
      axqw.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
      return;
      if (paramInt == 1) {
        paramInt = 2;
      } else if (paramInt == 3000) {
        paramInt = 3;
      } else {
        paramInt = 4;
      }
    }
  }
  
  public static void c(String paramString, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).edit();
    localEditor.putBoolean("short_video_hotpic_show_pic_" + paramString, paramBoolean);
    localEditor.apply();
  }
  
  public static boolean c()
  {
    boolean bool = false;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int k = arrayOfString.length;
    int j = 0;
    while (j < k)
    {
      String str = arrayOfString[j];
      if (Build.MODEL.equalsIgnoreCase(str)) {
        bool = true;
      }
      j += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUtils", 2, "isInFullScreenBlackList(), result=" + bool);
    }
    return bool;
  }
  
  public static boolean c(String paramString)
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).getBoolean("short_video_hotpic_show_pic_" + paramString, false);
  }
  
  public static String d()
  {
    String str = Build.MODEL.toUpperCase();
    if (str.contains("GN9000L")) {
      str = ajsf.cJ;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "getCameraPath: commonPath=" + str);
      }
      return str;
      if ((str.contains("MX4")) || (str.contains("MX6")) || (str.contains("MX5")) || (str.contains("M355")) || (str.contains("M571C"))) {
        str = ajsf.cI;
      } else if (str.contains("M040")) {
        str = ajsf.cL;
      } else if ((str.contains("VIVO X7")) || (str.contains("VIVO X6A")) || (str.contains("VIVO XPLAY6")) || (str.contains("VIVO X5PRO")) || (str.contains("VIVO X9 PLUS")) || (str.contains("VIVO Y51A")) || (str.contains("VIVO X9I")) || (str.contains("VIVO X9")) || (str.contains("VIVO X6D"))) {
        str = ajsf.cK;
      } else {
        str = ajsf.bj;
      }
    }
  }
  
  public static String d(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Others";
    case 1: 
      return "WIFI";
    case 2: 
      return "2G";
    case 3: 
      return "3G";
    }
    return "4G";
  }
  
  public static String d(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo.isSend()) {
      return paramMessageForShortVideo.selfuin;
    }
    if ((paramMessageForShortVideo.istroop == 1) || (paramMessageForShortVideo.istroop == 3000)) {
      return paramMessageForShortVideo.senderuin;
    }
    return paramMessageForShortVideo.frienduin;
  }
  
  public static String d(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    paramFile = axlv.a(paramFile);
    StringBuilder localStringBuilder = new StringBuilder(jdField_c_of_type_JavaLangString);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("temp");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("audio");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramFile);
    localStringBuilder.append(".mp4");
    return localStringBuilder.toString();
  }
  
  @TargetApi(9)
  public static String d(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      String str = MD5.toMD5(paramString1);
      StringBuilder localStringBuilder = new StringBuilder(jdField_c_of_type_JavaLangString);
      localStringBuilder.append("shortvideo");
      localStringBuilder.append(File.separator);
      localStringBuilder.append(str);
      localStringBuilder.append("_raw");
      localStringBuilder.append(".");
      localStringBuilder.append(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "getShortVideoCompressPath: sourcePath=" + paramString1 + "/n compressPath=" + localStringBuilder.toString());
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static boolean d()
  {
    if (!jdField_c_of_type_Boolean) {}
    try
    {
      Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1|1|999|4|1");
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "needBlockBrokenVideo:" + (String)localObject);
      }
      localObject = ((String)localObject).split("\\|");
      if (localObject.length > 5) {
        h = localObject[5].equals("1");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUtils", 2, "needBlockBrokenVideo e:" + localException.toString());
        }
      }
    }
    jdField_c_of_type_Boolean = true;
    return h;
  }
  
  /* Error */
  @TargetApi(16)
  public static boolean d(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: new 1053	android/media/MediaExtractor
    //   5: dup
    //   6: invokespecial 1054	android/media/MediaExtractor:<init>	()V
    //   9: astore 4
    //   11: aload 4
    //   13: aload_0
    //   14: invokevirtual 1055	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   17: iconst_0
    //   18: istore_1
    //   19: iload_3
    //   20: istore_2
    //   21: iload_1
    //   22: aload 4
    //   24: invokevirtual 1058	android/media/MediaExtractor:getTrackCount	()I
    //   27: if_icmpge +34 -> 61
    //   30: aload 4
    //   32: iload_1
    //   33: invokevirtual 1062	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   36: ldc_w 1064
    //   39: invokevirtual 1068	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   42: astore_0
    //   43: aload_0
    //   44: ldc_w 1070
    //   47: invokevirtual 1073	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   50: ifeq +18 -> 68
    //   53: aload_0
    //   54: ldc_w 1075
    //   57: invokevirtual 967	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   60: istore_2
    //   61: aload 4
    //   63: invokevirtual 1076	android/media/MediaExtractor:release	()V
    //   66: iload_2
    //   67: ireturn
    //   68: iload_1
    //   69: iconst_1
    //   70: iadd
    //   71: istore_1
    //   72: goto -53 -> 19
    //   75: astore_0
    //   76: invokestatic 135	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +13 -> 92
    //   82: ldc 137
    //   84: iconst_2
    //   85: ldc_w 1078
    //   88: aload_0
    //   89: invokestatic 307	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   92: aload 4
    //   94: invokevirtual 1076	android/media/MediaExtractor:release	()V
    //   97: iconst_0
    //   98: ireturn
    //   99: astore_0
    //   100: aload 4
    //   102: invokevirtual 1076	android/media/MediaExtractor:release	()V
    //   105: aload_0
    //   106: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	107	0	paramString	String
    //   18	54	1	j	int
    //   20	47	2	bool1	boolean
    //   1	19	3	bool2	boolean
    //   9	92	4	localMediaExtractor	android.media.MediaExtractor
    // Exception table:
    //   from	to	target	type
    //   11	17	75	java/lang/Exception
    //   21	61	75	java/lang/Exception
    //   11	17	99	finally
    //   21	61	99	finally
    //   76	92	99	finally
  }
  
  /* Error */
  public static String e(File paramFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: iconst_0
    //   4: istore_1
    //   5: iconst_4
    //   6: newarray byte
    //   8: astore 10
    //   10: iconst_4
    //   11: newarray byte
    //   13: astore 12
    //   15: lconst_0
    //   16: lstore 5
    //   18: bipush 8
    //   20: invokestatic 1084	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   23: astore 13
    //   25: new 1086	java/io/FileInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 1089	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: astore 9
    //   35: iconst_0
    //   36: istore_2
    //   37: iload_1
    //   38: bipush 100
    //   40: if_icmpge +292 -> 332
    //   43: aload 9
    //   45: astore_0
    //   46: aload 9
    //   48: aload 10
    //   50: invokevirtual 1095	java/io/InputStream:read	([B)I
    //   53: istore_3
    //   54: iload_3
    //   55: ifgt +41 -> 96
    //   58: aload 9
    //   60: ifnull +8 -> 68
    //   63: aload 9
    //   65: invokevirtual 1098	java/io/InputStream:close	()V
    //   68: new 101	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   75: iload_2
    //   76: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   79: ldc_w 1100
    //   82: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: lload 5
    //   87: invokevirtual 246	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   90: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore_0
    //   94: aload_0
    //   95: areturn
    //   96: aload 9
    //   98: astore_0
    //   99: aload 13
    //   101: iconst_4
    //   102: newarray byte
    //   104: invokevirtual 1104	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   107: pop
    //   108: aload 9
    //   110: astore_0
    //   111: aload 13
    //   113: aload 10
    //   115: invokevirtual 1104	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   118: pop
    //   119: aload 9
    //   121: astore_0
    //   122: aload 13
    //   124: invokevirtual 1108	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   127: pop
    //   128: aload 9
    //   130: astore_0
    //   131: aload 13
    //   133: invokevirtual 1111	java/nio/ByteBuffer:getLong	()J
    //   136: lstore 7
    //   138: aload 9
    //   140: astore_0
    //   141: iload_3
    //   142: aload 9
    //   144: aload 12
    //   146: invokevirtual 1095	java/io/InputStream:read	([B)I
    //   149: iadd
    //   150: istore 4
    //   152: iload 4
    //   154: istore_3
    //   155: lload 7
    //   157: lstore 5
    //   159: lload 7
    //   161: lconst_1
    //   162: lcmp
    //   163: ifne +172 -> 335
    //   166: aload 9
    //   168: astore_0
    //   169: bipush 8
    //   171: newarray byte
    //   173: astore 14
    //   175: aload 9
    //   177: astore_0
    //   178: iload 4
    //   180: aload 9
    //   182: aload 14
    //   184: invokevirtual 1095	java/io/InputStream:read	([B)I
    //   187: iadd
    //   188: istore_3
    //   189: aload 9
    //   191: astore_0
    //   192: aload 13
    //   194: invokevirtual 1114	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   197: pop
    //   198: aload 9
    //   200: astore_0
    //   201: aload 13
    //   203: aload 14
    //   205: invokevirtual 1104	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   208: pop
    //   209: aload 9
    //   211: astore_0
    //   212: aload 13
    //   214: invokevirtual 1108	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   217: pop
    //   218: aload 9
    //   220: astore_0
    //   221: aload 13
    //   223: invokevirtual 1111	java/nio/ByteBuffer:getLong	()J
    //   226: lstore 5
    //   228: goto +107 -> 335
    //   231: aload 9
    //   233: astore_0
    //   234: aload 9
    //   236: lload 5
    //   238: iload_3
    //   239: i2l
    //   240: lsub
    //   241: invokevirtual 1117	java/io/InputStream:skip	(J)J
    //   244: pop2
    //   245: iload_2
    //   246: i2l
    //   247: lload 5
    //   249: ladd
    //   250: l2i
    //   251: istore_2
    //   252: aload 9
    //   254: astore_0
    //   255: aload 13
    //   257: invokevirtual 1114	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   260: pop
    //   261: iload_1
    //   262: iconst_1
    //   263: iadd
    //   264: istore_1
    //   265: goto -228 -> 37
    //   268: astore 10
    //   270: aconst_null
    //   271: astore 9
    //   273: aload 9
    //   275: astore_0
    //   276: aload 10
    //   278: invokevirtual 164	java/lang/Exception:printStackTrace	()V
    //   281: aload 11
    //   283: astore_0
    //   284: aload 9
    //   286: ifnull -192 -> 94
    //   289: aload 9
    //   291: invokevirtual 1098	java/io/InputStream:close	()V
    //   294: aconst_null
    //   295: areturn
    //   296: astore_0
    //   297: aconst_null
    //   298: areturn
    //   299: astore 9
    //   301: aconst_null
    //   302: astore_0
    //   303: aload_0
    //   304: ifnull +7 -> 311
    //   307: aload_0
    //   308: invokevirtual 1098	java/io/InputStream:close	()V
    //   311: aload 9
    //   313: athrow
    //   314: astore_0
    //   315: goto -247 -> 68
    //   318: astore_0
    //   319: goto -8 -> 311
    //   322: astore 9
    //   324: goto -21 -> 303
    //   327: astore 10
    //   329: goto -56 -> 273
    //   332: goto -274 -> 58
    //   335: aload 12
    //   337: iconst_0
    //   338: baload
    //   339: i2c
    //   340: bipush 109
    //   342: if_icmpne -111 -> 231
    //   345: aload 12
    //   347: iconst_1
    //   348: baload
    //   349: i2c
    //   350: bipush 111
    //   352: if_icmpne -121 -> 231
    //   355: aload 12
    //   357: iconst_2
    //   358: baload
    //   359: i2c
    //   360: bipush 111
    //   362: if_icmpne -131 -> 231
    //   365: aload 12
    //   367: iconst_3
    //   368: baload
    //   369: i2c
    //   370: bipush 118
    //   372: if_icmpne -141 -> 231
    //   375: goto -317 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	378	0	paramFile	File
    //   4	261	1	j	int
    //   36	216	2	k	int
    //   53	186	3	m	int
    //   150	38	4	n	int
    //   16	232	5	l1	long
    //   136	24	7	l2	long
    //   33	257	9	localFileInputStream	java.io.FileInputStream
    //   299	13	9	localObject1	Object
    //   322	1	9	localObject2	Object
    //   8	106	10	arrayOfByte1	byte[]
    //   268	9	10	localException1	Exception
    //   327	1	10	localException2	Exception
    //   1	281	11	localObject3	Object
    //   13	353	12	arrayOfByte2	byte[]
    //   23	233	13	localByteBuffer	java.nio.ByteBuffer
    //   173	31	14	arrayOfByte3	byte[]
    // Exception table:
    //   from	to	target	type
    //   25	35	268	java/lang/Exception
    //   289	294	296	java/lang/Exception
    //   25	35	299	finally
    //   63	68	314	java/lang/Exception
    //   307	311	318	java/lang/Exception
    //   46	54	322	finally
    //   99	108	322	finally
    //   111	119	322	finally
    //   122	128	322	finally
    //   131	138	322	finally
    //   141	152	322	finally
    //   169	175	322	finally
    //   178	189	322	finally
    //   192	198	322	finally
    //   201	209	322	finally
    //   212	218	322	finally
    //   221	228	322	finally
    //   234	245	322	finally
    //   255	261	322	finally
    //   276	281	322	finally
    //   46	54	327	java/lang/Exception
    //   99	108	327	java/lang/Exception
    //   111	119	327	java/lang/Exception
    //   122	128	327	java/lang/Exception
    //   131	138	327	java/lang/Exception
    //   141	152	327	java/lang/Exception
    //   169	175	327	java/lang/Exception
    //   178	189	327	java/lang/Exception
    //   192	198	327	java/lang/Exception
    //   201	209	327	java/lang/Exception
    //   212	218	327	java/lang/Exception
    //   221	228	327	java/lang/Exception
    //   234	245	327	java/lang/Exception
    //   255	261	327	java/lang/Exception
  }
  
  public static boolean e()
  {
    if (!i) {
      i = true;
    }
    try
    {
      Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_config.name(), "");
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "supportShortVideoMergePhoto:" + (String)localObject);
      }
      localObject = ((String)localObject).split("\\|");
      if (localObject.length > 10)
      {
        int j = Integer.valueOf(localObject[10]).intValue();
        if ((j >= 0) && (j <= 1)) {
          jdField_b_of_type_Int = j;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUtils", 2, "supportShortVideoMergePhoto e:" + localException.toString());
        }
      }
    }
    return jdField_b_of_type_Int == 1;
  }
  
  public static boolean f()
  {
    boolean bool1 = e();
    boolean bool2 = amfw.a();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUtils", 2, "supportShortVideoMergePhoto dpc:" + jdField_b_of_type_Int + " choiceQC:" + bool2);
    }
    return (!bool1) || (!bool2);
  }
  
  public static boolean g()
  {
    return BaseApplicationImpl.getApplication().getSharedPreferences("ptv_and_hot_pic_reddot_sp", 4).getBoolean("short_video_ae_pitu_takesame_switch", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoUtils
 * JD-Core Version:    0.7.0.1
 */