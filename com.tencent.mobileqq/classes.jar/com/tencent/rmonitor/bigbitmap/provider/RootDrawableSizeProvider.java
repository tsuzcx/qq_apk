package com.tencent.rmonitor.bigbitmap.provider;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import com.tencent.rmonitor.bigbitmap.datainfo.DrawableInfo;
import com.tencent.rmonitor.common.logger.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RootDrawableSizeProvider
  extends AbstractDrawableSizeProvider
{
  private static Method a;
  private static Class<?> b;
  private static Class<?> c;
  private static Field d;
  private static Field e;
  
  static
  {
    try
    {
      b = Class.forName("com.facebook.drawee.generic.RootDrawable");
      c = Class.forName("com.facebook.drawee.drawable.FadeDrawable");
      a = b.getMethod("getCurrent", new Class[0]);
      a.setAccessible(true);
      d = c.getDeclaredField("mIsLayerOn");
      d.setAccessible(true);
      e = c.getDeclaredField("mLayers");
      e.setAccessible(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.b.w(new String[] { "RMonitor_bigmap_RootDrawableSizeProvider", localThrowable.toString() });
    }
  }
  
  @Nullable
  private DrawableInfo a(Object paramObject)
  {
    try
    {
      boolean[] arrayOfBoolean = (boolean[])d.get(paramObject);
      paramObject = (Drawable[])e.get(paramObject);
      if ((arrayOfBoolean != null) && (paramObject != null) && (arrayOfBoolean.length == paramObject.length) && (paramObject.length >= 6))
      {
        Object localObject = paramObject[2];
        if ((arrayOfBoolean[2] != 0) && (paramObject[2] != null))
        {
          paramObject = new DrawableInfo(1, localObject.getIntrinsicWidth(), localObject.getIntrinsicHeight());
          return paramObject;
        }
      }
    }
    catch (Throwable paramObject)
    {
      Logger.b.w(new String[] { "RMonitor_bigmap_RootDrawableSizeProvider", paramObject.toString() });
    }
    return null;
  }
  
  @Nullable
  public DrawableInfo a(@Nullable Drawable paramDrawable)
  {
    return null;
  }
  
  @Nullable
  public DrawableInfo b(@Nullable Drawable paramDrawable)
  {
    if ((paramDrawable != null) && (paramDrawable.getClass() == b)) {
      try
      {
        paramDrawable = (Drawable)a.invoke(paramDrawable, new Object[0]);
        if ((paramDrawable != null) && (paramDrawable.getClass() == c))
        {
          paramDrawable = a(paramDrawable);
          return paramDrawable;
        }
      }
      catch (Throwable paramDrawable)
      {
        Logger.b.w(new String[] { "RMonitor_bigmap_RootDrawableSizeProvider", paramDrawable.toString() });
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.bigbitmap.provider.RootDrawableSizeProvider
 * JD-Core Version:    0.7.0.1
 */