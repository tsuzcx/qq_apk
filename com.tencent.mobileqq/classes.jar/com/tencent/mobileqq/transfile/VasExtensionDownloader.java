package com.tencent.mobileqq.transfile;

import amuo;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import aqyy;
import areb;
import avsq;
import bfpx;
import bgoe;
import bgog;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.JobQueue;
import com.tencent.image.NativeGifFactory;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

public class VasExtensionDownloader
  extends AbsDownloader
{
  public static final String BUSINESS_CAMERA_EMO_PANEL_DYNAMIC = "BUSINESS_CAMERA_EMO_PANEL_DYNAMIC";
  public static final String BUSINESS_CAMERA_EMO_PANEL_THUMB = "BUSINESS_CAMERA_EMO_PANEL_THUMB";
  public static final String BUSINESS_COMMERCIAL_DRAINAGE = "COMMERCIAL_DRAINAGE";
  public static final String BUSINESS_EMOTICON_DIY = "EMOTICON_DIY";
  public static final String BUSINESS_EMOTICON_TAB = "EMOTICON_TAB";
  public static final String BUSINESS_FAVORITE_PANEL_DYNAMIC = "FAVOROTE_PANEL_DYNAMIC";
  public static final String BUSINESS_FAVORITE_PANEL_THUMB = "FAVORITE_PANEL_THUMB";
  public static final String BUSINESS_FAVORITE_PANEL_THUMB_NEW = "FAVORITE_PANEL_THUMB_NEW";
  public static final String BUSINESS_FONT_BUBBLE = "FONT_BUBBLE";
  public static final String BUSINESS_REDPACKET_SEND_PIC = "REDPACKET_SEND_PIC";
  public static final String BUSINESS_RESOURCE_IMG = "RESOURCE_IMG";
  public static final String COMIC_IPSITE_GAME_IMAGE = "COMIC_IPSITE_GAME_IMAGE";
  public static final String COMIC_IP_SITE_ROUND_IMAGE = "COMIC_IP_SITE_ROUND_IMAGE";
  public static final String IP_SITE_IMAGE = "IP_SITE_IMAGE";
  public static final String PROTOCOL_VAS_EXTENSION = "protocol_vas_extension_image";
  public static final String TAG = "VasExtensionDownloader";
  protected BaseApplicationImpl application;
  
  public VasExtensionDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.application = paramBaseApplicationImpl;
  }
  
  /* Error */
  @Nullable
  private Object decodeFileBusinessDrainage(File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: ldc 48
    //   6: iconst_1
    //   7: ldc 65
    //   9: invokestatic 71	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   12: aconst_null
    //   13: areturn
    //   14: aload_1
    //   15: invokevirtual 77	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   18: astore_1
    //   19: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   22: ifeq +28 -> 50
    //   25: ldc 48
    //   27: iconst_2
    //   28: new 83	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   35: ldc 86
    //   37: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: new 98	java/io/FileInputStream
    //   53: dup
    //   54: aload_1
    //   55: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   58: astore_2
    //   59: new 103	java/io/BufferedInputStream
    //   62: dup
    //   63: aload_2
    //   64: invokespecial 106	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   67: invokestatic 112	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   70: astore_1
    //   71: aload_2
    //   72: invokevirtual 115	java/io/FileInputStream:close	()V
    //   75: aload_1
    //   76: invokevirtual 121	android/graphics/Bitmap:getWidth	()I
    //   79: aload_1
    //   80: invokevirtual 124	android/graphics/Bitmap:getHeight	()I
    //   83: getstatic 130	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   86: invokestatic 134	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   89: astore_2
    //   90: new 136	android/graphics/Canvas
    //   93: dup
    //   94: aload_2
    //   95: invokespecial 139	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   98: astore_3
    //   99: new 141	android/graphics/Paint
    //   102: dup
    //   103: invokespecial 142	android/graphics/Paint:<init>	()V
    //   106: astore 4
    //   108: new 144	android/graphics/Rect
    //   111: dup
    //   112: iconst_0
    //   113: iconst_0
    //   114: aload_1
    //   115: invokevirtual 121	android/graphics/Bitmap:getWidth	()I
    //   118: aload_1
    //   119: invokevirtual 124	android/graphics/Bitmap:getHeight	()I
    //   122: invokespecial 147	android/graphics/Rect:<init>	(IIII)V
    //   125: astore 5
    //   127: new 149	android/graphics/RectF
    //   130: dup
    //   131: new 144	android/graphics/Rect
    //   134: dup
    //   135: iconst_0
    //   136: iconst_0
    //   137: aload_1
    //   138: invokevirtual 121	android/graphics/Bitmap:getWidth	()I
    //   141: aload_1
    //   142: invokevirtual 124	android/graphics/Bitmap:getHeight	()I
    //   145: invokespecial 147	android/graphics/Rect:<init>	(IIII)V
    //   148: invokespecial 152	android/graphics/RectF:<init>	(Landroid/graphics/Rect;)V
    //   151: astore 6
    //   153: aload 4
    //   155: iconst_1
    //   156: invokevirtual 156	android/graphics/Paint:setAntiAlias	(Z)V
    //   159: aload_3
    //   160: iconst_0
    //   161: iconst_0
    //   162: iconst_0
    //   163: iconst_0
    //   164: invokevirtual 159	android/graphics/Canvas:drawARGB	(IIII)V
    //   167: aload 4
    //   169: ldc 160
    //   171: invokevirtual 164	android/graphics/Paint:setColor	(I)V
    //   174: aload_3
    //   175: aload 6
    //   177: ldc 165
    //   179: ldc 165
    //   181: aload 4
    //   183: invokevirtual 169	android/graphics/Canvas:drawRoundRect	(Landroid/graphics/RectF;FFLandroid/graphics/Paint;)V
    //   186: aload 4
    //   188: new 171	android/graphics/PorterDuffXfermode
    //   191: dup
    //   192: getstatic 177	android/graphics/PorterDuff$Mode:SRC_IN	Landroid/graphics/PorterDuff$Mode;
    //   195: invokespecial 180	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   198: invokevirtual 184	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   201: pop
    //   202: aload_3
    //   203: aload_1
    //   204: new 144	android/graphics/Rect
    //   207: dup
    //   208: iconst_0
    //   209: iconst_0
    //   210: aload_1
    //   211: invokevirtual 121	android/graphics/Bitmap:getWidth	()I
    //   214: aload_1
    //   215: invokevirtual 124	android/graphics/Bitmap:getHeight	()I
    //   218: invokespecial 147	android/graphics/Rect:<init>	(IIII)V
    //   221: aload 5
    //   223: aload 4
    //   225: invokevirtual 188	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   228: aload_2
    //   229: areturn
    //   230: astore_2
    //   231: ldc 48
    //   233: iconst_1
    //   234: ldc 190
    //   236: aload_2
    //   237: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   240: aload_1
    //   241: areturn
    //   242: astore_1
    //   243: ldc 48
    //   245: iconst_1
    //   246: new 83	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   253: ldc 195
    //   255: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: aload_1
    //   259: invokevirtual 198	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   262: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 71	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: aconst_null
    //   272: areturn
    //   273: astore_2
    //   274: ldc 48
    //   276: iconst_1
    //   277: new 83	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   284: ldc 200
    //   286: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload_2
    //   290: invokevirtual 198	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   293: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 71	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: goto -227 -> 75
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	305	0	this	VasExtensionDownloader
    //   0	305	1	paramFile	File
    //   58	171	2	localObject	Object
    //   230	7	2	localException1	Exception
    //   273	17	2	localException2	Exception
    //   98	105	3	localCanvas	Canvas
    //   106	118	4	localPaint	Paint
    //   125	97	5	localRect	Rect
    //   151	25	6	localRectF	RectF
    // Exception table:
    //   from	to	target	type
    //   75	228	230	java/lang/Exception
    //   59	71	242	java/lang/Exception
    //   71	75	273	java/lang/Exception
  }
  
  @Nullable
  private Object decodeFileBusinessEmoDiy(DownloadParams paramDownloadParams)
  {
    try
    {
      String str = paramDownloadParams.url.getFile();
      if (aqyy.b(str))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasExtensionDownloader", 2, "decodeFile isGifFile,path=" + str);
        }
        return NativeGifFactory.getNativeGifObject(new File(str), true, true, 0, 0, 0.0F);
      }
      if (QLog.isColorLevel()) {
        QLog.d("VasExtensionDownloader", 2, "decodeFile getDecryptFileData,path=" + str);
      }
      paramDownloadParams = aqyy.b(str);
      if (paramDownloadParams != null) {
        try
        {
          paramDownloadParams = BitmapFactory.decodeByteArray(paramDownloadParams, 0, paramDownloadParams.length, null);
          if (paramDownloadParams == null)
          {
            QLog.e("VasExtensionDownloader", 2, "decode MARKET File:file error" + str);
            return null;
          }
        }
        catch (OutOfMemoryError paramDownloadParams)
        {
          for (;;)
          {
            QLog.e("emoticon", 1, "decode oom path = " + str);
            paramDownloadParams = null;
          }
        }
      }
      return paramDownloadParams;
    }
    catch (FileNotFoundException paramDownloadParams)
    {
      QLog.e("VasExtensionDownloader", 1, "decode MARKET File", paramDownloadParams);
      return null;
    }
    catch (IOException paramDownloadParams)
    {
      for (;;)
      {
        QLog.e("VasExtensionDownloader", 1, "decode MARKET File", paramDownloadParams);
      }
    }
    catch (Exception paramDownloadParams)
    {
      for (;;)
      {
        QLog.e("VasExtensionDownloader", 1, "decode MARKET File", paramDownloadParams);
      }
    }
  }
  
  /* Error */
  @Nullable
  private Object decodeFileBusinessFavorite(DownloadParams paramDownloadParams, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 260	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   4: instanceof 262
    //   7: ifne +34 -> 41
    //   10: ldc 48
    //   12: iconst_1
    //   13: new 83	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 264
    //   23: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: getfield 215	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   30: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokestatic 71	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   39: aconst_null
    //   40: areturn
    //   41: aload_1
    //   42: getfield 260	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   45: checkcast 262	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   48: astore 8
    //   50: aload 8
    //   52: ifnull +511 -> 563
    //   55: aload 8
    //   57: getfield 270	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   60: astore 6
    //   62: new 73	java/io/File
    //   65: dup
    //   66: aload 6
    //   68: invokespecial 229	java/io/File:<init>	(Ljava/lang/String;)V
    //   71: astore 5
    //   73: aload 5
    //   75: invokestatic 276	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   78: ifeq +86 -> 164
    //   81: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   84: ifeq +29 -> 113
    //   87: ldc 48
    //   89: iconst_2
    //   90: new 83	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   97: ldc 228
    //   99: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload 6
    //   104: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   110: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   113: new 278	com/tencent/mobileqq/transfile/VasExtensionDownloader$ThumbGifImage
    //   116: dup
    //   117: aload_0
    //   118: aload 5
    //   120: iconst_1
    //   121: aload_1
    //   122: getfield 282	com/tencent/image/DownloadParams:mGifRoundCorner	F
    //   125: invokespecial 285	com/tencent/mobileqq/transfile/VasExtensionDownloader$ThumbGifImage:<init>	(Lcom/tencent/mobileqq/transfile/VasExtensionDownloader;Ljava/io/File;ZF)V
    //   128: astore_2
    //   129: aload_2
    //   130: areturn
    //   131: astore_2
    //   132: ldc 48
    //   134: iconst_2
    //   135: new 83	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   142: ldc_w 287
    //   145: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_1
    //   149: getfield 215	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   152: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: aload_2
    //   159: invokestatic 193	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   162: aconst_null
    //   163: areturn
    //   164: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq +30 -> 197
    //   170: ldc 48
    //   172: iconst_2
    //   173: new 83	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   180: ldc_w 289
    //   183: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: aload 6
    //   188: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   197: new 291	android/graphics/BitmapFactory$Options
    //   200: dup
    //   201: invokespecial 292	android/graphics/BitmapFactory$Options:<init>	()V
    //   204: astore 7
    //   206: aload 7
    //   208: iconst_1
    //   209: putfield 296	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   212: aload 8
    //   214: getfield 270	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   217: aload 7
    //   219: invokestatic 300	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   222: pop
    //   223: aload 7
    //   225: aload 7
    //   227: aload 8
    //   229: getfield 304	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   232: aload 8
    //   234: getfield 307	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   237: invokestatic 313	bfvo:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   240: putfield 316	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   243: aload 7
    //   245: iconst_0
    //   246: putfield 296	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   249: new 98	java/io/FileInputStream
    //   252: dup
    //   253: aload 5
    //   255: invokespecial 319	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   258: astore 6
    //   260: aload 6
    //   262: astore 5
    //   264: new 103	java/io/BufferedInputStream
    //   267: dup
    //   268: aload 6
    //   270: invokespecial 106	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   273: aconst_null
    //   274: aload 7
    //   276: invokestatic 322	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   279: astore 7
    //   281: aload 7
    //   283: astore 5
    //   285: aload 6
    //   287: ifnull +12 -> 299
    //   290: aload 6
    //   292: invokevirtual 115	java/io/FileInputStream:close	()V
    //   295: aload 7
    //   297: astore 5
    //   299: aload 5
    //   301: ifnonnull +83 -> 384
    //   304: ldc 48
    //   306: iconst_2
    //   307: new 83	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   314: ldc_w 324
    //   317: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: aload_1
    //   321: getfield 215	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   324: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 71	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: aconst_null
    //   334: areturn
    //   335: astore 7
    //   337: aconst_null
    //   338: astore 6
    //   340: aload 6
    //   342: astore 5
    //   344: ldc 48
    //   346: iconst_2
    //   347: aload 7
    //   349: iconst_0
    //   350: anewarray 326	java/lang/Object
    //   353: invokestatic 329	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   356: aload 6
    //   358: ifnull +248 -> 606
    //   361: aload 6
    //   363: invokevirtual 115	java/io/FileInputStream:close	()V
    //   366: aconst_null
    //   367: astore 5
    //   369: goto -70 -> 299
    //   372: aload 5
    //   374: ifnull +8 -> 382
    //   377: aload 5
    //   379: invokevirtual 115	java/io/FileInputStream:close	()V
    //   382: aload_2
    //   383: athrow
    //   384: ldc 27
    //   386: aload_2
    //   387: invokevirtual 335	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   390: ifeq +20 -> 410
    //   393: aload_0
    //   394: aload 5
    //   396: aload 8
    //   398: getfield 304	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   401: aload 8
    //   403: getfield 307	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   406: invokevirtual 339	com/tencent/mobileqq/transfile/VasExtensionDownloader:zoomBitmap	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   409: areturn
    //   410: aload 5
    //   412: invokevirtual 121	android/graphics/Bitmap:getWidth	()I
    //   415: istore_3
    //   416: aload 5
    //   418: invokevirtual 124	android/graphics/Bitmap:getHeight	()I
    //   421: istore 4
    //   423: new 144	android/graphics/Rect
    //   426: dup
    //   427: invokespecial 340	android/graphics/Rect:<init>	()V
    //   430: astore_2
    //   431: new 149	android/graphics/RectF
    //   434: dup
    //   435: fconst_0
    //   436: fconst_0
    //   437: aload 8
    //   439: getfield 304	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   442: i2f
    //   443: aload 8
    //   445: getfield 304	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   448: i2f
    //   449: invokespecial 343	android/graphics/RectF:<init>	(FFFF)V
    //   452: astore 6
    //   454: iload_3
    //   455: iload 4
    //   457: if_icmple +81 -> 538
    //   460: iload_3
    //   461: iload 4
    //   463: isub
    //   464: iconst_2
    //   465: idiv
    //   466: istore_3
    //   467: aload_2
    //   468: iload_3
    //   469: iconst_0
    //   470: iload_3
    //   471: iload 4
    //   473: iadd
    //   474: iload 4
    //   476: iconst_0
    //   477: iadd
    //   478: invokevirtual 346	android/graphics/Rect:set	(IIII)V
    //   481: aload 8
    //   483: getfield 304	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   486: aload 8
    //   488: getfield 304	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   491: getstatic 130	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   494: invokestatic 134	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   497: astore 7
    //   499: aload 7
    //   501: ifnull +102 -> 603
    //   504: new 136	android/graphics/Canvas
    //   507: dup
    //   508: aload 7
    //   510: invokespecial 139	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   513: aload 5
    //   515: aload_2
    //   516: aload 6
    //   518: new 141	android/graphics/Paint
    //   521: dup
    //   522: bipush 6
    //   524: invokespecial 348	android/graphics/Paint:<init>	(I)V
    //   527: invokevirtual 351	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   530: aload 5
    //   532: invokevirtual 354	android/graphics/Bitmap:recycle	()V
    //   535: aload 7
    //   537: areturn
    //   538: iload 4
    //   540: iload_3
    //   541: isub
    //   542: iconst_2
    //   543: idiv
    //   544: istore 4
    //   546: aload_2
    //   547: iconst_0
    //   548: iload 4
    //   550: iconst_0
    //   551: iload_3
    //   552: iadd
    //   553: iload_3
    //   554: iload 4
    //   556: iadd
    //   557: invokevirtual 346	android/graphics/Rect:set	(IIII)V
    //   560: goto -79 -> 481
    //   563: ldc 48
    //   565: iconst_1
    //   566: new 83	java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   573: ldc_w 356
    //   576: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: aload_1
    //   580: getfield 215	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   583: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   586: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   589: invokestatic 71	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   592: aconst_null
    //   593: areturn
    //   594: astore_2
    //   595: goto -223 -> 372
    //   598: astore 7
    //   600: goto -260 -> 340
    //   603: aload 5
    //   605: areturn
    //   606: aconst_null
    //   607: astore 5
    //   609: goto -310 -> 299
    //   612: astore_2
    //   613: aconst_null
    //   614: astore 5
    //   616: goto -244 -> 372
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	619	0	this	VasExtensionDownloader
    //   0	619	1	paramDownloadParams	DownloadParams
    //   0	619	2	paramString	String
    //   415	142	3	i	int
    //   421	136	4	j	int
    //   71	544	5	localObject1	Object
    //   60	457	6	localObject2	Object
    //   204	92	7	localObject3	Object
    //   335	13	7	localException1	Exception
    //   497	39	7	localBitmap	Bitmap
    //   598	1	7	localException2	Exception
    //   48	439	8	localLocalMediaInfo	com.tencent.mobileqq.activity.photo.LocalMediaInfo
    // Exception table:
    //   from	to	target	type
    //   73	113	131	java/lang/Exception
    //   113	129	131	java/lang/Exception
    //   164	197	131	java/lang/Exception
    //   197	249	131	java/lang/Exception
    //   290	295	131	java/lang/Exception
    //   304	333	131	java/lang/Exception
    //   361	366	131	java/lang/Exception
    //   377	382	131	java/lang/Exception
    //   382	384	131	java/lang/Exception
    //   384	410	131	java/lang/Exception
    //   410	454	131	java/lang/Exception
    //   460	481	131	java/lang/Exception
    //   481	499	131	java/lang/Exception
    //   504	535	131	java/lang/Exception
    //   538	560	131	java/lang/Exception
    //   249	260	335	java/lang/Exception
    //   264	281	594	finally
    //   344	356	594	finally
    //   264	281	598	java/lang/Exception
    //   249	260	612	finally
  }
  
  private Object decodeFileBusinessFontBubble(File paramFile, DownloadParams paramDownloadParams)
  {
    if (GifDrawable.isGifFile(paramFile)) {
      return NativeGifFactory.getNativeGifObject(paramFile, false, false, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, 0.0F);
    }
    paramDownloadParams = new BitmapFactory.Options();
    paramDownloadParams.inTargetDensity = this.application.getResources().getDisplayMetrics().densityDpi;
    paramDownloadParams.inDensity = Math.max(paramDownloadParams.inTargetDensity, 320);
    return bfpx.a(paramFile.getAbsolutePath(), paramDownloadParams);
  }
  
  @Nullable
  private Object decodeFileBusinessRedPacketPic(File paramFile)
  {
    if (paramFile == null)
    {
      QLog.e("VasExtensionDownloader", 1, "decodeFile redpacket send pic f is null");
      return null;
    }
    paramFile = paramFile.getAbsolutePath();
    if (QLog.isColorLevel()) {
      QLog.d("VasExtensionDownloader", 2, "decodeFile redpacket send pic fileName = " + paramFile);
    }
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    try
    {
      paramFile = SafeBitmapFactory.decodeStream(new BufferedInputStream(localFileInputStream));
      try
      {
        localFileInputStream.close();
        return paramFile;
      }
      catch (Exception localException)
      {
        QLog.e("VasExtensionDownloader", 1, "decodeFile redpacket send pic decode io close exception e = " + localException.getMessage());
        return paramFile;
      }
      return null;
    }
    catch (Exception paramFile)
    {
      QLog.e("VasExtensionDownloader", 1, "decodeFile redpacket send pic decode exception e = " + paramFile.getMessage());
    }
  }
  
  @Nullable
  private Object decodeFileBusinessResImg(DownloadParams paramDownloadParams)
  {
    Object localObject = paramDownloadParams.url.getFile();
    paramDownloadParams = (DownloadParams)localObject;
    if (((String)localObject).startsWith("/")) {
      paramDownloadParams = ((String)localObject).substring(1, ((String)localObject).length());
    }
    if (TextUtils.isEmpty(paramDownloadParams))
    {
      QLog.e("VasExtensionDownloader", 1, "decodeFile res is null ");
      return null;
    }
    try
    {
      int i = Integer.valueOf(paramDownloadParams).intValue();
      localObject = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), i);
      return localObject;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.e("VasExtensionDownloader", 1, "decodeFile resid number exception res = " + paramDownloadParams);
      return null;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      QLog.e("VasExtensionDownloader", 1, "decodeFile res not fontexcetpion ;res = " + paramDownloadParams);
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("VasExtensionDownloader", 1, "decodeFile res OutOfMemoryError ;res = " + paramDownloadParams);
    }
    return null;
  }
  
  /* Error */
  @Nullable
  private Object decodeFileSiteImage(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: ifnonnull +14 -> 17
    //   6: ldc 48
    //   8: iconst_1
    //   9: ldc_w 458
    //   12: invokestatic 71	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_3
    //   16: areturn
    //   17: aload_1
    //   18: invokevirtual 77	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   21: astore_1
    //   22: invokestatic 81	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   25: ifeq +29 -> 54
    //   28: ldc 48
    //   30: iconst_2
    //   31: new 83	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 460
    //   41: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_1
    //   45: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: new 98	java/io/FileInputStream
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   62: astore_3
    //   63: new 103	java/io/BufferedInputStream
    //   66: dup
    //   67: aload_3
    //   68: invokespecial 106	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   71: invokestatic 112	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   74: astore_1
    //   75: aload_3
    //   76: invokevirtual 115	java/io/FileInputStream:close	()V
    //   79: ldc 40
    //   81: aload_2
    //   82: invokevirtual 335	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: ifeq +74 -> 159
    //   88: aload_0
    //   89: aload_1
    //   90: invokespecial 464	com/tencent/mobileqq/transfile/VasExtensionDownloader:toRoundBitmap	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   93: areturn
    //   94: astore_1
    //   95: ldc 48
    //   97: iconst_1
    //   98: new 83	java/lang/StringBuilder
    //   101: dup
    //   102: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   105: ldc_w 466
    //   108: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: aload_1
    //   112: invokevirtual 198	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   115: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 71	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: aconst_null
    //   125: areturn
    //   126: astore_3
    //   127: ldc 48
    //   129: iconst_1
    //   130: new 83	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   137: ldc_w 468
    //   140: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: aload_3
    //   144: invokevirtual 198	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   147: invokevirtual 90	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 71	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   156: goto -77 -> 79
    //   159: aload_1
    //   160: astore_3
    //   161: ldc 38
    //   163: aload_2
    //   164: invokevirtual 335	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   167: ifeq -152 -> 15
    //   170: aload_0
    //   171: aload_1
    //   172: iconst_1
    //   173: invokespecial 471	com/tencent/mobileqq/transfile/VasExtensionDownloader:toRoundBitmap	(Landroid/graphics/Bitmap;Z)Landroid/graphics/Bitmap;
    //   176: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	VasExtensionDownloader
    //   0	177	1	paramFile	File
    //   0	177	2	paramString	String
    //   1	75	3	localObject	Object
    //   126	18	3	localException	Exception
    //   160	1	3	localFile	File
    // Exception table:
    //   from	to	target	type
    //   63	75	94	java/lang/Exception
    //   75	79	126	java/lang/Exception
  }
  
  @Nullable
  private File downloadCameraThumb(DownloadParams paramDownloadParams, String paramString1, String paramString2)
  {
    Object localObject1 = null;
    Object localObject2 = getLocalFile(paramString2);
    if (localObject2 != null) {
      return localObject2;
    }
    if ((paramDownloadParams.mExtraInfo instanceof CameraEmoticonInfo))
    {
      String str = ((CameraEmoticonInfo)paramDownloadParams.mExtraInfo).url;
      localObject1 = str;
      localObject2 = paramString2;
      if (QLog.isColorLevel())
      {
        QLog.i("VasExtensionDownloader", 2, String.format("File path %s is not exits, now need download %s", new Object[] { paramString2, str }));
        localObject2 = paramString2;
        localObject1 = str;
      }
    }
    for (;;)
    {
      return realDownloadFile(paramDownloadParams, paramString1, localObject1, (String)localObject2);
      localObject2 = null;
    }
  }
  
  @Nullable
  private File downloadDynamicImage(DownloadParams paramDownloadParams, String paramString1, String paramString2)
  {
    Object localObject = getLocalFile(paramString2);
    if (localObject != null) {
      return localObject;
    }
    String str;
    if ((paramDownloadParams.mExtraInfo instanceof FavoriteEmoticonInfo))
    {
      str = ((FavoriteEmoticonInfo)paramDownloadParams.mExtraInfo).url;
      localObject = str;
      if (QLog.isColorLevel())
      {
        QLog.i("VasExtensionDownloader", 2, String.format("File path %s is not exits, now need download %s", new Object[] { paramString2, str }));
        localObject = str;
      }
    }
    for (;;)
    {
      return realDownloadFile(paramDownloadParams, paramString1, (String)localObject, paramString2);
      if ((paramDownloadParams.mExtraInfo instanceof CameraEmoticonInfo))
      {
        str = ((CameraEmoticonInfo)paramDownloadParams.mExtraInfo).url;
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.i("VasExtensionDownloader", 2, String.format("File path %s is not exits, now need download %s", new Object[] { paramString2, str }));
          localObject = str;
        }
      }
      else
      {
        if (!(paramDownloadParams.mExtraInfo instanceof String)) {
          break;
        }
        str = (String)paramDownloadParams.mExtraInfo;
        localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.i("VasExtensionDownloader", 2, String.format("File path %s is not exits, now need download %s", new Object[] { paramString2, str }));
          localObject = str;
        }
      }
    }
    return null;
  }
  
  @Nullable
  private File downloadFavoriteImage(DownloadParams paramDownloadParams, String paramString1, String paramString2)
  {
    Object localObject1 = null;
    Object localObject2 = getLocalFile(paramString2);
    if (localObject2 != null) {
      return localObject2;
    }
    if ((paramDownloadParams.mExtraInfo instanceof FavoriteEmoticonInfo))
    {
      String str = ((FavoriteEmoticonInfo)paramDownloadParams.mExtraInfo).url;
      localObject1 = str;
      localObject2 = paramString2;
      if (QLog.isColorLevel())
      {
        QLog.i("VasExtensionDownloader", 2, String.format("File path %s is not exits, now need download %s", new Object[] { paramString2, str }));
        localObject2 = paramString2;
        localObject1 = str;
      }
    }
    for (;;)
    {
      return realDownloadFile(paramDownloadParams, paramString1, localObject1, (String)localObject2);
      localObject2 = null;
    }
  }
  
  private File downloadFile(String paramString, DownloadParams paramDownloadParams)
  {
    if ((paramDownloadParams.url != null) && (!TextUtils.isEmpty(paramDownloadParams.url.getFile())))
    {
      String str1 = paramDownloadParams.url.getFile();
      paramDownloadParams = str1;
      if (str1.startsWith("/")) {
        paramDownloadParams = str1.substring(1, str1.length());
      }
      String str2 = MD5.toMD5(paramDownloadParams);
      StringBuilder localStringBuilder = new StringBuilder().append(File.separator);
      if (TextUtils.isEmpty(str2)) {}
      for (str1 = "null";; str1 = str2.substring(0, 2))
      {
        str1 = str1;
        str1 = AppConstants.SDCARD_PATH + paramString + str1 + File.separator + str2;
        if (QLog.isColorLevel()) {
          QLog.d("VasExtensionDownloader", 2, paramString + " save local filePath: " + str1);
        }
        paramString = new File(str1);
        if (!paramString.exists()) {
          break;
        }
        return paramString;
      }
      paramDownloadParams = new bgoe(paramDownloadParams, paramString);
      paramDownloadParams.e = areb.b;
      if (bgog.a(paramDownloadParams, null) == 0) {
        return paramString;
      }
    }
    return null;
  }
  
  @Nullable
  private File downloadFromEmoticonTab(DownloadParams paramDownloadParams, String paramString1, String paramString2)
  {
    if ((paramDownloadParams.mExtraInfo == null) || (paramString2 == null)) {
      return null;
    }
    Object localObject = paramString2;
    if (paramString2.startsWith("/")) {
      localObject = paramString2.substring(1, paramString2.length());
    }
    localObject = ((String)localObject).split("_");
    paramString2 = localObject[0];
    Boolean localBoolean = (Boolean)paramDownloadParams.mExtraInfo;
    boolean bool1 = Boolean.valueOf(localObject[1]).booleanValue();
    if (QLog.isColorLevel()) {
      QLog.d("VasExtensionDownloader", 2, "downloadImage, completed = " + bool1 + ", epId = " + paramString2);
    }
    File localFile;
    if (bool1)
    {
      localObject = aqyy.a(3, paramString2);
      localFile = new File((String)localObject);
    }
    for (;;)
    {
      try
      {
        boolean bool2 = localFile.exists();
        if (bool2)
        {
          return localFile;
          localObject = aqyy.a(4, paramString2);
          break;
        }
        if (!bool1) {
          continue;
        }
        if (localBoolean.booleanValue()) {
          continue;
        }
        paramString2 = aqyy.b(3, paramString2);
      }
      catch (OutOfMemoryError paramString2)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("EmoticonTabAdapter", 2, "getTabDrawable OOM return null");
        paramString2 = null;
        continue;
      }
      return realDownloadFile(paramDownloadParams, paramString1, paramString2, (String)localObject);
      paramString2 = aqyy.b(17, paramString2);
      continue;
      if (!localBoolean.booleanValue()) {
        paramString2 = aqyy.b(4, paramString2);
      } else {
        paramString2 = aqyy.b(18, paramString2);
      }
    }
  }
  
  @Nullable
  private File downloadRedpacketImage()
  {
    Object localObject1 = BaseApplicationImpl.sApplication.getRuntime().getAccount();
    try
    {
      localObject1 = (AppInterface)this.application.getAppRuntime((String)localObject1);
      if ((localObject1 == null) || (!(localObject1 instanceof QQAppInterface)))
      {
        QLog.e("VasExtensionDownloader", 2, "downloadImage redpacket send img app ==null or app not instanceof qqapp");
        return null;
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.d("VasExtensionDownloader", 2, "exception:" + localThrowable.getMessage());
        localObject2 = null;
      }
      Object localObject2 = (amuo)((AppInterface)localObject2).getManager(131);
      if (localObject2 != null)
      {
        localObject2 = ((amuo)localObject2).a();
        if (QLog.isColorLevel()) {
          QLog.d("VasExtensionDownloader", 2, "downloadImage redpacket send img filename = " + (String)localObject2);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          return new File((String)localObject2);
        }
      }
    }
    return null;
  }
  
  @Nullable
  private File downloadSiteImage(DownloadParams paramDownloadParams, String paramString1, String paramString2)
  {
    if ((paramDownloadParams.url != null) && (!TextUtils.isEmpty(paramDownloadParams.url.getFile())))
    {
      paramString2 = paramString2.split("_");
      String str = paramString2[1];
      paramString2 = paramString2[0].substring(1);
      int i;
      if ("COMMERCIAL_DRAINAGE".equals(paramString1))
      {
        i = 22;
        paramDownloadParams = aqyy.a(i, str, MD5.toMD5(paramDownloadParams.url.getFile()));
        if (QLog.isColorLevel()) {
          QLog.d("VasExtensionDownloader", 2, "emotion save local filePath: " + paramDownloadParams);
        }
        paramDownloadParams = new File(paramDownloadParams);
        if (!paramDownloadParams.exists()) {
          break label129;
        }
      }
      label129:
      do
      {
        return paramDownloadParams;
        i = 23;
        break;
        paramString1 = new bgoe(paramString2, paramDownloadParams);
        paramString1.e = areb.b;
      } while (bgog.a(paramString1, null) == 0);
    }
    return null;
  }
  
  private File getLocalFile(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new File(paramString);
      if (paramString.exists()) {
        return paramString;
      }
    }
    return null;
  }
  
  private File realDownloadFile(DownloadParams paramDownloadParams, String paramString1, String paramString2, String paramString3)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString2 != null)
    {
      if ((!"FAVORITE_PANEL_THUMB".equals(paramString1)) && (!"BUSINESS_CAMERA_EMO_PANEL_THUMB".equals(paramString1)) && (!"FAVORITE_PANEL_THUMB_NEW".equals(paramString1))) {
        paramDownloadParams.url = new URL(paramString2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("VasExtensionDownloader", 2, "downloadImage : " + paramString2 + " -> " + paramString3);
      }
      File localFile = new File(paramString3);
      localObject1 = new bgoe(paramString2, localFile);
      ((bgoe)localObject1).e = areb.b;
      int i = bgog.a((bgoe)localObject1, null);
      reportFavoriteDownloadStatus(paramString1, i);
      localObject1 = localObject2;
      if (i == 0)
      {
        if (((paramDownloadParams.mExtraInfo instanceof FavoriteEmoticonInfo)) && (("FAVORITE_PANEL_THUMB".equals(paramString1)) || ("FAVORITE_PANEL_THUMB_NEW".equals(paramString1)))) {
          updateFavEmoticonInDB((FavoriteEmoticonInfo)paramDownloadParams.mExtraInfo);
        }
        if (QLog.isColorLevel()) {
          QLog.i("VasExtensionDownloader", 2, "download sucessful " + paramString2 + " to path " + paramString3);
        }
        localObject1 = localFile;
      }
    }
    return localObject1;
  }
  
  private void reportFavoriteDownloadStatus(String paramString, int paramInt)
  {
    if (("FAVOROTE_PANEL_DYNAMIC".equals(paramString)) || ("FAVORITE_PANEL_THUMB".equals(paramString)) || ("FAVORITE_PANEL_THUMB_NEW".equals(paramString))) {
      avsq.e(String.valueOf(paramInt), 6);
    }
  }
  
  private Bitmap toRoundBitmap(Bitmap paramBitmap)
  {
    return toRoundBitmap(paramBitmap, false);
  }
  
  private Bitmap toRoundBitmap(Bitmap paramBitmap, boolean paramBoolean)
  {
    if ((paramBitmap == null) || (this.application == null)) {
      return null;
    }
    int j = paramBitmap.getWidth();
    int i = paramBitmap.getHeight();
    float f1;
    float f5;
    float f6;
    float f4;
    float f3;
    float f2;
    if (j <= i)
    {
      f1 = j / 2;
      f5 = j;
      f6 = j;
      f4 = j;
      f3 = j;
      i = j;
      f2 = 0.0F;
    }
    for (;;)
    {
      if (paramBoolean) {
        f1 = 5.0F * this.application.getResources().getDisplayMetrics().density + 0.5F;
      }
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect1 = new Rect((int)f2, (int)0.0F, (int)f6, (int)f5);
      Rect localRect2 = new Rect((int)0.0F, (int)0.0F, (int)f4, (int)f3);
      RectF localRectF = new RectF(localRect2);
      localPaint.setAntiAlias(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawRoundRect(localRectF, f1, f1, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      return localBitmap;
      f1 = i / 2;
      f6 = (j - i) / 2;
      float f7 = j;
      f5 = i;
      f4 = i;
      f3 = i;
      f2 = f6;
      f6 = f7 - f6;
      j = i;
    }
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramDownloadParams == null) || (paramDownloadParams.url == null)) {}
    do
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.d("VasExtensionDownloader", 2, "decodeFile, url = " + paramDownloadParams.url);
      }
      paramURLDrawableHandler = paramDownloadParams.url.getHost();
      if ("RESOURCE_IMG".equals(paramURLDrawableHandler)) {
        return decodeFileBusinessResImg(paramDownloadParams);
      }
      if ("EMOTICON_DIY".equals(paramURLDrawableHandler)) {
        return decodeFileBusinessEmoDiy(paramDownloadParams);
      }
      if ("REDPACKET_SEND_PIC".equals(paramURLDrawableHandler)) {
        return decodeFileBusinessRedPacketPic(paramFile);
      }
      if (("FAVORITE_PANEL_THUMB".equals(paramURLDrawableHandler)) || ("BUSINESS_CAMERA_EMO_PANEL_THUMB".equals(paramURLDrawableHandler)) || ("FAVORITE_PANEL_THUMB_NEW".equals(paramURLDrawableHandler))) {
        return decodeFileBusinessFavorite(paramDownloadParams, paramURLDrawableHandler);
      }
      if ("COMMERCIAL_DRAINAGE".equals(paramURLDrawableHandler)) {
        return decodeFileBusinessDrainage(paramFile);
      }
      if (("COMIC_IP_SITE_ROUND_IMAGE".equals(paramURLDrawableHandler)) || ("COMIC_IPSITE_GAME_IMAGE".equals(paramURLDrawableHandler))) {
        return decodeFileSiteImage(paramFile, paramURLDrawableHandler);
      }
    } while (!"FONT_BUBBLE".equals(paramURLDrawableHandler));
    return decodeFileBusinessFontBubble(paramFile, paramDownloadParams);
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if ((paramDownloadParams == null) || (paramDownloadParams.url == null)) {}
    do
    {
      do
      {
        return null;
        paramOutputStream = paramDownloadParams.url.getHost();
        paramURLDrawableHandler = paramDownloadParams.url.getFile();
        if (QLog.isColorLevel()) {
          QLog.d("VasExtensionDownloader", 2, "downloadImage, host = " + paramOutputStream + ", epId = " + paramURLDrawableHandler);
        }
        if ("EMOTICON_TAB".equals(paramOutputStream)) {
          return downloadFromEmoticonTab(paramDownloadParams, paramOutputStream, paramURLDrawableHandler);
        }
        if (("FAVOROTE_PANEL_DYNAMIC".equals(paramOutputStream)) || ("BUSINESS_CAMERA_EMO_PANEL_DYNAMIC".equals(paramOutputStream))) {
          return downloadDynamicImage(paramDownloadParams, paramOutputStream, paramURLDrawableHandler);
        }
        if (("FAVORITE_PANEL_THUMB".equals(paramOutputStream)) || ("FAVORITE_PANEL_THUMB_NEW".equals(paramOutputStream))) {
          return downloadFavoriteImage(paramDownloadParams, paramOutputStream, paramURLDrawableHandler);
        }
        if ("BUSINESS_CAMERA_EMO_PANEL_THUMB".equals(paramOutputStream)) {
          return downloadCameraThumb(paramDownloadParams, paramOutputStream, paramURLDrawableHandler);
        }
      } while ("RESOURCE_IMG".equals(paramOutputStream));
      if ("EMOTICON_DIY".equals(paramOutputStream)) {
        return new File(AppConstants.SDCARD_PATH);
      }
      if ("REDPACKET_SEND_PIC".equals(paramOutputStream)) {
        return downloadRedpacketImage();
      }
      if (("COMMERCIAL_DRAINAGE".equals(paramOutputStream)) || ("IP_SITE_IMAGE".equals(paramOutputStream))) {
        return downloadSiteImage(paramDownloadParams, paramOutputStream, paramURLDrawableHandler);
      }
      if (("COMIC_IP_SITE_ROUND_IMAGE".equals(paramOutputStream)) || ("COMIC_IPSITE_GAME_IMAGE".equals(paramOutputStream))) {
        return downloadFile(".comicIPSite", paramDownloadParams);
      }
    } while (!"FONT_BUBBLE".equals(paramOutputStream));
    return downloadFile(".fontbubble", paramDownloadParams);
  }
  
  public JobQueue getQueue(URL paramURL)
  {
    try
    {
      paramURL = BaseApplicationImpl.sApplication.getRuntime().getAccount();
      paramURL = (areb)((QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramURL)).getManager(43);
      if (paramURL != null) {
        return paramURL.a;
      }
    }
    catch (Throwable paramURL)
    {
      for (;;)
      {
        paramURL = null;
      }
    }
    return null;
  }
  
  public void updateFavEmoticonInDB(FavoriteEmoticonInfo paramFavoriteEmoticonInfo)
  {
    if (paramFavoriteEmoticonInfo == null) {
      return;
    }
    ThreadManager.post(new VasExtensionDownloader.1(this, paramFavoriteEmoticonInfo), 5, null, false);
  }
  
  public boolean useDiskCache()
  {
    return false;
  }
  
  public Bitmap zoomBitmap(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if (i > j) {}
    for (float f = paramInt1 / i;; f = paramInt2 / j)
    {
      Matrix localMatrix = new Matrix();
      localMatrix.postScale(f, f);
      Bitmap.Config localConfig = paramBitmap.getConfig();
      Object localObject = localConfig;
      if (localConfig == null) {
        localObject = Bitmap.Config.ARGB_8888;
      }
      localObject = Bitmap.createBitmap(paramInt1, paramInt2, (Bitmap.Config)localObject);
      new Canvas((Bitmap)localObject).drawBitmap(paramBitmap, localMatrix, null);
      if (!paramBitmap.isRecycled()) {
        paramBitmap.recycle();
      }
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.VasExtensionDownloader
 * JD-Core Version:    0.7.0.1
 */