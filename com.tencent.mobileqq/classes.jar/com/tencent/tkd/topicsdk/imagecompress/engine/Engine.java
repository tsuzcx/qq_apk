package com.tencent.tkd.topicsdk.imagecompress.engine;

import com.tencent.tkd.topicsdk.imagecompress.InputStreamProvider;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/imagecompress/engine/Engine;", "Lcom/tencent/tkd/topicsdk/imagecompress/engine/IEngine;", "srcImg", "Lcom/tencent/tkd/topicsdk/imagecompress/InputStreamProvider;", "tagImg", "Ljava/io/File;", "focusAlpha", "", "(Lcom/tencent/tkd/topicsdk/imagecompress/InputStreamProvider;Ljava/io/File;Z)V", "compress", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class Engine
  implements IEngine
{
  private final InputStreamProvider jdField_a_of_type_ComTencentTkdTopicsdkImagecompressInputStreamProvider;
  private final File jdField_a_of_type_JavaIoFile;
  private final boolean jdField_a_of_type_Boolean;
  
  public Engine(@NotNull InputStreamProvider paramInputStreamProvider, @NotNull File paramFile, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressInputStreamProvider = paramInputStreamProvider;
    this.jdField_a_of_type_JavaIoFile = paramFile;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  @NotNull
  public File a()
  {
    if (this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressInputStreamProvider.a()) {
      return new GifEngine(this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressInputStreamProvider, this.jdField_a_of_type_JavaIoFile).a();
    }
    return new ImageEngine(this.jdField_a_of_type_ComTencentTkdTopicsdkImagecompressInputStreamProvider, this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_Boolean).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.imagecompress.engine.Engine
 * JD-Core Version:    0.7.0.1
 */