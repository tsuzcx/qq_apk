package com.tencent.mobileqq.kandian.base.image.api;

import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.net.URL;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/image/api/IImageManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "cancelRequest", "", "request", "Lcom/tencent/mobileqq/kandian/base/image/ImageRequest;", "reason", "", "clean", "getBitmap", "Lcom/tencent/mobileqq/kandian/base/image/api/ICloseableBitmap;", "isLocalFileExist", "", "url", "Ljava/net/URL;", "loadImage", "uicallback", "Lcom/tencent/mobileqq/kandian/base/image/api/IBitmapCallback;", "pauseDownload", "resume", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IImageManager
  extends QRouteApi
{
  public abstract void cancelRequest(@Nullable ImageRequest paramImageRequest, @Nullable String paramString);
  
  public abstract void clean();
  
  @Nullable
  public abstract ICloseableBitmap getBitmap(@Nullable ImageRequest paramImageRequest);
  
  public abstract boolean isLocalFileExist(@Nullable URL paramURL);
  
  public abstract void loadImage(@Nullable ImageRequest paramImageRequest, @Nullable IBitmapCallback paramIBitmapCallback);
  
  public abstract void pauseDownload();
  
  public abstract void resume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.image.api.IImageManager
 * JD-Core Version:    0.7.0.1
 */