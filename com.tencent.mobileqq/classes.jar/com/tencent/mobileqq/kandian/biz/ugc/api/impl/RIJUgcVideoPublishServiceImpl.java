package com.tencent.mobileqq.kandian.biz.ugc.api.impl;

import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.IGetAllUploadStatusVideosCallback;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.IReleaseCallback;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.IUploadVideoStatusCallback;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.IVideoPublishCallback;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.RIJUgcVideoPublishManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/ugc/api/impl/RIJUgcVideoPublishServiceImpl;", "Lcom/tencent/mobileqq/kandian/biz/ugc/api/IRIJUgcVideoPublishService;", "()V", "manager", "Lcom/tencent/mobileqq/kandian/biz/ugc/publishvideotask/RIJUgcVideoPublishManager;", "addReleaseCallback", "", "callback", "Lcom/tencent/mobileqq/kandian/biz/ugc/api/IRIJUgcVideoPublishService$IReleaseCallback;", "addToDB", "ugcVideo", "Lcom/tencent/mobileqq/kandian/biz/ugc/entity/UgcVideo;", "addVideoPublishCallback", "Lcom/tencent/mobileqq/kandian/biz/ugc/api/IRIJUgcVideoPublishService$IVideoPublishCallback;", "addVideoTask", "video", "isStart", "", "deleteFromDB", "getAllUploadStatusVideos", "columnId", "", "Lcom/tencent/mobileqq/kandian/biz/ugc/api/IRIJUgcVideoPublishService$IGetAllUploadStatusVideosCallback;", "onCreate", "appRuntime", "Lmqq/app/AppRuntime;", "onDestroy", "pauseAllVideoTask", "pauseVideoTask", "preUploadVideoTask", "Lcom/tencent/mobileqq/kandian/biz/ugc/api/IRIJUgcVideoPublishService$IUploadVideoStatusCallback;", "removeReleaseCallback", "removeVideoPublishCallback", "removeVideoTask", "updateDB", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJUgcVideoPublishServiceImpl
  implements IRIJUgcVideoPublishService
{
  private RIJUgcVideoPublishManager manager;
  
  public void addReleaseCallback(@NotNull IRIJUgcVideoPublishService.IReleaseCallback paramIReleaseCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramIReleaseCallback, "callback");
    RIJUgcVideoPublishManager localRIJUgcVideoPublishManager = this.manager;
    if (localRIJUgcVideoPublishManager != null) {
      localRIJUgcVideoPublishManager.a(paramIReleaseCallback);
    }
  }
  
  public void addToDB(@NotNull UgcVideo paramUgcVideo)
  {
    Intrinsics.checkParameterIsNotNull(paramUgcVideo, "ugcVideo");
    RIJUgcVideoPublishManager localRIJUgcVideoPublishManager = this.manager;
    if (localRIJUgcVideoPublishManager != null) {
      localRIJUgcVideoPublishManager.c(paramUgcVideo);
    }
  }
  
  public void addVideoPublishCallback(@NotNull IRIJUgcVideoPublishService.IVideoPublishCallback paramIVideoPublishCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramIVideoPublishCallback, "callback");
    RIJUgcVideoPublishManager localRIJUgcVideoPublishManager = this.manager;
    if (localRIJUgcVideoPublishManager != null) {
      localRIJUgcVideoPublishManager.a(paramIVideoPublishCallback);
    }
  }
  
  public void addVideoTask(@NotNull UgcVideo paramUgcVideo, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramUgcVideo, "video");
    RIJUgcVideoPublishManager localRIJUgcVideoPublishManager = this.manager;
    if (localRIJUgcVideoPublishManager != null) {
      localRIJUgcVideoPublishManager.a(paramUgcVideo, paramBoolean);
    }
  }
  
  public void deleteFromDB(@NotNull UgcVideo paramUgcVideo)
  {
    Intrinsics.checkParameterIsNotNull(paramUgcVideo, "ugcVideo");
    RIJUgcVideoPublishManager localRIJUgcVideoPublishManager = this.manager;
    if (localRIJUgcVideoPublishManager != null) {
      localRIJUgcVideoPublishManager.e(paramUgcVideo);
    }
  }
  
  public void getAllUploadStatusVideos(long paramLong, @NotNull IRIJUgcVideoPublishService.IGetAllUploadStatusVideosCallback paramIGetAllUploadStatusVideosCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramIGetAllUploadStatusVideosCallback, "callback");
    RIJUgcVideoPublishManager localRIJUgcVideoPublishManager = this.manager;
    if (localRIJUgcVideoPublishManager != null) {
      localRIJUgcVideoPublishManager.a(paramLong, paramIGetAllUploadStatusVideosCallback);
    }
  }
  
  public void onCreate(@NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "appRuntime");
    this.manager = RIJUgcVideoPublishManager.a(paramAppRuntime);
  }
  
  public void onDestroy() {}
  
  public void pauseAllVideoTask()
  {
    RIJUgcVideoPublishManager localRIJUgcVideoPublishManager = this.manager;
    if (localRIJUgcVideoPublishManager != null) {
      localRIJUgcVideoPublishManager.a();
    }
  }
  
  public void pauseVideoTask(@NotNull UgcVideo paramUgcVideo)
  {
    Intrinsics.checkParameterIsNotNull(paramUgcVideo, "ugcVideo");
    RIJUgcVideoPublishManager localRIJUgcVideoPublishManager = this.manager;
    if (localRIJUgcVideoPublishManager != null) {
      localRIJUgcVideoPublishManager.b(paramUgcVideo);
    }
  }
  
  public void preUploadVideoTask(@NotNull UgcVideo paramUgcVideo, boolean paramBoolean, @NotNull IRIJUgcVideoPublishService.IUploadVideoStatusCallback paramIUploadVideoStatusCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramUgcVideo, "video");
    Intrinsics.checkParameterIsNotNull(paramIUploadVideoStatusCallback, "callback");
    RIJUgcVideoPublishManager localRIJUgcVideoPublishManager = this.manager;
    if (localRIJUgcVideoPublishManager != null) {
      localRIJUgcVideoPublishManager.a(paramUgcVideo, paramBoolean, paramIUploadVideoStatusCallback);
    }
  }
  
  public void removeReleaseCallback(@NotNull IRIJUgcVideoPublishService.IReleaseCallback paramIReleaseCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramIReleaseCallback, "callback");
    RIJUgcVideoPublishManager localRIJUgcVideoPublishManager = this.manager;
    if (localRIJUgcVideoPublishManager != null) {
      localRIJUgcVideoPublishManager.b(paramIReleaseCallback);
    }
  }
  
  public void removeVideoPublishCallback(@NotNull IRIJUgcVideoPublishService.IVideoPublishCallback paramIVideoPublishCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramIVideoPublishCallback, "callback");
    RIJUgcVideoPublishManager localRIJUgcVideoPublishManager = this.manager;
    if (localRIJUgcVideoPublishManager != null) {
      localRIJUgcVideoPublishManager.b(paramIVideoPublishCallback);
    }
  }
  
  public void removeVideoTask(@NotNull UgcVideo paramUgcVideo)
  {
    Intrinsics.checkParameterIsNotNull(paramUgcVideo, "ugcVideo");
    RIJUgcVideoPublishManager localRIJUgcVideoPublishManager = this.manager;
    if (localRIJUgcVideoPublishManager != null) {
      localRIJUgcVideoPublishManager.a(paramUgcVideo);
    }
  }
  
  public void updateDB(@NotNull UgcVideo paramUgcVideo)
  {
    Intrinsics.checkParameterIsNotNull(paramUgcVideo, "ugcVideo");
    RIJUgcVideoPublishManager localRIJUgcVideoPublishManager = this.manager;
    if (localRIJUgcVideoPublishManager != null) {
      localRIJUgcVideoPublishManager.d(paramUgcVideo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.api.impl.RIJUgcVideoPublishServiceImpl
 * JD-Core Version:    0.7.0.1
 */