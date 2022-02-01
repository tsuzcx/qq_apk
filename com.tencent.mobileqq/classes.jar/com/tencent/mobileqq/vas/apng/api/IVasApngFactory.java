package com.tencent.mobileqq.vas.apng.api;

import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/apng/api/IVasApngFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getApngURLDrawable", "Lcom/tencent/image/URLDrawable;", "urlStr", "", "options", "Lcom/tencent/mobileqq/vas/apng/api/ApngOptions;", "filePath", "vas-temp-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IVasApngFactory
  extends QRouteApi
{
  @Nullable
  public abstract URLDrawable getApngURLDrawable(@NotNull String paramString);
  
  @Nullable
  public abstract URLDrawable getApngURLDrawable(@NotNull String paramString, @NotNull ApngOptions paramApngOptions);
  
  @Nullable
  public abstract URLDrawable getApngURLDrawable(@NotNull String paramString1, @NotNull ApngOptions paramApngOptions, @NotNull String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.apng.api.IVasApngFactory
 * JD-Core Version:    0.7.0.1
 */