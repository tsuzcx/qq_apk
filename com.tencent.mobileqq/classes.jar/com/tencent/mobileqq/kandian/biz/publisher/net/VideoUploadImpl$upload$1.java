package com.tencent.mobileqq.kandian.biz.publisher.net;

import com.tencent.mobileqq.kandian.biz.publisher.observer.PublisherObserverController;
import com.tencent.mobileqq.kandian.biz.ugc.upload.IVideoUploadListener;
import com.tencent.tkd.topicsdk.interfaces.IUploadListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/publisher/net/VideoUploadImpl$upload$1", "Lcom/tencent/mobileqq/kandian/biz/ugc/upload/IVideoUploadListener;", "", "onCancel", "", "onFailed", "errCode", "", "errMsg", "onPause", "onProgress", "progress", "", "total", "onStart", "uploadKey", "onSuccess", "result", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoUploadImpl$upload$1
  implements IVideoUploadListener<String>
{
  public void a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    IUploadListener localIUploadListener = this.a.d();
    if (localIUploadListener != null) {
      localIUploadListener.c(paramString);
    }
    PublisherObserverController.a.b(paramInt, paramString);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    IUploadListener localIUploadListener = this.a.d();
    if (localIUploadListener != null) {
      localIUploadListener.a(paramLong1, paramLong2);
    }
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uploadKey");
    VideoUploadImpl.a(this.a, paramString);
    IUploadListener localIUploadListener = this.a.d();
    if (localIUploadListener != null) {
      localIUploadListener.a(paramString);
    }
  }
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "result");
    IUploadListener localIUploadListener = this.a.d();
    if (localIUploadListener != null) {
      localIUploadListener.b(paramString);
    }
    PublisherObserverController.a.b(0, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.net.VideoUploadImpl.upload.1
 * JD-Core Version:    0.7.0.1
 */