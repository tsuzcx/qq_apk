package com.tencent.mobileqq.location.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import com.tencent.theme.SkinnableBitmapDrawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"MAX_SHOWN_AVATAR_COUNT", "", "TAG", "", "getHalfAlphaDrawableList", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "d", "qq-location-impl_release"}, k=2, mv={1, 1, 16})
public final class HeadSetViewKt
{
  @NotNull
  public static final Drawable a(@NotNull Context paramContext, @NotNull Drawable paramDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramDrawable, "d");
    boolean bool = paramDrawable instanceof SkinnableBitmapDrawable;
    if ((!bool) && (!(paramDrawable instanceof BitmapDrawable))) {
      return paramDrawable;
    }
    Object localObject = (Bitmap)null;
    if (bool) {
      localObject = ((SkinnableBitmapDrawable)paramDrawable).getBitmap();
    } else if ((paramDrawable instanceof BitmapDrawable)) {
      localObject = ((BitmapDrawable)paramDrawable).getBitmap();
    }
    Bitmap localBitmap = Bitmap.createBitmap((Bitmap)localObject);
    Resources localResources = paramContext.getResources();
    if (localResources != null)
    {
      if ((localObject != null) && (localBitmap == null))
      {
        paramContext = (Context)localObject;
      }
      else
      {
        paramContext = localBitmap;
        if (localObject == null)
        {
          paramContext = localBitmap;
          if (localBitmap == null) {
            return paramDrawable;
          }
        }
      }
      paramDrawable = new BitmapDrawable(localResources, (Bitmap)localObject);
      localObject = new BitmapDrawable(localResources, paramContext);
      ((BitmapDrawable)localObject).setAlpha(127);
      paramContext = new StateListDrawable();
      localObject = (Drawable)localObject;
      paramContext.addState(new int[] { 16842919, 16842910 }, (Drawable)localObject);
      paramDrawable = (Drawable)paramDrawable;
      paramContext.addState(new int[] { 16842908 }, paramDrawable);
      paramContext.addState(new int[0], paramDrawable);
      return (Drawable)paramContext;
    }
    return paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.HeadSetViewKt
 * JD-Core Version:    0.7.0.1
 */