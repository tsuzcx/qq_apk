package com.tencent.mobileqq.kandian.biz.publisher.net;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.ugc.upload.IVideoUploadListener;
import com.tencent.mobileqq.kandian.biz.ugc.upload.RIJUgcVideoUploader;
import com.tencent.tkd.topicsdk.interfaces.BaseUploader;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/net/VideoUploadImpl;", "Lcom/tencent/tkd/topicsdk/interfaces/BaseUploader;", "()V", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "getApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "uploadKey", "", "videoUploader", "Lcom/tencent/mobileqq/kandian/biz/ugc/upload/RIJUgcVideoUploader;", "cancel", "", "pause", "resume", "resumeFromAppRestart", "upload", "videoPath", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoUploadImpl
  extends BaseUploader
{
  private final RIJUgcVideoUploader a = new RIJUgcVideoUploader(e());
  private String b = "";
  
  private final QQAppInterface e()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getRuntime();
    if (localObject != null) {
      return (QQAppInterface)localObject;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void a()
  {
    this.a.a();
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uploadKey");
    this.a.b(paramString);
  }
  
  public void b()
  {
    int i;
    if (((CharSequence)this.b).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      this.a.b(this.b);
    }
  }
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "videoPath");
    this.a.a((IVideoUploadListener)new VideoUploadImpl.upload.1(this));
    this.a.a(paramString);
  }
  
  public void c()
  {
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.net.VideoUploadImpl
 * JD-Core Version:    0.7.0.1
 */