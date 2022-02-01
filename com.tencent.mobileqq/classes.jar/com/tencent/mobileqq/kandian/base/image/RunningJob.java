package com.tencent.mobileqq.kandian.base.image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCache;
import com.tencent.mobileqq.kandian.base.image.api.IBitmapCallback;
import com.tencent.mobileqq.kandian.base.image.imageloader.CloseableBitmap;
import com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptReport;
import com.tencent.mobileqq.kandian.base.image.imageloader.Utils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.DiskCache;
import com.tencent.mobileqq.transfile.HttpDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RunningJob
  implements Runnable
{
  public static final String a;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  ImageManager jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageManager;
  ImageRequest jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest;
  IBitmapCache jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiIBitmapCache;
  DiskCache jdField_a_of_type_ComTencentMobileqqTransfileDiskCache;
  HttpDownloader jdField_a_of_type_ComTencentMobileqqTransfileHttpDownloader;
  File jdField_a_of_type_JavaIoFile;
  Set<WeakReference<IBitmapCallback>> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("zimage.");
    localStringBuilder.append(RunningJob.class.getSimpleName());
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public RunningJob(ImageManager paramImageManager, ImageRequest paramImageRequest)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageManager = paramImageManager;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest = paramImageRequest;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiIBitmapCache = paramImageManager.mBitmapCache;
    this.jdField_a_of_type_ComTencentMobileqqTransfileDiskCache = new DiskCache(URLDrawableHelper.diskCachePath);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public static int a(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = 1;
    int m = j;
    if (paramInt1 != 0)
    {
      m = j;
      if (paramInt2 != 0)
      {
        m = j;
        if (paramInt1 != -1)
        {
          if (paramInt2 == -1) {
            return 1;
          }
          j = Math.min(paramOptions.outHeight, 2048);
          int k = Math.min(paramOptions.outWidth, 2048);
          for (;;)
          {
            m = i;
            if (j <= paramInt2) {
              break;
            }
            m = i;
            if (k <= paramInt1) {
              break;
            }
            int n = Math.round(j / paramInt2);
            m = Math.round(k / paramInt1);
            if (n <= m) {
              n = m;
            }
            m = i;
            if (n < 2) {
              break;
            }
            k >>= 1;
            j >>= 1;
            i <<= 1;
          }
        }
      }
    }
    return m;
  }
  
  /* Error */
  private Bitmap a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: getfield 121	com/tencent/mobileqq/kandian/base/image/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   10: instanceof 123
    //   13: ifeq +111 -> 124
    //   16: new 125	java/io/ByteArrayInputStream
    //   19: dup
    //   20: aload_0
    //   21: getfield 121	com/tencent/mobileqq/kandian/base/image/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   24: checkcast 123	com/tencent/mobileqq/kandian/base/image/RIJImageOptBitmapFile
    //   27: invokevirtual 129	com/tencent/mobileqq/kandian/base/image/RIJImageOptBitmapFile:getBytes	()[B
    //   30: invokespecial 132	java/io/ByteArrayInputStream:<init>	([B)V
    //   33: astore 4
    //   35: new 125	java/io/ByteArrayInputStream
    //   38: dup
    //   39: aload_0
    //   40: getfield 121	com/tencent/mobileqq/kandian/base/image/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   43: checkcast 123	com/tencent/mobileqq/kandian/base/image/RIJImageOptBitmapFile
    //   46: invokevirtual 129	com/tencent/mobileqq/kandian/base/image/RIJImageOptBitmapFile:getBytes	()[B
    //   49: invokespecial 132	java/io/ByteArrayInputStream:<init>	([B)V
    //   52: astore 5
    //   54: aload_0
    //   55: getfield 121	com/tencent/mobileqq/kandian/base/image/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   58: checkcast 123	com/tencent/mobileqq/kandian/base/image/RIJImageOptBitmapFile
    //   61: invokevirtual 135	com/tencent/mobileqq/kandian/base/image/RIJImageOptBitmapFile:getLength	()J
    //   64: lstore_1
    //   65: iconst_0
    //   66: istore_3
    //   67: goto +128 -> 195
    //   70: astore 8
    //   72: aload 4
    //   74: astore 6
    //   76: aload 5
    //   78: astore 7
    //   80: aload 8
    //   82: astore 4
    //   84: aload 6
    //   86: astore 5
    //   88: aload 7
    //   90: astore 6
    //   92: goto +268 -> 360
    //   95: astore 6
    //   97: goto +208 -> 305
    //   100: astore 7
    //   102: aconst_null
    //   103: astore 6
    //   105: aload 4
    //   107: astore 5
    //   109: aload 7
    //   111: astore 4
    //   113: goto +247 -> 360
    //   116: astore 6
    //   118: aconst_null
    //   119: astore 5
    //   121: goto +184 -> 305
    //   124: new 137	java/io/FileInputStream
    //   127: dup
    //   128: aload_0
    //   129: getfield 121	com/tencent/mobileqq/kandian/base/image/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   132: invokespecial 138	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   135: astore 4
    //   137: new 137	java/io/FileInputStream
    //   140: dup
    //   141: aload_0
    //   142: getfield 121	com/tencent/mobileqq/kandian/base/image/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   145: invokespecial 138	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   148: astore 5
    //   150: aload 4
    //   152: astore 8
    //   154: aload 5
    //   156: astore 6
    //   158: aload 4
    //   160: astore 9
    //   162: aload 5
    //   164: astore 7
    //   166: aload_0
    //   167: getfield 121	com/tencent/mobileqq/kandian/base/image/RunningJob:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   170: invokevirtual 143	java/io/File:length	()J
    //   173: lstore_1
    //   174: aload 4
    //   176: astore 8
    //   178: aload 5
    //   180: astore 6
    //   182: aload 4
    //   184: astore 9
    //   186: aload 5
    //   188: astore 7
    //   190: aload_0
    //   191: invokevirtual 146	com/tencent/mobileqq/kandian/base/image/RunningJob:a	()Z
    //   194: istore_3
    //   195: aload 4
    //   197: astore 8
    //   199: aload 5
    //   201: astore 6
    //   203: aload 4
    //   205: astore 9
    //   207: aload 5
    //   209: astore 7
    //   211: aload_0
    //   212: aload 4
    //   214: aload 5
    //   216: lload_1
    //   217: iload_3
    //   218: invokevirtual 149	com/tencent/mobileqq/kandian/base/image/RunningJob:a	(Ljava/io/InputStream;Ljava/io/InputStream;JZ)Landroid/graphics/Bitmap;
    //   221: astore 10
    //   223: aload_0
    //   224: aload 4
    //   226: invokespecial 152	com/tencent/mobileqq/kandian/base/image/RunningJob:a	(Ljava/io/InputStream;)V
    //   229: aload_0
    //   230: aload 5
    //   232: invokespecial 152	com/tencent/mobileqq/kandian/base/image/RunningJob:a	(Ljava/io/InputStream;)V
    //   235: aload 10
    //   237: areturn
    //   238: astore 4
    //   240: aload 8
    //   242: astore 5
    //   244: goto +116 -> 360
    //   247: astore 6
    //   249: aload 9
    //   251: astore 4
    //   253: aload 7
    //   255: astore 5
    //   257: goto +48 -> 305
    //   260: astore 6
    //   262: aload 4
    //   264: astore 5
    //   266: aload 6
    //   268: astore 4
    //   270: aconst_null
    //   271: astore 6
    //   273: goto +87 -> 360
    //   276: astore 6
    //   278: aconst_null
    //   279: astore 5
    //   281: goto +24 -> 305
    //   284: astore 4
    //   286: aconst_null
    //   287: astore 6
    //   289: goto +71 -> 360
    //   292: astore 7
    //   294: aconst_null
    //   295: astore 5
    //   297: aload 6
    //   299: astore 4
    //   301: aload 7
    //   303: astore 6
    //   305: new 23	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   312: astore 7
    //   314: aload 7
    //   316: ldc 154
    //   318: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 7
    //   324: aload 6
    //   326: invokevirtual 155	java/lang/Exception:toString	()Ljava/lang/String;
    //   329: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: new 157	java/lang/RuntimeException
    //   336: dup
    //   337: aload 7
    //   339: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokespecial 160	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   345: athrow
    //   346: astore 7
    //   348: aload 5
    //   350: astore 6
    //   352: aload 4
    //   354: astore 5
    //   356: aload 7
    //   358: astore 4
    //   360: aload_0
    //   361: aload 5
    //   363: invokespecial 152	com/tencent/mobileqq/kandian/base/image/RunningJob:a	(Ljava/io/InputStream;)V
    //   366: aload_0
    //   367: aload 6
    //   369: invokespecial 152	com/tencent/mobileqq/kandian/base/image/RunningJob:a	(Ljava/io/InputStream;)V
    //   372: aload 4
    //   374: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	this	RunningJob
    //   64	153	1	l	long
    //   66	152	3	bool	boolean
    //   33	192	4	localObject1	Object
    //   238	1	4	localObject2	Object
    //   251	18	4	localObject3	Object
    //   284	1	4	localObject4	Object
    //   299	74	4	localObject5	Object
    //   1	361	5	localObject6	Object
    //   4	87	6	localObject7	Object
    //   95	1	6	localException1	Exception
    //   103	1	6	localObject8	Object
    //   116	1	6	localException2	Exception
    //   156	46	6	localObject9	Object
    //   247	1	6	localException3	Exception
    //   260	7	6	localObject10	Object
    //   271	1	6	localObject11	Object
    //   276	1	6	localException4	Exception
    //   287	81	6	localObject12	Object
    //   78	11	7	localObject13	Object
    //   100	10	7	localObject14	Object
    //   164	90	7	localObject15	Object
    //   292	10	7	localException5	Exception
    //   312	26	7	localStringBuilder	StringBuilder
    //   346	11	7	localObject16	Object
    //   70	11	8	localObject17	Object
    //   152	89	8	localObject18	Object
    //   160	90	9	localObject19	Object
    //   221	15	10	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   54	65	70	finally
    //   54	65	95	java/lang/Exception
    //   35	54	100	finally
    //   35	54	116	java/lang/Exception
    //   166	174	238	finally
    //   190	195	238	finally
    //   211	223	238	finally
    //   166	174	247	java/lang/Exception
    //   190	195	247	java/lang/Exception
    //   211	223	247	java/lang/Exception
    //   137	150	260	finally
    //   137	150	276	java/lang/Exception
    //   6	35	284	finally
    //   124	137	284	finally
    //   6	35	292	java/lang/Exception
    //   124	137	292	java/lang/Exception
    //   305	346	346	finally
  }
  
  private Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = paramBitmap;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_c_of_type_Int == 1) {
      localBitmap = ImageUtil.c(paramBitmap, this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_b_of_type_Int);
    }
    return localBitmap;
  }
  
  @Nullable
  private Bitmap a(boolean paramBoolean)
  {
    Bitmap localBitmap2 = null;
    Object localObject1 = null;
    Bitmap localBitmap1 = null;
    Object localObject3 = localObject1;
    if (paramBoolean)
    {
      localObject3 = localObject1;
      if (this.jdField_a_of_type_JavaIoFile != null)
      {
        localObject3 = localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest != null)
        {
          localObject3 = localObject1;
          if (Build.VERSION.SDK_INT >= 19)
          {
            localObject3 = localBitmap1;
            Object localObject2;
            try
            {
              Object localObject4 = RIJImageTypeOptHelper.a.a(this.jdField_a_of_type_JavaIoFile.getPath());
              localObject3 = localBitmap1;
              localObject1 = localBitmap2;
              if (((BitmapFactory.Options)localObject4).outWidth != -1)
              {
                localObject3 = localBitmap1;
                localObject1 = localBitmap2;
                if (((BitmapFactory.Options)localObject4).outHeight != -1)
                {
                  localObject3 = localBitmap1;
                  int j = a((BitmapFactory.Options)localObject4, this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_b_of_type_Int);
                  localObject3 = localBitmap1;
                  int i = ((BitmapFactory.Options)localObject4).outWidth / j;
                  localObject3 = localBitmap1;
                  j = ((BitmapFactory.Options)localObject4).outHeight / j;
                  localObject3 = localBitmap1;
                  ((BitmapFactory.Options)localObject4).outWidth = i;
                  localObject3 = localBitmap1;
                  ((BitmapFactory.Options)localObject4).outHeight = j;
                  localObject3 = localBitmap1;
                  ((BitmapFactory.Options)localObject4).inSampleSize = 1;
                  localObject3 = localBitmap1;
                  ((BitmapFactory.Options)localObject4).inMutable = true;
                  localObject3 = localBitmap1;
                  localBitmap2 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiIBitmapCache.getReusableBitmap((BitmapFactory.Options)localObject4);
                  if (localBitmap2 != null)
                  {
                    localObject3 = localBitmap1;
                    localObject1 = jdField_a_of_type_JavaLangString;
                    localObject3 = localBitmap1;
                    localObject4 = new StringBuilder();
                    localObject3 = localBitmap1;
                    ((StringBuilder)localObject4).append("origin bitmap: ");
                    localObject3 = localBitmap1;
                    ((StringBuilder)localObject4).append(localBitmap2.getWidth());
                    localObject3 = localBitmap1;
                    ((StringBuilder)localObject4).append(" ");
                    localObject3 = localBitmap1;
                    ((StringBuilder)localObject4).append(localBitmap2.getHeight());
                    localObject3 = localBitmap1;
                    ((StringBuilder)localObject4).append(" after: ");
                    localObject3 = localBitmap1;
                    ((StringBuilder)localObject4).append(i);
                    localObject3 = localBitmap1;
                    ((StringBuilder)localObject4).append(" ");
                    localObject3 = localBitmap1;
                    ((StringBuilder)localObject4).append(j);
                    localObject3 = localBitmap1;
                    QLog.d((String)localObject1, 2, ((StringBuilder)localObject4).toString());
                    localObject3 = localBitmap1;
                    localBitmap2.reconfigure(i, j, Bitmap.Config.ARGB_8888);
                  }
                  localObject3 = localBitmap1;
                  localBitmap1 = RIJImageTypeOptHelper.a.a(this.jdField_a_of_type_JavaIoFile.getPath(), i, j, localBitmap2);
                  localObject1 = localBitmap1;
                  if (localBitmap2 != null)
                  {
                    localObject1 = localBitmap1;
                    if (localBitmap1 != localBitmap2)
                    {
                      localObject3 = localBitmap1;
                      QLog.d(jdField_a_of_type_JavaLangString, 2, "reuse failed");
                      localObject1 = localBitmap1;
                    }
                  }
                }
              }
            }
            catch (Error localError)
            {
              QLog.d(jdField_a_of_type_JavaLangString, 1, localError.getMessage());
              localObject2 = localObject3;
            }
            localObject3 = localObject2;
            if (localObject2 == null)
            {
              QLog.d(jdField_a_of_type_JavaLangString, 1, "sharpP bitmap is null");
              localObject3 = localObject2;
            }
          }
        }
      }
    }
    return localObject3;
  }
  
  @TargetApi(11)
  private BitmapFactory.Options a(InputStream paramInputStream)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiIBitmapCache.getTempBufferSize() > 0)
        {
          arrayOfByte1 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiIBitmapCache.removeTempBuffer(0);
          byte[] arrayOfByte2 = arrayOfByte1;
          if (arrayOfByte1 == null)
          {
            arrayOfByte1 = new byte[16384];
            arrayOfByte2 = arrayOfByte1;
            if (QLog.isColorLevel())
            {
              Utils.a(jdField_a_of_type_JavaLangString, "allocate temp storage");
              arrayOfByte2 = arrayOfByte1;
            }
          }
          localOptions.inTempStorage = arrayOfByte2;
          localOptions.inJustDecodeBounds = true;
          try
          {
            BitmapFactory.decodeStream(new BufferedInputStream(paramInputStream), null, localOptions);
            if ((localOptions.outWidth != -1) && (localOptions.outHeight != -1))
            {
              localOptions.inJustDecodeBounds = false;
              localOptions.inDither = true;
              localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
              if (Build.VERSION.SDK_INT >= 11) {
                localOptions.inMutable = true;
              }
              localOptions.inSampleSize = a(localOptions, this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_b_of_type_Int);
              return localOptions;
            }
            throw new IllegalArgumentException("decode bounds fail");
          }
          catch (Exception paramInputStream)
          {
            this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiIBitmapCache.addTempBuffer(localOptions.inTempStorage);
            throw paramInputStream;
          }
          catch (OutOfMemoryError paramInputStream)
          {
            this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiIBitmapCache.addTempBuffer(localOptions.inTempStorage);
            throw paramInputStream;
          }
        }
        byte[] arrayOfByte1 = null;
      }
      finally {}
    }
  }
  
  private Rect a(BitmapFactory.Options paramOptions)
  {
    int i = Math.min(paramOptions.outWidth, 2048);
    int j = Math.min(paramOptions.outHeight, 2048);
    int k = (paramOptions.outWidth - i) / 2;
    int m = (paramOptions.outHeight - j) / 2;
    return new Rect(k, m, i + k, j + m);
  }
  
  @NotNull
  private DownloadParams a()
  {
    DownloadParams localDownloadParams = new DownloadParams();
    localDownloadParams.url = this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_a_of_type_JavaNetURL;
    localDownloadParams.urlStr = this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_a_of_type_JavaNetURL.toString();
    localDownloadParams.retryCount = this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_f_of_type_Int;
    return localDownloadParams;
  }
  
  private File a(DownloadParams paramDownloadParams, StringBuilder paramStringBuilder)
  {
    return this.jdField_a_of_type_ComTencentMobileqqTransfileHttpDownloader.loadImageFile(paramDownloadParams, new RunningJob.1(this, paramStringBuilder));
  }
  
  private void a(long paramLong)
  {
    ImageRequest localImageRequest = this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest;
    if (localImageRequest != null) {
      localImageRequest.jdField_e_of_type_Long = paramLong;
    }
  }
  
  private void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageManager.removeJob(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
    paramBitmap = new CloseableBitmap(a(paramBitmap), this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiIBitmapCache.getReleaser());
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiIBitmapCache.cacheBitmap(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest, paramBitmap);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_a_of_type_Boolean)
    {
      RIJImageOptReport.a(6, this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
      RIJImageOptReport.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest, false, "cancelled");
      paramBitmap.a();
      return;
    }
    RIJImageOptReport.a(5, this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
    if (RIJImageOptConfig.INSTANCE.isRenderFirst())
    {
      this.jdField_a_of_type_AndroidOsHandler.postAtFrontOfQueue(new RunningJob.2(this, paramBitmap));
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new RunningJob.3(this, paramBitmap));
  }
  
  private void a(Bitmap paramBitmap, long paramLong1, long paramLong2)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest;
    if (localObject != null)
    {
      ((ImageRequest)localObject).jdField_f_of_type_Long = paramLong2;
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[decode success](");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(") total(");
      localStringBuilder.append(paramLong1 - this.jdField_a_of_type_Long);
      localStringBuilder.append(")");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
      localStringBuilder.append("; size =");
      localStringBuilder.append(paramBitmap.getByteCount());
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
  }
  
  private void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramBitmap);
      return;
    }
    d(new RuntimeException("bitmap null"));
  }
  
  private void a(CloseableBitmap paramCloseableBitmap)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_a_of_type_Boolean)
    {
      RIJImageOptReport.a(6, this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
      RIJImageOptReport.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest, false, "cancelled");
      paramCloseableBitmap.a();
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      WeakReference localWeakReference = (WeakReference)localIterator.next();
      if (localWeakReference.get() != null) {
        ((IBitmapCallback)localWeakReference.get()).a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest, paramCloseableBitmap.a());
      }
    }
    paramCloseableBitmap.a();
  }
  
  private void a(InputStream paramInputStream)
  {
    if (paramInputStream != null) {
      try
      {
        paramInputStream.close();
        return;
      }
      catch (IOException paramInputStream)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, paramInputStream.getMessage());
      }
    }
  }
  
  private void a(Throwable paramThrowable)
  {
    try
    {
      if (c(paramThrowable))
      {
        a(paramThrowable, -3);
        return;
      }
      if (b(paramThrowable))
      {
        c(paramThrowable);
        return;
      }
      if (a(paramThrowable))
      {
        b(paramThrowable);
        return;
      }
      d(paramThrowable);
      return;
    }
    catch (Exception paramThrowable)
    {
      d(paramThrowable);
    }
  }
  
  private void a(Throwable paramThrowable, int paramInt)
  {
    Object localObject1 = jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[job fail] failCode:");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append(paramThrowable);
    ((StringBuilder)localObject2).append(" retryCount:");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
    QLog.d((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_e_of_type_Int == -2) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_e_of_type_Int = paramInt;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageManager.removeJob(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_a_of_type_Boolean)
    {
      RIJImageOptReport.a(6, this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
      RIJImageOptReport.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest, false, "cancelled");
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_f_of_type_Int == ImageRequest.g)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest;
      if (paramThrowable != null) {
        localObject1 = paramThrowable.getMessage();
      } else {
        localObject1 = "";
      }
      RIJImageOptReport.a((ImageRequest)localObject2, false, (String)localObject1);
    }
    if (e())
    {
      e(paramThrowable);
      return;
    }
    localObject1 = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (WeakReference)((Iterator)localObject1).next();
      if (((WeakReference)localObject2).get() != null) {
        this.jdField_a_of_type_AndroidOsHandler.post(new RunningJob.4(this, (WeakReference)localObject2, paramThrowable));
      }
    }
  }
  
  private static void a(boolean paramBoolean1, long paramLong, int paramInt, boolean paramBoolean2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("showUseTime", Long.toString(paramLong));
    String str2 = "1";
    String str1;
    if (paramBoolean1) {
      str1 = "1";
    } else {
      str1 = "2";
    }
    localHashMap.put("cached", str1);
    if (paramBoolean2) {
      str1 = str2;
    } else {
      str1 = "0";
    }
    localHashMap.put("success", str1);
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actKandianImageShow", paramBoolean2, paramLong, paramInt, localHashMap, "", true);
  }
  
  private void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    Bitmap localBitmap = a();
    long l = System.currentTimeMillis();
    paramLong1 = l - paramLong1;
    a(localBitmap, l, paramLong1);
    int j = 0;
    boolean bool;
    if (localBitmap != null) {
      bool = true;
    } else {
      bool = false;
    }
    int i = j;
    if (bool)
    {
      i = j;
      if (localBitmap != null) {
        i = localBitmap.getByteCount();
      }
    }
    a(paramBoolean, paramLong2 + paramLong1, i, bool);
    a(localBitmap, bool);
  }
  
  private boolean a(Throwable paramThrowable)
  {
    return (paramThrowable.getMessage() != null) && ((((paramThrowable instanceof RuntimeException)) && (paramThrowable.getMessage().contains("decode fail"))) || (((paramThrowable instanceof IOException)) && (paramThrowable.getMessage().contains("write 0 length file or null File"))));
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_a_of_type_Boolean) {
      return;
    }
    throw new RuntimeException("cancel");
  }
  
  private void b(Throwable paramThrowable)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramThrowable.getMessage());
    localStringBuilder.append(" ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
    localStringBuilder.append(" retryCount:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    QLog.d(str, 1, localStringBuilder.toString());
    int i = this.jdField_a_of_type_Int;
    if (i == 0)
    {
      this.jdField_a_of_type_Int = (i + 1);
      paramThrowable = this.jdField_a_of_type_JavaIoFile;
      if (paramThrowable != null) {
        paramThrowable.delete();
      }
      run();
      return;
    }
    a(paramThrowable, -3);
  }
  
  private boolean b()
  {
    for (;;)
    {
      try
      {
        if (d()) {
          return true;
        }
        this.jdField_a_of_type_ComTencentMobileqqTransfileHttpDownloader = ((HttpDownloader)((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).getHttpDownloader());
        Object localObject = a();
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqTransfileHttpDownloader.hasDiskFile((DownloadParams)localObject);
        l1 = System.currentTimeMillis();
        this.jdField_a_of_type_JavaIoFile = a((DownloadParams)localObject, new StringBuilder());
        c();
        long l2 = System.currentTimeMillis();
        long l3 = l2 - l1;
        a(l3);
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[download success](");
        localStringBuilder.append(l3);
        localStringBuilder.append(")");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
        localStringBuilder.append(" fileSize:");
        if (this.jdField_a_of_type_JavaIoFile == null) {
          break label218;
        }
        l1 = this.jdField_a_of_type_JavaIoFile.length();
        localStringBuilder.append(l1);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
        b();
        if (c()) {
          return true;
        }
        a(bool, l2, l3);
      }
      catch (Throwable localThrowable)
      {
        a(localThrowable);
      }
      return false;
      label218:
      long l1 = 0L;
    }
  }
  
  private boolean b(Throwable paramThrowable)
  {
    return (((paramThrowable instanceof RuntimeException)) || ((paramThrowable instanceof IOException))) && (paramThrowable.getMessage() != null) && (paramThrowable.getMessage().contains("cancel"));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_JavaIoFile != null) {
      return;
    }
    throw new IOException("downloader fail");
  }
  
  private void c(Throwable paramThrowable)
  {
    RIJImageOptReport.a(6, this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
    RIJImageOptReport.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest, false, paramThrowable.getMessage());
  }
  
  private boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilSet.isEmpty()))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageManager.removeJob(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[preload request]");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
      localStringBuilder.append(" no callback, give up decode");
      QLog.d(str, 2, localStringBuilder.toString());
      ImageManager.get().removeExecuteJob(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
      return true;
    }
    return false;
  }
  
  private boolean c(Throwable paramThrowable)
  {
    return ((paramThrowable instanceof RuntimeException)) && (paramThrowable.getMessage() != null) && (paramThrowable.getMessage().equals("sharpP decode fail"));
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.d == 0) {
      RIJImageOptReport.b(2, this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
    }
  }
  
  private void d(Throwable paramThrowable)
  {
    a(paramThrowable, -1);
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_a_of_type_Boolean)
    {
      RIJImageOptReport.a(6, this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
      ImageManager.get().removeExecuteJob(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
      return true;
    }
    return false;
  }
  
  private void e(Throwable paramThrowable)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest;
    ((ImageRequest)localObject).jdField_f_of_type_Int += 1;
    localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("try count: ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_f_of_type_Int);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
    QLog.d((String)localObject, 1, localStringBuilder.toString());
    if (((paramThrowable != null) && (paramThrowable.getMessage() != null) && (paramThrowable.getMessage().equals("sharpP decode fail"))) || (this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_e_of_type_Int == 400))
    {
      paramThrowable = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("before convert: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_a_of_type_JavaNetURL);
      QLog.d(paramThrowable, 1, ((StringBuilder)localObject).toString());
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_a_of_type_JavaNetURL = new URL(RIJImageTypeOptHelper.a.b(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_a_of_type_JavaNetURL.toString(), this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_c_of_type_JavaLangString));
      }
      catch (Exception paramThrowable)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, paramThrowable.getMessage());
      }
      paramThrowable = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("after convert: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_a_of_type_JavaNetURL);
      QLog.d(paramThrowable, 1, ((StringBuilder)localObject).toString());
    }
    ThreadManager.getUIHandler().post(new RunningJob.5(this));
  }
  
  private boolean e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_f_of_type_Int < ImageRequest.g;
  }
  
  public Bitmap a(InputStream paramInputStream1, InputStream paramInputStream2, long paramLong)
  {
    if (Utils.a()) {
      return b(paramInputStream1, paramInputStream2, paramLong);
    }
    return c(paramInputStream1, paramInputStream2, paramLong);
  }
  
  protected Bitmap a(InputStream paramInputStream1, InputStream paramInputStream2, long paramLong, boolean paramBoolean)
  {
    Bitmap localBitmap2 = a(paramBoolean);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null) {
      localBitmap1 = a(paramInputStream1, paramInputStream2, paramLong);
    }
    return localBitmap1;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[cancel request]");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
      Utils.a((String)localObject, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_a_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileHttpDownloader;
    if (localObject != null) {
      ((HttpDownloader)localObject).cancel();
    }
  }
  
  public void a(IBitmapCallback paramIBitmapCallback)
  {
    if (paramIBitmapCallback != null) {}
    try
    {
      this.jdField_a_of_type_JavaUtilSet.add(new WeakReference(paramIBitmapCallback));
    }
    finally {}
  }
  
  protected boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    for (;;)
    {
      try
      {
        if (AVSoUtils.a())
        {
          bool1 = bool2;
          if (RIJImageOptConfig.INSTANCE.useSharpP())
          {
            RIJImageTypeOptHelper localRIJImageTypeOptHelper = RIJImageTypeOptHelper.a;
            if (this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_a_of_type_JavaNetURL == null) {
              break label97;
            }
            String str1 = this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest.jdField_a_of_type_JavaNetURL.toString();
            bool1 = bool2;
            if (localRIJImageTypeOptHelper.a(str1))
            {
              boolean bool3 = SharpPUtil.isSharpPFile(this.jdField_a_of_type_JavaIoFile);
              bool1 = bool2;
              if (bool3) {
                bool1 = true;
              }
            }
          }
        }
        return bool1;
      }
      catch (Throwable localThrowable)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, localThrowable.getMessage());
        return false;
      }
      label97:
      String str2 = "";
    }
  }
  
  /* Error */
  @TargetApi(21)
  public Bitmap b(InputStream paramInputStream1, InputStream paramInputStream2, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokespecial 721	com/tencent/mobileqq/kandian/base/image/RunningJob:a	(Ljava/io/InputStream;)Landroid/graphics/BitmapFactory$Options;
    //   5: astore_2
    //   6: invokestatic 272	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +65 -> 74
    //   12: getstatic 43	com/tencent/mobileqq/kandian/base/image/RunningJob:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   15: astore 6
    //   17: new 23	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   24: astore 7
    //   26: aload 7
    //   28: ldc_w 723
    //   31: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload 7
    //   37: aload_0
    //   38: getfield 70	com/tencent/mobileqq/kandian/base/image/RunningJob:jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest	Lcom/tencent/mobileqq/kandian/base/image/ImageRequest;
    //   41: invokevirtual 430	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 7
    //   47: ldc_w 725
    //   50: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 7
    //   56: aload_2
    //   57: getfield 200	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   60: invokevirtual 221	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload 6
    //   66: aload 7
    //   68: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 279	com/tencent/mobileqq/kandian/base/image/imageloader/Utils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload_0
    //   75: getfield 77	com/tencent/mobileqq/kandian/base/image/RunningJob:jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiIBitmapCache	Lcom/tencent/mobileqq/kandian/base/image/api/IBitmapCache;
    //   78: aload_2
    //   79: invokeinterface 210 2 0
    //   84: astore 6
    //   86: aload 6
    //   88: ifnull +15 -> 103
    //   91: aload_2
    //   92: aload 6
    //   94: putfield 729	android/graphics/BitmapFactory$Options:inBitmap	Landroid/graphics/Bitmap;
    //   97: iconst_1
    //   98: istore 5
    //   100: goto +6 -> 106
    //   103: iconst_0
    //   104: istore 5
    //   106: new 288	java/io/BufferedInputStream
    //   109: dup
    //   110: aload_1
    //   111: invokespecial 290	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   114: astore_1
    //   115: aload_2
    //   116: invokestatic 732	com/tencent/mobileqq/kandian/base/image/imageloader/Utils:a	(Landroid/graphics/BitmapFactory$Options;)Z
    //   119: ifeq +21 -> 140
    //   122: aload_1
    //   123: iconst_0
    //   124: invokestatic 738	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   127: aload_0
    //   128: aload_2
    //   129: invokespecial 740	com/tencent/mobileqq/kandian/base/image/RunningJob:a	(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Rect;
    //   132: aload_2
    //   133: invokevirtual 744	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   136: astore_1
    //   137: goto +10 -> 147
    //   140: aload_1
    //   141: aconst_null
    //   142: aload_2
    //   143: invokestatic 296	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   146: astore_1
    //   147: aload_0
    //   148: getfield 77	com/tencent/mobileqq/kandian/base/image/RunningJob:jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiIBitmapCache	Lcom/tencent/mobileqq/kandian/base/image/api/IBitmapCache;
    //   151: aload_2
    //   152: getfield 283	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   155: invokeinterface 310 2 0
    //   160: iload 5
    //   162: ifeq +23 -> 185
    //   165: aload 6
    //   167: aload_1
    //   168: if_acmpne +5 -> 173
    //   171: aload_1
    //   172: areturn
    //   173: aload_1
    //   174: invokevirtual 747	android/graphics/Bitmap:recycle	()V
    //   177: new 749	java/lang/IllegalStateException
    //   180: dup
    //   181: invokespecial 750	java/lang/IllegalStateException:<init>	()V
    //   184: athrow
    //   185: aload_1
    //   186: areturn
    //   187: astore_1
    //   188: goto +9 -> 197
    //   191: astore_1
    //   192: aload_1
    //   193: athrow
    //   194: astore_1
    //   195: aload_1
    //   196: athrow
    //   197: aload_0
    //   198: getfield 77	com/tencent/mobileqq/kandian/base/image/RunningJob:jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiIBitmapCache	Lcom/tencent/mobileqq/kandian/base/image/api/IBitmapCache;
    //   201: aload_2
    //   202: getfield 283	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   205: invokeinterface 310 2 0
    //   210: aload_1
    //   211: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	RunningJob
    //   0	212	1	paramInputStream1	InputStream
    //   0	212	2	paramInputStream2	InputStream
    //   0	212	3	paramLong	long
    //   98	63	5	i	int
    //   15	151	6	localObject	Object
    //   24	43	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   106	137	187	finally
    //   140	147	187	finally
    //   192	194	187	finally
    //   195	197	187	finally
    //   106	137	191	java/lang/RuntimeException
    //   140	147	191	java/lang/RuntimeException
    //   106	137	194	java/lang/OutOfMemoryError
    //   140	147	194	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public Bitmap c(InputStream paramInputStream1, InputStream paramInputStream2, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokespecial 721	com/tencent/mobileqq/kandian/base/image/RunningJob:a	(Ljava/io/InputStream;)Landroid/graphics/BitmapFactory$Options;
    //   5: astore 12
    //   7: aload 12
    //   9: getstatic 753	com/tencent/mobileqq/kandian/base/image/NativeBitmap:jdField_a_of_type_Boolean	Z
    //   12: putfield 756	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   15: lload_3
    //   16: l2i
    //   17: istore 5
    //   19: aconst_null
    //   20: astore 10
    //   22: aconst_null
    //   23: astore_2
    //   24: aconst_null
    //   25: astore 7
    //   27: aconst_null
    //   28: astore 9
    //   30: aconst_null
    //   31: astore 8
    //   33: aconst_null
    //   34: astore 11
    //   36: new 288	java/io/BufferedInputStream
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 290	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   44: astore 6
    //   46: aload 11
    //   48: astore 7
    //   50: aload 10
    //   52: astore 8
    //   54: aload 6
    //   56: astore_2
    //   57: aload 9
    //   59: astore_1
    //   60: aload_0
    //   61: getfield 77	com/tencent/mobileqq/kandian/base/image/RunningJob:jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiIBitmapCache	Lcom/tencent/mobileqq/kandian/base/image/api/IBitmapCache;
    //   64: invokeinterface 760 1 0
    //   69: iload 5
    //   71: invokevirtual 764	com/tencent/mobileqq/kandian/base/image/BytePool:a	(I)[B
    //   74: astore 9
    //   76: aload 9
    //   78: astore 7
    //   80: aload 9
    //   82: astore 8
    //   84: aload 6
    //   86: astore_2
    //   87: aload 9
    //   89: astore_1
    //   90: aload 6
    //   92: aload 9
    //   94: iconst_0
    //   95: iload 5
    //   97: invokevirtual 768	java/io/InputStream:read	([BII)I
    //   100: pop
    //   101: aload 9
    //   103: astore 7
    //   105: aload 9
    //   107: astore 8
    //   109: aload 6
    //   111: astore_2
    //   112: aload 9
    //   114: astore_1
    //   115: aload 12
    //   117: invokestatic 732	com/tencent/mobileqq/kandian/base/image/imageloader/Utils:a	(Landroid/graphics/BitmapFactory$Options;)Z
    //   120: ifeq +42 -> 162
    //   123: aload 9
    //   125: astore 7
    //   127: aload 9
    //   129: astore 8
    //   131: aload 6
    //   133: astore_2
    //   134: aload 9
    //   136: astore_1
    //   137: aload 9
    //   139: iconst_0
    //   140: iload 5
    //   142: iconst_0
    //   143: invokestatic 771	android/graphics/BitmapRegionDecoder:newInstance	([BIIZ)Landroid/graphics/BitmapRegionDecoder;
    //   146: aload_0
    //   147: aload 12
    //   149: invokespecial 740	com/tencent/mobileqq/kandian/base/image/RunningJob:a	(Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Rect;
    //   152: aload 12
    //   154: invokevirtual 744	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   157: astore 10
    //   159: goto +29 -> 188
    //   162: aload 9
    //   164: astore 7
    //   166: aload 9
    //   168: astore 8
    //   170: aload 6
    //   172: astore_2
    //   173: aload 9
    //   175: astore_1
    //   176: aload 9
    //   178: iconst_0
    //   179: iload 5
    //   181: aload 12
    //   183: invokestatic 775	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   186: astore 10
    //   188: aload 9
    //   190: astore 7
    //   192: aload 9
    //   194: astore 8
    //   196: aload 6
    //   198: astore_2
    //   199: aload 9
    //   201: astore_1
    //   202: getstatic 753	com/tencent/mobileqq/kandian/base/image/NativeBitmap:jdField_a_of_type_Boolean	Z
    //   205: ifeq +22 -> 227
    //   208: aload 9
    //   210: astore 7
    //   212: aload 9
    //   214: astore 8
    //   216: aload 6
    //   218: astore_2
    //   219: aload 9
    //   221: astore_1
    //   222: aload 10
    //   224: invokestatic 778	com/tencent/mobileqq/kandian/base/image/NativeBitmap:nativePinBitmap	(Landroid/graphics/Bitmap;)V
    //   227: aload 9
    //   229: ifnull +17 -> 246
    //   232: aload_0
    //   233: getfield 77	com/tencent/mobileqq/kandian/base/image/RunningJob:jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiIBitmapCache	Lcom/tencent/mobileqq/kandian/base/image/api/IBitmapCache;
    //   236: invokeinterface 760 1 0
    //   241: aload 9
    //   243: invokevirtual 780	com/tencent/mobileqq/kandian/base/image/BytePool:a	([B)V
    //   246: aload_0
    //   247: getfield 77	com/tencent/mobileqq/kandian/base/image/RunningJob:jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiIBitmapCache	Lcom/tencent/mobileqq/kandian/base/image/api/IBitmapCache;
    //   250: aload 12
    //   252: getfield 283	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   255: invokeinterface 310 2 0
    //   260: aload 6
    //   262: invokevirtual 483	java/io/InputStream:close	()V
    //   265: aload 10
    //   267: areturn
    //   268: astore_1
    //   269: aload_1
    //   270: invokevirtual 783	java/io/IOException:printStackTrace	()V
    //   273: aload 10
    //   275: areturn
    //   276: astore_1
    //   277: aload 6
    //   279: astore_2
    //   280: aload_1
    //   281: astore 6
    //   283: aload 7
    //   285: astore_1
    //   286: goto +36 -> 322
    //   289: astore_1
    //   290: aload 6
    //   292: astore_2
    //   293: aload_1
    //   294: astore 6
    //   296: aload 8
    //   298: astore_1
    //   299: goto +26 -> 325
    //   302: astore_1
    //   303: aconst_null
    //   304: astore_2
    //   305: aload 8
    //   307: astore 6
    //   309: goto +27 -> 336
    //   312: astore 6
    //   314: aconst_null
    //   315: astore 7
    //   317: aload_2
    //   318: astore_1
    //   319: aload 7
    //   321: astore_2
    //   322: aload 6
    //   324: athrow
    //   325: aload 6
    //   327: athrow
    //   328: astore 7
    //   330: aload_1
    //   331: astore 6
    //   333: aload 7
    //   335: astore_1
    //   336: aload 6
    //   338: ifnull +17 -> 355
    //   341: aload_0
    //   342: getfield 77	com/tencent/mobileqq/kandian/base/image/RunningJob:jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiIBitmapCache	Lcom/tencent/mobileqq/kandian/base/image/api/IBitmapCache;
    //   345: invokeinterface 760 1 0
    //   350: aload 6
    //   352: invokevirtual 780	com/tencent/mobileqq/kandian/base/image/BytePool:a	([B)V
    //   355: aload_0
    //   356: getfield 77	com/tencent/mobileqq/kandian/base/image/RunningJob:jdField_a_of_type_ComTencentMobileqqKandianBaseImageApiIBitmapCache	Lcom/tencent/mobileqq/kandian/base/image/api/IBitmapCache;
    //   359: aload 12
    //   361: getfield 283	android/graphics/BitmapFactory$Options:inTempStorage	[B
    //   364: invokeinterface 310 2 0
    //   369: aload_2
    //   370: ifnull +15 -> 385
    //   373: aload_2
    //   374: invokevirtual 483	java/io/InputStream:close	()V
    //   377: goto +8 -> 385
    //   380: astore_2
    //   381: aload_2
    //   382: invokevirtual 783	java/io/IOException:printStackTrace	()V
    //   385: aload_1
    //   386: athrow
    //   387: astore 6
    //   389: aconst_null
    //   390: astore_2
    //   391: aload 7
    //   393: astore_1
    //   394: goto -69 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	RunningJob
    //   0	397	1	paramInputStream1	InputStream
    //   0	397	2	paramInputStream2	InputStream
    //   0	397	3	paramLong	long
    //   17	163	5	i	int
    //   44	264	6	localObject1	Object
    //   312	14	6	localException	Exception
    //   331	20	6	localInputStream	InputStream
    //   387	1	6	localOutOfMemoryError	OutOfMemoryError
    //   25	295	7	localObject2	Object
    //   328	64	7	localObject3	Object
    //   31	275	8	localObject4	Object
    //   28	214	9	arrayOfByte	byte[]
    //   20	254	10	localBitmap	Bitmap
    //   34	13	11	localObject5	Object
    //   5	355	12	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   260	265	268	java/io/IOException
    //   60	76	276	java/lang/Exception
    //   90	101	276	java/lang/Exception
    //   115	123	276	java/lang/Exception
    //   137	159	276	java/lang/Exception
    //   176	188	276	java/lang/Exception
    //   202	208	276	java/lang/Exception
    //   222	227	276	java/lang/Exception
    //   60	76	289	java/lang/OutOfMemoryError
    //   90	101	289	java/lang/OutOfMemoryError
    //   115	123	289	java/lang/OutOfMemoryError
    //   137	159	289	java/lang/OutOfMemoryError
    //   176	188	289	java/lang/OutOfMemoryError
    //   202	208	289	java/lang/OutOfMemoryError
    //   222	227	289	java/lang/OutOfMemoryError
    //   36	46	302	finally
    //   36	46	312	java/lang/Exception
    //   60	76	328	finally
    //   90	101	328	finally
    //   115	123	328	finally
    //   137	159	328	finally
    //   176	188	328	finally
    //   202	208	328	finally
    //   222	227	328	finally
    //   322	325	328	finally
    //   325	328	328	finally
    //   373	377	380	java/io/IOException
    //   36	46	387	java/lang/OutOfMemoryError
  }
  
  @TargetApi(12)
  public void run()
  {
    RIJImageOptReport.a(4, this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
    ImageManager.get().putExecuteJob(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[start request](");
    localStringBuilder.append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    localStringBuilder.append(")");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
    localStringBuilder.append(" createTs:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    QLog.d(str, 2, localStringBuilder.toString());
    if (b()) {
      return;
    }
    ImageManager.get().removeExecuteJob(this.jdField_a_of_type_ComTencentMobileqqKandianBaseImageImageRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.RunningJob
 * JD-Core Version:    0.7.0.1
 */