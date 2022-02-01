package com.tencent.mobileqq.qrscan.utils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IMiniCodeApi;
import com.tencent.mobileqq.qrscan.api.IQRScanTempApi;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.BasePhotoUtils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.io.IOException;
import mqq.app.AppRuntime;

public class Util
{
  public static int a(BitmapFactory.Options paramOptions, int paramInt)
  {
    int k = paramOptions.outWidth;
    int j = 1;
    int i = 1;
    if (k > paramInt)
    {
      k /= 2;
      for (;;)
      {
        j = i;
        if (k / i <= paramInt) {
          break;
        }
        i *= 2;
      }
    }
    return j;
  }
  
  public static Bitmap a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BasePhotoUtils.decodeFileWithBuffer(paramString, localOptions);
      if ((paramInt1 <= 0) && (paramInt2 <= 0)) {
        paramInt1 = 1;
      } else {
        paramInt1 = a(localOptions, paramInt1);
      }
      localOptions.inSampleSize = paramInt1;
      localOptions.inJustDecodeBounds = false;
      paramString = BasePhotoUtils.decodeFileWithBuffer(paramString, localOptions);
      return paramString;
    }
    catch (Exception paramString)
    {
      QZLog.e("Util", 1, new Object[] { "getBitmapFromFile, exception", paramString });
      return null;
    }
    catch (OutOfMemoryError paramString)
    {
      label65:
      break label65;
    }
    QZLog.e("Util", 1, new Object[] { "getBitmapFromFile, OutOfMemoryError" });
    return null;
  }
  
  public static Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = null;
    Object localObject1 = null;
    Object localObject2 = localBitmap;
    try
    {
      int[] arrayOfInt = new int[paramInt1 * paramInt2];
      localObject2 = localBitmap;
      if (((IMiniCodeApi)QRoute.api(IMiniCodeApi.class)).yuv2Rgba(arrayOfInt, paramArrayOfByte, paramInt1, paramInt2) == 0)
      {
        localObject2 = localBitmap;
        localObject1 = Bitmap.createBitmap(arrayOfInt, paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        paramArrayOfByte = new Matrix();
        localObject2 = localObject1;
        paramArrayOfByte.postRotate(90.0F);
        localObject2 = localObject1;
        localBitmap = Bitmap.createBitmap((Bitmap)localObject1, 0, 0, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight(), paramArrayOfByte, true);
        paramArrayOfByte = localBitmap;
        if (localBitmap == localObject1) {
          break label144;
        }
        localObject2 = localObject1;
        ((Bitmap)localObject1).recycle();
        paramArrayOfByte = localBitmap;
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      QLog.i("IQRScanConst_ScannerMultiResultSelectView", 2, "getBitmapFromYuv error ", paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject2;
    }
    label144:
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getBitmapFromYuv bitmap:");
      ((StringBuilder)localObject1).append(paramArrayOfByte);
      QLog.i("IQRScanConst_ScannerMultiResultSelectView", 2, ((StringBuilder)localObject1).toString());
    }
    return paramArrayOfByte;
  }
  
  public static String a(String paramString)
  {
    String str = "";
    System.currentTimeMillis();
    try
    {
      localObject = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      return localObject;
    }
    catch (OutOfMemoryError paramString)
    {
      paramString.printStackTrace();
      return "";
      localObject = new File(paramString);
      paramString = str;
      if (!((File)localObject).exists()) {}
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        try
        {
          Object localObject;
          paramString = MD5FileUtil.a((File)localObject);
          if (paramString == null) {
            paramString = "";
          }
          return paramString;
        }
        catch (IOException paramString) {}
        localUnsatisfiedLinkError = localUnsatisfiedLinkError;
      }
    }
    return "";
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if ((!((IQRScanTempApi)QRoute.api(IQRScanTempApi.class)).isRingerVibrate(paramAppRuntime)) && (!((IQRScanTempApi)QRoute.api(IQRScanTempApi.class)).isRingerSilent(paramAppRuntime)) && (!((IQRScanTempApi)QRoute.api(IQRScanTempApi.class)).isRingEqualsZero(paramAppRuntime))) {
      AudioUtil.b(2131230765, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qrscan.utils.Util
 * JD-Core Version:    0.7.0.1
 */