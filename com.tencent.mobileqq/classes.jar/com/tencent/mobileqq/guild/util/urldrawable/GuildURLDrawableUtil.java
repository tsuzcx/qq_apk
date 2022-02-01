package com.tencent.mobileqq.guild.util.urldrawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.utils.StackBlur;

public class GuildURLDrawableUtil
{
  public static Drawable a(Resources paramResources, Drawable paramDrawable, @NonNull Bitmap.Config paramConfig, int paramInt)
  {
    if (paramResources == null) {
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
    }
    else
    {
      if ((paramDrawable instanceof URLDrawable))
      {
        paramDrawable = ((URLDrawable)paramDrawable).getCurrDrawable();
        if ((paramDrawable instanceof RegionDrawable))
        {
          paramDrawable = ((RegionDrawable)paramDrawable).getBitmap();
          break label59;
        }
      }
      paramDrawable = null;
    }
    label59:
    if (paramDrawable == null) {
      return null;
    }
    paramDrawable = paramDrawable.copy(paramConfig, true);
    StackBlur.a(paramDrawable, paramInt);
    return new BitmapDrawable(paramResources, paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.urldrawable.GuildURLDrawableUtil
 * JD-Core Version:    0.7.0.1
 */