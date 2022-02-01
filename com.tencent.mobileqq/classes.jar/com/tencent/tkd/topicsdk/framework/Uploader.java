package com.tencent.tkd.topicsdk.framework;

import com.tencent.tkd.topicsdk.interfaces.BaseUploader;
import com.tencent.tkd.topicsdk.interfaces.ISimpleUploadListener;
import com.tencent.tkd.topicsdk.interfaces.IUploadListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/Uploader;", "", "path", "", "uploaderImpl", "Lcom/tencent/tkd/topicsdk/interfaces/BaseUploader;", "(Ljava/lang/String;Lcom/tencent/tkd/topicsdk/interfaces/BaseUploader;)V", "getPath", "()Ljava/lang/String;", "cancel", "", "pause", "resume", "resumeFromAppRestart", "uploadKey", "setSimpleUploadListener", "uploadListener", "Lcom/tencent/tkd/topicsdk/interfaces/ISimpleUploadListener;", "setUploadListener", "Lcom/tencent/tkd/topicsdk/interfaces/IUploadListener;", "upload", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
public final class Uploader
{
  private final BaseUploader jdField_a_of_type_ComTencentTkdTopicsdkInterfacesBaseUploader;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  
  public Uploader(@NotNull String paramString, @NotNull BaseUploader paramBaseUploader)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesBaseUploader = paramBaseUploader;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesBaseUploader.b(this.jdField_a_of_type_JavaLangString);
  }
  
  public final void a(@NotNull ISimpleUploadListener paramISimpleUploadListener)
  {
    Intrinsics.checkParameterIsNotNull(paramISimpleUploadListener, "uploadListener");
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesBaseUploader.a((IUploadListener)new Uploader.setSimpleUploadListener.1(paramISimpleUploadListener));
  }
  
  public final void a(@NotNull IUploadListener paramIUploadListener)
  {
    Intrinsics.checkParameterIsNotNull(paramIUploadListener, "uploadListener");
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesBaseUploader.a(paramIUploadListener);
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uploadKey");
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesBaseUploader.a(paramString);
  }
  
  public final void b()
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesBaseUploader.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.Uploader
 * JD-Core Version:    0.7.0.1
 */