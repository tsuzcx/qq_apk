package com.tencent.tkd.topicsdk.imagecompress;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Log;
import com.tencent.tkd.topicsdk.framework.TLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public enum Checker
{
  SINGLE;
  
  private static final byte[] JPEG_SIGNATURE = { -1, -40, -1 };
  private static final String JPG = ".jpg";
  private static final String TAG = "Luban";
  
  private Checker() {}
  
  private int getOrientation(byte[] paramArrayOfByte)
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
            break label220;
          }
          j = i + 1;
          if ((paramArrayOfByte[i] & 0xFF) != 255) {
            break label228;
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
        return parseJpegOrientation(i, j, paramArrayOfByte);
        i = pack(paramArrayOfByte, j, 2, false);
        if ((i < 2) || (j + i > paramArrayOfByte.length))
        {
          Log.e("Luban", "Invalid length");
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
      Log.e("Luban", "Orientation not found");
      return 0;
      label220:
      j = k;
      i = 0;
      continue;
      label228:
      i = 0;
    }
  }
  
  private boolean isJPG(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 3)) {
      return false;
    }
    int i = paramArrayOfByte[0];
    int j = paramArrayOfByte[1];
    int k = paramArrayOfByte[2];
    return Arrays.equals(JPEG_SIGNATURE, new byte[] { i, j, k });
  }
  
  private int pack(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
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
  
  private int parseJpegOrientation(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    int i = pack(paramArrayOfByte, paramInt2, 4, false);
    if ((i != 1229531648) && (i != 1296891946))
    {
      Log.e("Luban", "Invalid byte order");
      return 0;
    }
    if (i == 1229531648) {}
    for (boolean bool = true;; bool = false)
    {
      i = pack(paramArrayOfByte, paramInt2 + 4, 4, bool) + 2;
      if ((i >= 10) && (i <= paramInt1)) {
        break;
      }
      Log.e("Luban", "Invalid offset");
      return 0;
    }
    paramInt2 += i;
    int j = pack(paramArrayOfByte, paramInt2 - 2, 2, bool);
    i = paramInt1 - i;
    paramInt1 = j;
    while ((paramInt1 > 0) && (i >= 12))
    {
      if (pack(paramArrayOfByte, paramInt2, 2, bool) == 274)
      {
        switch (pack(paramArrayOfByte, paramInt2 + 8, 2, bool))
        {
        case 1: 
        case 2: 
        case 4: 
        case 5: 
        case 7: 
        default: 
          Log.e("Luban", "Unsupported orientation");
          return 0;
        case 3: 
          return 180;
        case 6: 
          return 90;
        }
        return 270;
      }
      i -= 12;
      paramInt2 += 12;
      paramInt1 -= 1;
    }
    Log.e("Luban", "Orientation not found");
    return 0;
  }
  
  private byte[] toByteArray(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return new byte[0];
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[4096];
    try
    {
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      try
      {
        localIOException1.close();
        throw paramInputStream;
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          TLog.d("Luban", localIOException2.toString());
        }
      }
    }
    catch (Exception paramInputStream)
    {
      paramInputStream = paramInputStream;
      paramInputStream = new byte[0];
      try
      {
        localByteArrayOutputStream.close();
        return paramInputStream;
      }
      catch (IOException localIOException1)
      {
        TLog.d("Luban", localIOException1.toString());
        return paramInputStream;
      }
      try
      {
        localIOException1.close();
        return localIOException1.toByteArray();
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          TLog.d("Luban", paramInputStream.toString());
        }
      }
    }
    finally {}
  }
  
  String extSuffix(InputStreamProvider paramInputStreamProvider)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeStream(paramInputStreamProvider.a(), null, localOptions);
      paramInputStreamProvider = localOptions.outMimeType.replace("image/", ".");
      return paramInputStreamProvider;
    }
    catch (Exception paramInputStreamProvider) {}
    return ".jpg";
  }
  
  public int getOrientation(InputStream paramInputStream)
  {
    return getOrientation(toByteArray(paramInputStream));
  }
  
  public boolean isJPG(InputStream paramInputStream)
  {
    return isJPG(toByteArray(paramInputStream));
  }
  
  boolean needCompress(int paramInt, String paramString)
  {
    if (paramInt > 0) {
      paramString = new File(paramString);
    }
    return (paramString.exists()) && (paramString.length() > paramInt << 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.Checker
 * JD-Core Version:    0.7.0.1
 */