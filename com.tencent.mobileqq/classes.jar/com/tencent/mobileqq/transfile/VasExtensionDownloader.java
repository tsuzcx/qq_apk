package com.tencent.mobileqq.transfile;

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
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.JobQueue;
import com.tencent.image.NativeGifFactory;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.jetbrains.annotations.Nullable;

public class VasExtensionDownloader
  extends AbsDownloader
{
  public static final String TAG = "VasExtensionDownloader";
  protected MobileQQ application;
  
  public VasExtensionDownloader(MobileQQ paramMobileQQ)
  {
    this.application = paramMobileQQ;
  }
  
  @Nullable
  private Object decodeFileBusinessDrainage(File paramFile)
  {
    if (paramFile == null)
    {
      QLog.e("VasExtensionDownloader", 1, "decodeFile commercial drainage send pic f is null");
      return null;
    }
    paramFile = paramFile.getAbsolutePath();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("decodeFile commercial drainage send pic fileName = ");
      ((StringBuilder)localObject1).append(paramFile);
      QLog.d("VasExtensionDownloader", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new FileInputStream(paramFile);
    try
    {
      paramFile = SafeBitmapFactory.decodeStream(new BufferedInputStream((InputStream)localObject1));
      Object localObject2;
      try
      {
        ((FileInputStream)localObject1).close();
      }
      catch (Exception localException1)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("decodeFile commercial drainage send pic decode io close exception e = ");
        ((StringBuilder)localObject2).append(localException1.getMessage());
        QLog.e("VasExtensionDownloader", 1, ((StringBuilder)localObject2).toString());
      }
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(paramFile.getWidth(), paramFile.getHeight(), Bitmap.Config.ARGB_8888);
        localObject2 = new Canvas(localBitmap);
        Paint localPaint = new Paint();
        Rect localRect = new Rect(0, 0, paramFile.getWidth(), paramFile.getHeight());
        RectF localRectF = new RectF(new Rect(0, 0, paramFile.getWidth(), paramFile.getHeight()));
        localPaint.setAntiAlias(true);
        ((Canvas)localObject2).drawARGB(0, 0, 0, 0);
        localPaint.setColor(-16777216);
        ((Canvas)localObject2).drawRoundRect(localRectF, 4.0F, 4.0F, localPaint);
        localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        ((Canvas)localObject2).drawBitmap(paramFile, new Rect(0, 0, paramFile.getWidth(), paramFile.getHeight()), localRect, localPaint);
        return localBitmap;
      }
      catch (Exception localException2)
      {
        QLog.e("VasExtensionDownloader", 1, "decode BUSINESS_COMMERCIAL_DRAINAGE exception e = ", localException2);
        return paramFile;
      }
      StringBuilder localStringBuilder;
      return null;
    }
    catch (Exception paramFile)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("decodeFile commercial drainage send pic decode exception e = ");
      localStringBuilder.append(paramFile.getMessage());
      QLog.e("VasExtensionDownloader", 1, localStringBuilder.toString());
    }
  }
  
  @Nullable
  private Object decodeFileBusinessEmoDiy(DownloadParams paramDownloadParams)
  {
    try
    {
      str = paramDownloadParams.url.getFile();
      if (EmosmUtils.d(str))
      {
        if (QLog.isColorLevel())
        {
          paramDownloadParams = new StringBuilder();
          paramDownloadParams.append("decodeFile isGifFile,path=");
          paramDownloadParams.append(str);
          QLog.d("VasExtensionDownloader", 2, paramDownloadParams.toString());
        }
        return NativeGifFactory.getNativeGifObject(new File(str), true, true, 0, 0, 0.0F);
      }
      if (QLog.isColorLevel())
      {
        paramDownloadParams = new StringBuilder();
        paramDownloadParams.append("decodeFile getDecryptFileData,path=");
        paramDownloadParams.append(str);
        QLog.d("VasExtensionDownloader", 2, paramDownloadParams.toString());
      }
      paramDownloadParams = EmosmUtils.c(str);
      if (paramDownloadParams == null) {}
    }
    catch (Exception paramDownloadParams)
    {
      String str;
      QLog.e("VasExtensionDownloader", 1, "decode MARKET File", paramDownloadParams);
      return null;
    }
    catch (IOException paramDownloadParams)
    {
      QLog.e("VasExtensionDownloader", 1, "decode MARKET File", paramDownloadParams);
      return null;
    }
    catch (FileNotFoundException paramDownloadParams)
    {
      label127:
      QLog.e("VasExtensionDownloader", 1, "decode MARKET File", paramDownloadParams);
    }
    try
    {
      paramDownloadParams = BitmapFactory.decodeByteArray(paramDownloadParams, 0, paramDownloadParams.length, null);
    }
    catch (OutOfMemoryError paramDownloadParams)
    {
      break label127;
    }
    paramDownloadParams = new StringBuilder();
    paramDownloadParams.append("decode oom path = ");
    paramDownloadParams.append(str);
    QLog.e("emoticon", 1, paramDownloadParams.toString());
    paramDownloadParams = null;
    if (paramDownloadParams == null)
    {
      paramDownloadParams = new StringBuilder();
      paramDownloadParams.append("decode MARKET File:file error");
      paramDownloadParams.append(str);
      QLog.e("VasExtensionDownloader", 2, paramDownloadParams.toString());
      return null;
    }
    return paramDownloadParams;
    return null;
  }
  
  /* Error */
  @Nullable
  private Object decodeFileBusinessFavorite(DownloadParams paramDownloadParams, String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 220	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   4: instanceof 222
    //   7: ifne +39 -> 46
    //   10: new 43	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   17: astore_2
    //   18: aload_2
    //   19: ldc 224
    //   21: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload_2
    //   26: aload_1
    //   27: getfield 175	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   30: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: ldc 8
    //   36: iconst_1
    //   37: aload_2
    //   38: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokestatic 31	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   44: aconst_null
    //   45: areturn
    //   46: aload_1
    //   47: getfield 220	com/tencent/image/DownloadParams:tag	Ljava/lang/Object;
    //   50: checkcast 222	com/tencent/mobileqq/activity/photo/LocalMediaInfo
    //   53: astore 8
    //   55: aload 8
    //   57: ifnull +548 -> 605
    //   60: aload 8
    //   62: getfield 230	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   65: astore 6
    //   67: new 33	java/io/File
    //   70: dup
    //   71: aload 6
    //   73: invokespecial 188	java/io/File:<init>	(Ljava/lang/String;)V
    //   76: astore 5
    //   78: aload 5
    //   80: invokestatic 236	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   83: ifeq +57 -> 140
    //   86: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   89: ifeq +35 -> 124
    //   92: new 43	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   99: astore_2
    //   100: aload_2
    //   101: ldc 187
    //   103: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload_2
    //   108: aload 6
    //   110: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: ldc 8
    //   116: iconst_2
    //   117: aload_2
    //   118: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   121: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   124: new 238	com/tencent/mobileqq/transfile/VasExtensionDownloader$ThumbGifImage
    //   127: dup
    //   128: aload_0
    //   129: aload 5
    //   131: iconst_1
    //   132: aload_1
    //   133: getfield 242	com/tencent/image/DownloadParams:mGifRoundCorner	F
    //   136: invokespecial 245	com/tencent/mobileqq/transfile/VasExtensionDownloader$ThumbGifImage:<init>	(Lcom/tencent/mobileqq/transfile/VasExtensionDownloader;Ljava/io/File;ZF)V
    //   139: areturn
    //   140: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +39 -> 182
    //   146: new 43	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   153: astore 7
    //   155: aload 7
    //   157: ldc 247
    //   159: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload 7
    //   165: aload 6
    //   167: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: ldc 8
    //   173: iconst_2
    //   174: aload 7
    //   176: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 56	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: new 249	android/graphics/BitmapFactory$Options
    //   185: dup
    //   186: invokespecial 250	android/graphics/BitmapFactory$Options:<init>	()V
    //   189: astore 7
    //   191: aload 7
    //   193: iconst_1
    //   194: putfield 254	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   197: aload 8
    //   199: getfield 230	com/tencent/mobileqq/activity/photo/LocalMediaInfo:path	Ljava/lang/String;
    //   202: aload 7
    //   204: invokestatic 258	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   207: pop
    //   208: aload 7
    //   210: aload 7
    //   212: aload 8
    //   214: getfield 262	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   217: aload 8
    //   219: getfield 265	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   222: invokestatic 271	com/tencent/mobileqq/utils/BaseImageUtil:a	(Landroid/graphics/BitmapFactory$Options;II)I
    //   225: putfield 274	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   228: aload 7
    //   230: iconst_0
    //   231: putfield 254	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   234: new 58	java/io/FileInputStream
    //   237: dup
    //   238: aload 5
    //   240: invokespecial 277	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   243: astore 6
    //   245: aload 6
    //   247: astore 5
    //   249: new 63	java/io/BufferedInputStream
    //   252: dup
    //   253: aload 6
    //   255: invokespecial 66	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   258: aconst_null
    //   259: aload 7
    //   261: invokestatic 280	com/tencent/image/SafeBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   264: astore 7
    //   266: aload 6
    //   268: invokevirtual 75	java/io/FileInputStream:close	()V
    //   271: aload 7
    //   273: astore 5
    //   275: goto +53 -> 328
    //   278: astore_2
    //   279: goto +271 -> 550
    //   282: astore 7
    //   284: goto +15 -> 299
    //   287: astore_2
    //   288: aconst_null
    //   289: astore 5
    //   291: goto +259 -> 550
    //   294: astore 7
    //   296: aconst_null
    //   297: astore 6
    //   299: aload 6
    //   301: astore 5
    //   303: ldc 8
    //   305: iconst_2
    //   306: aload 7
    //   308: iconst_0
    //   309: anewarray 282	java/lang/Object
    //   312: invokestatic 285	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   315: aload 6
    //   317: ifnull +325 -> 642
    //   320: aload 6
    //   322: invokevirtual 75	java/io/FileInputStream:close	()V
    //   325: goto +317 -> 642
    //   328: aload 5
    //   330: ifnonnull +40 -> 370
    //   333: new 43	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   340: astore_2
    //   341: aload_2
    //   342: ldc_w 287
    //   345: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload_2
    //   350: aload_1
    //   351: getfield 175	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   354: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: ldc 8
    //   360: iconst_2
    //   361: aload_2
    //   362: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 31	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: aconst_null
    //   369: areturn
    //   370: ldc_w 289
    //   373: aload_2
    //   374: invokevirtual 295	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   377: ifeq +20 -> 397
    //   380: aload_0
    //   381: aload 5
    //   383: aload 8
    //   385: getfield 262	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   388: aload 8
    //   390: getfield 265	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbHeight	I
    //   393: invokevirtual 299	com/tencent/mobileqq/transfile/VasExtensionDownloader:zoomBitmap	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   396: areturn
    //   397: aload 5
    //   399: invokevirtual 86	android/graphics/Bitmap:getWidth	()I
    //   402: istore_3
    //   403: aload 5
    //   405: invokevirtual 89	android/graphics/Bitmap:getHeight	()I
    //   408: istore 4
    //   410: new 109	android/graphics/Rect
    //   413: dup
    //   414: invokespecial 300	android/graphics/Rect:<init>	()V
    //   417: astore_2
    //   418: new 114	android/graphics/RectF
    //   421: dup
    //   422: fconst_0
    //   423: fconst_0
    //   424: aload 8
    //   426: getfield 262	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   429: i2f
    //   430: aload 8
    //   432: getfield 262	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   435: i2f
    //   436: invokespecial 303	android/graphics/RectF:<init>	(FFFF)V
    //   439: astore 6
    //   441: iload_3
    //   442: iload 4
    //   444: if_icmple +27 -> 471
    //   447: iload_3
    //   448: iload 4
    //   450: isub
    //   451: iconst_2
    //   452: idiv
    //   453: istore_3
    //   454: aload_2
    //   455: iload_3
    //   456: iconst_0
    //   457: iload_3
    //   458: iload 4
    //   460: iadd
    //   461: iload 4
    //   463: iconst_0
    //   464: iadd
    //   465: invokevirtual 306	android/graphics/Rect:set	(IIII)V
    //   468: goto +25 -> 493
    //   471: iload 4
    //   473: iload_3
    //   474: isub
    //   475: iconst_2
    //   476: idiv
    //   477: istore 4
    //   479: aload_2
    //   480: iconst_0
    //   481: iload 4
    //   483: iload_3
    //   484: iconst_0
    //   485: iadd
    //   486: iload_3
    //   487: iload 4
    //   489: iadd
    //   490: invokevirtual 306	android/graphics/Rect:set	(IIII)V
    //   493: aload 8
    //   495: getfield 262	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   498: aload 8
    //   500: getfield 262	com/tencent/mobileqq/activity/photo/LocalMediaInfo:thumbWidth	I
    //   503: getstatic 95	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   506: invokestatic 99	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   509: astore 7
    //   511: aload 7
    //   513: ifnull +135 -> 648
    //   516: new 101	android/graphics/Canvas
    //   519: dup
    //   520: aload 7
    //   522: invokespecial 104	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   525: aload 5
    //   527: aload_2
    //   528: aload 6
    //   530: new 106	android/graphics/Paint
    //   533: dup
    //   534: bipush 6
    //   536: invokespecial 308	android/graphics/Paint:<init>	(I)V
    //   539: invokevirtual 311	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/RectF;Landroid/graphics/Paint;)V
    //   542: aload 5
    //   544: invokevirtual 314	android/graphics/Bitmap:recycle	()V
    //   547: aload 7
    //   549: areturn
    //   550: aload 5
    //   552: ifnull +8 -> 560
    //   555: aload 5
    //   557: invokevirtual 75	java/io/FileInputStream:close	()V
    //   560: aload_2
    //   561: athrow
    //   562: astore_2
    //   563: new 43	java/lang/StringBuilder
    //   566: dup
    //   567: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   570: astore 5
    //   572: aload 5
    //   574: ldc_w 316
    //   577: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload 5
    //   583: aload_1
    //   584: getfield 175	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   587: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: ldc 8
    //   593: iconst_2
    //   594: aload 5
    //   596: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   599: aload_2
    //   600: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   603: aconst_null
    //   604: areturn
    //   605: new 43	java/lang/StringBuilder
    //   608: dup
    //   609: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   612: astore_2
    //   613: aload_2
    //   614: ldc_w 318
    //   617: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   620: pop
    //   621: aload_2
    //   622: aload_1
    //   623: getfield 175	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   626: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   629: pop
    //   630: ldc 8
    //   632: iconst_1
    //   633: aload_2
    //   634: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   637: invokestatic 31	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   640: aconst_null
    //   641: areturn
    //   642: aconst_null
    //   643: astore 5
    //   645: goto -317 -> 328
    //   648: aload 5
    //   650: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	651	0	this	VasExtensionDownloader
    //   0	651	1	paramDownloadParams	DownloadParams
    //   0	651	2	paramString	String
    //   402	88	3	i	int
    //   408	82	4	j	int
    //   76	573	5	localObject1	Object
    //   65	464	6	localObject2	Object
    //   153	119	7	localObject3	Object
    //   282	1	7	localException1	Exception
    //   294	13	7	localException2	Exception
    //   509	39	7	localBitmap	Bitmap
    //   53	446	8	localLocalMediaInfo	com.tencent.mobileqq.activity.photo.LocalMediaInfo
    // Exception table:
    //   from	to	target	type
    //   249	266	278	finally
    //   303	315	278	finally
    //   249	266	282	java/lang/Exception
    //   234	245	287	finally
    //   234	245	294	java/lang/Exception
    //   78	124	562	java/lang/Exception
    //   124	140	562	java/lang/Exception
    //   140	182	562	java/lang/Exception
    //   182	234	562	java/lang/Exception
    //   266	271	562	java/lang/Exception
    //   320	325	562	java/lang/Exception
    //   333	368	562	java/lang/Exception
    //   370	397	562	java/lang/Exception
    //   397	441	562	java/lang/Exception
    //   447	468	562	java/lang/Exception
    //   471	493	562	java/lang/Exception
    //   493	511	562	java/lang/Exception
    //   516	547	562	java/lang/Exception
    //   555	560	562	java/lang/Exception
    //   560	562	562	java/lang/Exception
  }
  
  private Object decodeFileBusinessFontBubble(File paramFile, DownloadParams paramDownloadParams)
  {
    if (GifDrawable.isGifFile(paramFile)) {
      return NativeGifFactory.getNativeGifObject(paramFile, false, false, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, 0.0F);
    }
    paramDownloadParams = new BitmapFactory.Options();
    paramDownloadParams.inTargetDensity = this.application.getResources().getDisplayMetrics().densityDpi;
    paramDownloadParams.inDensity = Math.max(paramDownloadParams.inTargetDensity, 320);
    return BitmapManager.a(paramFile.getAbsolutePath(), paramDownloadParams);
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decodeFile redpacket send pic fileName = ");
      ((StringBuilder)localObject).append(paramFile);
      QLog.d("VasExtensionDownloader", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new FileInputStream(paramFile);
    try
    {
      paramFile = SafeBitmapFactory.decodeStream(new BufferedInputStream((InputStream)localObject));
      try
      {
        ((FileInputStream)localObject).close();
        return paramFile;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("decodeFile redpacket send pic decode io close exception e = ");
        localStringBuilder2.append(localException.getMessage());
        QLog.e("VasExtensionDownloader", 1, localStringBuilder2.toString());
        return paramFile;
      }
      StringBuilder localStringBuilder1;
      return null;
    }
    catch (Exception paramFile)
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("decodeFile redpacket send pic decode exception e = ");
      localStringBuilder1.append(paramFile.getMessage());
      QLog.e("VasExtensionDownloader", 1, localStringBuilder1.toString());
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
      localObject = BitmapFactory.decodeResource(MobileQQ.getContext().getResources(), i);
      return localObject;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      break label137;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      break label103;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label69:
      break label69;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("decodeFile res OutOfMemoryError ;res = ");
    ((StringBuilder)localObject).append(paramDownloadParams);
    QLog.e("VasExtensionDownloader", 1, ((StringBuilder)localObject).toString());
    return null;
    label103:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("decodeFile res not fontexcetpion ;res = ");
    ((StringBuilder)localObject).append(paramDownloadParams);
    QLog.e("VasExtensionDownloader", 1, ((StringBuilder)localObject).toString());
    return null;
    label137:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("decodeFile resid number exception res = ");
    ((StringBuilder)localObject).append(paramDownloadParams);
    QLog.e("VasExtensionDownloader", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  @Nullable
  private Object decodeFileSiteImage(File paramFile, String paramString)
  {
    if (paramFile == null)
    {
      QLog.e("VasExtensionDownloader", 1, "decodeFile comic_ip_site send pic f is null");
      return null;
    }
    paramFile = paramFile.getAbsolutePath();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decodeFile comic_ip_site send pic fileName = ");
      ((StringBuilder)localObject).append(paramFile);
      QLog.d("VasExtensionDownloader", 2, ((StringBuilder)localObject).toString());
    }
    paramFile = new FileInputStream(paramFile);
    try
    {
      localObject = SafeBitmapFactory.decodeStream(new BufferedInputStream(paramFile));
      try
      {
        paramFile.close();
      }
      catch (Exception paramFile)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("decodeFile comic_ip_site send pic decode io close exception e = ");
        localStringBuilder.append(paramFile.getMessage());
        QLog.e("VasExtensionDownloader", 1, localStringBuilder.toString());
      }
      if ("COMIC_IP_SITE_ROUND_IMAGE".equals(paramString)) {
        return toRoundBitmap((Bitmap)localObject);
      }
      paramFile = (File)localObject;
      if ("COMIC_IPSITE_GAME_IMAGE".equals(paramString)) {
        paramFile = toRoundBitmap((Bitmap)localObject, true);
      }
      return paramFile;
    }
    catch (Exception paramFile)
    {
      paramString = new StringBuilder();
      paramString.append("decodeFile ccomic_ip_site send pic decode exception e = ");
      paramString.append(paramFile.getMessage());
      QLog.e("VasExtensionDownloader", 1, paramString.toString());
    }
    return null;
  }
  
  @Nullable
  private File downloadCameraThumb(DownloadParams paramDownloadParams, String paramString1, String paramString2)
  {
    Object localObject1 = getLocalFile(paramString2);
    if (localObject1 != null) {
      return localObject1;
    }
    boolean bool = paramDownloadParams.mExtraInfo instanceof CameraEmoticonInfo;
    Object localObject2 = null;
    if (bool)
    {
      String str = ((CameraEmoticonInfo)paramDownloadParams.mExtraInfo).url;
      localObject2 = str;
      localObject1 = paramString2;
      if (QLog.isColorLevel())
      {
        QLog.i("VasExtensionDownloader", 2, String.format("File path %s is not exits, now need download %s", new Object[] { paramString2, str }));
        localObject2 = str;
        localObject1 = paramString2;
      }
    }
    else
    {
      localObject1 = null;
    }
    return realDownloadFile(paramDownloadParams, paramString1, localObject2, (String)localObject1);
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
    else if ((paramDownloadParams.mExtraInfo instanceof CameraEmoticonInfo))
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
        break label211;
      }
      str = (String)paramDownloadParams.mExtraInfo;
      localObject = str;
      if (QLog.isColorLevel())
      {
        QLog.i("VasExtensionDownloader", 2, String.format("File path %s is not exits, now need download %s", new Object[] { paramString2, str }));
        localObject = str;
      }
    }
    return realDownloadFile(paramDownloadParams, paramString1, (String)localObject, paramString2);
    label211:
    return null;
  }
  
  @Nullable
  private File downloadFavoriteImage(DownloadParams paramDownloadParams, String paramString1, String paramString2)
  {
    Object localObject1 = getLocalFile(paramString2);
    if (localObject1 != null) {
      return localObject1;
    }
    boolean bool = paramDownloadParams.mExtraInfo instanceof FavoriteEmoticonInfo;
    Object localObject2 = null;
    if (bool)
    {
      String str = ((FavoriteEmoticonInfo)paramDownloadParams.mExtraInfo).url;
      localObject2 = str;
      localObject1 = paramString2;
      if (QLog.isColorLevel())
      {
        QLog.i("VasExtensionDownloader", 2, String.format("File path %s is not exits, now need download %s", new Object[] { paramString2, str }));
        localObject2 = str;
        localObject1 = paramString2;
      }
    }
    else
    {
      localObject1 = null;
    }
    return realDownloadFile(paramDownloadParams, paramString1, localObject2, (String)localObject1);
  }
  
  private File downloadFile(String paramString, DownloadParams paramDownloadParams)
  {
    if ((paramDownloadParams.url != null) && (!TextUtils.isEmpty(paramDownloadParams.url.getFile())))
    {
      String str = paramDownloadParams.url.getFile();
      paramDownloadParams = str;
      if (str.startsWith("/")) {
        paramDownloadParams = str.substring(1, str.length());
      }
      Object localObject = MD5.toMD5(paramDownloadParams);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(File.separator);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        str = "null";
      } else {
        str = ((String)localObject).substring(0, 2);
      }
      localStringBuilder.append(str);
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.SDCARD_PATH);
      localStringBuilder.append(paramString);
      localStringBuilder.append(str);
      localStringBuilder.append(File.separator);
      localStringBuilder.append((String)localObject);
      str = localStringBuilder.toString();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" save local filePath: ");
        ((StringBuilder)localObject).append(str);
        QLog.d("VasExtensionDownloader", 2, ((StringBuilder)localObject).toString());
      }
      paramString = new File(str);
      if (paramString.exists()) {
        return paramString;
      }
      paramDownloadParams = new DownloadTask(paramDownloadParams, paramString);
      paramDownloadParams.v = EmojiManagerServiceConstant.EMOTION_DOWNLOAD_TIMEOUT;
      if (((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).download(paramDownloadParams, MobileQQ.sMobileQQ.waitAppRuntime(null)) == 0) {
        return paramString;
      }
    }
    return null;
  }
  
  @Nullable
  private File downloadFromEmoticonTab(DownloadParams paramDownloadParams, String paramString1, String paramString2)
  {
    Object localObject1 = paramDownloadParams.mExtraInfo;
    Object localObject2 = null;
    Boolean localBoolean;
    boolean bool;
    File localFile;
    if (localObject1 != null)
    {
      if (paramString2 == null) {
        return null;
      }
      localObject1 = paramString2;
      if (paramString2.startsWith("/")) {
        localObject1 = paramString2.substring(1, paramString2.length());
      }
      localObject1 = ((String)localObject1).split("_");
      paramString2 = localObject1[0];
      localBoolean = (Boolean)paramDownloadParams.mExtraInfo;
      bool = Boolean.valueOf(localObject1[1]).booleanValue();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("downloadImage, completed = ");
        ((StringBuilder)localObject1).append(bool);
        ((StringBuilder)localObject1).append(", epId = ");
        ((StringBuilder)localObject1).append(paramString2);
        QLog.d("VasExtensionDownloader", 2, ((StringBuilder)localObject1).toString());
      }
      if (bool) {
        localObject1 = EmosmUtils.b(3, paramString2);
      } else {
        localObject1 = EmosmUtils.b(4, paramString2);
      }
      localFile = new File((String)localObject1);
    }
    try
    {
      if (localFile.exists()) {
        return localFile;
      }
      if (bool)
      {
        if (!localBoolean.booleanValue()) {
          paramString2 = EmosmUtils.c(3, paramString2);
        } else {
          paramString2 = EmosmUtils.c(17, paramString2);
        }
      }
      else if (!localBoolean.booleanValue()) {
        paramString2 = EmosmUtils.c(4, paramString2);
      } else {
        paramString2 = EmosmUtils.c(18, paramString2);
      }
    }
    catch (OutOfMemoryError paramString2)
    {
      label242:
      break label242;
    }
    paramString2 = localObject2;
    if (QLog.isColorLevel())
    {
      QLog.w("EmoticonTabAdapter", 2, "getTabDrawable OOM return null");
      paramString2 = localObject2;
    }
    return realDownloadFile(paramDownloadParams, paramString1, paramString2, (String)localObject1);
    return null;
  }
  
  @Nullable
  private File downloadRedpacketImage()
  {
    Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
    StringBuilder localStringBuilder;
    Object localObject2;
    try
    {
      localObject1 = (AppInterface)this.application.getAppRuntime((String)localObject1);
    }
    catch (Throwable localThrowable)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("exception:");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.d("VasExtensionDownloader", 2, localStringBuilder.toString());
      localObject2 = null;
    }
    if ((localObject2 != null) && ((localObject2 instanceof BaseQQAppInterface)))
    {
      localObject2 = ((IEmosmService)QRoute.api(IEmosmService.class)).getIndividualRedPacketManager((AppInterface)localObject2);
      if (localObject2 != null)
      {
        localObject2 = ((IEmosmService)QRoute.api(IEmosmService.class)).getSendCombineImg((Manager)localObject2);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("downloadImage redpacket send img filename = ");
          localStringBuilder.append((String)localObject2);
          QLog.d("VasExtensionDownloader", 2, localStringBuilder.toString());
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          return new File((String)localObject2);
        }
      }
      return null;
    }
    QLog.e("VasExtensionDownloader", 2, "downloadImage redpacket send img app ==null or app not instanceof qqapp");
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
      if ("COMMERCIAL_DRAINAGE".equals(paramString1)) {
        i = 22;
      } else {
        i = 23;
      }
      paramDownloadParams = EmosmUtils.a(i, str, MD5.toMD5(paramDownloadParams.url.getFile()));
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("emotion save local filePath: ");
        paramString1.append(paramDownloadParams);
        QLog.d("VasExtensionDownloader", 2, paramString1.toString());
      }
      paramDownloadParams = new File(paramDownloadParams);
      if (paramDownloadParams.exists()) {
        return paramDownloadParams;
      }
      paramString1 = new DownloadTask(paramString2, paramDownloadParams);
      paramString1.v = EmojiManagerServiceConstant.EMOTION_DOWNLOAD_TIMEOUT;
      if (((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).download(paramString1, MobileQQ.sMobileQQ.waitAppRuntime(null)) == 0) {
        return paramDownloadParams;
      }
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
    if (paramString2 != null)
    {
      if ((!"FAVORITE_PANEL_THUMB".equals(paramString1)) && (!"BUSINESS_CAMERA_EMO_PANEL_THUMB".equals(paramString1)) && (!"FAVORITE_PANEL_THUMB_NEW".equals(paramString1))) {
        paramDownloadParams.url = new URL(paramString2);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("downloadImage : ");
        ((StringBuilder)localObject).append(paramString2);
        ((StringBuilder)localObject).append(" -> ");
        ((StringBuilder)localObject).append(paramString3);
        QLog.d("VasExtensionDownloader", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new File(paramString3);
      DownloadTask localDownloadTask = new DownloadTask(paramString2, (File)localObject);
      localDownloadTask.v = EmojiManagerServiceConstant.EMOTION_DOWNLOAD_TIMEOUT;
      int i = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).download(localDownloadTask, MobileQQ.sMobileQQ.waitAppRuntime(null));
      reportFavoriteDownloadStatus(paramString1, i);
      if (i == 0)
      {
        if (((paramDownloadParams.mExtraInfo instanceof FavoriteEmoticonInfo)) && (("FAVORITE_PANEL_THUMB".equals(paramString1)) || ("FAVORITE_PANEL_THUMB_NEW".equals(paramString1)))) {
          updateFavEmoticonInDB((FavoriteEmoticonInfo)paramDownloadParams.mExtraInfo);
        }
        if (QLog.isColorLevel())
        {
          paramDownloadParams = new StringBuilder();
          paramDownloadParams.append("download sucessful ");
          paramDownloadParams.append(paramString2);
          paramDownloadParams.append(" to path ");
          paramDownloadParams.append(paramString3);
          QLog.i("VasExtensionDownloader", 2, paramDownloadParams.toString());
        }
        return localObject;
      }
    }
    return null;
  }
  
  private void reportFavoriteDownloadStatus(String paramString, int paramInt)
  {
    if (("FAVOROTE_PANEL_DYNAMIC".equals(paramString)) || ("FAVORITE_PANEL_THUMB".equals(paramString)) || ("FAVORITE_PANEL_THUMB_NEW".equals(paramString))) {
      EmoticonOperateReport.reportEmoticonOperateMonitorGetStatus(String.valueOf(paramInt), 6);
    }
  }
  
  private Bitmap toRoundBitmap(Bitmap paramBitmap)
  {
    return toRoundBitmap(paramBitmap, false);
  }
  
  private Bitmap toRoundBitmap(Bitmap paramBitmap, boolean paramBoolean)
  {
    if ((paramBitmap != null) && (this.application != null))
    {
      int i = paramBitmap.getWidth();
      int j = paramBitmap.getHeight();
      float f1;
      float f2;
      float f4;
      float f3;
      if (i <= j)
      {
        f1 = i / 2;
        f2 = i;
        f4 = f2;
        f3 = 0.0F;
      }
      else
      {
        f1 = j / 2;
        f3 = (i - j) / 2;
        f4 = i;
        f2 = j;
        f4 -= f3;
        i = j;
      }
      if (paramBoolean) {
        f1 = this.application.getResources().getDisplayMetrics().density * 5.0F + 0.5F;
      }
      Bitmap localBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      Paint localPaint = new Paint();
      Rect localRect1 = new Rect((int)f3, (int)0.0F, (int)f4, (int)f2);
      Rect localRect2 = new Rect((int)0.0F, (int)0.0F, (int)f2, (int)f2);
      RectF localRectF = new RectF(localRect2);
      localPaint.setAntiAlias(true);
      localCanvas.drawARGB(0, 0, 0, 0);
      localPaint.setColor(-12434878);
      localCanvas.drawRoundRect(localRectF, f1, f1, localPaint);
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
      localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
      return localBitmap;
    }
    return null;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    if (paramDownloadParams != null)
    {
      if (paramDownloadParams.url == null) {
        return null;
      }
      if (QLog.isColorLevel())
      {
        paramURLDrawableHandler = new StringBuilder();
        paramURLDrawableHandler.append("decodeFile, url = ");
        paramURLDrawableHandler.append(paramDownloadParams.url);
        QLog.d("VasExtensionDownloader", 2, paramURLDrawableHandler.toString());
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
      if ((!"FAVORITE_PANEL_THUMB".equals(paramURLDrawableHandler)) && (!"BUSINESS_CAMERA_EMO_PANEL_THUMB".equals(paramURLDrawableHandler)) && (!"FAVORITE_PANEL_THUMB_NEW".equals(paramURLDrawableHandler)))
      {
        if ("COMMERCIAL_DRAINAGE".equals(paramURLDrawableHandler)) {
          return decodeFileBusinessDrainage(paramFile);
        }
        if ((!"COMIC_IP_SITE_ROUND_IMAGE".equals(paramURLDrawableHandler)) && (!"COMIC_IPSITE_GAME_IMAGE".equals(paramURLDrawableHandler)))
        {
          if ("FONT_BUBBLE".equals(paramURLDrawableHandler)) {
            return decodeFileBusinessFontBubble(paramFile, paramDownloadParams);
          }
          return null;
        }
        return decodeFileSiteImage(paramFile, paramURLDrawableHandler);
      }
      return decodeFileBusinessFavorite(paramDownloadParams, paramURLDrawableHandler);
    }
    return null;
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = null;
    paramURLDrawableHandler = null;
    if (paramDownloadParams != null)
    {
      if (paramDownloadParams.url == null) {
        return null;
      }
      String str = paramDownloadParams.url.getHost();
      paramOutputStream = paramDownloadParams.url.getFile();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("downloadImage, host = ");
        localStringBuilder.append(str);
        localStringBuilder.append(", epId = ");
        localStringBuilder.append(paramOutputStream);
        QLog.d("VasExtensionDownloader", 2, localStringBuilder.toString());
      }
      if ("EMOTICON_TAB".equals(str)) {
        return downloadFromEmoticonTab(paramDownloadParams, str, paramOutputStream);
      }
      if ((!"FAVOROTE_PANEL_DYNAMIC".equals(str)) && (!"BUSINESS_CAMERA_EMO_PANEL_DYNAMIC".equals(str)))
      {
        if ((!"FAVORITE_PANEL_THUMB".equals(str)) && (!"FAVORITE_PANEL_THUMB_NEW".equals(str)))
        {
          if ("BUSINESS_CAMERA_EMO_PANEL_THUMB".equals(str)) {
            return downloadCameraThumb(paramDownloadParams, str, paramOutputStream);
          }
          if ("RESOURCE_IMG".equals(str)) {
            return null;
          }
          if ("EMOTICON_DIY".equals(str)) {
            return new File(AppConstants.SDCARD_PATH);
          }
          if ("REDPACKET_SEND_PIC".equals(str)) {
            return downloadRedpacketImage();
          }
          if ((!"COMMERCIAL_DRAINAGE".equals(str)) && (!"IP_SITE_IMAGE".equals(str)))
          {
            if ((!"COMIC_IP_SITE_ROUND_IMAGE".equals(str)) && (!"COMIC_IPSITE_GAME_IMAGE".equals(str)))
            {
              paramOutputStream = paramURLDrawableHandler;
              if ("FONT_BUBBLE".equals(str)) {
                paramOutputStream = downloadFile(".fontbubble", paramDownloadParams);
              }
              return paramOutputStream;
            }
            return downloadFile(".comicIPSite", paramDownloadParams);
          }
          return downloadSiteImage(paramDownloadParams, str, paramOutputStream);
        }
        return downloadFavoriteImage(paramDownloadParams, str, paramOutputStream);
      }
      paramOutputStream = downloadDynamicImage(paramDownloadParams, str, paramOutputStream);
    }
    return paramOutputStream;
  }
  
  public JobQueue getQueue(URL paramURL)
  {
    JobQueue localJobQueue = null;
    try
    {
      paramURL = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
      paramURL = (IEmojiManagerService)((BaseQQAppInterface)MobileQQ.sMobileQQ.getAppRuntime(paramURL)).getRuntimeService(IEmojiManagerService.class);
    }
    catch (Throwable paramURL)
    {
      label36:
      break label36;
    }
    paramURL = null;
    if (paramURL != null) {
      localJobQueue = paramURL.getEmoQueue();
    }
    return localJobQueue;
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
    float f;
    if (i > j) {
      f = paramInt1 / i;
    } else {
      f = paramInt2 / j;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.VasExtensionDownloader
 * JD-Core Version:    0.7.0.1
 */