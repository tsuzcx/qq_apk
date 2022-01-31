package com.tencent.upload.e;

import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.tencent.upload.common.b;
import com.tencent.upload.uinterface.IUploadConfig;
import java.lang.reflect.Field;

public final class a
{
  public static BitmapFactory.Options a()
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    if ((Build.VERSION.SDK_INT < 11) && (com.tencent.upload.common.a.b() != null) && (com.tencent.upload.common.a.b().enableBitmapNativeAlloc())) {
      a(localOptions);
    }
    return localOptions;
  }
  
  public static void a(Object paramObject)
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
      b.a("BitmapUtils", "setBitmapOptionInNativeAlloc :", paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.e.a
 * JD-Core Version:    0.7.0.1
 */