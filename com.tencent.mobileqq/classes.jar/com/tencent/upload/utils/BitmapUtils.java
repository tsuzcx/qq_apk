package com.tencent.upload.utils;

import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.uinterface.IUploadConfig;
import java.lang.reflect.Field;

public final class BitmapUtils
{
  public static BitmapFactory.Options getOptions()
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    if ((Build.VERSION.SDK_INT < 11) && (UploadGlobalConfig.getConfig() != null) && (UploadGlobalConfig.getConfig().enableBitmapNativeAlloc())) {
      setBitmapOptionInNativeAlloc(localOptions);
    }
    return localOptions;
  }
  
  public static void setBitmapOptionInNativeAlloc(Object paramObject)
  {
    try
    {
      Field localField = paramObject.getClass().getDeclaredField("inNativeAlloc");
      localField.setAccessible(true);
      localField.setBoolean(paramObject, true);
      return;
    }
    catch (Throwable paramObject)
    {
      UploadLog.i("BitmapUtils", "setBitmapOptionInNativeAlloc :", paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.upload.utils.BitmapUtils
 * JD-Core Version:    0.7.0.1
 */