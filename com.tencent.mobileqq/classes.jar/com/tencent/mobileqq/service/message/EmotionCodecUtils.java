package com.tencent.mobileqq.service.message;

import android.text.TextUtils;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import java.nio.ByteBuffer;

public class EmotionCodecUtils
{
  @Deprecated
  public static final short[] a = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 34, 41, 20, 44, 22, 10, 21, 107, 36, 251, 26, 25, 2, 1, 24, 0, 70, 0, 0, 0, 0, 48, 0, 96, 0, 72, 97, 39, 0, 78, 0, 0, 61, 9, 58, 0, 29, 75, 60, 77, 0, 0, 76, 0, 0, 69, 53, 54, 0, 0, 33, 13, 0, 14, 23, 27, 3, 38, 51, 8, 0, 0, 46, 67, 59, 0, 0, 0, 0, 0, 0, 55, 16, 4, 19, 31, 32, 82, 83, 43, 84, 35, 12, 50, 85, 40, 79, 6, 5, 68, 0, 81, 17, 71, 0, 56, 28, 7, 86, 87, 88, 47, 89, 45, 90, 49, 15, 91, 42, 37, 92, 52, 18, 62, 93, 94, 30, 63, 57, 64, 74, 73, 66, 95, 65, 98, 99, 100, 101, 80, 102, 103, 104, 105, 106, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  @Deprecated
  public static final short[] b = { 13, 12, 56, 73, 88, 87, 97, 59, 33, 5, 9, 82, 51, 53, 106, 72, 92, 112, 74, 2, 6, 4, 54, 14, 11, 10, 55, 96, 36, 116, 75, 76, 50, 0, 81, 8, 109, 57, 27, 85, 1, 108, 79, 3, 103, 62, 101, 21, 105, 83, 58, 111, 46, 47, 71, 95, 118, 34, 64, 38, 32, 113, 117, 119, 124, 122, 63, 89, 45, 16, 93, 25, 121, 120, 37, 42, 39, 29, 86, 129, 91, 77, 78, 80, 84, 98, 99, 100, 102, 104, 107, 110, 114, 115, 123, 23, 26, 125, 126, 127, 128, 130, 131, 132, 133, 134, 7, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 9 };
  
  static int a(char paramChar, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramChar < '')
    {
      paramArrayOfByte[(paramInt + 0)] = ((byte)paramChar);
      return 1;
    }
    if (paramChar < 'ࠀ')
    {
      paramArrayOfByte[(paramInt + 0)] = ((byte)(paramChar >> '\006' & 0x1F | 0xC0));
      paramArrayOfByte[(paramInt + 1)] = ((byte)(paramChar & 0x3F | 0x80));
      return 2;
    }
    paramArrayOfByte[(paramInt + 0)] = ((byte)(paramChar >> '\f' & 0xF | 0xE0));
    paramArrayOfByte[(paramInt + 1)] = ((byte)(paramChar >> '\006' & 0x3F | 0x80));
    paramArrayOfByte[(paramInt + 2)] = ((byte)(paramChar & 0x3F | 0x80));
    return 3;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j;
    for (int i = 0; i < paramString.length(); i = j + 1)
    {
      if (paramString.charAt(i) == '\024')
      {
        int k = i + 1;
        if (k < paramString.length())
        {
          int m = QQSysFaceUtil.convertToServer(paramString.charAt(k));
          j = i;
          if (m < 0) {
            continue;
          }
          localStringBuilder.append(paramString.charAt(i));
          localStringBuilder.append((char)(m / 128 + 65));
          localStringBuilder.append((char)(m % 128 + 65));
          j = k;
          continue;
        }
      }
      localStringBuilder.append(paramString.charAt(i));
      j = i;
    }
    return localStringBuilder.toString();
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j;
      if (paramArrayOfByte[i] != 20)
      {
        if (paramArrayOfByte[i] == 13)
        {
          if ((i > 0) && (paramArrayOfByte[(i - 1)] == 20))
          {
            localByteBuffer.put(paramArrayOfByte[i]);
          }
          else
          {
            j = i + 1;
            if (j < paramArrayOfByte.length)
            {
              if (paramArrayOfByte[j] != 10) {
                localByteBuffer.put((byte)10);
              }
            }
            else {
              localByteBuffer.put((byte)10);
            }
          }
        }
        else {
          localByteBuffer.put(paramArrayOfByte[i]);
        }
      }
      else
      {
        j = i + 1;
        int k = (short)(paramArrayOfByte[j] & 0xFF);
        localByteBuffer.put(paramArrayOfByte[i]);
        short[] arrayOfShort = a;
        if (arrayOfShort[k] > 0)
        {
          i = arrayOfShort[k] - 1;
          if (i < 128)
          {
            localByteBuffer.put((byte)i);
          }
          else
          {
            localByteBuffer.put((byte)(i >> 6 & 0x1F | 0xC0));
            localByteBuffer.put((byte)(i >> 0 & 0x3F | 0x80));
          }
          i = j;
        }
      }
      i += 1;
    }
    paramArrayOfByte = new byte[localByteBuffer.position()];
    localByteBuffer.flip();
    localByteBuffer.get(paramArrayOfByte);
    return paramArrayOfByte;
  }
  
  public static byte[] b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    int m = paramString.length();
    byte[] arrayOfByte = new byte[m << 2];
    int k = 0;
    int j = 0;
    while (k < m)
    {
      int i = paramString.charAt(k);
      if (i != 20)
      {
        j += a(i, arrayOfByte, j);
      }
      else
      {
        int n = j + 1;
        arrayOfByte[j] = ((byte)i);
        j = k + 1;
        i = paramString.charAt(j);
        short[] arrayOfShort = b;
        if (i >= arrayOfShort.length)
        {
          j = n + a(i, arrayOfByte, n);
        }
        else
        {
          arrayOfByte[n] = ((byte)(char)(arrayOfShort[i] + 65));
          k = j;
          j = n + 1;
        }
      }
      k += 1;
    }
    paramString = new byte[j];
    System.arraycopy(arrayOfByte, 0, paramString, 0, j);
    return paramString;
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      if (paramString.charAt(i) == '\024')
      {
        int k = i + 2;
        if (k < paramString.length())
        {
          int j = i + 1;
          k = (paramString.charAt(j) - 'A') * 128 + paramString.charAt(k) - 65;
          if (k < 0) {
            break label123;
          }
          localStringBuilder.append(String.valueOf(new char[] { '\024', (char)QQSysFaceUtil.convertToLocal(k) }));
          i = j + 1;
          break label123;
        }
      }
      localStringBuilder.append(paramString.charAt(i));
      label123:
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.EmotionCodecUtils
 * JD-Core Version:    0.7.0.1
 */