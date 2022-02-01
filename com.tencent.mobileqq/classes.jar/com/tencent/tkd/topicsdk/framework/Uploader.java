package com.tencent.tkd.topicsdk.framework;

import com.tencent.tkd.topicsdk.interfaces.BaseUploader;
import com.tencent.tkd.topicsdk.interfaces.IUploadListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/Uploader;", "", "filePath", "", "uploaderImpl", "Lcom/tencent/tkd/topicsdk/interfaces/BaseUploader;", "(Ljava/lang/String;Lcom/tencent/tkd/topicsdk/interfaces/BaseUploader;)V", "getFilePath", "()Ljava/lang/String;", "cancel", "", "pause", "resume", "resumeFromAppRestart", "uploadKey", "setSimpleUploadListener", "uploadListener", "Lcom/tencent/tkd/topicsdk/interfaces/ISimpleUploadListener;", "setUploadListener", "Lcom/tencent/tkd/topicsdk/interfaces/IUploadListener;", "start", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
public final class Uploader
{
  @NotNull
  private final String a;
  private final BaseUploader b;
  
  public Uploader(@NotNull String paramString, @NotNull BaseUploader paramBaseUploader)
  {
    this.a = paramString;
    this.b = paramBaseUploader;
  }
  
  public final void a()
  {
    this.b.b(this.a);
  }
  
  public final void a(@NotNull IUploadListener paramIUploadListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIUploadListener, "uploadListener");
    this.b.a(paramIUploadListener);
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uploadKey");
    this.b.a(paramString);
  }
  
  public final void b()
  {
    this.b.a();
  }
  
  public final void c()
  {
    this.b.b();
  }
  
  public final void d()
  {
    this.b.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.Uploader
 * JD-Core Version:    0.7.0.1
 */