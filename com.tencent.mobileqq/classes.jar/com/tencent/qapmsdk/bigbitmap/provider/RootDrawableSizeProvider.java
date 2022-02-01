package com.tencent.qapmsdk.bigbitmap.provider;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import com.tencent.qapmsdk.bigbitmap.datainfo.DrawableInfo;
import com.tencent.qapmsdk.common.logger.Logger;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class RootDrawableSizeProvider
  extends AbstractDrawableSizeProvider
{
  private static final int ACTUAL_IMAGE_INDEX = 2;
  private static final int BACKGROUND_IMAGE_INDEX = 0;
  private static final int FAILURE_IMAGE_INDEX = 5;
  private static final int OVERLAY_IMAGES_INDEX = 6;
  private static final int PLACEHOLDER_IMAGE_INDEX = 1;
  private static final int PROGRESS_BAR_IMAGE_INDEX = 3;
  private static final int RETRY_IMAGE_INDEX = 4;
  private static final String TAG = "QAPM_bigmap_RootDrawableSizeProvider";
  private static Class<?> fadeDrawableClass;
  private static Method getCurrentMethod;
  private static Field mIsLayerOnField;
  private static Field mLayersField;
  private static Class<?> rootDrawableClass;
  
  static
  {
    try
    {
      rootDrawableClass = Class.forName("com.facebook.drawee.generic.RootDrawable");
      fadeDrawableClass = Class.forName("com.facebook.drawee.drawable.FadeDrawable");
      getCurrentMethod = rootDrawableClass.getMethod("getCurrent", new Class[0]);
      getCurrentMethod.setAccessible(true);
      mIsLayerOnField = fadeDrawableClass.getDeclaredField("mIsLayerOn");
      mIsLayerOnField.setAccessible(true);
      mLayersField = fadeDrawableClass.getDeclaredField("mLayers");
      mLayersField.setAccessible(true);
      return;
    }
    catch (Throwable localThrowable)
    {
      Logger.INSTANCE.w(new String[] { "QAPM_bigmap_RootDrawableSizeProvider", localThrowable.toString() });
    }
  }
  
  @Nullable
  private DrawableInfo getActualDrawableSize(Object paramObject)
  {
    try
    {
      boolean[] arrayOfBoolean = (boolean[])mIsLayerOnField.get(paramObject);
      paramObject = (Drawable[])mLayersField.get(paramObject);
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
      Logger.INSTANCE.w(new String[] { "QAPM_bigmap_RootDrawableSizeProvider", paramObject.toString() });
    }
    return null;
  }
  
  @Nullable
  public DrawableInfo checkBackground(@Nullable Drawable paramDrawable)
  {
    return null;
  }
  
  @Nullable
  public DrawableInfo checkSrc(@Nullable Drawable paramDrawable)
  {
    if ((paramDrawable != null) && (paramDrawable.getClass() == rootDrawableClass)) {
      try
      {
        paramDrawable = (Drawable)getCurrentMethod.invoke(paramDrawable, new Object[0]);
        if ((paramDrawable != null) && (paramDrawable.getClass() == fadeDrawableClass))
        {
          paramDrawable = getActualDrawableSize(paramDrawable);
          return paramDrawable;
        }
      }
      catch (Throwable paramDrawable)
      {
        Logger.INSTANCE.w(new String[] { "QAPM_bigmap_RootDrawableSizeProvider", paramDrawable.toString() });
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.bigbitmap.provider.RootDrawableSizeProvider
 * JD-Core Version:    0.7.0.1
 */