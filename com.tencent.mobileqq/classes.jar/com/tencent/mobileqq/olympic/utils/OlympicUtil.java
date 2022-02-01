package com.tencent.mobileqq.olympic.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.AppIntefaceReportWrap;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.InflaterInputStream;

public class OlympicUtil
{
  static SimpleDateFormat a;
  private static int b = -1;
  private static int c = -1;
  
  public static long a(String paramString)
  {
    if (a == null)
    {
      a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      a.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    long l2 = -1L;
    long l1;
    try
    {
      l1 = a.parse(paramString).getTime();
    }
    catch (ParseException localParseException)
    {
      l1 = l2;
      if (QLog.isColorLevel())
      {
        QLog.d("OlympicUtil", 2, "", localParseException);
        l1 = l2;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("data2Millis, date = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",millionSeconds = ");
      localStringBuilder.append(l1);
      QLog.d("OlympicUtil", 2, localStringBuilder.toString());
    }
    return l1;
  }
  
  public static Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    if ((paramBitmap != null) && (paramFloat != 1.0F) && (paramBitmap.getWidth() > 0))
    {
      if (paramBitmap.getHeight() <= 0) {
        return paramBitmap;
      }
      Object localObject = new Matrix();
      ((Matrix)localObject).postScale(paramFloat, paramFloat);
      try
      {
        localObject = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), (Matrix)localObject, true);
        return localObject;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.e("OlympicUtil", 2, "scaleBitmap,", localOutOfMemoryError);
        }
      }
    }
    return paramBitmap;
  }
  
  public static void a(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    a(paramAppInterface, paramString, paramInt, "");
  }
  
  public static void a(AppInterface paramAppInterface, String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    AppIntefaceReportWrap.a(paramAppInterface, "CliOper", "", paramString2, paramString1, paramString1, 0, 0, localStringBuilder.toString(), "", "", "");
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString, 2, paramVarArgs);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    BaseApplicationImpl.getContext().getSharedPreferences("olympic", 0).edit().putBoolean("dpc_ar_entrance", paramBoolean).commit();
  }
  
  public static boolean a()
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("olympic", 0).getBoolean("dpc_ar_entrance", true);
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      paramArrayOfByte = new InflaterInputStream(new ByteArrayInputStream(paramArrayOfByte));
      byte[] arrayOfByte = new byte[256];
      for (;;)
      {
        int i = paramArrayOfByte.read(arrayOfByte);
        if (-1 == i) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      paramArrayOfByte = localByteArrayOutputStream.toByteArray();
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("OlympicUtil", 2, "inflateConfigString");
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (paramString.startsWith("http://hb.url.cn/myapp/qq_desk/")) {
      return paramString.substring(31);
    }
    String str = paramString;
    if (paramString.startsWith("http://")) {
      str = paramString.substring(7);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.utils.OlympicUtil
 * JD-Core Version:    0.7.0.1
 */