package com.tencent.mobileqq.kandian.biz.publisher.impls;

import com.tencent.mobileqq.kandian.biz.publisher.net.ImageUploaderImpl;
import com.tencent.mobileqq.kandian.biz.publisher.net.VideoUploadImpl;
import com.tencent.tkd.topicsdk.interfaces.BaseUploader;
import com.tencent.tkd.topicsdk.interfaces.BaseUploader.UploaderType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/publisher/impls/UploaderFactory;", "Lcom/tencent/tkd/topicsdk/interfaces/BaseUploader;", "()V", "cancel", "", "getUploaderByType", "type", "Lcom/tencent/tkd/topicsdk/interfaces/BaseUploader$UploaderType;", "pause", "resume", "resumeFromAppRestart", "p0", "", "upload", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class UploaderFactory
  extends BaseUploader
{
  @NotNull
  public BaseUploader a(@NotNull BaseUploader.UploaderType paramUploaderType)
  {
    Intrinsics.checkParameterIsNotNull(paramUploaderType, "type");
    int i = UploaderFactory.WhenMappings.a[paramUploaderType.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        return (BaseUploader)new VideoUploadImpl();
      }
      throw new NoWhenBranchMatchedException();
    }
    return (BaseUploader)new ImageUploaderImpl();
  }
  
  public void a() {}
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "p0");
  }
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "p0");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.UploaderFactory
 * JD-Core Version:    0.7.0.1
 */