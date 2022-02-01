package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class ShortVideoThumbDownloader
  extends AbsDownloader
{
  public static final String PROTOCOL_SHORT_VIDEO_THUMB = "shortvideothumb";
  private static final String TAG = "ShortVideoThumbDownloader";
  
  public static Bitmap getRoundedCornerBitmap(Bitmap paramBitmap, int paramInt)
  {
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
      localBitmap.setDensity(160);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
      RectF localRectF = new RectF(new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()));
      float f = paramInt;
      localPaint.setAntiAlias(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-16777216);
      localCanvas.drawRoundRect(localRectF, f, f, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), localRect, localPaint);
      return localBitmap;
    }
    catch (Exception localException) {}
    return paramBitmap;
  }
  
  /* Error */
  public java.lang.Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 105	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   4: astore_1
    //   5: aload_1
    //   6: invokestatic 111	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   9: ifne +19 -> 28
    //   12: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15: ifeq +11 -> 26
    //   18: ldc 11
    //   20: iconst_2
    //   21: ldc 119
    //   23: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aconst_null
    //   27: areturn
    //   28: new 125	android/graphics/BitmapFactory$Options
    //   31: dup
    //   32: invokespecial 126	android/graphics/BitmapFactory$Options:<init>	()V
    //   35: astore 4
    //   37: aload 4
    //   39: sipush 160
    //   42: putfield 130	android/graphics/BitmapFactory$Options:inDensity	I
    //   45: aload 4
    //   47: sipush 160
    //   50: putfield 133	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   53: aload 4
    //   55: sipush 160
    //   58: putfield 136	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   61: aload 4
    //   63: iconst_1
    //   64: putfield 140	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   67: aload_1
    //   68: aload 4
    //   70: invokestatic 145	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   73: pop
    //   74: aload 4
    //   76: iconst_0
    //   77: putfield 140	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   80: aload 4
    //   82: aload_0
    //   83: aload 4
    //   85: aload_2
    //   86: getfield 150	com/tencent/image/DownloadParams:reqWidth	I
    //   89: aload_2
    //   90: getfield 153	com/tencent/image/DownloadParams:reqHeight	I
    //   93: invokevirtual 157	com/tencent/mobileqq/transfile/ShortVideoThumbDownloader:calculateSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   96: putfield 160	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   99: new 162	java/io/BufferedInputStream
    //   102: dup
    //   103: new 164	java/io/FileInputStream
    //   106: dup
    //   107: aload_1
    //   108: invokespecial 167	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   111: invokespecial 170	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   114: astore_3
    //   115: aload_3
    //   116: astore_1
    //   117: aload_3
    //   118: aconst_null
    //   119: aload 4
    //   121: invokestatic 176	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   124: astore 4
    //   126: aload_3
    //   127: astore_1
    //   128: aload_2
    //   129: getfield 180	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   132: astore 5
    //   134: aload 4
    //   136: astore_2
    //   137: aload_3
    //   138: astore_1
    //   139: aload 5
    //   141: instanceof 182
    //   144: ifeq +39 -> 183
    //   147: aload 4
    //   149: astore_2
    //   150: aload_3
    //   151: astore_1
    //   152: aload 5
    //   154: checkcast 182	[I
    //   157: checkcast 182	[I
    //   160: arraylength
    //   161: iconst_3
    //   162: if_icmpne +21 -> 183
    //   165: aload_3
    //   166: astore_1
    //   167: aload 4
    //   169: aload 5
    //   171: checkcast 182	[I
    //   174: checkcast 182	[I
    //   177: iconst_2
    //   178: iaload
    //   179: invokestatic 184	com/tencent/mobileqq/transfile/ShortVideoThumbDownloader:getRoundedCornerBitmap	(Landroid/graphics/Bitmap;I)Landroid/graphics/Bitmap;
    //   182: astore_2
    //   183: aload_3
    //   184: invokevirtual 187	java/io/BufferedInputStream:close	()V
    //   187: aload_2
    //   188: areturn
    //   189: astore_1
    //   190: aload_3
    //   191: astore_2
    //   192: aload_1
    //   193: astore_3
    //   194: goto +12 -> 206
    //   197: astore_2
    //   198: aconst_null
    //   199: astore_1
    //   200: goto +36 -> 236
    //   203: astore_3
    //   204: aconst_null
    //   205: astore_2
    //   206: aload_2
    //   207: astore_1
    //   208: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   211: ifeq +14 -> 225
    //   214: aload_2
    //   215: astore_1
    //   216: ldc 11
    //   218: iconst_2
    //   219: ldc 189
    //   221: aload_3
    //   222: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   225: aload_2
    //   226: ifnull +7 -> 233
    //   229: aload_2
    //   230: invokevirtual 187	java/io/BufferedInputStream:close	()V
    //   233: aconst_null
    //   234: areturn
    //   235: astore_2
    //   236: aload_1
    //   237: ifnull +7 -> 244
    //   240: aload_1
    //   241: invokevirtual 187	java/io/BufferedInputStream:close	()V
    //   244: aload_2
    //   245: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	ShortVideoThumbDownloader
    //   0	246	1	paramFile	File
    //   0	246	2	paramDownloadParams	DownloadParams
    //   0	246	3	paramURLDrawableHandler	URLDrawableHandler
    //   35	133	4	localObject1	java.lang.Object
    //   132	38	5	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   117	126	189	java/lang/OutOfMemoryError
    //   128	134	189	java/lang/OutOfMemoryError
    //   139	147	189	java/lang/OutOfMemoryError
    //   152	165	189	java/lang/OutOfMemoryError
    //   167	183	189	java/lang/OutOfMemoryError
    //   99	115	197	finally
    //   99	115	203	java/lang/OutOfMemoryError
    //   117	126	235	finally
    //   128	134	235	finally
    //   139	147	235	finally
    //   152	165	235	finally
    //   167	183	235	finally
    //   208	214	235	finally
    //   216	225	235	finally
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return new File(paramDownloadParams.url.getFile());
  }
  
  public boolean useDiskCache()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoThumbDownloader
 * JD-Core Version:    0.7.0.1
 */