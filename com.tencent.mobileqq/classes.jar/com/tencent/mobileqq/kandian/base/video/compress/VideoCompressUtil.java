package com.tencent.mobileqq.kandian.base.video.compress;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.open.base.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import java.io.File;
import java.text.DecimalFormat;

public class VideoCompressUtil
{
  public static final String a = AppConstants.SDCARD_PATH_READINJOY;
  
  public static int a(int paramInt1, int paramInt2)
  {
    int n = Math.min(paramInt1, paramInt2);
    int j = Math.abs(n - 480);
    int k = Math.abs(n - 640);
    int m = Math.abs(n - 720);
    int i = 1080;
    n = Math.abs(n - 1080);
    int i1 = Math.min(Math.min(j, k), Math.min(m, n));
    if (i1 == j) {}
    do
    {
      i = 480;
      break;
      if (i1 == k)
      {
        i = 640;
        break;
      }
      if (i1 == m)
      {
        i = 720;
        break;
      }
    } while (i1 != n);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("calculateTargetVideoResolution(): width:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", height:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" => resolution:");
      localStringBuilder.append(i);
      QLog.d("VideoConvertUtils", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public static long a(int paramInt1, int paramInt2)
  {
    return VideoCompressConfig.a(a(paramInt1, paramInt2)) * 1024;
  }
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(a);
    localStringBuilder.append("convert");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  @TargetApi(9)
  public static String a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(System.currentTimeMillis());
      String str = MD5.a(localStringBuilder.toString());
      localStringBuilder = new StringBuilder(a());
      localStringBuilder.append(str);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString2);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("getVideoCompressedPath: sourcePath=");
        paramString2.append(paramString1);
        paramString2.append("\n compressPath=");
        paramString2.append(localStringBuilder.toString());
        QLog.d("VideoConvertUtils", 2, paramString2.toString());
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static boolean a()
  {
    return DeviceInfoUtils.a();
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isExceedResolutionLimit(): width:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", height:");
    localStringBuilder.append(paramInt2);
    QLog.d("VideoConvertUtils", 1, localStringBuilder.toString());
    return paramInt1 * paramInt2 > 3110400.0F;
  }
  
  public static boolean a(VideoMediaInfo paramVideoMediaInfo)
  {
    if (paramVideoMediaInfo == null) {
      return false;
    }
    if ((paramVideoMediaInfo.d >= VideoCompressConfig.a()) && (paramVideoMediaInfo.d <= VideoCompressConfig.b()))
    {
      if (a(paramVideoMediaInfo.a, paramVideoMediaInfo.jdField_b_of_type_Int))
      {
        QLog.d("VideoConvertUtils", 1, "needCompress(): true! isExceedResolutionLimit");
        return true;
      }
      if (!a())
      {
        QLog.d("VideoConvertUtils", 1, "needCompress(): false! not High Profile Device");
        return false;
      }
      long l = a(paramVideoMediaInfo.a, paramVideoMediaInfo.jdField_b_of_type_Int);
      if ((l > 0L) && (paramVideoMediaInfo.jdField_b_of_type_Long > 3L * l))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("needCompress(): true! sourceBitRate:");
        localStringBuilder.append(paramVideoMediaInfo.jdField_b_of_type_Long);
        localStringBuilder.append(", targetBitRate:");
        localStringBuilder.append(l);
        QLog.d("VideoConvertUtils", 1, localStringBuilder.toString());
        return true;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("needCompress(): false, bitrate not match, sourceBitRate:");
      localStringBuilder.append(paramVideoMediaInfo.jdField_b_of_type_Long);
      localStringBuilder.append(", targetBitRate:");
      localStringBuilder.append(l);
      QLog.d("VideoConvertUtils", 1, localStringBuilder.toString());
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("needCompress(): false! fileSize not match, size=");
    localStringBuilder.append(paramVideoMediaInfo.d);
    QLog.d("VideoConvertUtils", 1, localStringBuilder.toString());
    return false;
  }
  
  public static String b()
  {
    long l = VideoCompressConfig.b();
    if (l < 1073741824L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(l / 1048576L);
      ((StringBuilder)localObject).append("MB");
      return ((StringBuilder)localObject).toString();
    }
    if (l % 1073741824L == 0L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(l / 1073741824L);
      ((StringBuilder)localObject).append("GB");
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = new DecimalFormat(".00");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((DecimalFormat)localObject).format((float)l / 1.073742E+009F));
    localStringBuilder.append("GB");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.compress.VideoCompressUtil
 * JD-Core Version:    0.7.0.1
 */