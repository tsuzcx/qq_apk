package com.tencent.tkd.topicsdk.imagecompress;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.util.Log;
import java.io.File;
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
    for (;;)
    {
      j = i;
      if (i + 3 >= paramArrayOfByte.length) {
        break;
      }
      int k = i + 1;
      j = k;
      if ((paramArrayOfByte[i] & 0xFF) != 255) {
        break;
      }
      int m = paramArrayOfByte[k] & 0xFF;
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
                  break label228;
                }
                continue;
              }
            }
            Log.e("Luban", "Invalid length");
            return 0;
          }
        }
      }
    }
    i = 0;
    label228:
    if (i > 8) {
      return parseJpegOrientation(i, j, paramArrayOfByte);
    }
    Log.e("Luban", "Orientation not found");
    return 0;
  }
  
  private boolean isJPG(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length < 3) {
        return false;
      }
      int i = paramArrayOfByte[0];
      int j = paramArrayOfByte[1];
      int k = paramArrayOfByte[2];
      return Arrays.equals(JPEG_SIGNATURE, new byte[] { i, j, k });
    }
    return false;
  }
  
  private int pack(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
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
  
  private int parseJpegOrientation(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    int i = pack(paramArrayOfByte, paramInt2, 4, false);
    if ((i != 1229531648) && (i != 1296891946))
    {
      Log.e("Luban", "Invalid byte order");
      return 0;
    }
    boolean bool;
    if (i == 1229531648) {
      bool = true;
    } else {
      bool = false;
    }
    int j = pack(paramArrayOfByte, paramInt2 + 4, 4, bool) + 2;
    if ((j >= 10) && (j <= paramInt1))
    {
      i = paramInt2 + j;
      paramInt2 = paramInt1 - j;
      paramInt1 = pack(paramArrayOfByte, i - 2, 2, bool);
      while ((paramInt1 > 0) && (paramInt2 >= 12))
      {
        if (pack(paramArrayOfByte, i, 2, bool) == 274)
        {
          paramInt1 = pack(paramArrayOfByte, i + 8, 2, bool);
          if (paramInt1 != 1)
          {
            if (paramInt1 != 3)
            {
              if (paramInt1 != 6)
              {
                if (paramInt1 != 8)
                {
                  Log.e("Luban", "Unsupported orientation");
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
        i += 12;
        paramInt2 -= 12;
        paramInt1 -= 1;
      }
      Log.e("Luban", "Orientation not found");
      return 0;
    }
    Log.e("Luban", "Invalid offset");
    return 0;
  }
  
  /* Error */
  private byte[] toByteArray(InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +7 -> 8
    //   4: iconst_0
    //   5: newarray byte
    //   7: areturn
    //   8: new 81	java/io/ByteArrayOutputStream
    //   11: dup
    //   12: invokespecial 83	java/io/ByteArrayOutputStream:<init>	()V
    //   15: astore_3
    //   16: sipush 4096
    //   19: newarray byte
    //   21: astore 4
    //   23: aload_1
    //   24: aload 4
    //   26: iconst_0
    //   27: aload 4
    //   29: arraylength
    //   30: invokevirtual 89	java/io/InputStream:read	([BII)I
    //   33: istore_2
    //   34: iload_2
    //   35: iconst_m1
    //   36: if_icmpeq +14 -> 50
    //   39: aload_3
    //   40: aload 4
    //   42: iconst_0
    //   43: iload_2
    //   44: invokevirtual 93	java/io/ByteArrayOutputStream:write	([BII)V
    //   47: goto -24 -> 23
    //   50: aload_3
    //   51: invokevirtual 96	java/io/ByteArrayOutputStream:close	()V
    //   54: goto +13 -> 67
    //   57: astore_1
    //   58: ldc 18
    //   60: aload_1
    //   61: invokevirtual 100	java/io/IOException:toString	()Ljava/lang/String;
    //   64: invokestatic 106	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_3
    //   68: invokevirtual 109	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   71: areturn
    //   72: astore_1
    //   73: goto +25 -> 98
    //   76: iconst_0
    //   77: newarray byte
    //   79: astore_1
    //   80: aload_3
    //   81: invokevirtual 96	java/io/ByteArrayOutputStream:close	()V
    //   84: aload_1
    //   85: areturn
    //   86: astore_3
    //   87: ldc 18
    //   89: aload_3
    //   90: invokevirtual 100	java/io/IOException:toString	()Ljava/lang/String;
    //   93: invokestatic 106	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_1
    //   97: areturn
    //   98: aload_3
    //   99: invokevirtual 96	java/io/ByteArrayOutputStream:close	()V
    //   102: goto +13 -> 115
    //   105: astore_3
    //   106: ldc 18
    //   108: aload_3
    //   109: invokevirtual 100	java/io/IOException:toString	()Ljava/lang/String;
    //   112: invokestatic 106	com/tencent/tkd/topicsdk/framework/TLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: goto +5 -> 120
    //   118: aload_1
    //   119: athrow
    //   120: goto -2 -> 118
    //   123: astore_1
    //   124: goto -48 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	Checker
    //   0	127	1	paramInputStream	InputStream
    //   33	11	2	i	int
    //   15	66	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   86	13	3	localIOException1	java.io.IOException
    //   105	4	3	localIOException2	java.io.IOException
    //   21	20	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   50	54	57	java/io/IOException
    //   23	34	72	finally
    //   39	47	72	finally
    //   76	80	72	finally
    //   80	84	86	java/io/IOException
    //   98	102	105	java/io/IOException
    //   23	34	123	java/lang/Exception
    //   39	47	123	java/lang/Exception
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
    catch (Exception paramInputStreamProvider)
    {
      label39:
      break label39;
    }
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
    boolean bool = true;
    if (paramInt > 0)
    {
      paramString = new File(paramString);
      if ((paramString.exists()) && (paramString.length() > paramInt << 10)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.Checker
 * JD-Core Version:    0.7.0.1
 */