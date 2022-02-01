package com.tencent.mobileqq.shortvideo;

import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.ShortVideoTrimmer;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class VideoCompressConfig
{
  public static VideoCompressConfig.CompressInfo a(VideoCompressConfig.VideoInfo paramVideoInfo, VideoCompressConfig.ManageConfig paramManageConfig, boolean paramBoolean)
  {
    VideoCompressConfig.CompressInfo localCompressInfo = new VideoCompressConfig.CompressInfo();
    int i;
    if (paramVideoInfo.e > 0)
    {
      i = paramVideoInfo.e;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "getCompressInfo, videoFps = " + i);
      }
      if (!paramBoolean) {
        break label189;
      }
      localCompressInfo.jdField_a_of_type_Float = 1.0F;
      localCompressInfo.jdField_a_of_type_Int = paramVideoInfo.jdField_a_of_type_Int;
      localCompressInfo.jdField_b_of_type_Int = paramVideoInfo.jdField_b_of_type_Int;
      localCompressInfo.jdField_b_of_type_Long = i;
      if ((paramVideoInfo.jdField_a_of_type_Long <= 0L) || (paramVideoInfo.jdField_a_of_type_Long * 8L >= paramManageConfig.jdField_a_of_type_Long)) {
        break label169;
      }
      localCompressInfo.jdField_a_of_type_Long = paramVideoInfo.jdField_b_of_type_Long;
      label124:
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "getCompressInfo, isRaw, compressInfo.desBitRate = " + localCompressInfo.jdField_a_of_type_Long);
      }
    }
    label169:
    label189:
    label352:
    label742:
    for (;;)
    {
      return localCompressInfo;
      i = 30;
      break;
      localCompressInfo.jdField_a_of_type_Long = ((int)(paramManageConfig.jdField_a_of_type_Long / paramVideoInfo.d));
      break label124;
      double d2;
      double d1;
      if (paramVideoInfo.jdField_a_of_type_Int <= paramVideoInfo.jdField_b_of_type_Int)
      {
        i = paramVideoInfo.jdField_b_of_type_Int;
        if (i <= paramManageConfig.jdField_a_of_type_Int) {
          break label692;
        }
        localCompressInfo.jdField_a_of_type_Float = (paramManageConfig.jdField_a_of_type_Int / i);
        localCompressInfo.jdField_a_of_type_Int = ((int)(paramVideoInfo.jdField_a_of_type_Int * localCompressInfo.jdField_a_of_type_Float));
        localCompressInfo.jdField_b_of_type_Int = ((int)(paramVideoInfo.jdField_b_of_type_Int * localCompressInfo.jdField_a_of_type_Float));
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo,  config.scaleRate = " + localCompressInfo.jdField_a_of_type_Float + ", compressInfo.desWidth = " + localCompressInfo.jdField_a_of_type_Int + ", compressInfo.desHeight = " + localCompressInfo.jdField_b_of_type_Int);
        }
        if ((paramVideoInfo.e <= 0) || (paramVideoInfo.e >= paramManageConfig.jdField_b_of_type_Int)) {
          break label719;
        }
        localCompressInfo.jdField_b_of_type_Long = paramVideoInfo.e;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, compressInfo.desFPS = " + localCompressInfo.jdField_b_of_type_Long);
        }
        d2 = localCompressInfo.jdField_a_of_type_Int * localCompressInfo.jdField_b_of_type_Int * localCompressInfo.jdField_b_of_type_Long * paramManageConfig.jdField_a_of_type_Double;
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, bpsExp = " + d2);
        }
        d1 = d2;
        if (d2 > paramVideoInfo.jdField_b_of_type_Long) {
          d1 = paramVideoInfo.jdField_b_of_type_Long;
        }
        d2 = d1;
        if (d1 > paramManageConfig.c) {
          d2 = paramManageConfig.c;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo, bpsExp real = " + d2);
        }
        if (paramVideoInfo.d * d2 <= paramManageConfig.jdField_a_of_type_Long) {
          break label732;
        }
        d2 = paramManageConfig.jdField_a_of_type_Long / (localCompressInfo.jdField_a_of_type_Int * localCompressInfo.jdField_b_of_type_Int * localCompressInfo.jdField_b_of_type_Long * paramVideoInfo.d);
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getCompressInfo,densityExp = " + d2);
        }
        d1 = d2;
        if (d2 < paramManageConfig.jdField_b_of_type_Double) {
          d1 = paramManageConfig.jdField_b_of_type_Double;
        }
      }
      for (localCompressInfo.jdField_a_of_type_Long = ((int)(d1 * (localCompressInfo.jdField_a_of_type_Int * localCompressInfo.jdField_b_of_type_Int * localCompressInfo.jdField_b_of_type_Long)));; localCompressInfo.jdField_a_of_type_Long = ((int)d2))
      {
        if (!QLog.isColorLevel()) {
          break label742;
        }
        QLog.d("VideoCompressConfig", 2, "getCompressInfo,  compressInfo.desBitRate " + localCompressInfo.jdField_a_of_type_Long);
        return localCompressInfo;
        i = paramVideoInfo.jdField_a_of_type_Int;
        break;
        localCompressInfo.jdField_a_of_type_Float = 1.0F;
        localCompressInfo.jdField_a_of_type_Int = paramVideoInfo.jdField_a_of_type_Int;
        localCompressInfo.jdField_b_of_type_Int = paramVideoInfo.jdField_b_of_type_Int;
        break label263;
        localCompressInfo.jdField_b_of_type_Long = paramManageConfig.jdField_b_of_type_Int;
        break label352;
      }
    }
  }
  
  public static VideoCompressConfig.ManageConfig a(QQAppInterface paramQQAppInterface)
  {
    VideoCompressConfig.ManageConfig localManageConfig = new VideoCompressConfig.ManageConfig();
    if (paramQQAppInterface == null) {
      QLog.e("VideoCompressConfig", 1, "getManageConfig, app is null.");
    }
    do
    {
      return localManageConfig;
      paramQQAppInterface = SharedPreUtils.p(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin());
      if ((paramQQAppInterface != null) && (paramQQAppInterface.length() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getManageConfig, compressConfig = " + paramQQAppInterface);
        }
        paramQQAppInterface = paramQQAppInterface.split("\\|");
        if ((paramQQAppInterface == null) || (paramQQAppInterface.length < 5)) {}
      }
      try
      {
        int i = Integer.valueOf(paramQQAppInterface[0]).intValue();
        if (i > 0) {
          localManageConfig.jdField_a_of_type_Int = i;
        }
        i = Integer.valueOf(paramQQAppInterface[1]).intValue();
        if (i > 0) {
          localManageConfig.jdField_b_of_type_Int = i;
        }
        double d = Double.valueOf(paramQQAppInterface[2]).doubleValue();
        if (d > 0.0D) {
          localManageConfig.jdField_a_of_type_Double = d;
        }
        d = Double.valueOf(paramQQAppInterface[3]).doubleValue();
        if (d > 0.0D) {
          localManageConfig.jdField_b_of_type_Double = d;
        }
        if ((paramQQAppInterface.length >= 6) && (paramQQAppInterface[5] != null) && (paramQQAppInterface[5].length() > 0))
        {
          i = Integer.valueOf(paramQQAppInterface[5]).intValue();
          if (i > 0) {
            localManageConfig.jdField_a_of_type_Long = (i * 1024 * 1024 * 8);
          }
        }
        long l;
        if ((paramQQAppInterface.length >= 8) && (paramQQAppInterface[7] != null) && (paramQQAppInterface[7].length() > 0))
        {
          l = Long.valueOf(paramQQAppInterface[7]).longValue();
          if (l > 0L) {
            localManageConfig.c = l;
          }
        }
        if ((paramQQAppInterface.length >= 9) && (paramQQAppInterface[8] != null) && (paramQQAppInterface[8].length() > 0))
        {
          l = Long.valueOf(paramQQAppInterface[8]).longValue();
          if (l > 0L) {
            localManageConfig.jdField_b_of_type_Long = l;
          }
        }
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("VideoCompressConfig", 2, "getCompressConfigNew -> get VideoCompressConfig Erro", paramQQAppInterface);
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoCompressConfig", 2, "getManageConfig, maxLength = " + localManageConfig.jdField_a_of_type_Int + ", maxFPS = " + localManageConfig.jdField_b_of_type_Int + ", maxDensity = " + localManageConfig.jdField_a_of_type_Double + ", minDensity = " + localManageConfig.jdField_b_of_type_Double + ", maxSize = " + localManageConfig.jdField_a_of_type_Long + ", maxBitRate = " + localManageConfig.c + ", minBitRate = " + localManageConfig.jdField_b_of_type_Long);
    return localManageConfig;
  }
  
  public static VideoCompressConfig.VideoInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("VideoCompressConfig", 1, "getVideoInfo, videoPath is empty.");
      paramString = null;
      return paramString;
    }
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      QLog.e("VideoCompressConfig", 1, "getVideoInfo, file not exists.");
      return null;
    }
    VideoCompressConfig.VideoInfo localVideoInfo = new VideoCompressConfig.VideoInfo();
    localVideoInfo.jdField_a_of_type_Long = ((File)localObject).length();
    if (Build.VERSION.SDK_INT >= 17) {
      localObject = new MediaMetadataRetriever();
    }
    for (;;)
    {
      try
      {
        ((MediaMetadataRetriever)localObject).setDataSource(paramString);
        paramString = ((MediaMetadataRetriever)localObject).extractMetadata(18);
        String str1 = ((MediaMetadataRetriever)localObject).extractMetadata(19);
        String str2 = ((MediaMetadataRetriever)localObject).extractMetadata(24);
        String str3 = ((MediaMetadataRetriever)localObject).extractMetadata(9);
        String str4 = ((MediaMetadataRetriever)localObject).extractMetadata(32);
        if (QLog.isColorLevel()) {
          QLog.d("VideoCompressConfig", 2, "getVideoInfo by MediaMetadataRetriever, width = " + paramString + ", height = " + str1 + ", rotation = " + str2 + ", duration = " + str3 + ", frameCount = " + str4);
        }
        localVideoInfo.jdField_a_of_type_Int = Integer.valueOf(paramString).intValue();
        localVideoInfo.jdField_b_of_type_Int = Integer.valueOf(str1).intValue();
        localVideoInfo.c = Integer.valueOf(str2).intValue();
        localVideoInfo.d = ((int)(Integer.valueOf(str3).intValue() / 1000.0D + 0.5D));
        localVideoInfo.e = ((int)(Integer.valueOf(str4).intValue() * 1.0D / localVideoInfo.d + 0.5D));
      }
      catch (Exception paramString)
      {
        QLog.e("VideoCompressConfig", 1, "getVideoProperty:", paramString);
        ((MediaMetadataRetriever)localObject).release();
        continue;
      }
      finally
      {
        ((MediaMetadataRetriever)localObject).release();
      }
      if (localVideoInfo.d > 0) {
        localVideoInfo.jdField_b_of_type_Long = (localVideoInfo.jdField_a_of_type_Long * 8L / localVideoInfo.d);
      }
      paramString = localVideoInfo;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VideoCompressConfig", 2, "getVideoInfo, fileSize = " + localVideoInfo.jdField_a_of_type_Long + ", width = " + localVideoInfo.jdField_a_of_type_Int + ", height = " + localVideoInfo.jdField_b_of_type_Int + ", rotation = " + localVideoInfo.c + ", duration = " + localVideoInfo.d + ", fps = " + localVideoInfo.e + ", videoInfo.bitRate = " + localVideoInfo.jdField_b_of_type_Long);
      return localVideoInfo;
      try
      {
        paramString = ShortVideoTrimmer.getRealProperties(paramString);
        if (paramString != null)
        {
          paramString = paramString.split(",");
          if ((paramString != null) && (paramString.length > 0))
          {
            localObject = new int[paramString.length];
            int i = 0;
            while (i < paramString.length)
            {
              localObject[i] = Integer.valueOf(paramString[i]).intValue();
              i += 1;
            }
            localVideoInfo.jdField_a_of_type_Int = localObject[1];
            localVideoInfo.jdField_b_of_type_Int = localObject[2];
            localVideoInfo.c = Integer.valueOf(ShortVideoTrimmer.getVideoRotate(localObject[3])).intValue();
            localVideoInfo.d = ((int)(localObject[4] / 1000.0D + 0.5D));
          }
        }
      }
      catch (Exception paramString)
      {
        QLog.e("VideoCompressConfig", 1, "getVideoInfo error.", paramString);
      }
    }
  }
  
  public static boolean a(VideoCompressConfig.VideoInfo paramVideoInfo, VideoCompressConfig.ManageConfig paramManageConfig)
  {
    if ((paramVideoInfo == null) || (paramManageConfig == null))
    {
      QLog.e("VideoCompressConfig", 1, "isNeedCompress, false, videoInfo or config is null");
      return false;
    }
    if (paramVideoInfo.jdField_a_of_type_Long * 8L > paramManageConfig.jdField_a_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, fileSize > maxSize, fileSize = " + paramVideoInfo.jdField_a_of_type_Long);
      }
      return true;
    }
    if (paramVideoInfo.jdField_b_of_type_Long < paramManageConfig.jdField_b_of_type_Long)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress,false, bitRate < minBitRate, bitRate = " + paramVideoInfo.jdField_b_of_type_Long + ", minBitRate = " + paramManageConfig.jdField_b_of_type_Long);
      }
      return false;
    }
    if (paramVideoInfo.jdField_b_of_type_Long > paramManageConfig.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, bitRate > maxBitRate, bitRate = " + paramVideoInfo.jdField_b_of_type_Long + ", maxBitRate = " + paramManageConfig.c);
      }
      return true;
    }
    if (paramVideoInfo.e > 0) {}
    for (int i = paramVideoInfo.e;; i = 30)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, videoFps = " + i);
      }
      if (paramVideoInfo.jdField_b_of_type_Long <= paramVideoInfo.jdField_a_of_type_Int * paramVideoInfo.jdField_b_of_type_Int * i * paramManageConfig.jdField_a_of_type_Double * 1.2D) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressConfig", 2, "isNeedCompress, true, density > 1.2 * maxDensty. bitRate = " + paramVideoInfo.jdField_b_of_type_Long + ", width * height * videoFps * maxDensity * 1.2 = " + i * (paramVideoInfo.jdField_a_of_type_Int * paramVideoInfo.jdField_b_of_type_Int) * paramManageConfig.jdField_a_of_type_Double * 1.2D);
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressConfig", 2, "isNeedCompress, false, density <= 1.2 * maxDensty. bitRate = " + paramVideoInfo.jdField_b_of_type_Long + ", width * height * videoFps * maxDensity * 1.2 = " + i * (paramVideoInfo.jdField_a_of_type_Int * paramVideoInfo.jdField_b_of_type_Int) * paramManageConfig.jdField_a_of_type_Double * 1.2D);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.VideoCompressConfig
 * JD-Core Version:    0.7.0.1
 */