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
    switch (paramInt)
    {
    case 0: 
    default: 
      return 1;
    case 180: 
      return 3;
    case 90: 
      return 6;
    }
    return 8;
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
    double[] arrayOfDouble;
    try
    {
      arrayOfDouble = new double[2];
      Object localObject = new ExifInterface(paramString);
      paramString = ((ExifInterface)localObject).getAttribute("GPSLatitude");
      String str1 = ((ExifInterface)localObject).getAttribute("GPSLatitudeRef");
      String str2 = ((ExifInterface)localObject).getAttribute("GPSLongitude");
      localObject = ((ExifInterface)localObject).getAttribute("GPSLongitudeRef");
      if (!TextUtils.isEmpty(paramString))
      {
        if (!"S".equals(str1)) {
          break label121;
        }
        arrayOfDouble[0] = (getGpsCoord(paramString.split(",")) * -1.0D);
      }
      while (!TextUtils.isEmpty(str2)) {
        if ("W".equals(localObject))
        {
          arrayOfDouble[1] = (getGpsCoord(str2.split(",")) * -1.0D);
          break;
          label121:
          arrayOfDouble[0] = getGpsCoord(paramString.split(","));
        }
        else
        {
          arrayOfDouble[1] = getGpsCoord(str2.split(","));
        }
      }
    }
    catch (Exception paramString)
    {
      LogUtils.e(paramString);
      return null;
    }
    return arrayOfDouble;
  }
  
  private static double getGpsCoord(String[] paramArrayOfString)
  {
    double d3 = 0.0D;
    if (paramArrayOfString == null) {
      return 0.0D;
    }
    double d1;
    double d2;
    label34:
    double d4;
    if (paramArrayOfString.length > 0)
    {
      d1 = gpsValue2Num(paramArrayOfString[0]);
      if (paramArrayOfString.length <= 1) {
        break label196;
      }
      d2 = gpsValue2Num(paramArrayOfString[1]);
      if (paramArrayOfString.length > 2) {
        d3 = gpsValue2Num(paramArrayOfString[2]);
      }
      double d5 = (d1 - Math.floor(d1)) * 60.0D + d2;
      d4 = Math.floor(d1);
      d2 = (d5 - Math.floor(d5)) * 60.0D + d3;
      d1 = Math.floor(d5);
      if (d2 < 60.0D) {
        break label210;
      }
      d3 = Math.floor(d2 / 60.0D);
      d2 -= Math.floor(d2 / 60.0D) * 60.0D;
      d1 += d3;
    }
    label196:
    label210:
    for (;;)
    {
      if (d1 >= 60.0D)
      {
        d3 = Math.floor(d1 / 60.0D) + d4;
        d4 = d1 - Math.floor(d1 / 60.0D) * 60.0D;
        d1 = d3;
        d3 = d4;
      }
      for (;;)
      {
        d3 /= 60.0D;
        return d2 / 3600.0D + (d3 + d1);
        d1 = 0.0D;
        break;
        d2 = 0.0D;
        break label34;
        d3 = d1;
        d1 = d4;
      }
    }
  }
  
  public static int getOrientation(InputStream paramInputStream)
  {
    boolean bool = true;
    if (paramInputStream == null) {}
    byte[] arrayOfByte;
    int k;
    int j;
    do
    {
      do
      {
        return 0;
        arrayOfByte = new byte[8];
        do
        {
          if ((!read(paramInputStream, arrayOfByte, 2)) || ((arrayOfByte[0] & 0xFF) != 255)) {
            break;
          }
          k = arrayOfByte[1] & 0xFF;
        } while ((k == 255) || (k == 216) || (k == 1));
      } while ((k == 217) || (k == 218) || (!read(paramInputStream, arrayOfByte, 2)));
      i = pack(arrayOfByte, 0, 2, false);
      if (i < 2)
      {
        LogUtils.e("CameraExif", "Invalid length");
        return 0;
      }
      j = i - 2;
      i = j;
      if (k != 225) {
        break;
      }
      i = j;
      if (j < 6) {
        break;
      }
    } while (!read(paramInputStream, arrayOfByte, 6));
    j -= 6;
    int i = j;
    if (pack(arrayOfByte, 0, 4, false) == 1165519206)
    {
      i = j;
      if (pack(arrayOfByte, 4, 2, false) != 0) {}
    }
    for (i = j;; i = 0)
    {
      for (;;)
      {
        if (i <= 8) {
          break label437;
        }
        arrayOfByte = new byte[i];
        if (!read(paramInputStream, arrayOfByte, i)) {
          break;
        }
        j = pack(arrayOfByte, 0, 4, false);
        if ((j != 1229531648) && (j != 1296891946))
        {
          LogUtils.e("CameraExif", "Invalid byte order");
          return 0;
          long l = i;
          try
          {
            paramInputStream.skip(l);
          }
          catch (IOException paramInputStream)
          {
            return 0;
          }
        }
      }
      if (j == 1229531648) {}
      for (;;)
      {
        k = pack(arrayOfByte, 4, 4, bool) + 2;
        if ((k >= 10) && (k <= i)) {
          break;
        }
        LogUtils.e("CameraExif", "Invalid offset");
        return 0;
        bool = false;
      }
      j = 0 + k;
      int m = pack(arrayOfByte, j - 2, 2, bool);
      k = i - k;
      i = m;
      while ((i > 0) && (k >= 12))
      {
        if (pack(arrayOfByte, j, 2, bool) == 274)
        {
          switch (pack(arrayOfByte, j + 8, 2, bool))
          {
          case 1: 
          case 2: 
          case 4: 
          case 5: 
          case 7: 
          default: 
            LogUtils.i("CameraExif", "Unsupported orientation");
            return 0;
          case 3: 
            return 180;
          case 6: 
            return 90;
          }
          return 270;
        }
        k -= 12;
        j += 12;
        i -= 1;
      }
      label437:
      LogUtils.i("CameraExif", "Orientation not found");
      return 0;
    }
  }
  
  public static int getOrientation(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return 0;
    }
    int i = 0;
    int j;
    int m;
    do
    {
      do
      {
        for (;;)
        {
          k = i;
          if (i + 3 >= paramArrayOfByte.length) {
            break label426;
          }
          j = i + 1;
          if ((paramArrayOfByte[i] & 0xFF) != 255) {
            break label433;
          }
          m = paramArrayOfByte[j] & 0xFF;
          if (m != 255) {
            break;
          }
          i = j;
        }
        j += 1;
        i = j;
      } while (m == 216);
      i = j;
    } while (m == 1);
    int k = j;
    if (m != 217) {
      if (m == 218) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i > 8)
      {
        k = pack(paramArrayOfByte, j, 4, false);
        if ((k != 1229531648) && (k != 1296891946))
        {
          LogUtils.e("CameraExif", "Invalid byte order");
          return 0;
          i = pack(paramArrayOfByte, j, 2, false);
          if ((i < 2) || (j + i > paramArrayOfByte.length))
          {
            LogUtils.e("CameraExif", "Invalid length");
            return 0;
          }
          if ((m == 225) && (i >= 8) && (pack(paramArrayOfByte, j + 2, 4, false) == 1165519206) && (pack(paramArrayOfByte, j + 6, 2, false) == 0))
          {
            j += 8;
            i -= 8;
            continue;
          }
          i = j + i;
          break;
        }
        if (k == 1229531648) {}
        for (boolean bool = true;; bool = false)
        {
          k = pack(paramArrayOfByte, j + 4, 4, bool) + 2;
          if ((k >= 10) && (k <= i)) {
            break;
          }
          LogUtils.e("CameraExif", "Invalid offset");
          return 0;
        }
        j += k;
        m = pack(paramArrayOfByte, j - 2, 2, bool);
        i -= k;
        k = j;
        j = i;
        i = m;
        while ((i > 0) && (j >= 12))
        {
          if (pack(paramArrayOfByte, k, 2, bool) == 274)
          {
            switch (pack(paramArrayOfByte, k + 8, 2, bool))
            {
            case 1: 
            case 2: 
            case 4: 
            case 5: 
            case 7: 
            default: 
              LogUtils.i("CameraExif", "Unsupported orientation");
              return 0;
            case 3: 
              return 180;
            case 6: 
              return 90;
            }
            return 270;
          }
          k += 12;
          j -= 12;
          i -= 1;
        }
      }
      LogUtils.i("CameraExif", "Orientation not found");
      return 0;
      label426:
      i = 0;
      j = k;
      continue;
      label433:
      i = 0;
    }
  }
  
  private static double gpsValue2Num(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return 0.0D;
        paramString = paramString.split("/");
      } while ((paramString == null) || (paramString.length <= 0));
      if (paramString.length == 1) {
        return Double.valueOf(paramString[0]).doubleValue();
      }
    } while (Math.abs(Double.valueOf(paramString[1]).doubleValue()) < 0.0001D);
    return Double.valueOf(paramString[0]).doubleValue() / Double.valueOf(paramString[1]).doubleValue();
  }
  
  public static void incExifData(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        ExifInterface localExifInterface = new ExifInterface(paramString);
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        String str = localExifInterface.getAttribute("DateTime");
        if (!TextUtils.isEmpty(str))
        {
          l = localSimpleDateFormat.parse(str).getTime();
          paramString = localSimpleDateFormat.format(Long.valueOf(l + paramInt * 1000));
          localExifInterface.setAttribute("DateTime", paramString);
          localExifInterface.saveAttributes();
          LogUtils.d("ExifUtils", "date written %s", new Object[] { paramString });
          return;
        }
      }
      catch (Exception paramString)
      {
        LogUtils.e(paramString);
        return;
      }
      long l = new File(paramString).lastModified();
    }
  }
  
  private static int pack(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = 1;
    int i = paramInt1;
    if (paramBoolean)
    {
      i = paramInt1 + (paramInt2 - 1);
      j = -1;
    }
    paramInt1 = 0;
    while (paramInt2 > 0)
    {
      paramInt1 = paramInt1 << 8 | paramArrayOfByte[i] & 0xFF;
      i += j;
      paramInt2 -= 1;
    }
    return paramInt1;
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
    int j;
    int m;
    do
    {
      do
      {
        for (;;)
        {
          k = i;
          if (i + 3 >= paramArrayOfByte.length) {
            break label453;
          }
          j = i + 1;
          if ((paramArrayOfByte[i] & 0xFF) != 255) {
            break label461;
          }
          m = paramArrayOfByte[j] & 0xFF;
          if (m != 255) {
            break;
          }
          i = j;
        }
        j += 1;
        i = j;
      } while (m == 216);
      i = j;
    } while (m == 1);
    int k = j;
    if (m != 217) {
      if (m == 218) {
        i = 0;
      }
    }
    for (;;)
    {
      if (i > 8)
      {
        k = pack(paramArrayOfByte, j, 4, false);
        if ((k != 1229531648) && (k != 1296891946))
        {
          LogUtils.e("CameraExif", "Invalid byte order");
          return 0;
          i = pack(paramArrayOfByte, j, 2, false);
          if ((i < 2) || (j + i > paramArrayOfByte.length))
          {
            LogUtils.e("CameraExif", "Invalid length");
            return 0;
          }
          if ((m == 225) && (i >= 8) && (pack(paramArrayOfByte, j + 2, 4, false) == 1165519206) && (pack(paramArrayOfByte, j + 6, 2, false) == 0))
          {
            j += 8;
            i -= 8;
            continue;
          }
          i = j + i;
          break;
        }
        if (k == 1229531648) {}
        for (boolean bool = true;; bool = false)
        {
          k = pack(paramArrayOfByte, j + 4, 4, bool) + 2;
          if ((k >= 10) && (k <= i)) {
            break;
          }
          LogUtils.e("CameraExif", "Invalid offset");
          return 0;
        }
        j += k;
        m = pack(paramArrayOfByte, j - 2, 2, bool);
        k = i - k;
        i = j;
        j = m;
        while ((j > 0) && (k >= 12))
        {
          if (pack(paramArrayOfByte, i, 2, bool) == 274)
          {
            switch (paramInt)
            {
            default: 
              paramInt = 0;
            }
            for (;;)
            {
              write(paramArrayOfByte, i + 8, paramInt, 2, bool);
              LogUtils.i("CameraExif", "Unsupported orientation");
              return 0;
              paramInt = 0;
              continue;
              paramInt = 3;
              continue;
              paramInt = 6;
              continue;
              paramInt = 8;
            }
          }
          i += 12;
          k -= 12;
          j -= 1;
        }
      }
      LogUtils.i("CameraExif", "Orientation not found");
      return 0;
      label453:
      i = 0;
      j = k;
      continue;
      label461:
      i = 0;
    }
  }
  
  private static void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int k = 1;
    int i = paramInt1;
    int m = paramInt2;
    int j = paramInt3;
    if (paramBoolean)
    {
      i = paramInt1 + (paramInt3 - 1);
      k = -1;
      j = paramInt3;
      m = paramInt2;
    }
    while (j > 0)
    {
      paramArrayOfByte[i] = ((byte)(m & 0xFF));
      m >>= 8;
      i += k;
      j -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.bitmap.ExifUtils
 * JD-Core Version:    0.7.0.1
 */