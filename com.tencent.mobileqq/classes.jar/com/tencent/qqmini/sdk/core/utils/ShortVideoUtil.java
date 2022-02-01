package com.tencent.qqmini.sdk.core.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Environment;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.File;

public class ShortVideoUtil
{
  static String SDCARD_IMG_CAMERA;
  static String SDCARD_IMG_VIDEO;
  static String SDCARD_IMG_VIDEO_GN9000L;
  static String SDCARD_IMG_VIDEO_RUBBISH_MX040;
  static String SDCARD_IMG_VIDEO_VIVO_X7;
  static String SDCARD_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath();
  private static final String TAG = "ShortVideoUtil";
  static int VIDEO_THUMBNAIL_MAX_LENGTH_DEFAULT = 640;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(SDCARD_ROOT);
    localStringBuilder.append("/DCIM/Video/");
    SDCARD_IMG_VIDEO = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(SDCARD_ROOT);
    localStringBuilder.append("/照相机/Camera/");
    SDCARD_IMG_VIDEO_GN9000L = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(SDCARD_ROOT);
    localStringBuilder.append("/相机/");
    SDCARD_IMG_VIDEO_VIVO_X7 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(SDCARD_ROOT);
    localStringBuilder.append("/Camera/Video/");
    SDCARD_IMG_VIDEO_RUBBISH_MX040 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(SDCARD_ROOT);
    localStringBuilder.append("/DCIM/Camera/");
    SDCARD_IMG_CAMERA = localStringBuilder.toString();
  }
  
  public static String getCameraPath()
  {
    String str = Build.MODEL.toUpperCase();
    if (str.contains("GN9000L")) {
      str = SDCARD_IMG_VIDEO_GN9000L;
    } else if (isDCIMVideoModel(str)) {
      str = SDCARD_IMG_VIDEO;
    } else if (str.contains("M040")) {
      str = SDCARD_IMG_VIDEO_RUBBISH_MX040;
    } else if (isVIVOX7Model(str)) {
      str = SDCARD_IMG_VIDEO_VIVO_X7;
    } else {
      str = SDCARD_IMG_CAMERA;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getCameraPath: commonPath=");
    localStringBuilder.append(str);
    QMLog.d("ShortVideoUtil", localStringBuilder.toString());
    return str;
  }
  
  @TargetApi(10)
  public static Bitmap getVideoThumbnail(Context paramContext, String paramString)
  {
    return getVideoThumbnail(paramContext, paramString, VIDEO_THUMBNAIL_MAX_LENGTH_DEFAULT);
  }
  
  @TargetApi(10)
  public static Bitmap getVideoThumbnail(Context paramContext, String paramString, int paramInt)
  {
    return getVideoThumbnail(paramContext, paramString, paramInt, -1L);
  }
  
  /* Error */
  @TargetApi(10)
  public static Bitmap getVideoThumbnail(Context paramContext, String paramString, int paramInt, long paramLong)
  {
    // Byte code:
    //   0: iload_2
    //   1: istore 6
    //   3: iload_2
    //   4: ifgt +8 -> 12
    //   7: getstatic 66	com/tencent/qqmini/sdk/core/utils/ShortVideoUtil:VIDEO_THUMBNAIL_MAX_LENGTH_DEFAULT	I
    //   10: istore 6
    //   12: invokestatic 128	java/lang/System:currentTimeMillis	()J
    //   15: lstore 9
    //   17: new 130	android/media/MediaMetadataRetriever
    //   20: dup
    //   21: invokespecial 131	android/media/MediaMetadataRetriever:<init>	()V
    //   24: astore 12
    //   26: aconst_null
    //   27: astore 11
    //   29: aload 12
    //   31: aload_1
    //   32: invokevirtual 135	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   35: aload 12
    //   37: lload_3
    //   38: invokevirtual 139	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   41: astore_0
    //   42: aload 12
    //   44: invokevirtual 142	android/media/MediaMetadataRetriever:release	()V
    //   47: goto +33 -> 80
    //   50: astore_0
    //   51: goto +20 -> 71
    //   54: astore_0
    //   55: ldc 14
    //   57: ldc 144
    //   59: aload_0
    //   60: invokestatic 147	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   63: aload 12
    //   65: invokevirtual 142	android/media/MediaMetadataRetriever:release	()V
    //   68: goto +10 -> 78
    //   71: aload 12
    //   73: invokevirtual 142	android/media/MediaMetadataRetriever:release	()V
    //   76: aload_0
    //   77: athrow
    //   78: aconst_null
    //   79: astore_0
    //   80: aload_0
    //   81: ifnonnull +5 -> 86
    //   84: aconst_null
    //   85: areturn
    //   86: aload_0
    //   87: invokevirtual 153	android/graphics/Bitmap:getWidth	()I
    //   90: istore 7
    //   92: aload_0
    //   93: invokevirtual 156	android/graphics/Bitmap:getHeight	()I
    //   96: istore_2
    //   97: iload 7
    //   99: iload_2
    //   100: invokestatic 162	java/lang/Math:max	(II)I
    //   103: istore 8
    //   105: iload 8
    //   107: iload 6
    //   109: if_icmple +55 -> 164
    //   112: iload 6
    //   114: i2f
    //   115: iload 8
    //   117: i2f
    //   118: fdiv
    //   119: fstore 5
    //   121: iload 7
    //   123: i2f
    //   124: fload 5
    //   126: fmul
    //   127: invokestatic 166	java/lang/Math:round	(F)I
    //   130: istore 6
    //   132: fload 5
    //   134: iload_2
    //   135: i2f
    //   136: fmul
    //   137: invokestatic 166	java/lang/Math:round	(F)I
    //   140: istore_2
    //   141: aload_0
    //   142: iload 6
    //   144: iload_2
    //   145: iconst_1
    //   146: invokestatic 170	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   149: astore_0
    //   150: goto +14 -> 164
    //   153: astore_0
    //   154: aload_0
    //   155: invokevirtual 173	java/lang/OutOfMemoryError:printStackTrace	()V
    //   158: aload 11
    //   160: astore_0
    //   161: goto +3 -> 164
    //   164: invokestatic 128	java/lang/System:currentTimeMillis	()J
    //   167: lstore_3
    //   168: aload_0
    //   169: ifnull +107 -> 276
    //   172: invokestatic 177	com/tencent/qqmini/sdk/launcher/log/QMLog:isColorLevel	()Z
    //   175: ifeq +141 -> 316
    //   178: new 34	java/lang/StringBuilder
    //   181: dup
    //   182: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   185: astore 11
    //   187: aload 11
    //   189: ldc 179
    //   191: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 11
    //   197: aload_0
    //   198: invokevirtual 153	android/graphics/Bitmap:getWidth	()I
    //   201: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 11
    //   207: ldc 184
    //   209: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload 11
    //   215: aload_0
    //   216: invokevirtual 156	android/graphics/Bitmap:getHeight	()I
    //   219: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload 11
    //   225: ldc 186
    //   227: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload 11
    //   233: aload_1
    //   234: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 11
    //   240: ldc 188
    //   242: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload 11
    //   248: lload_3
    //   249: lload 9
    //   251: lsub
    //   252: invokevirtual 191	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload 11
    //   258: ldc 193
    //   260: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: ldc 14
    //   266: aload 11
    //   268: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 102	com/tencent/qqmini/sdk/launcher/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: aload_0
    //   275: areturn
    //   276: invokestatic 177	com/tencent/qqmini/sdk/launcher/log/QMLog:isColorLevel	()Z
    //   279: ifeq +37 -> 316
    //   282: new 34	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 37	java/lang/StringBuilder:<init>	()V
    //   289: astore 11
    //   291: aload 11
    //   293: ldc 195
    //   295: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload 11
    //   301: aload_1
    //   302: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: ldc 14
    //   308: aload 11
    //   310: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   313: invokestatic 198	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: aload_0
    //   317: areturn
    //   318: astore_0
    //   319: goto -256 -> 63
    //   322: astore 12
    //   324: goto -244 -> 80
    //   327: astore_0
    //   328: goto -250 -> 78
    //   331: astore_1
    //   332: goto -256 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	paramContext	Context
    //   0	335	1	paramString	String
    //   0	335	2	paramInt	int
    //   0	335	3	paramLong	long
    //   119	14	5	f	float
    //   1	142	6	i	int
    //   90	32	7	j	int
    //   103	13	8	k	int
    //   15	235	9	l	long
    //   27	282	11	localStringBuilder	StringBuilder
    //   24	48	12	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   322	1	12	localRuntimeException	java.lang.RuntimeException
    // Exception table:
    //   from	to	target	type
    //   29	42	50	finally
    //   55	63	50	finally
    //   29	42	54	java/lang/OutOfMemoryError
    //   141	150	153	java/lang/OutOfMemoryError
    //   29	42	318	java/lang/IllegalArgumentException
    //   29	42	318	java/lang/RuntimeException
    //   42	47	322	java/lang/RuntimeException
    //   63	68	327	java/lang/RuntimeException
    //   71	76	331	java/lang/RuntimeException
  }
  
  private static boolean isDCIMVideoModel(String paramString)
  {
    return (paramString.contains("MX4")) || (paramString.contains("MX6")) || (paramString.contains("MX5")) || (paramString.contains("M355")) || (paramString.contains("M571C"));
  }
  
  private static boolean isVIVOX7Model(String paramString)
  {
    return (paramString.contains("VIVO X7")) || (paramString.contains("VIVO X6A")) || (paramString.contains("VIVO XPLAY6")) || (paramString.contains("VIVO X5PRO")) || (paramString.contains("VIVO X9 PLUS")) || (paramString.contains("VIVO Y51A")) || (paramString.contains("VIVO X9I")) || (paramString.contains("VIVO X9")) || (paramString.contains("VIVO X6D"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.utils.ShortVideoUtil
 * JD-Core Version:    0.7.0.1
 */