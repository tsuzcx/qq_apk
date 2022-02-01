package com.tencent.mobileqq.shortvideo.mediadevice;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.text.TextUtils;
import com.tencent.maxvideo.common.GlobalInit;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.utils.ThumbnailUtils;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.cover.RecordThumbnailUtils;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.utils.IQzoneVideoHelper;
import com.tencent.video.decode.ShortVideoSoLoad;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.AlbumLibDownloaderUtil;
import cooperation.qzone.util.GifCoder;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class GifProcessor
{
  public static final int ERROR_CODE_FORMAT_NOT_SUPPORT = -111;
  public static final int ERROR_CODE_GET_FRAME_INIT_FAILED = -112;
  public static final int ERROR_CODE_SO_NOT_LOADED = -110;
  private static final String TAG = "GifProcessor";
  private static int gifFirstNSecond;
  private static int gifFps;
  private static int gifMaxFrame;
  private static int gifSize;
  private static int gifSizeForLongEdge;
  private static int gifTimePerFrame;
  private static boolean sIsSoLoaded;
  
  private static int convertByFFmpeg(String paramString1, String paramString2)
  {
    if (!loadSo()) {
      return -110;
    }
    loadConfig();
    String str1 = String.format("fps=%d", new Object[] { Integer.valueOf(gifFps) });
    Object localObject1 = null;
    try
    {
      String str2 = TrimNative.getRealProperties(paramString1, gifSize, gifSizeForLongEdge);
      localObject1 = str2;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GifProcessor", 1, "getRealProperties error:", localThrowable);
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return -11;
    }
    localObject1 = ((String)localObject1).split(",");
    if ((localObject1.length >= 4) && (localObject1[0].equals("0")))
    {
      int i = Integer.valueOf(localObject1[3]).intValue();
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            localObject1 = str1;
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(str1);
            ((StringBuilder)localObject1).append(",transpose=2");
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str1);
          ((StringBuilder)localObject1).append(",vflip,hflip");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str1);
        ((StringBuilder)localObject1).append(",transpose=1");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      str1 = new File(paramString2).getParent();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("tempPics");
      str1 = ((StringBuilder)localObject2).toString();
      localObject2 = new File(str1);
      if (((File)localObject2).exists()) {
        if (((File)localObject2).isDirectory()) {
          FileUtils.deleteDirectory(str1);
        } else {
          ((File)localObject2).delete();
        }
      }
      ((File)localObject2).mkdir();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(str1);
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append("%03d.jpg");
      localObject3 = ((StringBuilder)localObject3).toString();
      long l1 = System.currentTimeMillis();
      int j = ((IQzoneVideoHelper)QRoute.api(IQzoneVideoHelper.class)).trimByFFmpeg(new String[] { "-i", paramString1, "-vf", localObject1, "-y", localObject3 });
      long l2 = System.currentTimeMillis();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("convertVideoToGifForRecord generate temp pics input=");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" output=");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(" cost=");
      ((StringBuilder)localObject1).append(l2 - l1);
      ((StringBuilder)localObject1).append(" ret=");
      ((StringBuilder)localObject1).append(j);
      QLog.i("GifProcessor", 1, ((StringBuilder)localObject1).toString());
      i = j;
      if (j == 0)
      {
        localObject2 = ((File)localObject2).listFiles();
        if ((localObject2 != null) && (localObject2.length != 0))
        {
          localObject1 = new ArrayList();
          int k = localObject2.length;
          i = 0;
          while (i < k)
          {
            ((ArrayList)localObject1).add(localObject2[i].getAbsolutePath());
            i += 1;
          }
          localObject2 = new GifCoder();
          ((GifCoder)localObject2).setEncoderDither(true);
          ((GifCoder)localObject2).setEncoderGifSize(gifSize);
          boolean bool;
          if (gifSizeForLongEdge == 1) {
            bool = true;
          } else {
            bool = false;
          }
          ((GifCoder)localObject2).setEncoderGifPicSizeForLongEdge(bool);
          i = j;
          if (!((GifCoder)localObject2).encodeGif(paramString2, (ArrayList)localObject1, gifTimePerFrame, true)) {
            i = -234;
          }
          ((GifCoder)localObject2).closeEncoder();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("convertVideoToGifForRecord generate gif input=");
          ((StringBuilder)localObject1).append(paramString1);
          ((StringBuilder)localObject1).append(" output=");
          ((StringBuilder)localObject1).append(paramString2);
          ((StringBuilder)localObject1).append(" cost=");
          ((StringBuilder)localObject1).append(System.currentTimeMillis() - l2);
          ((StringBuilder)localObject1).append(" ret=");
          ((StringBuilder)localObject1).append(i);
          QLog.i("GifProcessor", 1, ((StringBuilder)localObject1).toString());
        }
        else
        {
          i = -233;
        }
      }
      FileUtils.deleteDirectory(str1);
      return i;
    }
    return -12;
  }
  
  private static int convertByFFmpegForLocal(String paramString1, String paramString2)
  {
    if (!loadSo()) {
      return -110;
    }
    loadConfig();
    String str1 = String.format("fps=%d", new Object[] { Integer.valueOf(gifFps) });
    Object localObject1 = null;
    try
    {
      String str2 = TrimNative.getRealProperties(paramString1, gifSize, gifSizeForLongEdge);
      localObject1 = str2;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GifProcessor", 1, "getRealProperties error:", localThrowable);
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return -11;
    }
    localObject1 = ((String)localObject1).split(",");
    if ((localObject1.length >= 4) && (localObject1[0].equals("0")))
    {
      int i = Integer.valueOf(localObject1[3]).intValue();
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            localObject1 = str1;
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(str1);
            ((StringBuilder)localObject1).append(",transpose=2");
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(str1);
          ((StringBuilder)localObject1).append(",vflip,hflip");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(str1);
        ((StringBuilder)localObject1).append(",transpose=1");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      str1 = new File(paramString2).getParent();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append("tempPics");
      str1 = ((StringBuilder)localObject2).toString();
      localObject2 = new File(str1);
      if (((File)localObject2).exists()) {
        if (((File)localObject2).isDirectory()) {
          FileUtils.deleteDirectory(str1);
        } else {
          ((File)localObject2).delete();
        }
      }
      ((File)localObject2).mkdir();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(str1);
      ((StringBuilder)localObject3).append(File.separator);
      ((StringBuilder)localObject3).append("%03d.jpg");
      localObject3 = ((StringBuilder)localObject3).toString();
      i = gifFirstNSecond;
      long l1 = System.currentTimeMillis();
      int j = ((IQzoneVideoHelper)QRoute.api(IQzoneVideoHelper.class)).trimByFFmpeg(new String[] { "-i", paramString1, "-t", String.valueOf(i), "-vf", localObject1, "-y", localObject3 });
      long l2 = System.currentTimeMillis();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("convertVideoToGifForRecord generate temp pics input=");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" output=");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(" cost=");
      ((StringBuilder)localObject1).append(l2 - l1);
      ((StringBuilder)localObject1).append(" ret=");
      ((StringBuilder)localObject1).append(j);
      QLog.i("GifProcessor", 1, ((StringBuilder)localObject1).toString());
      i = j;
      if (j == 0)
      {
        localObject2 = ((File)localObject2).listFiles();
        if ((localObject2 != null) && (localObject2.length != 0))
        {
          localObject1 = new ArrayList();
          int k = localObject2.length;
          i = 0;
          while (i < k)
          {
            ((ArrayList)localObject1).add(localObject2[i].getAbsolutePath());
            i += 1;
          }
          localObject2 = new GifCoder();
          ((GifCoder)localObject2).setEncoderDither(true);
          ((GifCoder)localObject2).setEncoderGifSize(gifSize);
          boolean bool;
          if (gifSizeForLongEdge == 1) {
            bool = true;
          } else {
            bool = false;
          }
          ((GifCoder)localObject2).setEncoderGifPicSizeForLongEdge(bool);
          i = j;
          if (!((GifCoder)localObject2).encodeGif(paramString2, (ArrayList)localObject1, gifTimePerFrame, true)) {
            i = -234;
          }
          ((GifCoder)localObject2).closeEncoder();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("convertVideoToGifForRecord generate gif input=");
          ((StringBuilder)localObject1).append(paramString1);
          ((StringBuilder)localObject1).append(" output=");
          ((StringBuilder)localObject1).append(paramString2);
          ((StringBuilder)localObject1).append(" cost=");
          ((StringBuilder)localObject1).append(System.currentTimeMillis() - l2);
          ((StringBuilder)localObject1).append(" ret=");
          ((StringBuilder)localObject1).append(i);
          QLog.i("GifProcessor", 1, ((StringBuilder)localObject1).toString());
        }
        else
        {
          i = -233;
        }
      }
      FileUtils.deleteDirectory(str1);
      return i;
    }
    return -12;
  }
  
  private static int convertByFrameFatcher(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2, int paramInt3, int paramInt4, int paramInt5)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("convertByFrameFatcher input=");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(" width=");
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append(" height=");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(" duration=");
    ((StringBuilder)localObject1).append(paramLong);
    ((StringBuilder)localObject1).append(" output=");
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append(", gifFps=");
    ((StringBuilder)localObject1).append(paramInt3);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = "GifProcessor";
    QLog.i("GifProcessor", 1, (String)localObject1);
    if (!loadSo()) {
      return -110;
    }
    loadConfig();
    localObject1 = null;
    try
    {
      String str1 = TrimNative.getRealProperties(paramString1, gifSize, gifSizeForLongEdge);
      localObject1 = str1;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("GifProcessor", 1, "getRealProperties error:", localThrowable);
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return -11;
    }
    localObject1 = ((String)localObject1).split(",");
    if ((localObject1.length >= 4) && (localObject1[0].equals("0")))
    {
      int i = Integer.valueOf(localObject1[3]).intValue();
      paramInt1 = Integer.valueOf(localObject1[1]).intValue();
      paramInt2 = Integer.valueOf(localObject1[2]).intValue();
      if ((i != 1) && (i != 3))
      {
        i = paramInt1;
      }
      else
      {
        i = paramInt2;
        paramInt2 = paramInt1;
      }
      ThumbnailUtils.a(paramString1, i, paramInt2, 0, 0, i, paramInt2);
      paramInt1 = gifFirstNSecond;
      long l1;
      if (paramLong > paramInt1 * 1000) {
        l1 = paramInt1 * 1000;
      } else {
        l1 = paramLong;
      }
      GifCoder localGifCoder = new GifCoder();
      localGifCoder.setUseOrignalBitmap(true);
      long l3 = 1000L / paramInt3;
      long l4 = l1 / paramInt4;
      long l2 = l4;
      if (l3 > l4) {
        l2 = l3;
      }
      paramString1 = new File(paramString2).getParent();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(File.separator);
      ((StringBuilder)localObject1).append("tempPics");
      String str2 = ((StringBuilder)localObject1).toString();
      paramString1 = new File(str2);
      if (paramString1.exists()) {
        if (paramString1.isDirectory()) {
          FileUtils.deleteDirectory(str2);
        } else {
          paramString1.delete();
        }
      }
      paramString1.mkdir();
      ArrayList localArrayList = new ArrayList();
      l3 = 0L;
      paramString1 = (String)localObject2;
      while (l3 <= l1)
      {
        long l5 = System.currentTimeMillis();
        l4 = l3 + l2;
        if (l4 >= l1) {
          break;
        }
        localObject1 = ThumbnailUtils.b(l3, l4);
        long l6 = System.currentTimeMillis();
        if (localObject1 != null) {
          try
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(str2);
            try
            {
              ((StringBuilder)localObject2).append(File.separator);
              ((StringBuilder)localObject2).append(l3);
              ((StringBuilder)localObject2).append(".jpg");
              ImageUtil.a((Bitmap)localObject1, new File(((StringBuilder)localObject2).toString()));
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(str2);
              ((StringBuilder)localObject1).append(File.separator);
              ((StringBuilder)localObject1).append(l3);
              ((StringBuilder)localObject1).append(".jpg");
              localArrayList.add(((StringBuilder)localObject1).toString());
            }
            catch (IOException localIOException1) {}
            localIOException2.printStackTrace();
          }
          catch (IOException localIOException2) {}
        }
        long l7 = System.currentTimeMillis();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("convertByFrameFatcher currentTime=");
          localStringBuilder.append(l3);
          localStringBuilder.append(" duration=");
          localStringBuilder.append(paramLong);
          localStringBuilder.append(" retrieve frame cost=");
          localStringBuilder.append(l6 - l5);
          localStringBuilder.append(" encode frame cost=");
          localStringBuilder.append(l7 - l6);
          QLog.d(paramString1, 2, localStringBuilder.toString());
        }
        l3 = l4;
      }
      localGifCoder.encodeGif(paramString2, localArrayList, paramInt5, true);
      localGifCoder.closeEncoder();
      FileUtils.deleteDirectory(str2);
      return 0;
    }
    return -12;
  }
  
  /* Error */
  @android.annotation.TargetApi(10)
  private static int convertByRetriever(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 100	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   7: astore 15
    //   9: aload 15
    //   11: ldc_w 292
    //   14: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 15
    //   20: aload_0
    //   21: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 15
    //   27: ldc 175
    //   29: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 15
    //   35: aload_1
    //   36: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: ldc 15
    //   42: iconst_1
    //   43: aload 15
    //   45: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 189	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/GifProcessor:loadConfig	()V
    //   54: new 294	android/media/MediaMetadataRetriever
    //   57: dup
    //   58: invokespecial 295	android/media/MediaMetadataRetriever:<init>	()V
    //   61: astore 15
    //   63: aload 15
    //   65: aload_0
    //   66: invokevirtual 298	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   69: aload 15
    //   71: bipush 9
    //   73: invokevirtual 301	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   76: invokestatic 306	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   79: invokevirtual 309	java/lang/Long:longValue	()J
    //   82: lstore_2
    //   83: lload_2
    //   84: lstore 4
    //   86: lload_2
    //   87: getstatic 230	com/tencent/mobileqq/shortvideo/mediadevice/GifProcessor:gifFirstNSecond	I
    //   90: sipush 1000
    //   93: imul
    //   94: i2l
    //   95: lcmp
    //   96: ifle +13 -> 109
    //   99: getstatic 230	com/tencent/mobileqq/shortvideo/mediadevice/GifProcessor:gifFirstNSecond	I
    //   102: sipush 1000
    //   105: imul
    //   106: i2l
    //   107: lstore 4
    //   109: new 204	cooperation/qzone/util/GifCoder
    //   112: dup
    //   113: invokespecial 205	cooperation/qzone/util/GifCoder:<init>	()V
    //   116: astore_0
    //   117: aload_0
    //   118: iconst_1
    //   119: invokevirtual 209	cooperation/qzone/util/GifCoder:setEncoderDither	(Z)V
    //   122: aload_0
    //   123: getstatic 57	com/tencent/mobileqq/shortvideo/mediadevice/GifProcessor:gifSize	I
    //   126: invokevirtual 213	cooperation/qzone/util/GifCoder:setEncoderGifSize	(I)V
    //   129: getstatic 59	com/tencent/mobileqq/shortvideo/mediadevice/GifProcessor:gifSizeForLongEdge	I
    //   132: iconst_1
    //   133: if_icmpne +262 -> 395
    //   136: iconst_1
    //   137: istore 14
    //   139: goto +3 -> 142
    //   142: aload_0
    //   143: iload 14
    //   145: invokevirtual 216	cooperation/qzone/util/GifCoder:setEncoderGifPicSizeForLongEdge	(Z)V
    //   148: ldc2_w 259
    //   151: getstatic 43	com/tencent/mobileqq/shortvideo/mediadevice/GifProcessor:gifFps	I
    //   154: i2l
    //   155: ldiv
    //   156: lstore 6
    //   158: lload 4
    //   160: getstatic 311	com/tencent/mobileqq/shortvideo/mediadevice/GifProcessor:gifMaxFrame	I
    //   163: i2l
    //   164: ldiv
    //   165: lstore 8
    //   167: lload 8
    //   169: lstore_2
    //   170: lload 6
    //   172: lload 8
    //   174: lcmp
    //   175: ifle +226 -> 401
    //   178: lload 6
    //   180: lstore_2
    //   181: goto +220 -> 401
    //   184: lload 6
    //   186: lload 4
    //   188: lcmp
    //   189: ifgt +158 -> 347
    //   192: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   195: lstore 8
    //   197: aload 15
    //   199: lload 6
    //   201: ldc2_w 259
    //   204: lmul
    //   205: iconst_3
    //   206: invokevirtual 315	android/media/MediaMetadataRetriever:getFrameAtTime	(JI)Landroid/graphics/Bitmap;
    //   209: astore 16
    //   211: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   214: lstore 10
    //   216: aload 16
    //   218: ifnull +22 -> 240
    //   221: aload_0
    //   222: aload 16
    //   224: getstatic 321	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   227: iconst_1
    //   228: invokevirtual 327	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   231: aload_1
    //   232: getstatic 218	com/tencent/mobileqq/shortvideo/mediadevice/GifProcessor:gifTimePerFrame	I
    //   235: iconst_1
    //   236: invokevirtual 330	cooperation/qzone/util/GifCoder:encodeGif	(Landroid/graphics/Bitmap;Ljava/lang/String;IZ)Z
    //   239: pop
    //   240: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   243: lstore 12
    //   245: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq +159 -> 407
    //   251: new 100	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   258: astore 16
    //   260: aload 16
    //   262: ldc_w 332
    //   265: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 16
    //   271: lload 6
    //   273: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload 16
    //   279: ldc 247
    //   281: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload 16
    //   287: lload 4
    //   289: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 16
    //   295: ldc_w 281
    //   298: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload 16
    //   304: lload 10
    //   306: lload 8
    //   308: lsub
    //   309: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload 16
    //   315: ldc_w 283
    //   318: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload 16
    //   324: lload 12
    //   326: lload 10
    //   328: lsub
    //   329: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   332: pop
    //   333: ldc 15
    //   335: iconst_2
    //   336: aload 16
    //   338: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokestatic 286	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   344: goto +63 -> 407
    //   347: aload_0
    //   348: invokevirtual 225	cooperation/qzone/util/GifCoder:closeEncoder	()V
    //   351: aload 15
    //   353: invokevirtual 335	android/media/MediaMetadataRetriever:release	()V
    //   356: iconst_0
    //   357: ireturn
    //   358: astore_0
    //   359: goto +23 -> 382
    //   362: astore_0
    //   363: ldc 15
    //   365: iconst_1
    //   366: ldc_w 337
    //   369: aload_0
    //   370: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   373: aload 15
    //   375: invokevirtual 335	android/media/MediaMetadataRetriever:release	()V
    //   378: sipush -501
    //   381: ireturn
    //   382: aload 15
    //   384: invokevirtual 335	android/media/MediaMetadataRetriever:release	()V
    //   387: goto +5 -> 392
    //   390: aload_0
    //   391: athrow
    //   392: goto -2 -> 390
    //   395: iconst_0
    //   396: istore 14
    //   398: goto -256 -> 142
    //   401: lconst_0
    //   402: lstore 6
    //   404: goto -220 -> 184
    //   407: lload 6
    //   409: lload_2
    //   410: ladd
    //   411: lstore 6
    //   413: goto -229 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	416	0	paramString1	String
    //   0	416	1	paramString2	String
    //   82	328	2	l1	long
    //   84	204	4	l2	long
    //   156	256	6	l3	long
    //   165	142	8	l4	long
    //   214	113	10	l5	long
    //   243	82	12	l6	long
    //   137	260	14	bool	boolean
    //   7	376	15	localObject1	Object
    //   209	128	16	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   63	83	358	finally
    //   86	109	358	finally
    //   109	136	358	finally
    //   142	167	358	finally
    //   192	216	358	finally
    //   221	240	358	finally
    //   240	344	358	finally
    //   347	351	358	finally
    //   363	373	358	finally
    //   63	83	362	java/lang/Throwable
    //   86	109	362	java/lang/Throwable
    //   109	136	362	java/lang/Throwable
    //   142	167	362	java/lang/Throwable
    //   192	216	362	java/lang/Throwable
    //   221	240	362	java/lang/Throwable
    //   240	344	362	java/lang/Throwable
    //   347	351	362	java/lang/Throwable
  }
  
  public static int convertVideoToGifForLocal(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    loadConfig();
    return convertVideoToGifForLocal(paramString1, paramInt1, paramInt2, paramLong, paramString2, gifFps, gifMaxFrame, gifTimePerFrame);
  }
  
  public static int convertVideoToGifForLocal(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2, int paramInt3, int paramInt4, int paramInt5)
  {
    return convertByFrameFatcher(paramString1, paramInt1, paramInt2, paramLong, paramString2, paramInt3, paramInt4, paramInt5);
  }
  
  public static int convertVideoToGifForRecord(String paramString1, String paramString2)
  {
    return convertByFFmpeg(paramString1, paramString2);
  }
  
  public static int generateGifFromVFile(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("generateGifFromVFile vfPath=");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" output=");
    ((StringBuilder)localObject).append(paramString3);
    QLog.i("GifProcessor", 1, ((StringBuilder)localObject).toString());
    loadConfig();
    localObject = new GifCoder();
    ((GifCoder)localObject).setEncoderDither(true);
    ((GifCoder)localObject).setEncoderGifSize(gifSize);
    int i = gifSizeForLongEdge;
    int k = 0;
    boolean bool;
    if (i == 1) {
      bool = true;
    } else {
      bool = false;
    }
    ((GifCoder)localObject).setEncoderGifPicSizeForLongEdge(bool);
    i = CodecParam.mRecordFrames * 1000 / CodecParam.mRecordTime / gifFps;
    int j = i;
    if (i <= 0) {
      j = 1;
    }
    VideoSourceHelper localVideoSourceHelper = new VideoSourceHelper(paramString1, paramString2);
    localVideoSourceHelper.initHelperParam();
    paramString1 = localVideoSourceHelper.getSourceVideoParam();
    Bitmap localBitmap = Bitmap.createBitmap(paramString1[0], paramString1[1], Bitmap.Config.RGB_565);
    i = 0;
    while (k < CodecParam.mRecordFrames)
    {
      i = localVideoSourceHelper.getVideoFrameByIndex(localBitmap, k);
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("getVideoFrameByIndex from vffile. index=");
        paramString1.append(k);
        paramString1.append(" ret=");
        paramString1.append(i);
        QLog.d("GifProcessor", 2, paramString1.toString());
      }
      if (i != 0) {
        break;
      }
      paramString2 = localBitmap.copy(Bitmap.Config.ARGB_8888, true);
      paramString1 = paramString2;
      if (paramInt != 0)
      {
        paramString1 = paramString2;
        if (!RecordThumbnailUtils.a(paramInt)) {
          paramString1 = RecordThumbnailUtils.a(paramString2, paramInt);
        }
      }
      if (!((GifCoder)localObject).encodeGif(paramString1, paramString3, gifTimePerFrame, true))
      {
        i = -1;
        break;
      }
      k += j;
    }
    ((GifCoder)localObject).closeEncoder();
    return i;
  }
  
  /* Error */
  public static int getFrameFromVideoByRetriever(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 100	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   7: astore 14
    //   9: aload 14
    //   11: ldc_w 395
    //   14: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 14
    //   20: aload_0
    //   21: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 14
    //   27: ldc 175
    //   29: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 14
    //   35: aload_1
    //   36: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 14
    //   42: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: astore 14
    //   47: ldc 15
    //   49: astore 15
    //   51: ldc 15
    //   53: iconst_1
    //   54: aload 14
    //   56: invokestatic 189	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/GifProcessor:loadConfig	()V
    //   62: new 294	android/media/MediaMetadataRetriever
    //   65: dup
    //   66: invokespecial 295	android/media/MediaMetadataRetriever:<init>	()V
    //   69: astore 16
    //   71: aload 15
    //   73: astore 14
    //   75: aload 16
    //   77: aload_0
    //   78: invokevirtual 298	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   81: aload 15
    //   83: astore 14
    //   85: aload 16
    //   87: bipush 9
    //   89: invokevirtual 301	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   92: invokestatic 306	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   95: invokevirtual 309	java/lang/Long:longValue	()J
    //   98: lstore 4
    //   100: lload 4
    //   102: lstore_2
    //   103: aload 15
    //   105: astore 14
    //   107: lload 4
    //   109: getstatic 230	com/tencent/mobileqq/shortvideo/mediadevice/GifProcessor:gifFirstNSecond	I
    //   112: sipush 1000
    //   115: imul
    //   116: i2l
    //   117: lcmp
    //   118: ifle +16 -> 134
    //   121: aload 15
    //   123: astore 14
    //   125: getstatic 230	com/tencent/mobileqq/shortvideo/mediadevice/GifProcessor:gifFirstNSecond	I
    //   128: sipush 1000
    //   131: imul
    //   132: i2l
    //   133: lstore_2
    //   134: lconst_0
    //   135: lstore 4
    //   137: aload 15
    //   139: astore 14
    //   141: ldc2_w 259
    //   144: getstatic 43	com/tencent/mobileqq/shortvideo/mediadevice/GifProcessor:gifFps	I
    //   147: i2l
    //   148: ldiv
    //   149: lstore 6
    //   151: aload 15
    //   153: astore 14
    //   155: lload_2
    //   156: getstatic 311	com/tencent/mobileqq/shortvideo/mediadevice/GifProcessor:gifMaxFrame	I
    //   159: i2l
    //   160: ldiv
    //   161: lstore 8
    //   163: lload 6
    //   165: lload 8
    //   167: lcmp
    //   168: ifle +296 -> 464
    //   171: aload 15
    //   173: astore_0
    //   174: goto +3 -> 177
    //   177: lload 4
    //   179: lload_2
    //   180: lcmp
    //   181: ifgt +237 -> 418
    //   184: aload_0
    //   185: astore 14
    //   187: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   190: lstore 8
    //   192: aload 16
    //   194: lload 4
    //   196: ldc2_w 259
    //   199: lmul
    //   200: iconst_3
    //   201: invokevirtual 315	android/media/MediaMetadataRetriever:getFrameAtTime	(JI)Landroid/graphics/Bitmap;
    //   204: astore 14
    //   206: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   209: lstore 10
    //   211: aload 14
    //   213: ifnull +74 -> 287
    //   216: aload 14
    //   218: getstatic 321	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   221: iconst_1
    //   222: invokevirtual 327	android/graphics/Bitmap:copy	(Landroid/graphics/Bitmap$Config;Z)Landroid/graphics/Bitmap;
    //   225: astore 14
    //   227: new 100	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   234: astore 15
    //   236: aload 15
    //   238: aload_1
    //   239: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload 15
    //   245: getstatic 126	java/io/File:separator	Ljava/lang/String;
    //   248: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload 15
    //   254: lload 4
    //   256: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload 15
    //   262: ldc_w 266
    //   265: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload 14
    //   271: new 117	java/io/File
    //   274: dup
    //   275: aload 15
    //   277: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokespecial 120	java/io/File:<init>	(Ljava/lang/String;)V
    //   283: invokestatic 271	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)Z
    //   286: pop
    //   287: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   290: lstore 12
    //   292: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   295: ifeq +109 -> 404
    //   298: new 100	java/lang/StringBuilder
    //   301: dup
    //   302: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   305: astore 14
    //   307: aload 14
    //   309: ldc_w 397
    //   312: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload 14
    //   318: lload 4
    //   320: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload 14
    //   326: ldc 247
    //   328: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload 14
    //   334: lload_2
    //   335: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload 14
    //   341: ldc_w 281
    //   344: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: pop
    //   348: aload 14
    //   350: lload 10
    //   352: lload 8
    //   354: lsub
    //   355: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload 14
    //   361: ldc_w 283
    //   364: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload 14
    //   370: lload 12
    //   372: lload 10
    //   374: lsub
    //   375: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload 14
    //   381: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: astore 17
    //   386: aload_0
    //   387: astore 15
    //   389: aload 15
    //   391: astore 14
    //   393: aload 15
    //   395: iconst_2
    //   396: aload 17
    //   398: invokestatic 286	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   401: goto +3 -> 404
    //   404: lload 4
    //   406: lload 6
    //   408: ladd
    //   409: lstore 4
    //   411: goto -234 -> 177
    //   414: astore_1
    //   415: goto +18 -> 433
    //   418: aload 16
    //   420: invokevirtual 335	android/media/MediaMetadataRetriever:release	()V
    //   423: iconst_0
    //   424: ireturn
    //   425: astore_0
    //   426: goto +25 -> 451
    //   429: astore_1
    //   430: aload 14
    //   432: astore_0
    //   433: aload_0
    //   434: iconst_1
    //   435: ldc_w 399
    //   438: aload_1
    //   439: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   442: aload 16
    //   444: invokevirtual 335	android/media/MediaMetadataRetriever:release	()V
    //   447: sipush -501
    //   450: ireturn
    //   451: aload 16
    //   453: invokevirtual 335	android/media/MediaMetadataRetriever:release	()V
    //   456: goto +5 -> 461
    //   459: aload_0
    //   460: athrow
    //   461: goto -2 -> 459
    //   464: lload 8
    //   466: lstore 6
    //   468: aload 15
    //   470: astore_0
    //   471: goto -294 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	474	0	paramString1	String
    //   0	474	1	paramString2	String
    //   102	233	2	l1	long
    //   98	312	4	l2	long
    //   149	318	6	l3	long
    //   161	304	8	l4	long
    //   209	164	10	l5	long
    //   290	81	12	l6	long
    //   7	424	14	localObject1	Object
    //   49	420	15	localObject2	Object
    //   69	383	16	localMediaMetadataRetriever	android.media.MediaMetadataRetriever
    //   384	13	17	str	String
    // Exception table:
    //   from	to	target	type
    //   192	211	414	java/lang/Throwable
    //   216	287	414	java/lang/Throwable
    //   287	386	414	java/lang/Throwable
    //   75	81	425	finally
    //   85	100	425	finally
    //   107	121	425	finally
    //   125	134	425	finally
    //   141	151	425	finally
    //   155	163	425	finally
    //   187	192	425	finally
    //   192	211	425	finally
    //   216	287	425	finally
    //   287	386	425	finally
    //   393	401	425	finally
    //   433	442	425	finally
    //   75	81	429	java/lang/Throwable
    //   85	100	429	java/lang/Throwable
    //   107	121	429	java/lang/Throwable
    //   125	134	429	java/lang/Throwable
    //   141	151	429	java/lang/Throwable
    //   155	163	429	java/lang/Throwable
    //   187	192	429	java/lang/Throwable
    //   393	401	429	java/lang/Throwable
  }
  
  /* Error */
  public static int getFramesFromVideo(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    // Byte code:
    //   0: new 100	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   7: astore 21
    //   9: aload 21
    //   11: ldc_w 402
    //   14: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 21
    //   20: aload_0
    //   21: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 21
    //   27: ldc 243
    //   29: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 21
    //   35: iload_1
    //   36: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 21
    //   42: ldc 245
    //   44: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 21
    //   50: iload_2
    //   51: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 21
    //   57: ldc 247
    //   59: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 21
    //   65: lload_3
    //   66: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload 21
    //   72: ldc 175
    //   74: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 21
    //   80: aload 5
    //   82: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: ldc 15
    //   88: iconst_1
    //   89: aload 21
    //   91: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 189	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: invokestatic 36	com/tencent/mobileqq/shortvideo/mediadevice/GifProcessor:loadSo	()Z
    //   100: ifne +6 -> 106
    //   103: bipush 146
    //   105: ireturn
    //   106: aload_0
    //   107: invokestatic 406	com/tencent/maxvideo/trim/TrimNative:detect	(Ljava/lang/String;)I
    //   110: ifeq +6 -> 116
    //   113: bipush 145
    //   115: ireturn
    //   116: invokestatic 39	com/tencent/mobileqq/shortvideo/mediadevice/GifProcessor:loadConfig	()V
    //   119: aconst_null
    //   120: astore 21
    //   122: aload_0
    //   123: getstatic 57	com/tencent/mobileqq/shortvideo/mediadevice/GifProcessor:gifSize	I
    //   126: getstatic 59	com/tencent/mobileqq/shortvideo/mediadevice/GifProcessor:gifSizeForLongEdge	I
    //   129: invokestatic 65	com/tencent/maxvideo/trim/TrimNative:getRealProperties	(Ljava/lang/String;II)Ljava/lang/String;
    //   132: astore 22
    //   134: aload 22
    //   136: astore 21
    //   138: goto +15 -> 153
    //   141: astore 22
    //   143: ldc 15
    //   145: iconst_1
    //   146: ldc 67
    //   148: aload 22
    //   150: invokestatic 73	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   153: aload 21
    //   155: invokestatic 79	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   158: ifeq +6 -> 164
    //   161: bipush 245
    //   163: ireturn
    //   164: aload 21
    //   166: ldc 81
    //   168: invokevirtual 85	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   171: astore 21
    //   173: aload 21
    //   175: arraylength
    //   176: iconst_4
    //   177: if_icmplt +442 -> 619
    //   180: aload 21
    //   182: iconst_0
    //   183: aaload
    //   184: ldc 87
    //   186: invokevirtual 91	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   189: ifne +6 -> 195
    //   192: goto +427 -> 619
    //   195: aload 21
    //   197: iconst_3
    //   198: aaload
    //   199: invokestatic 94	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   202: invokevirtual 98	java/lang/Integer:intValue	()I
    //   205: istore 6
    //   207: aload 21
    //   209: iconst_1
    //   210: aaload
    //   211: invokestatic 94	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   214: invokevirtual 98	java/lang/Integer:intValue	()I
    //   217: istore_1
    //   218: aload 21
    //   220: iconst_2
    //   221: aaload
    //   222: invokestatic 94	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   225: invokevirtual 98	java/lang/Integer:intValue	()I
    //   228: istore_2
    //   229: iload 6
    //   231: iconst_1
    //   232: if_icmpeq +18 -> 250
    //   235: iload 6
    //   237: iconst_3
    //   238: if_icmpne +6 -> 244
    //   241: goto +9 -> 250
    //   244: iload_2
    //   245: istore 6
    //   247: goto +8 -> 255
    //   250: iload_1
    //   251: istore 6
    //   253: iload_2
    //   254: istore_1
    //   255: aload_0
    //   256: iload_1
    //   257: iload 6
    //   259: iconst_0
    //   260: iconst_0
    //   261: iload_1
    //   262: iload 6
    //   264: invokestatic 255	com/tencent/mobileqq/activity/richmedia/trimvideo/video/utils/ThumbnailUtils:a	(Ljava/lang/String;IIIIII)I
    //   267: ifeq +6 -> 273
    //   270: bipush 144
    //   272: ireturn
    //   273: getstatic 230	com/tencent/mobileqq/shortvideo/mediadevice/GifProcessor:gifFirstNSecond	I
    //   276: istore_1
    //   277: lload_3
    //   278: iload_1
    //   279: sipush 1000
    //   282: imul
    //   283: i2l
    //   284: lcmp
    //   285: ifle +14 -> 299
    //   288: iload_1
    //   289: sipush 1000
    //   292: imul
    //   293: i2l
    //   294: lstore 7
    //   296: goto +6 -> 302
    //   299: lload_3
    //   300: lstore 7
    //   302: ldc2_w 259
    //   305: getstatic 43	com/tencent/mobileqq/shortvideo/mediadevice/GifProcessor:gifFps	I
    //   308: i2l
    //   309: ldiv
    //   310: lstore 11
    //   312: lload 7
    //   314: getstatic 311	com/tencent/mobileqq/shortvideo/mediadevice/GifProcessor:gifMaxFrame	I
    //   317: i2l
    //   318: ldiv
    //   319: lstore 13
    //   321: lload 13
    //   323: lstore 9
    //   325: lload 11
    //   327: lload 13
    //   329: lcmp
    //   330: ifle +7 -> 337
    //   333: lload 11
    //   335: lstore 9
    //   337: new 117	java/io/File
    //   340: dup
    //   341: aload 5
    //   343: invokespecial 120	java/io/File:<init>	(Ljava/lang/String;)V
    //   346: astore_0
    //   347: aload_0
    //   348: invokevirtual 131	java/io/File:exists	()Z
    //   351: ifeq +23 -> 374
    //   354: aload_0
    //   355: invokevirtual 134	java/io/File:isDirectory	()Z
    //   358: ifeq +11 -> 369
    //   361: aload 5
    //   363: invokestatic 139	com/tencent/mobileqq/utils/FileUtils:deleteDirectory	(Ljava/lang/String;)V
    //   366: goto +8 -> 374
    //   369: aload_0
    //   370: invokevirtual 142	java/io/File:delete	()Z
    //   373: pop
    //   374: aload_0
    //   375: invokevirtual 145	java/io/File:mkdir	()Z
    //   378: pop
    //   379: lconst_0
    //   380: lstore 11
    //   382: lload 11
    //   384: lload 7
    //   386: lcmp
    //   387: ifgt +230 -> 617
    //   390: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   393: lstore 17
    //   395: lload 11
    //   397: lload 9
    //   399: ladd
    //   400: lstore 13
    //   402: lload 13
    //   404: lload 7
    //   406: lcmp
    //   407: iflt +10 -> 417
    //   410: lload 7
    //   412: lstore 15
    //   414: goto +7 -> 421
    //   417: lload 13
    //   419: lstore 15
    //   421: lload 11
    //   423: lload 15
    //   425: invokestatic 264	com/tencent/mobileqq/activity/richmedia/trimvideo/video/utils/ThumbnailUtils:b	(JJ)Landroid/graphics/Bitmap;
    //   428: astore_0
    //   429: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   432: lstore 15
    //   434: aload_0
    //   435: ifnull +79 -> 514
    //   438: new 100	java/lang/StringBuilder
    //   441: dup
    //   442: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   445: astore 21
    //   447: aload 21
    //   449: aload 5
    //   451: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: pop
    //   455: aload 21
    //   457: getstatic 126	java/io/File:separator	Ljava/lang/String;
    //   460: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: pop
    //   464: aload 21
    //   466: lload 11
    //   468: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: aload 21
    //   474: ldc_w 266
    //   477: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: pop
    //   481: aload_0
    //   482: new 117	java/io/File
    //   485: dup
    //   486: aload 21
    //   488: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   491: invokespecial 120	java/io/File:<init>	(Ljava/lang/String;)V
    //   494: invokestatic 271	com/tencent/mobileqq/utils/ImageUtil:a	(Landroid/graphics/Bitmap;Ljava/io/File;)Z
    //   497: pop
    //   498: goto +16 -> 514
    //   501: astore_0
    //   502: goto +5 -> 507
    //   505: astore 21
    //   507: aload_0
    //   508: invokevirtual 274	java/io/IOException:printStackTrace	()V
    //   511: goto +3 -> 514
    //   514: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   517: lstore 19
    //   519: invokestatic 277	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   522: ifeq +88 -> 610
    //   525: new 100	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   532: astore_0
    //   533: aload_0
    //   534: ldc_w 408
    //   537: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload_0
    //   542: lload 11
    //   544: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   547: pop
    //   548: aload_0
    //   549: ldc 247
    //   551: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: aload_0
    //   556: lload_3
    //   557: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload_0
    //   562: ldc_w 281
    //   565: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: aload_0
    //   570: lload 15
    //   572: lload 17
    //   574: lsub
    //   575: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   578: pop
    //   579: aload_0
    //   580: ldc_w 283
    //   583: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: pop
    //   587: aload_0
    //   588: lload 19
    //   590: lload 15
    //   592: lsub
    //   593: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   596: pop
    //   597: ldc 15
    //   599: iconst_2
    //   600: aload_0
    //   601: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   604: invokestatic 286	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   607: goto +3 -> 610
    //   610: lload 13
    //   612: lstore 11
    //   614: goto -232 -> 382
    //   617: iconst_0
    //   618: ireturn
    //   619: bipush 244
    //   621: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	622	0	paramString1	String
    //   0	622	1	paramInt1	int
    //   0	622	2	paramInt2	int
    //   0	622	3	paramLong	long
    //   0	622	5	paramString2	String
    //   205	58	6	i	int
    //   294	117	7	l1	long
    //   323	75	9	l2	long
    //   310	157	11	l3	long
    //   319	99	13	l4	long
    //   412	21	15	l5	long
    //   393	1	17	l6	long
    //   7	480	21	localObject	Object
    //   132	3	22	str	String
    //   141	8	22	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   122	134	141	java/lang/Throwable
    //   438	498	501	java/io/IOException
  }
  
  private static void loadConfig()
  {
    gifSize = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoToGifSize", 720);
    gifSizeForLongEdge = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoToGifSizeForLongEdge", 0);
    gifFps = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoToGifFps", 5);
    gifTimePerFrame = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoToGifTimePerFrame", 200);
    gifMaxFrame = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoToGifMaxFrame", 10);
    gifFirstNSecond = QzoneConfig.getInstance().getConfig("MiniVideo", "VideoToGifFirstNSecond", 10);
  }
  
  private static boolean loadSo()
  {
    if (sIsSoLoaded) {
      return true;
    }
    try
    {
      String str2 = ShortVideoSoLoad.getShortVideoSoPath(BaseApplication.getContext());
      String str1 = VideoEnvironment.getShortVideoSoLibName();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(str1);
      str2 = ((StringBuilder)localObject).toString();
      localObject = new File(str2);
      if (str1 != null)
      {
        if (!((File)localObject).exists()) {
          return false;
        }
        GlobalInit.loadLibraryWithFullPath(str2);
        sIsSoLoaded = true;
        return true;
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      QLog.w("GifProcessor", 1, "loadLibrary error", localThrowable);
    }
    return false;
  }
  
  private static boolean tryToLoadGifEncoderSo()
  {
    boolean[] arrayOfBoolean = new boolean[1];
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    AlbumLibDownloaderUtil.getInstance().downloadGifEncoderSo(new GifProcessor.1(arrayOfBoolean, localCountDownLatch));
    try
    {
      arrayOfBoolean[0] = localCountDownLatch.await(30L, TimeUnit.SECONDS);
    }
    catch (InterruptedException localInterruptedException)
    {
      label44:
      break label44;
    }
    arrayOfBoolean[0] = false;
    return arrayOfBoolean[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.GifProcessor
 * JD-Core Version:    0.7.0.1
 */