package com.tencent.qapmsdk.common.util;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/FileUtil$MmapFile;", "", "mmapFilePath", "", "randomAccessFile", "Ljava/io/RandomAccessFile;", "byteBuffer", "Ljava/nio/MappedByteBuffer;", "(Ljava/lang/String;Ljava/io/RandomAccessFile;Ljava/nio/MappedByteBuffer;)V", "buffer", "getBuffer", "()Ljava/nio/MappedByteBuffer;", "setBuffer", "(Ljava/nio/MappedByteBuffer;)V", "file", "getFile", "()Ljava/io/RandomAccessFile;", "setFile", "(Ljava/io/RandomAccessFile;)V", "filePath", "getFilePath", "()Ljava/lang/String;", "setFilePath", "(Ljava/lang/String;)V", "common_release"}, k=1, mv={1, 1, 15})
public final class FileUtil$MmapFile
{
  @NotNull
  private MappedByteBuffer buffer;
  @NotNull
  private RandomAccessFile file;
  @NotNull
  private String filePath;
  
  public FileUtil$MmapFile(@NotNull String paramString, @NotNull RandomAccessFile paramRandomAccessFile, @NotNull MappedByteBuffer paramMappedByteBuffer)
  {
    this.filePath = paramString;
    this.file = paramRandomAccessFile;
    this.buffer = paramMappedByteBuffer;
  }
  
  @NotNull
  public final MappedByteBuffer getBuffer()
  {
    return this.buffer;
  }
  
  @NotNull
  public final RandomAccessFile getFile()
  {
    return this.file;
  }
  
  @NotNull
  public final String getFilePath()
  {
    return this.filePath;
  }
  
  public final void setBuffer(@NotNull MappedByteBuffer paramMappedByteBuffer)
  {
    Intrinsics.checkParameterIsNotNull(paramMappedByteBuffer, "<set-?>");
    this.buffer = paramMappedByteBuffer;
  }
  
  public final void setFile(@NotNull RandomAccessFile paramRandomAccessFile)
  {
    Intrinsics.checkParameterIsNotNull(paramRandomAccessFile, "<set-?>");
    this.file = paramRandomAccessFile;
  }
  
  public final void setFilePath(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.filePath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.FileUtil.MmapFile
 * JD-Core Version:    0.7.0.1
 */