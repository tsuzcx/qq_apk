import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.DecimalFormat;

public class ror
{
  public static final String a = alof.cA;
  
  public static int a()
  {
    int i = 60;
    AladdinConfig localAladdinConfig = Aladdin.getConfig(274);
    if (localAladdinConfig != null)
    {
      i = localAladdinConfig.getIntegerFromString("compress_size_lower_bound", 60);
      QLog.d("VideoConvertUtils", 1, new Object[] { "getConfigCompressFileSizeLowerBound(), value = ", Integer.valueOf(i) });
    }
    return i * 1048576;
  }
  
  public static int a(int paramInt)
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(274);
    if (localAladdinConfig == null) {
      return 2048;
    }
    switch (paramInt)
    {
    default: 
      return localAladdinConfig.getIntegerFromString("compress_bitrate_720p", 2048);
    case 480: 
      return localAladdinConfig.getIntegerFromString("compress_bitrate_480p", 1024);
    case 640: 
      return localAladdinConfig.getIntegerFromString("compress_bitrate_640p", 1536);
    case 720: 
      return localAladdinConfig.getIntegerFromString("compress_bitrate_720p", 2048);
    }
    return localAladdinConfig.getIntegerFromString("compress_bitrate_1080p", 4096);
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    int i = 480;
    int n = Math.min(paramInt1, paramInt2);
    int j = Math.abs(n - 480);
    int k = Math.abs(n - 640);
    int m = Math.abs(n - 720);
    n = Math.abs(n - 1080);
    int i1 = Math.min(Math.min(j, k), Math.min(m, n));
    if (i1 == j) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoConvertUtils", 2, "calculateTargetVideoResolution(): width:" + paramInt1 + ", height:" + paramInt2 + " => resolution:" + i);
      }
      return i;
      if (i1 == k) {
        i = 640;
      } else if (i1 == m) {
        i = 720;
      } else if (i1 == n) {
        i = 1080;
      }
    }
  }
  
  public static long a(int paramInt1, int paramInt2)
  {
    return a(a(paramInt1, paramInt2)) * 1024;
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
      String str = bflq.a(paramString1 + System.currentTimeMillis());
      StringBuilder localStringBuilder = new StringBuilder(a());
      localStringBuilder.append(str);
      localStringBuilder.append(".");
      localStringBuilder.append(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("VideoConvertUtils", 2, "getVideoCompressedPath: sourcePath=" + paramString1 + "\n compressPath=" + localStringBuilder.toString());
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static boolean a()
  {
    return bdgk.f();
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return paramInt1 * paramInt2 > 3110400.0F;
  }
  
  public static boolean a(ros paramros)
  {
    if (paramros == null) {}
    long l;
    do
    {
      do
      {
        do
        {
          return false;
          if (a(paramros.a, paramros.jdField_b_of_type_Int))
          {
            if (QLog.isColorLevel()) {
              QLog.d("VideoConvertUtils", 2, "needCompress(): true! isExceedResolutionLimit");
            }
            return true;
          }
          if ((paramros.d >= a()) && (paramros.d <= b())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("VideoConvertUtils", 2, "needCompress(): false! fileSize not match, size=" + paramros.d);
        return false;
        if (a()) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("VideoConvertUtils", 2, "needCompress(): false! not High Profile Device");
      return false;
      l = a(paramros.a, paramros.jdField_b_of_type_Int);
      if ((l > 0L) && (paramros.jdField_b_of_type_Long > 3L * l))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoConvertUtils", 2, "needCompress(): true! sourceBitRate:" + paramros.jdField_b_of_type_Long + ", targetBitRate:" + l);
        }
        return true;
      }
    } while (!QLog.isColorLevel());
    QLog.d("VideoConvertUtils", 2, "needCompress(): false, bitrate not match, sourceBitRate:" + paramros.jdField_b_of_type_Long + ", targetBitRate:" + l);
    return false;
  }
  
  public static int b()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(274);
    int i = 60;
    if (localAladdinConfig != null)
    {
      i = localAladdinConfig.getIntegerFromString("compress_size_upper_bound", 1024);
      QLog.d("VideoConvertUtils", 1, new Object[] { "getConfigCompressFileSizeUpperBound(), value = ", Integer.valueOf(i) });
    }
    return i * 1048576;
  }
  
  public static String b()
  {
    long l = b();
    if (l < 1073741824L) {
      return l / 1048576L + "MB";
    }
    if (l % 1073741824L == 0L) {
      return l / 1073741824L + "GB";
    }
    DecimalFormat localDecimalFormat = new DecimalFormat(".00");
    return localDecimalFormat.format((float)l / 1.073742E+009F) + "GB";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ror
 * JD-Core Version:    0.7.0.1
 */