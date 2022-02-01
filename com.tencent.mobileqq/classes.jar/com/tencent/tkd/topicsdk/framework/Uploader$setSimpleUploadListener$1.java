package com.tencent.tkd.topicsdk.framework;

import com.tencent.tkd.topicsdk.interfaces.ISimpleUploadListener;
import com.tencent.tkd.topicsdk.interfaces.IUploadListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/tkd/topicsdk/framework/Uploader$setSimpleUploadListener$1", "Lcom/tencent/tkd/topicsdk/interfaces/IUploadListener;", "onCancel", "", "onFailed", "errMsg", "", "onPauseFailed", "onPauseSuccess", "onProgress", "progress", "", "total", "onStart", "uploadKey", "onSuccess", "url", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
public final class Uploader$setSimpleUploadListener$1
  implements IUploadListener
{
  public void a(long paramLong1, long paramLong2) {}
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uploadKey");
  }
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    this.a.a(paramString);
  }
  
  public void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "errMsg");
    this.a.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.Uploader.setSimpleUploadListener.1
 * JD-Core Version:    0.7.0.1
 */