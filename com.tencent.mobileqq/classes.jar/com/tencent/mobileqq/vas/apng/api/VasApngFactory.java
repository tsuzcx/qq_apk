package com.tencent.mobileqq.vas.apng.api;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/apng/api/VasApngFactory;", "", "()V", "PROTOCOL", "", "TAG", "TRANSPARENT", "Landroid/graphics/drawable/ColorDrawable;", "doOnMainThread", "", "block", "Lkotlin/Function0;", "getApngDrawableFromUrl", "Lcom/tencent/image/URLDrawable;", "filePath", "urlStr", "options", "Lcom/tencent/mobileqq/vas/apng/api/VasApngFactory$Options;", "getApngURLDrawable", "Options", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public final class VasApngFactory
{
  @JvmField
  @NotNull
  public static final ColorDrawable a;
  public static final VasApngFactory a;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVasApngApiVasApngFactory = new VasApngFactory();
    jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(0);
  }
  
  @JvmStatic
  @JvmOverloads
  @Nullable
  public static final URLDrawable a(@NotNull String paramString)
  {
    return a(paramString, null, null, 6, null);
  }
  
  @JvmStatic
  @JvmOverloads
  @Nullable
  public static final URLDrawable a(@NotNull String paramString, @NotNull VasApngFactory.Options paramOptions)
  {
    return a(paramString, paramOptions, null, 4, null);
  }
  
  @JvmStatic
  @JvmOverloads
  @Nullable
  public static final URLDrawable a(@NotNull String paramString1, @NotNull VasApngFactory.Options paramOptions, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "urlStr");
    Intrinsics.checkParameterIsNotNull(paramOptions, "options");
    Intrinsics.checkParameterIsNotNull(paramString2, "filePath");
    VasApngFactory.getApngURLDrawable.listenerProxy.1 local1 = new VasApngFactory.getApngURLDrawable.listenerProxy.1(paramOptions);
    paramString1 = jdField_a_of_type_ComTencentMobileqqVasApngApiVasApngFactory.a(paramString2, paramString1, paramOptions);
    if (paramString1 != null)
    {
      int i = paramString1.getStatus();
      if (i != 1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("VasApngFactory", 2, "UrlDrawable is not  SUCCESSED :" + i);
        }
        paramString1.setURLDrawableListener((URLDrawable.URLDrawableListener)local1);
        if (i == 2) {
          paramString1.restartDownload();
        }
      }
      for (;;)
      {
        return paramString1;
        if (i != 0)
        {
          paramString1.startDownload();
          continue;
          local1.onLoadSuccessed(paramString1);
        }
      }
    }
    return null;
  }
  
  private final URLDrawable a(String paramString1, String paramString2, VasApngFactory.Options paramOptions)
  {
    if (((CharSequence)paramString1).length() == 0) {}
    for (int i = 1; i != 0; i = 0) {
      return null;
    }
    String str = new File(paramString2).getName();
    try
    {
      Object localObject = paramOptions.a();
      ((Bundle)localObject).putInt("key_loop", paramOptions.a());
      ((Bundle)localObject).putIntArray("key_tagId_arr", paramOptions.a());
      ((Bundle)localObject).putBoolean("key_double_bitmap", true);
      ((Bundle)localObject).putString("key_name", str);
      paramString2 = new URL("vasapngdownloader", paramString1, paramString2);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = paramOptions.a();
      ((URLDrawable.URLDrawableOptions)localObject).mUseApngImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mUseMemoryCache = paramOptions.a();
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = String.valueOf(paramOptions.a());
      ((URLDrawable.URLDrawableOptions)localObject).mUseUnFinishCache = paramOptions.c();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramOptions.b();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramOptions.c();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramOptions.a();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramOptions.a();
      ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = paramOptions.b();
      paramString2 = URLDrawable.getDrawable(paramString2, (URLDrawable.URLDrawableOptions)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("VasApngFactory", 2, "getApngDrawable ApngImage ok path:" + paramString1 + ", name=" + str);
      }
      return paramString2;
    }
    catch (Throwable paramString2)
    {
      QLog.e("VasApngFactory", 1, "getApngDrawable ApngImage err:" + paramString2 + ", path:" + paramString1 + ", name=" + str);
    }
    return null;
  }
  
  private final void a(Function0<Unit> paramFunction0)
  {
    if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()))
    {
      paramFunction0.invoke();
      return;
    }
    Handler localHandler = ThreadManagerV2.getUIHandlerV2();
    if (paramFunction0 != null) {
      paramFunction0 = new VasApngFactory.sam.java_lang_Runnable.0(paramFunction0);
    }
    for (;;)
    {
      localHandler.post((Runnable)paramFunction0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.apng.api.VasApngFactory
 * JD-Core Version:    0.7.0.1
 */