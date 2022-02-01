package com.tencent.mobileqq.transfile;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.SliceBitmap;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.FilePicConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import org.jetbrains.annotations.Nullable;

public class FileAssistantDownloader
  extends AbsDownloader
  implements ProtocolDownloaderConstants
{
  public static final int RADIUS = 16;
  private static final String TAG = "FileAssistantDownloader";
  protected BaseApplicationImpl application;
  
  public FileAssistantDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.application = paramBaseApplicationImpl;
  }
  
  public static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_4444);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  /* Error */
  private Object internalDecodeFile(DownloadParams paramDownloadParams, FileAssistantDownloader.PhotoInfo paramPhotoInfo)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 80	com/tencent/mobileqq/transfile/FileAssistantDownloader$PhotoInfo:path	Ljava/lang/String;
    //   4: astore 7
    //   6: aload 7
    //   8: ifnonnull +5 -> 13
    //   11: aconst_null
    //   12: areturn
    //   13: new 82	java/io/File
    //   16: dup
    //   17: aload 7
    //   19: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore 8
    //   24: aload 8
    //   26: invokestatic 91	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   29: istore 5
    //   31: iload 5
    //   33: ifeq +67 -> 100
    //   36: aload_2
    //   37: getfield 95	com/tencent/mobileqq/transfile/FileAssistantDownloader$PhotoInfo:isRaw	Z
    //   40: ifeq +60 -> 100
    //   43: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   46: ifeq +526 -> 572
    //   49: new 103	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   56: astore_1
    //   57: aload_1
    //   58: ldc 106
    //   60: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_1
    //   65: aload 8
    //   67: invokevirtual 114	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   70: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_1
    //   75: ldc 116
    //   77: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_1
    //   82: aload 7
    //   84: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: ldc 13
    //   90: iconst_2
    //   91: aload_1
    //   92: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 123	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aconst_null
    //   99: areturn
    //   100: new 125	android/graphics/BitmapFactory$Options
    //   103: dup
    //   104: invokespecial 126	android/graphics/BitmapFactory$Options:<init>	()V
    //   107: astore 9
    //   109: aload 9
    //   111: getstatic 131	com/tencent/mobileqq/transfile/URLDrawableHelper:mConfig	Landroid/graphics/Bitmap$Config;
    //   114: putfield 134	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   117: aload 9
    //   119: sipush 160
    //   122: putfield 137	android/graphics/BitmapFactory$Options:inDensity	I
    //   125: aload 9
    //   127: sipush 160
    //   130: putfield 140	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   133: aload 9
    //   135: sipush 160
    //   138: putfield 143	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   141: aload_1
    //   142: aload 7
    //   144: invokestatic 149	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   147: putfield 154	com/tencent/image/DownloadParams:outOrientation	I
    //   150: aload 9
    //   152: iconst_1
    //   153: putfield 157	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   156: new 159	java/io/FileInputStream
    //   159: dup
    //   160: aload 8
    //   162: invokevirtual 114	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   165: invokespecial 160	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   168: astore_2
    //   169: new 162	java/io/BufferedInputStream
    //   172: dup
    //   173: aload_2
    //   174: invokespecial 165	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   177: astore 6
    //   179: iconst_2
    //   180: newarray byte
    //   182: astore 10
    //   184: aload 6
    //   186: aload 10
    //   188: invokevirtual 169	java/io/BufferedInputStream:read	([B)I
    //   191: pop
    //   192: aload 10
    //   194: iconst_0
    //   195: baload
    //   196: bipush 66
    //   198: if_icmpeq +15 -> 213
    //   201: aload 10
    //   203: iconst_1
    //   204: baload
    //   205: bipush 77
    //   207: if_icmpeq +6 -> 213
    //   210: goto +81 -> 291
    //   213: aload 6
    //   215: iconst_4
    //   216: newarray byte
    //   218: invokevirtual 169	java/io/BufferedInputStream:read	([B)I
    //   221: pop
    //   222: aload 6
    //   224: ldc2_w 170
    //   227: invokevirtual 175	java/io/BufferedInputStream:skip	(J)J
    //   230: pop2
    //   231: iconst_4
    //   232: newarray byte
    //   234: astore 10
    //   236: aload 6
    //   238: aload 10
    //   240: invokevirtual 169	java/io/BufferedInputStream:read	([B)I
    //   243: pop
    //   244: aload_0
    //   245: aload 10
    //   247: invokevirtual 178	com/tencent/mobileqq/transfile/FileAssistantDownloader:byte2Int	([B)I
    //   250: istore_3
    //   251: iconst_4
    //   252: newarray byte
    //   254: astore 10
    //   256: aload 6
    //   258: aload 10
    //   260: invokevirtual 169	java/io/BufferedInputStream:read	([B)I
    //   263: pop
    //   264: aload_0
    //   265: aload 10
    //   267: invokevirtual 178	com/tencent/mobileqq/transfile/FileAssistantDownloader:byte2Int	([B)I
    //   270: invokestatic 184	java/lang/Math:abs	(I)I
    //   273: istore 4
    //   275: iload_3
    //   276: iflt +27 -> 303
    //   279: iload_3
    //   280: iload 4
    //   282: imul
    //   283: ldc 185
    //   285: if_icmple +6 -> 291
    //   288: goto +15 -> 303
    //   291: aload 6
    //   293: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   296: aload_2
    //   297: invokevirtual 189	java/io/FileInputStream:close	()V
    //   300: goto +64 -> 364
    //   303: invokestatic 195	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   306: invokevirtual 201	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   309: ldc 202
    //   311: invokevirtual 208	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   314: invokestatic 210	com/tencent/mobileqq/transfile/FileAssistantDownloader:drawableToBitmap	(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    //   317: astore 10
    //   319: aload 6
    //   321: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   324: aload_2
    //   325: invokevirtual 189	java/io/FileInputStream:close	()V
    //   328: aload 10
    //   330: areturn
    //   331: aload_1
    //   332: ifnull +7 -> 339
    //   335: aload_1
    //   336: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   339: aload 6
    //   341: ifnull +8 -> 349
    //   344: aload 6
    //   346: invokevirtual 189	java/io/FileInputStream:close	()V
    //   349: aload_2
    //   350: athrow
    //   351: aload 6
    //   353: ifnull +275 -> 628
    //   356: aload 6
    //   358: invokevirtual 188	java/io/BufferedInputStream:close	()V
    //   361: goto +267 -> 628
    //   364: aload 9
    //   366: iconst_1
    //   367: putfield 157	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   370: aload 8
    //   372: invokevirtual 114	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   375: aload 9
    //   377: invokestatic 216	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   380: pop
    //   381: aload 9
    //   383: getfield 219	android/graphics/BitmapFactory$Options:outHeight	I
    //   386: ifeq +152 -> 538
    //   389: aload 9
    //   391: getfield 222	android/graphics/BitmapFactory$Options:outWidth	I
    //   394: ifeq +144 -> 538
    //   397: aload 9
    //   399: aload 9
    //   401: aload_1
    //   402: getfield 225	com/tencent/image/DownloadParams:reqWidth	I
    //   405: aload_1
    //   406: getfield 228	com/tencent/image/DownloadParams:reqHeight	I
    //   409: invokestatic 234	com/tencent/mobileqq/transfile/AbstractImageDownloader:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   412: putfield 237	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   415: aload 9
    //   417: getfield 219	android/graphics/BitmapFactory$Options:outHeight	I
    //   420: aload 9
    //   422: getfield 222	android/graphics/BitmapFactory$Options:outWidth	I
    //   425: imul
    //   426: ldc 238
    //   428: if_icmple +64 -> 492
    //   431: new 103	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   438: astore_1
    //   439: aload_1
    //   440: ldc 240
    //   442: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: pop
    //   446: aload_1
    //   447: aload 9
    //   449: getfield 219	android/graphics/BitmapFactory$Options:outHeight	I
    //   452: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: aload_1
    //   457: ldc 245
    //   459: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: aload_1
    //   464: aload 9
    //   466: getfield 222	android/graphics/BitmapFactory$Options:outWidth	I
    //   469: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   472: pop
    //   473: aload_1
    //   474: ldc 247
    //   476: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: ldc 13
    //   482: iconst_1
    //   483: aload_1
    //   484: invokevirtual 119	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: invokestatic 250	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   490: aconst_null
    //   491: areturn
    //   492: aload 9
    //   494: getfield 222	android/graphics/BitmapFactory$Options:outWidth	I
    //   497: istore_3
    //   498: aload 9
    //   500: getfield 219	android/graphics/BitmapFactory$Options:outHeight	I
    //   503: istore_3
    //   504: aload 9
    //   506: iconst_0
    //   507: putfield 157	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   510: aload_0
    //   511: aload 7
    //   513: aload 8
    //   515: aload 9
    //   517: invokespecial 254	com/tencent/mobileqq/transfile/FileAssistantDownloader:internalDecodeFile_decodeImage	(Ljava/lang/String;Ljava/io/File;Landroid/graphics/BitmapFactory$Options;)Ljava/lang/Object;
    //   520: astore_1
    //   521: aload_1
    //   522: ifnull +5 -> 527
    //   525: aload_1
    //   526: areturn
    //   527: new 256	java/io/IOException
    //   530: dup
    //   531: ldc_w 258
    //   534: invokespecial 259	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   537: athrow
    //   538: new 256	java/io/IOException
    //   541: dup
    //   542: ldc_w 261
    //   545: invokespecial 259	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   548: athrow
    //   549: astore_1
    //   550: goto +5 -> 555
    //   553: aload_1
    //   554: athrow
    //   555: goto -2 -> 553
    //   558: astore_2
    //   559: goto +60 -> 619
    //   562: astore 6
    //   564: goto +40 -> 604
    //   567: astore 10
    //   569: goto +19 -> 588
    //   572: aconst_null
    //   573: areturn
    //   574: astore 7
    //   576: aload 6
    //   578: astore_1
    //   579: aload_2
    //   580: astore 6
    //   582: aload 7
    //   584: astore_2
    //   585: goto -254 -> 331
    //   588: goto -237 -> 351
    //   591: astore 7
    //   593: aconst_null
    //   594: astore_1
    //   595: aload_2
    //   596: astore 6
    //   598: aload 7
    //   600: astore_2
    //   601: goto -270 -> 331
    //   604: aconst_null
    //   605: astore 6
    //   607: goto -256 -> 351
    //   610: astore_2
    //   611: aconst_null
    //   612: astore_1
    //   613: aload_1
    //   614: astore 6
    //   616: goto -285 -> 331
    //   619: aconst_null
    //   620: astore 6
    //   622: aload 6
    //   624: astore_2
    //   625: goto -274 -> 351
    //   628: aload_2
    //   629: ifnull -265 -> 364
    //   632: goto -336 -> 296
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	635	0	this	FileAssistantDownloader
    //   0	635	1	paramDownloadParams	DownloadParams
    //   0	635	2	paramPhotoInfo	FileAssistantDownloader.PhotoInfo
    //   250	254	3	i	int
    //   273	10	4	j	int
    //   29	3	5	bool	boolean
    //   177	180	6	localBufferedInputStream	java.io.BufferedInputStream
    //   562	15	6	localException1	Exception
    //   580	43	6	localObject1	Object
    //   4	508	7	str	String
    //   574	9	7	localObject2	Object
    //   591	8	7	localObject3	Object
    //   22	492	8	localFile	File
    //   107	409	9	localOptions	BitmapFactory.Options
    //   182	147	10	localObject4	Object
    //   567	1	10	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   24	31	549	java/lang/Exception
    //   36	98	549	java/lang/Exception
    //   100	156	549	java/lang/Exception
    //   291	296	549	java/lang/Exception
    //   296	300	549	java/lang/Exception
    //   319	328	549	java/lang/Exception
    //   335	339	549	java/lang/Exception
    //   344	349	549	java/lang/Exception
    //   349	351	549	java/lang/Exception
    //   356	361	549	java/lang/Exception
    //   364	490	549	java/lang/Exception
    //   492	521	549	java/lang/Exception
    //   527	538	549	java/lang/Exception
    //   538	549	549	java/lang/Exception
    //   156	169	558	java/lang/Exception
    //   169	179	562	java/lang/Exception
    //   179	192	567	java/lang/Exception
    //   213	275	567	java/lang/Exception
    //   303	319	567	java/lang/Exception
    //   179	192	574	finally
    //   213	275	574	finally
    //   303	319	574	finally
    //   169	179	591	finally
    //   156	169	610	finally
  }
  
  @Nullable
  private Object internalDecodeFile_decodeImage(String paramString, File paramFile, BitmapFactory.Options paramOptions)
  {
    int i = 1;
    Object localObject = null;
    String str;
    while (i <= 3) {
      try
      {
        Bitmap localBitmap = SafeBitmapFactory.decodeFile(paramFile.getAbsolutePath(), paramOptions);
        if (localBitmap != null)
        {
          localObject = localBitmap;
          if (Build.VERSION.SDK_INT < 11) {
            break label311;
          }
          localObject = localBitmap;
          SliceBitmap.needSlice(localBitmap);
          break label311;
        }
        localObject = localBitmap;
        localStringBuilder = new StringBuilder();
        localObject = localBitmap;
        localStringBuilder.append("DecodeFile Failed,bitmap == null, url:");
        localObject = localBitmap;
        localStringBuilder.append(paramString);
        localObject = localBitmap;
        localStringBuilder.append(" ,retry count: ");
        localObject = localBitmap;
        localStringBuilder.append(i);
        localObject = localBitmap;
        localStringBuilder.append(",path:");
        localObject = localBitmap;
        localStringBuilder.append(paramFile.getAbsolutePath());
        localObject = localBitmap;
        throw new OutOfMemoryError(localStringBuilder.toString());
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        StringBuilder localStringBuilder;
        if (localObject != null) {
          localObject.recycle();
        }
        str = localOutOfMemoryError.getMessage();
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("DecodeFile ERROR,oom retryCount=");
          localStringBuilder.append(i);
          localStringBuilder.append(",options.inSampleSize=");
          localStringBuilder.append(paramOptions.inSampleSize);
          localStringBuilder.append(",cacheFile=");
          localStringBuilder.append(paramFile.getAbsolutePath());
          localStringBuilder.append(",url=");
          localStringBuilder.append(paramString);
          localStringBuilder.append(",oom.msg:");
          localStringBuilder.append(str);
          QLog.d("FileAssistantDownloader", 2, localStringBuilder.toString());
        }
        i += 1;
        paramOptions.inSampleSize *= 2;
      }
    }
    return null;
    label311:
    return str;
  }
  
  private RoundRectBitmap resizeAndClipBitmap(Bitmap paramBitmap)
  {
    try
    {
      f3 = this.application.getResources().getDisplayMetrics().density;
      i1 = this.application.getResources().getDisplayMetrics().densityDpi;
      f4 = URLDrawableHelper.getRoundCorner();
      k = FilePicConstants.b;
      m = FilePicConstants.c;
      j = paramBitmap.getWidth();
      i = paramBitmap.getHeight();
      localObject3 = new Paint(1);
      ((Paint)localObject3).setColor(-16777216);
      n = FilePicURLDrawlableHelper.a;
      int i2 = FilePicURLDrawlableHelper.b;
      if (j < i2) {
        break label139;
      }
      if (i >= i2) {
        break label316;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label139:
      label400:
      for (;;)
      {
        float f3;
        int i1;
        float f4;
        int k;
        int m;
        int j;
        int i;
        Object localObject3;
        int n;
        Object localObject1;
        Object localObject2;
        float f5;
        float f1;
        float f2;
        Bitmap localBitmap;
        continue;
        label316:
        if ((j < n) && (i < n))
        {
          f1 = f3;
          label333:
          j = (int)(j * f1 + 0.5F);
          i = (int)(i * f1 + 0.5F);
        }
        else if (j > i)
        {
          f1 = m;
          f2 = j;
        }
        else
        {
          f1 = m;
          f2 = i;
          continue;
          f1 = k;
          f2 = j;
          continue;
          j = i;
          i = k;
        }
      }
    }
    f5 = localObject1 / localObject2;
    if (j > i)
    {
      f1 = k;
      f2 = i;
      f1 /= f2;
      f1 = Math.max(f5, f1);
      break label333;
      if (j < i)
      {
        f1 = k / j;
        n = (int)(i * f1 + 0.5F);
        i = n;
        j = k;
        if (n > m)
        {
          i = m;
          j = k;
        }
      }
      else
      {
        f1 = k / i;
        j = (int)(j * f1 + 0.5F);
        i = j;
        if (j <= m) {
          break label400;
        }
        i = m;
        break label400;
      }
      localBitmap = Bitmap.createBitmap(j, i, URLDrawableHelper.mThumbConfig);
      localBitmap.setDensity(i1);
      new Canvas(localBitmap).drawBitmap(paramBitmap, null, new Rect(0, 0, j, i), (Paint)localObject3);
      localObject3 = new RoundRectBitmap(localBitmap, (f4 + 2.0F) * f3);
      return localObject3;
      return new RoundRectBitmap(paramBitmap, URLDrawableHelper.getAioFilePicRoundCorner());
    }
  }
  
  int byte2Int(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte[3];
    int j = paramArrayOfByte[2];
    int k = paramArrayOfByte[1];
    return paramArrayOfByte[0] & 0xFF | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramFile = AlbumThumbManager.getInstance(BaseApplicationImpl.getContext());
    paramURLDrawableHandler = parseUrl(paramDownloadParams.url);
    if (paramURLDrawableHandler == null) {
      return null;
    }
    int i;
    if (FileManagerUtil.c(paramURLDrawableHandler.path) == 2) {
      i = 1;
    } else {
      i = 0;
    }
    if ((paramURLDrawableHandler.isRaw) && (!paramURLDrawableHandler.isApkIcon) && (i == 0))
    {
      if (paramURLDrawableHandler.isAIOFilePic) {
        return internalDecodeAIOFilePic(paramDownloadParams, paramURLDrawableHandler);
      }
      paramDownloadParams = (Bitmap)internalDecodeFile(paramDownloadParams, paramURLDrawableHandler);
      paramFile = paramDownloadParams;
      if (paramURLDrawableHandler.isRound) {
        paramFile = FileManagerUtil.a(this.application, paramDownloadParams, 16);
      }
      return paramFile;
    }
    if (paramURLDrawableHandler.isApkIcon)
    {
      paramFile = ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).getApkIcon(this.application, paramURLDrawableHandler.path);
      if (paramFile != null) {
        paramFile = drawableToBitmap(paramFile);
      } else {
        paramFile = drawableToBitmap(BaseApplicationImpl.getContext().getResources().getDrawable(2130845642));
      }
    }
    else
    {
      paramFile = paramFile.getThumb(paramDownloadParams.url, new FileAssistantDownloader.VideoBitmapCreator(this));
    }
    paramDownloadParams = paramFile;
    if (paramFile == null)
    {
      paramFile = BaseApplicationImpl.getContext();
      i = FileManagerUtil.c(paramURLDrawableHandler.path);
      paramDownloadParams = drawableToBitmap(paramFile.getResources().getDrawable(FileManagerUtil.c(i)));
    }
    if (paramDownloadParams == null) {
      return null;
    }
    paramFile = paramDownloadParams;
    if (paramURLDrawableHandler.isRound) {
      paramFile = FileManagerUtil.a(this.application, paramDownloadParams, 16);
    }
    return paramFile;
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramOutputStream = parseUrl(paramDownloadParams.url);
    if ((paramOutputStream != null) && (paramOutputStream.path != null)) {
      return new File(paramOutputStream.path);
    }
    return new File(AppConstants.SDCARD_ROOT);
  }
  
  public Object internalDecodeAIOFilePic(DownloadParams paramDownloadParams, FileAssistantDownloader.PhotoInfo paramPhotoInfo)
  {
    paramDownloadParams = paramPhotoInfo.path;
    if (paramDownloadParams == null) {
      return null;
    }
    File localFile = new File(paramDownloadParams);
    try
    {
      paramDownloadParams = new BitmapFactory.Options();
      paramDownloadParams.inPreferredConfig = URLDrawableHelper.mThumbConfig;
      paramDownloadParams.inDensity = 160;
      paramDownloadParams.inTargetDensity = 160;
      paramDownloadParams.inScreenDensity = 160;
      paramDownloadParams.inJustDecodeBounds = false;
      paramPhotoInfo = SafeBitmapFactory.decodeFile(localFile.getAbsolutePath(), paramDownloadParams);
      paramDownloadParams = paramPhotoInfo;
      if (paramPhotoInfo != null)
      {
        paramDownloadParams = resizeAndClipBitmap(paramPhotoInfo);
        if (!paramPhotoInfo.equals(paramDownloadParams.mBitmap)) {
          paramPhotoInfo.recycle();
        }
        paramDownloadParams = new RoundRectBitmap(((IPicUtil)QRoute.api(IPicUtil.class)).getExifBitmap(localFile.getAbsolutePath(), paramDownloadParams.mBitmap), paramDownloadParams.mCornerRadius, paramDownloadParams.mBoardColor, paramDownloadParams.mBorderWidth);
        if (this.application != null)
        {
          paramDownloadParams.mDisplayWidth = this.application.getResources().getDisplayMetrics().widthPixels;
          paramDownloadParams.mDisplayHeight = this.application.getResources().getDisplayMetrics().heightPixels;
        }
      }
      return paramDownloadParams;
    }
    catch (Exception paramDownloadParams)
    {
      throw paramDownloadParams;
    }
  }
  
  public FileAssistantDownloader.PhotoInfo parseUrl(URL paramURL)
  {
    try
    {
      paramURL = paramURL.getFile().split("\\|");
      localPhotoInfo = new FileAssistantDownloader.PhotoInfo(this);
      bool2 = false;
      localPhotoInfo.path = paramURL[0];
      localPhotoInfo.thumbWidth = Integer.parseInt(paramURL[1]);
      localPhotoInfo.thumbHeight = Integer.parseInt(paramURL[2]);
      localPhotoInfo.modifiedDate = Long.parseLong(paramURL[3]);
      if (paramURL.length <= 4) {
        break label91;
      }
      if (Integer.parseInt(paramURL[4]) != 1) {
        break label184;
      }
      bool1 = true;
    }
    catch (Exception paramURL)
    {
      for (;;)
      {
        FileAssistantDownloader.PhotoInfo localPhotoInfo;
        boolean bool2;
        label91:
        continue;
        label184:
        boolean bool1 = false;
        continue;
        bool1 = false;
        continue;
        label194:
        bool1 = false;
      }
    }
    localPhotoInfo.isRaw = bool1;
    if (paramURL.length > 5)
    {
      if (Integer.parseInt(paramURL[5]) == 1)
      {
        bool1 = true;
        localPhotoInfo.isRound = bool1;
      }
    }
    else
    {
      if (paramURL.length > 6)
      {
        if (Integer.parseInt(paramURL[6]) != 1) {
          break label194;
        }
        bool1 = true;
        localPhotoInfo.isApkIcon = bool1;
      }
      if (paramURL.length > 7)
      {
        bool1 = bool2;
        if (Integer.parseInt(paramURL[7]) == 1) {
          bool1 = true;
        }
        localPhotoInfo.isAIOFilePic = bool1;
      }
      return localPhotoInfo;
      return null;
    }
  }
  
  public boolean useDiskCache()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FileAssistantDownloader
 * JD-Core Version:    0.7.0.1
 */