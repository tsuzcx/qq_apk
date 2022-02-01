package com.tencent.mobileqq.kandian.biz.publisher.impls;

import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.IUploadVideoStatusCallback;
import com.tencent.tkd.topicsdk.interfaces.IPublishManager.IPublishStatusListener;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/publisher/impls/PublishManagerImpl$uploadVideoStatusCallback$2$1", "Lcom/tencent/mobileqq/kandian/biz/ugc/api/IRIJUgcVideoPublishService$IUploadVideoStatusCallback;", "onFailedStatus", "", "onPauseStatus", "onProgress", "progress", "", "speed", "", "uploadedSize", "", "fileSize", "onUploadSuccessStatus", "onUploadVideoCoverSuccessStatus", "coverUrl", "onUploadingStatus", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PublishManagerImpl$uploadVideoStatusCallback$2$1
  implements IRIJUgcVideoPublishService.IUploadVideoStatusCallback
{
  public void a()
  {
    Iterator localIterator = PublishManagerImpl.a(this.a.this$0).iterator();
    while (localIterator.hasNext()) {
      ((IPublishManager.IPublishStatusListener)localIterator.next()).c();
    }
    PublishManagerImpl.a(this.a.this$0).clear();
  }
  
  public void a(int paramInt, @NotNull String paramString, long paramLong1, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "speed");
    Iterator localIterator = PublishManagerImpl.a(this.a.this$0).iterator();
    while (localIterator.hasNext()) {
      ((IPublishManager.IPublishStatusListener)localIterator.next()).a(paramInt, paramString, paramLong1, paramLong2);
    }
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "coverUrl");
    Iterator localIterator = PublishManagerImpl.a(this.a.this$0).iterator();
    while (localIterator.hasNext()) {
      ((IPublishManager.IPublishStatusListener)localIterator.next()).a(paramString);
    }
  }
  
  public void b()
  {
    Iterator localIterator = PublishManagerImpl.a(this.a.this$0).iterator();
    while (localIterator.hasNext()) {
      ((IPublishManager.IPublishStatusListener)localIterator.next()).d();
    }
  }
  
  public void c()
  {
    Iterator localIterator = PublishManagerImpl.a(this.a.this$0).iterator();
    while (localIterator.hasNext()) {
      ((IPublishManager.IPublishStatusListener)localIterator.next()).a();
    }
  }
  
  public void d()
  {
    Iterator localIterator = PublishManagerImpl.a(this.a.this$0).iterator();
    while (localIterator.hasNext()) {
      ((IPublishManager.IPublishStatusListener)localIterator.next()).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.PublishManagerImpl.uploadVideoStatusCallback.2.1
 * JD-Core Version:    0.7.0.1
 */