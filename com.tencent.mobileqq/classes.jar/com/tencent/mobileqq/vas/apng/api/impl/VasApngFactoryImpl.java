package com.tencent.mobileqq.vas.apng.api.impl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/apng/api/impl/VasApngFactoryImpl;", "Lcom/tencent/mobileqq/vas/apng/api/IVasApngFactory;", "()V", "doOnMainThread", "", "block", "Lkotlin/Function0;", "getApngDrawableFromUrl", "Lcom/tencent/image/URLDrawable;", "filePath", "", "urlStr", "options", "Lcom/tencent/mobileqq/vas/apng/api/ApngOptions;", "getApngURLDrawable", "Companion", "vas-impl_release"}, k=1, mv={1, 1, 16})
public final class VasApngFactoryImpl
  implements IVasApngFactory
{
  public static final VasApngFactoryImpl.Companion Companion = new VasApngFactoryImpl.Companion(null);
  @NotNull
  public static final String TAG = "VasApngFactory";
  
  private final void doOnMainThread(Function0<Unit> paramFunction0)
  {
    if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()))
    {
      paramFunction0.invoke();
      return;
    }
    Handler localHandler = ThreadManagerV2.getUIHandlerV2();
    Object localObject = paramFunction0;
    if (paramFunction0 != null) {
      localObject = new VasApngFactoryImpl.sam.java_lang_Runnable.0(paramFunction0);
    }
    localHandler.post((Runnable)localObject);
  }
  
  private final URLDrawable getApngDrawableFromUrl(String paramString1, String paramString2, ApngOptions paramApngOptions)
  {
    int i;
    if (((CharSequence)paramString1).length() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      return null;
    }
    String str = new File(paramString2).getName();
    try
    {
      Object localObject = paramApngOptions.a();
      ((Bundle)localObject).putInt("key_loop", paramApngOptions.a());
      ((Bundle)localObject).putIntArray("key_tagId_arr", paramApngOptions.a());
      ((Bundle)localObject).putBoolean("key_double_bitmap", true);
      ((Bundle)localObject).putString("key_name", str);
      paramString2 = new URL("vasapngdownloader", paramString1, paramString2);
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = paramApngOptions.a();
      ((URLDrawable.URLDrawableOptions)localObject).mUseApngImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject).mUseMemoryCache = paramApngOptions.a();
      ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = String.valueOf(paramApngOptions.a());
      ((URLDrawable.URLDrawableOptions)localObject).mUseUnFinishCache = paramApngOptions.c();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramApngOptions.b();
      ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramApngOptions.c();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramApngOptions.a();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramApngOptions.a();
      ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = paramApngOptions.b();
      paramString2 = URLDrawable.getDrawable(paramString2, (URLDrawable.URLDrawableOptions)localObject);
      if (QLog.isColorLevel())
      {
        paramApngOptions = new StringBuilder();
        paramApngOptions.append("getApngDrawable ApngImage ok path:");
        paramApngOptions.append(paramString1);
        paramApngOptions.append(", name=");
        paramApngOptions.append(str);
        QLog.d("VasApngFactory", 2, paramApngOptions.toString());
      }
      return paramString2;
    }
    catch (Throwable paramString2)
    {
      paramApngOptions = new StringBuilder();
      paramApngOptions.append("getApngDrawable ApngImage err:");
      paramApngOptions.append(paramString2);
      paramApngOptions.append(", path:");
      paramApngOptions.append(paramString1);
      paramApngOptions.append(", name=");
      paramApngOptions.append(str);
      QLog.e("VasApngFactory", 1, paramApngOptions.toString());
    }
    return null;
  }
  
  @Nullable
  public URLDrawable getApngURLDrawable(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "urlStr");
    return getApngURLDrawable(paramString, new ApngOptions());
  }
  
  @Nullable
  public URLDrawable getApngURLDrawable(@NotNull String paramString, @NotNull ApngOptions paramApngOptions)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "urlStr");
    Intrinsics.checkParameterIsNotNull(paramApngOptions, "options");
    String str = VasApngUtil.getCacheFilePath(paramString);
    Intrinsics.checkExpressionValueIsNotNull(str, "VasApngUtil.getCacheFilePath(urlStr)");
    return getApngURLDrawable(paramString, paramApngOptions, str);
  }
  
  @Nullable
  public URLDrawable getApngURLDrawable(@NotNull String paramString1, @NotNull ApngOptions paramApngOptions, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "urlStr");
    Intrinsics.checkParameterIsNotNull(paramApngOptions, "options");
    Intrinsics.checkParameterIsNotNull(paramString2, "filePath");
    VasApngFactoryImpl.getApngURLDrawable.listenerProxy.1 local1 = new VasApngFactoryImpl.getApngURLDrawable.listenerProxy.1(this, paramApngOptions);
    paramString1 = getApngDrawableFromUrl(paramString2, paramString1, paramApngOptions);
    if (paramString1 != null)
    {
      int i = paramString1.getStatus();
      if (i != 1)
      {
        if (QLog.isColorLevel())
        {
          paramApngOptions = new StringBuilder();
          paramApngOptions.append("UrlDrawable is not  SUCCESSED :");
          paramApngOptions.append(i);
          QLog.e("VasApngFactory", 2, paramApngOptions.toString());
        }
        paramString1.setURLDrawableListener((URLDrawable.URLDrawableListener)local1);
        if (i == 2)
        {
          paramString1.restartDownload();
          return paramString1;
        }
        if (i != 0)
        {
          paramString1.startDownload();
          return paramString1;
        }
      }
      else
      {
        local1.onLoadSuccessed(paramString1);
      }
      return paramString1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.apng.api.impl.VasApngFactoryImpl
 * JD-Core Version:    0.7.0.1
 */