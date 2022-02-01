package com.tencent.mobileqq.shortvideo.mediadevice;

import akwa;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import bfvo;
import com.tencent.maxvideo.common.GlobalInit;
import com.tencent.maxvideo.trim.TrimNative;
import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.cover.RecordThumbnailUtils;
import com.tencent.mobileqq.shortvideo.hwcodec.VideoSourceHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.ShortVideoSoLoad;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.AlbumLibDownloaderUtil;
import cooperation.qzone.util.GifCoder;
import cooperation.qzone.video.QZoneVideoCompressor;
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
      for (;;)
      {
        QLog.e("GifProcessor", 1, "getRealProperties error:", localThrowable);
      }
      localObject1 = ((String)localObject1).split(",");
      if ((localObject1.length >= 4) && (localObject1[0].equals("0"))) {
        break label108;
      }
      return -12;
      switch (Integer.valueOf(localObject1[3]).intValue())
      {
      default: 
        localObject1 = str1;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return -11;
    }
    label108:
    str1 = new File(paramString2).getParent();
    str1 = str1 + File.separator + "tempPics";
    Object localObject2 = new File(str1);
    label221:
    int i;
    long l2;
    if (((File)localObject2).exists())
    {
      if (((File)localObject2).isDirectory()) {
        FileUtils.deleteDirectory(str1);
      }
    }
    else
    {
      ((File)localObject2).mkdir();
      String str3 = str1 + File.separator + "%03d.jpg";
      long l1 = System.currentTimeMillis();
      i = QZoneVideoCompressor.trimByFFmpeg(new String[] { "-i", paramString1, "-vf", localObject1, "-y", str3 });
      l2 = System.currentTimeMillis();
      QLog.i("GifProcessor", 1, "convertVideoToGifForRecord generate temp pics input=" + paramString1 + " output=" + paramString2 + " cost=" + (l2 - l1) + " ret=" + i);
      if (i != 0) {
        break label651;
      }
      localObject2 = ((File)localObject2).listFiles();
      if ((localObject2 != null) && (localObject2.length != 0)) {
        break label476;
      }
      i = -233;
    }
    label648:
    label651:
    for (;;)
    {
      FileUtils.deleteDirectory(str1);
      return i;
      localObject1 = str1 + ",transpose=1";
      break;
      localObject1 = str1 + ",vflip,hflip";
      break;
      localObject1 = str1 + ",transpose=2";
      break;
      ((File)localObject2).delete();
      break label221;
      label476:
      localObject1 = new ArrayList();
      int k = localObject2.length;
      int j = 0;
      while (j < k)
      {
        ((ArrayList)localObject1).add(localObject2[j].getAbsolutePath());
        j += 1;
      }
      localObject2 = new GifCoder();
      ((GifCoder)localObject2).setEncoderDither(true);
      ((GifCoder)localObject2).setEncoderGifSize(gifSize);
      boolean bool;
      if (gifSizeForLongEdge == 1)
      {
        bool = true;
        label551:
        ((GifCoder)localObject2).setEncoderGifPicSizeForLongEdge(bool);
        if (((GifCoder)localObject2).encodeGif(paramString2, (ArrayList)localObject1, gifTimePerFrame, true)) {
          break label648;
        }
        i = -234;
      }
      for (;;)
      {
        ((GifCoder)localObject2).closeEncoder();
        QLog.i("GifProcessor", 1, "convertVideoToGifForRecord generate gif input=" + paramString1 + " output=" + paramString2 + " cost=" + (System.currentTimeMillis() - l2) + " ret=" + i);
        break;
        bool = false;
        break label551;
      }
    }
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
      for (;;)
      {
        QLog.e("GifProcessor", 1, "getRealProperties error:", localThrowable);
      }
      localObject1 = ((String)localObject1).split(",");
      if ((localObject1.length >= 4) && (localObject1[0].equals("0"))) {
        break label108;
      }
      return -12;
      switch (Integer.valueOf(localObject1[3]).intValue())
      {
      default: 
        localObject1 = str1;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return -11;
    }
    label108:
    str1 = new File(paramString2).getParent();
    str1 = str1 + File.separator + "tempPics";
    Object localObject2 = new File(str1);
    label221:
    int i;
    long l2;
    if (((File)localObject2).exists())
    {
      if (((File)localObject2).isDirectory()) {
        FileUtils.deleteDirectory(str1);
      }
    }
    else
    {
      ((File)localObject2).mkdir();
      String str3 = str1 + File.separator + "%03d.jpg";
      i = gifFirstNSecond;
      long l1 = System.currentTimeMillis();
      i = QZoneVideoCompressor.trimByFFmpeg(new String[] { "-i", paramString1, "-t", String.valueOf(i), "-vf", localObject1, "-y", str3 });
      l2 = System.currentTimeMillis();
      QLog.i("GifProcessor", 1, "convertVideoToGifForRecord generate temp pics input=" + paramString1 + " output=" + paramString2 + " cost=" + (l2 - l1) + " ret=" + i);
      if (i != 0) {
        break label669;
      }
      localObject2 = ((File)localObject2).listFiles();
      if ((localObject2 != null) && (localObject2.length != 0)) {
        break label494;
      }
      i = -233;
    }
    label666:
    label669:
    for (;;)
    {
      FileUtils.deleteDirectory(str1);
      return i;
      localObject1 = str1 + ",transpose=1";
      break;
      localObject1 = str1 + ",vflip,hflip";
      break;
      localObject1 = str1 + ",transpose=2";
      break;
      ((File)localObject2).delete();
      break label221;
      label494:
      localObject1 = new ArrayList();
      int k = localObject2.length;
      int j = 0;
      while (j < k)
      {
        ((ArrayList)localObject1).add(localObject2[j].getAbsolutePath());
        j += 1;
      }
      localObject2 = new GifCoder();
      ((GifCoder)localObject2).setEncoderDither(true);
      ((GifCoder)localObject2).setEncoderGifSize(gifSize);
      boolean bool;
      if (gifSizeForLongEdge == 1)
      {
        bool = true;
        label569:
        ((GifCoder)localObject2).setEncoderGifPicSizeForLongEdge(bool);
        if (((GifCoder)localObject2).encodeGif(paramString2, (ArrayList)localObject1, gifTimePerFrame, true)) {
          break label666;
        }
        i = -234;
      }
      for (;;)
      {
        ((GifCoder)localObject2).closeEncoder();
        QLog.i("GifProcessor", 1, "convertVideoToGifForRecord generate gif input=" + paramString1 + " output=" + paramString2 + " cost=" + (System.currentTimeMillis() - l2) + " ret=" + i);
        break;
        bool = false;
        break label569;
      }
    }
  }
  
  private static int convertByFrameFatcher(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2, int paramInt3, int paramInt4, int paramInt5)
  {
    QLog.i("GifProcessor", 1, "convertByFrameFatcher input=" + paramString1 + " width=" + paramInt1 + " height=" + paramInt2 + " duration=" + paramLong + " output=" + paramString2 + ", gifFps=" + paramInt3);
    if (!loadSo()) {
      return -110;
    }
    loadConfig();
    Object localObject1 = null;
    try
    {
      String str = TrimNative.getRealProperties(paramString1, gifSize, gifSizeForLongEdge);
      localObject1 = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("GifProcessor", 1, "getRealProperties error:", localThrowable);
      }
      localObject1 = ((String)localObject1).split(",");
      if ((localObject1.length >= 4) && (localObject1[0].equals("0"))) {
        break label160;
      }
      return -12;
      label160:
      i = Integer.valueOf(localObject1[3]).intValue();
      paramInt2 = Integer.valueOf(localObject1[1]).intValue();
      paramInt1 = Integer.valueOf(localObject1[2]).intValue();
      if (i == 1) {
        break label206;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return -11;
    }
    int i;
    if (i == 3)
    {
      label206:
      i = paramInt2;
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      akwa.a(paramString1, paramInt2, i, 0, 0, paramInt2, i);
      long l1;
      long l3;
      long l2;
      long l4;
      label288:
      Object localObject2;
      if (paramLong > gifFirstNSecond * 1000)
      {
        l1 = gifFirstNSecond * 1000;
        paramString1 = new GifCoder();
        paramString1.setUseOrignalBitmap(true);
        l3 = 0L;
        l2 = 1000L / paramInt3;
        l4 = l1 / paramInt4;
        if (l2 <= l4) {
          break label434;
        }
        localObject1 = new File(paramString2).getParent();
        localObject1 = (String)localObject1 + File.separator + "tempPics";
        localObject2 = new File((String)localObject1);
        if (((File)localObject2).exists())
        {
          if (!((File)localObject2).isDirectory()) {
            break label441;
          }
          FileUtils.deleteDirectory((String)localObject1);
        }
        label362:
        ((File)localObject2).mkdir();
        localObject2 = new ArrayList();
      }
      for (;;)
      {
        if (l3 <= l1)
        {
          l4 = System.currentTimeMillis();
          l5 = l3 + l2;
          if (l5 < l1) {}
        }
        else
        {
          paramString1.encodeGif(paramString2, (ArrayList)localObject2, paramInt5, true);
          paramString1.closeEncoder();
          FileUtils.deleteDirectory((String)localObject1);
          return 0;
          l1 = paramLong;
          break;
          label434:
          l2 = l4;
          break label288;
          label441:
          ((File)localObject2).delete();
          break label362;
        }
        Bitmap localBitmap = akwa.b(l3, l5);
        long l5 = System.currentTimeMillis();
        if (localBitmap != null) {}
        try
        {
          bfvo.a(localBitmap, new File((String)localObject1 + File.separator + l3 + ".jpg"));
          ((ArrayList)localObject2).add((String)localObject1 + File.separator + l3 + ".jpg");
          long l6 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("GifProcessor", 2, "convertByFrameFatcher currentTime=" + l3 + " duration=" + paramLong + " retrieve frame cost=" + (l5 - l4) + " encode frame cost=" + (l6 - l5));
          }
          l3 += l2;
        }
        catch (IOException localIOException)
        {
          for (;;)
          {
            localIOException.printStackTrace();
          }
        }
      }
      i = paramInt1;
    }
  }
  
  @TargetApi(10)
  private static int convertByRetriever(String paramString1, String paramString2)
  {
    QLog.i("GifProcessor", 1, "convertByRetriever input=" + paramString1 + " output=" + paramString2);
    loadConfig();
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    boolean bool;
    long l2;
    long l3;
    label154:
    label326:
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever.setDataSource(paramString1);
        l1 = Long.valueOf(localMediaMetadataRetriever.extractMetadata(9)).longValue();
        if (l1 <= gifFirstNSecond * 1000) {
          break label326;
        }
        l1 = gifFirstNSecond * 1000;
        paramString1 = new GifCoder();
        paramString1.setEncoderDither(true);
        paramString1.setEncoderGifSize(gifSize);
        if (gifSizeForLongEdge != 1) {
          break label345;
        }
        bool = true;
        paramString1.setEncoderGifPicSizeForLongEdge(bool);
        l2 = 1000L / gifFps;
        l3 = l1 / gifMaxFrame;
        if (l2 <= l3) {
          break label351;
        }
      }
      catch (Throwable paramString1)
      {
        long l1;
        long l4;
        Bitmap localBitmap;
        long l5;
        long l6;
        QLog.e("GifProcessor", 1, "convertByRetriever error:", paramString1);
        return -501;
      }
      finally
      {
        localMediaMetadataRetriever.release();
      }
      if (l3 <= l1)
      {
        l4 = System.currentTimeMillis();
        localBitmap = localMediaMetadataRetriever.getFrameAtTime(1000L * l3, 3);
        l5 = System.currentTimeMillis();
        if (localBitmap != null) {
          paramString1.encodeGif(localBitmap.copy(Bitmap.Config.ARGB_8888, true), paramString2, gifTimePerFrame, true);
        }
        l6 = System.currentTimeMillis();
        if (!QLog.isColorLevel()) {
          break label335;
        }
        QLog.d("GifProcessor", 2, "convertByRetriever currentTime=" + l3 + " duration=" + l1 + " retrieve frame cost=" + (l5 - l4) + " encode frame cost=" + (l6 - l5));
        break label335;
      }
      paramString1.closeEncoder();
      localMediaMetadataRetriever.release();
      return 0;
    }
    for (;;)
    {
      l3 = 0L;
      break label154;
      label335:
      l3 += l2;
      break label154;
      label345:
      bool = false;
      break;
      label351:
      l2 = l3;
    }
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
    int i = 0;
    QLog.i("GifProcessor", 1, "generateGifFromVFile vfPath=" + paramString1 + " output=" + paramString3);
    loadConfig();
    GifCoder localGifCoder = new GifCoder();
    localGifCoder.setEncoderDither(true);
    localGifCoder.setEncoderGifSize(gifSize);
    boolean bool;
    int k;
    int j;
    VideoSourceHelper localVideoSourceHelper;
    Bitmap localBitmap;
    if (gifSizeForLongEdge == 1)
    {
      bool = true;
      localGifCoder.setEncoderGifPicSizeForLongEdge(bool);
      k = CodecParam.mRecordFrames * 1000 / CodecParam.mRecordTime / gifFps;
      j = k;
      if (k <= 0) {
        j = 1;
      }
      localVideoSourceHelper = new VideoSourceHelper(paramString1, paramString2);
      localVideoSourceHelper.initHelperParam();
      paramString1 = localVideoSourceHelper.getSourceVideoParam();
      localBitmap = Bitmap.createBitmap(paramString1[0], paramString1[1], Bitmap.Config.RGB_565);
      k = 0;
    }
    for (;;)
    {
      if (k < CodecParam.mRecordFrames)
      {
        i = localVideoSourceHelper.getVideoFrameByIndex(localBitmap, k);
        if (QLog.isColorLevel()) {
          QLog.d("GifProcessor", 2, "getVideoFrameByIndex from vffile. index=" + k + " ret=" + i);
        }
        if (i == 0) {
          break label231;
        }
      }
      for (;;)
      {
        localGifCoder.closeEncoder();
        return i;
        bool = false;
        break;
        label231:
        paramString2 = localBitmap.copy(Bitmap.Config.ARGB_8888, true);
        paramString1 = paramString2;
        if (paramInt != 0)
        {
          paramString1 = paramString2;
          if (!CameraFilterGLView.a(paramInt)) {
            paramString1 = RecordThumbnailUtils.a(paramString2, paramInt);
          }
        }
        if (localGifCoder.encodeGif(paramString1, paramString3, gifTimePerFrame, true)) {
          break label282;
        }
        i = -1;
      }
      label282:
      k += j;
    }
  }
  
  public static int getFrameFromVideoByRetriever(String paramString1, String paramString2)
  {
    QLog.i("GifProcessor", 1, "getFrameFromVideoByRetriever input=" + paramString1 + " output=" + paramString2);
    loadConfig();
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    for (;;)
    {
      try
      {
        localMediaMetadataRetriever.setDataSource(paramString1);
        long l1 = Long.valueOf(localMediaMetadataRetriever.extractMetadata(9)).longValue();
        if (l1 > gifFirstNSecond * 1000)
        {
          l1 = gifFirstNSecond * 1000;
          long l2 = 1000L / gifFps;
          l3 = l1 / gifMaxFrame;
          if (l2 > l3)
          {
            break label332;
            if (l3 <= l1)
            {
              long l4 = System.currentTimeMillis();
              paramString1 = localMediaMetadataRetriever.getFrameAtTime(1000L * l3, 3);
              long l5 = System.currentTimeMillis();
              if (paramString1 != null) {
                bfvo.a(paramString1.copy(Bitmap.Config.ARGB_8888, true), new File(paramString2 + File.separator + l3 + ".jpg"));
              }
              long l6 = System.currentTimeMillis();
              if (QLog.isColorLevel()) {
                QLog.d("GifProcessor", 2, "getFrameFromVideoByRetriever currentTime=" + l3 + " duration=" + l1 + " retrieve frame cost=" + (l5 - l4) + " encode frame cost=" + (l6 - l5));
              }
              l3 += l2;
              continue;
            }
          }
          else
          {
            l2 = l3;
            break label332;
          }
          return 0;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("GifProcessor", 1, "getFrameFromVideoByRetriever error:", paramString1);
        return -501;
      }
      finally
      {
        localMediaMetadataRetriever.release();
      }
      continue;
      label332:
      long l3 = 0L;
    }
  }
  
  public static int getFramesFromVideo(String paramString1, int paramInt1, int paramInt2, long paramLong, String paramString2)
  {
    QLog.i("GifProcessor", 1, "getFramesFromVideo input=" + paramString1 + " width=" + paramInt1 + " height=" + paramInt2 + " duration=" + paramLong + " output=" + paramString2);
    if (!loadSo()) {
      return -110;
    }
    if (TrimNative.detect(paramString1) != 0) {
      return -111;
    }
    loadConfig();
    Object localObject = null;
    try
    {
      String str = TrimNative.getRealProperties(paramString1, gifSize, gifSizeForLongEdge);
      localObject = str;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("GifProcessor", 1, "getRealProperties error:", localThrowable);
      }
      localObject = ((String)localObject).split(",");
      if ((localObject.length >= 4) && (localObject[0].equals("0"))) {
        break label161;
      }
      return -12;
      i = Integer.valueOf(localObject[3]).intValue();
      paramInt2 = Integer.valueOf(localObject[1]).intValue();
      paramInt1 = Integer.valueOf(localObject[2]).intValue();
      if (i == 1) {
        break label207;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return -11;
    }
    label161:
    int i;
    if (i == 3)
    {
      label207:
      i = paramInt2;
      paramInt2 = paramInt1;
    }
    for (;;)
    {
      if (akwa.a(paramString1, paramInt2, i, 0, 0, paramInt2, i) != 0) {
        return -112;
      }
      long l1;
      if (paramLong > gifFirstNSecond * 1000) {
        l1 = gifFirstNSecond * 1000;
      }
      for (;;)
      {
        long l3 = 0L;
        long l2 = 1000L / gifFps;
        long l4 = l1 / gifMaxFrame;
        label283:
        label317:
        long l6;
        long l5;
        if (l2 > l4)
        {
          paramString1 = new File(paramString2);
          if (paramString1.exists())
          {
            if (!paramString1.isDirectory()) {
              break label512;
            }
            FileUtils.deleteDirectory(paramString2);
          }
          paramString1.mkdir();
          if (l3 > l1) {
            break label528;
          }
          l6 = System.currentTimeMillis();
          l5 = l3 + l2;
          l4 = l5;
          if (l5 >= l1) {
            l4 = l1;
          }
          paramString1 = akwa.b(l3, l4);
          l4 = System.currentTimeMillis();
          if (paramString1 == null) {}
        }
        try
        {
          bfvo.a(paramString1, new File(paramString2 + File.separator + l3 + ".jpg"));
          l5 = System.currentTimeMillis();
          if (QLog.isColorLevel()) {
            QLog.d("GifProcessor", 2, "getFramesFromVideo currentTime=" + l3 + " duration=" + paramLong + " retrieve frame cost=" + (l4 - l6) + " encode frame cost=" + (l5 - l4));
          }
          l3 += l2;
          break label317;
          l1 = paramLong;
          continue;
          l2 = l4;
          break label283;
          label512:
          paramString1.delete();
        }
        catch (IOException paramString1)
        {
          for (;;)
          {
            paramString1.printStackTrace();
          }
        }
      }
      label528:
      return 0;
      i = paramInt1;
    }
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
      str2 = str2 + str1;
      File localFile = new File(str2);
      if ((str1 != null) && (localFile.exists()))
      {
        GlobalInit.loadLibraryWithFullPath(str2);
        sIsSoLoaded = true;
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.w("GifProcessor", 1, "loadLibrary error", localThrowable);
      return false;
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
      return arrayOfBoolean[0];
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        arrayOfBoolean[0] = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediadevice.GifProcessor
 * JD-Core Version:    0.7.0.1
 */