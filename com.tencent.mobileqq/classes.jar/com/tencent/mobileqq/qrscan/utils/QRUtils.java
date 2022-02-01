package com.tencent.mobileqq.qrscan.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class QRUtils
{
  public static long a(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length;
    long l = 0L;
    int i = 0;
    while (i < j)
    {
      l += ((paramArrayOfByte[(j - i - 1)] & 0xFF) << i * 8);
      i += 1;
    }
    return l;
  }
  
  public static short a(byte[] paramArrayOfByte)
  {
    return (short)(((paramArrayOfByte[0] & 0xFF) << 8) + (paramArrayOfByte[1] & 0xFF));
  }
  
  public static void a(Context paramContext)
  {
    if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
      return;
    }
    try
    {
      Object localObject1 = Class.forName("android.gestureboost.GestureBoostManager");
      Object localObject2 = ((Class)localObject1).getDeclaredField("sGestureBoostManager");
      ((Field)localObject2).setAccessible(true);
      localObject2 = ((Field)localObject2).get(localObject1);
      localObject1 = ((Class)localObject1).getDeclaredField("mContext");
      ((Field)localObject1).setAccessible(true);
      if (((Field)localObject1).get(localObject2) == paramContext)
      {
        ((Field)localObject1).set(localObject2, null);
        return;
      }
    }
    catch (Throwable paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScannerUtils", 2, paramContext.getMessage());
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x1) == 1;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.contains("app_name=qim");
  }
  
  public static byte[] a(long paramLong)
  {
    return new byte[] { (byte)(int)(paramLong >>> 56), (byte)(int)(paramLong >>> 48), (byte)(int)(paramLong >>> 40), (byte)(int)(paramLong >>> 32), (byte)(int)(paramLong >>> 24), (byte)(int)(paramLong >>> 16), (byte)(int)(paramLong >>> 8), (byte)(int)paramLong };
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt & 0x2) == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.utils.QRUtils
 * JD-Core Version:    0.7.0.1
 */