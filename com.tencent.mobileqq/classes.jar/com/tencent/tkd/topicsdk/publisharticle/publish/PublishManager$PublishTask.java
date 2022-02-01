package com.tencent.tkd.topicsdk.publisharticle.publish;

import com.tencent.tkd.topicsdk.TopicSDK;
import com.tencent.tkd.topicsdk.TopicSDK.Companion;
import com.tencent.tkd.topicsdk.TopicSDKConfig;
import com.tencent.tkd.topicsdk.bean.PublishArticleInfo;
import com.tencent.tkd.topicsdk.common.NetWorkStatus;
import com.tencent.tkd.topicsdk.common.NetworkUtils;
import com.tencent.tkd.topicsdk.framework.Uploader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/publisharticle/publish/PublishManager$PublishTask;", "", "articleInfo", "Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "(Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;)V", "getArticleInfo", "()Lcom/tencent/tkd/topicsdk/bean/PublishArticleInfo;", "setArticleInfo", "canUploadInMobileNet", "", "currentUploader", "Lcom/tencent/tkd/topicsdk/framework/Uploader;", "currentUploaderHasStarted", "isPause", "pauseBySwitchNet", "cancel", "", "checkUploadNetEnv", "handleChangeToMobileNet", "handleChangeToWifiNet", "isPauseState", "pause", "resume", "resumeFromAppRestart", "uploadKey", "", "setCanUploadInMobileNet", "allowed", "setCurrentUploader", "uploader", "start", "stage", "Lcom/tencent/tkd/topicsdk/publisharticle/publish/PublishStage;", "startUploadCover", "startUploadImage", "startUploadVideo", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class PublishManager$PublishTask
{
  private Uploader a;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  @NotNull
  private PublishArticleInfo f;
  
  public PublishManager$PublishTask(@NotNull PublishArticleInfo paramPublishArticleInfo)
  {
    this.f = paramPublishArticleInfo;
  }
  
  private final void a(PublishStage paramPublishStage)
  {
    if ((!this.e) && (j()))
    {
      paramPublishStage = this.a;
      if (paramPublishStage != null) {
        paramPublishStage.a();
      }
      this.c = true;
      return;
    }
    if (this.d)
    {
      PublishManager.a(PublishManager.a, paramPublishStage);
      return;
    }
    PublishManager.b(PublishManager.a, paramPublishStage);
  }
  
  private final boolean j()
  {
    return (this.b) || (NetworkUtils.a.c(TopicSDK.a.a().b().b()) != NetWorkStatus.Mobile);
  }
  
  public final void a()
  {
    this.c = false;
    a(PublishStage.PUBLISH_STAGE_UPLOAD_IMAGE);
  }
  
  public final void a(@Nullable Uploader paramUploader)
  {
    this.a = paramUploader;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uploadKey");
    this.e = false;
    if (!j()) {
      this.b = true;
    }
    Uploader localUploader = this.a;
    if (localUploader != null) {
      localUploader.a(paramString);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public final void b()
  {
    this.c = false;
    a(PublishStage.PUBLISH_STAGE_UPLOAD_COVER);
  }
  
  public final void c()
  {
    this.c = false;
    a(PublishStage.PUBLISH_STAGE_UPLOAD_VIDEO);
  }
  
  public final void d()
  {
    this.e = true;
    if (NetworkUtils.a.c(TopicSDK.a.a().b().b()) == NetWorkStatus.Mobile) {
      this.b = false;
    }
    Uploader localUploader = this.a;
    if (localUploader != null) {
      localUploader.b();
    }
  }
  
  public final boolean e()
  {
    this.e = false;
    if (!j()) {
      this.b = true;
    }
    Uploader localUploader = this.a;
    if (localUploader != null)
    {
      if (this.c)
      {
        if (localUploader != null)
        {
          localUploader.c();
          return true;
        }
      }
      else
      {
        if (localUploader != null) {
          localUploader.a();
        }
        this.c = true;
      }
      return true;
    }
    return false;
  }
  
  public final void f()
  {
    if (!this.e)
    {
      if (this.b) {
        return;
      }
      this.d = true;
      d();
    }
  }
  
  public final void g()
  {
    if ((this.e) && (this.d))
    {
      e();
      this.d = false;
    }
  }
  
  public final void h()
  {
    Uploader localUploader = this.a;
    if (localUploader != null) {
      localUploader.d();
    }
  }
  
  @NotNull
  public final PublishArticleInfo i()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.publisharticle.publish.PublishManager.PublishTask
 * JD-Core Version:    0.7.0.1
 */