package com.tencent.util;

import java.io.IOException;
import java.io.InputStream;

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
  
  public static int getOrientation(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return 0;
    }
    byte[] arrayOfByte = new byte[8];
    for (;;)
    {
      j = 0;
      i = j;
      if (read(paramInputStream, arrayOfByte, 2))
      {
        i = j;
        if ((arrayOfByte[0] & 0xFF) == 255)
        {
          k = arrayOfByte[1] & 0xFF;
          if ((k == 255) || (k == 216) || (k == 1)) {
            continue;
          }
          if ((k == 217) || (k == 218)) {
            return 0;
          }
          if (!read(paramInputStream, arrayOfByte, 2)) {
            return 0;
          }
          i = pack(arrayOfByte, 0, 2, false);
          if (i < 2)
          {
            LogUtil.e("CameraExif", "Invalid length");
            return 0;
          }
          j = i - 2;
          i = j;
          if (k != 225) {
            break label214;
          }
          i = j;
          if (j < 6) {
            break label214;
          }
          if (!read(paramInputStream, arrayOfByte, 6)) {
            return 0;
          }
          j -= 6;
          i = j;
          if (pack(arrayOfByte, 0, 4, false) != 1165519206) {
            break label214;
          }
          i = j;
          if (pack(arrayOfByte, 4, 2, false) != 0) {
            break label214;
          }
          i = j;
        }
      }
      if (i <= 8) {
        break label452;
      }
      arrayOfByte = new byte[i];
      if (!read(paramInputStream, arrayOfByte, i))
      {
        return 0;
        label214:
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
    int j = pack(arrayOfByte, 0, 4, false);
    if ((j != 1229531648) && (j != 1296891946))
    {
      LogUtil.e("CameraExif", "Invalid byte order");
      return 0;
    }
    if (j == 1229531648) {}
    for (boolean bool = true;; bool = false)
    {
      j = pack(arrayOfByte, 4, 4, bool) + 2;
      if ((j >= 10) && (j <= i)) {
        break;
      }
      LogUtil.e("CameraExif", "Invalid offset");
      return 0;
    }
    int k = 0 + j;
    j = i - j;
    int i = pack(arrayOfByte, k - 2, 2, bool);
    while ((i > 0) && (j >= 12))
    {
      if (pack(arrayOfByte, k, 2, bool) == 274)
      {
        switch (pack(arrayOfByte, k + 8, 2, bool))
        {
        case 2: 
        case 4: 
        case 5: 
        case 7: 
        default: 
          LogUtil.i("CameraExif", "Unsupported orientation");
          return 0;
        case 1: 
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
    label452:
    LogUtil.i("CameraExif", "Orientation not found");
    return 0;
  }
  
  public static int getOrientation(byte[] paramArrayOfByte)
  {
    boolean bool = true;
    if (paramArrayOfByte == null) {
      return 0;
    }
    int i = 0;
    int n;
    int i1;
    int m;
    do
    {
      do
      {
        for (;;)
        {
          n = 0;
          k = n;
          j = i;
          if (i + 3 >= paramArrayOfByte.length) {
            break label119;
          }
          j = i + 1;
          if ((paramArrayOfByte[i] & 0xFF) != 255) {
            break label460;
          }
          i1 = paramArrayOfByte[j] & 0xFF;
          if (i1 != 255) {
            break;
          }
          i = j;
        }
        m = j + 1;
        i = m;
      } while (i1 == 216);
      i = m;
    } while (i1 == 1);
    int k = n;
    int j = m;
    if (i1 != 217)
    {
      if (i1 != 218) {
        break label155;
      }
      j = m;
      k = n;
    }
    for (;;)
    {
      label119:
      if (k > 8)
      {
        i = pack(paramArrayOfByte, j, 4, false);
        if ((i != 1229531648) && (i != 1296891946))
        {
          LogUtil.e("CameraExif", "Invalid byte order");
          return 0;
          i = pack(paramArrayOfByte, m, 2, false);
          if ((i < 2) || (m + i > paramArrayOfByte.length))
          {
            LogUtil.e("CameraExif", "Invalid length");
            return 0;
          }
          if ((i1 == 225) && (i >= 8) && (pack(paramArrayOfByte, m + 2, 4, false) == 1165519206) && (pack(paramArrayOfByte, m + 6, 2, false) == 0))
          {
            j = m + 8;
            k = i - 8;
            continue;
          }
          i = m + i;
          break;
        }
        if (i == 1229531648) {}
        for (;;)
        {
          m = pack(paramArrayOfByte, j + 4, 4, bool) + 2;
          if ((m >= 10) && (m <= k)) {
            break;
          }
          LogUtil.e("CameraExif", "Invalid offset");
          return 0;
          bool = false;
        }
        i = j + m;
        j = k - m;
        m = pack(paramArrayOfByte, i - 2, 2, bool);
        k = i;
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
              LogUtil.i("CameraExif", "Unsupported orientation");
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
      label155:
      LogUtil.i("CameraExif", "Orientation not found");
      return 0;
      label460:
      k = n;
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
    int n;
    int i1;
    int m;
    do
    {
      do
      {
        for (;;)
        {
          n = 0;
          k = n;
          j = i;
          if (i + 3 >= paramArrayOfByte.length) {
            break label119;
          }
          j = i + 1;
          if ((paramArrayOfByte[i] & 0xFF) != 255) {
            break label475;
          }
          i1 = paramArrayOfByte[j] & 0xFF;
          if (i1 != 255) {
            break;
          }
          i = j;
        }
        m = j + 1;
        i = m;
      } while (i1 == 216);
      i = m;
    } while (i1 == 1);
    int k = n;
    int j = m;
    if (i1 != 217)
    {
      if (i1 != 218) {
        break label156;
      }
      j = m;
      k = n;
    }
    for (;;)
    {
      label119:
      if (k > 8)
      {
        i = pack(paramArrayOfByte, j, 4, false);
        if ((i != 1229531648) && (i != 1296891946))
        {
          LogUtil.e("CameraExif", "Invalid byte order");
          return 0;
          i = pack(paramArrayOfByte, m, 2, false);
          if ((i < 2) || (m + i > paramArrayOfByte.length))
          {
            LogUtil.e("CameraExif", "Invalid length");
            return 0;
          }
          if ((i1 == 225) && (i >= 8) && (pack(paramArrayOfByte, m + 2, 4, false) == 1165519206) && (pack(paramArrayOfByte, m + 6, 2, false) == 0))
          {
            j = m + 8;
            k = i - 8;
            continue;
          }
          i = m + i;
          break;
        }
        if (i == 1229531648) {}
        for (boolean bool = true;; bool = false)
        {
          m = pack(paramArrayOfByte, j + 4, 4, bool) + 2;
          if ((m >= 10) && (m <= k)) {
            break;
          }
          LogUtil.e("CameraExif", "Invalid offset");
          return 0;
        }
        i = j + m;
        k -= m;
        j = pack(paramArrayOfByte, i - 2, 2, bool);
        while ((j > 0) && (k >= 12))
        {
          if (pack(paramArrayOfByte, i, 2, bool) == 274)
          {
            j = 0;
            switch (paramInt)
            {
            default: 
              paramInt = j;
            }
            for (;;)
            {
              write(paramArrayOfByte, i + 8, paramInt, 2, bool);
              LogUtil.i("CameraExif", "Unsupported orientation");
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
      label156:
      LogUtil.i("CameraExif", "Orientation not found");
      return 0;
      label475:
      k = n;
    }
  }
  
  private static void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i = 1;
    if (paramBoolean)
    {
      paramInt1 += paramInt3 - 1;
      i = -1;
    }
    for (;;)
    {
      if (paramInt3 > 0)
      {
        paramArrayOfByte[paramInt1] = ((byte)(paramInt2 & 0xFF));
        paramInt2 >>= 8;
        paramInt1 += i;
        paramInt3 -= 1;
      }
      else
      {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.util.ExifUtils
 * JD-Core Version:    0.7.0.1
 */