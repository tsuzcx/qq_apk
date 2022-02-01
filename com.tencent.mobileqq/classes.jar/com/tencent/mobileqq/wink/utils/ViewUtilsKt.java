package com.tencent.mobileqq.wink.utils;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.wink.edit.log.WinkQLog;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TAG", "", "setViewByURL", "", "view", "Landroid/widget/ImageView;", "url", "width", "", "height", "defaultDrawable", "Landroid/graphics/drawable/Drawable;", "suffix", "qq-wink-impl_release"}, k=2, mv={1, 1, 16})
public final class ViewUtilsKt
{
  public static final void a(@NotNull ImageView paramImageView, @Nullable String paramString1, int paramInt1, int paramInt2, @Nullable Drawable paramDrawable, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramImageView, "view");
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    Intrinsics.checkExpressionValueIsNotNull(localURLDrawableOptions, "URLDrawable.URLDrawableOptions.obtain()");
    Drawable localDrawable = paramDrawable;
    if (paramDrawable == null) {
      localDrawable = ContextCompat.getDrawable(paramImageView.getContext(), 2131165731);
    }
    if (TextUtils.isEmpty((CharSequence)paramString1))
    {
      paramImageView.setImageDrawable(localDrawable);
      return;
    }
    try
    {
      paramString1 = new URL(paramString1);
      localURLDrawableOptions.mLoadingDrawable = localDrawable;
      localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
      localURLDrawableOptions.mUseAutoScaleParams = false;
      localURLDrawableOptions.mRequestWidth = paramInt1;
      localURLDrawableOptions.mRequestHeight = paramInt2;
      if (!TextUtils.isEmpty((CharSequence)paramString2)) {
        localURLDrawableOptions.mMemoryCacheKeySuffix = paramString2;
      }
      paramString1 = URLDrawable.getDrawable(paramString1, localURLDrawableOptions);
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "URLDrawable.getDrawable(target, options)");
      if ((paramString1.getStatus() == 2) || (paramString1.getStatus() == 3))
      {
        WinkQLog.c("DisplayUtil", "drawable restartDownload");
        paramString1.restartDownload();
      }
      paramImageView.setImageDrawable((Drawable)paramString1);
      return;
    }
    catch (MalformedURLException paramString1)
    {
      paramString1 = paramString1.getMessage();
      if (paramString1 != null) {
        WinkQLog.d("DisplayUtil", paramString1);
      }
      paramImageView.setImageDrawable(localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.utils.ViewUtilsKt
 * JD-Core Version:    0.7.0.1
 */