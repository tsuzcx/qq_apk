package com.tencent.mobileqq.ecshop.utils;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.qwallet.preload.PreloadStaticApi;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/utils/QQShopPicUtil;", "", "()V", "TAG", "", "getDrawableInner", "Lcom/tencent/image/URLDrawable;", "path", "urlStr", "loadingDrawable", "Landroid/graphics/drawable/Drawable;", "failedDrawable", "picTag", "", "bundle", "Landroid/os/Bundle;", "getNativeDrawable", "filePath", "getNetDrawable", "setBgRadius", "", "layoutContent", "Landroid/view/View;", "bgRadius", "", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class QQShopPicUtil
{
  public static final QQShopPicUtil a = new QQShopPicUtil();
  
  @JvmStatic
  @Nullable
  public static final URLDrawable a(@NotNull String paramString, @Nullable Drawable paramDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "urlStr");
    paramString = a(a, null, paramString, paramDrawable, paramDrawable, new int[] { 40 }, null, 32, null);
    ApngImage.playByTag(40);
    return paramString;
  }
  
  private final URLDrawable a(String paramString1, String paramString2, Drawable paramDrawable1, Drawable paramDrawable2, int[] paramArrayOfInt, Bundle paramBundle)
  {
    String str = paramString1;
    try
    {
      if (TextUtils.isEmpty((CharSequence)paramString1)) {
        str = PreloadStaticApi.b(paramString2);
      }
      boolean bool = paramBundle.getBoolean("key_play_apng", true);
      int i = paramBundle.getInt("key_loop");
      paramBundle.putIntArray("key_tagId_arr", paramArrayOfInt);
      paramBundle.putString("key_name", paramString2);
      paramBundle.putBoolean("key_use_file_loop", true);
      paramBundle.putBoolean("key_double_bitmap", paramBundle.getBoolean("key_double_bitmap", true));
      paramString1 = new URL("vasapngdownloader", str, paramString2);
      paramArrayOfInt = URLDrawable.URLDrawableOptions.obtain();
      paramArrayOfInt.mUseApngImage = bool;
      paramArrayOfInt.mUseMemoryCache = paramBundle.getBoolean("key_use_cache", true);
      if (i > 0) {
        paramArrayOfInt.mUseMemoryCache = false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(bool);
      localStringBuilder.append(',');
      localStringBuilder.append(i);
      paramArrayOfInt.mMemoryCacheKeySuffix = localStringBuilder.toString();
      paramArrayOfInt.mLoadingDrawable = paramDrawable1;
      paramArrayOfInt.mFailedDrawable = paramDrawable2;
      paramArrayOfInt.mExtraInfo = paramBundle;
      paramString1 = URLDrawable.getDrawable(paramString1, paramArrayOfInt);
      if (QLog.isColorLevel())
      {
        paramDrawable1 = new StringBuilder();
        paramDrawable1.append("getApngDrawable ApngImage ok path:");
        paramDrawable1.append(str);
        paramDrawable1.append(", urlStr=");
        paramDrawable1.append(paramString2);
        QLog.d("QQShopPicUtil", 2, paramDrawable1.toString());
      }
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      label250:
      break label250;
    }
    return null;
  }
  
  public final void a(@NotNull View paramView, float paramFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "layoutContent");
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramView.setOutlineProvider((ViewOutlineProvider)new QQShopPicUtil.setBgRadius.1(paramFloat));
      paramView.setClipToOutline(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.utils.QQShopPicUtil
 * JD-Core Version:    0.7.0.1
 */