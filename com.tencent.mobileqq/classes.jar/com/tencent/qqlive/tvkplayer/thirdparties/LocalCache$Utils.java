package com.tencent.qqlive.tvkplayer.thirdparties;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.io.ByteArrayOutputStream;

class LocalCache$Utils
{
  private static final char mSeparator = ' ';
  
  private static byte[] bitmap2Bytes(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  private static Drawable bitmap2Drawable(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    return new BitmapDrawable(paramBitmap);
  }
  
  private static Bitmap bytes2Bitmap(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 0) {}
    return null;
  }
  
  private static String clearDateInfo(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (hasDateInfo(paramString.getBytes())) {
        str = paramString.substring(paramString.indexOf(' ') + 1, paramString.length());
      }
    }
    return str;
  }
  
  private static byte[] clearDateInfo(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (hasDateInfo(paramArrayOfByte)) {
      arrayOfByte = copyOfRange(paramArrayOfByte, indexOf(paramArrayOfByte, ' ') + 1, paramArrayOfByte.length);
    }
    return arrayOfByte;
  }
  
  private static byte[] copyOfRange(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt2 - paramInt1;
    if (i >= 0)
    {
      byte[] arrayOfByte = new byte[i];
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, Math.min(paramArrayOfByte.length - paramInt1, i));
      return arrayOfByte;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append(paramInt1);
    paramArrayOfByte.append(" > ");
    paramArrayOfByte.append(paramInt2);
    throw new IllegalArgumentException(paramArrayOfByte.toString());
  }
  
  private static String createDateInfo(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append("");
    for (localObject = ((StringBuilder)localObject).toString(); ((String)localObject).length() < 13; localObject = localStringBuilder.toString())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("0");
      localStringBuilder.append((String)localObject);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("-");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(' ');
    return localStringBuilder.toString();
  }
  
  private static Bitmap drawable2Bitmap(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {
      localObject = Bitmap.Config.ARGB_8888;
    } else {
      localObject = Bitmap.Config.RGB_565;
    }
    Object localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    paramDrawable.setBounds(0, 0, i, j);
    paramDrawable.draw(localCanvas);
    return localObject;
  }
  
  private static String[] getDateInfoFromDate(byte[] paramArrayOfByte)
  {
    if (hasDateInfo(paramArrayOfByte)) {
      return new String[] { new String(copyOfRange(paramArrayOfByte, 0, 13)), new String(copyOfRange(paramArrayOfByte, 14, indexOf(paramArrayOfByte, ' '))) };
    }
    return null;
  }
  
  private static boolean hasDateInfo(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length > 15) && (paramArrayOfByte[13] == 45) && (indexOf(paramArrayOfByte, ' ') > 14);
  }
  
  private static int indexOf(byte[] paramArrayOfByte, char paramChar)
  {
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      if (paramArrayOfByte[i] == paramChar) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  private static boolean isDue(String paramString)
  {
    return isDue(paramString.getBytes());
  }
  
  private static boolean isDue(byte[] paramArrayOfByte)
  {
    String[] arrayOfString = getDateInfoFromDate(paramArrayOfByte);
    if ((arrayOfString != null) && (arrayOfString.length == 2)) {
      for (paramArrayOfByte = arrayOfString[0]; paramArrayOfByte.startsWith("0"); paramArrayOfByte = paramArrayOfByte.substring(1, paramArrayOfByte.length())) {}
    }
    try
    {
      long l1 = Long.valueOf(paramArrayOfByte).longValue();
      long l2 = Long.valueOf(arrayOfString[1]).longValue();
      long l3 = System.currentTimeMillis();
      return l3 > l1 + l2 * 1000L;
    }
    catch (Exception paramArrayOfByte) {}
    return false;
  }
  
  private static byte[] newByteArrayWithDateInfo(int paramInt, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = createDateInfo(paramInt).getBytes();
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramArrayOfByte.length];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, arrayOfByte1.length, paramArrayOfByte.length);
    return arrayOfByte2;
  }
  
  private static String newStringWithDateInfo(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(createDateInfo(paramInt));
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.thirdparties.LocalCache.Utils
 * JD-Core Version:    0.7.0.1
 */