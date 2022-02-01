package com.tencent.ttpic.baseutils.bitmap;

import android.media.ExifInterface;
import android.text.TextUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExifUtils
{
  private static final String TAG = "CameraExif";
  
  public static int exchange(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 90)
      {
        if (paramInt != 180)
        {
          if (paramInt != 270) {
            return 1;
          }
          return 8;
        }
        return 3;
      }
      return 6;
    }
    return 1;
  }
  
  public static double getExifAltitude(String paramString)
  {
    try
    {
      Object localObject = new ExifInterface(paramString);
      paramString = ((ExifInterface)localObject).getAttribute("GPSAltitude");
      localObject = ((ExifInterface)localObject).getAttribute("GPSAltitudeRef");
      double d2 = gpsValue2Num(paramString);
      boolean bool = "1".equals(localObject);
      double d1 = d2;
      if (bool) {
        d1 = d2 * -1.0D;
      }
      return d1;
    }
    catch (Exception paramString)
    {
      LogUtils.e(paramString);
    }
    return 0.0D;
  }
  
  public static long getExifDate(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    try
    {
      String str = new ExifInterface(paramString).getAttribute("DateTime");
      if (TextUtils.isEmpty(str)) {
        return new File(paramString).lastModified();
      }
      long l = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse(str).getTime();
      return l;
    }
    catch (Exception paramString)
    {
      LogUtils.e(paramString);
    }
    return 0L;
  }
  
  public static double[] getExifGPS(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      double[] arrayOfDouble = new double[2];
      Object localObject = new ExifInterface(paramString);
      paramString = ((ExifInterface)localObject).getAttribute("GPSLatitude");
      String str1 = ((ExifInterface)localObject).getAttribute("GPSLatitudeRef");
      String str2 = ((ExifInterface)localObject).getAttribute("GPSLongitude");
      localObject = ((ExifInterface)localObject).getAttribute("GPSLongitudeRef");
      boolean bool = TextUtils.isEmpty(paramString);
      if (!bool) {
        if ("S".equals(str1)) {
          arrayOfDouble[0] = (getGpsCoord(paramString.split(",")) * -1.0D);
        } else {
          arrayOfDouble[0] = getGpsCoord(paramString.split(","));
        }
      }
      if (!TextUtils.isEmpty(str2))
      {
        if ("W".equals(localObject))
        {
          arrayOfDouble[1] = (getGpsCoord(str2.split(",")) * -1.0D);
          return arrayOfDouble;
        }
        arrayOfDouble[1] = getGpsCoord(str2.split(","));
      }
      return arrayOfDouble;
    }
    catch (Exception paramString)
    {
      LogUtils.e(paramString);
    }
    return null;
  }
  
  private static double getGpsCoord(String[] paramArrayOfString)
  {
    double d3 = 0.0D;
    if (paramArrayOfString == null) {
      return 0.0D;
    }
    if (paramArrayOfString.length > 0) {
      d1 = gpsValue2Num(paramArrayOfString[0]);
    } else {
      d1 = 0.0D;
    }
    if (paramArrayOfString.length > 1) {
      d2 = gpsValue2Num(paramArrayOfString[1]);
    } else {
      d2 = 0.0D;
    }
    if (paramArrayOfString.length > 2) {
      d3 = gpsValue2Num(paramArrayOfString[2]);
    }
    d2 += (d1 - Math.floor(d1)) * 60.0D;
    double d5 = Math.floor(d1);
    d3 += (d2 - Math.floor(d2)) * 60.0D;
    double d4 = Math.floor(d2);
    double d2 = d3;
    double d1 = d4;
    if (d3 >= 60.0D)
    {
      d2 = d3 / 60.0D;
      d1 = d4 + Math.floor(d2);
      d2 = d3 - Math.floor(d2) * 60.0D;
    }
    d4 = d5;
    d3 = d1;
    if (d1 >= 60.0D)
    {
      d3 = d1 / 60.0D;
      d4 = d5 + Math.floor(d3);
      d3 = d1 - Math.floor(d3) * 60.0D;
    }
    return d4 + d3 / 60.0D + d2 / 3600.0D;
  }
  
  public static int getOrientation(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return 0;
    }
    byte[] arrayOfByte = new byte[8];
    for (;;)
    {
      if ((!read(paramInputStream, arrayOfByte, 2)) || ((arrayOfByte[0] & 0xFF) != 255)) {
        break label203;
      }
      int i = arrayOfByte[1] & 0xFF;
      int j;
      long l;
      if ((i != 255) && (i != 216) && (i != 1)) {
        if (i != 217)
        {
          if (i == 218) {
            return 0;
          }
          if (!read(paramInputStream, arrayOfByte, 2)) {
            return 0;
          }
          j = pack(arrayOfByte, 0, 2, false);
          if (j < 2)
          {
            LogUtils.e("CameraExif", "Invalid length");
            return 0;
          }
          j -= 2;
          if ((i == 225) && (j >= 6))
          {
            if (!read(paramInputStream, arrayOfByte, 6)) {
              return 0;
            }
            i = j - 6;
            j = i;
            if (pack(arrayOfByte, 0, 4, false) == 1165519206)
            {
              j = i;
              if (pack(arrayOfByte, 4, 2, false) == 0) {
                break label205;
              }
            }
          }
          l = j;
        }
      }
      boolean bool;
      int k;
      try
      {
        paramInputStream.skip(l);
      }
      catch (IOException paramInputStream) {}
    }
    return 0;
    label203:
    i = 0;
    label205:
    if (i > 8)
    {
      arrayOfByte = new byte[i];
      if (!read(paramInputStream, arrayOfByte, i)) {
        return 0;
      }
      j = pack(arrayOfByte, 0, 4, false);
      if ((j != 1229531648) && (j != 1296891946))
      {
        LogUtils.e("CameraExif", "Invalid byte order");
        return 0;
      }
      if (j == 1229531648) {
        bool = true;
      } else {
        bool = false;
      }
      j = pack(arrayOfByte, 4, 4, bool) + 2;
      if ((j >= 10) && (j <= i))
      {
        k = j + 0;
        j = i - j;
        i = pack(arrayOfByte, k - 2, 2, bool);
      }
      while ((i > 0) && (j >= 12))
      {
        if (pack(arrayOfByte, k, 2, bool) == 274)
        {
          i = pack(arrayOfByte, k + 8, 2, bool);
          if (i != 1)
          {
            if (i != 3)
            {
              if (i != 6)
              {
                if (i != 8)
                {
                  LogUtils.i("CameraExif", "Unsupported orientation");
                  return 0;
                }
                return 270;
              }
              return 90;
            }
            return 180;
          }
          return 0;
        }
        k += 12;
        j -= 12;
        i -= 1;
        continue;
        LogUtils.e("CameraExif", "Invalid offset");
        return 0;
      }
    }
    LogUtils.i("CameraExif", "Orientation not found");
    return 0;
    return 0;
  }
  
  public static int getOrientation(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return 0;
    }
    int i = 0;
    int j;
    int k;
    int m;
    for (;;)
    {
      j = i;
      if (i + 3 >= paramArrayOfByte.length) {
        break;
      }
      k = i + 1;
      j = k;
      if ((paramArrayOfByte[i] & 0xFF) != 255) {
        break;
      }
      m = paramArrayOfByte[k] & 0xFF;
      if (m == 255)
      {
        i = k;
      }
      else
      {
        k += 1;
        i = k;
        if (m != 216) {
          if (m == 1)
          {
            i = k;
          }
          else
          {
            j = k;
            if (m == 217) {
              break;
            }
            if (m == 218)
            {
              j = k;
              break;
            }
            int n = pack(paramArrayOfByte, k, 2, false);
            if (n >= 2)
            {
              i = k + n;
              if (i <= paramArrayOfByte.length)
              {
                if ((m == 225) && (n >= 8) && (pack(paramArrayOfByte, k + 2, 4, false) == 1165519206) && (pack(paramArrayOfByte, k + 6, 2, false) == 0))
                {
                  j = k + 8;
                  i = n - 8;
                  break label209;
                }
                continue;
              }
            }
            LogUtils.e("CameraExif", "Invalid length");
            return 0;
          }
        }
      }
    }
    i = 0;
    label209:
    if (i > 8)
    {
      k = pack(paramArrayOfByte, j, 4, false);
      if ((k != 1229531648) && (k != 1296891946))
      {
        LogUtils.e("CameraExif", "Invalid byte order");
        return 0;
      }
      boolean bool;
      if (k == 1229531648) {
        bool = true;
      } else {
        bool = false;
      }
      m = pack(paramArrayOfByte, j + 4, 4, bool) + 2;
      if ((m >= 10) && (m <= i))
      {
        k = j + m;
        j = i - m;
        i = pack(paramArrayOfByte, k - 2, 2, bool);
      }
      while ((i > 0) && (j >= 12))
      {
        if (pack(paramArrayOfByte, k, 2, bool) == 274)
        {
          i = pack(paramArrayOfByte, k + 8, 2, bool);
          if (i != 1)
          {
            if (i != 3)
            {
              if (i != 6)
              {
                if (i != 8)
                {
                  LogUtils.i("CameraExif", "Unsupported orientation");
                  return 0;
                }
                return 270;
              }
              return 90;
            }
            return 180;
          }
          return 0;
        }
        k += 12;
        j -= 12;
        i -= 1;
        continue;
        LogUtils.e("CameraExif", "Invalid offset");
        return 0;
      }
    }
    LogUtils.i("CameraExif", "Orientation not found");
    return 0;
  }
  
  private static double gpsValue2Num(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0.0D;
    }
    paramString = paramString.split("/");
    if (paramString != null)
    {
      if (paramString.length <= 0) {
        return 0.0D;
      }
      if (paramString.length == 1) {
        return Double.valueOf(paramString[0]).doubleValue();
      }
      if (Math.abs(Double.valueOf(paramString[1]).doubleValue()) < 0.0001D) {
        return 0.0D;
      }
      return Double.valueOf(paramString[0]).doubleValue() / Double.valueOf(paramString[1]).doubleValue();
    }
    return 0.0D;
  }
  
  public static void incExifData(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    try
    {
      ExifInterface localExifInterface = new ExifInterface(paramString);
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
      String str = localExifInterface.getAttribute("DateTime");
      long l;
      if (!TextUtils.isEmpty(str)) {
        l = localSimpleDateFormat.parse(str).getTime();
      } else {
        l = new File(paramString).lastModified();
      }
      paramString = localSimpleDateFormat.format(Long.valueOf(l + paramInt * 1000));
      localExifInterface.setAttribute("DateTime", paramString);
      localExifInterface.saveAttributes();
      LogUtils.d("ExifUtils", "date written %s", new Object[] { paramString });
      return;
    }
    catch (Exception paramString)
    {
      LogUtils.e(paramString);
    }
  }
  
  private static int pack(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      paramInt1 += paramInt2 - 1;
      i = -1;
    }
    else
    {
      i = 1;
    }
    int j = 0;
    while (paramInt2 > 0)
    {
      j = paramArrayOfByte[paramInt1] & 0xFF | j << 8;
      paramInt1 += i;
      paramInt2 -= 1;
    }
    return j;
  }
  
  private static boolean read(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = false;
    try
    {
      int i = paramInputStream.read(paramArrayOfByte, 0, paramInt);
      if (i == paramInt) {
        bool = true;
      }
      return bool;
    }
    catch (IOException paramInputStream) {}
    return false;
  }
  
  public static int setOrientation(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {
      return 0;
    }
    int i = 0;
    int k;
    boolean bool;
    int j;
    int m;
    for (;;)
    {
      k = paramArrayOfByte.length;
      bool = true;
      j = i;
      if (i + 3 >= k) {
        break;
      }
      k = i + 1;
      j = k;
      if ((paramArrayOfByte[i] & 0xFF) != 255) {
        break;
      }
      m = paramArrayOfByte[k] & 0xFF;
      if (m == 255)
      {
        i = k;
      }
      else
      {
        k += 1;
        i = k;
        if (m != 216) {
          if (m == 1)
          {
            i = k;
          }
          else
          {
            j = k;
            if (m == 217) {
              break;
            }
            if (m == 218)
            {
              j = k;
              break;
            }
            int n = pack(paramArrayOfByte, k, 2, false);
            if (n >= 2)
            {
              i = k + n;
              if (i <= paramArrayOfByte.length)
              {
                if ((m == 225) && (n >= 8) && (pack(paramArrayOfByte, k + 2, 4, false) == 1165519206) && (pack(paramArrayOfByte, k + 6, 2, false) == 0))
                {
                  j = k + 8;
                  i = n - 8;
                  break label231;
                }
                continue;
              }
            }
            LogUtils.e("CameraExif", "Invalid length");
            return 0;
          }
        }
      }
    }
    i = 0;
    label231:
    if (i > 8)
    {
      k = pack(paramArrayOfByte, j, 4, false);
      if ((k != 1229531648) && (k != 1296891946))
      {
        LogUtils.e("CameraExif", "Invalid byte order");
        return 0;
      }
      if (k != 1229531648) {
        bool = false;
      }
      k = pack(paramArrayOfByte, j + 4, 4, bool) + 2;
      if ((k >= 10) && (k <= i))
      {
        m = j + k;
        k = i - k;
        j = pack(paramArrayOfByte, m - 2, 2, bool);
        i = m;
      }
      while ((j > 0) && (k >= 12))
      {
        if (pack(paramArrayOfByte, i, 2, bool) == 274)
        {
          if (paramInt != 0)
          {
            if (paramInt == 90) {
              break label404;
            }
            if (paramInt == 180) {
              break label399;
            }
            if (paramInt == 270) {}
          }
          else
          {
            paramInt = 0;
            break label407;
          }
          paramInt = 8;
          break label407;
          paramInt = 3;
          break label407;
          paramInt = 6;
          write(paramArrayOfByte, i + 8, paramInt, 2, bool);
          LogUtils.i("CameraExif", "Unsupported orientation");
          return 0;
        }
        i += 12;
        k -= 12;
        j -= 1;
        continue;
        LogUtils.e("CameraExif", "Invalid offset");
        return 0;
      }
    }
    label399:
    label404:
    label407:
    LogUtils.i("CameraExif", "Orientation not found");
    return 0;
  }
  
  private static void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      paramInt1 += paramInt3 - 1;
      i = -1;
    }
    else
    {
      i = 1;
    }
    while (paramInt3 > 0)
    {
      paramArrayOfByte[paramInt1] = ((byte)(paramInt2 & 0xFF));
      paramInt2 >>= 8;
      paramInt1 += i;
      paramInt3 -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.bitmap.ExifUtils
 * JD-Core Version:    0.7.0.1
 */