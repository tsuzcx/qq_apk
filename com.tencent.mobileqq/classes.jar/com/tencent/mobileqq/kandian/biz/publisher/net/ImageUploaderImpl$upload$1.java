package com.tencent.mobileqq.kandian.biz.publisher.net;

import com.tencent.biz.pubaccount.readinjoy.ugc.upload.IImageUploadListener;
import com.tencent.mobileqq.kandian.biz.publisher.observer.PublisherObserverController;
import com.tencent.tkd.topicsdk.interfaces.IUploadListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/publisher/net/ImageUploaderImpl$upload$1", "Lcom/tencent/biz/pubaccount/readinjoy/ugc/upload/IImageUploadListener;", "onFailed", "", "errCode", "", "errMsg", "", "onProgress", "progress", "", "total", "onSuccess", "result", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ImageUploaderImpl$upload$1
  implements IImageUploadListener
{
  public void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    IUploadListener localIUploadListener = this.a.a();
    if (localIUploadListener != null) {
      localIUploadListener.c(paramString);
    }
    PublisherObserverController.a.a(paramInt, paramString);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    IUploadListener localIUploadListener = this.a.a();
    if (localIUploadListener != null) {
      localIUploadListener.a(paramLong1, paramLong2);
    }
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "result");
    IUploadListener localIUploadListener = this.a.a();
    if (localIUploadListener != null) {
      localIUploadListener.b(paramString);
    }
    PublisherObserverController.a.a(0, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.net.ImageUploaderImpl.upload.1
 * JD-Core Version:    0.7.0.1
 */