package dov.com.tencent.mobileqq.shortvideo;

import ajni;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Build;
import android.text.TextUtils;
import android.text.format.Formatter;
import ayyw;
import bdcs;
import bnoj;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import uku;

public class ShortVideoUtils
  implements ayyw
{
  private static int jdField_a_of_type_Int;
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  public static boolean a;
  private static int[] jdField_a_of_type_ArrayOfInt;
  private static String[] jdField_a_of_type_ArrayOfJavaLangString = { "GT-N7108" };
  private static int b;
  public static boolean b;
  private static volatile boolean c;
  private static boolean d;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Boolean = true;
    d = true;
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    jdField_a_of_type_Int = 2;
    jdField_b_of_type_Int = 1;
    jdField_a_of_type_ArrayOfInt = new int[] { 1, 97, 125 };
    ThreadManager.getSubThreadHandler().post(new ShortVideoUtils.1());
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
    //   12: invokestatic 145	java/lang/System:currentTimeMillis	()J
    //   15: lstore 9
    //   17: new 147	android/media/MediaMetadataRetriever
    //   20: dup
    //   21: invokespecial 148	android/media/MediaMetadataRetriever:<init>	()V
    //   24: astore 11
    //   26: aload 11
    //   28: aload_1
    //   29: invokevirtual 149	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   32: aload 11
    //   34: lload_3
    //   35: invokevirtual 153	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   38: astore_0
    //   39: aload 11
    //   41: invokevirtual 154	android/media/MediaMetadataRetriever:release	()V
    //   44: aload_0
    //   45: ifnonnull +49 -> 94
    //   48: aconst_null
    //   49: astore_0
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: aload 11
    //   55: invokevirtual 154	android/media/MediaMetadataRetriever:release	()V
    //   58: aconst_null
    //   59: astore_0
    //   60: goto -16 -> 44
    //   63: astore_0
    //   64: aconst_null
    //   65: astore_0
    //   66: goto -22 -> 44
    //   69: astore_0
    //   70: aload 11
    //   72: invokevirtual 154	android/media/MediaMetadataRetriever:release	()V
    //   75: aconst_null
    //   76: astore_0
    //   77: goto -33 -> 44
    //   80: astore_0
    //   81: aconst_null
    //   82: astore_0
    //   83: goto -39 -> 44
    //   86: astore_0
    //   87: aload 11
    //   89: invokevirtual 154	android/media/MediaMetadataRetriever:release	()V
    //   92: aload_0
    //   93: athrow
    //   94: aload_0
    //   95: invokevirtual 159	android/graphics/Bitmap:getWidth	()I
    //   98: istore_2
    //   99: aload_0
    //   100: invokevirtual 162	android/graphics/Bitmap:getHeight	()I
    //   103: istore 7
    //   105: iload_2
    //   106: iload 7
    //   108: invokestatic 168	java/lang/Math:max	(II)I
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
    //   138: invokestatic 172	java/lang/Math:round	(F)I
    //   141: iload 7
    //   143: i2f
    //   144: fload 5
    //   146: fmul
    //   147: invokestatic 172	java/lang/Math:round	(F)I
    //   150: iconst_1
    //   151: invokestatic 176	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   154: astore 11
    //   156: invokestatic 145	java/lang/System:currentTimeMillis	()J
    //   159: lstore_3
    //   160: aload 11
    //   162: ifnull +83 -> 245
    //   165: aload 11
    //   167: astore_0
    //   168: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   171: ifeq -121 -> 50
    //   174: ldc 80
    //   176: iconst_2
    //   177: new 82	java/lang/StringBuilder
    //   180: dup
    //   181: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   184: ldc 178
    //   186: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload 11
    //   191: invokevirtual 159	android/graphics/Bitmap:getWidth	()I
    //   194: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: ldc 183
    //   199: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 11
    //   204: invokevirtual 162	android/graphics/Bitmap:getHeight	()I
    //   207: invokevirtual 181	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   210: ldc 185
    //   212: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_1
    //   216: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: ldc 187
    //   221: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: lload_3
    //   225: lload 9
    //   227: lsub
    //   228: invokevirtual 190	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   231: ldc 192
    //   233: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: invokestatic 194	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   242: aload 11
    //   244: areturn
    //   245: aload 11
    //   247: astore_0
    //   248: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   251: ifeq -201 -> 50
    //   254: ldc 80
    //   256: iconst_2
    //   257: new 82	java/lang/StringBuilder
    //   260: dup
    //   261: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   264: ldc 196
    //   266: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: aload_1
    //   270: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 99	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   130	15	5	f	float
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
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(c());
    localStringBuilder.append("thumbs");
    localStringBuilder.append(File.separator);
    Object localObject = new File(localStringBuilder.toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = localStringBuilder.toString() + ".nomedia";
    if (!new File((String)localObject).exists()) {
      bdcs.c((String)localObject);
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
        if (bdcs.b(paramString)) {
          bool2 = false;
        }
      }
      paramMessageForShortVideo = c(paramMessageForShortVideo.getMd5());
      localObject = new File(paramMessageForShortVideo);
      if (((File)localObject).exists()) {
        break;
      }
      ((File)localObject).mkdirs();
      bdcs.c(paramMessageForShortVideo + ".nomedia");
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
          break label382;
        }
        str = localObject[i];
        if ((!str.endsWith(".tmp")) && (!str.equals(".nomedia"))) {
          break;
        }
        i += 1;
      }
    }
    label382:
    for (paramMessageForShortVideo = paramMessageForShortVideo + str;; paramMessageForShortVideo = null)
    {
      if ((bool2) && (paramMessageForShortVideo != null) && (!new File(paramString).exists()))
      {
        long l1 = System.currentTimeMillis();
        if (paramMessageForShortVideo.equals(paramString)) {
          return paramString;
        }
        bdcs.d(paramMessageForShortVideo, paramString);
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
    paramFile = bnoj.a(paramFile);
    StringBuilder localStringBuilder = new StringBuilder(ajni.d);
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
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = bnoj.a(new File(paramString));
    StringBuilder localStringBuilder = new StringBuilder(ajni.d);
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
  
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(a());
    localStringBuilder.append(paramString1);
    localStringBuilder.append(".");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static String a(HashSet<Integer> paramHashSet)
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    paramHashSet = paramHashSet.iterator();
    int i = 1;
    while (paramHashSet.hasNext())
    {
      if (i == 0) {
        localStringBuilder.append(",");
      }
      i = 0;
      localStringBuilder.append(paramHashSet.next());
    }
    return localStringBuilder.toString();
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    try
    {
      if (!a())
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
  
  public static boolean a()
  {
    return VideoEnvironment.e();
  }
  
  public static int[] a()
  {
    return jdField_a_of_type_ArrayOfInt;
  }
  
  public static native int adjustMoovPosition(String paramString1, String paramString2);
  
  @TargetApi(14)
  public static long b(String paramString)
  {
    if (!bdcs.a(paramString)) {
      return 0L;
    }
    return uku.a(paramString);
  }
  
  public static String b()
  {
    String str = bnoj.a();
    return ajni.d + "shortvideo" + File.separator + "temp" + File.separator + "source" + File.separator + str + "watermark.png";
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
  
  public static String b(MessageForShortVideo paramMessageForShortVideo, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(c(paramMessageForShortVideo.getMd5()));
    localStringBuilder.append(paramMessageForShortVideo.frienduin);
    localStringBuilder.append(Math.abs(paramMessageForShortVideo.uniseq));
    localStringBuilder.append(".");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String b(File paramFile)
  {
    if (paramFile == null) {
      return null;
    }
    paramFile = bnoj.a(paramFile);
    StringBuilder localStringBuilder = new StringBuilder(ajni.d);
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
  
  public static String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("QIM视频");
    localStringBuilder.append("_").append(paramString);
    return localStringBuilder.toString();
  }
  
  @TargetApi(9)
  public static String b(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      String str = MD5.toMD5(paramString1);
      StringBuilder localStringBuilder = new StringBuilder(ajni.d);
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
  
  public static boolean b()
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
  
  private static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder(ajni.d);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
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
  
  private static String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(ajni.d);
    localStringBuilder.append("shortvideo");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils
 * JD-Core Version:    0.7.0.1
 */