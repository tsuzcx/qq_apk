package com.tencent.mobileqq.shortvideo;

import ahma;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.widget.Toast;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.util.VidUtil;
import com.tencent.mobileqq.statistics.AVShortVideoReportController;
import com.tencent.mobileqq.statistics.AVShortVideoReportController.ReportData;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class ShortVideoUtils
  implements ShortVideoConstants
{
  private static int jdField_a_of_type_Int;
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  public static boolean a;
  private static int[] jdField_a_of_type_ArrayOfInt;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "GT-N7108" };
  private static int b;
  public static boolean b;
  public static boolean c;
  public static boolean d;
  private static volatile boolean e;
  private static boolean f;
  private static boolean g;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = true;
    f = true;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    jdField_a_of_type_Int = 2;
    jdField_b_of_type_Int = 1;
    jdField_a_of_type_ArrayOfInt = new int[] { 1, 97, 125 };
    ThreadManager.getSubThreadHandler().post(new ahma());
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
      int i = localMediaPlayer.getDuration();
      long l = i;
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
    //   0: iload_2
    //   1: istore 6
    //   3: iload_2
    //   4: ifgt +8 -> 12
    //   7: sipush 640
    //   10: istore 6
    //   12: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   15: lstore 9
    //   17: new 155	android/media/MediaMetadataRetriever
    //   20: dup
    //   21: invokespecial 156	android/media/MediaMetadataRetriever:<init>	()V
    //   24: astore 11
    //   26: aload 11
    //   28: aload_1
    //   29: invokevirtual 157	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   32: aload 11
    //   34: lload_3
    //   35: invokevirtual 161	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   38: astore_0
    //   39: aload 11
    //   41: invokevirtual 162	android/media/MediaMetadataRetriever:release	()V
    //   44: aload_0
    //   45: ifnonnull +49 -> 94
    //   48: aconst_null
    //   49: astore_0
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: aload 11
    //   55: invokevirtual 162	android/media/MediaMetadataRetriever:release	()V
    //   58: aconst_null
    //   59: astore_0
    //   60: goto -16 -> 44
    //   63: astore_0
    //   64: aconst_null
    //   65: astore_0
    //   66: goto -22 -> 44
    //   69: astore_0
    //   70: aload 11
    //   72: invokevirtual 162	android/media/MediaMetadataRetriever:release	()V
    //   75: aconst_null
    //   76: astore_0
    //   77: goto -33 -> 44
    //   80: astore_0
    //   81: aconst_null
    //   82: astore_0
    //   83: goto -39 -> 44
    //   86: astore_0
    //   87: aload 11
    //   89: invokevirtual 162	android/media/MediaMetadataRetriever:release	()V
    //   92: aload_0
    //   93: athrow
    //   94: aload_0
    //   95: invokevirtual 167	android/graphics/Bitmap:getWidth	()I
    //   98: istore_2
    //   99: aload_0
    //   100: invokevirtual 170	android/graphics/Bitmap:getHeight	()I
    //   103: istore 7
    //   105: iload_2
    //   106: iload 7
    //   108: invokestatic 175	java/lang/Math:max	(II)I
    //   111: istore 8
    //   113: aload_0
    //   114: astore 11
    //   116: iload 8
    //   118: iload 6
    //   120: if_icmple +36 -> 156
    //   123: iload 6
    //   125: i2f
    //   126: iload 8
    //   128: i2f
    //   129: fdiv
    //   130: fstore 5
    //   132: aload_0
    //   133: iload_2
    //   134: i2f
    //   135: fload 5
    //   137: fmul
    //   138: invokestatic 179	java/lang/Math:round	(F)I
    //   141: iload 7
    //   143: i2f
    //   144: fload 5
    //   146: fmul
    //   147: invokestatic 179	java/lang/Math:round	(F)I
    //   150: iconst_1
    //   151: invokestatic 183	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   154: astore 11
    //   156: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   159: lstore_3
    //   160: aload 11
    //   162: ifnull +83 -> 245
    //   165: aload 11
    //   167: astore_0
    //   168: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq -121 -> 50
    //   174: ldc 90
    //   176: iconst_2
    //   177: new 92	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   184: ldc 185
    //   186: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload 11
    //   191: invokevirtual 167	android/graphics/Bitmap:getWidth	()I
    //   194: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: ldc 190
    //   199: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 11
    //   204: invokevirtual 170	android/graphics/Bitmap:getHeight	()I
    //   207: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   210: ldc 192
    //   212: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_1
    //   216: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: ldc 194
    //   221: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: lload_3
    //   225: lload 9
    //   227: lsub
    //   228: invokevirtual 197	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   231: ldc 199
    //   233: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: aload 11
    //   244: areturn
    //   245: aload 11
    //   247: astore_0
    //   248: invokestatic 88	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   251: ifeq -201 -> 50
    //   254: ldc 90
    //   256: iconst_2
    //   257: new 92	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   264: ldc 203
    //   266: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload_1
    //   270: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 108	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   279: aload 11
    //   281: areturn
    //   282: astore 11
    //   284: goto -240 -> 44
    //   287: astore_1
    //   288: goto -196 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	paramContext	Context
    //   0	291	1	paramString	String
    //   0	291	2	paramInt	int
    //   0	291	3	paramLong	long
    //   130	15	5	f1	float
    //   1	123	6	i	int
    //   103	39	7	j	int
    //   111	16	8	k	int
    //   15	211	9	l	long
    //   24	256	11	localObject	Object
    //   282	1	11	localRuntimeException	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   26	39	52	java/lang/IllegalArgumentException
    //   53	58	63	java/lang/RuntimeException
    //   26	39	69	java/lang/RuntimeException
    //   70	75	80	java/lang/RuntimeException
    //   26	39	86	finally
    //   39	44	282	java/lang/RuntimeException
    //   87	92	287	java/lang/RuntimeException
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
      int i;
      int j;
      try
      {
        i = paramBitmap.getWidth();
        j = paramBitmap.getHeight();
        localObject = a(paramBitmap);
        if (localObject != null) {
          break label231;
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
        QLog.d("ShortVideoUtils", 2, "resizeThumb ==> dstW:" + k + ", dstH:" + m);
      }
      f1 = k / i;
      f2 = m / j;
      localObject = new Matrix();
      ((Matrix)localObject).postScale(f1, f2);
      localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
      localCanvas = new Canvas((Bitmap)localObject);
      localRectF = new RectF(0.0F, 0.0F, k, m);
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
      label231:
      int k = localObject[0];
      int m = localObject[1];
      if (i == k)
      {
        localObject = paramBitmap;
        if (j == m) {
          break;
        }
      }
    }
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(e());
    localStringBuilder.append("thumbs");
    localStringBuilder.append(File.separator);
    Object localObject = new File(localStringBuilder.toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = localStringBuilder.toString() + ".nomedia";
    if (!new File((String)localObject).exists()) {
      FileUtils.c((String)localObject);
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
    int k = (int)paramLong / 1000;
    int i = k % 60;
    int j = k / 60 % 60;
    k /= 3600;
    if (k > 0) {
      return String.format("%d:%02d:%02d", new Object[] { Integer.valueOf(k), Integer.valueOf(j), Integer.valueOf(i) }).toString();
    }
    return String.format("%02d:%02d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) }).toString();
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    String str = Formatter.formatShortFileSize(paramContext, paramLong);
    int i = str.length();
    paramContext = str;
    if (i > 3) {
      paramContext = str.substring(0, i - 1);
    }
    return paramContext.replace(" ", "");
  }
  
  @Deprecated
  public static String a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (paramMessageForShortVideo == null) {}
    do
    {
      do
      {
        return null;
        String str = a(paramMessageForShortVideo, "mp4");
        if (FileUtils.b(str)) {
          return str;
        }
      } while (!paramMessageForShortVideo.isSendFromLocal());
      paramMessageForShortVideo = paramMessageForShortVideo.videoFileName;
    } while (!FileUtils.b(paramMessageForShortVideo));
    return paramMessageForShortVideo;
  }
  
  public static String a(MessageForShortVideo paramMessageForShortVideo, String paramString)
  {
    int i = 0;
    paramString = b(paramMessageForShortVideo, paramString);
    int j = paramMessageForShortVideo.videoFileStatus;
    switch (j)
    {
    }
    boolean bool2;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (paramMessageForShortVideo.isSendFromLocal())
      {
        bool2 = bool1;
        if (FileUtils.b(paramString)) {
          bool2 = false;
        }
      }
      paramMessageForShortVideo = d(paramMessageForShortVideo.getMd5());
      localObject = new File(paramMessageForShortVideo);
      if (((File)localObject).exists()) {
        break;
      }
      ((File)localObject).mkdirs();
      FileUtils.c(paramMessageForShortVideo + ".nomedia");
      return paramString;
    }
    Object localObject = ((File)localObject).list();
    String str;
    if ((localObject != null) && (localObject.length > 0))
    {
      int k = localObject.length;
      for (;;)
      {
        if (i >= k) {
          break label384;
        }
        str = localObject[i];
        if ((!str.endsWith(".tmp")) && (!str.equals(".nomedia"))) {
          break;
        }
        i += 1;
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
        FileUtils.d(paramMessageForShortVideo, paramString);
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoUtils", 2, "copy " + paramMessageForShortVideo + " to " + paramString);
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUtils", 2, "getShortVideoSavePath-----time: = " + (l2 - l1) + ", videoStatus:" + b(j) + ", needCopy=" + bool2);
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
    Object localObject = VidUtil.a(paramFile);
    paramFile = new StringBuilder(AppConstants.aV);
    paramFile.append((String)localObject);
    paramFile.append(".mp4");
    localObject = new File(AppConstants.aV);
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
    String str = VidUtil.a(paramFile);
    paramFile = new StringBuilder(AppConstants.aV);
    paramFile.append(paramString);
    paramFile.append(str);
    paramFile.append(".mp4");
    paramString = new File(AppConstants.aV);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramFile.toString();
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = VidUtil.a(new File(paramString));
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.aJ);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("temp");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("source");
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
    paramString1 = new StringBuilder(d(paramString1));
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
  
  @TargetApi(10)
  public static void a(Activity paramActivity, File paramFile)
  {
    long l = FileUtils.a(paramFile.getAbsolutePath());
    paramActivity = new StringBuilder();
    paramActivity.append("VideoSize:");
    paramActivity.append(l / 1000L);
    paramActivity.append("KB\n");
    if (VersionUtils.d())
    {
      Object localObject = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject).setDataSource(paramFile.getAbsolutePath());
      paramFile = ((MediaMetadataRetriever)localObject).extractMetadata(18);
      String str = ((MediaMetadataRetriever)localObject).extractMetadata(19);
      localObject = ((MediaMetadataRetriever)localObject).extractMetadata(9);
      paramActivity.append("VideoResolution:" + paramFile + "*" + str);
      paramActivity.append('\n');
      paramActivity.append("VideoDuration:" + (String)localObject + "ms");
    }
    Toast.makeText(BaseApplicationImpl.sApplication, paramActivity.toString(), 1).show();
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
    AVShortVideoReportController.ReportData localReportData = new AVShortVideoReportController.ReportData();
    localReportData.b = paramString;
    switch (paramSessionInfo.jdField_a_of_type_Int)
    {
    default: 
      if (paramString == "0X8008E53")
      {
        localReportData.c = "2";
        label67:
        if ((paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForShortVideo))) {
          break label257;
        }
        paramString = (MessageForShortVideo)paramMessageRecord;
        localReportData.jdField_a_of_type_JavaLangString = String.valueOf(paramString.videoFileTime * 1000);
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
    for (localReportData.f = "1";; localReportData.f = "2")
    {
      AVShortVideoReportController.a(paramAppInterface.getAccount(), "dc01178", paramSessionInfo.jdField_a_of_type_JavaLangString, localReportData);
      return;
      localReportData.d = "1";
      break;
      localReportData.d = "2";
      break;
      localReportData.d = "3";
      break;
      localReportData.c = "1";
      break label67;
      localReportData.e = "1";
      break label124;
      localReportData.e = "2";
      break label124;
      label257:
      localReportData.jdField_a_of_type_JavaLangString = "0";
      localReportData.e = "3";
      break label150;
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
    FileUtils.d(a(paramMessageForShortVideo, "mp4"));
  }
  
  public static void a(MessageForShortVideo paramMessageForShortVideo, Activity paramActivity, int paramInt, String paramString)
  {
    String str = a(paramMessageForShortVideo.thumbMD5, "jpg");
    Bundle localBundle = new Bundle();
    localBundle.putInt("uintype", paramMessageForShortVideo.istroop);
    localBundle.putString("from_uin", b(paramMessageForShortVideo));
    localBundle.putInt("from_uin_type", paramInt);
    localBundle.putString("from_session_uin", paramString);
    localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
    localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
    localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
    localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
    localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
    localBundle.putString("thumbfile_send_path", str);
    localBundle.putString("file_shortvideo_md5", paramMessageForShortVideo.md5);
    localBundle.putInt("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
    localBundle.putInt("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
    localBundle.putString("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
    localBundle.putString("file_source", paramMessageForShortVideo.fileSource);
    localBundle.putString("file_uuid", paramMessageForShortVideo.uuid);
    localBundle.putInt("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
    localBundle.putBoolean("support_progressive", paramMessageForShortVideo.supportProgressive);
    localBundle.putInt("file_width", paramMessageForShortVideo.fileWidth);
    localBundle.putInt("file_height", paramMessageForShortVideo.fileHeight);
    localBundle.putInt("video_play_caller", 0);
    localBundle.putParcelable("key_message_for_shortvideo", paramMessageForShortVideo);
    localBundle.putLong("message_click_start", System.currentTimeMillis());
    if (paramMessageForShortVideo.CheckIsHotVideo())
    {
      localBundle.putBoolean("is_hotVideo", true);
      localBundle.putString("hot_video_icon", paramMessageForShortVideo.hotVideoIconUrl);
      localBundle.putString("hot_video_icon_sub", paramMessageForShortVideo.hotVideoSubIconUrl);
      localBundle.putString("hot_video_title", paramMessageForShortVideo.hotVideoTitle);
      localBundle.putString("hot_video_url", paramMessageForShortVideo.hotVideoUrl);
    }
    localBundle.putInt("special_video_type", paramMessageForShortVideo.specialVideoType);
    localBundle.putInt("short_video_msg_tail_type", paramMessageForShortVideo.msgTailType);
    paramMessageForShortVideo = new Intent(paramActivity, ShortVideoPlayActivity.class);
    paramMessageForShortVideo.putExtras(localBundle);
    paramActivity.startActivityForResult(paramMessageForShortVideo, 13002);
    paramActivity.overridePendingTransition(2131034165, 2131034167);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, String paramString5)
  {
    AVShortVideoReportController.ReportData localReportData = new AVShortVideoReportController.ReportData();
    localReportData.jdField_a_of_type_JavaLangString = paramString3;
    localReportData.b = "0X8008E53";
    switch (paramInt)
    {
    }
    for (;;)
    {
      localReportData.c = "2";
      localReportData.e = paramString4;
      localReportData.f = paramString5;
      AVShortVideoReportController.a(paramString1, "dc01178", paramString2, localReportData);
      return;
      localReportData.d = "1";
      continue;
      localReportData.d = "2";
      continue;
      localReportData.d = "3";
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUtils", 2, "deleteDownloadTempFile, exclude :" + paramString + ",compareModifiedTime : " + paramBoolean);
    }
    Object localObject = new File(e());
    if (!((File)localObject).exists()) {}
    File[] arrayOfFile;
    for (;;)
    {
      return;
      localObject = ((File)localObject).listFiles();
      if (localObject != null)
      {
        int k = localObject.length;
        int i = 0;
        while (i < k)
        {
          arrayOfFile = localObject[i].listFiles();
          if (arrayOfFile != null) {
            break label109;
          }
          i += 1;
        }
      }
    }
    label109:
    int m = arrayOfFile.length;
    int j = 0;
    label116:
    File localFile;
    if (j < m)
    {
      localFile = arrayOfFile[j];
      if (!localFile.getName().equals(paramString)) {
        break label147;
      }
    }
    for (;;)
    {
      j += 1;
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
  
  public static boolean a()
  {
    return VideoEnvironment.e();
  }
  
  public static boolean a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
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
      int i;
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
        i = -1;
        try
        {
          int j = Integer.parseInt(localObject[0]);
          i = j;
        }
        catch (Exception localException)
        {
          long l2;
          float f1;
          break label144;
        }
        bool2 = bool1;
      } while (i <= 0);
      l2 = paramFile.length();
      f1 = i / (float)l2;
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
      if (!e) {
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
      FileUtils.c(paramString, str3);
      if (!FileUtils.c(str2, paramString))
      {
        FileUtils.c(str3, paramString);
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
    int j;
    int k;
    label13:
    int i;
    int m;
    if (paramInt1 > 0)
    {
      j = paramInt1;
      if (paramInt2 <= 0) {
        break label214;
      }
      k = paramInt2;
      i = (int)(BaseChatItemLayout.e + 0.5D);
      m = URLDrawableHelper.a();
      if (m < 135) {
        break label335;
      }
      m = AIOUtils.a(m, BaseApplicationImpl.getApplication().getResources());
      if (m >= i) {
        break label335;
      }
      i = m;
    }
    label68:
    label335:
    for (;;)
    {
      String str;
      if (j >= k)
      {
        m = 1;
        if (m == 0) {
          break label281;
        }
        if (j / k <= 1.555556F) {
          break label227;
        }
        str = "landscape close to 16:9";
        j = (int)(i * 9.0F / 16.0F + 0.5D);
        k = i;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUtils", 2, "adjustSize " + str + " maxPixel:" + i + " ow:" + paramInt1 + " oh:" + paramInt2 + " w:" + k + " h:" + j);
        }
        return new int[] { k, j };
        j = 100;
        break;
        label214:
        k = 100;
        break label13;
        m = 0;
        break label68;
        label227:
        if (j / k > 1.166667F)
        {
          str = "landscape close to 4:3";
          j = (int)(i * 3.0F / 4.0F + 0.5D);
          k = i;
        }
        else
        {
          str = "landscape close to 1:1";
          j = i;
          k = i;
          continue;
          if (k / j > 1.3F)
          {
            str = "portrait close to 10:16";
            k = (int)(i * 10.0F / 16.0F + 0.5D);
            j = i;
          }
          else
          {
            str = "portrait close to 1:1";
            j = i;
            k = i;
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
        if (!VersionUtils.d()) {
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
        i = Integer.parseInt(str1);
        if (i == 90) {
          continue;
        }
        if (i != 270) {}
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
        int i = arrayOfInt[0];
        arrayOfInt[0] = arrayOfInt[1];
        arrayOfInt[1] = i;
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
    int i = 160;
    int j = 80;
    if (paramArrayOfInt == null) {
      return null;
    }
    int k = paramArrayOfInt[0];
    int m = paramArrayOfInt[1];
    if ((k == 0) || (m == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUtils", 2, "calculateThumbWH, w or h == 0 !");
      }
      return null;
    }
    float f1;
    if (m > k)
    {
      f1 = m / k;
      if (f1 <= 2.0F) {
        break label129;
      }
      f1 = f2;
      label76:
      if (m <= k) {
        break label152;
      }
      if (m <= 160) {
        break label132;
      }
    }
    for (;;)
    {
      label91:
      k = (int)(i / f1);
      if (k < 80) {}
      for (;;)
      {
        return new int[] { j, i };
        f1 = k / m;
        break;
        label129:
        break label76;
        label132:
        if (m >= 100) {
          break label213;
        }
        i = 100;
        break label91;
        j = k;
      }
      label152:
      if (k > 160) {}
      for (;;)
      {
        label160:
        k = (int)(i / f1);
        if (k < 80) {}
        for (;;)
        {
          k = i;
          i = j;
          j = k;
          break;
          if (k >= 100) {
            break label207;
          }
          i = 100;
          break label160;
          j = k;
        }
        label207:
        i = k;
      }
      label213:
      i = m;
    }
  }
  
  public static native int adjustMoovPosition(String paramString1, String paramString2);
  
  @TargetApi(14)
  public static long b(String paramString)
  {
    if (!FileUtils.a(paramString)) {
      return 0L;
    }
    return VideoCompositeHelper.a(paramString);
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder;
    do
    {
      String str = VidUtil.a();
      localStringBuilder = new StringBuilder(c());
      localStringBuilder.append(str).append(".mp4");
    } while (new File(localStringBuilder.toString()).exists());
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
    if (paramMessageForShortVideo.isSend()) {
      return paramMessageForShortVideo.selfuin;
    }
    if ((paramMessageForShortVideo.istroop == 1) || (paramMessageForShortVideo.istroop == 3000)) {
      return paramMessageForShortVideo.senderuin;
    }
    return paramMessageForShortVideo.frienduin;
  }
  
  public static String b(MessageForShortVideo paramMessageForShortVideo, String paramString)
  {
    if (paramMessageForShortVideo != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(d(paramMessageForShortVideo.getMd5()));
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
    paramFile = VidUtil.a(paramFile);
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.aJ);
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
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = VidUtil.a(new File(paramString));
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.aJ);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("temp");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("source");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append("watermark");
    localStringBuilder.append(".png");
    return localStringBuilder.toString();
  }
  
  public static String b(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(e());
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
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
          int i = Integer.valueOf(localObject[0]).intValue();
          if ((i >= 0) && (i <= 2)) {
            jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(i);
          }
          i = Integer.valueOf(localObject[1]).intValue();
          if ((i >= 0) && (i <= 60)) {
            jdField_a_of_type_Int = i;
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
  
  public static String c()
  {
    String str = Build.MODEL.toUpperCase();
    if (str.contains("GN9000L")) {
      return AppConstants.cq;
    }
    if ((str.contains("MX4")) || (str.contains("MX6")) || (str.contains("MX5")) || (str.contains("M355")) || (str.contains("M571C"))) {
      return AppConstants.cp;
    }
    if (str.contains("M040")) {
      return AppConstants.cs;
    }
    if ((str.contains("VIVO X7")) || (str.contains("VIVO X6A")) || (str.contains("VIVO XPLAY6")) || (str.contains("VIVO X5PRO"))) {
      return AppConstants.cr;
    }
    return AppConstants.aV;
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
  
  public static String c(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    paramFile = VidUtil.a(paramFile);
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.aJ);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("temp");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("source");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramFile);
    localStringBuilder.append("_local");
    localStringBuilder.append(".mp4");
    return localStringBuilder.toString();
  }
  
  public static String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("QQ视频");
    localStringBuilder.append("_").append(paramString);
    return localStringBuilder.toString();
  }
  
  @TargetApi(9)
  public static String c(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      String str = MD5.toMD5(paramString1);
      StringBuilder localStringBuilder = new StringBuilder(AppConstants.aJ);
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
  
  public static boolean c()
  {
    boolean bool = false;
    String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      if (Build.MODEL.equalsIgnoreCase(str)) {
        bool = true;
      }
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUtils", 2, "isInFullScreenBlackList(), result=" + bool);
    }
    return bool;
  }
  
  public static String d()
  {
    String str = VidUtil.a();
    return AppConstants.aJ + "shortvideo" + File.separator + "temp" + File.separator + "source" + File.separator + str + "watermark.png";
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
  
  public static String d(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    paramFile = VidUtil.a(paramFile);
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.aJ);
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
  
  private static String d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.aJ);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static boolean d()
  {
    if (!c) {}
    try
    {
      Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1|1|999|4|1");
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUtils", 2, "needBlockBrokenVideo:" + (String)localObject);
      }
      localObject = ((String)localObject).split("\\|");
      if (localObject.length > 5) {
        f = localObject[5].equals("1");
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
    c = true;
    return f;
  }
  
  private static String e()
  {
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.aJ);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
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
    //   20: invokestatic 1130	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   23: astore 13
    //   25: new 1132	java/io/FileInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 1135	java/io/FileInputStream:<init>	(Ljava/io/File;)V
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
    //   50: invokevirtual 1141	java/io/InputStream:read	([B)I
    //   53: istore_3
    //   54: iload_3
    //   55: ifgt +41 -> 96
    //   58: aload 9
    //   60: ifnull +8 -> 68
    //   63: aload 9
    //   65: invokevirtual 1144	java/io/InputStream:close	()V
    //   68: new 92	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   75: iload_2
    //   76: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   79: ldc_w 1146
    //   82: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: lload 5
    //   87: invokevirtual 197	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   90: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: astore_0
    //   94: aload_0
    //   95: areturn
    //   96: aload 9
    //   98: astore_0
    //   99: aload 13
    //   101: iconst_4
    //   102: newarray byte
    //   104: invokevirtual 1150	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   107: pop
    //   108: aload 9
    //   110: astore_0
    //   111: aload 13
    //   113: aload 10
    //   115: invokevirtual 1150	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   118: pop
    //   119: aload 9
    //   121: astore_0
    //   122: aload 13
    //   124: invokevirtual 1154	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   127: pop
    //   128: aload 9
    //   130: astore_0
    //   131: aload 13
    //   133: invokevirtual 1157	java/nio/ByteBuffer:getLong	()J
    //   136: lstore 7
    //   138: aload 9
    //   140: astore_0
    //   141: iload_3
    //   142: aload 9
    //   144: aload 12
    //   146: invokevirtual 1141	java/io/InputStream:read	([B)I
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
    //   184: invokevirtual 1141	java/io/InputStream:read	([B)I
    //   187: iadd
    //   188: istore_3
    //   189: aload 9
    //   191: astore_0
    //   192: aload 13
    //   194: invokevirtual 1160	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   197: pop
    //   198: aload 9
    //   200: astore_0
    //   201: aload 13
    //   203: aload 14
    //   205: invokevirtual 1150	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   208: pop
    //   209: aload 9
    //   211: astore_0
    //   212: aload 13
    //   214: invokevirtual 1154	java/nio/ByteBuffer:flip	()Ljava/nio/Buffer;
    //   217: pop
    //   218: aload 9
    //   220: astore_0
    //   221: aload 13
    //   223: invokevirtual 1157	java/nio/ByteBuffer:getLong	()J
    //   226: lstore 5
    //   228: goto +107 -> 335
    //   231: aload 9
    //   233: astore_0
    //   234: aload 9
    //   236: lload 5
    //   238: iload_3
    //   239: i2l
    //   240: lsub
    //   241: invokevirtual 1163	java/io/InputStream:skip	(J)J
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
    //   257: invokevirtual 1160	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
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
    //   278: invokevirtual 128	java/lang/Exception:printStackTrace	()V
    //   281: aload 11
    //   283: astore_0
    //   284: aload 9
    //   286: ifnull -192 -> 94
    //   289: aload 9
    //   291: invokevirtual 1144	java/io/InputStream:close	()V
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
    //   308: invokevirtual 1144	java/io/InputStream:close	()V
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
    //   4	261	1	i	int
    //   36	216	2	j	int
    //   53	186	3	k	int
    //   150	38	4	m	int
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
    if (!g) {
      g = true;
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
        int i = Integer.valueOf(localObject[10]).intValue();
        if ((i >= 0) && (i <= 1)) {
          jdField_b_of_type_Int = i;
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
    boolean bool2 = CameraUtils.a();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUtils", 2, "supportShortVideoMergePhoto dpc:" + jdField_b_of_type_Int + " choiceQC:" + bool2);
    }
    return (!bool1) || (!bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoUtils
 * JD-Core Version:    0.7.0.1
 */