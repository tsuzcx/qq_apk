package com.tencent.mobileqq.vas.apng.api;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/apng/api/IVasApngFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getApngDrawable", "Lcom/tencent/mobileqq/vas/ui/APNGDrawable;", "urlStr", "", "options", "Lcom/tencent/mobileqq/vas/apng/api/ApngOptions;", "filePath", "getApngURLDrawable", "Lcom/tencent/image/URLDrawable;", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVasApngFactory
  extends QRouteApi
{
  @NotNull
  public abstract APNGDrawable getApngDrawable(@NotNull String paramString);
  
  @NotNull
  public abstract APNGDrawable getApngDrawable(@NotNull String paramString, @NotNull ApngOptions paramApngOptions);
  
  @NotNull
  public abstract APNGDrawable getApngDrawable(@NotNull String paramString1, @NotNull ApngOptions paramApngOptions, @NotNull String paramString2);
  
  @Nullable
  public abstract URLDrawable getApngURLDrawable(@NotNull String paramString);
  
  @Nullable
  public abstract URLDrawable getApngURLDrawable(@NotNull String paramString, @NotNull ApngOptions paramApngOptions);
  
  @Nullable
  public abstract URLDrawable getApngURLDrawable(@NotNull String paramString1, @NotNull ApngOptions paramApngOptions, @NotNull String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.apng.api.IVasApngFactory
 * JD-Core Version:    0.7.0.1
 */